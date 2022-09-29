package br.edu.ifsp.souza.charles.pdm.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import br.edu.ifsp.souza.charles.pdm.intents.Constant.URL
import br.edu.ifsp.souza.charles.pdm.intents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val amb : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private  lateinit var urlArl: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)
        supportActionBar?.subtitle = "MainActivity"

        urlArl = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { resultado: ActivityResult ->
            if(resultado.resultCode == RESULT_OK){
                val urlRetornada = resultado.data?.getStringExtra(URL) ?: ""
                amb.urlTv.text = urlRetornada
            }
        }

        amb.entrarUrlBt.setOnClickListener {
//            val urlActivityIntent = Intent(this, UrlActivity::class.java)
            val urlActivityIntent = Intent("SEGUNDA_TELA_DO_PROJETO_INTENTS")
            urlActivityIntent.putExtra(URL, amb.urlTv.text.toString())
            urlArl.launch(urlActivityIntent)
//
        }
    }
}
