package com.hrithik.customnotification.notficationBuilder;

import static com.hrithik.customnotification.notificationHelper.NotificationHelper.channelID;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.core.app.NotificationCompat;

import com.hrithik.customnotification.R;

public class GetStyledBuilder {

    public static NotificationCompat.Builder getBigTextNotification(Context context, String title, String bigBody){

        NotificationCompat.Builder mBuilder= new NotificationCompat.Builder(context.getApplicationContext(), channelID)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(bigBody))
                .setContentTitle(title)
                .setContentText("Click this notification's header to see larger text.")
                .setSmallIcon(R.drawable.ic_launcher_foreground);

        return mBuilder;

    }

    public static NotificationCompat.Builder getImgExpandableNotification(Context context){

        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.android1);

        NotificationCompat.Builder mBuilder= new NotificationCompat.Builder(context.getApplicationContext(), channelID)
                .setLargeIcon(bitmap)
                .setStyle(new NotificationCompat.BigPictureStyle()
                        .bigPicture(bitmap)
                        .bigLargeIcon(null))
                .setContentTitle("Expandable Image")
                .setContentText("Click this notification's header to see expanded image")
                .setSmallIcon(R.drawable.ic_launcher_foreground);

        return mBuilder;
    }


    public static NotificationCompat.Builder getInboxStyledNotification(Context context){
        NotificationCompat.Builder mBuilder= new NotificationCompat.Builder(context.getApplicationContext(), channelID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Inbox style")
                .setContentText("This is the inbox styled notification")
                .setStyle(new NotificationCompat.InboxStyle()
                        .addLine("Inbox Line 1")
                        .addLine("Inbox Line 2"));

        return mBuilder;
    }

    public static NotificationCompat.Builder getMessagingStyleNotification(Context context){
        NotificationCompat.MessagingStyle.Message message1 = new NotificationCompat.MessagingStyle.Message("Hey buddy, what's up",
                1627906259,
                "Android");

        NotificationCompat.MessagingStyle.Message message2 = new NotificationCompat.MessagingStyle.Message("I am fine, what about you?",
                1627906326,
                "You");

        NotificationCompat.MessagingStyle.Message message3 = new NotificationCompat.MessagingStyle.Message("Good, \uD83D\uDE42\uD83D\uDE42",
                1627909912,
                "Android");

        NotificationCompat.Builder mBuilder= new NotificationCompat.Builder(context.getApplicationContext(), channelID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setStyle(new NotificationCompat.MessagingStyle("Reply Name")
                        .addMessage(message1)
                        .addMessage(message2)
                        .addMessage(message3));

        return mBuilder;
    }
}
