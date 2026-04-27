/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.awarenessgenerator;

import javax.swing.SwingUtilities;

/**
 *
 * @author hassa
 */
public class AwarenessGenerator {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}