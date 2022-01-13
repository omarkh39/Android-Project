package com.example.project

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLite(context: Context):SQLiteOpenHelper(context,"USERDB",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {


        db?.execSQL("CREATE TABLE USERS(USERID INTEGER PRIMARY KEY AUTOINCREMENT,UNAME TEXT,PWD TEXT)")

        db?.execSQL("INSERT INTO USERS(UNAME,PWD) VALUES('oma20180170@std.psut.edu.jo','test12')")
        db?.execSQL("INSERT INTO USERS(UNAME,PWD) VALUES('moh20180183@std.psut.edu.jo','test123')")
        db?.execSQL("INSERT INTO USERS(UNAME,PWD) VALUES('bak20180583@std.psut.edu.jo','test1234')")
        db?.execSQL("INSERT INTO USERS(UNAME,PWD) VALUES('nas20180173@std.psut.edu.jo','test12345')")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}