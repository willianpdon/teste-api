package teste.api.configuracao;

import org.springframework.context.annotation.Bean;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spring.web.plugins.Docket;

public class ApplicationSwaggerConfig {

    @Bean
    public springfox.documentation.spring.web.plugins.Docket docket() {
        Docket docket = new Docket(springfox.documentation.spi.DocumentationType.SWAGGER_2);
        return docket.apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Teste API",
                "Modelagem da serviço rest teste-api",
                "Versão API 1.0",
                "Termos de uso",
                "willianpdon@gmail.com",
                "",
                ""
                );
        return apiInfo;
    }

}
