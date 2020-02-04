package com.example.git_grass_reader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedList;

public class invidual_teamgrass extends AppCompatActivity {
    String path;
    LinkedList<String> name_array = new LinkedList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invidual_teamgrass);//새로운 창 띄우기;
        path = getFilesDir().getPath();
        Intent intent = getIntent();
        String which_block = intent.getExtras().getString("selected_team_name");
        Log.i("received by Teamgrass",which_block);

        File file = new File(path+"/"+which_block+".txt");

        try {
            FileReader filereader = new FileReader(file);
            BufferedReader bufreader = new BufferedReader(filereader);
            String line = "";
            while((line = bufreader.readLine()) != null){
                name_array.add(line);
                Log.e("registered id", name_array.getLast());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
