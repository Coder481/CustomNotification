package com.hrithik.customnotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.os.Bundle;
import android.view.View;

import com.hrithik.customnotification.databinding.ActivityMainBinding;
import com.hrithik.customnotification.notificationHelper.NotificationHelper;
import com.hrithik.customnotification.notificationHelper.SoundNotificationHelper;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding b;
    private NotificationHelper notificationHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        notificationHelper = new NotificationHelper(this);

        setUpBtns();
    }

    private void setUpBtns() {
        b.simpleNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder nb = notificationHelper.getBuilder(Constants.GET_SIMPLE_NOTIFICATION);
                notificationHelper.getManager().notify(Constants.GET_SIMPLE_NOTIFICATION,nb.build());
            }
        });

        b.largeIconNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder nb = notificationHelper.getBuilder(Constants.GET_LARGE_ICON_NOTIFICATION);
                notificationHelper.getManager().notify(Constants.GET_LARGE_ICON_NOTIFICATION,nb.build());
            }
        });


        // Styled Notifications
        b.bigTextNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder nb = notificationHelper.getBuilder(Constants.GET_LARGE_TEXT_NOTIFICATION);
                notificationHelper.getManager().notify(Constants.GET_LARGE_TEXT_NOTIFICATION,nb.build());
            }
        });
        b.expImgNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder nb = notificationHelper.getBuilder(Constants.GET_EXP_IMG_NOTIFICATION);
                notificationHelper.getManager().notify(Constants.GET_EXP_IMG_NOTIFICATION,nb.build());
            }
        });
        b.inboxStyleNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder nb = notificationHelper.getBuilder(Constants.GET_INBOX_STYLED_NOTIFICATION);
                notificationHelper.getManager().notify(Constants.GET_INBOX_STYLED_NOTIFICATION,nb.build());
            }
        });
        b.messagingNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder nb = notificationHelper.getBuilder(Constants.GET_MESSAGING_NOTIFICATION);
                notificationHelper.getManager().notify(Constants.GET_MESSAGING_NOTIFICATION,nb.build());
            }
        });


        // Custom Layout Notification
        b.customLayNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder nb = notificationHelper.getBuilder(Constants.GET_CUSTOM_LAY_NOTIFICATION);
                notificationHelper.getManager().notify(Constants.GET_CUSTOM_LAY_NOTIFICATION,nb.build());
            }
        });


        // Sounded Notification
        b.soundedNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SoundNotificationHelper sNH = new SoundNotificationHelper(MainActivity.this);
                NotificationCompat.Builder nb = sNH.getSoundBuilder();
                sNH.getManager().notify(Constants.GET_SOUNDED_NOTIFICATION,nb.build());
            }
        });
    }
}