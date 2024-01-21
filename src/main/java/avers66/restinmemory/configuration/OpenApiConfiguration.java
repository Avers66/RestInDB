package avers66.restinmemory.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * OpenApiConfiguration
 *
 * @Author Tretyakov Alexandr
 */

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI openApiPIDescription() {
        Server localHostServer = new Server();
        localHostServer.setUrl("http://localhost:8080");
        localHostServer.setDescription("Local env");

        Server productionServer = new Server();
        productionServer.setUrl("http://some.prod.url:8080");
        productionServer.setDescription("Production env");

        Contact contact = new Contact();
        contact.setName("Petr Petrov");
        contact.setEmail("some@some.com");
        contact.setUrl("http://some.url");

        License license = new License().name("GNU AGPLv3")
                .url("https://chooselicense.com/license/agpl-3.0/");

        Info info = new Info()
                .title("Client orders API ")
                .version("1.0")
                .contact(contact)
                .description("API for client orders")
                .termsOfService("http://some.term.url")
                .license(license);
        return new OpenAPI().info(info).servers(List.of(localHostServer, productionServer));
    }
}
