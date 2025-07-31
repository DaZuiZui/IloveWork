package com.example.helloworld;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

public class WorkSettingsAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Project project = e.getProject();
        if (project == null) return;

        WorkSettingsDialog dialog = new WorkSettingsDialog(project);

                if (dialog.showAndGet()) {
            // 用户点击了OK按钮
            String salary = dialog.getSalary();
            String morningTime = dialog.getMorningTime();
            String afternoonTime = dialog.getAfternoonTime();
            String nightTime = dialog.getNightTime();
            
            // 保存数据到静态变量
            WorkSettingsManager.setMonthlySalary(salary);
            WorkSettingsManager.setMorningTime(morningTime);
            WorkSettingsManager.setAfternoonTime(afternoonTime);
            WorkSettingsManager.setNightTime(nightTime);
            
            // 计算日工资
            double dailySalary = WorkSettingsManager.getDailySalary();
            
            // 在控制台打印输入的内容
            System.out.println("=== 工作设置 ===");
            System.out.println("月工资: " + salary + " 元");
            System.out.println("日工资: " + String.format("%.2f", dailySalary) + " 元");
            System.out.println("上午工作时间: " + morningTime);
            System.out.println("下午工作时间: " + afternoonTime);
            System.out.println("夜间工作时间: " + nightTime);
            System.out.println("数据已保存！");
            System.out.println("==================");
        }
    }
}