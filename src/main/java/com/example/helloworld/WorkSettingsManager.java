package com.example.helloworld;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class WorkSettingsManager {

    // 静态变量存储工作设置
    private static String monthlySalary = "";
    private static String morningTime = "";
    private static String afternoonTime = "";
    private static String nightTime = "";

    // 获取月工资
    public static String getMonthlySalary() {
        return monthlySalary;
    }

    // 设置月工资
    public static void setMonthlySalary(String salary) {
        monthlySalary = salary;
    }

    // 获取上午工作时间
    public static String getMorningTime() {
        return morningTime;
    }

    // 设置上午工作时间
    public static void setMorningTime(String time) {
        morningTime = time;
    }

    // 获取下午工作时间
    public static String getAfternoonTime() {
        return afternoonTime;
    }

    // 设置下午工作时间
    public static void setAfternoonTime(String time) {
        afternoonTime = time;
    }

    // 获取夜间工作时间
    public static String getNightTime() {
        return nightTime;
    }

    // 设置夜间工作时间
    public static void setNightTime(String time) {
        nightTime = time;
    }

    // 计算日工资
    public static double getDailySalary() {
        try {
            double salary = Double.parseDouble(monthlySalary);
            return salary / 21.75;
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    // 检查是否有数据
    public static boolean hasData() {
        return !monthlySalary.isEmpty() || !morningTime.isEmpty() ||
               !afternoonTime.isEmpty() || !nightTime.isEmpty();
    }

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    // 计算单个时间段的分钟数，比如 "09:00-12:00"
    public static long calculateMinutes(String timeRange) {
        if (timeRange == null || !timeRange.contains("-")) return 0;
        try {
            String[] parts = timeRange.split("-");
            LocalTime start = LocalTime.parse(parts[0].trim(), TIME_FORMATTER);
            LocalTime end = LocalTime.parse(parts[1].trim(), TIME_FORMATTER);
            if (end.isBefore(start)) {
                // 如果结束时间比开始时间早，认为是跨天，按24小时制算
                end = end.plusHours(24);
            }
            return ChronoUnit.MINUTES.between(start, end);
        } catch (Exception e) {
            return 0;
        }
    }

    // 计算总工作分钟数
    public static long getTotalWorkMinutes() {
        return calculateMinutes(morningTime) + calculateMinutes(afternoonTime) + calculateMinutes(nightTime);
    }

    // 每分钟工资 = 月工资 / (21.75天 * 8小时 * 60分钟)
    public static double getSalaryPerMinute() {
        try {
            double salary = Double.parseDouble(monthlySalary);
            return salary / (21.75 * 8 * 60);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    // 计算当前工作分钟数 * 每分钟工资 = 赚了多少钱
    public static double getEarnedMoney() {
        return getTotalWorkMinutes() * getSalaryPerMinute();
    }
}