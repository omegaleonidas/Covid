package com.sidiq.covid19.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.sidiq.covid19.R;
import com.sidiq.covid19.model.CovidData;
import com.sidiq.covid19.model.ResultsItem;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class ActivityGrafikKota extends AppCompatActivity {

    public static final String EXTRA_DATA = "extra_data";

    private PieChart chart;
    private TextView txtPositif, txtKabupatenKota, txtSembuh, txtPdp, txtOdp, txtUpdate;
    private CardView cardViewRed, cardViewBlue, cardViewYellow, cardViewGray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafik_kota);
        txtPositif = findViewById(R.id.TxtPositif);
        txtSembuh = findViewById(R.id.TxtSembuh);
        txtPdp = findViewById(R.id.TxtPdp);
        txtOdp = findViewById(R.id.TxtOdp);
        txtUpdate = findViewById(R.id.tanggal_update);
        cardViewRed = findViewById(R.id.buttonRed);
        cardViewBlue = findViewById(R.id.buttonBlue);
        cardViewYellow = findViewById(R.id.buttonYellow);
        cardViewGray = findViewById(R.id.buttonGray);


        txtKabupatenKota = findViewById(R.id.kabupaten_kota);
        cardViewRed.getBackground().setTint(Color.RED);
        cardViewBlue.getBackground().setTint(Color.BLUE);
        cardViewYellow.getBackground().setTint(Color.YELLOW);
        cardViewGray.getBackground().setTint(Color.GRAY);

        tampilData();
        grafik();

    }

    private void tampilData() {
        ResultsItem listMovie = getIntent().getParcelableExtra(EXTRA_DATA);
        Bundle bundleDetail = getIntent().getExtras();
        txtPositif.setText(bundleDetail.getString("positif"));
        txtSembuh.setText(bundleDetail.getString("sembuh"));
        txtOdp.setText(bundleDetail.getString("odp"));
        txtUpdate.setText(bundleDetail.getString("update"));
        txtPdp.setText(bundleDetail.getString("pdp"));

        txtKabupatenKota.setText(bundleDetail.getString("kabupaten_kota"));


    }

    private void grafik() {
        Bundle bundleDetail = getIntent().getExtras();
        String positif = bundleDetail.getString("positif");
        String sembuh = bundleDetail.getString("sembuh");


        String odp = bundleDetail.getString("odp");
        String pdp = bundleDetail.getString("pdp");

        Float angka1 = Float.valueOf(positif);
        Float angka2 = Float.valueOf(sembuh);

        Float total = angka1 - angka2;
        PieChartView pieChartView = findViewById(R.id.chart);
        List<SliceValue> pieData = new ArrayList<>();
        pieData.add(new SliceValue(angka1, Color.RED));
        pieData.add(new SliceValue(Float.parseFloat(sembuh), Color.BLUE).setLabel("positif"));
        pieData.add(new SliceValue(Float.parseFloat(pdp), Color.GREEN));
        pieData.add(new SliceValue(Float.parseFloat(odp), Color.MAGENTA));
        PieChartData pieChartData = new PieChartData(pieData);



       //pieChartData.setHasCenterCircle(true).setCenterText1("").setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#0097A7"));
        pieChartView.setPieChartData(pieChartData);


    }

}