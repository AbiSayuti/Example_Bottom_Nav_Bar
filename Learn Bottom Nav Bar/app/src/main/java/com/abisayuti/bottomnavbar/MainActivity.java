package com.abisayuti.bottomnavbar;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.abisayuti.bottomnavbar.Fragment.HomeFragment;
import com.abisayuti.bottomnavbar.Fragment.KulinerFragment;
import com.abisayuti.bottomnavbar.Fragment.WisataFragment;

public class MainActivity extends AppCompatActivity {

    // TODO Create Variable

    BottomNavigationView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO Inisialisasi Variable
        view = findViewById(R.id.navigation);

        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment selectedFragment = null;

                switch (item.getItemId()){
                    case R.id.mHome:
                        selectedFragment = HomeFragment.newInstance();
                    break;

                    case R.id.mWisata:
                        selectedFragment = WisataFragment.newInstance();
                        break;

                        // TODO koding berbeda
                    case R.id.mKuliner:
                        selectedFragment = new KulinerFragment();
                        break;
                }

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.relativeLayout, selectedFragment);
                transaction.commit();
                return true;
            }
        });

        FragmentTransaction transaction =  getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.relativeLayout, HomeFragment.newInstance());
        transaction.commit();

    }
}
