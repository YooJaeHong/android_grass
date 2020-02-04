package com.example.git_grass_reader;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Environment;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class teamgrass extends mygrass{

    Context mContext;

    String text = "";
    String myLine = null;
    String path = null;
    Intent toTeamgrass = null;
    teamgrass(Context mContext){
        this.mContext = mContext;
        try {
            path = mContext.getFilesDir().getPath();
            Log.e("output_file_path",path+"/team2.txt");
            OutputStream output = new FileOutputStream(path+"/team2.txt");
            OutputStream output2 = new FileOutputStream(path+"/team3.txt");
            String text ="temp";
            byte[] by = text.getBytes();
            Log.e("output_file_path",path+"/team2.txt");
            output.write(by);
            output2.write(by);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        toTeamgrass = new Intent(this.mContext,invidual_teamgrass.class);


        loadAllFile(path);
    }


    //ScrollView teamgrass_scrollview = (ScrollView)findViewById(R.id.팀잔디밭_scrollview);



    public void createlayout(String teamname){



        final LinearLayout teamgrass_block = new LinearLayout(mContext);
        final int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,100,mContext.getResources().getDisplayMetrics());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, width);

        //teamgrass_block.setBackgroundColor(mContext.getResources().getColor(R.color.colorAccent));
        teamgrass_block.setGravity(Gravity.CENTER);



        teamgrass_block.setLayoutParams(params);


        final TextView Team_title = new TextView(mContext.getApplicationContext());







        Team_title.setGravity(Gravity.CENTER|Gravity.CENTER);
        Team_title.setText(teamname);
        //Team_title.setBackgroundResource(R.color.colorPrimaryDark);

        teamgrass_block.addView(Team_title);





        teamgrass_block.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Log.e("teamTitle.getText()",Team_title.getText().toString());
                toTeamgrass.putExtra("selected_team_name",Team_title.getText().toString());
                mContext.startActivity(toTeamgrass);
            }
        });



       Activity teamlist_view = (Activity)mContext;
       final LinearLayout teamgrass_layout = teamlist_view.findViewById(R.id.팀잔디밭_innerlayout);
       teamgrass_layout.addView(teamgrass_block);
    }
    public void loadAllFile(String path){
        File file = new File(path);
        Log.e("file_path",path);

        File[] fileArray = file.listFiles();
        Log.e("file_num",Integer.toString(fileArray.length));
        if(fileArray != null) {

            for (int i = 0; i < fileArray.length; i++) {
                Log.e("filename",fileArray[i].getName());

                createlayout(fileArray[i].getName());
            }
        }
    }
}
