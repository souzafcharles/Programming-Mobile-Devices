package br.edu.ifsp.souza.charles.pdm.ciclopdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.ifsp.souza.charles.pdm.ciclopdm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}