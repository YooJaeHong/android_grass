package com.example.git_grass_reader;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.TabHost;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class mygrass extends AppCompatActivity {
    int col_num = 1;
    List<String> all_date = new ArrayList<>();
    List<String> all_colors = new ArrayList<>();
    private String github_id = "YooJaehong";
    private String htmlPageUrl = "https://github.com/" + github_id;

    private TextView textviewHtmlDocument;

    private String htmlContentInStringFormat;
    //TextView top_date = (TextView)findViewById(R.id.selected_date);//이 코드 실행하면 터짐(?)

    SimpleDateFormat git_hub_time_formatter = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy년 MM월");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mygrass);


        final TextView top_date = (TextView)findViewById(R.id.selected_date);




        //상단 탭 생성 + 조작
        TabHost tabhost1 = (TabHost) findViewById(R.id.taphost_mygrass);
        tabhost1.setup();
        TabHost.TabSpec ts1 = tabhost1.newTabSpec("Tab Spec 1");
        ts1.setContent(R.id.내잔디밭);
        ts1.setIndicator("내잔디밭");
        tabhost1.addTab(ts1);

        TabHost.TabSpec ts2 = tabhost1.newTabSpec("Tab Spec 2");
        ts2.setContent(R.id.팀잔디밭);
        ts2.setIndicator("팀잔디밭");
        tabhost1.addTab(ts2);

        TabHost.TabSpec ts3 = tabhost1.newTabSpec("Tab Spec 3");
        ts3.setContent(R.id.새로운잔디밭);
        ts3.setIndicator("새로운잔디밭");
        tabhost1.addTab(ts3);

        //상단 스크롤바 버튼
        //col 주소를 tv에 저장
       final View[] tv = new View[25];
        for(int i=1;i<=24;i++){

            try {
                int id = R.id.class.getField("col"+i+"row1").getInt(0);
                tv[i] = (View)findViewById(id);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }

        }
        //버튼조작
        Button left_btn = (Button)findViewById(R.id.left_btn);
        Button right_btn = (Button)findViewById(R.id.right_btn);
        final HorizontalScrollView horizontalScrollView= (HorizontalScrollView)findViewById(R.id.내잔디밭_scrollView);

        left_btn.setOnClickListener(new Button.OnClickListener(){
          public void onClick(View view){
              if(col_num>1){
                  col_num--;
              }
              horizontalScrollView.smoothScrollTo(tv[col_num].getLeft(),0);//스크롤이동

              //날짜변환
              try {
                  Date original_date = formatter.parse(top_date.getText().toString());
                  Calendar cal = Calendar.getInstance();
                  cal.setTime(original_date);
                  cal.add(Calendar.MONTH,-1);


                  String scroll_starter_date = formatter.format(cal.getTime());
                  top_date.setText(scroll_starter_date);
              } catch (ParseException e) {
                  e.printStackTrace();
              }
          }
        });
        right_btn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){
                if(col_num<24){
                    col_num++;
                }
                horizontalScrollView.smoothScrollTo(tv[col_num].getLeft(),0);//스크롤이동
                try {
                    Date original_date = formatter.parse(top_date.getText().toString());
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(original_date);
                    cal.add(Calendar.MONTH,1);


                    String scroll_starter_date = formatter.format(cal.getTime());
                    top_date.setText(scroll_starter_date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

        Log.e("try 이전:","abce");
        //Document doc = null;
        Elements dates = null;
        github_parser date_color_parser = new github_parser();
        try {
            dates = date_color_parser.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //파싱
        /*Document doc = null;
        try {
            Log.e("파싱한하기전:","abce");
            doc = Jsoup.connect("https://github.com/YooJaehong").get();

        }
        catch (Exception e){
            e.printStackTrace();
        }*/
        //Log.e("파싱후:","abce");
        //Log.e("파싱한 값 전체:",doc.text());
        //Elements dates = doc.select("rect[class=day]");





        for (Element date : dates) {
            String raw_date = date.attr("abs:data-date");
            String raw_color = date.attr("abs:fill");

            int color_idx = raw_color.indexOf("#");

            String url_deleted_date = raw_date.substring(19);
            String url_deleted_color = raw_color.substring(color_idx);


            all_date.add(url_deleted_date);
            all_colors.add(url_deleted_color);
        }

        //파싱한 데이터로 초기 날짜 설정

        try {
            Date original_date = null;
            Log.e("num of date : ",Integer.toString(all_date.size()));
            Log.e("num of color : ",Integer.toString(all_colors.size()));
            /*for(int i=0;i<all_date.size();i++){
                Log.e("date:",all_date.get(i));
            }
            for(int i=0;i<all_colors.size();i++){
                Log.e("color:",all_colors.get(i));
            }*/
            //출력값 로그
            if(all_date.size()!=0) {
                original_date = git_hub_time_formatter.parse(all_date.get(0));
            }

            String scroll_starter_date = formatter.format(original_date);
            top_date.setText(scroll_starter_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }



        //파싱한 데이터를 기반으로 색상변경

        for(int i=1;i<=48;i++){
            for(int j=1;j<=7;j++){
                //all_date.get(i);
                String color_temp = all_colors.get((i-1)*7+j);
                Log.e("colortemp:",color_temp);

                try {
                    int colrowid = R.id.class.getField("col"+i+"row"+j).getInt(0);
                    View colrow = (View)findViewById(colrowid);
                    colrow.setBackgroundColor(Color.parseColor(color_temp));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }

        }



    }
}