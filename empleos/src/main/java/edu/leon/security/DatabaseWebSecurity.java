package edu.leon.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

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
}
