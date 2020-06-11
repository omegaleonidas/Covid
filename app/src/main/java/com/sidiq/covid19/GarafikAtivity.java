package com.sidiq.covid19;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.sidiq.covid19.model.CovidData;
import com.sidiq.covid19.network.ApiInterface;
import com.sidiq.covid19.network.ApiServices;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GarafikAtivity extends AppCompatActivity {

    private List<CovidData> covidData1 = new ArrayList<>();

    private LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garafik_ativity);


        tampil_grafik();


    }


    private void tampil_grafik() {
        ApiInterface server = ApiServices.getRetrofit().create(ApiInterface.class);
        final Call<List<CovidData>> listCall = server.getAllData();
        listCall.enqueue(new Callback<List<CovidData>>() {
            @Override
            public void onResponse(Call<List<CovidData>> call, Response<List<CovidData>> response) {
                if (response.isSuccessful()) {
                    covidData1 = response.body();
                    grafikList(response.body());
                    grafikList(covidData1);
                    Log.e("datamasuk", "" + covidData1.get(20).getCovidDirawat());
                }

            }

            @Override
            public void onFailure(Call<List<CovidData>> call, Throwable t) {

            }
        });


    }


    private void grafikList(List<CovidData> covidData1) {
        lineChart = findViewById(R.id.chart);

        lineChart.setDragEnabled(true);
        lineChart.setScaleEnabled(false);
        ArrayList<Entry> yValues = new ArrayList<>();
        ArrayList<Entry> sembuhValues = new ArrayList<>();


        for (int i = 0; i < covidData1.size(); i++) {


            yValues.add(new Entry(i, Float.parseFloat(covidData1.get(i).getPositif())));

            sembuhValues.add(new Entry(i, Float.parseFloat(covidData1.get(i).getCovidSembuh())));
            i++;



            LineDataSet set1 = new LineDataSet(yValues, "positif");
            LineDataSet set2 = new LineDataSet(sembuhValues, "sembuh");
            set1.setFillAlpha(110);
            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1);
            set1.setColor(Color.RED);
            set1.setLineWidth(3);
            LineData data = new LineData(dataSets);
            lineChart.setData(data);


            set2.setFillAlpha(110);
            ArrayList<ILineDataSet> dataSets2 = new ArrayList<>();
            dataSets.add(set2);
            set2.setColor(Color.BLUE);
            set2.setLineWidth(3);
            LineData data2 = new LineData(dataSets);
            lineChart.setData(data);
            lineChart.invalidate();


        }

    }


}


//

