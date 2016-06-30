package com.example.qiang.sharedpreferencesdemo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button SaveButton, LoadButton;
    private TextView ShowData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        Listener();

    }

    private void init() {
        SaveButton = (Button) findViewById(R.id.save_data);
        LoadButton = (Button) findViewById(R.id.load_data);
        ShowData = (TextView) findViewById(R.id.show_data);

    }

    public void Listener() {

        SaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveData();
            }
        });

        LoadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadData();
            }
        });
    }

    public void SaveData() {
        //指定操作的文件名称
        SharedPreferences share = getSharedPreferences("config", MODE_PRIVATE);
        SharedPreferences.Editor edit = share.edit(); //编辑文件
        edit.putString("name", "LJie");
        edit.commit();  //保存数据信息
    }

    public void LoadData() {
        //指定操作的文件名称
        SharedPreferences share = getSharedPreferences("config", MODE_PRIVATE);
        ShowData.setText("作者：" + share.getString("name", "信息为空..."));
    }
}
