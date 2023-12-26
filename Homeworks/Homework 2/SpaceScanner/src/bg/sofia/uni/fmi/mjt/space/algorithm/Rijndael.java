package bg.sofia.uni.fmi.mjt.space.algorithm;

import bg.sofia.uni.fmi.mjt.space.exception.CipherException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.io.InputStream;
import java.io.OutputStream;

public class Rijndael implements SymmetricBlockCipher {

    private static final int KILOBYTE = 1024;
    private static final String ENCRYPTION_ALGORITHM = "AES";
    private static final String KEY_FILE_PATH = "secret.key";
    private static final int KEY_SIZE_IN_BITS = 128;

    SecretKey secretKey;
    public Rijndael(SecretKey secretKey) {
        this.secretKey = secretKey;
    }

}
