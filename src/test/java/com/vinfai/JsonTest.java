package com.vinfai;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * @author vinfai
 * @since 2017/5/11
 */
public class JsonTest {

    public static void main(String[] args) {
        Map<String,String> params = Maps.newHashMap();
        params.put("tradeNo", "1150214211604506");
        params.put("orderType","MOVIE");
        params.put("totalAmount","3000");
        params.put("fee","3000");

        params.put("gatewayCode","unionWapPay");
        params.put("mobile","13552535506");
        params.put("quantity","0");
        params.put("ticketNum","2");
        params.put("createTime","2017-5-11 11:45:38");
        params.put("updateTime","2017-5-11 11:45:38");
        params.put("validTime","2017-5-11 11:55:38");
        params.put("subject", "格瓦拉电影票");
        params.put("description","格瓦拉电影票description");
        params.put("clientIp", "127.0.0.1");
        params.put("reserve1","");
        params.put("reserve2","");
        params.put("returnUrl","http://returnUrl");
        params.put("notifyUrl","http://notifyUrl");
        params.put("memberId","1");
        params.put("partnerId","50000960");
        params.put("reqSource","APP");
        params.put("discount","0");
        params.put("otherInfo", "");
        params.put("cardNo", "");
        params.put("nonceStr", "123456");
        params.put("v", "1.0");
        params.put("sign", "b6f55afd5c25b543f368cdcc1377fc54");
        String s = JSON.toJSONString(params);
        System.out.println(s);

        String result = "{\"totalAmount\":\"100\",\"tradeNo\":\"Test201751116647\",\"due\":\"100\",\"requestMethod\":\"post\",\"errorCode\":\"0000\",\"payUrl\":\"http://test.gewala.net/pay/wapPayRedirect.xhtml\",\"payParams\":[{\"paramName\":\"PAY_DATA_\",\"paramValue\":\"eyJodHRwRW5jb2RpbmciOiJ1dGYtOCIsInBheXVybCI6IiBodHRwczovLzEwMS4yMzEuMjA0LjgwOjUwMDAvZ2F0ZXdheS9hcGkvZnJvbnRUcmFuc1JlcS5kbyIsImh0dHBNZXRob2QiOiJwb3N0Iiwic3VibWl0UGFyYW1zIjoie1wiYml6VHlwZVwiOlwiMDAwMjAxXCIsXCJ0eG5TdWJUeXBlXCI6XCIwMVwiLFwiYmFja1VybFwiOlwiaHR0cDovL3Rlc3QuZ2V3YWxhLm5ldC9wYXkvdW5pb25XYXBQYXlOb3RpZnkueGh0bWxcIixcIm9yZGVySWRcIjpcIlRlc3QyMDE3NTExMTY2NDdcIixcInNpZ25hdHVyZVwiOlwiVmNuOWNOMWZhTC93Y2doTy9heUN0UVBCcE1LTVFPUWZmM2M3aGROcXJVZGZMM0I1TW84ejZLOXF5OUcrYjJSOHY5R0RwbWE3anJxOTcxWHZsZ1FEcUpYenljQ2x5MjFmL3I3clp3c01Hei9ONkZGTmJaM3RRNVloeWthaEVYdkhZeXN0aitTOXBCM2IwWDBqcnN6RnVvOHNLWHBDa1NKblJRenFNcms5QzRZPVwiLFwidHhuVHlwZVwiOlwiMDFcIixcImNoYW5uZWxUeXBlXCI6XCIwOFwiLFwiZnJvbnRVcmxcIjpcImh0dHA6Ly90ZXN0Lmdld2FsYS5uZXQvcGF5L3VuaW9uV2FwUGF5UmV0dXJuLnhodG1sXCIsXCJjZXJ0SWRcIjpcIjEyNDg3Njg4NTE4NTc5NDcyNjk4NjMwMTM1NTk1MTY3MDQ1MjcxOFwiLFwiZW5jb2RpbmdcIjpcIlVURi04XCIsXCJ2ZXJzaW9uXCI6XCI1LjAuMFwiLFwiYWNjZXNzVHlwZVwiOlwiMFwiLFwicmVxUmVzZXJ2ZWRcIjpcInVuaW9ud2FwcGF5XCIsXCJ0eG5UaW1lXCI6XCIyMDE3MDUxMTE2MDYwMFwiLFwibWVySWRcIjpcIjEwMzMxMDA3Mzk5MDE4OVwiLFwiY3VycmVuY3lDb2RlXCI6XCIxNTZcIixcInNpZ25NZXRob2RcIjpcIjAxXCIsXCJ0eG5BbXRcIjpcIjEwMFwifSJ9\"}]}";
        Map map = JSON.parseObject(result, Map.class);
        List<Map<String,String>> list = (List)map.get("payParams");
        for (Map<String, String> dataMap : list) {
            for (String key : dataMap.keySet()) {
                System.out.println(key+" --> "+ dataMap.get(key));
            }
        }

    }
}
