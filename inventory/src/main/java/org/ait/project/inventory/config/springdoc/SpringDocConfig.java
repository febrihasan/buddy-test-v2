package org.ait.project.inventory.config.springdoc;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    /**.
    * This method for detail description spring document with swagger ui
    * @return api information for spring document with swagger ui
    */
    @Bean
    public OpenAPI springDocAPI() {
        return new OpenAPI()
                .info(new Info().title("Inventory Service APIs")
                        .description("Inventory services application")
                        .version("v1.0")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Inventory Service APIs Documentation")
                        .url("http://localhost:8084/api/swagger-ui/index.html"));
    }

}
