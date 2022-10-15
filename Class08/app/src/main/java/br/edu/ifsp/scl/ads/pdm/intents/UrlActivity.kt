package ifsp.pdm.intents

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ifsp.pdm.intents.Constant.URL
import ifsp.pdm.intents.databinding.ActivityUrlBinding

class UrlActivity : AppCompatActivity() {

    private lateinit var amb: ActivityUrlBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        amb = ActivityUrlBinding.inflate(layoutInflater)
        setContentView(amb.root)

        supportActionBar?.subtitle = "URLActivity"

        val urlAnterior = intent.getStringExtra(URL) ?: ""

        //duas maneiras de fazer essa verificação
//        if(urlAnterior.isNotEmpty()) {
//            amb.urlEt.setText(urlAnterior)
//        }
        urlAnterior.takeIf { it.isNotEmpty() }.also { amb.urlEt.setText(it) }

        amb.entrarUrlBt.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?){
                val retornoIntent = Intent()
                retornoIntent.putExtra(URL, amb.urlEt.text.toString())
                //só irá retornar no clique do botao passado na funcao, nao irá retornar caso seja pelo botao back
                setResult(RESULT_OK, retornoIntent)
                //encerra o ciclo da view
                finish()
            }
        })
    }
}