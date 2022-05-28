package org.cuit.utils;

import java.util.Random;

/**
 * @author Devil
 * @date 2022-05-01-17:52
 */
public class InviteUtil {


    /**
     * 生成验证码的位数
     */
    private static final int GENERATE_VERIFICATION_CODE_LENGTH = 8;
    private static final String[] META_CODE = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
            "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "z", "b", "c", "d", "e", "f", "g", "h",
            "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y",
            "z"};

    /**
     * @return 4位邀请码
     */
    public static String generateInvitationCode() {
        Random random = new Random(System.currentTimeMillis());
        StringBuilder verificationCode = new StringBuilder();
        while (verificationCode.length() < GENERATE_VERIFICATION_CODE_LENGTH) {
            int i = random.nextInt(META_CODE.length);
            verificationCode.append(META_CODE[i]);
        }
        return verificationCode.toString();
    }
}
