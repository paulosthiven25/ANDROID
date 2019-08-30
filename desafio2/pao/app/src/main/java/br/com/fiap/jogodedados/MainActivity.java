package br.com.fiap.jogodedados;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
      ImageView imgJg1;
      ImageView imgJg2;
      int[] imagens ={
              R.drawable.dado1,
              R.drawable.dado2,
              R.drawable.dado3,
              R.drawable.dado4,
              R.drawable.dado5,
              R.drawable.dado6,
      };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgJg1=findViewById(R.id.imgJg1);
        imgJg2=findViewById(R.id.imgJg2);
    }

    public void jogarDados(View view) {
        Random gerador = new Random();
        int jog1 = gerador.nextInt(imagens.length);
        int jog2 = gerador.nextInt(imagens.length);

       imgJg1.setImageResource(imagens[jog1]);
       imgJg2.setImageResource(imagens[jog2]);


        if(jog1>jog2){
            Toast.makeText(this,"O jogador 1 venceu", Toast.LENGTH_SHORT).show();
        }
        else if (jog1<jog2){
            Toast.makeText(this,"O jogador 2 venceu", Toast.LENGTH_SHORT).show();
        }

        else{
            Toast.makeText(this,"Empatou", Toast.LENGTH_SHORT).show();
        }

    }
}
