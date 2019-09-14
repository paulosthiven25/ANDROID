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
        SharedPreferences.Editor editor;

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
        editor= sp.edit();

        retornarDados();



    }

    public void retornarDados(){
        chkCabo.setChecked(sp.getBoolean("Cabo",false));
        chkAco.setChecked(sp.getBoolean("Aco",false));
        chkTelha.setChecked(sp.getBoolean("Telha",false));
        chkLadrilho.setChecked(sp.getBoolean("Ladrilho",false));
        chkPiso.setChecked(sp.getBoolean("Piso",false));
        chkFrete.setChecked(sp.getBoolean("Frete",false));
        txtResultado.setText(Integer.toString(sp.getInt("resul",0)));

    }

    public void guardaInfo() {


        editor.putBoolean("Cabo",chkCabo.isChecked());
        editor.putBoolean("Aco",chkAco.isChecked());
        editor.putBoolean("Telha",chkTelha.isChecked());
        editor.putBoolean("Ladrilho",chkLadrilho.isChecked());
        editor.putBoolean("Piso",chkPiso.isChecked());
        editor.putBoolean("Frete",chkFrete.isChecked());
        editor.putInt("resul",Integer.parseInt(txtResultado.getText().toString()));
        editor.commit();


    }



    public void calcularCompra(View view) {

        int resul=0;
        String inputMetro = edtValor.getText().toString();

        if(inputMetro.equals("")){
            Toast.makeText(this, R.string.preencher_campo_de_m_quadrado,Toast.LENGTH_SHORT).show();
            txtResultado.setText(Integer.toString(0));
            return;
        }

        else if (!chkCabo.isChecked() && !chkTelha.isChecked() && !chkPiso.isChecked() &&
                !chkAco.isChecked() && !chkLadrilho.isChecked() ){
            Toast.makeText(this, R.string.escolha_uma_opcao,Toast.LENGTH_SHORT).show();
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


            txtResultado.setText(Integer.toString(resul));
            guardaInfo();

        }
    }
}
