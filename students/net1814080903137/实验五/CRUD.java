package edu.hzuapps.androidlabs.net1814080903137;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class CRUD {
    SQLiteOpenHelper dbHandler;
    SQLiteDatabase db;

    private static final String[] colums = {//将数据库的每一列取出来，组成数组，方便后续操作
            NoteDatabase.ID,
            NoteDatabase.CONTENT,
            NoteDatabase.TIME,
            NoteDatabase.MODE
    };

    public CRUD(Context context){
        dbHandler = new NoteDatabase(context);//新建notedatabase
    }
    public void open(){
        db=dbHandler.getWritableDatabase();
    }
    public void close(){
        dbHandler.close();
    }

    //把note加入到database
    public Note addNote(Note note){//将写完的东西传输到note
        ContentValues contentValues=new ContentValues();
        contentValues.put(NoteDatabase.CONTENT,note.getContent());
        contentValues.put(NoteDatabase.TIME,note.getTime());
        contentValues.put(NoteDatabase.MODE,note.getTag());
        long insertID =db.insert(NoteDatabase.TABLE_NAME,null,contentValues);
        note.setId(insertID);
        return note;
    }

//查找
    public Note getNote(long id){
        Cursor cursor =db.query(NoteDatabase.TABLE_NAME,colums,NoteDatabase.ID+"=?",
                new String[]{String.valueOf(id)},null,null,null,null);
        if(cursor!=null)cursor.moveToFirst();
        Note e=new Note(cursor.getString(1),cursor.getString(2),cursor.getInt(3));
        return e;
    }
    public List<Note> getAllNotes(){

        Cursor cursor=db.query(NoteDatabase.TABLE_NAME,colums,null,null,null,null,null);

        List<Note> notes = new ArrayList<>();
        if (cursor.getCount()>0){
            while(cursor.moveToNext()){
                Note note=new Note();
                note.setId(cursor.getLong(cursor.getColumnIndex(NoteDatabase.ID)));
                note.setContent(cursor.getString(cursor.getColumnIndex(NoteDatabase.CONTENT)));
                note.setTime(cursor.getString(cursor.getColumnIndex(NoteDatabase.TIME)));
                note.setTag(cursor.getInt(cursor.getColumnIndex(NoteDatabase.MODE)));
                notes.add(note);
            }
        }
        return notes;
    }



    //更新
    public int updateNote(Note note){
        ContentValues values=new ContentValues();
        values.put(NoteDatabase.CONTENT,note.getContent());
        values.put(NoteDatabase.TIME,note.getTime());
        values.put(NoteDatabase.MODE,note.getTag());
        return db.update(NoteDatabase.TABLE_NAME,values,
                NoteDatabase.ID+"=?",new String[]{String.valueOf(note.getId())});

    }

    //删除
    public void removeNote(Note note){
        db.delete(NoteDatabase.TABLE_NAME,NoteDatabase.ID+"="+note.getId(),null);
    }
}
