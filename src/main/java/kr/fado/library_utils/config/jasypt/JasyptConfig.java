package kr.fado.library_utils.config.jasypt;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JasyptConfig {

    @Value("${jasypt.encryptor.password}")
    private String encryptKey;

    @Bean("jasyptStringEncryptor")
    public StringEncryptor jasyptStringEncryptor() {

        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();

        config.setPassword(encryptKey);                         // 암호화 키 설정
        config.setAlgorithm("PBEWithMD5AndDES");                // devglan.com 암호화 사용
//        config.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");   // 강력한 AES 256bit 암호화 사용 (로컬 암호화 후 로컬 복호화 필요)
        config.setStringOutputType("base64");                   // 암호화된 결과물의 출력 형식
        config.setKeyObtentionIterations("1000");               // 키 획득 반복 횟수
        config.setPoolSize(4);                                  // 병렬 암호화 성능 향상
        config.setProviderName("SunJCE");                       // Java 표준 암호화 방식 사용
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");    // 랜덤 솔트 사용 (랜덤 사용 시 보안 향상 및 org.jasypt 사용 가능, 고정 시 보안 저하 org.jasypt 사용 불가능)

        encryptor.setConfig(config);
        return encryptor;
    }
}
