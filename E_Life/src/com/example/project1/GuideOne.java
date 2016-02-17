package com.example.project1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

public class GuideOne extends Activity implements android.view.GestureDetector.OnGestureListener{

	private GestureDetector detector;
		
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return detector.onTouchEvent(event);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.guide_one);
		
		LinearLayout linearLayout = (LinearLayout) this.findViewById(R.id.linearLayout);
		detector = new GestureDetector(GuideOne.this, this);
		
		 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		// TODO Auto-generated method stub
		/*if(e1.getX()-e2.getX()>=100 && Math.abs(e1.getY()-e2.getY())<=100){
			Intent intent = new Intent(GuideOne.this,GuideTwo.class);
			startActivity(intent);
			finish();
			overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
		}*/
		if(e1.getX()-e2.getX()>=100 && Math.abs(e1.getY()-e2.getY())<=100){
			Intent intent = new Intent(GuideOne.this,GuideTwo.class);
			startActivity(intent);
			finish();
			overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
		}
		 
		
		
		return false;
	}


}
