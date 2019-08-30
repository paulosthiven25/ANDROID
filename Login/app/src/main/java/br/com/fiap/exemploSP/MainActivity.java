package br.com.fiap.exemploSP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtUsuario;
    EditText edtSenha;
    CheckBox chkManterConectado;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtUsuario = findViewById(R.id.edtUsuario);
        edtSenha = findViewById(R.id.edtSenha);
        chkManterConectado = findViewById(R.id.checkManterConectado);
        sp = getPreferences(MODE_PRIVATE);
        if(sp.getBoolean("conectado",false)){
            String usuario = sp.getString("usuario","");
            String senha =sp.getString("senha","");

            edtSenha.setText(senha);
            edtUsuario.setText(usuario);
            chkManterConectado.setChecked(true);
        }
    }


    public void login(View view) {
        String usuario = edtUsuario.getText().toString().trim();
        String senha = edtSenha.getText().toString();

        if(usuario.isEmpty() || senha.isEmpty()){
            Toast.makeText(this,"INFORME OS DADOS CORRETAMENTE!",Toast.LENGTH_SHORT).show();
            return;
        }
        if(usuario.equals("fiap")  && senha.equals("fiap")){

            SharedPreferences.Editor editor = sp.edit();
            if(chkManterConectado.isChecked()){


                editor.putString("usuario",usuario);
                editor.putString("senha",senha);
                editor.putBoolean("conectado",true);

            } else {
                /*editor.remove("usuario");*/

                editor.clear();
            }
            editor.commit();

            Toast.makeText(this,"Usuário logado com sucesso!",Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this,"Usuários ou senha inválidos",Toast.LENGTH_SHORT).show();
    }
}
