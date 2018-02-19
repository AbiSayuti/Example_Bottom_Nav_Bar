package com.abisayuti.bottomnavbar.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.abisayuti.bottomnavbar.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WisataFragment extends Fragment {


    public WisataFragment() {
        // Required empty public constructor
    }

    public static WisataFragment newInstance() {

//        Bundle args = new Bundle();

        WisataFragment fragment = new WisataFragment();
//        fragment.setArguments(args);
        return fragment;
    }


    String[] wisata = {"air terjun", "pantai", "danau", "goa", "curug"};
    int[] gambarwst = {R.drawable.airterjun, R.drawable.pantai, R.drawable.danau, R.drawable.goa, R.drawable.curug};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView view = new RecyclerView(getContext());
//        view = view.findViewById(R.id.recyclerVieww);
        view.setLayoutManager(new LinearLayoutManager(getContext()));
        view.setAdapter(new WisataFragment.SimpleRVAdapter(wisata));
        return view;
    }

    public class SimpleRVAdapter extends RecyclerView.Adapter<SimpleRVAdapter.MyViewHolder> {
        public SimpleRVAdapter(String[] wisata) {
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.wisata_item, null, false);
            return new MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {

            holder.judulwisata.setText(wisata[position]);
            holder.imgwisata.setImageResource(gambarwst[position]);
        }

        @Override
        public int getItemCount() {
            return wisata.length;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView judulwisata;
            ImageView imgwisata;

            public MyViewHolder(View itemView) {
                super(itemView);
                judulwisata = itemView.findViewById(R.id.judulwisata);
                imgwisata = itemView.findViewById(R.id.imgwisata);

            }
        }
    }
}