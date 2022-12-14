package com.georgesh.plugin.myplugin;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;


public class ActionPerformer extends AnAction {
    Provider provider = new Provider();

    public ActionPerformer() throws IOException {
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        try {
            provider.display();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
