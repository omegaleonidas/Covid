package com.sidiq.covid19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.sidiq.covid19.Adapter.AdapterKota;
import com.sidiq.covid19.model.Response;
import com.sidiq.covid19.model.Results;
import com.sidiq.covid19.network.ApiInterface;
import com.sidiq.covid19.network.ApiServices;

import retrofit2.Call;
import retrofit2.Callback;

public class activity_padang extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterKota adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_padang);
        loadData();
    }

    private void loadData() {
//        ApiInterface server = ApiServices.getRetrofit().create(ApiInterface.class);
//        final Call<Response> resDataCall =server.getAll_kota();
//        resDataCall.enqueue(new Callback<Response>() {
//            @Override
//            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
//                if (response.isSuccessful()) {
//                    load(response.body().getResults());
//                    Log.d("Message","Success");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Response> call, Throwable t) {
//                Log.d("Message","Error" +t.getMessage());
//            }
//        });
//

    }

    private void load(Results covidData) {
        recyclerView = findViewById(R.id.rv_dataPadang);
        adapter = new AdapterKota(this,covidData);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);

    }
}