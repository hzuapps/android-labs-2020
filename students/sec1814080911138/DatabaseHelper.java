package edu.hzuapps.androidlabs.Sec1814080911138;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
public class DatabaseHelper {

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

        import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String COST_MONEY = "cost_money";
    public static final String COST_DATE = "cost_date";
    public static final String COST_TITLE = "cost_title";
    public static final String ACCOUNT_COST = "account_cost";

    SQLiteDatabase mdatabaseHelper;

    public DatabaseHelper(@Nullable Context context) {
        super(context, "account_book", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists account_cost(" +  //是实现基本的增删改查
                "id integer primary key, " +
                "cost_title varchar, " +
                "cost_date varchar, " +
                "cost_money varchar)");

    }

    public void insertCost(CostBean costBean) {  //增添
        SQLiteDatabase database = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COST_TITLE, costBean.costTitle);
        cv.put(COST_DATE, costBean.costDate);
        cv.put(COST_MONEY, costBean.costMoney);
        database.insert(ACCOUNT_COST, null, cv);
    }

    public Cursor getAllCostData() {    //查询
        SQLiteDatabase database = getWritableDatabase();
        return database.query(ACCOUNT_COST, null, null, null, null, null, COST_DATE + " ASC");
    }

    public void deleteAllData() {
        SQLiteDatabase database = getWritableDatabase();
        database.delete(ACCOUNT_COST, null, null);
    }

    public void toDelete(CostBean costBean) {
        SQLiteDatabase database = getWritableDatabase();
        database.delete(ACCOUNT_COST, "COST_TITLE = ? and COST_MONEY = ? and COST_DATE = ?",
                new String[]{"" + costBean.costTitle, "" + costBean.costMoney, "" + costBean.costDate});
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
