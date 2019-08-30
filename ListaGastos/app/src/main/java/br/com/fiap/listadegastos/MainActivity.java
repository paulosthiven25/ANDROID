package br.com.fiap.listadegastos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ListView lstGastos;
    List<Gasto> gastos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstGastos = (ListView) findViewById(R.id.lstGastos);




        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/Servidor-WS-Gastos/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();



        RetrofitContatosInterface api = retrofit.create(RetrofitContatosInterface.class);
        api.getGastos().enqueue(new Callback<List<Gasto>>() {

            @Override
            public void onResponse(Call<List<Gasto>> call, Response<List<Gasto>> response) {

            }


            @Override
            public void onFailure(Call<List<Gasto>> call, Throwable t) {

            }
        });

        GastoAdapter ga = new GastoAdapter(this,gastos);
        lstGastos.setAdapter(ga);
    }
}
