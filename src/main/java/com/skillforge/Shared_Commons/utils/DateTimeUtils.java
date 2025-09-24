package com.skillforge.Shared_Commons.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

// For date, time validations and conversion to understandable format

@Component
public class DateTimeUtils {

    public static final DateTimeFormatter ISO_DATE_FORMAT = DateTimeFormatter.ISO_LOCAL_DATE;
    public static final DateTimeFormatter ISO_DATETIME_FORMAT = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    public static final DateTimeFormatter DISPLAY_DATE_FORMAT = DateTimeFormatter.ofPattern("MMM dd, yyyy");
    public static final DateTimeFormatter DISPLAY_DATETIME_FORMAT = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm");

    // Get current UTC time
    public LocalDateTime getCurrentUtcTime() {
        return LocalDateTime.now(ZoneOffset.UTC);
    }

    // Convert LocalDateTime to specific timezone
    public LocalDateTime convertToTimezone(LocalDateTime dateTime, String timezoneId) {
        ZoneId utcZone = ZoneOffset.UTC;
        ZoneId targetZone = ZoneId.of(timezoneId);

        return dateTime.atZone(utcZone).withZoneSameInstant(targetZone).toLocalDateTime();
    }

    // Calculate days between two dates
    public long daysBetween(LocalDateTime start, LocalDateTime end) {
        return ChronoUnit.DAYS.between(start.toLocalDate(), end.toLocalDate());
    }

    // Calculate hours between two dates
    public long hoursBetween(LocalDateTime start, LocalDateTime end) {
        return ChronoUnit.HOURS.between(start, end);
    }

    // Calculate minutes between two dates
    public long minutesBetween(LocalDateTime start, LocalDateTime end) {
        return ChronoUnit.MINUTES.between(start, end);
    }

    // Add days to a date
    public LocalDateTime addDays(LocalDateTime dateTime, long days) {
        return dateTime.plusDays(days);
    }

    // Add hours to a date
    public LocalDateTime addHours(LocalDateTime dateTime, long hours) {
        return dateTime.plusHours(hours);
    }

    // Add minutes to a date
    public LocalDateTime addMinutes(LocalDateTime dateTime, long minutes) {
        return dateTime.plusMinutes(minutes);
    }

    // Check if date is in the past
    public boolean isInPast(LocalDateTime dateTime) {
        return dateTime.isBefore(getCurrentUtcTime());
    }

    // Check if date is in the future
    public boolean isInFuture(LocalDateTime dateTime) {
        return dateTime.isAfter(getCurrentUtcTime());
    }

    // Get start of day
    public LocalDateTime startOfDay(LocalDateTime dateTime) {
        return dateTime.toLocalDate().atStartOfDay();
    }

    // Get end of day
    public LocalDateTime endOfDay(LocalDateTime dateTime) {
        return dateTime.toLocalDate().atTime(LocalTime.MAX);
    }

    // Format date for display
    public String formatForDisplay(LocalDateTime dateTime) {
        return dateTime.format(DISPLAY_DATETIME_FORMAT);
    }

    // Format date only for display
    public String formatDateForDisplay(LocalDateTime dateTime) {
        return dateTime.format(DISPLAY_DATE_FORMAT);
    }

    // Parse ISO date string
    public LocalDateTime parseIsoDateTime(String dateTimeString) {
        return LocalDateTime.parse(dateTimeString, ISO_DATETIME_FORMAT);
    }

    // Format to ISO string
    public String formatToIso(LocalDateTime dateTime) {
        return dateTime.format(ISO_DATETIME_FORMAT);
    }

}
