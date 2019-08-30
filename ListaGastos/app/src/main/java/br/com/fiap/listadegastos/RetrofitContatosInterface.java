package br.com.fiap.listadegastos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitContatosInterface {

    @GET("gasto")
    Call<List<Gasto>> getGastos();

}
