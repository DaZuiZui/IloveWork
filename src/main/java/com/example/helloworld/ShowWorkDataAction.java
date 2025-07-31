package com.example.helloworld;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

public class ShowWorkDataAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Project project = e.getProject();
        if (project == null) return;

        if (!WorkSettingsManager.hasData()) {
            System.out.println("=== 当前工作设置 ===");
            System.out.println("还没有设置工作数据，请先进行设置！");
            System.out.println("==================");
            return;
        }
        
        System.out.println("=== 当前工作设置 ===");
        System.out.println("月工资: " + WorkSettingsManager.getMonthlySalary() + " 元");
        System.out.println("日工资: " + String.format("%.2f", WorkSettingsManager.getDailySalary()) + " 元");
        System.out.println("上午工作时间: " + WorkSettingsManager.getMorningTime());
        System.out.println("下午工作时间: " + WorkSettingsManager.getAfternoonTime());
        System.out.println("夜间工作时间: " + WorkSettingsManager.getNightTime());
        System.out.println("==================");
    }
} 