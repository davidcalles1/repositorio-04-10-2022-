package com.unab.practicasql

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.util.prefs.PreferencesFactory

class AdmiSQLlite(
    context:Context?,
    name:String,
    factory:SQLiteDatabase.CursorFactory?,
    version:Int):
    SQLiteOpenHelper(context,name,factory,version) {

    override fun onCreate(dB: SQLiteDatabase?) {
        dB?.execSQL("create table articulos(" +
                "id_article int primary key," +
                "description text," +
                "price real)")

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {



    }
}