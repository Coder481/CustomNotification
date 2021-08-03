package com.hrithik.customnotification.notificationHelper;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.hrithik.customnotification.Constants;
import com.hrithik.customnotification.R;
import com.hrithik.customnotification.notficationBuilder.GetCustomLayBuilder;
import com.hrithik.customnotification.notficationBuilder.GetSimpleBuilder;
import com.hrithik.customnotification.notficationBuilder.GetStyledBuilder;

public class NotificationHelper extends ContextWrapper {

    public static final String channelID = "channelID";
    public static final String channelName = "Channel Name";
    private NotificationManager mManager;
    private final Context context;

    public NotificationHelper(Context context) {
        super(context);
        this.context = context;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannel();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createChannel() {
        NotificationChannel channel = new NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_HIGH);

        getManager().createNotificationChannel(channel);
    }

    public NotificationManager getManager() {
        if (mManager == null) {
            mManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return mManager;
    }

    public NotificationCompat.Builder getBuilder(int notificationType){

        NotificationCompat.Builder mBuilder = null;

        switch (notificationType){
            case Constants.GET_SIMPLE_NOTIFICATION:
                mBuilder =  GetSimpleBuilder.getSimpleBuilder(context);
                break;

            case Constants.GET_LARGE_ICON_NOTIFICATION:
                mBuilder = GetSimpleBuilder.getLargeIconNotification(context);
                break;

            case Constants.GET_LARGE_TEXT_NOTIFICATION:
                String bigText = context.getString(R.string.big_text);
                mBuilder = GetStyledBuilder.getBigTextNotification(context,"Big Text Notification",bigText);
                break;

            case Constants.GET_EXP_IMG_NOTIFICATION:
                mBuilder = GetStyledBuilder.getImgExpandableNotification(context);
                break;

            case Constants.GET_INBOX_STYLED_NOTIFICATION:
                mBuilder = GetStyledBuilder.getInboxStyledNotification(context);
                break;

            case Constants.GET_MESSAGING_NOTIFICATION:
                mBuilder = GetStyledBuilder.getMessagingStyleNotification(context);
                break;

            case Constants.GET_CUSTOM_LAY_NOTIFICATION:
                mBuilder = GetCustomLayBuilder.getCustomLayNotification(context);
                break;
        }


        return mBuilder;
    }

}
