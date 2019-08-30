package br.com.fiap.formulario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome  = findViewById(R.id.edtNome);
    }

    public void salvar(View view) {
        String nome = edtNome.getText().toString();
        Toast.makeText(this,"Olá "+nome,Toast.LENGTH_LONG).show();
    }
}
