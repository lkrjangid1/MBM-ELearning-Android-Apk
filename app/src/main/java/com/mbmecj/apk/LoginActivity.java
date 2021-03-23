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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import android.os.Bundle;
import java.io.InputStream;
import android.content.Intent;
import android.net.Uri;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import java.util.Timer;
import java.util.TimerTask;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;


public class LoginActivity extends  AppCompatActivity  { 
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> map = new HashMap<>();
	private String Text = "";
	
	private LinearLayout linear1;
	private LinearLayout linear3login;
	private LinearLayout linear10;
	private LinearLayout linear9;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private LinearLayout linear2;
	private LinearLayout linear11;
	private TextView textview3;
	private TextView textview4;
	private TextView textview5;
	private TextView textview6;
	private LinearLayout linear3signin;
	private LinearLayout linear6signup;
	private LinearLayout linear7fp;
	private LinearLayout linear6;
	private EditText edittext5;
	private EditText edittext6;
	private Button button3sign;
	private LinearLayout linear7;
	private TextView textview8;
	private EditText edittext7;
	private EditText edittext8;
	private EditText edittext9;
	private Button button4;
	private LinearLayout linear8;
	private EditText edittext10;
	private Button button5fp;
	private TextView textview7;
	
	private FirebaseAuth fauth;
	private OnCompleteListener<Void> fauth_updateEmailListener;
	private OnCompleteListener<Void> fauth_updatePasswordListener;
	private OnCompleteListener<Void> fauth_emailVerificationSentListener;
	private OnCompleteListener<Void> fauth_deleteUserListener;
	private OnCompleteListener<Void> fauth_updateProfileListener;
	private OnCompleteListener<AuthResult> fauth_phoneAuthListener;
	private OnCompleteListener<AuthResult> fauth_googleSignInListener;
	private OnCompleteListener<AuthResult> _fauth_create_user_listener;
	private OnCompleteListener<AuthResult> _fauth_sign_in_listener;
	private OnCompleteListener<Void> _fauth_reset_password_listener;
	private Intent intent = new Intent();
	private DatabaseReference username = _firebase.getReference("username");
	private ChildEventListener _username_child_listener;
	private TimerTask t;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.login);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear3login = (LinearLayout) findViewById(R.id.linear3login);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		textview3 = (TextView) findViewById(R.id.textview3);
		textview4 = (TextView) findViewById(R.id.textview4);
		textview5 = (TextView) findViewById(R.id.textview5);
		textview6 = (TextView) findViewById(R.id.textview6);
		linear3signin = (LinearLayout) findViewById(R.id.linear3signin);
		linear6signup = (LinearLayout) findViewById(R.id.linear6signup);
		linear7fp = (LinearLayout) findViewById(R.id.linear7fp);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		edittext5 = (EditText) findViewById(R.id.edittext5);
		edittext6 = (EditText) findViewById(R.id.edittext6);
		button3sign = (Button) findViewById(R.id.button3sign);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		textview8 = (TextView) findViewById(R.id.textview8);
		edittext7 = (EditText) findViewById(R.id.edittext7);
		edittext8 = (EditText) findViewById(R.id.edittext8);
		edittext9 = (EditText) findViewById(R.id.edittext9);
		button4 = (Button) findViewById(R.id.button4);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		edittext10 = (EditText) findViewById(R.id.edittext10);
		button5fp = (Button) findViewById(R.id.button5fp);
		textview7 = (TextView) findViewById(R.id.textview7);
		fauth = FirebaseAuth.getInstance();
		
		textview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear3signin.setVisibility(View.VISIBLE);
				linear6signup.setVisibility(View.GONE);
				linear7fp.setVisibility(View.GONE);
				textview4.setTextColor(0xFF90A4AE);
				textview5.setTextColor(0xFF000000);
				textview6.setTextColor(0xFF000000);
			}
		});
		
		textview5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear3signin.setVisibility(View.GONE);
				linear6signup.setVisibility(View.VISIBLE);
				linear7fp.setVisibility(View.GONE);
				textview5.setTextColor(0xFF90A4AE);
				textview4.setTextColor(0xFF000000);
				textview6.setTextColor(0xFF000000);
			}
		});
		
		textview6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear3signin.setVisibility(View.GONE);
				linear6signup.setVisibility(View.GONE);
				linear7fp.setVisibility(View.VISIBLE);
				textview6.setTextColor(0xFF90A4AE);
				textview4.setTextColor(0xFF000000);
				textview5.setTextColor(0xFF000000);
			}
		});
		
		button3sign.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext5.getText().toString().equals("") && edittext6.getText().toString().equals("")) {
					_ShowSnackbar("input your details", "OK", 3);
				}
				else {
					fauth.signInWithEmailAndPassword(edittext5.getText().toString(), edittext6.getText().toString()).addOnCompleteListener(LoginActivity.this, _fauth_sign_in_listener);
				}
			}
		});
		
		textview8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), TncActivity.class);
				startActivity(intent);
			}
		});
		
		button4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext7.getText().toString().equals("") && (edittext8.getText().toString().equals("") && edittext9.getText().toString().equals(""))) {
					_ShowSnackbar("input your details", "OK", 3);
				}
				else {
					fauth.createUserWithEmailAndPassword(edittext8.getText().toString(), edittext9.getText().toString()).addOnCompleteListener(LoginActivity.this, _fauth_create_user_listener);
				}
			}
		});
		
		button5fp.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext10.getText().toString().equals("")) {
					_ShowSnackbar("input your email", "OK", 3);
				}
				else {
					fauth.sendPasswordResetEmail(edittext10.getText().toString()).addOnCompleteListener(_fauth_reset_password_listener);
				}
			}
		});
		
		_username_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
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
		username.addChildEventListener(_username_child_listener);
		
		fauth_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task){
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		fauth_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task){
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_fauth_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				if (_success) {
					map = new HashMap<>();
					map.put("email", edittext8.getText().toString());
					map.put("name", edittext7.getText().toString());
					username.push().updateChildren(map);
					map.clear();
					intent.setAction(Intent.ACTION_VIEW);
					intent.setClass(getApplicationContext(), HomeActivity.class);
					startActivity(intent);
					SketchwareUtil.showMessage(getApplicationContext(), "Signup Successfully");
				}
				else {
					_ShowSnackbar(_errorMessage, "OK", 3);
				}
			}
		};
		
		_fauth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				if (_success) {
					intent.setAction(Intent.ACTION_VIEW);
					intent.setClass(getApplicationContext(), HomeActivity.class);
					startActivity(intent);
					SketchwareUtil.showMessage(getApplicationContext(), "Signin Successfully");
				}
				else {
					_ShowSnackbar(_errorMessage, "OK", 3);
				}
			}
		};
		
		_fauth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				if (_success) {
					_ShowSnackbar("Reset password email sent successfully", "OK", 3);
				}
				else {
					_ShowSnackbar("Something went wrong !", "OK", 3);
				}
			}
		};
	}
	
	private void initializeLogic() {
		textview4.setTextColor(0xFF90A4AE);
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
	
	
	public void _ShowSnackbar (final String _message, final String _buttonText, final double _duration) {
		String ButtonText = "OK";
		if (!_buttonText.equals("")) {
			ButtonText = _buttonText;
		}
		ViewGroup parentLayout = (ViewGroup) ((ViewGroup) this .findViewById(android.R.id.content)).getChildAt(0);
		
		com.google.android.material.snackbar.Snackbar snackbar =
		com.google.android.material.snackbar.Snackbar.make(parentLayout, _message, com.google.android.material.snackbar.Snackbar.LENGTH_INDEFINITE).setAction(ButtonText, new View.OnClickListener() {
			 @Override 
			public void onClick(View view) {
			} 
		});
		if (!(_duration == 0)) {
			snackbar.setDuration((int)_duration*1000);
		}
		snackbar.show();
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