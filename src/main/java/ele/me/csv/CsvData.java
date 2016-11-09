package ele.me.csv;

import ele.me.entity.CombineData;

import java.beans.IntrospectionException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by dd on 16/11/7.
 */
public class CsvData {

    public String[] getHeader(){
        Field[] fields = CombineData.class.getDeclaredFields();
        String[] headers = new String[fields.length];
        for (int i=0; i<fields.length; i++) {
            headers[i] = fields[i].getName();
        }
        return headers;
    }

    public Object[] getData() throws IllegalAccessException, InvocationTargetException, IntrospectionException {
        Field[] fields = this.getClass().getDeclaredFields();
        Object[] data = new Object[fields.length];
        for (int i=0; i<fields.length; i++) {
            if (fields[i].isAccessible()){
                data[i] = fields[i].get(this);
            } else {
                fields[i].setAccessible(true);
                data[i] = fields[i].get(this);
                fields[i].setAccessible(false);
            }
        }
        return data;
    }
}
