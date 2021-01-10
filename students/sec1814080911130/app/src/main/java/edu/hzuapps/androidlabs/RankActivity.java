package edu.hzuapps.androidlabs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class RankActivity extends Activity {
	ListView lvRank = null;
	PlaneDBHelper dbHelper;
	List<Map<String,String>> listRank = new ArrayList<Map<String,String>>();
	SimpleAdapter adapter = null;
	Intent intent;
	EditText edtName;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rank);
		lvRank = (ListView) findViewById(R.id.lv_rank);
		dbHelper = new PlaneDBHelper(this, "FinalPlaneDB", null, 1);
		getAllRank();//获取所有人的记录
		rank();//对记录按从小到大的顺序排序

		adapter = new SimpleAdapter(this, listRank, R.layout.ranklist, new String[]{"enemyDestroyedNum","name","score"}, new int[]{R.id.txt_id,R.id.txt_name,R.id.txt_score});
		Log.i("wy", "适配器初始化成功");
		lvRank.setAdapter(adapter);
		edtName = new EditText(this);
		intent = getIntent();
		if(intent.getIntExtra("score", -1) != -1){
			int score = intent.getIntExtra("score", 0);
			new AlertDialog.Builder(this).setTitle("记录")
					.setView(edtName)
					.setIcon(android.R.drawable.ic_dialog_info)
					.setPositiveButton("确定", new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							insert(edtName.getText().toString(), intent.getIntExtra("score", 0)+"");
							Log.i("wy", "插入成功");
							listRank = getAllRank();
							rank();
							adapter.notifyDataSetChanged();
						}
					})
					.setNegativeButton("取消", new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							insert("unknown", intent.getIntExtra("score", 0)+"");
							Log.i("wy", "插入成功");
							listRank = getAllRank();
							rank();
							adapter.notifyDataSetChanged();
						}
					}).show();
		}
	}

	private List<Map<String,String>> getAllRank(){
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Cursor cursor = db.query(dbHelper.TABLE, null, null, null, null, null, null);
		listRank.clear();
		if(cursor != null){
			Log.i("wy", "记录:"+cursor.getCount());
			if(cursor.moveToFirst()){
				while(!cursor.isAfterLast()){
					Map<String, String> map = new HashMap<String, String>();
					map.put("_id", cursor.getInt(cursor.getColumnIndex(dbHelper.ID))+"");
					map.put("name", cursor.getString(cursor.getColumnIndex(dbHelper.NAME)));
					map.put("score", cursor.getInt(cursor.getColumnIndex(dbHelper.SCORE))+"");
					listRank.add(map);
					cursor.moveToNext();
				}
			}
		}else{
			Log.i("wy", "没有记录");
		}
		return listRank;
	}

	private void insert(String name,String score){
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("name", name);
		values.put("score", score);
		db.insert(dbHelper.TABLE, null, values);
	}

	private void rank(){
		for(int i = 0;i < listRank.size();i++){
			for(int j = i;j < listRank.size();j++){
				if(Integer.parseInt(listRank.get(i).get("score")) < Integer.parseInt(listRank.get(j).get("score"))){
					Map<String,String> temp = listRank.get(i);
					listRank.set(i, listRank.get(j));
					listRank.set(j, temp);
				}
			}
		}
		for(int i = 0; i < listRank.size(); i++){
			listRank.get(i).put("enemyDestroyedNum", (i+1)+"");//设定名次
		}
	}

}
