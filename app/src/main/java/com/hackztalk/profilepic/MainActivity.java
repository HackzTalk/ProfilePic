package com.hackztalk.profilepic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hackztalk.profilepic.Fragments.homefragment;
import com.hackztalk.profilepic.Fragments.savedfragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navbar;
    ImageView ivfollow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivfollow = findViewById(R.id.ivfollow);
        ivfollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gotoUrl("https://www.instagram.com/_whyanil/");

            }
        });





        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container,new homefragment());
        transaction.commit();

        navbar = findViewById(R.id.navbar);


        navbar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId())
                {

                    case R.id.home:
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.container,new homefragment());
                        transaction.commit();
                        break;
                    case R.id.saved:
                        FragmentTransaction transactionsaved = getSupportFragmentManager().beginTransaction();
                        transactionsaved.replace(R.id.container,new savedfragment());
                        transactionsaved.commit();
                        break;


                }

                return true;
            }
        });

    }

    private void gotoUrl(String s) {

        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));

    }
}