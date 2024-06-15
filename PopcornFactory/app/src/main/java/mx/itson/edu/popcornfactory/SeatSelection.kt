package mx.itson.edu.popcornfactory

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class SeatSelection : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seats)

        val title: TextView = findViewById(R.id.titleSeats)
        var posMovie = -1
        val bundle = intent.extras
        var checkId = -1
        
        if(bundle!= null){
            title.setText(bundle.getString("name"))
            posMovie = bundle.getInt("id")
        }

        val confirm: Button = findViewById(R.id.confirm)

        confirm.setOnClickListener {
                if (posMovie != -1 && checkId != -1){
                    CatalogActivity.staticPel.peliculas[posMovie].seats.add(Cliente(MainActivity.staticCliente.nombre,"Alguno",checkId))
                    Toast.makeText(this, "Asiento #$checkId reservado" , Toast.LENGTH_LONG).show()
                    var intento: Intent = Intent(this, ResumeActivity::class.java)
                    intento.putExtra("numAsiento", checkId)

                    startActivity(intento)
                }
        }

        val row1: RadioGroup = findViewById(R.id.row1)
        val row2: RadioGroup = findViewById(R.id.row2)
        val row3: RadioGroup = findViewById(R.id.row3)
        val row4: RadioGroup = findViewById(R.id.row4)

        row1.setOnCheckedChangeListener{group,checkedID->
            if(checkedID > -1){
                row2.clearCheck()
                row3.clearCheck()
                row4.clearCheck()
                checkId = checkedID
                row1.check(checkedID)
            }
        }
        row2.setOnCheckedChangeListener{group,checkedID->
            if(checkedID > -1){
                row1.clearCheck()
                row3.clearCheck()
                row4.clearCheck()
                checkId = checkedID

                row2.check(checkedID)
            }
        }
        row3.setOnCheckedChangeListener{group,checkedID->
            if(checkedID > -1){
                row2.clearCheck()
                row1.clearCheck()
                row4.clearCheck()
                checkId = checkedID
                row3.check(checkedID)
            }
        }
        row4.setOnCheckedChangeListener{group,checkedID->
            if(checkedID > -1){
                row2.clearCheck()
                row3.clearCheck()
                row1.clearCheck()
                checkId = checkedID
                row4.check(checkedID)
            }
        }
    }
}
