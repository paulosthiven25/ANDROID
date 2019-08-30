package br.com.fiap.appcarros;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void alterarBanner1(View view) {
        alterarFragment(new Fragment_Ferrari());
    }

    public void alterarBanner2(View view) {
        alterarFragment(new Fragment_Van());
    }

    public void alterarBanner3(View view) {
        alterarFragment(new Fragment_Jipe());
    }

    public void alterarFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,fragment)
                .addToBackStack(null)
                .commit();
    }

}
