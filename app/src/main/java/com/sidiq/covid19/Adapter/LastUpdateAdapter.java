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

public class LastUpdateAdapter extends RecyclerView.Adapter<LastUpdateAdapter.ViewHolder> {
    private final Context context;
    private CovidData listCovid;

    public LastUpdateAdapter(Context context, CovidData listCovid) {
        this.context = context;
        this.listCovid = listCovid;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.txtOdp.setText(listCovid.getTotalOdp());
        holder.txtPdp.setText(listCovid.getPdp());
        holder.txtPositif.setText(listCovid.getPositif());
        holder.txtSembuh.setText(listCovid.getCovidSembuh());
        holder.txtMeninggal.setText(listCovid.getCovidMeninggal());
//        holder.txtTempat.setText(listCovid.getProvinsi());
////        holder.txtWaktu.setText(listCovid.getWaktu());
    }

    @Override
    public int getItemCount() {
        return 1;
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

