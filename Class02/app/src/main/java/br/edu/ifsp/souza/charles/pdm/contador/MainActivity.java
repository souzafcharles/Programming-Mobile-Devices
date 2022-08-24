package br.edu.ifsp.souza.charles.pdm.contador;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import br.edu.ifsp.souza.charles.pdm.contador.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding amb;
    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        amb = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(amb.getRoot());

        amb.inicialSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                contador = (i == 0)? 0 : (i==1)? 5: 10;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        amb.cliqueBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amb.contadorTv.setText(String.valueOf(++contador));
            }
        });
    }
}