package com.example.project1;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.services.OpenSdCardDireatoty;
import com.services.SdCardService;


import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class SubUIEntertainment_Mp3 extends Activity {

	private String path = "";
	private String fileName = "";
	
	private static final int SET_TOTAL = 0;
	private static final int SET_CURRENT = 1;
	private static final int SET_RESET = 2;
	private static final int SET_CLEAR = 3;

	private EditText editText_fileName;
	private MediaPlayer mp;
	private ImageButton imageButton_start;
	private ImageButton imageButton_pause;
	private ImageButton imageButton_reset;
	private ImageButton imageButton_stop;
	private Button button_addFile;
	private ButtonClickListener onClickListener;
	private TextView currentTime;
	private TextView totalTime;
	private ProgressBar progressBar;
	private static boolean isCut = false;
	private static boolean isStop = false;
	private int currentPosition = 0;
	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			switch (msg.what) {
			case SET_TOTAL:
				totalTime.setText(msg.getData().getString("totalTime"));
				progressBar.setMax(msg.getData().getInt("progressBarMax"));
				break;
			case SET_CURRENT:
				currentTime.setText(msg.getData().getString("currentTime"));
				progressBar.setProgress(msg.getData().getInt("progressBarNow"));
				break;
			case SET_RESET:
				currentTime.setText(msg.getData().getString("reset"));
				progressBar.setProgress(0);
				break;
			case SET_CLEAR:
				currentTime.setText(msg.getData().getString("clear"));
				totalTime.setText(msg.getData().getString("clear"));
				progressBar.setMax(msg.getData().getInt("toZero"));
			}
		}

	};

	
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if(mp.isPlaying()){
			mp.stop();
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		if(!data.getStringExtra("isChoose").equals("no")){
			path = data.getStringExtra("absolutePath");
			fileName = data.getStringExtra("name");
			Log.i("result", path);
			editText_fileName.setText(fileName);
		}else{
			path = "";
			fileName = "";
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.subui_entertainment_mp3);

		// initial
		editText_fileName = (EditText) this
				.findViewById(R.id.subui_entertainment_mp3_editText_fileName);
		progressBar = (ProgressBar) this
				.findViewById(R.id.subui_entertainment_mp3_progressBar_current);
		currentTime = (TextView) this
				.findViewById(R.id.subui_entertainment_mp3_textView_currentTime);
		totalTime = (TextView) this
				.findViewById(R.id.subui_entertainment_mp3_textView_totalTime);
		imageButton_start = (ImageButton) this
				.findViewById(R.id.subui_entertainment_mp3_imageButton_start);
		imageButton_pause = (ImageButton) this
				.findViewById(R.id.subui_entertainment_mp3_imageButton_pause);
		imageButton_reset = (ImageButton) this
				.findViewById(R.id.subui_entertainment_mp3_imageButton_reset);
		imageButton_stop = (ImageButton) this
				.findViewById(R.id.subui_entertainment_mp3_imageButton_stop);
		button_addFile = (Button) this
				.findViewById(R.id.subui_entertainment_mp3_button_addFile1);
		mp = new MediaPlayer();
		onClickListener = new ButtonClickListener();

		// register
		imageButton_start.setOnClickListener(onClickListener);
		imageButton_pause.setOnClickListener(onClickListener);
		imageButton_reset.setOnClickListener(onClickListener);
		imageButton_stop.setOnClickListener(onClickListener);
		button_addFile.setOnClickListener(onClickListener);
	}

	private class ButtonClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			try {
				// TODO Auto-generated method stub
				switch (v.getId()) {
				case R.id.subui_entertainment_mp3_imageButton_start:
					isStop = false;
					play();
					setTotal();
					new Thread(new Runnable() {

						@Override
						public void run() {
							// 从暂停到开始,防止不能setCurrent
							if (isCut == true) {
								isCut = false;
							}// isStop用于在stop按钮时，暂停这个线程不停的setCurrent
							while (!isCut && !isStop) {
								setCurrent();
							}
							// 不知为何在stop时currentTime不归零。这里设置下
							if (isStop) {
								resetProgress();
							}
						}
					}).start();
					break;
				case R.id.subui_entertainment_mp3_imageButton_pause:

					if (mp.isPlaying()) {
						isCut = true;
						currentPosition = mp.getCurrentPosition();
						mp.pause();
					} else {
						isCut = false;
						mp.start();
						new Thread(new Runnable() {

							@Override
							public void run() {
								// TODO Auto-generated method stub
								while (!isCut) {
									setCurrent();
								}
							}
						}).start();
					}
					break;
				case R.id.subui_entertainment_mp3_imageButton_reset:
					 
					// 如果暂停了再seekTo(0)会报错
					if (isCut == true) {
						play();
						// 为了让新线程能够setCurrent
						isCut = false;
					} else {
						mp.seekTo(0);
					}
					resetProgress();
					new Thread(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							while (!isCut) {
								setCurrent();
							}
						}
					}).start();
					break;
				case R.id.subui_entertainment_mp3_imageButton_stop:
					 
					if (mp.isPlaying()) {
						mp.stop();
						isCut = true;
						isStop = true;
					}
					clearProgress();
					break;
				case R.id.subui_entertainment_mp3_button_addFile1:
					if(SdCardService.isSdCardExist()){
						Intent intent5 = new Intent(SubUIEntertainment_Mp3.this,OpenSdCardDireatoty.class); 
						intent5.putExtra("path", "com.example.project1.SubUIEntertainment_Mp3");
						intent5.putExtra("type", "mp3");
						startActivityForResult(intent5, 200);
					}else{
						Toast.makeText(SubUIEntertainment_Mp3.this, "未检测到Sd卡", 1).show();
					}
					//startActivity(intent5);
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
				Log.i("err", e.toString());
			}
		}

		private void clearProgress() {
			Message msg = new Message();
			msg.what = SET_CLEAR;
			msg.getData().putString("clear", "00:00");
			msg.getData().putInt("toZero", 0);
			handler.sendMessage(msg);
		}

		private void resetProgress() {
			Message msg = new Message();
			msg.what = SET_RESET;
			msg.getData().putString("reset", "00:00");
			handler.sendMessage(msg);
		}

		private void setCurrent() {
			Message msg = new Message();
			msg.what = SET_CURRENT;

			// 设置当前时间
			SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
			int progressBarNow = mp.getCurrentPosition();
			msg.getData().putString("currentTime",
					sdf.format(new Date(progressBarNow)));

			// 设置当前进度条
			msg.getData().putInt("progressBarNow", progressBarNow);

			handler.sendMessage(msg);
		}

		private void setTotal() {

			Message msg = new Message();
			msg.what = SET_TOTAL;

			// 总时间
			SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
			String totalTime = sdf.format(new Date(mp.getDuration()));
			msg.getData().putString("totalTime", totalTime);

			// 进度条最大
			int progressBarMax = mp.getDuration();
			msg.getData().putInt("progressBarMax", progressBarMax);
			handler.sendMessage(msg);
		}

		private void play() throws IOException {
			File file = new File(path);
			String path = file.getAbsolutePath();
			mp.reset();
			mp.setDataSource(path);
			mp.prepare();
			mp.start();
		}

	}
}
