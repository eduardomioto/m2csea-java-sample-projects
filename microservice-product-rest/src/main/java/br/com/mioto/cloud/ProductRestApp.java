package br.com.mioto.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.mioto.cloud.controllers.ConsulController;
import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableConfigurationProperties
@EnableFeignClients
@Slf4j
@SpringBootApplication
public class ProductRestApp {

    @Bean
    public AlwaysSampler defaultSampler() {
        return new AlwaysSampler();
    }

	 /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main( String[] args ) {
         ConfigurableApplicationContext context = SpringApplication.run(ProductRestApp.class, args);
    	 //After Start process, create or update dependencies entry on KV Store from Service Discovery
         context.getBean(ConsulController.class).kvPut();
    }
}
