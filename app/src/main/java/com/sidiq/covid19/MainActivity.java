package com.sidiq.covid19;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.sidiq.covid19.Adapter.LastUpdateAdapter;
import com.sidiq.covid19.config.Constant;
import com.sidiq.covid19.model.CovidData;
import com.sidiq.covid19.network.ApiInterface;
import com.sidiq.covid19.network.ApiServices;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tempat, waktu;

    private RecyclerView recyclerView;
    private LastUpdateAdapter adapter;

    private ArrayList<String> xValues = new ArrayList<>();

    private Button B_PadangPanjang, B_payakumbuh, B_Padang, B_bukittinggi, grafik, b_allKota;
    private CovidData covidData1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        B_PadangPanjang = findViewById(R.id.btnPadangPanjang);
        B_Padang = findViewById(R.id.btnpadang);
        B_payakumbuh = findViewById(R.id.btnPayakumbuh);
        B_bukittinggi = findViewById(R.id.btnBukitTinggi);
        b_allKota = findViewById(R.id.textBtnALL_KOta);
        tempat = findViewById(R.id.txttempat);
        waktu = findViewById(R.id.txtjam);
        grafik = findViewById(R.id.textButton);
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }


        B_PadangPanjang.setOnClickListener(this);
        B_Padang.setOnClickListener(this);
        grafik.setOnClickListener(this);
        B_payakumbuh.setOnClickListener(this);
        B_bukittinggi.setOnClickListener(this);
        B_bukittinggi.setOnClickListener(this);
        b_allKota.setOnClickListener(this);

        loadData();


    }


    private void load(CovidData covidData) {
        recyclerView = findViewById(R.id.rv_data);
        adapter = new LastUpdateAdapter(this, covidData);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);

    }


    private void loadData() {
        ApiInterface server = ApiServices.getRetrofit().create(ApiInterface.class);

        Call<CovidData> response = server.getLast();
        response.enqueue(new Callback<CovidData>() {
            @Override
            public void onResponse(Call<CovidData> call, Response<CovidData> response) {
                if (response.isSuccessful()) {
                    CovidData covidData = new CovidData();
                    covidData1 = response.body();
                    covidData.setTotalOdp(response.body().getTotalOdp());
                    covidData.setPdp(response.body().getPdp());
                    tempat.setText(covidData1.getProvinsi());
                    waktu.setText(covidData1.getWaktu());
                    covidData.setPositif(response.body().getPositif());
                    covidData.setCovidSembuh(response.body().getCovidSembuh());
                    covidData.setCovidMeninggal(response.body().getCovidMeninggal());
                    covidData.setProvinsi(response.body().getProvinsi());
                    covidData.setWaktu(response.body().getWaktu());


                    load(covidData);
                }
            }

            @Override
            public void onFailure(Call<CovidData> call, Throwable t) {

            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPadangPanjang:
                Intent intent = new Intent(getApplicationContext(), Activity_padang_panjang.class);
                startActivity(intent);
                break;
            case R.id.btnpadang:
                Intent intent1 = new Intent(getApplicationContext(), activity_padang.class);
                startActivity(intent1);
                break;
            case R.id.textButton:
                Intent intent2 = new Intent(getApplicationContext(), GarafikAtivity.class);
                startActivity(intent2);
                break;
            case R.id.btnBukitTinggi:
                Toast.makeText(getApplicationContext(), "Comming Soon", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnPayakumbuh:
                Toast.makeText(getApplicationContext(), "Comming Soon", Toast.LENGTH_SHORT).show();
                break;
            case R.id.textBtnALL_KOta:
                Intent intent3 = new Intent(getApplicationContext(), Activity_All_kota.class);
                startActivity(intent3);
                break;

        }
    }
}