package com.sidiq.covid19.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sidiq.covid19.R;
import com.sidiq.covid19.model.CovidData;

import java.util.ArrayList;
import java.util.List;

public class AllUpdateAdapter extends RecyclerView.Adapter<AllUpdateAdapter.ViewHolder> {
    private final Context context;
    private List<CovidData> listData = new ArrayList<>();

    public AllUpdateAdapter(Context context, List<CovidData> listData) {
        this.context = context;
        this.listData = listData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final CovidData covidData = listData.get(position);
        holder.txtOdp.setText(covidData.getTotalOdp());
        holder.txtPdp.setText(covidData.getPdp());
        holder.txtPositif.setText(covidData.getPositif());
        holder.txtSembuh.setText(covidData.getCovidSembuh());
        holder.txtMeninggal.setText(covidData.getCovidMeninggal());
        holder.txtTempat.setText(covidData.getProvinsi());
        holder.txtWaktu.setText(covidData.getWaktu());
    }

    @Override
    public int getItemCount() {
        int count;
        if (listData == null) {
            count = 0;
            Toast.makeText(context, "Null", Toast.LENGTH_SHORT).show();
        } else {
            count = listData.size();
        }
        return count;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtPdp, txtOdp, txtPositif, txtSembuh,txtMeninggal,txtTempat,txtWaktu;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtOdp = itemView.findViewById(R.id.txt_ODP);
            txtPdp = itemView.findViewById(R.id.txt_PDP);
            txtPositif = itemView.findViewById(R.id.txt_Positif);
            txtMeninggal= itemView.findViewById(R.id.txt_meinggal);
            txtSembuh = itemView.findViewById(R.id.txt_sembuh);
            txtTempat = itemView.findViewById(R.id.tempat);
            txtWaktu = itemView.findViewById(R.id.txtjam);
        }
    }
}
