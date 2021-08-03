package com.hrithik.customnotification.notficationBuilder;

import static com.hrithik.customnotification.notificationHelper.NotificationHelper.channelID;

import android.content.Context;
import android.widget.RemoteViews;

import androidx.core.app.NotificationCompat;

import com.hrithik.customnotification.R;

public class GetCustomLayBuilder {

    public static NotificationCompat.Builder getCustomLayNotification(Context context){
        RemoteViews smallLayout = new RemoteViews(context.getPackageName(), R.layout.small_notification_layout);
        RemoteViews expandedLayout = new RemoteViews(context.getPackageName(), R.layout.expanded_notification_layout);

        smallLayout.setTextViewText(R.id.title,"Custom notification title");
        smallLayout.setTextViewText(R.id.text,"Text for the notification");

        NotificationCompat.Builder mBuilder= new NotificationCompat.Builder(context.getApplicationContext(), channelID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                .setCustomContentView(smallLayout);

        return mBuilder;
    }

}
