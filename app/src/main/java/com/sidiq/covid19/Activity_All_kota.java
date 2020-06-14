package com.sidiq.covid19;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Circle;
import com.sidiq.covid19.Adapter.AdapterAllKota;
import com.sidiq.covid19.model.ResponKota;
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

    private ProgressBar progressBar;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__all_kota);
        progressBar = findViewById(R.id.spin_kti3);
        Sprite doubleBounce = new Circle();
        progressBar.setIndeterminateDrawable(doubleBounce);
        showLoading(true);

        recyclerView = findViewById(R.id.rv_Kota);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);
        loadData();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                loadData();


                return false;
            }
        });
        return true;
    }


    private void showLoading(Boolean state) {
        if (state) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    private void loadData() {
        ApiInterface server = ApiServices.getRetrofit().create(ApiInterface.class);
        final Call<ResponKota> responcall = server.getAll_kota();
        responcall.enqueue(new Callback<ResponKota>() {
            @Override
            public void onResponse(Call<ResponKota> call, Response<ResponKota> response) {
                resultKota = response.body().getResults();
                showLoading(false);
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

    private void load(ResponKota resultsItem) {


    }
}