package br.com.fiap.desafio01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtNum1;
    EditText edtNum2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNum1 = findViewById(R.id.edtNum1);
        edtNum2 = findViewById(R.id.edtNum2);


    }

    public void somar(View view) {
        int num1 = Integer.parseInt(edtNum1.getText().toString());
        int num2 = Integer.parseInt(edtNum2.getText().toString());
        int result = num1+num2;
        String resultado = String.valueOf(result);

        Toast.makeText(this,resultado, Toast.LENGTH_SHORT).show();

    }
}
