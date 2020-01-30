package com.example.git_grass_reader;


import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.text.method.ScrollingMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.app.NotificationCompat;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    /*private background_service b_service;

    ServiceConnection sconn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            background_service.MyBinder myBinder = (background_service.MyBinder) service;
            b_service = myBinder.getService();

            //isBind = true//////여기까지함! 백그라운드 서비스 구현중
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };*/

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent loading = new Intent(this,loadingActivity.class);
        startActivity(loading);









//grass


//grass end

        //notification start
        /*findViewById(R.id.btn_noti).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Bitmap mLargeIconForNoti = BitmapFactory.decodeResource(getResources(), R.drawable.image1);

                PendingIntent mPendingIntent = PendingIntent.getActivity(MainActivity.this, 0,
                        new Intent(getApplicationContext(), MainActivity.class),
                        PendingIntent.FLAG_UPDATE_CURRENT
                );


                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(MainActivity.this)
                                //.setSmallIcon(R.drawable.image0)
                                .setContentTitle("알림 제목")
                                .setContentText("내용")
                                .setDefaults(Notification.DEFAULT_VIBRATE)
                                //.setLargeIcon(mLargeIconForNoti)
                                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                                .setAutoCancel(true)
                                .setContentIntent(mPendingIntent);

                NotificationManager mNotificationManager =
                        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                mNotificationManager.notify(0, mBuilder.build());
            }
        });*/
        //notification end
    }
}
