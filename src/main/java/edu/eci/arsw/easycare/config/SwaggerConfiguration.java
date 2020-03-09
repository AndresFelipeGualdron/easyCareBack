package edu.eci.arsw.easycare.config;


import com.google.common.base.Predicate;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;

import springfox.documentation.builders.RequestHandlerSelectors;

import springfox.documentation.service.ApiInfo;

import springfox.documentation.spi.DocumentationType;

import springfox.documentation.spring.web.plugins.Docket;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {


    @Bean

    public Docket easyCareApi() {

        return new Docket(DocumentationType.SWAGGER_2)

                .apiInfo(easyCareApiInfo())

                .select()

                .paths(easyCarePaths())

                .apis(RequestHandlerSelectors.any())

                .build()

                .useDefaultResponseMessages(false);

    }


    private ApiInfo easyCareApiInfo() {

        return new ApiInfoBuilder()

                .title("Servicio Easy Care")

                .version("1.0")

                .license("Apache License Version 2.0")

                .build();

    }


    private Predicate<String> easyCarePaths() {
        return or(
                regex("/clients.*"),
                regex("/paseadores.*"),
                regex("/mascotas.*"),
                regex("/paseos.*"),
                regex("/subastas.*")
                );
    }
}
