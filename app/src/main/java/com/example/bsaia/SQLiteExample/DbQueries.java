package com.example.bsaia.SQLiteExample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

//real data databse , mongo db etc iosko alg class manaty hain industry ma jb hm jaengee
//same queries jo bar bar use hone ioska fun bna dete hain
//meaning k ek query ka functon bna lete hain,
//so jo bhi db ka kam kreneg wo seperate class m hoti , bcz if kl ko
//we wanna change the databse then we can do easily , without conflict
//and in every mobile we have sqlite ,(low lite data base)
public class DbQueries  extends SQLiteOpenHelper {
    //contructor
    public DbQueries(Context context)
    {
        super(context,"ContactsDB",null,1);
        //version 1 agr phle hi hoga t again create ni hoga
        //agr hm verson 2 likhe then again chalega , but 2 likhne sy data ur jaega
        //purana data ur jata
        Log.d("TAG","Database has been created.");

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query="CREATE TABLE CONTACT("+//start query
                "_id INTEGER PRIMARY KEY AUTOINCREMENT,"+//column 1
                "firstName TEXT,"+//col 2
                "secondName TEXT,"+//col 3
                "phoneNumber TEXT,"+//col 4
                "emailAddress TEXT,"+//col 5
                "homeAddress TEXT)";//col 6
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    //for version 2
    }
    public void Insert(HashMap<String,String> contact)
    {
        SQLiteDatabase db=getWritableDatabase();//get permission for write into Database
        ContentValues contentValues=new ContentValues();//for key value pair, we can use koi bhi

        contentValues.put("_id",contact.get("_id"));//ye id auto bn jati ha , halank we dont have id in contact object
        //sequence same hona chaye lazmi
        contentValues.put("firstName",contact.get("firstName"));
        contentValues.put("secondName",contact.get("secondName"));
        contentValues.put("phoneNumber",contact.get("phoneNumber"));
        contentValues.put("emailAddress",contact.get("emailAddress"));
        contentValues.put("homeAddress",contact.get("homeAddress"));

        //ye data base me dal dega
        long i=db.insert("CONTACT",null,contentValues);
        //ye fun (db.insert) ek value return krta if positiv hogi means k chl gaya
        //neg hoge means nhi chala
        if(i!=-1)
        {
            Log.d("TAG","New Contact Added.");
        }
        else{
            Log.d("TAG","Failed to add new Contact.");
        }
    }


    //ye function sab contact ko get krega
    public  ArrayList<HashMap<String,String>> getAllContacts()
    {
        SQLiteDatabase db=getReadableDatabase();
        ArrayList<HashMap<String,String>> allContacts= new ArrayList<HashMap<String,String>>();
        String Query ="SELECT * FROM CONTACT";
        Cursor cursor =db.rawQuery(Query,null);

        if(cursor.moveToFirst())
        {
            do{
                HashMap<String,String> contact=new HashMap<>();
                contact.put("_id",cursor.getString(0));
                contact.put("firstName",cursor.getString(1));
                contact.put("secondName",cursor.getString(2));
                contact.put("phoneNumber",cursor.getString(3));
                contact.put("emailAddress",cursor.getString(4));
                contact.put("homeAddress",cursor.getString(5));

                allContacts.add(contact);
            }while (cursor.moveToNext());
        }
        return allContacts;
    }

    //function jo bs ek record fect krega , means search krna ha
    public HashMap<String,String> getSingleRecord(String id)
    {
        SQLiteDatabase db=getReadableDatabase();
        HashMap<String,String> singleRecord=new HashMap<>();
        String Query="SELECT * FROM CONTACT WHERE _id="+id;
        //Cursor ,data base sy read krta ha ye
        Cursor cursor=db.rawQuery(Query,null);
        if(cursor.moveToFirst())
        {
            singleRecord.put("_id",cursor.getString(0));
            singleRecord.put("firstName",cursor.getString(1));
            singleRecord.put("secondName",cursor.getString(2));
            singleRecord.put("phoneNumber",cursor.getString(3));
            singleRecord.put("emailAddress",cursor.getString(4));
            singleRecord.put("homeAddress",cursor.getString(5));
        }
        return singleRecord;
    }


    public void deleteContact(String id)
    {
        SQLiteDatabase db=getWritableDatabase();
        String Query="DELETE FROM CONTACT WHERE _id=" + id;
        db.execSQL(Query);
    }
    public long updateContact(HashMap<String,String> contact , String id)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("firstName", contact.get("firstName"));
        contentValues.put("secondName", contact.get("secondName"));
        contentValues.put("phoneNumber", contact.get("phoneNumber"));
        contentValues.put("emailAddress", contact.get("emailAddress"));
        contentValues.put("homeAddress", contact.get("homeAddress"));

        long i=db.update("CONTACT",contentValues,"_id = ?",new String[]{id});
        return i;
    }
}
