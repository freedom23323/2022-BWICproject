package com.ebidding.common.cryto;

import org.bouncycastle.util.encoders.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class Hash {
    public static String encode(String salt, String data) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(salt.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
        mac.init(secret_key);
        return Hex.toHexString(mac.doFinal(data.getBytes(StandardCharsets.UTF_8)));
    }
}

