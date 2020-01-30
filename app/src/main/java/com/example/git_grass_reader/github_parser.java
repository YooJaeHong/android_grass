package com.example.git_grass_reader;

import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class github_parser extends AsyncTask<Void, Void, Elements> {

    List<String> all_date = new ArrayList<>();
    List<String> all_colors = new ArrayList<>();
    protected  void onPreExecute(){
        super.onPreExecute();
    }

    @Override
    protected Elements doInBackground(Void... params) {
            String useragent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36";
            Document doc = null;
            try {
                Log.e("파싱한하기전:","abce");
                doc = Jsoup.connect("https://github.com/YooJaehong").userAgent(useragent).get();

            }
            catch (Exception e){
                e.printStackTrace();
            }
            //Log.e("파싱후:","abce");
           // Log.e("파싱한 값 전체:",doc.html());
            Elements dates = doc.select("rect[class=day]");

            return dates;
    }

}
