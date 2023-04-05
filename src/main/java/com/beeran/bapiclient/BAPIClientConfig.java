package com.beeran.bapiclient;

import com.beeran.bapiclient.client.BAPIClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties("bapi.client")
@ComponentScan
public class BAPIClientConfig {
    private String accessKey;

    private String secretKey;

    @Bean
    public BAPIClient BAPIClient() {
        return new BAPIClient(accessKey, secretKey);
    }


}
