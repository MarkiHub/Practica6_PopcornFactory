package mx.itson.edu.popcornfactory

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class ResumeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen)

        val num_asiento: TextView = findViewById(R.id.numAsientoSelect)
        val nom_cliente: TextView = findViewById(R.id.nombreCliente)
        val regresar: Button = findViewById(R.id.regresarInicio)

        var bundle = intent.extras
        var numAsiento = -1

        if(bundle != null){
            numAsiento = bundle.getInt("numAsiento")
        }

        num_asiento.text = "Asiento seleccionado: $numAsiento"
        nom_cliente.text = "Nombre cliente: ${MainActivity.staticCliente.nombre}"

        regresar.setOnClickListener {
            var intento: Intent = Intent(this, MainActivity::class.java)
            startActivity(intento)
        }

    }
}
