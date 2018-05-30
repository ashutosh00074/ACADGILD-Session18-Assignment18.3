package com.tech.gigabyte.inboxstylenotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_inbox_notification;
    private static final int INBOX_ID = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set the activity content from a layout resource.
        setContentView(R.layout.activity_main);
        btn_inbox_notification = (Button) findViewById(R.id.button_inbox_notification);
    }

    //On Click Button Showing Notification
    public void inboxclick(View view) {
        switch (view.getId()) {
            case R.id.button_inbox_notification:
                showinboxstylenotification();
                break;
        }
    }

    //Setting Up Notification
    private void showinboxstylenotification() {

        //Style of Notification --> InboxStyle
        NotificationCompat.InboxStyle inboxstyle = new NotificationCompat.InboxStyle();
        inboxstyle.setBigContentTitle(" ACADGILD ");
        inboxstyle.addLine("Session : Google Maps, GPS");
        inboxstyle.addLine("and Project II for ");
        inboxstyle.addLine("Android Developer Training Course");

        //Constructing the Notification Layouts
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
        builder.setContentTitle("Inbox Style Notification");
        builder.setContentText("Hello \n This is Inbox Style Notification");
        builder.setSmallIcon(R.drawable.ic_notification);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            builder.setColor(getColor(R.color.colorInbox));
        }
        builder.setTicker("Inbox Notification");
        builder.setAutoCancel(true);
        builder.setStyle(inboxstyle);

        //Setting Intent for "Inbox", "Reply"
        Intent inboxintent = new Intent(MainActivity.this, InboxActivity.class);
        //app navigation using the back key
        TaskStackBuilder stackbuilder_inbox = TaskStackBuilder.create(MainActivity.this);
        stackbuilder_inbox.addParentStack(InboxActivity.class);
        stackbuilder_inbox.addNextIntent(inboxintent);
        //Flag indicating that if the described PendingIntent already exists
        PendingIntent pending_intent_inbox = stackbuilder_inbox.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        //Taking to Inbox Activity
        builder.setContentIntent(pending_intent_inbox);
        builder.setContentIntent(pending_intent_inbox);
        builder.addAction(R.drawable.ic_inbox, "inbox", pending_intent_inbox);

        Intent replyintent = new Intent(MainActivity.this, ReplyActivity.class);
        TaskStackBuilder stackbuilder_reply = TaskStackBuilder.create(MainActivity.this);
        stackbuilder_reply.addParentStack(ReplyActivity.class);
        stackbuilder_reply.addNextIntent(replyintent);
        //Flag indicating that if the described PendingIntent already exists
        PendingIntent pending_intent_reply = stackbuilder_reply.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        //Taking to Inbox Activity
        builder.setContentIntent(pending_intent_reply);
        builder.setContentIntent(pending_intent_reply);
        builder.addAction(R.drawable.ic_reply, "Reply", pending_intent_reply);

        //Notify Created Notification
        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
        manager.notify(INBOX_ID, notification);
    }
}