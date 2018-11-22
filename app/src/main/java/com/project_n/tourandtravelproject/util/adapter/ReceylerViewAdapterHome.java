package com.project_n.tourandtravelproject.util.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project_n.tourandtravelproject.R;
import com.project_n.tourandtravelproject.fragment.HomeFragment;
import com.project_n.tourandtravelproject.util.PreferenceHelper;

import java.util.ArrayList;


public class ReceylerViewAdapterHome extends RecyclerView.Adapter<ReceylerViewAdapterHome.ViewHolder> {
    public static final int TYPE_1 =1;
    public static final int TYPE_2 =2;

    HomeFragment context;
    ArrayList<Integer> listViewType;

    public ReceylerViewAdapterHome(ArrayList<Integer> listViewType, HomeFragment context){
        this.listViewType = listViewType;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType){
            case TYPE_1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_header, null);
                return new HomeHeaderViewHolder(view);
            case TYPE_2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_content, null);
                return new HomeContentViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int viewType = listViewType.get(position);
        PreferenceHelper instance;
        instance = PreferenceHelper.getInstance(context.getActivity().getApplicationContext());
        switch (viewType){
            case TYPE_1:
                HomeHeaderViewHolder mhomeHeader = (HomeHeaderViewHolder) holder;
                mhomeHeader.mHomeUserName.setText(instance.getName());
                break;
            case TYPE_2:
                break;
        }

    }

    @Override
    public int getItemCount() {
        return listViewType.size();
    }

    @Override
    public int getItemViewType(int position){
        return listViewType.get(position);
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    private class HomeHeaderViewHolder extends ViewHolder {

        TextView mHomeUserName;

        public HomeHeaderViewHolder(View view) {
            super(view);

            mHomeUserName = view.findViewById(R.id.HomeUserName);

        }


    }

    private class HomeContentViewHolder extends ViewHolder {
        public HomeContentViewHolder(View view) {
            super(view);
        }
    }
}
