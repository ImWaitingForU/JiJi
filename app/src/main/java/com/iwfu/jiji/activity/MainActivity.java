package com.iwfu.jiji.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.iwfu.jiji.R;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
		assert fab != null;
		// 点击fab开始新建笔记,跳转到编辑界面
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(MainActivity.this, ActivityEdit.class));
			}
		});

		RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerView);
		assert rv != null;
		rv.setLayoutManager(new LinearLayoutManager(this,
		                                            LinearLayoutManager.VERTICAL, false));
		//添加item添加删除动画
		rv.setItemAnimator (new DefaultItemAnimator ());
		//添加分割线
//		rv.setAdapter ();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();

		// 跳转到设置界面
		if (id == R.id.action_settings) {
//			startActivity(new Intent(this, SettingsActivity.class));
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
