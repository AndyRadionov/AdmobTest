package io.github.andyradionov.admobtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBannerAdClick(View view) {
        Intent startIntent = new Intent(this, BannerActivity.class);
        startActivity(startIntent);
    }

    public void onInterstitialAdClick(View view) {
        Intent startIntent = new Intent(this, InterstitialActivity.class);
        startActivity(startIntent);
    }
}
