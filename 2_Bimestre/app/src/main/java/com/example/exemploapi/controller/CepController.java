package com.example.exemploapi.controller;

import android.content.Context;
import android.widget.TextView;

import com.example.exemploapi.dto.CepDTO;
import com.example.exemploapi.retrofit.RetrofitConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CepController {

    public static void getViaCep(String cep, TextView tvResponse){
        try{
            Call<CepDTO> call = new RetrofitConfig()
                    .cepService().getViaCep(cep);

            call.enqueue(new Callback<CepDTO>() {
                @Override
                public void onResponse(Call<CepDTO> call, Response<CepDTO> response) {
                    CepDTO dto = response.body();
                    tvResponse.setText(dto.toString());
                }

                @Override
                public void onFailure(Call<CepDTO> call, Throwable t) {
                    tvResponse.setText(t.getMessage());
                }
            });

        }catch (Exception ex){}

    }


}
