package com.project_n.tourandtravelproject.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.project_n.tourandtravelproject.R;
import com.project_n.tourandtravelproject.Traveling;


/**
 * A simple {@link Fragment} subclass.
 */
public class MulaiTourFragment extends Fragment {

    Traveling mTravel;
    Button MulaiTour;
    TextView mAsalKota;

    public MulaiTourFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mulai_tour, container, false);

        mAsalKota = view.findViewById(R.id.mtAsalKota);
        //Bundle i = getActivity().getIntent().getExtras();
       // mAsalKota.setText(i.getString("kota"));

        MulaiTour = view.findViewById(R.id.BtnMulaiTour);
        MulaiTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*mTravel = new Traveling();
                mTravel.setKotaAsal(mAsalKota.getText().toString());
                insetData(mTravel);*/
                Toast.makeText(getActivity().getApplicationContext(), "Ditambahkan Kedaftar Pesanan Anda",
                        Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }

     /* private void insetData(final Traveling traveling){
        new AsyncTask<Void, Void, Long>() {
            @Override
            protected Long doInBackground(Void... voids) {
                long status = db.travelingDao().insertTravel(traveling);
                return status;
            }
        }.execute();
    }*/

}
