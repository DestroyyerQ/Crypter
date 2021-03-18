package xyz.destroyyerq.crypter.api;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;

public class CrypterAPI
{
    public static void crypter(int cipherMode, String secretKey, File file, String algorithm) throws Exception {
        Key keyGen = new SecretKeySpec(secretKey.getBytes(), algorithm);
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(cipherMode, keyGen);

        FileInputStream fis = new FileInputStream(file);
        byte[] fisBytes = new byte[(int) file.length()];
        fis.read(fisBytes);

        FileOutputStream fos = new FileOutputStream(file);
        fos.write(cipher.doFinal(fisBytes));

        fis.close();
        fos.close();
    }
}
