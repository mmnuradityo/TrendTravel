package com.project_n.tourandtravelproject.util.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project_n.tourandtravelproject.R;
import com.project_n.tourandtravelproject.array.ListKota;

import java.util.List;

public class RecycleViewAdapterKota extends RecyclerView.Adapter<RecycleViewAdapterKota.MyViewHolder> {
    private Context mContext;
    public List<ListKota> mTravel ;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView mDetailKota;
        public MyViewHolder(View itemView) {
            super(itemView);
            mDetailKota = itemView.findViewById(R.id.textDetailKota);
        }
    }
    public RecycleViewAdapterKota(Context mContext, List<ListKota> kotaList) {
        this.mContext = mContext;
        this.mTravel = kotaList;
    }
    @Override
    public RecycleViewAdapterKota.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.detai_kota, parent, false);
        return new RecycleViewAdapterKota.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecycleViewAdapterKota.MyViewHolder holder, int position) {
        holder.mDetailKota.setText(mTravel.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mTravel.size();
    }


}
