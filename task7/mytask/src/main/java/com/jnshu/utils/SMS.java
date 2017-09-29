package com.jnshu.utils;

import com.cloopen.rest.sdk.CCPRestSmsSDK;

import java.util.HashMap;
import java.util.Set;

/**
 * created by 姚远 on 2017/9/28.
 */
public class SMS {
    private String serverIP;
    private String serverPort;
    private String accountSid;
    private String accountToken;
    private String appID;

    public String getServerIP() {
        return serverIP;
    }

    public void setServerIP(String serverIP) {
        this.serverIP = serverIP;
    }

    public String getServerPort() {
        return serverPort;
    }

    public void setServerPort(String serverPort) {
        this.serverPort = serverPort;
    }

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public String getAccountToken() {
        return accountToken;
    }

    public void setAccountToken(String accountToken) {
        this.accountToken = accountToken;
    }

    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public void sendMessage(String mobile, String number){


        HashMap<String, Object> result = null;
        CCPRestSmsSDK restAPI= new CCPRestSmsSDK();
        restAPI.init(serverIP, serverPort);
        restAPI.setAccount(accountSid, accountToken);
        restAPI.setAppId(appID);
        result = restAPI.sendTemplateSMS(mobile,"1" ,new String[]{number,"1"});
        System.out.println("SDKTestGetSubAccounts result=" + result);
        if ("000000".equals(result.get("statusCode"))) {
            HashMap<String, Object> data = (HashMap<String, Object>) result.get("data");
            Set<String> keySet = data.keySet();
            for (String key : keySet) {
                Object object = data.get(key);
                System.out.println(key + " = " + object);
            }
        } else {
            System.out.println("错误码=" + result.get("statusCode") + " 错误信息= " + result.get("statusMsg"));
        }

    }
}
