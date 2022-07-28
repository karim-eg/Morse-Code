package com.EnceptCode.MorseCode;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.google.android.gms.ads.MobileAds;

public class AboutActivity extends AppCompatActivity {

	private LinearLayout ln4;
	private LinearLayout ln6;

	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.about);
		initialize();
		
		MobileAds.initialize(this);
		
		initializeLogic();
	}
	
	private void initialize() {
		LinearLayout ln1 = findViewById(R.id.ln1);
		LinearLayout ln2 = findViewById(R.id.ln2);
		LinearLayout ln3 = findViewById(R.id.ln3);
		LinearLayout ln5 = findViewById(R.id.ln5);
		ln4 = findViewById(R.id.ln4);
		ImageView img1 = findViewById(R.id.img1);
		TextView tx1 = findViewById(R.id.tx1);
		TextView tx2 = findViewById(R.id.tx2);
		TextView tx3 = findViewById(R.id.tx3);
		TextView tx5 = findViewById(R.id.tx5);
		ln6 = findViewById(R.id.ln6);
		ImageView img2 = findViewById(R.id.img2);
		TextView tx4 = findViewById(R.id.tx4);
		
		tx3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_urii("https://encept.co");
			}
		});
		
		ln6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_urii("https://play.google.com/store/apps/details?id=com.EnceptCode.CodingOasis");
			}
		});
	}
	
	private void initializeLogic() {
		_gd(ln6, "#FFFFFF", "#E0E0E0", 15);
		com.google.android.gms.ads.MobileAds.initialize(AboutActivity.this, new com.google.android.gms.ads.initialization.OnInitializationCompleteListener() {
			@Override
			public void onInitializationComplete(com.google.android.gms.ads.initialization.InitializationStatus initializationStatus) {
				 }
		});

		com.google.android.gms.ads.AdView ad = new com.google.android.gms.ads.AdView(AboutActivity.this);
		
		ad.setAdSize(com.google.android.gms.ads.AdSize.LARGE_BANNER);
		
		ad.setAdUnitId("ca-app-pub-6910652682395372/8818939855");
		ad.loadAd(new com.google.android.gms.ads.AdRequest.Builder().build());
		
		ln4.addView(ad);
	}
	
	public void _urii(final String _string) {
		androidx.browser.customtabs.CustomTabsIntent.Builder builder = new androidx.browser.customtabs.CustomTabsIntent.Builder();
		androidx.browser.customtabs.CustomTabsIntent customTabsIntent = builder.build();
		customTabsIntent.launchUrl(getCurrentContext(this), Uri.parse(_string));
	}
	
	public Context getCurrentContext(Context c) {
		    return c;
	}
	public Context getCurrentContext(Fragment c) {
		    return c.getActivity();
	}
	public Context getCurrentContext(DialogFragment c) {
		    return c.getActivity();
	}


	public void _gd(final View _view, final String _c, final String _sc, final double _r) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		
		gd.setColor(Color.parseColor(_c));
		gd.setCornerRadius((float)_r);
		gd.setStroke(2, Color.parseColor(_sc));
		
		_view.setBackground(gd);
	}
	
}
