package com.unab.practicasql

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.unab.practicasql.AdmiSQLlite
import com.unab.practicasql.R

class MainActivity : AppCompatActivity() {

    private lateinit var codArticle: EditText
    private lateinit var descriptionA: EditText
    private lateinit var precio: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        codArticle = findViewById(R.id.nombre)
        descriptionA = findViewById(R.id.codigo)
        precio = findViewById(R.id.precio)
    }

    fun Save(V: View) {

        val admin = AdmiSQLlite(this, "Store", null, 1)
        val db: SQLiteDatabase = admin.writableDatabase


        val cod = codArticle.text.toString()
        val des = descriptionA.text.toString()
        val pre = precio.text.toString()

        if (!cod.isEmpty() && !des.isEmpty() && !pre.isEmpty()) {

            val c = ContentValues()
            c.put("id_article", cod)
            c.put("description", des)
            c.put("price", pre)

            db.insert("article", null, c)
            db.close()

            codArticle

            Toast.makeText(this, "registro exitoso ", Toast.LENGTH_SHORT)
                .show()
        } else {

            Toast.makeText(this, "Debe llenar todos los campos para registrar", Toast.LENGTH_SHORT)
                .show()

        }

    }
}

