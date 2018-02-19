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
public class KulinerFragment extends Fragment {


    public KulinerFragment() {
        // Required empty public constructor
    }


    public static KulinerFragment newInstance() {

//        Bundle args = new Bundle();

        KulinerFragment fragment = new KulinerFragment();
//        fragment.setArguments(args);
        return fragment;
    }

    String [] makanan = {"gudeg", "naspad", "nasi pecel", "nasduk", "indomie" };
    int [] gambar = {R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RecyclerView view = new RecyclerView(getContext());
//        view = view.findViewById(R.id.recyclerVieww);
        view.setLayoutManager(new LinearLayoutManager(getContext()));
        view.setAdapter(new SimpleRVAdapter(makanan));
        return view;
    }

    public class SimpleRVAdapter extends RecyclerView.Adapter<SimpleRVAdapter.MyViewHolder> {
        public SimpleRVAdapter(String[] makanan) {

        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.kuliner_item, null, false);
            return new MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.judul.setText(makanan[position]);
            holder.img.setImageResource(gambar[position]);
        }

        @Override
        public int getItemCount() {
            return makanan.length;
        }

        public  class MyViewHolder extends RecyclerView.ViewHolder {
            TextView judul;
            ImageView img;
            public MyViewHolder(View itemView) {
                super(itemView);
                judul = itemView.findViewById(R.id.judul);
                img = itemView.findViewById(R.id.img);
            }
        }
    }
}
