package no.havleik.joinfacestest;

import no.havleik.joinfacestest.scope.ViewScope;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;

@SpringBootApplication
public class JsftestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsftestApplication.class, args);
	}

    @Bean
	public static ViewScope viewScope() {
		return new ViewScope();
	}

    @Bean
    public static CustomScopeConfigurer scopeConfigurer() {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("view", viewScope());
        configurer.setScopes(hashMap);
        return configurer;
    }
}
