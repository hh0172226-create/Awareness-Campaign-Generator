/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.awarenessgenerator;

/**
 *
 * @author hassa
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private JComboBox<String> companyTypeBox;
    private JTextArea outputArea;
    private Map<String, String> awarenessData;

    public MainFrame() {
        setTitle("Cybersecurity Awareness Campaign Generator");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        
        initData();

        // واجهة المستخدم (GUI) 
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Select Organization Type:"));
        
        String[] types = {"Hospital", "Bank", "University"};
        companyTypeBox = new JComboBox<>(types);
        topPanel.add(companyTypeBox);

        JButton generateBtn = new JButton("Generate Plan");
        topPanel.add(generateBtn);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        
        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

       
        generateBtn.addActionListener((ActionEvent e) -> {
            String selected = (String) companyTypeBox.getSelectedItem();
            outputArea.setText(awarenessData.get(selected));
        });
    }

    private void initData() {
        awarenessData = new HashMap<>();
        
        
        awarenessData.put("Hospital", 
            "=== CYBERSECURITY PLAN: HOSPITAL ===\n" +
            "1. Core Threats: Ransomware on patient records, IoT device hijacking.\n" +
            "2. Phishing Case: Email 'Urgent Patient Lab Results' containing malware.\n" +
            "3. Risks: Identity theft, loss of life due to equipment failure.\n" +
            "4. Protection: Data encryption (AES-256), Multi-Factor Authentication (MFA).");

        
        awarenessData.put("Bank", 
            "=== CYBERSECURITY PLAN: BANK ===\n" +
            "1. Core Threats: Financial fraud, SQL injection on transaction DB.\n" +
            "2. Phishing Case: Fake 'Account Suspended' SMS with a malicious link.\n" +
            "3. Risks: Financial loss, regulatory non-compliance fines.\n" +
            "4. Protection: Zero Trust Architecture, E2EE for transactions.");

        // مثال لقطاع الجامعات
        awarenessData.put("University", 
            "=== CYBERSECURITY PLAN: UNIVERSITY ===\n" +
            "1. Core Threats: Intellectual property theft, DDoS on student portal.\n" +
            "2. Phishing Case: 'Scholarship Update' email asking for login credentials.\n" +
            "3. Risks: Reputation damage, compromised research data.\n" +
            "4. Protection: Network segmentation, regular backup schedule.");
    }

}