package com.hy.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * 拦截器属性文件
 *
 * @author wyx
 */
@ConfigurationProperties(prefix = "com.hy.interceptors")
@Data
public class InterceptorProperties {

    private Map<String, InterceptorInfo> key = new HashMap<>();

    @Data
    public static class InterceptorInfo {
        private int order = -1;
        private String[] pathPatterns = new String[]{"/**"};
        private String[] excludePathPatterns;

    }

}
