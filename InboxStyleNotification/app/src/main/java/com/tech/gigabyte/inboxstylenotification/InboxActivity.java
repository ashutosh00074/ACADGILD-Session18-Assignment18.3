package com.tech.gigabyte.inboxstylenotification;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by GIGABYTE on 06-Jun-17.
 *
 * My INBOX Activity
 */

public class InboxActivity extends AppCompatActivity {
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);
        txt = (TextView) findViewById(R.id.textView_inbox);
    }
}