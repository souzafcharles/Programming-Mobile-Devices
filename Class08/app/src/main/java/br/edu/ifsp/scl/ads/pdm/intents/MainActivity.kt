package ifsp.pdm.intents

import android.Manifest.permission.CALL_PHONE
import android.content.Intent
import android.content.Intent.*
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import ifsp.pdm.intents.Constant.URL
import ifsp.pdm.intents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //acessar os arquivos da view do xml
    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var urlArl: ActivityResultLauncher<Intent>
    private lateinit var permissaoChamadaArl: ActivityResultLauncher<String>
    private lateinit var pegarImagemArl: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        supportActionBar?.subtitle = "MainActivity"

        //abrir nova tela e espera resultado
        urlArl = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            resultado ->
            if(resultado.resultCode == RESULT_OK){
                val urlRetornada = resultado.data?.getStringExtra(URL) ?: ""
                amb.urlTv.text = urlRetornada
            }
        }

        //2 parametros: implementação de um callback
        permissaoChamadaArl = registerForActivityResult(ActivityResultContracts.RequestPermission(),
            object: ActivityResultCallback<Boolean>{
                                    //isso que vai ser executado quando atela de permissao fechar
                                   //o parametro booleano significa se a parmissao foi aceita ou nao
                                    override fun onActivityResult(concedida: Boolean?) {
                                        if (concedida!!){
                                            chamarNumero(true)
                                        } else {
                                            Toast.makeText(this@MainActivity, "Permissao necessaria para execução", Toast.LENGTH_SHORT)
                                                .show()
                                            finish() //se nao tem permissao tem que fechar a tela de permissao e como ela é a unica janela ativa fecha o aplicativo
                                        }
                                    }
                                })

        pegarImagemArl = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                resultado : ActivityResult ->
            if(resultado.resultCode == RESULT_OK){
                val imagemUri = resultado.data?.data
                //Toast.makeText(this, imagemUri.toString(), Toast.LENGTH_SHORT).show()

                //recebendo o path da imagem
                imagemUri?.let{
                    amb.urlTv.text = it.toString() //uri da imagem como sendo texto
                }

                //abrindo um visualizador
                val visualizarImagemIntent = Intent(ACTION_VIEW, imagemUri)
                startActivity(visualizarImagemIntent)

            }
        }

        amb.entrarUrlBt.setOnClickListener {
            // chamada de outra tela
            // val urlActivityIntent = Intent(this, UrlActivity::class.java)
            val urlActivityIntent = Intent("URL_ACTIVITY")
            urlActivityIntent.putExtra(URL, amb.urlTv.text)
            //espera o retorno da outra tela
            urlArl.launch(urlActivityIntent)
        }
    }

    // coloca o menu na actionBar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    // trata das escolhas das opcoes do meny / as intents
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.viewMi -> {
                //abrir navegador na url digitada pelo usuario
                val url = Uri.parse(amb.urlTv.text.toString())
                val navegadorIntent = Intent(ACTION_VIEW, url)
                startActivity(navegadorIntent)
                true
            }
            R.id.dialMi -> {
                chamarNumero(false)
                true
            }
            R.id.callMi -> {
                //verificar versão android
                //caso seja superior ou igual ao marshmello
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    //se tem a permissão
                    if (checkSelfPermission(CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                        chamarNumero(true); //faz a chamada
                    } else {
                        permissaoChamadaArl.launch(CALL_PHONE)//solicita permissão
                    }
                } else { //se a versão for anterior
                    chamarNumero(true) //faz a chamada sem necessidade de permissao pq nessas versoes o app nem instala sem essas permissoes
                }
                true
            }
            R.id.pickMi -> {
                val pegarImagemIntent = Intent(ACTION_PICK)
                val diretorioImagens = Environment //pegar diretorio
                    .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).path //path de um diretorio publico de imagens
                pegarImagemIntent
                    .setDataAndType(Uri.parse(diretorioImagens), "image/*") //pega qualquer tipo de imagem dentro desse diretorio
                pegarImagemArl.launch(pegarImagemIntent)
                true
            }
            R.id.chooserMi -> { //utiliza quando quer forçar que um aplicativo seja mostrado para o ususario
                var escolherAppIntent = Intent(ACTION_CHOOSER)
                var informacoesIntent = Intent(ACTION_VIEW, Uri.parse(amb.urlTv.text.toString()))

                escolherAppIntent.putExtra(EXTRA_TITLE, "Escolha seu navegador")
                escolherAppIntent.putExtra(EXTRA_INTENT, informacoesIntent)

                true
            }

            else -> { false }
        }
    }

    private fun chamarNumero(chamar: Boolean){
        val uri = Uri.parse("tel: ${amb.urlTv.text}")
        val intent = Intent( if (chamar) ACTION_CALL  else ACTION_DIAL ) //disca ou chama
        intent.data = uri
        startActivity(intent)
    }


    //OBS
    //Toast.makeTest("alerta").show()
}