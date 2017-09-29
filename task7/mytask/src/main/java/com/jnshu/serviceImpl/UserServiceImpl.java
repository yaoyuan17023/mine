package com.jnshu.serviceImpl;

import com.cloopen.rest.sdk.CCPRestSmsSDK;
import com.google.gson.Gson;
import com.jnshu.dao.UserMapper;
import com.jnshu.entities.User;
import com.jnshu.service.UserService;
import com.jnshu.utils.MemcachedUtil;
import com.jnshu.utils.RedisUtil;
import com.jnshu.utils.SerializeUtil;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * created by 姚远 on 2017/9/7.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public boolean isRightUser(String user,String password){
        System.out.println("输入的账号:" + user + "输入的密码:" + password);
        if (MemcachedUtil.get("users") == null){
            System.out.println("查数据库了");
            User user1=userMapper.isRightUser(user,password);
            if (user1 != null){
                return true;
            }
        }
        System.out.println("查缓存");
        return true;
//    if (userMapper.isRightUser(user,password) == null){
//        return false;
//    }return true;
    }

    public List<User> userAll(){
//        if (MemcachedUtil.get("users")==null){
            List users=userMapper.userAll();
//            MemcachedUtil.set("users",users);
            System.out.println("数据库");
            return users;
//        }else {
//            System.out.println("缓存");
//         return (List)MemcachedUtil.get("users");
//        }
//        Jedis redis = new Jedis("127.0.0.1",6379);
//        Jedis redis=RedisUtil.getJedis();
//        if(redis.get("users")==null) {
//            List user = userMapper.userAll();
//            redis.set("users".getBytes(), SerializeUtil. serialize(user));
//            System.out.println("这是数据库");
//            return user;
//        }else{
//            System.out.println("这是缓存");
//            byte[] value = redis.get("users".getBytes());
//            redis.close();
//            return (List)SerializeUtil. unserialize(value);
//        }
    }
    public User selectByName(String user){
        return userMapper.selectByName(user);
    }
    public int insert(User user) {
        Integer i=userMapper.insert(user);
        List users=userMapper.userAll();
        MemcachedUtil.set("users",users);
        System.out.println("users="+MemcachedUtil.get("users"));
        return i;
    }
    public User select(int id){
        return userMapper.select(id);
    }

    public boolean sendEmail(String email){
        try{//邮箱验证的逻辑块
            HttpClient httpclient = HttpClientBuilder.create().build();
            HttpPost httpost = new HttpPost("http://api.sendcloud.net/apiv2/mail/send");

            List params = new ArrayList();
            // 您需要登录SendCloud创建API_USER，使用API_USER和API_KEY才可以进行邮件的发送。
            params.add(new BasicNameValuePair("apiUser", "RoyalSlayer_test_yMIUO9 "));
            params.add(new BasicNameValuePair("apiKey", "9pkCB7gnSYUUyJG7"));
            params.add(new BasicNameValuePair("from", "sendcloud@sendcloud.org"));
            params.add(new BasicNameValuePair("fromName", "Father"));
            params.add(new BasicNameValuePair("to", email));
            params.add(new BasicNameValuePair("subject", "来自SendCloud的邮件！"));
            params.add(new BasicNameValuePair("html", "恭喜你，终于TMD收到邮件了！"));

            httpost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            // 请求
            HttpResponse response = httpclient.execute(httpost);
            // 处理响应
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) { // 正常返回
                // 读取xml文档
                String result = EntityUtils.toString(response.getEntity());
                System.out.println(result);
                return true;
            } else {
                System.err.println("error");
            }
            httpost.releaseConnection();

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

//    public void sendMessage(String mobile,String number){
//
//            HashMap<String, Object> result = null;
//            CCPRestSmsSDK restAPI= new CCPRestSmsSDK();
//            restAPI.init("app.cloopen.com", "8883");
//            restAPI.setAccount("8aaf07085ea24877015eb7f7095006c0", "34cc3fbe581e431896bf8a937826eb06");
//            restAPI.setAppId("8aaf07085ea24877015eb7f7099006c4");
//            result = restAPI.sendTemplateSMS(mobile,"1" ,new String[]{number,"1"});
//            System.out.println("SDKTestGetSubAccounts result=" + result);
//        if ("000000".equals(result.get("statusCode"))) {
//            HashMap<String, Object> data = (HashMap<String, Object>) result.get("data");
//            Set<String> keySet = data.keySet();
//            for (String key : keySet) {
//                Object object = data.get(key);
//                System.out.println(key + " = " + object);
//            }
//        } else {
//            System.out.println("错误码=" + result.get("statusCode") + " 错误信息= " + result.get("statusMsg"));
//        }
//
//    }

//    public void sendPicture(){
//        Configuration cfg = new Configuration(Zone.zone2());
//        //...其他参数参考类注释
//        UploadManager uploadManager = new UploadManager(cfg);
//        //...生成上传凭证，然后准备上传
//        String accessKey = "awJe3Lnn4W8m-FgxbjANo6oe8owIOWQdakQf8Ns7";
//        String secretKey = "CJFjd2XXXdrFfJtPHIhJ0w6aiUki-WB4xtRbVIeV";
//        String bucket = "yaoyuan";
//        //如果是Windows情况下，格式是 D:\\qiniu\\test.png
//        String localFilePath = "G:\\01.jpg";
//        //默认不指定key的情况下，以文件内容的hash值作为文件名
//        String key = null;
//        Auth auth = Auth.create(accessKey, secretKey);
//        String upToken = auth.uploadToken(bucket);
//        try {
//            Response response = uploadManager.put(localFilePath, key, upToken);
//            //解析上传成功的结果
//            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
//            System.out.println(putRet.key);
//            System.out.println(putRet.hash);
//        } catch (QiniuException ex) {
//            Response r = ex.response;
//            System.err.println(r.toString());
//            try {
//                System.err.println(r.bodyString());
//            } catch (QiniuException ex2) {
//                //ignore
//            }
//        }
//    }

    public void qingniu(String file){
        System.out.println("Enter StudentServiceImpl.putPicture()");
        //用来存文件名
        String key = null;
        try {
//            //图片上传逻辑块
//            //打开文件选择对话框
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//            JFileChooser fileChooser = new JFileChooser();
//            fileChooser.showOpenDialog(null);
//            String filePath = "" + fileChooser.getSelectedFile();
//            String fileName = "" + fileChooser.getSelectedFile().getName();
//            System.out.println("选择文件路径： " + filePath);
//            System.out.println("选择文件的文件名： " + fileName);

            String newURL = file.replaceAll("\\\\", "/");
            System.out.println("转义后的文件路径：" + newURL);


            //构造一个带指定Zone对象的配置类
            Configuration cfg = new Configuration(Zone.zone2());
//...其他参数参考类注释

            UploadManager uploadManager = new UploadManager(cfg);
//...生成上传凭证，然后准备上传

//如果是Windows情况下，格式是 D:\\qiniu\\test.png
//        String localFilePath = "D:\\image\\1.jsp";
//默认不指定key的情况下，以文件内容的hash值作为文件名
            key = file;

            Auth auth = Auth.create("awJe3Lnn4W8m-FgxbjANo6oe8owIOWQdakQf8Ns7", "CJFjd2XXXdrFfJtPHIhJ0w6aiUki-WB4xtRbVIeV");
            String upToken = auth.uploadToken("yaoyuan");

            try {
                Response response = uploadManager.put(newURL, key, upToken);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                System.out.println(putRet.key);
                System.out.println(putRet.hash);
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

