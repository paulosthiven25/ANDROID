package br.com.fiap.nac04.rm81631;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        CheckBox chkCabo;
        CheckBox chkTelha;
        CheckBox chkPiso;
        CheckBox chkAco;
        CheckBox chkLadrilho;
        CheckBox chkFrete;
        EditText edtValor;
        TextView txtResultado;
        SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chkCabo = findViewById(R.id.chkCabo);
        chkAco = findViewById(R.id.chkAco);
        chkTelha = findViewById(R.id.chktTelha);
        chkLadrilho = findViewById(R.id.chkLadrilho);
        chkPiso = findViewById(R.id.chkPisoLaminado);
        chkFrete = findViewById(R.id.chkFrete);
        edtValor = findViewById(R.id.edtMetro);
        txtResultado = findViewById(R.id.txtResultado);


        sp = getPreferences(MODE_PRIVATE);
    }

    public void calcularCompra(View view) {
        int resul=0;
        String inputMetro = edtValor.getText().toString();

        if(inputMetro == "" ){
            Toast.makeText(this,"Preencher campo de M²",Toast.LENGTH_SHORT).show();
            return;
        }


        else{
            int metro = Integer.parseInt(inputMetro);
            if (chkCabo.isChecked()){
                resul += metro*10;
            }

            if (chkTelha.isChecked()){
                resul += metro*20;
            }

            if (chkPiso.isChecked()){
                resul += metro*30;
            }

            if (chkAco.isChecked()){
                resul += metro*40;
            }

            if (chkLadrilho.isChecked()){
                resul += metro*50;
            }

            if (chkFrete.isChecked()){
                resul +=resul*0.44;
            }

        }
    }
}
