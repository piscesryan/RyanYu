package com.example.project1;

import com.services.sqlite.SQLiteService;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.Toast;

public class SubUIInfo_AboutMe extends Activity {

	private EditText editText;
	private ClickListener listener;
	private KeyListener listener_key;
	private SQLiteService sqlService;

	private void getMyNoteFromDB(){
		String content = sqlService.readMyNote();
		if(content!=null){
			editText.setText(content);
		}
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		String content = editText.getText().toString();
		sqlService.saveMyNote(content);
		super.onDestroy();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.subuiinfo_aboutme);

		listener = new ClickListener();
		listener_key = new KeyListener();

		editText = (EditText) this
				.findViewById(R.id.subuiinfo_aboutme_editText_things);
		editText.setOnTouchListener(listener);
		editText.setOnKeyListener(listener_key);

		sqlService = new SQLiteService(SubUIInfo_AboutMe.this);
		getMyNoteFromDB();
	}

	// listener
	private class KeyListener implements OnKeyListener {

		@Override
		public boolean onKey(View v, int keyCode, KeyEvent event) {
			// TODO Auto-generated method stub
			// return为true，后退会失去焦点，不会退出，但是不能删除和换行，所以通过flag来return
			boolean flag = false;

			if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
				editText.setFocusable(false);
				Log.i("result", "onDoubleTap");
				editText.setFocusableInTouchMode(false);
				Toast.makeText(SubUIInfo_AboutMe.this, "保存完成", 1).show();
				flag = true;
			}
			return flag;
		}

	}

	private class ClickListener implements OnTouchListener {

		@Override
		public boolean onTouch(View v, MotionEvent event) {
			// TODO Auto-generated method stub

			editText.setFocusable(true);
			editText.setFocusableInTouchMode(true);
			editText.requestFocus();
			editText.requestFocusFromTouch();

			return false;
		}

	}
}
