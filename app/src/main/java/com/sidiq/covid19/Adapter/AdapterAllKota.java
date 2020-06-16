package com.sidiq.covid19.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.sidiq.covid19.R;
import com.sidiq.covid19.View.ActivityGrafikKota;
import com.sidiq.covid19.model.CovidData;
import com.sidiq.covid19.model.ResultsItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AdapterAllKota extends RecyclerView.Adapter<AdapterAllKota.ViewHolder> {

    private final Context context;
    private List<ResultsItem> exampleList;
    private List<ResultsItem> exampleListFull;
    private List<ResultsItem> resultsItems = new ArrayList<>();

    public AdapterAllKota(Context context, List<ResultsItem> resultsItems) {
        this.context = context;
        this.resultsItems = resultsItems;
    }

    @NonNull
    @Override
    public AdapterAllKota.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_kota, parent, false);
        return new AdapterAllKota.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterAllKota.ViewHolder holder, int position) {
        final ResultsItem resultsItem = resultsItems.get(holder.getAdapterPosition());

        holder.txtOdp.setText(resultsItems.get(position).getTotalOdp());
        holder.txtMeninggal.setText(resultsItems.get(position).getCovidMeninggal());
        holder.txtPdp.setText(resultsItems.get(position).getPdp());
        holder.txtPositif.setText(resultsItems.get(position).getPositif());
        holder.txtSembuh.setText(resultsItems.get(position).getCovidSembuh());
        holder.txtTempat.setText(resultsItems.get(position).getKodeKota());
        holder.txtWaktu.setText(resultsItems.get(position).getTglUpdate());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDetail = new Intent(context, ActivityGrafikKota.class);
                intentDetail.putExtra("positif", resultsItems.get(holder.getAdapterPosition()).getPositif());
                intentDetail.putExtra("sembuh", resultsItems.get(holder.getAdapterPosition()).getCovidSembuh());
                intentDetail.putExtra("odp", resultsItems.get(holder.getAdapterPosition()).getTotalOdp());
                intentDetail.putExtra("pdp", resultsItems.get(holder.getAdapterPosition()).getPdp());
                intentDetail.putExtra("kabupaten_kota", resultsItems.get(holder.getAdapterPosition()).getKodeKota());
                intentDetail.putExtra("update", resultsItems.get(holder.getAdapterPosition()).getTglUpdate());



                intentDetail.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intentDetail);
            }
        });

    }

    public Filter getFilter() {
        return exampleFilter;
    }


    @Override
    public int getItemCount() {
        return resultsItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtPdp, txtOdp, txtPositif, txtSembuh, txtMeninggal, txtTempat, txtWaktu;
        private Button button;
        private CardView cardView;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            txtOdp = itemView.findViewById(R.id.txt_ODP);
            txtPdp = itemView.findViewById(R.id.txt_PDP);
            txtPositif = itemView.findViewById(R.id.txt_Positif);
            txtMeninggal = itemView.findViewById(R.id.txt_meinggal);
            txtSembuh = itemView.findViewById(R.id.txt_sembuh);
            txtTempat = itemView.findViewById(R.id.txt_kota);
            cardView = itemView.findViewById(R.id.cardView1);
            txtWaktu = itemView.findViewById(R.id.txt_update);




        }
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ResultsItem> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 1) {
                filteredList.addAll(resultsItems);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (ResultsItem item : resultsItems) {
                    if (item.getKodeKota().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            resultsItems.clear();
            resultsItems.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };


}
