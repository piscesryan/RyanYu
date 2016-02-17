package com.example.project1;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;


import com.services.OpenSdCardDireatoty;
import com.services.SdCardService;
import com.services.sqlite.SQLiteService;
import com.tools.ToolUtils;

public class SubUIEntertainment_Mp4 extends Activity {

	
	//file
	private String absolutePath;
	private String fileName;
	//widget
	private TextView textView_list;
	private TextView textView_currentTime;
	private TextView textView_totalTime;
	private SurfaceView surfaceView;
	private ListView listView_list;
	private ImageButton imageButton_start;
	private Button button_open;
	private SeekBar seekBar;
	private RelativeLayout rl_right;
	private RelativeLayout rl_bottom;
	//listener
	private GestureDetector detector;
	private GestureListener listener;
	private ClickListener clickListener;
	private SurfaceCallback callback;
	private SeekBarListener seekBarListener;
	//parameters
	private int longPressedTimes = 0;
	private int longDoubleTap = 0;
	private int surfaceViewDeafultWidth;
	private int surfaceViewDeafultHeight;
	private int screenWidth;
	private int screenHeight;
	//media player
	private MediaPlayer player;
	private int countTimes = 0;
	private boolean isPaused = false;
	private File video;
	private WindowManager wm;
	//about video lists
	private HashMap hm;
	private ArrayList<HashMap<String,String>> videoList;
	private SimpleAdapter adapter;
	private String[] from = {"name","time"};
	private int[] to = {R.id.item_mp4_textView_name,R.id.item_mp4_textView_date};
	private SQLiteService service;
	//about handler
	private static final int FROM_SEEKBAR = 2;
	private static final int CURRENT = 1;
	private Handler handler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			switch(msg.what){
			case CURRENT:
				int value = msg.getData().getInt("current");
				textView_currentTime.setText(ToolUtils.getTimeFromMillSec(value, "hh:mm:ss"));
				seekBar.setProgress(value);
			/*case FROM_SEEKBAR:
				player.seekTo(msg.getData().getInt("seekTo"));*/
			}
		}
		
	};

	
	
	//listener
	private class SeekBarListener implements OnSeekBarChangeListener{

		@Override
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
			// TODO Auto-generated method stub
			Log.i("result", "ProgressChanged");
		}

		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub
			Log.i("result", "Start");
		}

		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub
			Log.i("result", "stoptrace");
			/*Message msg = new Message();
			msg.what = FROM_SEEKBAR;
			msg.getData().putInt("seekTo", seekBar.getProgress());
			handler.sendMessage(msg);*/
		}
		
	}
	
	private class GestureListener extends SimpleOnGestureListener {

		@Override
		public void onLongPress(MotionEvent e) {
			// TODO Auto-generated method stub
			super.onLongPress(e);
			longPressedTimes++;
			if (longPressedTimes % 2 != 0) {
				// 收缩
				rl_right.setVisibility(View.INVISIBLE);

				RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
						screenWidth, surfaceViewDeafultHeight);
				surfaceView.setLayoutParams(params);
				Toast.makeText(SubUIEntertainment_Mp4.this, "隐藏播放列表，长按屏幕调出", 1)
						.show();
			} else {
				rl_right.setVisibility(View.VISIBLE);
				rl_bottom.setVisibility(View.VISIBLE);

				RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
						surfaceViewDeafultWidth, surfaceViewDeafultHeight);
				surfaceView.setLayoutParams(params);
				Toast.makeText(SubUIEntertainment_Mp4.this, "调出播放列表，长按屏幕隐藏", 1)
						.show();
			}

		}

		@Override
		public boolean onDoubleTap(MotionEvent e) {
			// TODO Auto-generated method stub

			longDoubleTap++;
			if (longDoubleTap % 2 != 0) {
				// 进入全屏
				hidden();

				RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
						screenWidth, screenHeight);
				surfaceView.setLayoutParams(params);
				surfaceView.getHolder().setFixedSize(screenWidth, screenHeight);
				Toast.makeText(SubUIEntertainment_Mp4.this, "进入全屏，双击退出", 1)
						.show();
			} else {
				show();
				Log.i("result", "surfaceViewDeafultHeight="
						+ surfaceViewDeafultHeight);
				RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
						surfaceViewDeafultWidth, surfaceViewDeafultHeight);
				surfaceView.setLayoutParams(params);
				Toast.makeText(SubUIEntertainment_Mp4.this, "退出全屏，双击进入", 1)
						.show();
			}
			return super.onDoubleTap(e);
		}

		public void show() {
			/*
			 * textView_list.setVisibility(View.VISIBLE);
			 * textView_currentTime.setVisibility(View.VISIBLE);
			 * textView_totalTime.setVisibility(View.VISIBLE);
			 * listView_list.setVisibility(View.VISIBLE);
			 * imageButton_start.setVisibility(View.VISIBLE);
			 * button_open.setVisibility(View.VISIBLE);
			 * progressBar.setVisibility(View.VISIBLE);
			 */
			rl_right.setVisibility(View.VISIBLE);
			rl_bottom.setVisibility(View.VISIBLE);
		}

		public void hidden() {
			/*
			 * textView_list.setVisibility(View.INVISIBLE);
			 * textView_currentTime.setVisibility(View.INVISIBLE);
			 * textView_totalTime.setVisibility(View.INVISIBLE);
			 * listView_list.setVisibility(View.INVISIBLE);
			 * imageButton_start.setVisibility(View.INVISIBLE);
			 * button_open.setVisibility(View.INVISIBLE);
			 * progressBar.setVisibility(View.INVISIBLE);
			 */
			rl_right.setVisibility(View.INVISIBLE);
			rl_bottom.setVisibility(View.INVISIBLE);
		}
	}
	
	private class ClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			try {
				switch (v.getId()) {
				case R.id.subui_entertainment_mp4_button_openFile:
					if(SdCardService.isSdCardExist()){
						Intent intent = new Intent(SubUIEntertainment_Mp4.this,OpenSdCardDireatoty.class);
						intent.putExtra("type", "mp4");
						intent.putExtra("path", "com.example.project1.SubUIEntertainment_Mp4");
						startActivityForResult(intent, 200);
					}else{
						Toast.makeText(SubUIEntertainment_Mp4.this, "未检测到Sd卡", 1).show();
					}
					break;
				case R.id.subui_entertainment_mp4_imageButton_play:
					countTimes++;
					if(!player.isPlaying()){
						//播放
						//考虑从暂停到播放
						if(isPaused){
							player.start();
						}else{
							play();
						}
						isPaused = false;
						ImageButton ib = (ImageButton) v;
						ib.setBackgroundResource(R.drawable.pause);
					 
						new Thread(new Runnable(){
							@Override
							public void run() {
								// TODO Auto-generated method stub
								while(!isPaused){
									setCurrent();
								}
							}							
						}).start();
					}else{
						//暂停
						isPaused = true;
						ImageButton ib = (ImageButton) v;
						ib.setBackgroundResource(R.drawable.play);
						pause();
					}
					break;
				}
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				Log.i("result", e.toString());
			}
		}	 
	}
	
	
	private class SurfaceCallback implements SurfaceHolder.Callback{

		@Override
		public void surfaceCreated(SurfaceHolder holder) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void surfaceChanged(SurfaceHolder holder, int format, int width,
				int height) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void surfaceDestroyed(SurfaceHolder holder) {
			// TODO Auto-generated method stub
			if (player.isPlaying()) {
				player.stop();
			}
		}
		
	}
	
	
	//override
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return detector.onTouchEvent(event);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.subui_entertainment_mp4);

		// initial
		initial();

	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		service.saveVideoRecords(videoList);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		try {
			if(!data.getStringExtra("isChoose").equals("no")){
				absolutePath = data.getStringExtra("absolutePath");
				fileName = data.getStringExtra("name");
				
				//添加到最近观看
				hm = new HashMap();
				hm.put("name", fileName);
				hm.put("time", ToolUtils.getTimeFromMillSec(System.currentTimeMillis(), "yyyy.MM.dd-HH:mm:ss"));
				videoList.add(hm);
	
				adapter = new SimpleAdapter(SubUIEntertainment_Mp4.this, videoList, R.layout.item_mp4, from, to);
				listView_list.setAdapter(adapter);
				
				load();
				Toast.makeText(SubUIEntertainment_Mp4.this, "加载完毕，请点击播放按钮", 1).show();
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			Log.i("result", e.toString());
			e.printStackTrace();
			Toast.makeText(SubUIEntertainment_Mp4.this, "加载出错，请重试", 1).show();
		}
	}
	
	
	//defined Methods

	public void initial() {

		wm = getWindowManager();

		// initial listener
		listener = new GestureListener();
		detector = new GestureDetector(SubUIEntertainment_Mp4.this, listener);
		detector.setOnDoubleTapListener(listener);
		clickListener = new ClickListener();
		seekBarListener = new SeekBarListener();

		// initial view
		rl_right = (RelativeLayout) this
				.findViewById(R.id.subui_entertainment_mp4_relativeLayout_right);
		rl_bottom = (RelativeLayout) this
				.findViewById(R.id.subui_entertainment_mp4_relativeLayout_bottom);

		screenWidth = wm.getDefaultDisplay().getWidth();
		screenHeight = wm.getDefaultDisplay().getHeight();

		surfaceView = (SurfaceView) this
				.findViewById(R.id.subui_entertainment_mp4_surfaceview);
		surfaceViewDeafultWidth = screenWidth - 150;
		surfaceViewDeafultHeight = screenHeight - 115;// 因为高度包括了通知栏的50
		//设置surfaceView
		callback = new SurfaceCallback();
		surfaceView.getHolder().setFixedSize(176, 144);
		surfaceView.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		surfaceView.getHolder().addCallback(callback);
		
		textView_list = (TextView) this
				.findViewById(R.id.subui_entertainment_mp4_textView_list);
		textView_currentTime = (TextView) this
				.findViewById(R.id.subui_entertainment_mp4_textView_currentTime);
		textView_totalTime = (TextView) this
				.findViewById(R.id.subui_entertainment_mp4_textView_totalTime);
		listView_list = (ListView) this
				.findViewById(R.id.subui_entertainment_mp4_listView1);
		imageButton_start = (ImageButton) this
				.findViewById(R.id.subui_entertainment_mp4_imageButton_play);
		seekBar = (SeekBar) this
				.findViewById(R.id.subui_entertainment_mp4_seekBar);
		button_open = (Button) this
				.findViewById(R.id.subui_entertainment_mp4_button_openFile);
		
		//打开mp4界面时加载观看记录
		service = new SQLiteService(SubUIEntertainment_Mp4.this);
		videoList = service.readVideoRecords();
		if(videoList==null){
			videoList = new ArrayList<HashMap<String,String>>();
		}
		adapter = new SimpleAdapter(SubUIEntertainment_Mp4.this, videoList, R.layout.item_mp4, from, to);
		listView_list.setAdapter(adapter);
		
		//initial player
		player = new MediaPlayer();
		
		// register
		button_open.setOnClickListener(clickListener);
		imageButton_start.setOnClickListener(clickListener);
		seekBar.setOnSeekBarChangeListener(seekBarListener);
	}
	
	private void setCurrent() {
		// TODO Auto-generated method stub
		Message msg = new Message();
		msg.what = CURRENT;
		msg.getData().putInt("current", player.getCurrentPosition());
		Log.i("result", ToolUtils.getTimeFromMillSec(player.getCurrentPosition(), "hh:mm:ss"));
		handler.sendMessage(msg);
	}
	
	private void setTotal() {
		// TODO Auto-generated method stub
		
	}

	private void pause() {
		// TODO Auto-generated method stub
		if(player.isPlaying()){
			player.pause();
		}
	}
	
	private void load() throws Throwable{
		/*video = new File(Environment.getExternalStorageDirectory(),
				fileName);
		player.reset();
		player.setAudioStreamType(AudioManager.STREAM_MUSIC);
		player.setDisplay(surfaceView.getHolder());

		player.setDataSource(video.getAbsolutePath());
		player.prepare();
		
		int totalTime = player.getDuration();
		String s_Time = ToolUtils.getTimeFromMillSec(totalTime, "hh:mm:ss");
		seekBar.setMax(totalTime);
		textView_totalTime.setText(s_Time);*/
		
		video = new File(Environment.getExternalStorageDirectory(),
				fileName);
		player.reset();
		player.setAudioStreamType(AudioManager.STREAM_MUSIC);
		//player.setDisplay(surfaceView.getHolder());    加这句会出错

		player.setDataSource(video.getAbsolutePath());
		player.prepare();
		
		int totalTime = player.getDuration();
		String s_Time = ToolUtils.getTimeFromMillSec(totalTime, "hh:mm:ss");
		seekBar.setMax(totalTime);
		textView_totalTime.setText(s_Time);
	}

	private void play() throws Throwable{
		// TODO Auto-generated method stub

		video = new File(Environment.getExternalStorageDirectory(),
				fileName);
		player.reset();
		player.setAudioStreamType(AudioManager.STREAM_MUSIC);
		player.setDisplay(surfaceView.getHolder());

		player.setDataSource(video.getAbsolutePath());
		player.prepare();

		player.start();
	}

}
