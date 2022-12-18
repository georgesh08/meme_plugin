package com.georgesh.plugin.myplugin;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetCustomMemFolderAction extends AnAction {
    private static JTextField input = new JTextField(20);
    private static JFrame frame;

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        frame = CreateWindow();
    }

    @Override
    public boolean isDumbAware(){
        return true;
    }

    private JFrame CreateWindow(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        frame.setTitle("Memes folder");
        JLabel label1 = new JLabel("Add your folder with memes:");
        panel.add(label1);
        JLabel label2 = new JLabel("(type 'default' for plugin included memes)");
        panel.add(label2);

        JButton btn = new JButton("Submit");
        btn.addActionListener(new ButtonClickListener());
        panel.add(input);
        panel.add(btn);
        frame.add(panel);
        frame.setVisible(true);
        frame.setSize(300, 150);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        return frame;
    }

    private static class ButtonClickListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String content = input.getText();
            if (content.isEmpty()) {
                JFrame frame = new JFrame();
                JLabel label = new JLabel("Plugin folder can't by empty string");
                frame.add(label);
                frame.setVisible(true);
                frame.setSize(200, 100);
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                return;
            }
            Adapter.getInstance().SetFolder(content);
            frame.dispose();
        }
    }
}
