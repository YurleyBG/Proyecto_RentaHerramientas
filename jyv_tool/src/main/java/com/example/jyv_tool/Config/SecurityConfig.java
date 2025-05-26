package com.example.jyv_tool.Config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.jyv_tool.Jwt.JwtAuthenticationFilter;

import lombok.RequiredArgsConstructor;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;
    
    @Bean
    public SecurityFilterChain securityfilterchain (HttpSecurity http) throws Exception {

        http
            .csrf(csrf->csrf.disable())
            .authorizeHttpRequests(authRequests->
                authRequests
                .requestMatchers("/Api/**").permitAll()
                .requestMatchers("/Home","/auth/**","/loginVista","/registrar","/favicon.ico","/css/**","/js/**", "/img/**").permitAll()
                .requestMatchers("/PaginaPrincipal","/Pagos","/Factura","/Reservas","/Historial").hasAuthority("Cliente")
                .requestMatchers("/RegistroHerramientas").hasAuthority("Proveedor")
                .requestMatchers("/admin_reporte","/admin_registrar","/admin_historial","/admin_herramienta","/admin_eliminar","/admin_devolucion").hasAuthority("Administrador")
                .requestMatchers("/Perfil").hasAnyAuthority("Cliente", "Administrador", "Proveedor")
                .anyRequest().authenticated()
                )
            
            .sessionManagement(sessionManager -> 
                sessionManager
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authenticationProvider(authProvider)
            .addFilterBefore(jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class);
        
        return http.build();

    }

    @Bean 
    public CorsConfigurationSource  corsConfigurationSource(){
        CorsConfiguration config =new CorsConfiguration();

        config.setAllowedOrigins(List.of("http://localhost:8080"));
        config.setAllowedMethods(List.of("GET","POST","DELETE","PUT","OPTIONS"));
        config.setAllowedHeaders(List.of("*"));
        config.setAllowCredentials(true); 

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config); 
        return source;
    }
   

}
