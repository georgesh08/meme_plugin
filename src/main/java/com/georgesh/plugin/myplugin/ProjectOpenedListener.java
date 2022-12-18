package com.georgesh.plugin.myplugin;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManagerListener;

import javax.swing.*;
import java.awt.*;

public class ProjectOpenedListener implements ProjectManagerListener {
    String folderPath;
    @Override
    public void projectOpened(Project project){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JLabel label = new JLabel("Add your folder with memes:");
        panel.add(label);

        JTextField input = new JTextField();
        panel.add(input);
        frame.add(panel);
        frame.setVisible(true);
    }
}
