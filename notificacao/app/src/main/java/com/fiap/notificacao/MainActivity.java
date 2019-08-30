package com.fiap.notificacao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void emitirNotificacao(View view){
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationChannel nc = new NotificationChannel("alertas","Promoção",nm.IMPORTANCE_DEFAULT);

        nc.setDescription("Notificações referentes ás promoções principais da loja");
        nc.enableLights(true);
        nc.setLightColor(Color.RED);
        nc.setVibrationPattern(new long[]{0,1000,500,1000,500,4000});
        nc.enableVibration(true);


        nm.createNotificationChannel(nc);


        NotificationCompat.Builder notification = new NotificationCompat.Builder(this,"alertas");
        notification.setContentTitle("Queima de estoque");
        notification.setChannelId("alertas");
        notification.setContentText("O patrão ficou louco!Produtos com até 90% de desconto!!");
        notification.setSmallIcon(R.mipmap.ic_launcher);

        notification.setContentIntent(PendingIntent.getActivity(this,0,new Intent(this,MainActivity.class),
                ,
                PendingIntent.FLAG_UPDATE_CURRENT));

        nm.notify(100,notification.build());



    }

}
