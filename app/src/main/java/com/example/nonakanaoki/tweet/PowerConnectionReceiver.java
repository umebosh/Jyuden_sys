package com.example.nonakanaoki.tweet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.util.Date;

import twitter4j.AsyncTwitter;
import twitter4j.AsyncTwitterFactory;
import twitter4j.auth.AccessToken;

/**
 * Created by nonakanaoki on 15/10/15.
 */
public class PowerConnectionReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "isCharging", Toast.LENGTH_LONG).show();

        Keys keys = new Keys();
        AsyncTwitter twitter = new AsyncTwitterFactory().getInstance();
        AccessToken at = new AccessToken(keys.getAct(), keys.getActs());
        twitter.setOAuthConsumer(keys.getCk(), keys.getCs());
        twitter.setOAuthAccessToken(at);

        Date date = new Date();
        String msg = date.toString() + "に充電が開始されたよ";
        twitter.updateStatus(msg);

    }
}
