package com.mycompany.awarenessgenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class MainFrame extends JFrame {
    private JComboBox<String> companyTypeBox;
    private JTextArea outputArea;
    private Random random = new Random();

    public MainFrame() {
        setTitle("AI Dynamic Security Generator");
        setSize(750, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(15, 15));

        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(245, 245, 245));
        topPanel.add(new JLabel("Target Sector:"));
        
        String[] types = {"Hospital", "Bank", "University"};
        companyTypeBox = new JComboBox<>(types);
        topPanel.add(companyTypeBox);

        JButton generateBtn = new JButton("Generate New AI Plan");
        topPanel.add(generateBtn);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        outputArea.setMargin(new Insets(15, 15, 15, 15));
        outputArea.setBackground(new Color(30, 30, 30));
        outputArea.setForeground(new Color(0, 255, 100));
        
        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        generateBtn.addActionListener((ActionEvent e) -> {
            String selected = (String) companyTypeBox.getSelectedItem();
            outputArea.setText(generateDynamicPlan(selected));
        });
    }

    private String generateDynamicPlan(String sector) {
        String[] threats = getThreats(sector);
        String[] phishing = getPhishing(sector);
        String[] solutions = getSolutions(sector);

        StringBuilder sb = new StringBuilder();
        sb.append("🤖 [AI LIVE GENERATION FOR: ").append(sector.toUpperCase()).append("]\n");
        sb.append("Timestamp: ").append(new java.util.Date()).append("\n");
        sb.append("--------------------------------------------------\n\n");
        
        sb.append("🔥 CURRENT THREAT LANDSCAPE:\n");
        sb.append("   - ").append(threats[random.nextInt(threats.length)]).append("\n");
        sb.append("   - ").append(threats[random.nextInt(threats.length)]).append("\n\n");

        sb.append("📧 NEW PHISHING VARIANT DETECTED:\n");
        sb.append("   - ").append(phishing[random.nextInt(phishing.length)]).append("\n\n");

        sb.append("💡 RECOMMENDED AI DEFENSE:\n");
        sb.append("   - ").append(solutions[random.nextInt(solutions.length)]).append("\n");
        sb.append("   - ").append(solutions[random.nextInt(solutions.length)]).append("\n\n");
        
        sb.append("--------------------------------------------------\n");
        sb.append("Click 'Generate' again for a fresh security perspective.");

        return sb.toString();
    }

    private String[] getThreats(String sector) {
        switch (sector) {
            case "Hospital": return new String[]{"Ransomware on MRI machines", "EHR Data Leaks", "Legacy System Vulnerabilities", "Insider Privacy Breach", "Bio-Metric Spoofing"};
            case "Bank": return new String[]{"ATM Jackpotting", "AI-Generated Deepfake Voice Fraud", "SWIFT Network Infiltration", "Mobile Banking Trojan", "SQL Injection on Ledgers"};
            case "University": return new String[]{"Research IP Exfiltration", "DDoS on Learning Management Systems", "Credential Stuffing on Student Portals", "Ransomware on Admin Servers", "Phishing for Academic Credentials"};
            default: return new String[]{"General Security Threat", "System Vulnerability"};
        }
    }

    private String[] getPhishing(String sector) {
        switch (sector) {
            case "Hospital": return new String[]{"Fake 'New Lab Protocol' PDF", "Urgent Patient Transfer Request", "Medical Insurance Verification Scam", "Department Budget Update Notification"};
            case "Bank": return new String[]{"Suspicious Login Alert SMS", "Updated Terms of Service Link", "Priority Loan Approval Document", "CEO Fraud: Urgent Wire Transfer Request"};
            case "University": return new String[]{"Scholarship Eligibility Notification", "Library Password Reset Request", "Dean's Invitation to Research Seminar", "Unpaid Tuition Fee Reminder"};
            default: return new String[]{"Standard Phishing Attempt"};
        }
    }

    private String[] getSolutions(String sector) {
        switch (sector) {
            case "Hospital": return new String[]{"IoT Network Micro-segmentation", "Real-time AI Vitals Monitoring Security", "Blockchain for Medical Records", "Air-gapped Backups for EHR"};
            case "Bank": return new String[]{"Behavioral Biometrics Analysis", "Zero-Trust Architecture", "Hardware Security Modules (HSM)", "Multi-signature Transaction Approval"};
            case "University": return new String[]{"Federated Identity Management", "Regular Penetration Testing of Portals", "VLAN Isolation for Labs", "Cloud-native Security Posture Management"};
            default: return new String[]{"Standard Security Patching"};
        }
    }
}