package com.hp.up.core.utils.web;

import com.hp.up.core.utils.json.JsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @Author haopeng
 * @Date 2017/9/11 9:29
 */
public class RenderUtils {

    private static final Logger logger = LoggerFactory.getLogger(RenderUtils.class);

    //返回JSON格式数据
    public static <T> ResponseEntity<T> getJsonResponseEntity(Object obj) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", MediaTypes.APPLICATION_JSON_UTF_8);
        String json = JsonMapper.nonNullMapper().toJson(obj);
        logger.info(json);
        return new ResponseEntity(json, responseHeaders, HttpStatus.OK);
    }

    //返回script脚本
    public static <T> ResponseEntity<T> getScriptResponseEntity(Object obj) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", MediaTypes.TEXT_PLAIN_UTF_8);
        return new ResponseEntity(obj.toString(), responseHeaders, HttpStatus.OK);
    }
}
