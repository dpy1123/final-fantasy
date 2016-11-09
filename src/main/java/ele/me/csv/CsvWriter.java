package ele.me.csv;

import java.io.*;

/**
 * Created by dd on 16/11/4.
 */
public class CsvWriter {

    private String path;
    private String splitStr;

    private PrintWriter writer;

    /**
     *
     * @param path 保存路径
     * @param splitStr 分隔符 ,或\t
     */
    public CsvWriter(String path, String splitStr) throws FileNotFoundException {
        this.path = path;
        this.splitStr = splitStr;
        this.writer = new PrintWriter(path);
    }


    /**
     * 将array拼接成完整的str, 用comb连接
     * @param array
     * @param comb
     * @return
     */
    private String combine(Object[] array, String comb){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1)
                sb.append(comb);
        }
        return sb.toString();
    }

    public void writeHeader(String[] header) {
        writer.println(combine(header, this.splitStr));
    }

    public void writeRow(Object[] data) {
        writer.println(combine(data, this.splitStr));
    }

    public void close() {
        if (writer!=null){
            writer.close();
        }
    }
}
