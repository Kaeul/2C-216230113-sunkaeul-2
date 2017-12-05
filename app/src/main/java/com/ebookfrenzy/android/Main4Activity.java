package com.ebookfrenzy.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {

    ViewGroup rootContainer;
    Scene scene1;
    Scene scene2;
    Scene scene3;
    Scene scene4;
    Scene scene5;
    Scene scene6;
    Scene scene7;
    Scene scene8;
    Scene scene9;
    Scene scene10;
    Scene scene11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        setTitle("Gallery");

        rootContainer =
                (ViewGroup) findViewById(R.id.rootContainer);

        scene1 = Scene.getSceneForLayout(rootContainer,
                R.layout.scene1_layout, this);

        scene2 = Scene.getSceneForLayout(rootContainer,
                R.layout.scene2_layout, this);

        scene3 = Scene.getSceneForLayout(rootContainer,
                R.layout.scene3_layout, this);

        scene4 = Scene.getSceneForLayout(rootContainer,
                R.layout.scene4_layout, this);

        scene5 = Scene.getSceneForLayout(rootContainer,
                R.layout.scene5_layout, this);

        scene6 = Scene.getSceneForLayout(rootContainer,
                R.layout.scene6_layout, this);

        scene7 = Scene.getSceneForLayout(rootContainer,
                R.layout.scene7_layout, this);

        scene8 = Scene.getSceneForLayout(rootContainer,
                R.layout.scene8_layout, this);

        scene9 = Scene.getSceneForLayout(rootContainer,
                R.layout.scene9_layout, this);

        scene10 = Scene.getSceneForLayout(rootContainer,
                R.layout.scene10_layout, this);

        scene11 = Scene.getSceneForLayout(rootContainer,
                R.layout.scene11_layout, this);

        scene1.enter();


    }
    public void goToScene1(View view) {
        TransitionManager.go(scene1);
    }

    public void goToScene2(View view) {
        TransitionManager.go(scene2);
        Toast.makeText(getApplicationContext(), "2017년 10월 7일 - 파스타", Toast.LENGTH_LONG).show();
    }

    public void goToScene3(View view) {
        TransitionManager.go(scene3);
        Toast.makeText(getApplicationContext(), "2017년 10월 12일 - 머랭쿠키", Toast.LENGTH_LONG).show();
    }

    public void goToScene4(View view) {
        TransitionManager.go(scene4);
        Toast.makeText(getApplicationContext(), "2017년 10월 11일 - 까르보나라 학식", Toast.LENGTH_LONG).show();
    }

    public void goToScene5(View view) {
        TransitionManager.go(scene5);
        Toast.makeText(getApplicationContext(), "2017년 9월 28일 - 돈까스 & 냉모밀", Toast.LENGTH_LONG).show();
    }

    public void goToScene6(View view) {
        TransitionManager.go(scene6);
        Toast.makeText(getApplicationContext(), "2017년 9월 14일 - BHC 스윗츄", Toast.LENGTH_LONG).show();
    }

    public void goToScene7(View view) {
        TransitionManager.go(scene7);
        Toast.makeText(getApplicationContext(), "2017년 9월 8일 - 무화과 타르트 & 곡물 라떼", Toast.LENGTH_LONG).show();
    }

    public void goToScene8(View view) {
        TransitionManager.go(scene8);
        Toast.makeText(getApplicationContext(), "2017년 9월 7일 - 바닐라 컵케이크 & 청귤청 에이드", Toast.LENGTH_LONG).show();
    }

    public void goToScene9(View view) {
        TransitionManager.go(scene9);
        Toast.makeText(getApplicationContext(), "2017년 8월 20일 - 치킨 & 떡볶이", Toast.LENGTH_LONG).show();
    }

    public void goToScene10(View view) {
        TransitionManager.go(scene10);
        Toast.makeText(getApplicationContext(), "2017년 8월 4일 - 게장 정식", Toast.LENGTH_LONG).show();
    }

    public void goToScene11(View view) {
        TransitionManager.go(scene11);
        Toast.makeText(getApplicationContext(), "2017년 7월 22일 - 갈비", Toast.LENGTH_LONG).show();
    }
}
