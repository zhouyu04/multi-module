package com.zzyy.rs.security;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.codec.Utf8;

public class CustomMessageDigestPasswordEncoder extends MessageDigestPasswordEncoder {
    private static final Logger logger = LoggerFactory.getLogger(SystemAuthenticationFailureHandler.class);


    public CustomMessageDigestPasswordEncoder(String algorithm) {
        super(algorithm);
    }

    public CustomMessageDigestPasswordEncoder(String algorithm, boolean encodeHashAsBase64) throws IllegalArgumentException {
        super(algorithm, encodeHashAsBase64);
    }

    @Override
    public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
        String rsaDecodePassword = "";
/*        try {
            PrivateKey privateKey = RSASecurityUtil.getPrivateKey("/opt/script/apiPrivate.pem");
            rsaDecodePassword = RSASecurityUtil.decrypt(rawPass, privateKey.getEncoded());
        } catch (Exception e) {
            if (logger.isErrorEnabled()) {
                logger.error("decode rsa password exception:", e);
            }
        }*/
        if (StringUtils.isNotEmpty(rsaDecodePassword)) {
            rawPass = rsaDecodePassword;
        }
        String encodePassword = encodePassword(rawPass, salt);
        return passwordEquals(encPass, encodePassword);
    }

    protected boolean passwordEquals(String expected, String actual) {
        byte[] expectedBytes = bytesUtf8(expected);
        byte[] actualBytes = bytesUtf8(actual);
        int expectedLength = expectedBytes == null ? -1 : expectedBytes.length;
        int actualLength = actualBytes == null ? -1 : actualBytes.length;
        if (expectedLength != actualLength) {
            return false;
        } else {
            int result = 0;

            for (int i = 0; i < expectedLength; ++i) {
                result |= expectedBytes[i] ^ actualBytes[i];
            }

            return result == 0;
        }
    }

    private byte[] bytesUtf8(String s) {
        return s == null ? null : Utf8.encode(s);
    }
}
