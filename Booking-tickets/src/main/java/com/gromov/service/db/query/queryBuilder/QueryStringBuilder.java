package com.gromov.service.db.query.queryBuilder;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class QueryStringBuilder {
    public static String insert(Object query) throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        StringBuffer queryString = new StringBuffer("INSERT INTO ");
        queryString.append(query.getClass().getMethod("getTableName").invoke(query));
        queryString.append(" SET ");
        stringMaker(queryString,query);
        return String.valueOf(queryString);
    }
    public static String deleteByID(Class myClass, int id) throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        StringBuffer queryString = new StringBuffer("DELETE FROM ");
        queryString.append(myClass.getMethod("getTableName").invoke(null));
        queryString.append(" WHERE ID= ");
        queryString.append(id);
        return String.valueOf(queryString);
    }
    public static String updateByID(Object query, int id) throws IllegalAccessException,
            InvocationTargetException, NoSuchMethodException {
        StringBuffer queryString = new StringBuffer("UPDATE ");
        queryString.append(query.getClass().getMethod("getTableName").invoke(query));
        queryString.append(" SET ");
        stringMaker(queryString,query);
        queryString.append(" WHERE ID = ");
        queryString.append(id);
        return String.valueOf(queryString);
    }
    public static String selectAll(Class myClass) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException {
        StringBuffer queryString = new StringBuffer();
        queryString.append("SELECT * FROM ");
        queryString.append(myClass.getMethod("getTableName").invoke(null));
        return String.valueOf(queryString);
    }
    public static String selectBy(Class myClass, Field key, String value) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException {
        StringBuffer queryString = new StringBuffer();
        queryString.append("SELECT * FROM ");
        queryString.append(myClass.getMethod("getTableName").invoke(null));
        queryString.append(" WHERE ");
        queryString.append(key.getName());
        queryString.append(" = ");
        if(key.getType().isPrimitive()) {
            queryString.append(value);
        }
        else {
            queryString.append("'");
            queryString.append(value);
            queryString.append("'");
        }
        return String.valueOf(queryString);
    }

    private static void stringMaker(StringBuffer str, Object table) throws IllegalAccessException {
        for(Field x : table.getClass().getDeclaredFields()) {
            x.setAccessible(true);
            if (x.getName() != "id") {
                if (x.getType() != String.class) {
                    str.append(x.getName() + " = " +
                            x.get(table) + ", ");
                } else {
                    str.append(x.getName() + " = '" + x.get(table) + "', ");
                }
            }
        }
        str.delete(str.length()-2,str.length());
    }
}
