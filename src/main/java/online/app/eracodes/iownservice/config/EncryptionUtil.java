package online.app.eracodes.iownservice.config;

import online.app.eracodes.iownservice.util.CustomEncryptionUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class EncryptionUtil {

    protected final static String ENCRYPTION_KEY = "DDBD1FF66CD5B9ED212EB055FC4F50E2FE1FC16B9C64E58E2868116152A5CA07";

    @Bean
    CustomEncryptionUtil cryptoUtil() {
        return new CustomEncryptionUtil(ENCRYPTION_KEY);
    }
}
