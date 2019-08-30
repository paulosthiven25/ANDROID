package br.com.fiap.componentesparte2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     RadioGroup rbgJogos;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rbgJogos = findViewById(R.id.rdgJogos);
    }

    public void salvar(View view) {
        int selecionado = rbgJogos.getCheckedRadioButtonId();
        RadioButton db = findViewById(selecionado);

        if(db != null){
            Toast.makeText(this,db.getText(),Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, R.string.nenhum_jogo_seleconado,Toast.LENGTH_SHORT).show();
        }

    }
}
