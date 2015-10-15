package com.example.nonakanaoki.tweet;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

import twitter4j.AsyncTwitter;
import twitter4j.AsyncTwitterFactory;
import twitter4j.auth.AccessToken;

public class MainActivity extends ActionBarActivity {

    private TextView textView;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ボタンの設定
        Button button = (Button) findViewById(R.id.buttonA);

        //TextViewの設定
        textView = (TextView) findViewById(R.id.textViewA);

        //リスナーをボタンに登録
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;

                if (counter % 2 == 0) {
                    textView.setText("Hello");
                } else {
                    textView.setText("World");
                }

                {   //つぶやく処理ひとまとめ
                    Keys keys = new Keys();
                    AsyncTwitter twitter = new AsyncTwitterFactory().getInstance();
                    AccessToken at = new AccessToken(keys.getAct(), keys.getActs());
                    twitter.setOAuthConsumer(keys.getCk(), keys.getCs());
                    twitter.setOAuthAccessToken(at);

                    Date date = new Date();
                    twitter.updateStatus(date.toString());
                }
            }
        });


    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
