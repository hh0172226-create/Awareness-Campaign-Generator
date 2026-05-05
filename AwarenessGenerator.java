package com.mycompany.awarenessgenerator;

import javax.swing.SwingUtilities;

public class AwarenessGenerator {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}