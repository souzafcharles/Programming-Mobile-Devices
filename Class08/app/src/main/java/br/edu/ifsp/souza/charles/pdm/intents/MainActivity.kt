package br.edu.ifsp.souza.charles.pdm.intents

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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
            val urlActivityIntent = Intent(this, UrlActivity::class.java)
            urlActivityIntent.putExtra(URL, amb.urlTv.text.toString())
            urlArl.launch(urlActivityIntent)
//
        }
    }

    //Coloca o menu da ActionBar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    //Trata das escolhas das opções de menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.viewMi -> {
                //Abrir o navegador na URL digitada pelo usuário
                val url = Uri.parse(amb.urlTv.text.toString())
                val navegadorIntent = Intent(ACTION_VIEW, url)
                startActivity(navegadorIntent)
                true
            }
            else -> { false }
        }
    }
}
