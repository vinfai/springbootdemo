package com.vinfai.util;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author vinfai
 * @since 2017/5/11
 */
public class WebUtils {

    public static final Map<String, String> getRequestMap(HttpServletRequest request) {
        Map<String, String> result = Maps.newHashMap();
        Enumeration<String> it = request.getParameterNames();
        String key = null;
        while (it.hasMoreElements()) {
            key = it.nextElement();
            result.put(key, request.getParameter(key));
        }
        return result;
    }

    public static final String joinParams(Map params, boolean ignoreBlank) {
        StringBuilder content = new StringBuilder();
        List<String> keys = new ArrayList(params.keySet());
        Collections.sort(keys);
        for (String key : keys) {
            Object value = params.get(key);
            if (!ignoreBlank || value != null && StringUtils.isNotBlank("" + value))
                content.append(key + "=" + value + "&");
        }
        if (content.length() > 0)
            content.deleteCharAt(content.length() - 1);
        return content.toString();
    }
}
