package com.developmentteam.brothersdeliveryapi.config.doc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.servers.ServerVariable;
import org.springframework.context.annotation.Configuration;

@Configuration()
@OpenAPIDefinition(
        info = @Info(
                title = "Brothers Delivery",
                version = "0.0.1",
                description = "brothers delivery api documentation",
                license = @License(
                        name = "MIT",
                        url = "https://opensource.org/licenses/MIT"
                ),
                contact = @Contact(
                        name = "Development Team",
                        email = "java.development.tm@gmail.com",
                        url = "https://github.com/DevelopmentTeam"
                )
        ),
        servers = {
                @Server(url = "http://localhost:9000", description = "development server"),
                @Server(url = "Undefined", description = "deployment server",
                        variables = {
                                @ServerVariable(name = "var1", defaultValue = "undefined"),
                                @ServerVariable(name = "var2", defaultValue = "undefined"),
                                @ServerVariable(name = "var3", defaultValue = "undefined"),
                                @ServerVariable(name = "var4", defaultValue = "undefined"),
                                @ServerVariable(name = "var5", defaultValue = "undefined"),
                        }
                )
        }
)
@SecurityScheme(
        name = OpenApiConfig.SECURITY_SCHEME_NAME,
        description = "autenticação  baseada em jwt",
        scheme = "bearer",
        bearerFormat = "JWT",
        type = SecuritySchemeType.HTTP,
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {

   // link: http://localhost:8080/swagger-ui/index.html#/

   public static final String SECURITY_SCHEME_NAME = "bearerToken";

}
