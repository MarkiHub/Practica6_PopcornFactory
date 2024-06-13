package mx.itson.edu.popcornfactory

import android.os.Bundle
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

        title.text = intent.extras?.getString("titulo") ?: "No message found"
        desc.text = intent.extras?.getString("sinopsis") ?: "No message found"
        var imageint = intent.extras?.getInt("header") ?: 0

        image.setImageResource(imageint)

    }
}