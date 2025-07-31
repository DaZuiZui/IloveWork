package com.example.helloworld;

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
} 