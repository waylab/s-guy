package org.waylab.sgy;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.waylab.sgy.swagger.SwaggerConfiguration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;

import com.google.common.base.Predicate;

@SpringBootApplication
@EnableDiscoveryClient
@Import({SwaggerConfiguration.class})
//@PropertySource(value="config/rabbit.properties")
public class SgyUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(SgyUserApplication.class, args);
    }

    @Bean
    public Predicate<String> swaggerPaths() {
      return regex("/users.*|/sign.*|/log.*|/withdrawal.*|/cargo.*");
    }

    @Bean
    public ApiInfo apiInfo() {
      return new ApiInfoBuilder()
              .title("Cargo User API")
              .description("Cargo Tracker User API")
              .contact("Anyframe Cloud Edition")
              .license("Anyframe Cloud Ed.")
              .version("1.0")
              .build();
    }
}
