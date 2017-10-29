package com.hp.up.business.test.message;

import com.hp.up.business.service.AliMessageService;
import com.hp.up.core.utils.shortMsg.aliMsg.CodeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * com.hp.up.business.test.message
 * Created by haopeng on 2017/10/28  11:26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/spring-context.xml")
public class AliMessage {
    @Autowired
    AliMessageService aliMessageService;

    @Test
    public void sendMsg(){
        String phoneNum = "18802953162";
        String code = CodeUtil.genarate(CodeUtil.SIX_BIT);
        System.out.println(code);
        boolean result = aliMessageService.sendMessage(phoneNum, code);
        System.out.println(result);
    }

    /**
     * public static void main(String[] args) throws ClientException, InterruptedException {

     //发短信
     String phoneNum = "18802953162";
     SendSmsResponse response = sendMsg(phoneNum, CodeUtil.genarate(CodeUtil.SIX_BIT));
     System.out.println("短信接口返回的数据----------------");
     System.out.println("Code=" + response.getCode());
     System.out.println("Message=" + response.getMessage());
     System.out.println("RequestId=" + response.getRequestId());
     System.out.println("BizId=" + response.getBizId());
     Thread.sleep(3000L);

     //查明细
     if(response.getCode() != null && response.getCode().equals("OK")) {
     QuerySendDetailsResponse querySendDetailsResponse = querySendDetails(response.getBizId(),phoneNum);
     System.out.println("短信明细查询接口返回数据----------------");
     System.out.println("Code=" + querySendDetailsResponse.getCode());
     System.out.println("Message=" + querySendDetailsResponse.getMessage());
     int i = 0;
     for(QuerySendDetailsResponse.SmsSendDetailDTO smsSendDetailDTO : querySendDetailsResponse.getSmsSendDetailDTOs())
     {
     System.out.println("SmsSendDetailDTO["+i+"]:");
     System.out.println("Content=" + smsSendDetailDTO.getContent());
     System.out.println("ErrCode=" + smsSendDetailDTO.getErrCode());
     System.out.println("OutId=" + smsSendDetailDTO.getOutId());
     System.out.println("PhoneNum=" + smsSendDetailDTO.getPhoneNum());
     System.out.println("ReceiveDate=" + smsSendDetailDTO.getReceiveDate());
     System.out.println("SendDate=" + smsSendDetailDTO.getSendDate());
     System.out.println("SendStatus=" + smsSendDetailDTO.getSendStatus());
     System.out.println("Template=" + smsSendDetailDTO.getTemplateCode());
     }
     System.out.println("TotalCount=" + querySendDetailsResponse.getTotalCount());
     System.out.println("RequestId=" + querySendDetailsResponse.getRequestId());
     }

     }
     */



}
