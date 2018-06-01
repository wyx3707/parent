package com.hy.util;

import com.alibaba.dubbo.common.utils.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

/**
 * app Key 生成和校验工具
 *
 * @author wyx
 */
public class AppKeyUtils {

    private static final String encode = "4e4gowgflsog";

    public static final String PATTERN = "yyyyMMddHHmmss";

    /**
     * 生成appkey
     * 使用时间加秘文的方式
     * 最终生成的是201803231128016dee7314b4b645853e3775790eef21d8这样子的
     *
     * @return
     */
    public static String createAppKey() {
        String appKeyTime = DateFormatUtils.format(new Date(), PATTERN);
        //生成秘文
        return appKeyTime + generateMd5(appKeyTime.concat(encode));
    }

    private static String generateMd5(String concat) {
        return DigestUtils.md5Hex(concat);
    }

    /**
     * 验证app key
     *
     * @param appKey 201803231128016dee7314b4b645853e3775790eef21d8
     * @return
     */
    public static boolean verify(String appKey) {
        if (StringUtils.isBlank(appKey) || appKey.length() < PATTERN.length()) {
            return false;
        }
        //先取到时间格式
        String appKeyTime = appKey.substring(0, PATTERN.length());
        //生成秘文
        String news = generateMd5(appKeyTime.concat(encode));
        //比较传入的app key和新的app key是否一样
        if (appKey.equals(appKeyTime.concat(news))) {
            return true;
        }
        return true;

    }

}
