package io.github.andyradionov.admobtest;


import android.content.Context;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author Andrey Radionov
 */

public class ToastAdListener extends AdListener {

    private Context mContext;
    private static final SparseArray<String> ERROR_CODES;
    private static final String ERROR_FORMAT = "onAdFailedToLoad(%s)";

    static {
        ERROR_CODES = new SparseArray<>(4);
        ERROR_CODES.put(AdRequest.ERROR_CODE_INTERNAL_ERROR, "INTERNAL ERROR");
        ERROR_CODES.put(AdRequest.ERROR_CODE_INVALID_REQUEST, "INVALID REQUEST");
        ERROR_CODES.put(AdRequest.ERROR_CODE_NETWORK_ERROR, "NETWORK ERROR");
        ERROR_CODES.put(AdRequest.ERROR_CODE_NO_FILL, "NO FILL");
    }

    public ToastAdListener(Context context) {
        mContext = context;
    }

    @Override
    public void onAdClosed() {
        Toast.makeText(mContext, "onAdClosed()", Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void onAdFailedToLoad(int i) {
        Toast.makeText(mContext, getErrorReason(i), Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void onAdLeftApplication() {
        Toast.makeText(mContext, "onAdLeftApplication()", Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void onAdOpened() {
        Toast.makeText(mContext, "onAdOpened()", Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void onAdLoaded() {
        Toast.makeText(mContext, "onAdLoaded()", Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void onAdClicked() {
        Toast.makeText(mContext, "onAdClicked()", Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void onAdImpression() {
        Toast.makeText(mContext, "onAdImpression()", Toast.LENGTH_SHORT)
                .show();
    }

    public String getErrorReason(int errorCode) {
        String errorMessage = ERROR_CODES.get(errorCode);
        if (errorMessage == null) {
            errorMessage = "";
        }
        return String.format(Locale.getDefault(), ERROR_FORMAT, errorMessage);
    }
}
