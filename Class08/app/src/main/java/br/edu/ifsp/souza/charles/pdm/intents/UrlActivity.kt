package br.edu.ifsp.souza.charles.pdm.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import br.edu.ifsp.souza.charles.pdm.intents.Constant.URL
import br.edu.ifsp.souza.charles.pdm.intents.databinding.ActivityUrlBinding

class UrlActivity : AppCompatActivity() {

    private lateinit var aub: ActivityUrlBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        aub = ActivityUrlBinding.inflate(layoutInflater)
        setContentView(aub.root)
        supportActionBar?.subtitle = "UrlActivity"

        val urlAnterior = intent.getStringExtra(URL) ?: ""
        if (urlAnterior.isNotEmpty()){
           aub.urlEt.setText(urlAnterior)
        }

        aub.entrarUrlBt.setOnClickListener(object: OnClickListener {
            override fun onClick(p0: View?){
                val retornoIntent = Intent()
                retornoIntent.putExtra(URL, aub.urlEt.text.toString())
                setResult(RESULT_OK, retornoIntent)
                finish()
            }
        })
    }
}