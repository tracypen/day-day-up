package com.hp.up.business.test;

import com.qiniu.common.Zone;
import com.qiniu.storage.Configuration;
import com.qiniu.util.Auth;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.StringMap;

import java.io.IOException;

/**
 * @Author haopeng
 * @Date 2017/10/13 15:24
 */
public class QiniuUtil {

    //设置好账号的ACCESS_KEY和SECRET_KEY
    private String ACCESS_KEY = "8RqeDjBEXVPK_ydlSiNTkXoi9SBsF-tBPJ21PtNS"; //这两个登录七牛 账号里面可以找到
    private String SECRET_KEY = "pRkEFX-RSIWLY93Kd1NostyIA68p7s42LBMqzRpG";

    //要上传的空间
    private String bucketname = "youbatis"; //对应要上传到七牛上 你的那个路径（自己建文件夹 注意设置公开）
    //上传到七牛后保存的文件名
    private String key = null;
    //上传文件的路径
    private String FilePath = "d:\\a9.jpg";  //本地要上传文件路径

    //密钥配置
    private Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    //构造一个带指定Zone对象的配置类
    Configuration cfg = new Configuration(Zone.zone0());
    //...其他参数参考类注释
    UploadManager uploadManager = new UploadManager(cfg);

    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public String getUpToken() {
        //有时候我们希望能自定义这个返回的JSON格式的内容，可以通过设置returnBody参数来实现，在returnBody中，我们可以使用七牛支持的魔法变量和自定义变量。
        StringMap putPolicy = new StringMap();
        putPolicy.put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":$(fsize)}");
        long expireSeconds = 3600;
        return auth.uploadToken(bucketname, null, expireSeconds, putPolicy);
    }

    //普通上传
    public void upload() throws IOException {
        try {
            //调用put方法上传
            // 支持字节数组上传
            // byte[] uploadBytes = "hello qiniu cloud".getBytes("utf-8");
            // Response res = uploadManager.put(FilePath, key, getUpToken());
            Response res = uploadManager.put(FilePath, key, getUpToken());
            //打印返回的信息
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                //响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException e1) {
                e1.printStackTrace();
            }
        }
    }

    public static void main(String args[]) throws IOException {
        new QiniuUtil().upload();
    }

}
