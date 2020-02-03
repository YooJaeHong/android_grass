package com.example.git_grass_reader;


import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
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
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import dalvik.system.BaseDexClassLoader;

public class MainActivity extends Activity {


    AlarmManager alarm_manager;
    Context context;
    PendingIntent pendingIntent;//for alarm

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //alarm 기능
        this.context = this;

        alarm_manager = (AlarmManager)getSystemService(ALARM_SERVICE);

        Intent alarm_receiver_Intent = new Intent(this.context,Alarm_Reciver.class);

        Calendar cal = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        cal.add(Calendar.SECOND,10);




        //cal.set(Calendar.HOUR_OF_DAY,cal.get(Calendar.HOUR_OF_DAY));
        //cal.set(Calendar.MINUTE,cal.get(Calendar.MINUTE));
        //cal.set(Calendar.SECOND,cal.get(Calendar.SECOND)+10);//현재시간 +1


        int today_date = today.DAY_OF_MONTH;
        int today_hour = today.HOUR;

        //alarm_receiver_Intent.putExtra("seeded","1");//1=심어짐, 0=안심어짐;

        //백그라운드 예약설정
        pendingIntent = PendingIntent.getBroadcast(MainActivity.this,0,alarm_receiver_Intent,PendingIntent.FLAG_UPDATE_CURRENT);
        alarm_manager.set(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pendingIntent);








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
