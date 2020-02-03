package com.example.git_grass_reader;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class teamgrass extends mygrass {
    Intent toTeamgrass = new Intent(this,invidual_teamgrass.class);
    public void createlayout(){


        final LinearLayout teamgrass_block = new LinearLayout(this);

        final TextView Team_title = new TextView(this);

        Team_title.setText("팀1");
        teamgrass_block.addView(Team_title);




        teamgrass_block.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                toTeamgrass.putExtra("seleted_team_name",Team_title.getText());

                startActivity(toTeamgrass);
            }
        });



        ScrollView teamlist_view = findViewById(R.id.팀잔디밭_scrollview);

        teamlist_view.addView(teamgrass_block);
    }
}
