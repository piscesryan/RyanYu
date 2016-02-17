package com.example.mydiary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TabActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.Toast;

import com.diary.ConcreteDiary;
import com.diary.DiaryWrite;
import com.domains.Diary;
import com.manage.FindDiaryResult;
import com.tools.CommonTools;
import com.tools.DatabaseHelper;

public class MainActivity extends TabActivity {

	private static final int DB_VERSION = 1;
	private static final String DB_NAME = "MyDiary";
	private static final String TABLE_NAME = "diary";
	private static final String OPERATION_SUCCEED = "操作成功";
	private static final String OPERATION_FAILED = "操作失败";
	private static final String TAG_Manage = "Manage";
	private static final String TAG_More = "More";
	private static final String TAG_Diary = "Diary";

	// 3个radioButtonlistener
	private OnClickListener clickListener;

	// manage
	private LinearLayout[] linearLayout_manage;
	private OnClickListener onclickListener_manage;
	private LayoutInflater inflater_manage_find;
	private View view_manage_find;
	private OnClickListener listener;
	private Dialog dialog;
	private Button button_find;
	private Button button_back;
	private EditText editText_manage_find_title;
	private List<HashMap<String, String>> data_manage;

	// more
	private LinearLayout[] linearLayout_more;
	private OnClickListener onclickListener_more;

	// diary
	private DatabaseHelper dbHelper;
	// private SQLiteDatabase db;
	private Cursor cursor;

	// main
	private LayoutInflater inflater;
	private View view;
	private RelativeLayout rl_welcome;
	private Animation animation;
	private Animation animation1;
	private Animation animation_in;
	private Animation animation_out;
	private Button button;
	private RelativeLayout rl_main;
	private RadioButton[] radioButton;
	private TabHost th;
	private RadioGroup radioGroup;

	private ListView lv_write;
	// private ListView lv_manage;
	// private ListView lv_more;

	// ListView
	private String[] from;
	private int[] to;
	private List<HashMap<String, String>> data;

	// 显示manage中"查找日志"对话框界面
	public void showFindDiaryByTitleDialog() {
		inflater_manage_find = LayoutInflater.from(MainActivity.this);
		view_manage_find = inflater_manage_find.inflate(R.layout.manage_find,
				null);
		editText_manage_find_title = (EditText) view_manage_find
				.findViewById(R.id.manage_find_editText_title);
		button_find = (Button) view_manage_find
				.findViewById(R.id.manage_find_button_find);
		button_back = (Button) view_manage_find
				.findViewById(R.id.manage_find_button_back);

		listener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()) {
				case R.id.manage_find_button_find:

					dbHelper = new DatabaseHelper(MainActivity.this, DB_NAME,
							null, DB_VERSION);
					data_manage = dbHelper.showDiaryFromDB(DB_NAME, null,
							"title=?",
							new String[] { editText_manage_find_title.getText()
									.toString() }, null, null, "time desc");
					Log.i("size", data_manage.size() + "");
					// 如果没有数据
					if (data_manage.size() == 0) {
						Toast.makeText(MainActivity.this, "查无日记",
								Toast.LENGTH_LONG).show();
					} else {
						// 有数据就跳转
						dialog.dismiss();

						Intent intent = new Intent(MainActivity.this,
								FindDiaryResult.class);
						intent.putExtra("title", editText_manage_find_title
								.getText().toString());
						startActivity(intent);

					}
					break;
				case R.id.manage_find_button_back:
					dialog.dismiss();
					break;
				}
			}
		};

		dialog = new Dialog(MainActivity.this);
		dialog.setTitle("要查找的日记的标题");
		dialog.setContentView(view_manage_find);

		button_find.setOnClickListener(listener);
		button_back.setOnClickListener(listener);

		dialog.show();
	}

	// 初始化TabHost,在（not）firstUse中调用
	public void initialTabHost() {

		th = this.getTabHost();

		LayoutInflater.from(this).inflate(R.layout.manage,
				th.getTabContentView(), true);
		LayoutInflater.from(this).inflate(R.layout.diary,
				th.getTabContentView(), true);
		LayoutInflater.from(this).inflate(R.layout.more,
				th.getTabContentView(), true);

		th.addTab(th.newTabSpec("no.1manage").setIndicator("manage")
				.setContent(R.id.manage_linearlayout));
		th.addTab(th.newTabSpec("no.2diary").setIndicator("diary")
				.setContent(R.id.diary_linearlayout));
		th.addTab(th.newTabSpec("no.3more").setIndicator("more")
				.setContent(R.id.more_linearlayout));

		th.setCurrentTab(1);

	}

	// 初始化manage,在onCreate中调用
	public void initialManage() {
		linearLayout_manage = new LinearLayout[3];
		// register
		onclickListener_manage = new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()) {
				case R.id.manage_linearLayout_find:
					Log.i(TAG_Manage, "find");
					showFindDiaryByTitleDialog();
					break;
				case R.id.manage_linearLayout_show:
					Log.i(TAG_Manage, "show");
					th.setCurrentTab(1);
					break;
				case R.id.manage_linearLayout_delete:
					Log.i(TAG_Manage, "delete");
					new AlertDialog.Builder(MainActivity.this)
							.setTitle("是否删除全部日记")
							.setPositiveButton("确定",
									new DialogInterface.OnClickListener() {
										@Override
										public void onClick(
												DialogInterface dialog,
												int which) {
											// TODO Auto-generated method stub
											dbHelper = new DatabaseHelper(
													MainActivity.this, DB_NAME,
													null, DB_VERSION);
											dbHelper.delete(TABLE_NAME, null,
													null);
											Toast.makeText(MainActivity.this,
													OPERATION_SUCCEED,
													Toast.LENGTH_LONG).show();
											dialog.dismiss();
											// 刷新日记列表
											initialDiary();
										}
									})
							.setNegativeButton("返回",
									new DialogInterface.OnClickListener() {

										@Override
										public void onClick(
												DialogInterface dialog,
												int which) {
											// TODO Auto-generated method stub
											dialog.dismiss();
										}
									}).show();

					break;
				}
			}
		};
		// initial
		for (int i = 0; i < linearLayout_manage.length; i++) {
			switch (i) {
			case 0:
				linearLayout_manage[i] = (LinearLayout) this
						.findViewById(R.id.manage_linearLayout_find);
				linearLayout_manage[i]
						.setOnClickListener(onclickListener_manage);
				break;
			case 1:
				linearLayout_manage[i] = (LinearLayout) this
						.findViewById(R.id.manage_linearLayout_show);
				linearLayout_manage[i]
						.setOnClickListener(onclickListener_manage);
				break;
			case 2:
				linearLayout_manage[i] = (LinearLayout) this
						.findViewById(R.id.manage_linearLayout_delete);
				linearLayout_manage[i]
						.setOnClickListener(onclickListener_manage);
				break;
			}
		}

	}

	// 初始化more，在onCreate中调用
	public void initialMore() {
		linearLayout_more = new LinearLayout[5];
		// register
		onclickListener_more = new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()) {
				case R.id.more_linearLayout_backToSDCard:
					Log.i(TAG_More, "backToSDCard");

					if (CommonTools.isSdCardExist(MainActivity.this)) {
						String pathFrom = "/data/data/com.example.mydiary/databases/MyDiary";
						String pathTo = CommonTools.getSdCardRootPath()
								+ "/MyDiary";

						if (CommonTools.backToSdCard(MainActivity.this,
								pathFrom, pathTo)) {
							CommonTools.showToast(MainActivity.this,
									OPERATION_SUCCEED);
							
							new AlertDialog.Builder(MainActivity.this).setTitle("提醒").
							setMessage("备份文件MyDiary保存在SD卡根目录下的MyDiary文件夹中。MyDiary.txt为文本格式的日记。").
							setPositiveButton("确定", null).setNegativeButton("返回", null);
							
						} else {
							CommonTools.showToast(MainActivity.this,
									OPERATION_FAILED);
						}
					}

					break;
				case R.id.more_linearLayout_restoreFromSDCard:
					Log.i(TAG_More, "restoreFromSDCard");
					if (CommonTools.isSdCardExist(MainActivity.this)) {
						String pathTo = "/data/data/com.example.mydiary/databases/MyDiary";
						String pathFrom = CommonTools.getSdCardRootPath()
								+ "/MyDiary/MyDiary";

						if (CommonTools.restoreFromSdCard(MainActivity.this,
								pathFrom, pathTo)) {
							CommonTools.showToast(MainActivity.this,
									OPERATION_SUCCEED);
							initialDiary();
						} else {
							CommonTools.showToast(MainActivity.this,
									OPERATION_FAILED);
						}
					}
					break;
				case R.id.more_linearLayout_feedback:
					Log.i(TAG_More, "feedback");

					AlertDialog dialog_info;

					View view_info = LayoutInflater.from(MainActivity.this)
							.inflate(R.layout.more_app_feedback, null);
					AlertDialog.Builder builder = new AlertDialog.Builder(
							MainActivity.this);
					builder.setTitle("产品信息");
					builder.setView(view_info);

					builder.setPositiveButton("确定", null);
					builder.setNegativeButton("返回", null);

					dialog_info = builder.show();

					break;
				case R.id.more_linearLayout_checkVersion:
					Log.i(TAG_More, "checkVersion");
					CommonTools.showToast(MainActivity.this, "当前已是最新版本");
					break;
				case R.id.more_linearLayout_aboutApp:
					Log.i(TAG_More, "aboutApp");

					AlertDialog dialog_info1;

					View view_info1 = LayoutInflater.from(MainActivity.this)
							.inflate(R.layout.more_app_info, null);
					AlertDialog.Builder builder1 = new AlertDialog.Builder(
							MainActivity.this);
					builder1.setTitle("产品信息");
					builder1.setView(view_info1);

					builder1.setPositiveButton("确定", null);
					builder1.setNegativeButton("返回", null);

					dialog_info = builder1.show();

					break;
				}
			}
		};
		// initial
		for (int i = 0; i < linearLayout_more.length; i++) {
			switch (i) {
			case 0:
				linearLayout_more[i] = (LinearLayout) this
						.findViewById(R.id.more_linearLayout_backToSDCard);
				linearLayout_more[i].setOnClickListener(onclickListener_more);
				break;
			case 1:
				linearLayout_more[i] = (LinearLayout) this
						.findViewById(R.id.more_linearLayout_restoreFromSDCard);
				linearLayout_more[i].setOnClickListener(onclickListener_more);
				break;
			case 2:
				linearLayout_more[i] = (LinearLayout) this
						.findViewById(R.id.more_linearLayout_feedback);
				linearLayout_more[i].setOnClickListener(onclickListener_more);
				break;
			case 3:
				linearLayout_more[i] = (LinearLayout) this
						.findViewById(R.id.more_linearLayout_checkVersion);
				linearLayout_more[i].setOnClickListener(onclickListener_more);
				break;
			case 4:
				linearLayout_more[i] = (LinearLayout) this
						.findViewById(R.id.more_linearLayout_aboutApp);
				linearLayout_more[i].setOnClickListener(onclickListener_more);
				break;
			}
		}
	}

	// 初始化diary，在onCreate中调用
	public void initialDiary() {

		lv_write = (ListView) this.findViewById(R.id.diary_listView);
		data = new ArrayList<HashMap<String, String>>();

		dbHelper = new DatabaseHelper(MainActivity.this, DB_NAME, null,
				DB_VERSION);
		data = dbHelper.showDiaryFromDB();

		from = new String[] { "title", "time" };
		to = new int[] { R.id.diary_item_textView_title,
				R.id.diary_item_textView_time };

		SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, data,
				R.layout.diary_item, from, to);

		lv_write = (ListView) this.findViewById(R.id.diary_listView);
		Log.i("isNull", String.valueOf(lv_write == null));
		lv_write.setAdapter(adapter);

		lv_write.setOnItemClickListener(new OnItemClickListener() {
			int whichOne = 0;
			android.app.AlertDialog.Builder temp_builder = new AlertDialog.Builder(
					MainActivity.this);
			AlertDialog temp_alertDialog;
			int target_position;

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub

				target_position = position;

				OnClickListener temp_onclickListener = new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						switch (v.getId()) {

						case R.id.diary_choose_linearlayout_openOrUpdate:
							whichOne = R.id.diary_choose_linearlayout_openOrUpdate;
							Log.i("info", "查看or打开");
							// 查看操作-----------------------------------------
							HashMap temp = data.get(target_position);
							int id_temp = Integer.parseInt(temp.get("id") + "");
							String title_temp = (String) temp.get("title");
							String content_temp = (String) temp.get("content");
							String time_temp = (String) temp.get("time");
							Diary diary = new Diary(id_temp, title_temp,
									content_temp, time_temp);

							Intent intent = new Intent(MainActivity.this,
									ConcreteDiary.class);
							intent.putExtra("obj", diary);

							startActivity(intent);
							// 查看操作-----------------------------------------
							temp_alertDialog.dismiss();
							break;
						case R.id.diary_choose_linearlayout_delete:
							whichOne = R.id.diary_choose_linearlayout_delete;
							Log.i("info", "删除");
							// 删除操作-----------------------------------------
							HashMap temp1 = data.get(target_position);
							int id_temp1 = Integer.parseInt(temp1.get("id")
									+ "");
							String whereClause = "id=?";
							dbHelper = new DatabaseHelper(MainActivity.this,
									DB_NAME, null, DB_VERSION);
							dbHelper.delete(TABLE_NAME, "id=?",
									new String[] { id_temp1 + "" });
							// 删除操作-----------------------------------------
							initialDiary();
							temp_alertDialog.dismiss();
							Toast.makeText(MainActivity.this,
									OPERATION_SUCCEED, Toast.LENGTH_LONG)
									.show();
							break;
						case R.id.diary_choose_linearlayout_back:
							whichOne = R.id.diary_choose_linearlayout_back;
							Log.i("info", "返回");
							temp_alertDialog.dismiss();
							break;
						}
					}
				};

				View temp_view = LayoutInflater.from(MainActivity.this)
						.inflate(R.layout.diary_choose, null);
				LinearLayout temp_ll_open = (LinearLayout) temp_view
						.findViewById(R.id.diary_choose_linearlayout_openOrUpdate);
				LinearLayout temp_ll_delete = (LinearLayout) temp_view
						.findViewById(R.id.diary_choose_linearlayout_delete);
				LinearLayout temp_ll_back = (LinearLayout) temp_view
						.findViewById(R.id.diary_choose_linearlayout_back);

				temp_ll_open.setOnClickListener(temp_onclickListener);
				temp_ll_delete.setOnClickListener(temp_onclickListener);
				temp_ll_back.setOnClickListener(temp_onclickListener);

				temp_builder.setTitle("您想做什么");
				temp_builder.setView(temp_view);

				temp_alertDialog = temp_builder.show();

			}
		});

	}

	// 非首次使用
	private void notFirstUse(Bundle savedInstanceState) {
		// 非首次使用
		inflater = this.getLayoutInflater();
		view = inflater.inflate(R.layout.activity_main, null);
		super.onCreate(savedInstanceState);
		this.setContentView(view);
		// 初始化TabHost、注册RadioButton
		initialTabHost();
		registerRadioGroup();

		//
		initialDiary();
		initialManage();
		initialMore();
	}

	// 注册按钮,在（not）firstUse中调用
	private void registerRadioGroup() {

		radioButton = new RadioButton[3];
		radioGroup = (RadioGroup) this.findViewById(R.id.main_radioGroup);

		clickListener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()) {
				case R.id.main_radionButton_manage:
					th.setCurrentTab(0);
					Log.i("info", "main_radionButton_manage");
					break;
				case R.id.main_radionButton_write:
					Log.i("info", "main_radionButton_write");
					Intent intent = new Intent(MainActivity.this,
							DiaryWrite.class);
					startActivity(intent);
					break;
				case R.id.main_radionButton_more:
					th.setCurrentTab(2);
					Log.i("info", "main_radionButton_more");
					break;
				}
			}
		};

		for (int i = 0; i < radioButton.length; i++) {
			switch (i) {
			case 0:
				radioButton[i] = (RadioButton) this
						.findViewById(R.id.main_radionButton_manage);
				radioButton[i].setOnClickListener(clickListener);
				break;
			case 1:
				radioButton[i] = (RadioButton) this
						.findViewById(R.id.main_radionButton_write);
				radioButton[i].setOnClickListener(clickListener);
				break;
			case 2:
				radioButton[i] = (RadioButton) this
						.findViewById(R.id.main_radionButton_more);
				radioButton[i].setOnClickListener(clickListener);
				break;
			}
		}

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		notFirstUse(savedInstanceState); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		// initialDiary();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		initialDiary();
	}
}
