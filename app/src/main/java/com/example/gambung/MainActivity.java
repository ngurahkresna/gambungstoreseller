package com.example.gambung;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;

import android.util.Log;
import android.view.MenuItem;


import com.example.gambung.model.Users;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment selectedFragment = new FragmentDashboard();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();

        //pengecekan parsing data menggunakan intent extra
        if (getIntent() != null){
            Users user = getIntent().getParcelableExtra("user");
            Log.d(TAG, "onCreate: "+getIntent().getStringExtra("store"));
        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_bot);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment selectedFragment = null;
        switch (menuItem.getItemId()) {
            case R.id.nav_dashboard:
                selectedFragment = new FragmentDashboard();
                break;
            case R.id.nav_produk:
                selectedFragment = new FragmentProduct();
                break;
            case R.id.nav_pesanan:
                selectedFragment = new FragmentPesanan();
                break;
            case R.id.nav_pendapatan:
                selectedFragment = new FragmentPesanan();
                break;
            case R.id.nav_profil:
                selectedFragment = new FragmentProfile();
                break;

        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container,selectedFragment).commit();
        return true;
    }

}
