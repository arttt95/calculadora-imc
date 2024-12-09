package com.arttt95.calculadoraimc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class ResultadoActivity : AppCompatActivity() {

    private lateinit var textPeso: TextView
    private lateinit var textAltura: TextView
    private lateinit var textResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textPeso = findViewById(R.id.text_peso)
        textAltura = findViewById(R.id.text_altura)
        textResultado = findViewById(R.id.text_resultado)

        val bundle = intent.extras

        if (bundle != null) {

            val peso = bundle.getDouble("peso")
            val altura = bundle.getDouble("altura")

            textPeso.text = "Peso informado: ${peso}Kg"
            textAltura.text = "Altura informada: ${altura}m "

            val imc = peso / (altura * altura)

            val res = if(imc < 18.5) {
                 "tá precisando comer berimbal\nIMC: $imc"
            } else if (imc in 18.5..24.9) {
                "O seu IMC está Normal\nIMC: $imc"
            } else if (imc in 25.0..29.9) {
                "O seu IMC é de Sobrepeso\nIMC: $imc"
            } else {
                "Carai gordão\nIMC: $imc"
            }

            textResultado.text = res

        }

    }
}