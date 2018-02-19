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
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance() {

//        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
//        fragment.setArguments(args);
        return fragment;
    }

    String[] Homeee = {"rumah", "bioskop", "sekolah", "kantor", "restoran"};
    int[] gambarrrr = {R.drawable.rumah, R.drawable.bioskop, R.drawable.sekolah, R.drawable.kantor, R.drawable.restoran};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        RecyclerView view = new RecyclerView(getContext());
//        view = view.findViewById(R.id.recyclerVieww);
        view.setLayoutManager(new LinearLayoutManager(getContext()));
        view.setAdapter(new SimpleRVAdapterr(Homeee));
        return view;

        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home2, container, false);
    }

    private class SimpleRVAdapterr extends RecyclerView.Adapter<SimpleRVAdapterr.MyViewHolder> {
        public SimpleRVAdapterr(String[] homeee) {
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item, null, false);
            return new MyViewHolder(v3);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.judulHome.setText(Homeee[position]);
            holder.imgHome.setImageResource(gambarrrr[position]);
        }

        @Override
        public int getItemCount() {
            return Homeee.length;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView judulHome;
            ImageView imgHome;
            public MyViewHolder(View itemView) {
                super(itemView);
                judulHome = itemView.findViewById(R.id.judulhome);
                imgHome = itemView.findViewById(R.id.imghome);
            }
        }
    }
}



   

