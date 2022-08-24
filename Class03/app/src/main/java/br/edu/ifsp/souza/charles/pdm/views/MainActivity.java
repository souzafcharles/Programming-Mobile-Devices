package br.edu.ifsp.souza.charles.pdm.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.ifsp.souza.charles.pdm.views.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Referência para classe de viewBinding
    private ActivityMainBinding amb;
    private Pessoa pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        amb = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(amb.getRoot());


        amb.salvarBt.setOnClickListener( view -> {
            pessoa = new Pessoa(
                    amb.nomeEt.getText().toString(),
                    amb.sobrenomeEt.getText().toString(),
                    amb.emailEt.getText().toString(),
                    ((TextView) amb.estadoCivilSp.getSelectedView()).getText().toString(),
                    amb.femininoRb.isChecked() ? getString(R.string.feminino) : amb.masculinoRb.getText().toString()
            );

            Toast.makeText(this, pessoa.toString(), Toast.LENGTH_SHORT).show();
        });

        amb.limparBt.setOnClickListener( view -> {
            amb.nomeEt.setText("");
            amb.sobrenomeEt.setText("");
            amb.emailEt.setText("");
            amb.estadoCivilSp.setSelection(0);
            amb.femininoRb.setChecked(true);
            pessoa = null;
        });

        amb.estadoCivilSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int posicao, long l) {
                // Caso seja selecinada a opção "casado"
                if (posicao == 1) {
                    amb.conjugeLl.setVisibility(View.VISIBLE);
                } else {
                    amb.conjugeLl.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    public void onClickBotao(View botao) {
        if (botao.getId() == R.id.salvarBt) {
            Toast.makeText(this, "Clicou em Salvar", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Clicou no Limpar", Toast.LENGTH_SHORT).show();
        }
    }
}