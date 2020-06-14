package com.sidiq.covid19;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Circle;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.sidiq.covid19.Adapter.LastUpdateAdapter;
import com.sidiq.covid19.model.CovidData;
import com.sidiq.covid19.network.ApiInterface;
import com.sidiq.covid19.network.ApiServices;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tempat, waktu;

    private RecyclerView recyclerView;
    private LastUpdateAdapter adapter;

    private ArrayList<String> xValues = new ArrayList<>();

    private Button grafik, b_allKota;
    private CovidData covidData1;
    private CardView cardView;

private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_allKota = findViewById(R.id.textBtnALL_KOta);
        tempat = findViewById(R.id.txttempat);
        waktu = findViewById(R.id.txtjam);
        cardView = findViewById(R.id.Card_penangann);
        cardView.invalidate();

        progressBar = findViewById(R.id.spin_ki2);
        Sprite doubleBounce = new Circle();
        progressBar.setIndeterminateDrawable(doubleBounce);
        showLoading(true);

        grafik = findViewById(R.id.textButton);
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }


        grafik.setOnClickListener(this);


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
                    showLoading(false);
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

            case R.id.textButton:
                Intent intent2 = new Intent(getApplicationContext(), GarafikAtivity.class);
                startActivity(intent2);
                break;

            case R.id.textBtnALL_KOta:
                Intent intent3 = new Intent(getApplicationContext(), Activity_All_kota.class);
                startActivity(intent3);
                break;

        }
    }
    private void showLoading(Boolean state) {
        if (state) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }
}
