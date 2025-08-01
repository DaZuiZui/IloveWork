package com.example.helloworld;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;

public class ShowWorkDataAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Project project = e.getProject();
        if (project == null) return;

        if (!WorkSettingsManager.hasData()) {
            Messages.showInfoMessage(project,
                    "还没有设置工作数据，请先进行设置！",
                    "work info");
            return;
        }

        long totalMinutes = WorkSettingsManager.getTotalWorkMinutes();
        long workedMinutes = WorkSettingsManager.getWorkedMinutesSoFar();
        double salaryPerMinute = WorkSettingsManager.getDailySalary() / totalMinutes;  // 日工资除以总分钟数
        double earnedMoney = workedMinutes * salaryPerMinute;

        String message = String.format(
                "=== 这点B班上的你妈的不值得 fucking ===\n" +
                        "月工资: %s 元\n" +
                        "日工资: %.2f 元\n" +
                        "上午工作时间: %s\n" +
                        "下午工作时间: %s\n" +
                        "夜间工作时间: %s\n" +
                        "总工作分钟数: %d 分钟\n" +
                        "目前工作分钟数: %d 分钟\n" +
                        "已赚金额: %.2f 元\n" +
                        "==================",
                WorkSettingsManager.getMonthlySalary(),
                WorkSettingsManager.getDailySalary(),
                WorkSettingsManager.getMorningTime(),
                WorkSettingsManager.getAfternoonTime(),
                WorkSettingsManager.getNightTime(),
                totalMinutes,
                workedMinutes,
                earnedMoney
        );

        Messages.showInfoMessage(project, message, "当前工作设置");
    }
}
