package com.hrithik.customnotification.notficationBuilder;

import android.app.Notification;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;

import androidx.core.app.NotificationCompat;

import com.hrithik.customnotification.R;
import com.hrithik.customnotification.notificationHelper.SoundNotificationHelper;

public class GetSoundedBuilder {

    public static NotificationCompat.Builder getSoundedNotification(Context context){

        Uri soundUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE+ "://" +context.getApplicationContext().getPackageName()+"/"+ R.raw.whatsapp_web_tone);

        NotificationCompat.Builder mBuilder= new NotificationCompat.Builder(context.getApplicationContext(), SoundNotificationHelper.channelID)
                .setContentTitle("Sounded Notification")
                .setContentText("This notification makes sound on arrival")
                .setSound(soundUri);

        return mBuilder;
    }

}
