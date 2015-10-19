package example.com.project343;

/**
 * Created by isahbellodoro on 10/18/15.
 *

 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.Tag;
import android.util.Log;

import java.sql.SQLData;
import java.util.ArrayList;
import java.util.List;

public class DatabaseOperations extends SQLiteOpenHelper {
    public static final int database_version =1;
    public String CREATE_QUERY = "CREATE TABLE"+
            TableData.TableInfo.TABLE_NAME+"("+
            TableData.TableInfo.USER_NAME+"TEXT,"+
            TableData.TableInfo.USER_PASS+"TEXT,"+ 
            TableData.TableInfo.USER_FNAME+"TEXT,"+ 
            TableData.TableInfo.USER_GENDER+"TEXT,"+ 
            TableData.TableInfo.USER_HUBBY+"TEXT );";
    
    public DatabaseOperations(Context context){
        super(context, TableData.TableInfo.DATABASE_NAME, null, database_version);
        Log.d("Database operations","Database created");

    }


    @Override
    public void onCreate(SQLiteDatabase sdb){

    sdb.execSQL(CREATE_QUERY);
        Log.d("Database operations", "Table created");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_FRIEND_TABLE = "DROP TABLE IF EXITS Friend";
        sdb.execSQL(DROP_FRIEND_TABLE);
        onCreate(sdb);

    }

    public void putInformation(DatabaseOperations dop, String name, String pass, String fname, String gender, String hubby)
    {
      SQLiteDatabase SQ = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TableData.TableInfo.USER_NAME,name);
        cv.put(TableData.TableInfo.USER_PASS, pass);
        cv.put(TableData.TableInfo.USER_FNAME,fname);
        cv.put(TableData.TableInfo.USER_GENDER,gender);
        cv.put(TableData.TableInfo.USER_HUBBY,hubby);

        long k = SQ.insert(TableData.TableInfo.TABLE_NAME,null,cv);
        Log.d("Database operations", "one raw inserted");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String DROP_FRIEND_TABLE ="DROP TABLE IF EXITS " + TableData.TableInfo;
        sdb.execSQL(DROP_FRIEND_TABLE);
        Log.i(TAG, "Upgrade database from" + oldVersion + "to" + newVersion);
        onCreate(sbd);
    }

    }




    public Cursor getInformation(DatabaseOperations dop)
    {
        SQLiteDatabase SQ = dop.getReadableDatabase();
        String[] coloumns = {TableData.TableInfo.USER_HUBBY,
                TableData.TableInfo.USER_GENDER,
                TableData.TableInfo.USER_FNAME,
                TableData.TableInfo.USER_PASS,
                TableData.TableInfo.USER_NAME,
                TableData.TableInfo.USER_NAME};
        Cursor CR = SQ.query(TableData.TableInfo.TABLE_NAME, coloumns, null, null, null, null,null);
    if (CR !=null) {
        CR.moveToFirst();
    }
    while (!CR.isAfterLast()){
        TableData.add(CR.getLong(0))+""+
                CR.getString(1)+""+
                CR.getString(2));
        CR.moveToNext();
    }
        SQLiteDatabase.close();
        return TableData;

}


