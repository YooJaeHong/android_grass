package com.example.git_grass_reader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class invidual_teamgrass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invidual_teamgrass);

        String team_name = getIntent().getExtras().getString("selected_team_name");

        File file = new File(team_name+".txt");//팀네임 txt파일or 하나로 통합후 진행

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        int[] readed_data = new int[100];
        try{
            FileInputStream fin = new FileInputStream(file);
            for(int i=0;i<100;i++){
                readed_data[i] = fin.read();
                if(readed_data[i] == -1) {
                    break;
                }
                buffer.write(readed_data[i],0,);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
