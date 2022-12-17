package com.georgesh.plugin.myplugin;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;


public class ActionPerformer extends AnAction {
    Provider provider = new Provider();

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        provider.display();
    }
}
