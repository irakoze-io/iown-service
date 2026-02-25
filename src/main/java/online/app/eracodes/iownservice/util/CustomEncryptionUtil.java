package online.app.eracodes.iownservice.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class CustomEncryptionUtil {

    private final static Logger log = LoggerFactory.getLogger(CustomEncryptionUtil.class);

    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private final SecretKey secretKey;

    public CustomEncryptionUtil(String key) {
        secretKey = new SecretKeySpec(resolveKeyBytes(key), "AES");
    }

    public String encrypt(String value) throws Exception {
        log.info("Encryption original value using algo: {}", ALGORITHM);
        var cipher = Cipher.getInstance(ALGORITHM);
        var ivSpec = new IvParameterSpec(new byte[cipher.getBlockSize()]);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);

        var encryptedBytes = cipher.doFinal(value.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public String decrypt(String src) throws Exception {
        var cipher = Cipher.getInstance(ALGORITHM);
        var ivSpec = new IvParameterSpec(new byte[cipher.getBlockSize()]);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);

        var decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(src));
        return new String(decryptedBytes);
    }

    private static byte[] resolveKeyBytes(String key) {
        if (isHex(key) && key.length() % 2 == 0) {
            var decoded = hexToBytes(key);
            validateAesKeyLength(decoded.length);
            return decoded;
        }

        var raw = key.getBytes(StandardCharsets.UTF_8);
        validateAesKeyLength(raw.length);
        return raw;
    }

    private static void validateAesKeyLength(int length) {
        if (length != 16 && length != 24 && length != 32) {
            throw new IllegalArgumentException(
                    "Invalid AES key length: " + length + " bytes. Expected 16, 24, or 32 bytes.");
        }
    }

    private static boolean isHex(String value) {
        for (int i = 0; i < value.length(); i++) {
            if (Character.digit(value.charAt(i), 16) == -1) {
                return false;
            }
        }
        return true;
    }

    private static byte[] hexToBytes(String hex) {
        var bytes = new byte[hex.length() / 2];
        for (int i = 0; i < hex.length(); i += 2) {
            bytes[i / 2] = (byte) Integer.parseInt(hex.substring(i, i + 2), 16);
        }
        return bytes;
    }
}
