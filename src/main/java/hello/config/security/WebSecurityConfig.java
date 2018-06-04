package hello.config.security;

import hello.GreetingController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    Logger logger = LoggerFactory.getLogger(GreetingController.class);
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll();
    }
   /* @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.addAllowedOrigin("http://localhost:4200");
        configuration.addAllowedOrigin("*");
        configuration.addAllowedHeader("Access-Control-Allow-Origin: http://localhost:4200");
        configuration.addAllowedHeader("Access-Control-Allow-Origin: *");
        configuration.addAllowedHeader("Access-Control-Allow-Origin: *");
        configuration.addAllowedHeader("Access-Control-Allow-Methods: GET, POST, PATCH, PUT, DELETE, OPTIONS");
        configuration.addAllowedHeader("Access-Control-Allow-Headers: Origin, Content-Type, X-Auth-Token");
        configuration.addAllowedHeader("Content-Type");
        configuration.addAllowedMethod("GET");
        configuration.applyPermitDefaultValues();
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("*", configuration);
        return source;
    }*/
}
/*public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    Logger logger = LoggerFactory.getLogger(SpringSecurityConfig.class);

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.debug("some message");
        logger.error("22222");
        http
                .authorizeRequests()
                .antMatchers("/", "/greeting").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();


    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.addAllowedOrigin("http://localhost:4200");
        configuration.addAllowedHeader("Access-Control-Allow-Origin: http://localhost:4200");
        configuration.addAllowedHeader("Access-Control-Allow-Origin: *");
        configuration.addAllowedHeader("Access-Control-Allow-Methods: GET, POST, PATCH, PUT, DELETE, OPTIONS");
        configuration.addAllowedHeader("Access-Control-Allow-Headers: Origin, Content-Type, X-Auth-Token");
        configuration.addAllowedHeader("Content-Type");
        configuration.addAllowedMethod("GET");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        logger.debug("some message");
        logger.error("22222");
        return source;
    }
}*/