package com.techmighty.pokemontricks;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

/**
 * Created by ankitvaria on 14/07/16.
 */
public class DetailActivity extends AppCompatActivity{

    private TextView textView;
    private ImageView imageView;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mAdView = (AdView) findViewById(R.id.adView);
        mInterstitialAd = new InterstitialAd(this);

        // set the ad unit ID
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_first));

        AdRequest adRequest = new AdRequest.Builder()
                .build();

        // Load ads into Interstitial Ads
        mInterstitialAd.loadAd(adRequest);

        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                showInterstitial();
            }
        });

        mAdView.loadAd(adRequest);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textView = (TextView) findViewById(R.id.description);
        imageView = (ImageView) findViewById(R.id.backdrop);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int value = extras.getInt("POSITION");
            //The key argument here must match that used in the other activity
            try {
                switch (value){
                    case 1:
                        Glide.with(this).load(R.drawable.album1).into(imageView);
                        textView.setText(getString(R.string.desc_1));
                        break;
                    case 2:
                        Glide.with(this).load(R.drawable.album2).into(imageView);
                        textView.setText(getString(R.string.desc_2));
                        break;
                    case 3:
                        Glide.with(this).load(R.drawable.album3).into(imageView);
                        textView.setText(getString(R.string.desc_3));
                        break;
                    case 4:
                        Glide.with(this).load(R.drawable.album4).into(imageView);
                        textView.setText(getString(R.string.desc_4));
                        break;
                    case 5:
                        Glide.with(this).load(R.drawable.album5).into(imageView);
                        textView.setText(getString(R.string.desc_5));
                        break;
                    case 6:
                        Glide.with(this).load(R.drawable.album6).into(imageView);
                        textView.setText(getString(R.string.desc_6));
                        break;
                    case 7:
                        Glide.with(this).load(R.drawable.album7).into(imageView);
                        textView.setText(getString(R.string.desc_7));
                        break;
                    case 8:
                        Glide.with(this).load(R.drawable.album8).into(imageView);
                        textView.setText(getString(R.string.desc_8));
                        break;
                    case 9:
                        Glide.with(this).load(R.drawable.album9).into(imageView);
                        textView.setText(getString(R.string.desc_9));
                        break;
                    case 10:
                        Glide.with(this).load(R.drawable.album10).into(imageView);
                        textView.setText(getString(R.string.desc_10));
                        break;
                    case 11:
                        Glide.with(this).load(R.drawable.album11).into(imageView);
                        textView.setText(getString(R.string.desc_11));
                        break;
                    case 12:
                        Glide.with(this).load(R.drawable.album12).into(imageView);
                        textView.setText(getString(R.string.desc_12));
                        break;
                    case 13:
                        Glide.with(this).load(R.drawable.album13).into(imageView);
                        textView.setText(getString(R.string.desc_13));
                        break;
                    case 14:
                        Glide.with(this).load(R.drawable.album2).into(imageView);
                        textView.setMovementMethod(LinkMovementMethod.getInstance());
                        textView.setText(Html.fromHtml(getString(R.string.desc_14)));
                        break;

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }
}
