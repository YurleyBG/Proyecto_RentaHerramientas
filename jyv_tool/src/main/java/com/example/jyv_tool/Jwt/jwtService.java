package com.example.jyv_tool.Jwt;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class jwtService {

    private static final String SECRET_KEY="435678939BDHJD43767384HJHHJDHJDHJ4267783894937HJHDHJHDHJ342453";
   
    public String getToken(UserDetails usuario){
        return getToken(new HashMap<>(),usuario);
    }

    private String getToken( Map<String,Object> extraClaims, UserDetails usuario) {
       return Jwts
            .builder()
            .claims(extraClaims)
            .subject(usuario.getUsername())
            .issuedAt(new Date(System.currentTimeMillis()))
            .expiration(new Date(System.currentTimeMillis()+1000*60*24))
            .signWith(getKey(), SignatureAlgorithm.HS256) 
            .compact();
    }
    private Key getKey() {
        byte[] keyBites = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBites);
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username= getUsernameFromToken(token);
        return(username.equals(userDetails.getUsername())&& !isTokenExpired(token));
    }

    public String getUsernameFromToken(String token) {
        return getClaim(token,Claims::getSubject);
        
    }

    private Claims getAllClaims(String token){

        return Jwts
            .parser()
            .setSigningKey(getKey())
            .build()
            .parseClaimsJws(token)
            .getBody();
    }
    public <T> T getClaim(String token , Function<Claims,T> claimsResolver){

        final Claims claims=getAllClaims(token);
        return claimsResolver.apply(claims) ;
        
    }
    private Date getExpiration(String token){
        return getClaim(token, Claims::getExpiration);
    }
    private boolean isTokenExpired(String token){
        return getExpiration(token).before(new Date());
    }

    

}
