package com.hp.up.core.utils.shortMsg.aliMsg;

/**
 * com.hp.up.core.utils.shortMsg.aliMsg
 * Created by haopeng on 2017/10/28  9:21.
 */
public class MsgConfig {

    /**
     *Key
     */
    String accessKeyID;

    /**
     *秘钥
     */
    String accessKeySecret;

    /**
     * 	短信签名
     */
    String signName;

    /**
     * 短信模板ID
     */
    String templateCode;

    public MsgConfig() {

    }

    public MsgConfig(String accessKeyID, String accessKeySecret, String signName, String templateCode) {
        this.accessKeyID = accessKeyID;
        this.accessKeySecret = accessKeySecret;
        this.signName = signName;
        this.templateCode = templateCode;
    }

    public String getAccessKeyID() {
        return accessKeyID;
    }

    public void setAccessKeyID(String accessKeyID) {
        this.accessKeyID = accessKeyID;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }
}
