package br.edu.ifsp.souza.charles.pdm.ciclopdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.LinearLayout
import br.edu.ifsp.souza.charles.pdm.ciclopdm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val amb : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var  dinamicoEt: EditText

    private companion object{
        const val TAG = "CICLO_PDM_TAG"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        dinamicoEt = EditText(this)
        val layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(0, 10,0,0)
        dinamicoEt.layoutParams = layoutParams
        dinamicoEt.hint = "EditText dinamico"
        amb.root.addView(dinamicoEt)

        Log.v(TAG, "onCreate: Iniciando ciclo COMPLETO")
    }

    override fun onStart() {
        super.onStart()
        Log.v(TAG, "onStart: Iniciando ciclo VISIVEL")
    }

    override fun onResume() {
        super.onResume()
        Log.v(TAG, "onResume: Iniciando ciclo FOREGROUND")
    }
    override fun onRestart() {
        super.onRestart()
        Log.v(TAG, "onRestart: Preparando a execução do onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.v(TAG, "onRestart: Finalizando ciclo FOREGROUND")
    }

    override fun onStop() {
        super.onStop()
        Log.v(TAG, "onRestart: Finalizando ciclo VISIVEL")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(TAG, "onRestart: Finalizando ciclo COMPLETO")
    }
}