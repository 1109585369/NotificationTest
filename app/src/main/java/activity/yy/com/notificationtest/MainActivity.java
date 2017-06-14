package activity.yy.com.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button sendNotice = (Button) findViewById(R.id.send_noice);

        sendNotice.setOnClickListener(this);


    }




    
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.send_noice:
                Intent intent=new Intent(this,NotificationActivity.class);
                PendingIntent pi=PendingIntent.getActivities(this,0, new Intent[]{intent},0);

                NotificationManager manager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification=  new NotificationCompat.Builder(this).setDefaults(Notification.DEFAULT_SOUND)
                        .setStyle(new android.support.v4.app.NotificationCompat.BigTextStyle().bigText("我们在Android系统发送一条Notification的时候，经常需要通过震动或声音来提醒用户。如何为Notification设置声音和震动了。大致思路有： \n" +
                                "- AndroidNotification系统默认的声音和震动 \n" +
                                "- 为AndroidNotification设置自定义的声音和震动 \n" +
                                "- 自己使用Vibrator和SoundPool来产生声音和震动"))
                        .setContentTitle("this is content title")
                        .setContentText("this is content text")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentIntent(pi)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher)).build();
                manager.notify(1,notification);
                break;

            default:
                break;
        }
    }
}
