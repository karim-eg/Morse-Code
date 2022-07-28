package com.EnceptCode.MorseCode;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class MorseInfoActivity extends AppCompatActivity {

	private final ArrayList<HashMap<String, Object>> Li = new ArrayList<>();
	private final ArrayList<HashMap<String, Object>> Mo = new ArrayList<>();

	private LinearLayout ln3;
	private RecyclerView recyclerview1;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.morse_info);
		initialize();
		
		MobileAds.initialize(this);
		
		initializeLogic();
	}
	
	private void initialize() {
		LinearLayout ln1 = findViewById(R.id.ln1);
		LinearLayout ln2 = findViewById(R.id.ln2);
		ln3 = findViewById(R.id.ln3);
		TextView tx1 = findViewById(R.id.tx1);
		recyclerview1 = findViewById(R.id.recyclerview1);
	}
	
	private void initializeLogic() {
		recyclerview1.setLayoutManager(new LinearLayoutManager(this));
		_got();
		com.google.android.gms.ads.MobileAds.initialize(MorseInfoActivity.this, new com.google.android.gms.ads.initialization.OnInitializationCompleteListener() {
			@Override
			public void onInitializationComplete(com.google.android.gms.ads.initialization.InitializationStatus initializationStatus) {
				 }
		});

		com.google.android.gms.ads.AdView ad = new com.google.android.gms.ads.AdView(MorseInfoActivity.this);
		
		ad.setAdSize(com.google.android.gms.ads.AdSize.BANNER);
		
		ad.setAdUnitId("ca-app-pub-6910652682395372/8818939855");
		ad.loadAd(new com.google.android.gms.ads.AdRequest.Builder().build());
		
		ln3.addView(ad);
	}
	
	public void _got() {
		String key = "Key";
		String val = "morse";
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(key, "A");
			Li.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(key, "B");
			Li.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(key, "C");
			Li.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(key, "D");
			Li.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(key, "E");
			Li.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(key, "F");
			Li.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(key, "G");
			Li.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(key, "H");
			Li.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(key, "I");
			Li.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(key, "J");
			Li.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(key, "K");
			Li.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(key, "L");
			Li.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(key, "M");
			Li.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(key, "N");
			Li.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(key, "O");
			Li.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(key, "P");
			Li.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(key, "Q");
			Li.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(key, "R");
			Li.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(key, "S");
			Li.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(key, "T");
			Li.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(key, "U");
			Li.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(key, "V");
			Li.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(key, "W");
			Li.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(key, "X");
			Li.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(key, "Y");
			Li.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(key, "Z");
			Li.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(key, "0");
			Li.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(key, "1");
			Li.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(key, "2");
			Li.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(key, "3");
			Li.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(key, "4");
			Li.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(key, "5");
			Li.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(key, "6");
			Li.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(key, "7");
			Li.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(key, "8");
			Li.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(key, "9");
			Li.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(val, ".-");
			Mo.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(val, "-...");
			Mo.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(val, "-.-.");
			Mo.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(val, "-..");
			Mo.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(val, ".");
			Mo.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(val, "..-.");
			Mo.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(val, "--.");
			Mo.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(val, "....");
			Mo.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(val, "..");
			Mo.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(val, ".---");
			Mo.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(val, "-.-");
			Mo.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(val, ".-..");
			Mo.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(val, "--");
			Mo.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(val, "-.");
			Mo.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(val, "---");
			Mo.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(val, ".--.");
			Mo.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(val, "--.-");
			Mo.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(val, ".-.");
			Mo.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(val, "...");
			Mo.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(val, "-");
			Mo.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(val, "..-");
			Mo.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(val, "...-");
			Mo.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(val, ".--");
			Mo.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(val, "-..-");
			Mo.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(val, "-.--");
			Mo.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(val, "--..");
			Mo.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(val, "-----");
			Mo.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(val, ".----");
			Mo.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(val, "..---");
			Mo.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(val, "...--");
			Mo.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(val, "....-");
			Mo.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(val, ".....");
			Mo.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(val, "-....");
			Mo.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(val, "--...");
			Mo.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(val, "---..");
			Mo.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put(val, "----.");
			Mo.add(_item);
		}
		
		recyclerview1.setAdapter(new Recyclerview1Adapter(Li));
	}
	
	
	public void _rippleRoundStroke(final View _view, final String _focus, final String _pressed, final double _round, final double _stroke, final String _strokeclr) {
		android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
		GG.setColor(Color.parseColor(_focus));
		GG.setCornerRadius((float)_round);
		GG.setStroke((int) _stroke,
		Color.parseColor("#" + _strokeclr.replace("#", "")));
		android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor(_pressed)}), GG, null);
		_view.setBackground(RE);
	}
	
	public class Recyclerview1Adapter extends RecyclerView.Adapter<Recyclerview1Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@NonNull
		@Override
		public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getLayoutInflater();
			@SuppressLint("InflateParams") View _v = _inflater.inflate(R.layout.cuu, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@SuppressLint("SetTextI18n")
		@Override
		public void onBindViewHolder(ViewHolder _holder, @SuppressLint("RecyclerView") final int _position) {
			View _view = _holder.itemView;
			
			final TextView tx1 = _view.findViewById(R.id.tx1);
			final LinearLayout ln1 = _view.findViewById(R.id.ln1);
			final LinearLayout ln2 = _view.findViewById(R.id.ln2);
			final ImageView img1 = _view.findViewById(R.id.img1);
			final TextView tx3 = _view.findViewById(R.id.tx3);
			final TextView tx2 = _view.findViewById(R.id.tx2);
			
			_rippleRoundStroke(ln1, "#FFFFFF", "#E0E0E0", 0, 0, "#E0E0E0");
			tx1.setVisibility(View.GONE);
			img1.setColorFilter(0xFF000000, PorterDuff.Mode.MULTIPLY);
			tx2.setTextIsSelectable(true);
			tx3.setTextIsSelectable(true);
			if (_position == 0) {
				tx1.setVisibility(View.VISIBLE);
				tx1.setText("Alphabet");
			}
			if (_position == 26) {
				tx1.setVisibility(View.VISIBLE);
				tx1.setText("Numbers");
			}
			tx2.setText(Objects.requireNonNull(Li.get((int) _position).get("Key")).toString());
			tx3.setText(Objects.requireNonNull(Mo.get((int) _position).get("morse")).toString());
			ln1.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View _view) {
					((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", Li.get((int)_position).get("Key").toString().concat("  »»  ".concat(Mo.get((int)_position).get("morse").toString()))));
					Toast.makeText(getApplicationContext(), "Text Copied", Toast.LENGTH_SHORT).show();
					return true;
				}
			});
		}
		
		@Override
		public int getItemCount() {
			return _data.size();
		}
		
		public class ViewHolder extends RecyclerView.ViewHolder {
			public ViewHolder(View v) {
				super(v);
			}
		}
	}
}
