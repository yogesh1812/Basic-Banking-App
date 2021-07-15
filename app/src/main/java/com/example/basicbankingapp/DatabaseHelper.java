package com.example.basicbankingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private String TABLE_NAME = "user_table";
    private String TABLE_NAME1 = "transfers_table";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "User.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (PHONENUMBER INTEGER PRIMARY KEY ,NAME TEXT,BALANCE DECIMAL,EMAIL VARCHAR,ACCOUNT_NO VARCHAR,IFSC_CODE VARCHAR)");
        db.execSQL("create table " + TABLE_NAME1 +" (TRANSACTIONID INTEGER PRIMARY KEY AUTOINCREMENT,DATE TEXT,FROMNAME TEXT,TONAME TEXT,AMOUNT DECIMAL,STATUS TEXT)");
        db.execSQL("insert into user_table values(2564179896,'Manish',9472.00,'manish102@gmail.com','XXXXXXXXXXXX1234','ABC09876543')");
        db.execSQL("insert into user_table values(2345678901,'Sunil',582.67,'sunil03@gmail.com','XXXXXXXXXXXX2341','BCA98765432')");
        db.execSQL("insert into user_table values(3456789012,'Amit',1359.56,'amit1204@gmail.com','XXXXXXXXXXXX3412','CAB87654321')");
        db.execSQL("insert into user_table values(4567890123,'Vikas',1500.01,'vikasg123@gmail.com','XXXXXXXXXXXX4123','ABC76543210')");
        db.execSQL("insert into user_table values(5678901234,'Benson',2603.48,'benson345@gmail.com','XXXXXXXXXXXX2345','BCA65432109')");
        db.execSQL("insert into user_table values(6789012345,'Akansha',945.16,'akansha127@gmail.com','XXXXXXXXXXXX3452','CAB54321098')");
        db.execSQL("insert into user_table values(7890123456,'Abhimanyu',5936.00,'abhichauhan448@gmail.com','XXXXXXXXXXXX4523','ABC43210987')");
        db.execSQL("insert into user_table values(8901234567,'Nishant',857.22,'nishant179@gmail.com','XXXXXXXXXXXX5234','BCA32109876')");
        db.execSQL("insert into user_table values(9012345678,'Vamshi',4398.46,'vamshi10@gmail.com','XXXXXXXXXXXX3456','CAB21098765')");
        db.execSQL("insert into user_table values(1234567809,'Anjali',273.90,'anjali401@gmail.com','XXXXXXXXXXXX4563','ABC10987654')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
        onCreate(db);
    }

    public Cursor readalldata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table", null);
        return cursor;
    }

    public Cursor readparticulardata(String phonenumber){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table where phonenumber = " +phonenumber, null);
        return cursor;
    }

    public Cursor readselectuserdata(String phonenumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table except select * from user_table where phonenumber = " +phonenumber, null);
        return cursor;
    }

    public void updateAmount(String phonenumber, String amount){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update user_table set balance = " + amount + " where phonenumber = " +phonenumber);
    }

    public Cursor readtransferdata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from transfers_table", null);
        return cursor;
    }

    public boolean insertTransferData(String date,String from_name, String to_name, String amount, String status){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("DATE", date);
        contentValues.put("FROMNAME", from_name);
        contentValues.put("TONAME", to_name);
        contentValues.put("AMOUNT", amount);
        contentValues.put("STATUS", status);
        Long result = db.insert(TABLE_NAME1, null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }
}

