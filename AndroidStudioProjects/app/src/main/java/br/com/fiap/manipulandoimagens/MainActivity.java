package br.com.fiap.manipulandoimagens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgPessoa=findViewById(R.id.imgPessoa);
    }


    public void alterarPessoa(View view) {
        switch (view.getId()){
            case R.id.btnPessoa1:
                imgPessoa.setImageResource(R.drawable.img1);
                break;
            case R.id.btnPessoa2:
                imgPessoa.setImageResource(R.drawable.img2);
                break;
            case R.id.btnPessoa3:
                imgPessoa.setImageResource(R.drawable.img3);
        }
    }
}
