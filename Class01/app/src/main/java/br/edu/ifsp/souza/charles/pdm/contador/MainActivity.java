package br.edu.ifsp.souza.charles.pdm.contador;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.edu.ifsp.souza.charles.pdm.contador.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding amb;
    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        amb = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(amb.getRoot());

        amb.inicialCb.setOnClickListener(view -> {
            if(amb.inicialCb.isChecked()){
                contador = Integer.parseInt(amb.inicialCb.getText().toString());
            }
        });


        amb.cliqueBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amb.contadorTv.setText(String.valueOf(++contador));
            }
        });
    }
}