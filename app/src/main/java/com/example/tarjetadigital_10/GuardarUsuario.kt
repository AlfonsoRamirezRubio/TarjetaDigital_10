package com.example.tarjetadigital_10

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class GuardarUsuario : AppCompatActivity() {

    lateinit var edNombre: EditText
    lateinit var edCarrera: EditText
    lateinit var edTelefono: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guardar_usuario)

        edNombre = findViewById(R.id.edDatoNombre)
        edCarrera = findViewById(R.id.edDatoCarrera)
        edTelefono = findViewById(R.id.edDatoTelefono)

        val nombre = intent.getStringExtra("Nombre")
        edNombre.setText(nombre)
        val carrera = intent.getStringExtra("Carrera")
        edCarrera.setText(carrera)
        val telefono = intent.getStringExtra("Telefono")
        edTelefono.setText(telefono)

         }
        fun guardarValor(v: View) {
            val preferencias = getSharedPreferences(
                "misdatos", Context.MODE_PRIVATE)
            val editor = preferencias.edit() //permite guardar
            val nombre = edNombre.text.toString()
            val carrera = edCarrera.text.toString()
            val telefono = edTelefono.text.toString()//obtener del cuadro
            editor.putString("Nombre", nombre)
            editor.putString("Carrera", carrera)
            editor.putString("Telefono", telefono)
            editor.commit()
            Toast.makeText(this, "Se grabo", Toast.LENGTH_LONG).show()


            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("Nombre", nombre)
            intent.putExtra("Carrera", carrera)
            intent.putExtra("Telefono", telefono)
            startActivity(intent)
            //edDatoNombre.text = nombre
            //edDatoCarrera.text = carrera
            //edDatoTelefono.text = telefono
        }

    }
