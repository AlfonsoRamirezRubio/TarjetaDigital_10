package com.example.tarjetadigital_10

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    lateinit var lblNombre: TextView
    lateinit var lblCarrera: TextView
    lateinit var lblTelefono: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ////
        lblNombre = findViewById(R.id.lblNombre)
        lblCarrera = findViewById(R.id.lblCarrera)
        lblTelefono = findViewById(R.id.lblTelefono)
    }


    fun llamarventana(v: View) {
        val intent = Intent(this, GuardarUsuario::class.java)
        intent.putExtra("Nombre", lblNombre.text)
        intent.putExtra("Carrera", lblCarrera.text)
        intent.putExtra("Telefono", lblTelefono.text)
        startActivity(intent)
    }

    override fun onResume(){
        super.onResume()
        val preferencia = getSharedPreferences(
            "misdatos", Context.MODE_PRIVATE)
        val nombre = preferencia.getString("Nombre", "")
        val carrera = preferencia.getString("Carrera", "")
        val telefono = preferencia.getString("Telefono", "")

        // Actualizar los TextView
        lblNombre.text = "$nombre"
        lblCarrera.text = "$carrera"
        lblTelefono.text = "$telefono"
    }


    }
