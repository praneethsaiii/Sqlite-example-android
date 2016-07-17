package com.example.praneethsai.sqlite1;

/**
 * Created by praneethsai on 04-07-2016.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DatabaseHandler extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "vit1";
    public static final String TABLE_NAME = "student1";
    public static final String COL_1 = "ROLLNO";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "BRANCH";
    public static final String COL_4 = "MARKS";
    public DatabaseHandler(Context context) {
// TODO Auto-generated constructor stub
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
// TODO Auto-generated method stub
        String query = "CREATE TABLE " + TABLE_NAME + "(" + COL_1 + " INTEGER PRIMARY KEY," + COL_2 + " TEXT,"
                + COL_3 + " TEXT," + COL_4 + " INTEGER "+ ")";
        db.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
// TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(int Rollno,String Name, String Branch, int
            Marks)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_1, Rollno);
        cv.put(COL_2, Name);
        cv.put(COL_3,Branch);
        cv.put(COL_4, Marks);
        long result = db.insert(TABLE_NAME, null, cv);
        if(result == -1)
            return false;
        else
            return true;
    }
    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ TABLE_NAME, null);
        return res;
    }
    public boolean updateData(int Rollno,String Name, String Branch, int
            Marks)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_1, Rollno);
        cv.put(COL_2, Name);
        cv.put(COL_3,Branch);
        cv.put(COL_4, Marks);
        db.update(TABLE_NAME, cv, COL_1+"=?", new
                String[]{String.valueOf(Rollno)});
        return true;
    }
    public int deleteData(int Rollno)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, COL_1+"=?", new
                String[]{String.valueOf(Rollno)});
    }
}