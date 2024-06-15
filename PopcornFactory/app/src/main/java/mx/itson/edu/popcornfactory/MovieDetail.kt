package mx.itson.edu.popcornfactory

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import mx.itson.edu.popcornfactory.ui.theme.PopcornFactoryTheme

class MovieDetail : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moviedetaill)
        var title: TextView = findViewById(R.id.title_movie)
        var image: ImageView = findViewById(R.id.image_header)
        var desc: TextView = findViewById(R.id.descripcion)
        var seats: TextView = findViewById(R.id.seatsLeft)
        var buyTickets: Button = findViewById(R.id.buyticket)

        var titletxt = intent.extras?.getString("titulo") ?: "No message found"
        var desctxt = intent.extras?.getString("sinopsis") ?: "No message found"
        var imageint = intent.extras?.getInt("header") ?: 0
        var numSeats = intent.extras?.getInt("numberSeats") ?: 0
        var id = intent.extras?.getInt("pos") ?: -1

        title.text = titletxt
        desc.text = desctxt
        image.setImageResource(imageint)
        seats.setText("$numSeats seats available ")

        if(numSeats <= 0){
            buyTickets.isActivated = false
        }else{
            buyTickets.setOnClickListener {
                val intent: Intent = Intent(this,SeatSelection::class.java)
                intent.putExtra("id",id)
                intent.putExtra("name",titletxt)

                startActivity(intent)
            }
        }

    }
}