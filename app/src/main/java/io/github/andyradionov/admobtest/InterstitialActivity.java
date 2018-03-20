package io.github.andyradionov.admobtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class InterstitialActivity extends AppCompatActivity {

    private Button mShowButton;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstitial);

        mShowButton = findViewById(R.id.showButton);
        mShowButton.setEnabled(false);
    }

    public void loadInterstitial(View view) {
        mShowButton.setEnabled(false);
        mShowButton.setText(R.string.interstitial_loading);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        mInterstitialAd.setAdListener(new ToastAdListener(this) {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                mShowButton.setText(R.string.interstitial_show);
                mShowButton.setEnabled(true);
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                super.onAdFailedToLoad(errorCode);
                mShowButton.setEnabled(false);
                mShowButton.setText(getErrorReason(errorCode));
            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest);
    }

    public void showInterstitial(View view) {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }

        mShowButton.setText(R.string.interstitial_not_ready);
        mShowButton.setEnabled(false);
    }
}
