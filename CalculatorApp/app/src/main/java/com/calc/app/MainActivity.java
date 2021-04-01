package com.calc.app;

import android.app.Activity;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.text.*;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;
import android.view.View;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends Activity {
	
	
	private double noff = 0;
	private String entrada = "";
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear6;
	private LinearLayout linear8;
	private LinearLayout linear9;
	private LinearLayout linear10;
	private LinearLayout linear11;
	private TextView salida;
	private ImageView imageview1;
	private TextView tce;
	private TextView textview2;
	private TextView tsqrt;
	private TextView tdiv;
	private TextView t7;
	private TextView t8;
	private TextView t9;
	private TextView tmult;
	private TextView t4;
	private TextView t5;
	private TextView t6;
	private TextView trest;
	private TextView t1;
	private TextView t2;
	private TextView t3;
	private TextView tsum;
	private TextView textview21;
	private TextView t0;
	private TextView textview23;
	private TextView tigual;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		salida = (TextView) findViewById(R.id.salida);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		tce = (TextView) findViewById(R.id.tce);
		textview2 = (TextView) findViewById(R.id.textview2);
		tsqrt = (TextView) findViewById(R.id.tsqrt);
		tdiv = (TextView) findViewById(R.id.tdiv);
		t7 = (TextView) findViewById(R.id.t7);
		t8 = (TextView) findViewById(R.id.t8);
		t9 = (TextView) findViewById(R.id.t9);
		tmult = (TextView) findViewById(R.id.tmult);
		t4 = (TextView) findViewById(R.id.t4);
		t5 = (TextView) findViewById(R.id.t5);
		t6 = (TextView) findViewById(R.id.t6);
		trest = (TextView) findViewById(R.id.trest);
		t1 = (TextView) findViewById(R.id.t1);
		t2 = (TextView) findViewById(R.id.t2);
		t3 = (TextView) findViewById(R.id.t3);
		tsum = (TextView) findViewById(R.id.tsum);
		textview21 = (TextView) findViewById(R.id.textview21);
		t0 = (TextView) findViewById(R.id.t0);
		textview23 = (TextView) findViewById(R.id.textview23);
		tigual = (TextView) findViewById(R.id.tigual);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (noff == 1) {
					imageview1.setImageResource(R.drawable.imageoff_2);
					entrada = "0";
					noff = 2;
					salida.setText(entrada);
				}
				else {
					imageview1.setImageResource(R.drawable.imageoff_1);
					entrada = " ";
					noff = 1;
					salida.setText(entrada);
				}
			}
		});
	}
	private void initializeLogic() {
		entrada = "";
		noff = 1;
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	public void onClickNumber (View _v) {
		//Add code
		if (noff == 2){
			if (entrada.equals("0")) {
				entrada = "";
			}


			TextView vw = (TextView) _v;

			if (vw.getId() == tigual.getId()) {
				ScriptEngineManager mgr = new ScriptEngineManager();
				ScriptEngine engine = mgr.getEngineByName("rhino");
				try {
					Object result = engine.eval(entrada);
					entrada = result.toString();
				} catch (Exception e) {
					entrada = "error: " + entrada;
				}
			} else if (vw.getId() == tce.getId()) {
				entrada = "0";
				salida.setText(entrada);
			} else if (vw.getId() == tdiv.getId()){
				if(entrada.charAt(entrada.length()-1) == '/'){
					entrada = entrada.substring(0, entrada.length()-1);
					entrada = entrada + "/";
				}else{
					entrada = entrada + "/";
				}
			}else if (vw.getId() == tmult.getId()){
				if(entrada.charAt(entrada.length()-1) == '*'){
					entrada = entrada.substring(0, entrada.length()-1);
					entrada = entrada + "*";
				}else{
					entrada = entrada + "*";
				}
			}else if(vw.getId() == trest.getId() || vw.getId() == tsum.getId()){
				if(entrada.charAt(entrada.length()-1) == '+' || entrada.charAt(entrada.length()-1) == '-'){
					entrada = entrada.substring(0, entrada.length()-1);
					entrada = entrada + vw.getText().toString();
				}else{
					entrada = entrada + vw.getText().toString();
				}
			}else if(vw.getId() == t0.getId()){
				  if(entrada.equals("0")){
					  }else{
						 entrada = entrada + "0";
					  }
			}else{
				  entrada = entrada + vw.getText().toString();
			}

			salida.setText(entrada);
		}else{
			Toast.makeText(getApplicationContext(), "Encienda la calculadora", Toast.LENGTH_SHORT).show();
		}
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
