package com.project_n.tourandtravelproject.util.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project_n.tourandtravelproject.R;
import com.project_n.tourandtravelproject.activity.MulaiTourKota;
import com.project_n.tourandtravelproject.array.RiwayatPemesanan;
import com.project_n.tourandtravelproject.fragment.AkunFragment;
import com.project_n.tourandtravelproject.fragment.PaketTourFragment;

import java.util.List;

public class ReceylerViewAdapter extends RecyclerView.Adapter<ReceylerViewAdapter.ViewHolder> {

    public AkunFragment AkunContext;
    public PaketTourFragment PaketContext;
    public MulaiTourKota MulaiTourKotaContext;
    public List<RiwayatPemesanan> mData ;

    public ReceylerViewAdapter(List<RiwayatPemesanan> lstRiwayat, PaketTourFragment context) {
        this.PaketContext = context;
        this.mData = lstRiwayat;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mRiwayatPaket;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mRiwayatPaket = itemView.findViewById(R.id.RiwayatPaket);
        }
    }
    public ReceylerViewAdapter(List<RiwayatPemesanan> mData, AkunFragment mContext){
        this.AkunContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.riwayat, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.mRiwayatPaket.setText(mData.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return  mData.size();
    }

}
