package com.mbmecj.apk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import java.util.HashMap;
import java.util.ArrayList;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ScrollView;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.os.Bundle;
import java.io.InputStream;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import java.util.Timer;
import java.util.TimerTask;
import android.animation.ObjectAnimator;
import android.view.animation.LinearInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.content.ClipData;
import android.content.ClipboardManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;


public class HomeActivity extends  AppCompatActivity  { 
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private double bann = 0;
	private String latest = "";
	private HashMap<String, Object> map = new HashMap<>();
	private HashMap<String, Object> map1 = new HashMap<>();
	private String liburl = "";
	private String package_name = "";
	private String your_version = "";
	
	private ArrayList<HashMap<String, Object>> lsmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> lmap = new ArrayList<>();
	
	private LinearLayout linear7;
	private LinearLayout linear1;
	private LinearLayout linear8;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear9;
	private ImageView imageview1;
	private TextView textview1;
	private ImageView imageview2;
	private ImageView imageview3;
	private ScrollView vscroll1;
	private LinearLayout linear10;
	private LinearLayout linear11;
	private LinearLayout linear4;
	private LinearLayout linear13;
	private LinearLayout linear14;
	private LinearLayout linear15;
	private LinearLayout linear19;
	private TextView textview6;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private LinearLayout linear7first;
	private LinearLayout linear8third;
	private ImageView imageview4;
	private TextView textview2;
	private ImageView imageview6;
	private TextView textview4;
	private LinearLayout linear9second;
	private LinearLayout linear10fourth;
	private ImageView imageview5;
	private TextView textview3;
	private ImageView imageview7;
	private TextView textview5;
	private LinearLayout linear16;
	private ImageView imageview8;
	private TextView textview7;
	private LinearLayout linear17;
	private LinearLayout linear18;
	private ImageView imageview9;
	private TextView textview8;
	private ImageView imageview10;
	private TextView textview9;
	private LinearLayout linear19map;
	private LinearLayout linear20;
	private LinearLayout linear21;
	private ImageView imageview11;
	private TextView textview10;
	private ImageView imageview12;
	private TextView textview11;
	private ImageView imageview13;
	private TextView textview12;
	private WebView webview1;
	
	private Intent intent = new Intent();
	private SharedPreferences u;
	private TimerTask time;
	private ObjectAnimator bb = new ObjectAnimator();
	private DatabaseReference version = _firebase.getReference("version");
	private ChildEventListener _version_child_listener;
	private AlertDialog.Builder dialog;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.home);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview1 = (TextView) findViewById(R.id.textview1);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear13 = (LinearLayout) findViewById(R.id.linear13);
		linear14 = (LinearLayout) findViewById(R.id.linear14);
		linear15 = (LinearLayout) findViewById(R.id.linear15);
		linear19 = (LinearLayout) findViewById(R.id.linear19);
		textview6 = (TextView) findViewById(R.id.textview6);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		linear7first = (LinearLayout) findViewById(R.id.linear7first);
		linear8third = (LinearLayout) findViewById(R.id.linear8third);
		imageview4 = (ImageView) findViewById(R.id.imageview4);
		textview2 = (TextView) findViewById(R.id.textview2);
		imageview6 = (ImageView) findViewById(R.id.imageview6);
		textview4 = (TextView) findViewById(R.id.textview4);
		linear9second = (LinearLayout) findViewById(R.id.linear9second);
		linear10fourth = (LinearLayout) findViewById(R.id.linear10fourth);
		imageview5 = (ImageView) findViewById(R.id.imageview5);
		textview3 = (TextView) findViewById(R.id.textview3);
		imageview7 = (ImageView) findViewById(R.id.imageview7);
		textview5 = (TextView) findViewById(R.id.textview5);
		linear16 = (LinearLayout) findViewById(R.id.linear16);
		imageview8 = (ImageView) findViewById(R.id.imageview8);
		textview7 = (TextView) findViewById(R.id.textview7);
		linear17 = (LinearLayout) findViewById(R.id.linear17);
		linear18 = (LinearLayout) findViewById(R.id.linear18);
		imageview9 = (ImageView) findViewById(R.id.imageview9);
		textview8 = (TextView) findViewById(R.id.textview8);
		imageview10 = (ImageView) findViewById(R.id.imageview10);
		textview9 = (TextView) findViewById(R.id.textview9);
		linear19map = (LinearLayout) findViewById(R.id.linear19map);
		linear20 = (LinearLayout) findViewById(R.id.linear20);
		linear21 = (LinearLayout) findViewById(R.id.linear21);
		imageview11 = (ImageView) findViewById(R.id.imageview11);
		textview10 = (TextView) findViewById(R.id.textview10);
		imageview12 = (ImageView) findViewById(R.id.imageview12);
		textview11 = (TextView) findViewById(R.id.textview11);
		imageview13 = (ImageView) findViewById(R.id.imageview13);
		textview12 = (TextView) findViewById(R.id.textview12);
		webview1 = (WebView) findViewById(R.id.webview1);
		webview1.getSettings().setJavaScriptEnabled(true);
		webview1.getSettings().setSupportZoom(true);
		u = getSharedPreferences("u", Activity.MODE_PRIVATE);
		dialog = new AlertDialog.Builder(this);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Bottom_Sheet_linear();
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				u.edit().putString("s", "https://www.mbm.ac.in").commit();
				intent.setClass(getApplicationContext(), AllwebActivity.class);
				startActivity(intent);
			}
		});
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				u.edit().putString("s", "https://www.mbmalumni.org/").commit();
				intent.setClass(getApplicationContext(), AllwebActivity.class);
				startActivity(intent);
			}
		});
		
		linear7first.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				u.edit().putString("s", "https://mbmec.weebly.com/firstyear.html").commit();
				intent.setClass(getApplicationContext(), AllwebActivity.class);
				startActivity(intent);
			}
		});
		
		linear8third.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				u.edit().putString("s", "https://mbmec.weebly.com/thirdyear.html/").commit();
				intent.setClass(getApplicationContext(), AllwebActivity.class);
				startActivity(intent);
			}
		});
		
		linear9second.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				u.edit().putString("s", "https://mbmec.weebly.com/secondyear.html").commit();
				intent.setClass(getApplicationContext(), AllwebActivity.class);
				startActivity(intent);
			}
		});
		
		linear10fourth.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				u.edit().putString("s", "https://mbmec.weebly.com/fourthyear.html/").commit();
				intent.setClass(getApplicationContext(), AllwebActivity.class);
				startActivity(intent);
			}
		});
		
		linear16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				u.edit().putString("s", "https://etrainfreecourses.weebly.com/").commit();
				intent.setClass(getApplicationContext(), AllwebActivity.class);
				startActivity(intent);
			}
		});
		
		linear17.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				u.edit().putString("s", "https://ndl.iitkgp.ac.in/homestudy/engineering").commit();
				intent.setClass(getApplicationContext(), AllwebActivity.class);
				startActivity(intent);
			}
		});
		
		linear18.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				u.edit().putString("s", "https://www.vlab.co.in/").commit();
				intent.setClass(getApplicationContext(), AllwebActivity.class);
				startActivity(intent);
			}
		});
		
		linear19map.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				u.edit().putString("s", "https://www.google.com/maps/d/viewer?mid=17iB1Cu1xtUXpjX7y8FTexYbGn92KdmAm&ll=26.26715087257309%2C73.02899095283236&z=16").commit();
				intent.setClass(getApplicationContext(), AllwebActivity.class);
				startActivity(intent);
			}
		});
		
		linear20.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				u.edit().putString("s", "https://sites.google.com/view/teqipmbmj/home?authuser=0").commit();
				intent.setClass(getApplicationContext(), AllwebActivity.class);
				startActivity(intent);
			}
		});
		
		linear21.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				u.edit().putString("s", "https://nssmbm.weebly.com/").commit();
				intent.setClass(getApplicationContext(), AllwebActivity.class);
				startActivity(intent);
			}
		});
		
		//webviewOnProgressChanged
		webview1.setWebChromeClient(new WebChromeClient() {
				@Override public void onProgressChanged(WebView view, int _newProgress) {
					
				}
		});
		
		//OnDownloadStarted
		webview1.setDownloadListener(new DownloadListener() {
			public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
				DownloadManager.Request webview1a = new DownloadManager.Request(Uri.parse(url));
				String webview1b = CookieManager.getInstance().getCookie(url);
				webview1a.addRequestHeader("cookie", webview1b);
				webview1a.addRequestHeader("User-Agent", userAgent);
				webview1a.setDescription("Downloading file...");
				webview1a.setTitle(URLUtil.guessFileName(url, contentDisposition, mimetype));
				webview1a.allowScanningByMediaScanner(); webview1a.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED); webview1a.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, URLUtil.guessFileName(url, contentDisposition, mimetype));
				
				DownloadManager webview1c = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
				webview1c.enqueue(webview1a);
				showMessage("Downloading File....");
				BroadcastReceiver onComplete = new BroadcastReceiver() {
					public void onReceive(Context ctxt, Intent intent) {
						showMessage("Download Complete!");
						unregisterReceiver(this);
						
					}};
				registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
			}
		});
		
		//OnTouch
		webview1.setOnTouchListener(new View.OnTouchListener(){
				@Override
				public boolean onTouch(View v, MotionEvent event){
						int ev = event.getAction();
						switch (ev) {
								case MotionEvent.ACTION_DOWN:
								
								 
								
								break;
								case MotionEvent.ACTION_UP:
								
								 
								
								break;
						} return true;
				}
		});
		
		webview1.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
				final String _url = _param2;
				
				super.onPageStarted(_param1, _param2, _param3);
			}
			
			@Override
			public void onPageFinished(WebView _param1, String _param2) {
				final String _url = _param2;
				
				super.onPageFinished(_param1, _param2);
			}
		});
		
		_version_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				version.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						lsmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								lsmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						latest = lsmap.get((int)0).get("v").toString();
						if (Double.parseDouble(latest) > Double.parseDouble(your_version)) {
							dialog.setTitle("New Update Available");
							dialog.setMessage("Please Update MBM E-LEARNING app");
							dialog.setPositiveButton("update", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									intent.setAction(Intent.ACTION_VIEW);
									intent.setData(Uri.parse("https://drive.google.com/folderview?id=1qJdJsTNPjC5XRFX-twKG6cisRdYJ_FSM"));
									startActivity(intent);
								}
							});
							dialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									
								}
							});
							dialog.create().show();
						}
						else {
							
						}
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		version.addChildEventListener(_version_child_listener);
	}
	
	private void initializeLogic() {
		webview1.loadUrl("https://mbmec.weebly.com/about-mbm.html");
		time = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						bann++;
						if (bann == 1) {
							imageview2.setVisibility(View.GONE);
							imageview3.setVisibility(View.VISIBLE);
							_SlideTarget(imageview3, 300);
						}
						else {
							if (bann == 2) {
								imageview2.setVisibility(View.VISIBLE);
								imageview3.setVisibility(View.GONE);
								bann = 0;
								_SlideTarget(imageview2, 300);
							}
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(time, (int)(0), (int)(3000));
		_radius_to(linear7first, 10, 10, "#ffffff");
		_radius_to(linear8third, 10, 10, "#ffffff");
		_radius_to(linear9second, 10, 10, "#ffffff");
		_radius_to(linear10fourth, 10, 10, "#ffffff");
		_radius_to(linear16, 10, 10, "#ffffff");
		_radius_to(linear17, 10, 10, "#ffffff");
		_radius_to(linear18, 10, 10, "#ffffff");
		_radius_to(linear19map, 10, 10, "#ffffff");
		_radius_to(linear20, 10, 10, "#ffffff");
		_radius_to(linear21, 10, 10, "#ffffff");
		package_name = "com.mbmecj.apk";
		try {
			android.content.pm.PackageInfo pinfo = getPackageManager().getPackageInfo( package_name, android.content.pm.PackageManager.GET_ACTIVITIES);
			your_version = pinfo.versionName; }
		catch (Exception e){ showMessage(e.toString()); }
		DatabaseReference rootRef = _firebase.getReference(); rootRef.child("version").addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot snapshot) {
				if (snapshot.exists()) { } else {
					map1 = new HashMap<>();
					map1.put("v", your_version);
					version.child("app").updateChildren(map1);
					map1.clear();
				} }
			@Override
			public void onCancelled(DatabaseError _error) { } });
		linear16.setOnLongClickListener(new View.OnLongClickListener() {
							@Override
							public boolean onLongClick(View _view) {
									((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", "https://etrainfreecourses.weebly.com/"));
				SketchwareUtil.showMessage(getApplicationContext(), "Etrain free Courses site link copy to clipbord");
									return true;
							}
					});
		linear20.setOnLongClickListener(new View.OnLongClickListener() {
							@Override
							public boolean onLongClick(View _view) {
									((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", "https://sites.google.com/view/teqipmbmj/home?authuser=0"));
				SketchwareUtil.showMessage(getApplicationContext(), "Teqipmbm site link copy to clipbord");
									return true;
							}
					});
		linear21.setOnLongClickListener(new View.OnLongClickListener() {
							@Override
							public boolean onLongClick(View _view) {
									((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", "https://nssmbm.weebly.com/"));
				SketchwareUtil.showMessage(getApplicationContext(), "nssmbm site link copy to clipbord");
									return true;
							}
					});
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	public void _radius_to (final View _view, final double _radius, final double _shadow, final String _color) {
		android.graphics.drawable.GradientDrawable ab = new android.graphics.drawable.GradientDrawable();
		
		ab.setColor(Color.parseColor(_color));
		ab.setCornerRadius((float) _radius);
		_view.setElevation((float) _shadow);
		_view.setBackground(ab);
	}
	
	
	public void _SlideTarget (final View _view, final double _durasi) {
		bb.setTarget(_view);
		bb.setPropertyName("alpha");
		bb.setFloatValues((float)(0), (float)(1));
		bb.setDuration((int)(_durasi));
		bb.setRepeatMode(ValueAnimator.REVERSE);
		bb.setRepeatCount((int)(0));
		bb.setInterpolator(new LinearInterpolator());
		bb.start();
	}
	
	
	public void _Bottom_Sheet_linear () {
		/*Code Created By Aauraparti*/
		final com.google.android.material.bottomsheet.BottomSheetDialog bs_base = new com.google.android.material.bottomsheet.BottomSheetDialog(HomeActivity.this);
		View layBase = getLayoutInflater().inflate(R.layout.menu, null);
		bs_base.setContentView(layBase);
		bs_base.show();
		/*part-1*/
		LinearLayout copy = layBase.findViewById(R.id.linear4);
		copy.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick (View v){
				
				
				intent.setClass(getApplicationContext(), MetarialActivity.class);
				startActivity(intent);
				
				
				bs_base.dismiss();
			}
		});
		/*part-2*/
		LinearLayout share = layBase.findViewById(R.id.linear6);
		share.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick (View v){
				
				
				u.edit().putString("s", "https://jnvuiums.in/(S(orp0zdehz5darhg0yoy0kcsb))/Results/ExamResult.aspx").commit();
				intent.setClass(getApplicationContext(), AllwebActivity.class);
				startActivity(intent);
				
				
				bs_base.dismiss();
			}
		});
		/*part-3*/
		LinearLayout report = layBase.findViewById(R.id.linear8);
		report.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick (View v){
				
				
				u.edit().putString("s", "https://jnvuiums.in/(S(llk4t5ufhw53cjepx2rkwrtz))/Exammain.aspx?id=1").commit();
				intent.setClass(getApplicationContext(), AllwebActivity.class);
				startActivity(intent);
				
				
				bs_base.dismiss();
			}
		});
		/*part-4*/
		LinearLayout aa = layBase.findViewById(R.id.linear10);
		aa.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick (View v){
				
				
				intent.setClass(getApplicationContext(), GalleryActivity.class);
				startActivity(intent);
				
				
				bs_base.dismiss();
			}
		});
		/*part-4*/
		LinearLayout aa1 = layBase.findViewById(R.id.linear12);
		aa1.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick (View v){
				
				
				u.edit().putString("s", "https://mbmec.weebly.com/about-mbm.html").commit();
				intent.setClass(getApplicationContext(), AllwebActivity.class);
				startActivity(intent);
				
				
				bs_base.dismiss();
			}
		});
		/*part-4*/
		LinearLayout aa2 = layBase.findViewById(R.id.linear14);
		aa2.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick (View v){
				
				
				intent.setClass(getApplicationContext(), SettingActivity.class);
				startActivity(intent);
				
				
				bs_base.dismiss();
			}
		});
	}
	
	
	public void _Send (final Intent _IntentName, final String _to, final String _subject, final String _text) {
		_IntentName.setAction(Intent.ACTION_VIEW);
		_IntentName.setData(Uri.parse(_to));
		startActivity(_IntentName);
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}