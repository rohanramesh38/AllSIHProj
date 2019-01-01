package com.example.rohan.bottomnavigationhach;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    bottomNavigationView=findViewById(R.id.bottomNavigationView);
bottomNavigationView.setOnNavigationItemSelectedListener(this);
bottomNavigationView.setSelectedItemId(R.id.navigation_home);




    }HomeFragment homeFragment=new HomeFragment();
    LikeFragment likeFragment=new LikeFragment();
    SettingsFragment settingsFragment=new SettingsFragment();

    CaptureFragment captureFragment=new CaptureFragment();
    DocFragment docFragment=new DocFragment();


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


            switch (menuItem.getItemId())
            {

                case R.id.navigation_home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,homeFragment).commit();
                    return  true;


                case R.id.navigation_cam:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,captureFragment).commit();
                    return  true;


                case R.id.navigation_doc:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,docFragment).commit();
                    return  true;


                case R.id.navigation_like:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,likeFragment).commit();
                    return  true;


                case R.id.navigation_setting:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,settingsFragment).commit();
                    return  true;
           
            }


        return false;
    }
}
