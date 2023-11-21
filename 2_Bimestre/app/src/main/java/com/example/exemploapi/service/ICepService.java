package com.example.exemploapi.service;

import com.example.exemploapi.dto.CepDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ICepService {

    @GET("ws/{cep}/json/")
    Call<CepDTO> getViaCep(@Path("cep")String cep);
}
