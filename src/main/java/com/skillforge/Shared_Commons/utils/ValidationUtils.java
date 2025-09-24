package com.skillforge.Shared_Commons.utils;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class ValidationUtils {

    // Email validation pattern
    public static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"
    );

    // Password validation pattern
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d@$!%*?&]{8,}$"
    );

    // Phone number validation pattern
    private static final Pattern PHONE_PATTERN = Pattern.compile(
            "^\\+?[1-9]\\d{1,14}$"
    );

    // Username validation pattern
    private static final Pattern USERNAME_PATTERN = Pattern.compile(
            "^[a-zA-Z0-9_]{3,30}$"
    );

    public boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    public boolean isValidPassword(String password) {
        return password != null && PASSWORD_PATTERN.matcher(password).matches();
    }

    public boolean isValidPhone(String phone) {
        return phone != null && PHONE_PATTERN.matcher(phone).matches();
    }

    public boolean isValidUsername(String username) {
        return username != null && USERNAME_PATTERN.matcher(username).matches();
    }

    public boolean isNotBlank(String str) {
        return str != null && !str.trim().isEmpty();
    }

    public boolean isValidLength(String str, int minLength, int maxLength) {
        if (str == null) return false;
        int length = str.length();
        return length >= minLength && length <= maxLength;
    }

    public boolean isPositiveNumber(Number number) {
        return number != null && number.doubleValue() > 0;
    }

    public boolean isNonNegativeNumber(Number number) {
        return number != null && number.doubleValue() >= 0;
    }

    public boolean isValidPercentage(Double percentage) {
        return percentage != null && percentage >= 0.0 && percentage <= 100.0;
    }

    // Course title validation
    public boolean isValidCourseTitle(String title) {
        return isNotBlank(title) && isValidLength(title, 5, 200);
    }

    // Course description validation
    public boolean isValidCourseDescription(String description) {
        return isNotBlank(description) && isValidLength(description, 20, 2000);
    }

    // Validate URL format
    public boolean isValidUrl(String url) {
        if (url == null || url.trim().isEmpty()) return false;
        try {
            java.net.URL validUrl = new java.net.URL(url);
            return true;
        } catch (java.net.MalformedURLException e) {
            return false;
        }
    }








}
