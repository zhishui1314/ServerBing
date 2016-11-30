package com.anke.vehicle.serverbing;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class MyService2 extends Service {
    public MyService2() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
       return new MyBinder();
    }
    public class MyBinder extends IMyAidlInterface.Stub{
        @Override
        public int methods() {
            return 1;
        }
    }
}
