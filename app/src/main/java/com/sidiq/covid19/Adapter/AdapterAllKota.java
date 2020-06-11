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
import com.sidiq.covid19.model.ResponKota;
import com.sidiq.covid19.model.ResultsItem;

import java.util.ArrayList;
import java.util.List;

public class AdapterAllKota extends RecyclerView.Adapter<AdapterAllKota.ViewHolder> {

    private Context context;
    private List<ResultsItem> resultsItems = new ArrayList<>();

    public AdapterAllKota(Context context, List<ResultsItem> resultsItems) {
        this.context = context;
        this.resultsItems = resultsItems;
    }

    @NonNull
    @Override
    public AdapterAllKota.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_kota,parent,false);
        return new AdapterAllKota.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAllKota.ViewHolder holder, int position) {

        holder.txtOdp.setText(resultsItems.get(position).getTotalOdp());
        holder.txtMeninggal.setText(resultsItems.get(position).getCovidMeninggal());
        holder.txtPdp.setText(resultsItems.get(position).getPdp());
        holder.txtPositif.setText(resultsItems.get(position).getPositif());
        holder.txtSembuh.setText(resultsItems.get(position).getCovidSembuh());
        holder.txtTempat.setText(resultsItems.get(position).getKodeKota());
        holder.txtWaktu.setText(resultsItems.get(position).getTglUpdate());

    }

    @Override
    public int getItemCount() {
      return resultsItems.size();
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
            txtTempat = itemView.findViewById(R.id.txt_kota);
            txtWaktu =itemView.findViewById(R.id.txt_update);




        }
    }
}
