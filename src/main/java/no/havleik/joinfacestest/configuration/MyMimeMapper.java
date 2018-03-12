package no.havleik.joinfacestest.configuration;

import org.springframework.boot.web.server.MimeMappings;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Bjørn T Johansen on 09.11.2015.
 */
@Configuration
public class MyMimeMapper implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>
{

    @Override
    public void customize(ConfigurableServletWebServerFactory factory) {
        MimeMappings mappings = new MimeMappings(MimeMappings.DEFAULT);
        mappings.add("ttf", "application/font-sfnt");
        mappings.add("woff", "application/font-woff");
        mappings.add("woff2", "application/font-woff2");
        mappings.add("eot", "application/vnd.ms-fontobject");
        mappings.add("eot?#iefix", "application/vnd.ms-fontobject");
        mappings.add("svg", "image/svg+xml");
        mappings.add("svg#exosemibold", "image/svg+xml");
        mappings.add("svg#exobolditalic", "image/svg+xml");
        mappings.add("svg#exomedium", "image/svg+xml");
        mappings.add("svg#exoregular", "image/svg+xml");
        mappings.add("svg#fontawesomeregular", "image/svg+xml");
        factory.setMimeMappings(mappings);
    }
}
