package ele.me;

import ele.me.dao.CombineDataRepository;
import ele.me.csv.CsvData;
import ele.me.csv.CsvWriter;
import ele.me.dao.DbAccess;
import ele.me.dao.PredictDataRepository;
import ele.me.entity.*;
import ele.me.service.Eval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import weka.classifiers.Classifier;
import weka.core.*;
import weka.core.converters.CSVLoader;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.NumericToNominal;

import java.beans.IntrospectionException;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class App implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Autowired
    private DbAccess dbAccess;
    @Autowired
    private CombineDataRepository combineDataRepository;
    @Autowired
    private PredictDataRepository predictDataRepository;

    @Autowired
    private Eval eval;


    @Override
    public void run(String... strings) throws Exception {
//        List<CombineData> trainingSet = getCombineData(113, 126);
//        writeToFile(trainingSet, "/Users/dd/Downloads/E_data/training.csv", "\t");
//
//        List<CombineData> testSet = getCombineData(127, 140);
//        writeToFile(testSet, "/Users/dd/Downloads/E_data/test.csv", "\t");
//
//        for (CombineData combineData : testSet) {
//            //save to db 作为realdata
//            combineDataRepository.save(combineData);
//        }

        Classifier cls4Buy = (Classifier) SerializationHelper.read("/Users/dd/Downloads/E_data/bayes4buy14day2.model");
        Classifier cls4Click = (Classifier) SerializationHelper.read("/Users/dd/Downloads/E_data/bayes4click14day2.model");

        CSVLoader loader = new CSVLoader();
        loader.setFieldSeparator("\t");
        loader.setMissingValue("NULL");
        loader.setSource(new File("/Users/dd/Downloads/E_data/test.csv"));
        Instances instances = loader.getDataSet();

        NumericToNominal filter = new NumericToNominal();
//        filter.setOptions(new String[]{"-R", String.valueOf(instances.attribute("hoursInDay").index()+1)});
        filter.setOptions(new String[]{"-R", "6,21,28,41"});

        filter.setInputFormat(instances);
        instances = Filter.useFilter(instances, filter);

        instances.deleteAttributeAt(instances.numAttributes()-1);//移除最后2列 is_click 和 is_buy
        instances.deleteAttributeAt(instances.numAttributes()-1);
        List classAttr = new ArrayList();
        classAttr.add("0");
        classAttr.add("1");

        Instances resultClick = new Instances(instances);
        resultClick.insertAttributeAt(new Attribute("is_click", classAttr), resultClick.numAttributes());
        resultClick.setClassIndex(resultClick.numAttributes()-1);

        for (int i = 0; i < resultClick.numInstances(); i++) {
            try {
                double clsLabel = cls4Click.classifyInstance(resultClick.instance(i));
                resultClick.instance(i).setClassValue(clsLabel);
            } catch (Exception e) {
                System.out.println(resultClick.instance(i).value(resultClick.attribute("logId")));
                e.printStackTrace();
            }
        }

        Instances resultBuy = new Instances(instances);
        resultBuy.insertAttributeAt(new Attribute("is_buy", classAttr), resultBuy.numAttributes());
        resultBuy.setClassIndex(resultBuy.numAttributes()-1);

        for (int i = 0; i < resultBuy.numInstances(); i++) {
            try {
                double clsLabel = cls4Buy.classifyInstance(resultBuy.instance(i));
                resultBuy.instance(i).setClassValue(clsLabel);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < resultClick.numInstances(); i++) {
            Instance click = resultClick.instance(i);
            Instance buy = resultBuy.instance(i);
            String logId = click.stringValue(resultClick.attribute("logId"));
            String userId = click.stringValue(resultClick.attribute("userId"));
            boolean isClick = click.classValue()>0.5;
            boolean isBuy = buy.classValue()>0.5;
            predictDataRepository.save(new PredictData(logId, userId, isClick, isBuy));
        }

        List<String> users = dbAccess.getPredUserIds();
        System.out.println(eval.eval(users));
    }

    private List<CombineData> getCombineData(int dayNoStart, int dayNoEnd) {
        List<CombineData> result = new ArrayList<CombineData>();
        List<HistEnv> histEnvList = dbAccess.loadHistEnv(dayNoStart, dayNoEnd);
        for (HistEnv histEnv : histEnvList) {
            HistLog histLog = dbAccess.getHistLog(histEnv.getListId());
            Restaurant restaurant = dbAccess.getRestaurant(histLog.getRestaurantId());
            CombineData combineData = new CombineData(histLog, histEnv, restaurant);
            result.add(combineData);
        }
        return result;
    }

    private void writeToFile(List<? extends CsvData> dataList, String filePath, String csvSplitStr)
            throws FileNotFoundException, IllegalAccessException, InvocationTargetException, IntrospectionException {
        CsvWriter csvWriter = new CsvWriter(filePath, csvSplitStr);
        boolean headerWrite = false;
        for (CsvData data : dataList) {
            if (!headerWrite){
                csvWriter.writeHeader(data.getHeader());
                headerWrite = true;
            }
            csvWriter.writeRow(data.getData());
        }
        csvWriter.close();
    }

}
