package dev.jtarango.customer_pannel.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import dev.jtarango.customer_pannel.models.User;

import java.util.Date;

public class JwtUtil {

    private static final String SECRET_KEY = "f4uyd78ft3q4";
    private static Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);

    public static String generateToken(User user){

        String token = JWT.create()
                .withIssuer("JTarango")
                .withClaim("userId", user.getId())
                .withIssuedAt(new Date())
                .withExpiresAt(getExpiresDate())
                .sign(algorithm);

        return token;
    }

    private static Date getExpiresDate(){
        return new Date(System.currentTimeMillis() + (1000L * 60 * 60 * 3)); //3 hours
    }


    public static String getUserIdByToken(String token){
        JWTVerifier verifier = JWT.require(algorithm).
                withIssuer("JTarango")
                .build();

        DecodedJWT decoded = verifier.verify(token);
        String userId = decoded.getClaim("userId").toString();

        return userId;
    }
}
