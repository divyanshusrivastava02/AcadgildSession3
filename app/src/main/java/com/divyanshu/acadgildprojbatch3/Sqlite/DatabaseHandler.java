package com.divyanshu.acadgildprojbatch3.Sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Divyanshu on 11-07-2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper{

    // Database Version
    private static final int DATABASE_VERSION = 1;

    //Datebase Name
    private static final String DATABASE_NAME = "contactsManager";

    private static final String TABLE_CONTACTS = "contacts";

    // Column names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_NO = "phone_number";



    public DatabaseHandler(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_CONTACTS_TABLE = "CREATE TABLE "+TABLE_CONTACTS +"("
                +KEY_ID +" INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                +KEY_PH_NO +" TEXT"+ ")";

        sqLiteDatabase.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        // DROP OLD TABLE
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" +TABLE_CONTACTS);
        onCreate(sqLiteDatabase);
    }

    void addContacts(Contacts contacts){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME,contacts.get_name());
        values.put(KEY_PH_NO,contacts.get_phone_number());
        db.insert(TABLE_CONTACTS,null,values);
        db.close();
    }



    Contacts getContact(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[]{KEY_ID,KEY_NAME,KEY_PH_NO},KEY_ID + "=?",
                new String[]{String.valueOf(id)},null,null,null,null);
        if(cursor!=null)
            cursor.moveToFirst();
        Contacts contact = new Contacts(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2));
        return contact;

    }


    public List<Contacts> getAllContacts(){
        List<Contacts> contactsList = new ArrayList<Contacts>();

        String selectQuery = "SELECT * FROM "+ TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery,null);

        if(cursor.moveToFirst()){
            do{
                Contacts contacts = new Contacts();
                contacts.set_id(Integer.parseInt(cursor.getString(0)));
                contacts.set_name(cursor.getString(1));
                contacts.set_phone_number(cursor.getString(2));
                contactsList.add(contacts);
            }while (cursor.moveToNext());
        }
        return contactsList;
    }


    public int updateContact(Contacts contact){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME,contact.get_name());
        values.put(KEY_PH_NO,contact.get_phone_number());

        return  db.update(TABLE_CONTACTS,values, KEY_ID+ " = ?",
                new String[]{String.valueOf(contact.get_id())});
    }

    public void deleteContacts(Contacts contacts){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
                new String[]{String.valueOf(contacts.get_id())});
        db.close();
    }


    public int getContactsConts(){
        String countQuery = "SELECT * FROM"+TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);
        cursor.close();
        return cursor.getCount();
    }


}
