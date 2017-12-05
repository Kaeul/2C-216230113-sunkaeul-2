package com.ebookfrenzy.android;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Main2Activity extends AppCompatActivity implements OnMapReadyCallback {
    TabHost tabHost;
    TextView idView;
    EditText studentName;
    EditText studentNum;

    private Handler mHandler;
    private TextView timerbutton;
    private NumberThread timerThread;

    Button go, right, left;
    EditText uri;
    WebView wv;
    View.OnClickListener cl;
    String weburi;

    class MyWeb extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        idView = (TextView) findViewById(R.id.studentID);
        studentName = (EditText) findViewById(R.id.studentName);
        studentNum =
                (EditText) findViewById(R.id.studentNumber);

        timerbutton = (TextView) findViewById(R.id.timer_button);
        mHandler = new Handler();

        go = (Button) findViewById(R.id.go);
        uri = (EditText) findViewById(R.id.uri);
        wv = (WebView) findViewById(R.id.wv);
        wv.setWebViewClient(new MyWeb());


        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.go :
                        weburi = uri.getText().toString();
                        if(weburi.startsWith("http://")) {
                            wv.loadUrl(weburi);
                        } else {
                            wv.loadUrl("http://" + weburi); }
                        break;
                }
            }
        };

        go.setOnClickListener(cl);

        setTitle("반갑습니다");

        tabHost = (TabHost) findViewById(R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec me = tabHost.newTabSpec("1").setContent(R.id.me).setIndicator("내 정보");
        TabHost.TabSpec thread = tabHost.newTabSpec("2").setContent(R.id.thread).setIndicator("스레드");
        TabHost.TabSpec db = tabHost.newTabSpec("3").setContent(R.id.db).setIndicator("DB");
        TabHost.TabSpec google = tabHost.newTabSpec("4").setContent(R.id.google).setIndicator("Google Map");
        TabHost.TabSpec web = tabHost.newTabSpec("5").setContent(R.id.web).setIndicator("Web View");


        tabHost.addTab(me);
        tabHost.addTab(thread);
        tabHost.addTab(db);
        tabHost.addTab(google);
        tabHost.addTab(web);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng hywoman = new LatLng(37.558182, 127.049907); // LatLng sydney = new LatLng(-33.852, 151.211);
        googleMap.addMarker(new MarkerOptions().position(hywoman).title("한양여자대학교"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(hywoman));
    }





    public void newStudent(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        int sname =
                Integer.parseInt(studentNum.getText().toString());
        Student student =
                new Student(studentName.getText().toString(), sname);
        dbHandler.addStudent(student);
//        studentName.setText("");
//        studentNum.setText("");

        boolean student_boolean = dbHandler.deleteStudent(studentName.getText().toString());
        dbHandler.addStudent(student);
        if (student_boolean)
        {
            idView.setText(" 학생 추가 완료!"); //학생 추가 버튼을 누르면 뜨게 함
            studentName.setText(""); //이동
            studentNum.setText(""); //이동
        }
        else
            idView.setText(" 학생 정보가 없습니다."); //
    }

    public void lookupStudent(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        Student student =
                dbHandler.findStudent(studentName.getText().toString());
        if (student != null) {
            idView.setText(String.valueOf(student.getID()));
            studentNum.setText(String.valueOf(student.getStudent()));
        } else {
            idView.setText(" 학생을 찾을 수 없습니다.");
        }
    }

    public void removeStudent(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null,
                null, 1);
        boolean result = dbHandler.deleteStudent(
                studentName.getText().toString());
        if (result)
        {
            idView.setText(" 학생 삭제 완료!");
            studentName.setText("");
            studentNum.setText("");
        }
        else
            idView.setText(" 학생 정보가 없습니다.");
    }

    public void onButtonClick(View v){
        switch (v.getId()) {
            case R.id.btn_start:
                timerThread = new NumberThread(true);
                timerThread.start();
                Toast.makeText(getApplicationContext(), "타이머를 시작합니다!", Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_stop:
                timerThread.stopThread();
                Toast.makeText(getApplicationContext(), "타이머를 중지합니다!", Toast.LENGTH_LONG).show();
                break;
        }
    }

    class NumberThread extends Thread {

        private int i = 1;
        private boolean isPlay = false;

        public NumberThread(boolean isPlay){
            this.isPlay = isPlay;
        }

        public void stopThread(){
            isPlay = !isPlay;
        }
        @Override
        public void run() {
            super.run();
            while (isPlay) {
                try { Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        timerbutton.setText(""+ i++ +"초 경과");
                    }
                });
            }
        }
    }







}
