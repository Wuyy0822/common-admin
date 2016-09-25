package com.panlingxiao.common_admin.util;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * Created by panlingxiao on 2016/9/25.
 */
public class PasswordUtil {

    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    /**
     * 对原来的凭证进行加密
     *
     * @param credential
     * @param salt
     * @param algorithmName
     * @param hashIterations
     * @return
     */
    public static String encryptCredentail(String credential, String salt, String algorithmName, int hashIterations) {

        String newCredential = new SimpleHash(
                algorithmName,
                credential,
                ByteSource.Util.bytes(salt),
                hashIterations).toHex();
        return newCredential;
    }

    /**
     * 根据指定的字符串生成盐值
     *
     * @return
     */
    public static String generateHalt() {
        return randomNumberGenerator.nextBytes().toHex();
    }
}
