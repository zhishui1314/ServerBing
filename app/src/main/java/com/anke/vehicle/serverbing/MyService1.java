package com.anke.vehicle.serverbing;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService1 extends Service {

    @Override
    public IBinder onBind(Intent intent) {

      return new MyBinder();
    }
 public class MyBinder extends Binder{
        MyService1 getServer(){
            return MyService1.this;
        }
        public void methods(){
            sListener.onResult(1);
        }
    }
   public SListener sListener;

    public void setsListener(SListener sListener) {
        this.sListener = sListener;
    }

    public interface SListener{
        void onResult(int i);
    }
}
