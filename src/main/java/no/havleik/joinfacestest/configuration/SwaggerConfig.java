package no.havleik.joinfacestest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Bjørn T Johansen on 21.09.2016
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig
{
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .description("This is the REST API for the testing")
                        .version("1.0.0")
                        .title("Joinfaces web app")
                        .termsOfServiceUrl("Terms of service URL")
                        .contact(new Contact("Company", null, "support@company.com"))
                        .license("Apache 2.0")
                        .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("no.havleik.joinfacestest"))
                .paths(PathSelectors.any())
                .build();
    }
}
