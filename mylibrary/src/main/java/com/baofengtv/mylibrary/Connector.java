package com.baofengtv.mylibrary;

import android.Manifest;
import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.browse.MediaBrowser;
import android.os.Build;
import android.os.Message;
import android.os.ParcelUuid;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import java.util.List;

import static android.support.v4.app.ActivityCompat.startActivityForResult;

public class Connector {

    public static final int CONNECT_TYPE_BLUETOOTH = 0;
    public static final int CONNECT_TYPE_WIFI = 1;
    public static final int CONNECT_TYPE_BOTH_WIFI_BT = 2;

    public static final int ROLE_CLIENT=0;
    public static final int ROLE_SERVER =1;
    private int mRole;
    private Context mContext;

    private static final int REQUEST_ENABLE_BT = 1;

    private BluetoothAdapter mBtAdapter;
    private BluetoothLeScanner mBleScanner;
    private BluetoothLeAdvertiser mBleAdvertiser;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Connector(Context context,int role) {
        mContext = context;
        this.mRole = role;
        mBtAdapter = BluetoothAdapter.getDefaultAdapter();
        mBleScanner = mBtAdapter.getBluetoothLeScanner();
        mBleAdvertiser = mBtAdapter.getBluetoothLeAdvertiser();
        //TODO: Check Whether Support LeScanner and LeAdvertiser
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void connect(Context context, int connectType, final ConnectCallback callback){
        switch (connectType) {
            case CONNECT_TYPE_BLUETOOTH:
                connectBluetooth(callback);
                break;
            case CONNECT_TYPE_WIFI:
                connectWiFi(callback);
                break;
            case CONNECT_TYPE_BOTH_WIFI_BT:
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void connectBluetooth(final ConnectCallback callback){
        if(!mBtAdapter.isEnabled()){
            //Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            //startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
            //TODO: Start Activity For Open Bluetooth
            return;
        }

        if(Build.VERSION.SDK_INT >=23) {
            //TODO: Request Permission
        }

        if(mBtAdapter.isDiscovering()) {
            mBtAdapter.cancelDiscovery();
        }
        mBleScanner.stopScan(mBleScanCallbak);
    }


     ScanCallback mBleScanCallbak = new ScanCallback() {
        @Override
        public void onScanResult(int callbackType, ScanResult result) {
            super.onScanResult(callbackType, result);
        }

        @Override
        public void onBatchScanResults(List<ScanResult> results) {
            super.onBatchScanResults(results);
        }

        @Override
        public void onScanFailed(int errorCode) {
            super.onScanFailed(errorCode);
        }

    };

    AdvertiseCallback mBleAdvtiseCallBack = new  AdvertiseCallback(){
        @Override
        public void onStartSuccess(AdvertiseSettings settingsInEffect) {
            super.onStartSuccess(settingsInEffect);
        }
        @Override
        public void onStartFailure(int errorCode) {
            super.onStartFailure(errorCode);
        }
    };


    private void connectWiFi(final ConnectCallback callback){

    }

    private void disconnect(){

    }

    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            }
    };

}
