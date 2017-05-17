package com.vinfai.web.action;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.vinfai.util.HttpClientUtil;
import com.vinfai.util.StringUtil;
import com.vinfai.util.WebUtils;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author vinfai
 * @since 2017/5/10
 */
@Controller
@RequestMapping("/pay")
public class PayController {

    @RequestMapping(value = "payInfo",method = RequestMethod.GET)
    public String payinfo(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("ha ha ha ssss2");
        return "pay/payInfo";
    }

    @RequestMapping(value = "sumbitPayInfo",method = RequestMethod.POST)
    public String payinfo2(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        String pause = request.getParameter("pause");

        String orderno = request.getParameter("orderno");
        String fee = request.getParameter("fee");
        String merchantCode = request.getParameter("merchantCode");

        String gateway = request.getParameter("gateway");
        String mobile = request.getParameter("mobile");
        String quantity = request.getParameter("quantity");

        String createtime = request.getParameter("createtime");
        String updatetime = request.getParameter("updatetime");
        String validtime = request.getParameter("validtime");

        String subject = request.getParameter("subject");
        String clientIp = request.getParameter("clientIp");
        String otherinfo = request.getParameter("otherinfo");
        String description = request.getParameter("description");

        String orderType = request.getParameter("orderType");
        String returnUrl = request.getParameter("returnUrl");
        String notifyUrl = request.getParameter("notifyUrl");
        Map<String, String> paramMap = Maps.newHashMap();

        //
        paramMap.put("merid",request.getParameter("merid"));
        paramMap.put("tradeNo", orderno);
        paramMap.put("orderType",orderType);
        paramMap.put("fee", fee);
        paramMap.put("totalAmount",fee);
        paramMap.put("gatewayCode", request.getParameter("gatewayCode"));
        paramMap.put("merchantCode",merchantCode);
        paramMap.put("payBank", request.getParameter("payBank"));

        paramMap.put("mobile",mobile);
        paramMap.put("quantity",quantity);
        paramMap.put("ticketNum",request.getParameter("ticketNum"));
        paramMap.put("createTime",createtime);
        paramMap.put("updateTime",updatetime);
        paramMap.put("validTime",validtime);
        paramMap.put("subject", subject);
        paramMap.put("description",description);
        paramMap.put("clientIp", clientIp);
        paramMap.put("reserve1","");
        paramMap.put("reserve2","");
        paramMap.put("returnUrl",returnUrl);
        paramMap.put("notifyUrl",notifyUrl);

        paramMap.put("memberid",request.getParameter("memberid"));

        paramMap.put("partnerId",request.getParameter("partnerId"));
        paramMap.put("reqSource",request.getParameter("reqSource"));
        paramMap.put("discount","0");
        paramMap.put("otherInfo", otherinfo);
        paramMap.put("cardNo",request.getParameter("cardNo"));
        paramMap.put("nonceStr","123456");
        paramMap.put("v", "1.0");
        //
        String slat = "111111";
        String sign = genSignature(paramMap, slat);
        paramMap.put("sign", sign);


        String url = request.getParameter("url");
        //HttpClientUtil clientUtil = new HttpClientUtil();
        //String result = clientUtil.doPost(url, paramMap, "utf-8");
        String result = "{\"totalAmount\":\"100\",\"tradeNo\":\"Test201751116647\",\"due\":\"100\",\"requestMethod\":\"post\",\"errorCode\":\"0000\",\"payUrl\":\"http://test.gewala.net/pay/wapPayRedirect.xhtml\",\"payParams\":[{\"paramName\":\"PAY_DATA_\",\"paramValue\":\"eyJodHRwRW5jb2RpbmciOiJ1dGYtOCIsInBheXVybCI6IiBodHRwczovLzEwMS4yMzEuMjA0LjgwOjUwMDAvZ2F0ZXdheS9hcGkvZnJvbnRUcmFuc1JlcS5kbyIsImh0dHBNZXRob2QiOiJwb3N0Iiwic3VibWl0UGFyYW1zIjoie1wiYml6VHlwZVwiOlwiMDAwMjAxXCIsXCJ0eG5TdWJUeXBlXCI6XCIwMVwiLFwiYmFja1VybFwiOlwiaHR0cDovL3Rlc3QuZ2V3YWxhLm5ldC9wYXkvdW5pb25XYXBQYXlOb3RpZnkueGh0bWxcIixcIm9yZGVySWRcIjpcIlRlc3QyMDE3NTExMTY2NDdcIixcInNpZ25hdHVyZVwiOlwiVmNuOWNOMWZhTC93Y2doTy9heUN0UVBCcE1LTVFPUWZmM2M3aGROcXJVZGZMM0I1TW84ejZLOXF5OUcrYjJSOHY5R0RwbWE3anJxOTcxWHZsZ1FEcUpYenljQ2x5MjFmL3I3clp3c01Hei9ONkZGTmJaM3RRNVloeWthaEVYdkhZeXN0aitTOXBCM2IwWDBqcnN6RnVvOHNLWHBDa1NKblJRenFNcms5QzRZPVwiLFwidHhuVHlwZVwiOlwiMDFcIixcImNoYW5uZWxUeXBlXCI6XCIwOFwiLFwiZnJvbnRVcmxcIjpcImh0dHA6Ly90ZXN0Lmdld2FsYS5uZXQvcGF5L3VuaW9uV2FwUGF5UmV0dXJuLnhodG1sXCIsXCJjZXJ0SWRcIjpcIjEyNDg3Njg4NTE4NTc5NDcyNjk4NjMwMTM1NTk1MTY3MDQ1MjcxOFwiLFwiZW5jb2RpbmdcIjpcIlVURi04XCIsXCJ2ZXJzaW9uXCI6XCI1LjAuMFwiLFwiYWNjZXNzVHlwZVwiOlwiMFwiLFwicmVxUmVzZXJ2ZWRcIjpcInVuaW9ud2FwcGF5XCIsXCJ0eG5UaW1lXCI6XCIyMDE3MDUxMTE2MDYwMFwiLFwibWVySWRcIjpcIjEwMzMxMDA3Mzk5MDE4OVwiLFwiY3VycmVuY3lDb2RlXCI6XCIxNTZcIixcInNpZ25NZXRob2RcIjpcIjAxXCIsXCJ0eG5BbXRcIjpcIjEwMFwifSJ9\"}]}";

        System.out.println(result);
        Map map = JSON.parseObject(result, Map.class);
        List<Map<String,String>> list = (List)map.get("payParams");
        Map<String, String> resultMap = Maps.newHashMap();
        for (Map<String, String> pmap : list) {
            resultMap.put(pmap.get("paramName"), pmap.get("paramValue"));
        }
        model.put("payParams", resultMap);
        model.put("tradeNo", map.get("tradeNo"));
        model.put("requestMethod", map.get("requestMethod"));
        model.put("totalAmount", map.get("totalAmount"));
        model.put("payUrl", map.get("payUrl"));
        model.put("pause", pause);
        return "pay/tempSubmitForm";
    }

    /**
     * MD5 签名
     * @param params
     * @param slat
     * @return
     */
    private String genSignature(Map params, String slat) {
        String s = WebUtils.joinParams(params, true);
        s = s+"&key="+slat;
        String sign = StringUtil.md5(s, "UTF-8");
        return sign;
    }
}
