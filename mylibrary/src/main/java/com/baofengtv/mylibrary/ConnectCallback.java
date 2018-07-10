package com.baofengtv.mylibrary;

public abstract class ConnectCallback {
    public static final int CONNECT_OK = 0;
    public static final int CONNECT_FAIL = 1;

    public static final int BT_FAIL_NOT_SCANED          =  100;   //蓝牙未扫描到魔投设备
    public static final int BT_FAIL_BOND                 =  101;   //蓝牙配对失败
    public static final int BT_FAIL_CONNECT              =  102;   //蓝牙连接失败
    public static final int BT_FAIL_CHECK_CLIENT        =  103;   //蓝牙连接校验客户端数据失败
    public static final int BT_FAIL_CHECK_SERVER        =  104 ;  //蓝牙连接校验服务器端数据失败

    public static final int WIFI_FAIL_NOT_SCANED        =   200;  //wifi热点没有扫描到。
    public static final int WIFI_FAIL_ASSOC              =  201;  //wifi关联失败
    public static final int WIFI_FAIL_AUTH               = 202; //wifi认证失败
    public static final int WIFI_DHCP_FAILUE            = 203; //DHCP失败
    public static final int WIFI_UDP_FAILURE            =  204;//UDP启动失败
    public static final int WIFI_TCP_FAILURE              =205;  //TCP连接失败

    public void onConnectResult(int connectType,int result ,int errorcode){

    }

    public void onConnectStatusChange(int connectType,int status){

    }

}
