package com.wudu.muldown.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.wudu.muldown.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnListView).setOnClickListener(this);
        findViewById(R.id.btnRecyclerView).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this,"点击事件",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, AppListActivity.class);
        switch (v.getId()) {
            case R.id.btnListView:
                intent.putExtra("EXTRA_TYPE", AppListActivity.TYPE.TYPE_LISTVIEW);
                Log.d("wd_thread","开始进入下载页面----1");
                break;
            case R.id.btnRecyclerView:
                intent.putExtra("EXTRA_TYPE", AppListActivity.TYPE.TYPE_RECYCLERVIEW);
                Log.d("wd_thread","开始进入下载页面----2");
                break;
            default:
                return;
        }
        startActivity(intent);
    }

}
