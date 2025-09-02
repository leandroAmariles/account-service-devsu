package com.devsu.accountservice.infraestructure.config;


import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

import javax.net.ssl.SSLException;
import java.time.Duration;

@Configuration
public class WebClientConfig {

    @Bean
    public org.springframework.web.reactive.function.client.WebClient inSecureWebClient() throws SSLException {
        SslContext sslContext = SslContextBuilder
                .forClient()
                .trustManager(InsecureTrustManagerFactory.INSTANCE)
                .build();

        HttpClient httpClient = HttpClient.create(ConnectionProvider
                        .builder("connectionProvider")
                        .maxConnections(100)
                        .maxLifeTime(Duration.ofSeconds(30))
                        .pendingAcquireTimeout(Duration.ofSeconds(60))
                        .build())
                .secure(t -> t.sslContext(sslContext));
        return org.springframework.web.reactive.function.client.WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }
}
