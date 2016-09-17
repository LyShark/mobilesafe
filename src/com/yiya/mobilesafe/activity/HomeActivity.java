package com.yiya.mobilesafe.activity;

import com.yiya.mobilesafe.R;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends Activity {
	private static final String TAG = "HomeActivity";
	GridView gv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		ImageView iv_heima =	(ImageView) findViewById(R.id.iv_heima);
		ObjectAnimator animator = ObjectAnimator.ofFloat(iv_heima, "rotationY", 0,359);
		//实现动画效果
		animator.setRepeatCount(ObjectAnimator.INFINITE);
		animator.setRepeatMode(ObjectAnimator.RESTART);
		animator.setDuration(2000);
		animator.start();
		// 在这里要显示8控件
		gv = (GridView) findViewById(R.id.gv);
		showHome();
	}
	
	
	
	public void setting(View v) {
		Intent setting = new Intent(this,SettingActivity.class);
		startActivity(setting);
		
	}

	private void showHome() {
		// 显示gridview
		MyGridView v = new MyGridView();
		gv.setAdapter(v);

	}

	private class MyGridView extends BaseAdapter {

		@Override
		public int getCount() {
			return 8;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// 在这里显示,先写初级代码,静态方法
			/*
			 * if(convertView != null) { return convertView; }else { return
			 * View.inflate(HomeActivity.this, R.layout.items, null); }
			 */
			View v = null;
			if(convertView != null ) {
				 v = convertView;
			}else {
				 v = View.inflate(HomeActivity.this, R.layout.items, null);
			}
			int[] arr = new int[] { R.drawable.sjfd, R.drawable.srlj,
					R.drawable.rjgj, R.drawable.jcgl, R.drawable.lltj,
					R.drawable.sjsd, R.drawable.xtjs, R.drawable.szzx };
			String[] title = new String[] { "手机防盗", "骚扰拦截", "软件管家", "进程管理",
					"流量统计", "手机杀毒", "系统加速", "常用工具" };
			String[] title1 = new String[] { "远程定位手机", "全面拦截骚扰", "管理您的软件",
					"管理正在运行", "流量使用统计", "病毒无法藏身", "手机快如火箭", "常用工具大全" };

			
			ImageView iv_items = (ImageView) v.findViewById(R.id.iv_items);
			iv_items.setImageResource(arr[position]);
			TextView tv_items_title = (TextView) v
					.findViewById(R.id.tv_items_title);
			tv_items_title.setText(title[position]);
			TextView tv_items_title1 = (TextView) v
					.findViewById(R.id.tv_items_title1);
			tv_items_title1.setText(title1[position]);
			return v;

		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

	}
}