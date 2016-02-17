package com.example.project1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.services.ContactService;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class SubUICompass extends Activity{
	
	private ImageView iv;
	private SensorManager sm;
	private SensorListener sl;
	private Sensor sensor_direction;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.subui_compass);
		
		//initial
		iv = (ImageView) this.findViewById(R.id.subui_compass_imageView_compass);
		sm = (SensorManager) this.getSystemService(SENSOR_SERVICE);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		sensor_direction = sm.getDefaultSensor(Sensor.TYPE_ORIENTATION);
		sl = new SensorListener();
		sm.registerListener(sl, sensor_direction, SensorManager.SENSOR_DELAY_NORMAL);
	}
	
	private class SensorListener implements SensorEventListener{
		
		private float fromDegrees = 0;
		private float toDegrees = 0;
		
		@Override
		public void onSensorChanged(SensorEvent event) {
			// TODO Auto-generated method stub
			if(event.sensor.getType()==Sensor.TYPE_ORIENTATION){
				float x = event.values[SensorManager.DATA_X];
				toDegrees = -x;
				RotateAnimation animation = new RotateAnimation(fromDegrees, toDegrees, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,0.5f);
				iv.startAnimation(animation);
				animation.setFillAfter(true);
				fromDegrees = toDegrees;
			}
		}

		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
