package com.vinfai.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;
import org.apache.commons.collections.map.CaseInsensitiveMap;
import org.apache.http.HttpStatus;

public class HttpResult {
    private Map<String, String> responseHeader = Maps.newHashMap();//new CaseInsensitiveMap();
    private List<String[]/*cookiename,cookiepath,value,expire(yyyy-mm-dd HH:mm:ss)*/> cookies = new ArrayList<String[]>();
    /**
     * cookiename,cookiepath,value,expire(yyyy-mm-dd HH:mm:ss)
     * @return
     */
    public List<String[]> getCookies() {
        return cookies;
    }
    private boolean success;
    private String response;
    private String msg;
    private int status;

    public HttpResult(boolean success, String response, String msg){
        this.success = success;
        this.response = response;
        this.msg = msg;
    }

    public HttpResult(boolean success, String response, String msg, int status){
        this.success = success;
        this.response = response;
        this.msg = msg;
        this.status = status;
    }

    public String getResponse() {
        return response;
    }
    public void setResponse(String response) {
        this.response = response;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public static HttpResult getSuccessReturn(String result) {
        return new HttpResult(true, result, null, HttpStatus.SC_OK);
    }
    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static HttpResult getFailure(String msg) {
        return new HttpResult(false, null, msg);
    }
    public static HttpResult getFailure(String msg, int status) {
        return new HttpResult(false, null, msg, status);
    }

    public static HttpResult getFailure(String msg, int status, String content) {
        return new HttpResult(false, content, msg, status);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void addHeader(String name, String value) {
        responseHeader.put(name, value);
    }
    public String getHeader(String name) {
        return responseHeader.get(name);
    }
    public Map<String, String> getAllHeaders(){
        return responseHeader;
    }
   /* public void addCookie(String name,String path, String value, Date expire){
        cookies.add(new String[]{name, path, value, DateUtil.formatTimestamp(expire)});
    }*/
}
