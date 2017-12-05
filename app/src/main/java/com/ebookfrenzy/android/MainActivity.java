package com.ebookfrenzy.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("2학년 C반 216230113번 선가을");
    }

    public void activity2(View view){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    public void activity3(View view){
        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);
    }

    public void activity4(View view){
        Intent intent = new Intent(this, Main4Activity.class);
        startActivity(intent);
    }

}
