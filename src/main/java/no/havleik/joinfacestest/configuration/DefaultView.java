package no.havleik.joinfacestest.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by Bjørn T Johansen on 09.11.2015.
 */
@Configuration
public class DefaultView implements WebMvcConfigurer
{
    @Override
    public void addViewControllers( ViewControllerRegistry registry ) {
        registry.addViewController("/").setViewName("redirect:/index.xhtml");
    }
}
