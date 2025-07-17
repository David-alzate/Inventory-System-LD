package co.inventory.system.ld.crosscutting.helpers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class JwtHelper {

    @Value("${security.jwt.key.private}")
    private String privateKey;

    @Value("${security.jwt.user.generator}")
    private String userGenerator;

    private static final long EXPIRATION_TIME_IN_MILLISEC = 1000L * 60L *60L *24L * 30L * 6L; // 6 meses

    public String createToken(Authentication authentication) {
        Algorithm algorithm = Algorithm.HMAC256(this.privateKey);
        String userName = authentication.getPrincipal().toString();

        String authorities = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        return JWT.create().withIssuer(this.userGenerator).withSubject(userName).withClaim("authorities", authorities)
                .withIssuedAt(new Date()).withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME_IN_MILLISEC))
                .withJWTId(UUID.randomUUID().toString()).withNotBefore(new Date(System.currentTimeMillis()))
                .sign(algorithm);
    }

    public DecodedJWT validateToken(String token) {
        try {

            Algorithm algorithm = Algorithm.HMAC256(this.privateKey);

            JWTVerifier verifier = JWT.require(algorithm).withIssuer(this.userGenerator).build();

            return verifier.verify(token);

        } catch (JWTVerificationException exception) {
            throw new JWTVerificationException("Token invalido, no autorizado");
        }

    }

    public String extractUserName(DecodedJWT decodedJWT) {
        return decodedJWT.getSubject();
    }
    public Claim getSpecificClaim(DecodedJWT decodedJWT, String claimName) {
        return decodedJWT.getClaim(claimName);
    }

    public Map<String, Claim> returnAllClaims(DecodedJWT decodedJWT) {
        return decodedJWT.getClaims();
    }
}

