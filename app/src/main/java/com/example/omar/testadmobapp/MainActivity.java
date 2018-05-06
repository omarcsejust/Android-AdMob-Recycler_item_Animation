package com.example.omar.testadmobapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    private AdView mAdView;

    Button buttonGoToList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonGoToList=findViewById(R.id.button_got_to_list);

        /*MobileAds.initialize(this,
                "ca-app-pub-3940256099942544~3347511713");*/

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }

    public void goToList(View view) {

        Intent intent=new Intent(MainActivity.this,ListActivity.class);
        startActivity(intent);
    }
}
