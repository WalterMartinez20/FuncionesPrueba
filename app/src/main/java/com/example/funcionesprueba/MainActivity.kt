package com.example.funcionesprueba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

data class Integrantes(val nombre:String, val codigo:String, val usuario:String)

class MainActivity : AppCompatActivity() {

    val inte1 = Integrantes("Carlos Humberto", "USIS075419", "Humberto")
    val inte2 = Integrantes("Juan Carlos", "USIS012820", "Juan")
    val inte3 = Integrantes("Carlos Daniel", "USTS055119", "Daniel")
    val inte4 = Integrantes("Walter Alberto", "SMIS133220", "Walter")
    val inte5 = Integrantes("Steven Amílcar", "USIS024020", "Steven")
    var inteGeneral = inte5.copy()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btCambiar = findViewById(R.id.btnCambiar) as Button
        btCambiar.setOnClickListener {
         view -> switchIntegrantes(inteGeneral)
        }
    }

    fun switchIntegrantes(integrantes: Integrantes){
        inteGeneral = integrantes.copy()
        when(integrantes.usuario){
            "Humberto" -> inteGeneral = inte2.copy()
            "Juan" -> inteGeneral = inte3.copy()
            "Daniel" -> inteGeneral = inte4.copy()
            "Walter" -> inteGeneral = inte5.copy()
            "Steven" -> inteGeneral = inte1.copy()

            else -> print("Ya no hay mas integrantes")
        }
        verPantalla("Nombre: ${inteGeneral.nombre}\n Usuario: ${inteGeneral.usuario}\n Codigo: ${inteGeneral.codigo}")
    }

    fun verPantalla(ver:String){
        val txtMensaje = findViewById<TextView>(R.id.tvMensaje)
        txtMensaje.setText(ver)
    }
    //fun todosIntegrantes() :String = "${react.nombre} y ${kot.nombre}"
}