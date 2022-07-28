package com.EnceptCode.MorseCode;

import static android.hardware.Camera.Parameters.FLASH_MODE_AUTO;
import static android.hardware.Camera.Parameters.FLASH_MODE_ON;
import static android.hardware.Camera.Parameters.FLASH_MODE_TORCH;

import android.Manifest;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.SurfaceTexture;
import android.graphics.Typeface;
import android.hardware.Camera;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements Camera.AutoFocusCallback {
	
	public static Camera camera = null;
	private double md5 = 0;
	private double sou = 0;
	private String vars = "";
	private double status = 0;
	private boolean visibilityCheck = false;
	private String ss = "";
	private String Tx = "";
	
	private ArrayList<String> k = new ArrayList<>();
	
	private LinearLayout ln_top;
	private ScrollView vs1;
	private TextView text;
	private ImageView im_info;
	private ImageView im_menu;
	private LinearLayout linear;
	private CardView frame1;
	private ImageView im_switch;
	private CardView frame2;
	private LinearLayout ln4x;
	private LinearLayout l_more;
	private LinearLayout ln5;
	private LinearLayout ln1;
	private LinearLayout ln6;
	private LinearLayout ln3;
	private TextView text2;
	private EditText input;
	private LinearLayout ln8;
	private ImageView im_del;
	private LinearLayout ln2;
	private LinearLayout ln10;
	private ScrollView vs2;
	private LinearLayout ln9;
	private TextView text3;
	private TextView outp;
	private LinearLayout ln7;
	private ImageView im_copy;
	private ImageView im_play;
	private ImageView im_flash;
	private Button bt_dot;
	private Button bt_dash;
	private ImageView im_spac;
	
	private MediaPlayer mediaPlayer;
	private Intent io = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		
		MobileAds.initialize(this);
		
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		ln_top = findViewById(R.id.ln_top);
		vs1 = findViewById(R.id.vs1);
		text = findViewById(R.id.text);
		im_info = findViewById(R.id.im_info);
		im_menu = findViewById(R.id.im_menu);
		linear = findViewById(R.id.linear);
		frame1 = findViewById(R.id.frame1);
		im_switch = findViewById(R.id.im_switch);
		frame2 = findViewById(R.id.frame2);
		ln4x = findViewById(R.id.ln4x);
		l_more = findViewById(R.id.l_more);
		ln5 = findViewById(R.id.ln5);
		ln1 = findViewById(R.id.ln1);
		ln6 = findViewById(R.id.ln6);
		ln3 = findViewById(R.id.ln3);
		text2 = findViewById(R.id.text2);
		input = findViewById(R.id.input);
		ln8 = findViewById(R.id.ln8);
		im_del = findViewById(R.id.im_del);
		ln2 = findViewById(R.id.ln2);
		ln10 = findViewById(R.id.ln10);
		vs2 = findViewById(R.id.vs2);
		ln9 = findViewById(R.id.ln9);
		text3 = findViewById(R.id.text3);
		outp = findViewById(R.id.outp);
		ln7 = findViewById(R.id.ln7);
		im_copy = findViewById(R.id.im_copy);
		im_play = findViewById(R.id.im_play);
		im_flash = findViewById(R.id.im_flash);
		bt_dot = findViewById(R.id.bt_dot);
		bt_dash = findViewById(R.id.bt_dash);
		im_spac = findViewById(R.id.im_spac);
		
		im_info.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				io.setClass(getApplicationContext(), MorseInfoActivity.class);
				startActivity(io);
			}
		});
		
		im_menu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Popup(im_menu);
			}
		});
		
		im_switch.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
				final AlphaAnimation faden = new AlphaAnimation(1.0f,0.0f);
				final AlphaAnimation fadeut = new AlphaAnimation(0.0f,1.0f);
				
				frame1.startAnimation(faden);
				frame1.startAnimation(fadeut);
				faden.setDuration(200);
				faden.setFillAfter(true);
				fadeut.setDuration(200);
				fadeut.setFillAfter(true);
				fadeut.setStartOffset(10+faden.getStartOffset());
				
				final AlphaAnimation fadeIn = new AlphaAnimation(1.0f,0.0f);
				final AlphaAnimation fadeOut = new AlphaAnimation(0.0f,1.0f);
				
				frame2.startAnimation(fadeIn);
				frame2.startAnimation(fadeOut);
				fadeIn.setDuration(200);
				fadeIn.setFillAfter(true);
				fadeOut.setDuration(200);
				fadeOut.setFillAfter(true);
				fadeOut.setStartOffset(10+fadeIn.getStartOffset());
				
				final AlphaAnimation fademore = new AlphaAnimation(1.0f,0.0f);
				final AlphaAnimation fadem = new AlphaAnimation(0.0f,1.0f);
				
				frame2.startAnimation(fademore);
				frame2.startAnimation(fadem);
				fademore.setDuration(200);
				fademore.setFillAfter(true);
				fadem.setDuration(200);
				fadem.setFillAfter(true);
				fadem.setStartOffset(10+fademore.getStartOffset());
				input.setText("");
				if (status == 0) {
					
					RotateAnimation rotateAnimation = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f); rotateAnimation.setInterpolator(new LinearInterpolator()); rotateAnimation.setDuration(300); im_switch.startAnimation(rotateAnimation);
					status = 1;
					l_more.setVisibility(View.VISIBLE);
					text2.setText("Morse Code");
					text3.setText("input Text");
					text2.setTextColor(0xFF1565C0);
					text3.setTextColor(0xFF000000);
				}
				else {
					if (status == 1) {
						
						RotateAnimation rotateAnimation = new RotateAnimation(0, -180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f); rotateAnimation.setInterpolator(new LinearInterpolator()); rotateAnimation.setDuration(300); im_switch.startAnimation(rotateAnimation);
						status = 0;
						l_more.setVisibility(View.INVISIBLE);
						text2.setText("input Text");
						text3.setText("Morse Code");
						text2.setTextColor(0xFF000000);
						text3.setTextColor(0xFF1565C0);
					}
				}
			}
		});
		
		input.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (status == 0) {
					outp.setText("");
					String text = input.getText().toString();
					
					String[] letters = text.split("");
					
					for (String letter : letters) {
						
						outp.append(TxtEncode(letter) + " ");
						
					}
				}
				else {
					outp.setText("");
					String text = input.getText().toString();
					
					String[] letters = text.split("\\s");
					
					for (String decoder : letters) {
						
						outp.append(decode(decoder));
						
					}
				}
				if (input.getText().toString().trim().equals("")) {
					ln8.setVisibility(View.INVISIBLE);
				}
				else {
					ln8.setVisibility(View.VISIBLE);
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		im_del.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				input.setText("");
				return true;
			}
		});
		
		im_del.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (input.getText().toString().length() == 0)
				return;
				 input.setText(input.getText().toString().substring(0, input.getText().toString().length() - 1));
				 input.setSelection(input.getText().toString().length());
			}
		});
		
		im_copy.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!input.getText().toString().trim().equals("")) {
					((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", outp.getText().toString()));
					Toast.makeText(getApplicationContext(), "Copied", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		im_play.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!input.getText().toString().trim().equals("")) {
					if (status == 0) {
						
						if (!TextUtils.isEmpty(outp.getText().toString())) {
							
							String[] something = TextUtils.split(outp.getText().toString().trim().replaceAll("\\s+", ""), "");
							
							for (String s : something) {
							}
							
							int len = something.length;
							final int[] tracks = new int[len];
							int counter = 0;
							for (String s : something) {
								if (s.equals(".")) {
									tracks[counter] = R.raw.dot;
									counter++;
									
								} else if (s.equals("-")) {
									tracks[counter] = R.raw.dash;
									counter++;
								}
							}
							
							final int[] trackcounter = {0};
							MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), tracks[trackcounter[0]]);
							
							mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
								
								@Override
								public void onCompletion(MediaPlayer mp) {
									mp.release();
									if (trackcounter[0] < tracks.length - 3) {
										trackcounter[0]++;
										mp = MediaPlayer.create(getApplicationContext(), tracks[trackcounter[0]]);
										
										mp.setOnCompletionListener(this);
										mp.start();
									}
								}
							});
							mediaPlayer.start();
						}
						
					} else {
						if (!TextUtils.isEmpty(input.getText().toString())) {
							String[] something = TextUtils.split(input.getText().toString().trim().replaceAll("\\s+", ""), "");
							
							for (String s : something) {
							}
							
							int len = something.length;
							final int[] tracks = new int[len];
							int counter = 0;
							for (String s : something) {
								if (s.equals(".")) {
									
									tracks[counter] = R.raw.dot;
									counter++;
									
								} else if (s.equals("-")) {
									tracks[counter] = R.raw.dash;
									counter++;
								}
							}
							
							final int[] trackcounter = {0};
							MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), tracks[trackcounter[0]]);
							
							mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
								
								@Override
								public void onCompletion(MediaPlayer mp) {
									mp.release();
									if (trackcounter[0] < tracks.length - 3) {
										trackcounter[0]++;
										mp = MediaPlayer.create(getApplicationContext(), tracks[trackcounter[0]]);
										
										mp.setOnCompletionListener(this);
										mp.start();
									}
								}
							});
							mediaPlayer.start();
						}
					}
				}
			}
		});
		
		im_flash.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!input.getText().toString().trim().equals("")) {
					int hasCameraPermission = 0;
					 if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
						hasCameraPermission = checkSelfPermission(Manifest.permission.CAMERA);
					}
					
					if (hasCameraPermission != PackageManager.PERMISSION_GRANTED) {
						
						Toast.makeText(getApplicationContext(), "Camera Permission Denied, Can't Use Flash", Toast.LENGTH_SHORT).show();
						return;
					}
					
					if (status == 0) {
						
						if (!TextUtils.isEmpty(outp.getText().toString())) {
							
							String[] str = TextUtils.split(outp.getText().toString().trim().replaceAll("\\s+", ""), "");
							
							for (String K : str) {
							}
							
							int len = str.length;
							int currentCounter = 0;
							
							if (!Build.MANUFACTURER.equals("HUAWEI")) {
								camera = Camera.open();
							}
							for (String K : str) {
								
								if (K.equals(".")) {
									
									turnOn();
									SystemClock.sleep(200);
									turnOff();
									
								} else if (K.equals("-")) {
									turnOn();
									SystemClock.sleep(600);
									turnOff();
									
								}
							}
							
							camera.release();
							camera = null;
							
						}
					} else {
						
						if (!TextUtils.isEmpty(input.getText().toString())) {
							
							try {
								
								String[] str2 = TextUtils.split(input.getText().toString().trim().replaceAll("\\s+", ""), "");
								
								for (String D : str2) {
								}
								
								int len = str2.length;
								int currentcounter = 0;
								
								for (String D : str2) {
									
									if (D.equals(".")) {
										
										turnOn();
										SystemClock.sleep(200);
										turnOff();
										
									} else if (D.equals("-")) {
										
										turnOn();
										SystemClock.sleep(600);
										turnOff();
										
									}
								}
								camera.release();
								camera = null;
								
							} catch(Exception e){
								ss = e.getMessage();
								Toast.makeText(getApplicationContext(), "an error occurred can't open flash", Toast.LENGTH_SHORT).show();
							}
							
						}
					}
				}
			}
		});
		
		bt_dot.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (status == 1) {
					input.append(".");
				}
			}
		});
		
		bt_dash.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (status == 1) {
					input.append("-");
				}
			}
		});
		
		im_spac.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (status == 1) {
					input.append(" ");
				}
			}
		});
	}
	
	private void initializeLogic() {
		ln_top.setElevation(10f);
		status = 0;
		visibilityCheck = false;
		_des();
		com.google.android.gms.ads.MobileAds.initialize(MainActivity.this, new com.google.android.gms.ads.initialization.OnInitializationCompleteListener() {
			@Override
			public void onInitializationComplete(com.google.android.gms.ads.initialization.InitializationStatus initializationStatus) {
				 }
		});

		com.google.android.gms.ads.AdView ad = new com.google.android.gms.ads.AdView(MainActivity.this);
		
		ad.setAdSize(com.google.android.gms.ads.AdSize.BANNER);
		
		ad.setAdUnitId("ca-app-pub-6910652682395372/8818939855");
		ad.loadAd(new com.google.android.gms.ads.AdRequest.Builder().build());
		
		ln5.addView(ad);
		
	}
	
	@Override
	public void onStart() {
		super.onStart();
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			
			int hasCameraPermission = checkSelfPermission(Manifest.permission.CAMERA);
			
			List<String> permissions = new ArrayList<>();
			
			if (hasCameraPermission != PackageManager.PERMISSION_GRANTED) {
				
				permissions.add(Manifest.permission.CAMERA);
				
			}
			
			if (!permissions.isEmpty()) {
				
				requestPermissions(permissions.toArray(new String[0]), 111);
				
			}
		}
	}
	

	public void _gd(final View _view, final String _c, final String _sc, final double _r) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		
		gd.setColor(Color.parseColor(_c));
		gd.setCornerRadius((float)_r);
		gd.setStroke(2, Color.parseColor(_sc));
		
		_view.setBackground(gd);
	}
	
	
	public void _Ripple(final View _view) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			android.graphics.drawable.RippleDrawable ripdr = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#0289cd")}), new android.graphics.drawable.ColorDrawable(Color.WHITE), null);
			
			_view.setBackground(ripdr);
		}
	}
	
	
	public void _rpl(final View _view) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			android.graphics.drawable.RippleDrawable ripdr = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#0289cd")}), new android.graphics.drawable.ColorDrawable(Color.parseColor("#2196F3")), null);
			
			_view.setBackground(ripdr);
		}
	}
	
	
	public void _des() {
		ln8.setVisibility(View.INVISIBLE);
		l_more.setVisibility(View.INVISIBLE);
		_gd(ln7, "#00000000", "#E0E0E0", 360);
		_rippleRoundStroke(bt_dot, "#00000000", "#BDBDBD", 360, 1, "#BDBDBD");
		_rippleRoundStroke(bt_dash, "#00000000", "#BDBDBD", 360, 1, "#BDBDBD");
		_rippleRoundStroke(im_spac, "#00000000", "#BDBDBD", 360, 1, "#BDBDBD");
		im_copy.setColorFilter(0xFF151E27, PorterDuff.Mode.MULTIPLY);
		im_del.setColorFilter(0xFF151E27, PorterDuff.Mode.MULTIPLY);
		im_switch.setColorFilter(0xFF151E27, PorterDuff.Mode.MULTIPLY);
		im_flash.setColorFilter(0xFF151E27, PorterDuff.Mode.MULTIPLY);
		im_play.setColorFilter(0xFF151E27, PorterDuff.Mode.MULTIPLY);
		im_spac.setColorFilter(0xFF151E27, PorterDuff.Mode.MULTIPLY);
		text.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/fon.ttf"), Typeface.BOLD);
		outp.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/fon.ttf"), Typeface.BOLD);
		text2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/fon.ttf"), Typeface.BOLD);
		text3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/fon.ttf"), Typeface.BOLD);
		input.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/fon.ttf"), Typeface.BOLD);
		bt_dot.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/fon.ttf"), Typeface.BOLD);
		bt_dash.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/fon.ttf"), Typeface.BOLD);
	}
	
	
	static String TxtEncode(String txt) {

        txt = txt.toLowerCase();
        switch (txt) {
            case "a":
                return ".-";
            case "b":
                return "-...";
            case "c":
                return "-.-.";
            case "d":
                return "-..";
            case "e":
                return ".";
            case "f":
                return "..-.";
            case "g":
                return "--.";
            case "h":
                return "....";
            case "i":
                return "..";
            case "j":
                return ".---";
            case "k":
                return "-.-";
            case "l":
                return ".-..";
            case "m":
                return "--";
            case "n":
                return "-.";
            case "o":
                return "---";
            case "p":
                return ".--.";
            case "q":
                return "--.-";
            case "r":
                return ".-.";
            case "s":
                return "...";
            case "t":
                return "-";
            case "u":
                return "..-";
            case "v":
                return "...-";
            case "w":
                return ".--";
            case "x":
                return "-..-";
            case "y":
                return "-.--";
            case "  ":
                return " ";
            case "z":
                return "--..";
            case " ":
                return " ";
            case "0":
                return "-----";
            case "1":
                return ".----";
            case "2":
                return "..---";
            case "3":
                return "...--";
            case "4":
                return "....-";
            case "5":
                return ".....";
            case "6":
                return "-....";
            case "7":
                return "--...";
            case "8":
                return "---..";
            case "9":
                return "----.";
        }
        return "";
		
	}
	
	
	static String decode(String decoder) {
        switch (decoder) {
            case ".-":
                return "a";
            case "-...":
                return "b";
            case "-.-.":
                return "c";
            case "-..":
                return "d";
            case ".":
                return "e";
            case "..-.":
                return "f";
            case "--.":
                return "g";
            case "....":
                return "h";
            case "..":
                return "i";
            case ".---":
                return "j";
            case "-.-":
                return "k";
            case ".-..":
                return "l";
            case "--":
                return "m";
            case "-.":
                return "n";
            case "---":
                return "o";
            case ".--.":
                return "p";
            case "--.-":
                return "q";
            case ".-.":
                return "r";
            case "...":
                return "s";
            case "-":
                return "t";
            case "..-":
                return "u";
            case "...-":
                return "v";
            case ".--":
                return "w";
            case "-..-":
                return "x";
            case "-.--":
                return "y";
            case "--..":
                return "z";
            case "   ":
                return " ";
            case "-----":
                return "0";
            case ".----":
                return "1";
            case "..---":
                return "2";
            case "...--":
                return "3";
            case "....-":
                return "4";
            case ".....":
                return "5";
            case "-....":
                return "6";
            case "--...":
                return "7";
            case "---..":
                return "8";
            case "----.":
                return "9";

        }

        return "";
		
	}
	
	
	 @Override
public void onAutoFocus(boolean b, Camera camera) { }

public void turnOn() {
        try {
            if (android.os.Build.MANUFACTURER.equals("HUAWEI")) {
                camera = Camera.open();
            }

            Log.d("cameraMorseCheck","turning camera on at " + System.currentTimeMillis());

            Camera.Parameters parameters = camera.getParameters();
            parameters.setFlashMode(getFlashOnParameter());
            camera.setParameters(parameters);

            camera.setPreviewTexture(new SurfaceTexture(0));

            camera.startPreview();
            camera.autoFocus(this);

        } catch (Exception e) {
        }
    }

    private String getFlashOnParameter() {
        List<String> flashModes = camera.getParameters().getSupportedFlashModes();

        if (flashModes.contains(FLASH_MODE_TORCH)) {
            return FLASH_MODE_TORCH;
        } else if (flashModes.contains(FLASH_MODE_ON)) {
            return FLASH_MODE_ON;
        } else if (flashModes.contains(FLASH_MODE_AUTO)) {
            return FLASH_MODE_AUTO;
        }
        throw new RuntimeException();
    }

    public void turnOff() {
        try {

            if (android.os.Build.MANUFACTURER.equals("HUAWEI")){
                camera.release();
                SystemClock.sleep(100);
            }
            else {
                camera.stopPreview();
            }
            Log.d("cameraMorseCheck","turning camera off at " + System.currentTimeMillis());

        } catch (Exception e) {
            Log.d("cameraMorseCheck","exception caught: " + e.getMessage());
        }

		
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
	
	
	public void _Popup(final View _view) {
		PopupMenu popup = new PopupMenu(MainActivity.this, _view);
		Menu menu = popup.getMenu();
		menu.add("Morse Code");
		menu.add("Privacy Policy");
		menu.add("About App");
		popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
			@Override
			public boolean onMenuItemClick(MenuItem item){
				switch (item.getTitle().toString()){
					case "Morse Code":
					_OpenUrl("https://en.m.wikipedia.org/wiki/Morse_code");
					break;
					case "Privacy Policy":
					_OpenUrl("https://privacy.encept.co/morse_code/privacy_policy.php");
					break;
					case "About App":
					io.setClass(getApplicationContext(), AboutActivity.class);
					startActivity(io);
					break;
				}
				return true;
			}
		});
		popup.show();
	}
	
	
	public void _OpenUrl(final String _string) {
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
	
	
	{
	}
	
}
