package Server;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("Server")
@PropertySource("classpath:app.properties")
public class ServerConfig {
}
