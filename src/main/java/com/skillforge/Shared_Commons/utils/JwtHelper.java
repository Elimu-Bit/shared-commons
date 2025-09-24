package com.skillforge.Shared_Commons.utils;

// Helper for parsing token, no secret

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtHelper {

    /**
     * Extract username from token WITHOUT validation
     * Used by services to identify user from token
     * Actual validation should be done by User-Service
     */
    public String getUsernameFromToken(String token) {
        try {
            // This is unsafe parsing - only for getting claims, not validation
            String[] chunks = token.split("\\.");
            if (chunks.length != 3) return null;

            // Decode payload (this doesn't validate signature!)
            String payload = new String(java.util.Base64.getUrlDecoder().decode(chunks[1]));
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            com.fasterxml.jackson.databind.JsonNode claims = mapper.readTree(payload);

            return claims.get("sub").asText();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Extract user ID from token WITHOUT validation
     */
    public Long getUserIdFromToken(String token) {
        try {
            String[] chunks = token.split("\\.");
            if (chunks.length != 3) return null;

            String payload = new String(java.util.Base64.getUrlDecoder().decode(chunks[1]));
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            com.fasterxml.jackson.databind.JsonNode claims = mapper.readTree(payload);

            return claims.get("userId").asLong();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Check if token is expired WITHOUT validation
     * This is just for quick checks - not security validation
     */
    public Boolean isTokenExpiredUnsafe(String token) {
        try {
            String[] chunks = token.split("\\.");
            if (chunks.length != 3) return true;

            String payload = new String(java.util.Base64.getUrlDecoder().decode(chunks[1]));
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            com.fasterxml.jackson.databind.JsonNode claims = mapper.readTree(payload);

            long exp = claims.get("exp").asLong();
            return new Date(exp * 1000).before(new Date());
        } catch (Exception e) {
            return true;
        }
    }

}
