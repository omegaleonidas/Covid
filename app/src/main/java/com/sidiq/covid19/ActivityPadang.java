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

public class ActivityPadang extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterKota adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_padang);

    }



}