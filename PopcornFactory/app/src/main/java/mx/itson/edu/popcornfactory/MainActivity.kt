package mx.itson.edu.popcornfactory

import android.content.Intent
import android.os.Bundle
import android.widget.Button
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

class MainActivity : ComponentActivity() {
    object staticCliente{
        @JvmStatic
        val nombre = "Marcos"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button: Button = findViewById(R.id.boton)

        button.setOnClickListener {
            var intento = Intent(this, CatalogActivity::class.java)
            this.startActivity(intento)
        }
    }
}