package com.example.git_grass_reader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class toTeamgrass_receiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String which_block = intent.getExtras().getString("selected_team_name");
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        Intent teamgrass_intent = new Intent(context, invidual_teamgrass.class);

        teamgrass_intent.putExtra("selected_team_name",which_block);

        context.startActivity(teamgrass_intent);

    }
}
