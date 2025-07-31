package com.example.helloworld;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

public class HelloWorldMenuAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        // 这个Action不执行任何操作，只是作为父菜单
    }
} 