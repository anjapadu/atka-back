package com.sourcecodeerror.swagger;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

  /**
   * Objeto Docket para la construcción de la documentación de los servicios.
   * @return Enrutamiento de controladores.
   */
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.regex("/api/v1.0.*")).build().apiInfo(apiInfo());
  }

  /**
   * Objeto ApiInfo para la información del Api
   * @return objeto contenedor de la informacion
   */
  private ApiInfo apiInfo() {
    return new ApiInfo("CHALLENNGE 1 - API",
        "Second Week Challenge API - Everis Bootcamp.", "API TOS", "Terms of service", 
        new Contact("Adrian Montenegro", "www.example.com", "amontenp@everis.com"), "Apache 2.0",
        "http://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
  }
}
