package priv.zc.utils;

import java.util.Arrays;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;

public class SignUtils {
    /**
     * 获取sign的方法
     *
     * @param params         加密数据
     * @param signKey        签名的key
     * @param signToken      签名的token
     * @param paramSeperator 数据分隔符
     * @param pairConnector  数据key和value的分隔符
     *
     * @return
     */
    public static String getSign(Map<String, String> params, String signKey, String signToken, String paramSeperator,
                                 String pairConnector) {
        //key值排序
        String[] keys = params.keySet().toArray(new String[params.size()]);
        Arrays.sort(keys);
        //获取被加密串
        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            String value = params.get(key);
            if (value != null && key.length() != 0 && value.length() != 0) {
                sb.append(key).append(pairConnector).append(value).append(paramSeperator);
            }
        }
        //加上token
        if (signKey != null && signKey.length() != 0) {
            sb.append(signKey).append(pairConnector);
        }
        sb.append(signToken);
        String md5 = DigestUtils.md5Hex(sb.toString());
        return md5;
    }

}
