package com.cl.utils;

import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @Description:
 * @Author: liugenhua
 * @Date created in 2019/1/9 14:37
 */
public class RsaUtil {

    private static final String RAS_KEY_FACTORY = "RSA";

    private static final String SIGNATURE_INSTANCE = "MD5withRSA";

    public static String[] getSecretKey() throws NoSuchAlgorithmException {
        String [] secretKey = new String[2];

        Object [] keyPairArr = initSecretKey();
        RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPairArr[0];
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPairArr[1];

        secretKey[0] = Base64Util.encode(rsaPublicKey.getEncoded());
        secretKey[1] = Base64Util.encode(rsaPrivateKey.getEncoded());
        return secretKey;
    }

    /**
     * 获取公钥私钥
     * @return
     * @throws NoSuchAlgorithmException
     */
    private static Object[] initSecretKey() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RAS_KEY_FACTORY);
        keyPairGenerator.initialize(512);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();

        Object[] keyPairArr = new Object[2];
        keyPairArr[0] = rsaPublicKey;
        keyPairArr[1] = rsaPrivateKey;

        return keyPairArr;
    }

    /**
     * 获取签名
     * @param rsaPrivateKey
     * @param content
     * @return
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws SignatureException
     */
    public static String executeSignature(String rsaPrivateKey, String content) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, SignatureException {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64Util.decode(rsaPrivateKey));
        KeyFactory keyFactory = KeyFactory.getInstance(RAS_KEY_FACTORY);
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Signature signature = Signature.getInstance(SIGNATURE_INSTANCE);
        signature.initSign(privateKey);
        signature.update(content.getBytes());
        byte[] result = signature.sign();
        return Base64Util.encode(result);
    }

    /**
     * 验证签名
     * @param rsaPublicKey
     * @param sign
     * @param content
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws InvalidKeyException
     * @throws SignatureException
     */
    public static boolean verifySignature(String rsaPublicKey, String sign, String content) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException{
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64Util.decode(rsaPublicKey));
        KeyFactory keyFactory = KeyFactory.getInstance(RAS_KEY_FACTORY);
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        Signature signature = Signature.getInstance(SIGNATURE_INSTANCE);
        signature.initVerify(publicKey);
        signature.update(content.getBytes());
        boolean bool = signature.verify(Base64Util.decode(sign));

        return bool;
    }
}
