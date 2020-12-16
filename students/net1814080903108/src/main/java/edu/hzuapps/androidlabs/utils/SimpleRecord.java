package edu.hzuapps.androidlabs.utils;

import android.app.Application;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.File;
import java.lang.reflect.Method;

public class SimpleRecord {
    private SQLiteDatabase db = null;

    private String recordName = null;

    private String primaryAttribute = null;

    private String[] attributes = null;

    public SimpleRecord(String recordsName, String primaryAttribute, String[] attributes) {
        this.recordName = recordsName;
        this.primaryAttribute = primaryAttribute;
        this.attributes = attributes;
        initRecord();
    }

    private void initRecord() {
        String databasePath = ApplicationGetter.getCurApplication().getFilesDir().getAbsolutePath() + recordName + ".db";
        this.db = SQLiteDatabase.openOrCreateDatabase(databasePath, null);
        initTable();
    }

    private void initTable() {
        StringBuilder sqlBuilder = new StringBuilder("create table if not exists " + recordName + "(_id integer primary key autoincrement," + primaryAttribute + " text unique not null");
        for (String attribute : attributes) {
            if (!attribute.equals(primaryAttribute)) {
                sqlBuilder.append(",").append(attribute).append(" text");
            }
        }
        sqlBuilder.append(")");
        String sql = sqlBuilder.toString();
        db.execSQL(sql);
    }

    public boolean dropRecord() {
        close();
        String databasePath = ApplicationGetter.getCurApplication().getFilesDir().getAbsolutePath() + recordName + ".db";
        File databaseFile = new File(databasePath);
        if (databaseFile.isFile() && databaseFile.exists()) {
            return databaseFile.delete();
        }
        return false;
    }

    public void close() {
        this.db.close();
        this.db = null;
        this.primaryAttribute = null;
        this.recordName = null;
        this.attributes = null;
    }

    public boolean put(boolean overridable, String[] attributes, Object[] values) {
        int conflictAlgorithm = overridable ? SQLiteDatabase.CONFLICT_REPLACE : SQLiteDatabase.CONFLICT_IGNORE;
        boolean flag = false;
        if (attributes.length != values.length) {
            return false;
        }
        ContentValues cValue = new ContentValues();
        for (int i = 0; i < attributes.length; i++) {
            if (attributes[i].equals(primaryAttribute) && values[i] != null) {
                flag = true;
            }
            cValue.put(attributes[i], values[i].toString());
        }
        if (flag == true) {
            if (db.insertWithOnConflict(recordName, null, cValue, conflictAlgorithm) == -1) {
                flag = false;
            }
        }
        return flag;
    }

    public int remove(Object primaryKeyValue) {
        String whereClause = primaryAttribute + "=?";
        String[] whereArgs = {primaryKeyValue.toString()};
        return db.delete(recordName, whereClause, whereArgs);
    }

    public int count() {
        Cursor cursor = db.query(recordName, null, null, null, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public String[] primaryKeyValueArray() {
        Cursor cursor = db.query(recordName, new String[]{primaryAttribute}, null, null, null, null, null);
        String[] primaryKeyArray = new String[cursor.getCount()];
        if (cursor.moveToFirst()) {
            int i = 0;
            do {
                primaryKeyArray[i++] = cursor.getString(0);
            }while(cursor.moveToNext());
        }
        cursor.close();
        return primaryKeyArray;
    }

    public String getValue(Object primaryKeyValue,String attribute){
        String value = null;
        Cursor c= db.rawQuery( "select " + attribute + " from " + recordName + " where " + primaryAttribute + " = ?", new String[]{primaryKeyValue.toString()});
        if(c.moveToNext()){
            value = c.getString(c.getColumnIndex(attribute));
        }
        c.close();
        return value;
    }

    private static class ApplicationGetter{
        public static Application getCurApplication(){
            Application application = null;
            try{
                Class atClass = Class.forName("android.app.ActivityThread");
                Method currentApplicationMethod = atClass.getDeclaredMethod("currentApplication");
                currentApplicationMethod.setAccessible(true);
                application = (Application) currentApplicationMethod.invoke(null);
                Log.d("fw_create","curApp class1:"+application);
            }catch (Exception e){
                Log.d("fw_create","e:"+e.toString());
            }

            if(application != null)
                return application;
            try{
                Class atClass = Class.forName("android.app.AppGlobals");
                Method currentApplicationMethod = atClass.getDeclaredMethod("getInitialApplication");
                currentApplicationMethod.setAccessible(true);
                application = (Application) currentApplicationMethod.invoke(null);
                Log.d("fw_create","curApp class2:"+application);
            }catch (Exception e){
                Log.d("fw_create","e:"+e.toString());
            }
            return application;
        }
    }
}