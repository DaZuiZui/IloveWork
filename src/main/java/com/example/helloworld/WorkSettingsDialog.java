package com.example.helloworld;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.ValidationInfo;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

public class WorkSettingsDialog extends DialogWrapper {
    private JBTextField salaryField;
    private JBTextField morningTimeField;
    private JBTextField afternoonTimeField;
    private JBTextField nightTimeField;

    public WorkSettingsDialog(@Nullable Project project) {
        super(project);
        init();
        setTitle("工作设置");
        
        // 加载已保存的数据
        salaryField.setText(WorkSettingsManager.getMonthlySalary());
        morningTimeField.setText(WorkSettingsManager.getMorningTime());
        afternoonTimeField.setText(WorkSettingsManager.getAfternoonTime());
        nightTimeField.setText(WorkSettingsManager.getNightTime());
    }

    @Override
    protected @Nullable JComponent createCenterPanel() {
        salaryField = new JBTextField();
        morningTimeField = new JBTextField();
        afternoonTimeField = new JBTextField();
        nightTimeField = new JBTextField();

        // 设置提示文本
        salaryField.getEmptyText().setText("请输入你的月工资");
        morningTimeField.getEmptyText().setText("格式：HH:MM-HH:MM，例如：09:30-12:00");
        afternoonTimeField.getEmptyText().setText("格式：HH:MM-HH:MM，例如：14:00-18:00");
        nightTimeField.getEmptyText().setText("格式：HH:MM-HH:MM，例如：19:00-22:00");

        JPanel dialogPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent(new JBLabel("月工资: "), salaryField, 1, false)
                .addLabeledComponent(new JBLabel("上午工作时间: "), morningTimeField, 1, false)
                .addLabeledComponent(new JBLabel("下午工作时间: "), afternoonTimeField, 1, false)
                .addLabeledComponent(new JBLabel("夜间工作时间: "), nightTimeField, 1, false)
                .addComponentFillVertically(new JPanel(), 0)
                .getPanel();
        dialogPanel.setPreferredSize(new Dimension(450, 250));
        return dialogPanel;
    }

    public String getSalary() {
        return salaryField.getText();
    }

    public String getMorningTime() {
        return morningTimeField.getText();
    }

    public String getAfternoonTime() {
        return afternoonTimeField.getText();
    }

    public String getNightTime() {
        return nightTimeField.getText();
    }
} 