package com.sidiq.covid19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.sidiq.covid19.Adapter.AdapterKota;
import com.sidiq.covid19.model.Response;
import com.sidiq.covid19.model.Results;
import com.sidiq.covid19.network.ApiInterface;
import com.sidiq.covid19.network.ApiServices;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class Activity_padang_panjang extends AppCompatActivity {

    private Results results;

    private TextView tempat, waktu;
    private RecyclerView recyclerView;
    private AdapterKota adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_padang_panjang);


        loadData();
        loadData1();
        tempat = findViewById(R.id.txttempat);
        waktu = findViewById(R.id.txtjam);

    }


    private void loadData() {
        ApiInterface server = ApiServices.getRetrofit().create(ApiInterface.class);
        final Call<Response> resDataCall = server.getPadangPanjang();
        resDataCall.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if (response.isSuccessful()) {
                    load(response.body().getResults());
                    results=response.body().getResults();
                    tempat.setText(results.getKodeKota());
                    waktu.setText(results.getTglUpdate());



                    Log.d("Message", "Success");
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Log.d("Message", "Error" + t.getMessage());
            }
        });


    }
    private void loadData1() {
        ApiInterface server = ApiServices.getRetrofit().create(ApiInterface.class);
        final Call<Response> resDataCall = server.getPadangPanjang();
        resDataCall.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if (response.isSuccessful()) {
                    load(response.body().getResults());
                    results=response.body().getResults();
                    Log.d("Message", "Success");
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Log.d("Message", "Error" + t.getMessage());
            }
        });


    }



    private void load(Results covidData) {
        recyclerView = findViewById(R.id.rv_dataPadangPanjang);
        adapter = new AdapterKota(this, covidData);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);

    }
}
