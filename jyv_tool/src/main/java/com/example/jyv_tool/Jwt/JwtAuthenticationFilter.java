package com.example.jyv_tool.Jwt;


import com.example.jyv_tool.Infraestructure.util.Exception.UserNameNotFoundException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal( @NonNull HttpServletRequest request,@NonNull HttpServletResponse response,
    @NonNull FilterChain filterChain
    ) throws ServletException, IOException {

        String ruta = request.getServletPath();

        if (ruta.equals("/Home") || ruta.equals("/loginVista") ||ruta.equals("/registrar") ||
            ruta.equals("/Pagos") || ruta.equals("/Factura") ||
            ruta.equals("/favicon.ico") || ruta.startsWith("/css/") ||
            ruta.startsWith("/js/") || ruta.startsWith("/img/") ||
            ruta.startsWith("/auth/")) {
            
            filterChain.doFilter(request, response);
            return;
        }

        final String token;
        String jwtCookie = null;

        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if ("jwtToken".equals(cookie.getName())) {
                    jwtCookie = cookie.getValue();
                    break;
                }
            }
        }

        if (jwtCookie == null) {
            filterChain.doFilter(request, response);
            return;
        }

        token = jwtCookie;

        final String userEmail;

        try {
            userEmail = jwtService.getUsernameFromToken(token); 
            
            if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
                
                if (jwtService.isTokenValid(token, userDetails)) {
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                    );
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                    System.out.println("Usuario autenticando" + userDetails.getUsername() + "a la ruta" + ruta);
                } else {
                    System.out.println("token invalido para usuario" + userEmail);
                }
            }
        } catch (ExpiredJwtException e) {
            System.out.println("El token expiro " + e.getMessage() + " para ruta: " + ruta);
        } catch (SignatureException | MalformedJwtException e) {
            System.out.println("el token es invalido" + e.getMessage() + " para ruta: " + ruta);
        } catch (UserNameNotFoundException e) {
            System.out.println("Username Incorrecto" + e.getMessage() + " Con ruta" + ruta);
        }

        filterChain.doFilter(request, response);
    }
}