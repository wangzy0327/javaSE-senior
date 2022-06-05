package com.atguigu.annotation.practice.operation;

import com.atguigu.annotation.practice.annotation.Column;
import com.atguigu.annotation.practice.annotation.Table;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Operate {
    private static String getValue(Class cl, Object obj, String columnName) {
        StringBuilder sb = new StringBuilder("get");
        sb.append(columnName.substring(0, 1).toUpperCase() + columnName.substring(1));
        //通过反射调用方法取值
        String res = "";
        try {
            Method method = cl.getMethod(sb.toString());
            res = method.invoke(obj, null).toString();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            return res;
        }
    }

    public static String select(Object obj) {
        StringBuilder sb = new StringBuilder("select * from ");
        //1.取出操作数据库表的实例的 类型
        Class cl = obj.getClass();
        //2.取出pojo类的注解
        Table table = (Table) cl.getAnnotation(Table.class);
        if (table != null) {
            //取出pojo类对应的数据库表名 即 注解的value
            String tableName = table.value();
            sb.append(tableName + " ");
            sb.append(" where 1 = 1 ");
            //取出属性值
            Field[] fields = cl.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)) {
                    //拿到每个field的值
                    Column column = field.getAnnotation(Column.class);
                    String columnName = column.value();
                    String value = getValue(cl, obj, field.getName());
                    if (value == null || value.equals("") || value.equals("0") || value.equals("0.0"))
                        continue;
                    Class<?> type = field.getType();
                    if (type.getName().equals("java.lang.String")) {
                        String[] values = value.split(",");
                        if (values.length > 1) {
                            sb.append(" and " + columnName + " in ( ");
                            for (String val : values)
                                sb.append("'" + val + "' ,");
                            sb.deleteCharAt(sb.length() - 1);
                            sb.append(" )");
                        } else {
                            sb.append(" and  " + columnName + " = '" + value + "'");
                        }
                    } else {
                        String[] values = value.split(",");
                        if (values.length > 1) {
                            sb.append(" and " + columnName + " in ( ");
                            for (String val : values)
                                sb.append("" + val + " ,");
                            sb.deleteCharAt(sb.length() - 1);
                            sb.append(" )");
                        } else {
                            sb.append(" and  " + columnName + " = " + value);
                        }
                    }
                }
            }
        }
        return sb.toString();
    }
}
