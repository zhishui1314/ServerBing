package com.anke.vehicle.serverbing;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    MyService1.MyBinder myBinder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this,MyService1.class);
        startService(intent);
        bindService(intent,conn,BIND_AUTO_CREATE);
    }
    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
           myBinder = (MyService1.MyBinder) iBinder;
            MyService1 server = myBinder.getServer();
            server.setsListener(new MyService1.SListener() {
                @Override
                public void onResult(int i) {
                    if (i == 1){
                        Log.e("获取到值拉","1111");
                    }
                }
            });
            myBinder.methods();


        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.e("onServiceDisconnected","服务断开连接");
        }
    };
}
