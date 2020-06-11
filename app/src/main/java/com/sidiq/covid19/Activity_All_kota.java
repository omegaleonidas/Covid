package com.sidiq.covid19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.sidiq.covid19.Adapter.AdapterAllKota;
import com.sidiq.covid19.Adapter.AdapterKota;
import com.sidiq.covid19.model.ResponKota;
import com.sidiq.covid19.model.Results;
import com.sidiq.covid19.model.ResultsItem;
import com.sidiq.covid19.network.ApiInterface;
import com.sidiq.covid19.network.ApiServices;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_All_kota extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterAllKota adapter;
    private List<ResultsItem> resultKota = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__all_kota);

        recyclerView = findViewById(R.id.rv_Kota);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);
        loadData();

    }

    private void loadData() {
        ApiInterface server = ApiServices.getRetrofit().create(ApiInterface.class);
         final Call<ResponKota> responcall = server.getAll_kota();
         responcall.enqueue(new Callback<ResponKota>() {
             @Override
             public void onResponse(Call<ResponKota> call, Response<ResponKota> response) {
                resultKota = response.body().getResults();
                 if (responcall != null) {
                     adapter = new AdapterAllKota(getApplicationContext(), resultKota);
                     recyclerView.setAdapter(adapter);
                 } else {
                     Toast.makeText(getApplicationContext(), "empty", Toast.LENGTH_SHORT).show();
                 }
             }

             @Override
             public void onFailure(Call<ResponKota> call, Throwable t) {

             }
         });




    }

    private void load(ResponKota resultsItem   ) {




    }
}