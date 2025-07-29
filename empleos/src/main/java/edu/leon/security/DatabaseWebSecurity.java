package edu.leon.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity {

    //tablas por defecto
    /*@Bean
    UserDetailsManager users(DataSource dataSource){//se inyecta  desde application.properties
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);

        return users;
    }*/
    //tablas personalizadas
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.setUsersByUsernameQuery("select username, password, estatus from Usuarios where username=?");
        users.setAuthoritiesByUsernameQuery("select u.username, p.perfil from UsuarioPerfil up " +
                "inner join Usuarios u on   u.id = up.idUsuario " +
                "inner join Perfiles p on   p.id = up.idPerfil " +
                "where u.username=?");
        return users;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize ->
                authorize
                        //recursos estaticos no requiren autenticacion
                        .requestMatchers("/bootstrap/**", "/images/**", "/tinymce/**", "/logos/**").permitAll()
                        //las vistas publicas no requieren autenticacion
                        .requestMatchers("/", "/signup", "/search", "/vacantes/view/**").permitAll()
                        //todas las demas vistas requieren autenticacion
                        .anyRequest().authenticated());
        //el formulario de login no requiere autenticacion
        http.formLogin(form -> form.permitAll());
        return http.build();
    }
}
