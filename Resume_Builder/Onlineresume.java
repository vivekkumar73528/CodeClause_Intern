import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Onlineresume extends JFrame {

    private JTextField nameField, emailField;
    private JTextArea educationArea, experienceArea, skillsArea;
    private JButton generateButton;
    
    public Onlineresume() {
        setTitle("Resume Builder");
        setSize(550, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // Create components
        JLabel nameLabel = new JLabel("Name:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel educationLabel = new JLabel("Education:");
        JLabel experienceLabel = new JLabel("Experience:");
        JLabel skillsLabel = new JLabel("skills:");
        nameField = new JTextField(20);
        emailField = new JTextField(20);
        educationArea = new JTextArea(5, 20); 
        experienceArea = new JTextArea(5, 20);
        skillsArea = new JTextArea(5, 20);
        generateButton = new JButton("Generate Button");

        // Create panels
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        inputPanel.add(nameLabel, gbc);
        gbc.gridx++;
        inputPanel.add(nameField, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        inputPanel.add(emailLabel, gbc);
        gbc.gridx++;
        inputPanel.add(emailField, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        inputPanel.add(educationLabel, gbc);
        gbc.gridy++;
        inputPanel.add(educationArea, gbc);
        gbc.gridy++;
        inputPanel.add(experienceLabel, gbc);
        gbc.gridy++;
        inputPanel.add(experienceArea, gbc);
        gbc.gridy++;
        inputPanel.add(skillsLabel, gbc);
        gbc.gridy++;
        inputPanel.add(skillsArea, gbc);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(generateButton);

        // Add panels to the frame
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Set the generate button action
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateResume();
            }
        });
    }

    public void generateResume() {
        String name = nameField.getText();
        String email = emailField.getText();
        String education = educationArea.getText();
        String experience = experienceArea.getText();
        String skills = skillsArea.getText();

        StringBuilder resume = new StringBuilder();
        resume.append("Resume\n\n");
        resume.append("Name: ").append(name).append("\n");
        resume.append("Email: ").append(email).append("\n\n");
        resume.append("Education\n").append(education).append("\n\n");
        resume.append("Experience\n").append(experience).append("\n\n");
        resume.append("skills\n").append(skills).append("\n");

        // Display the resume in a dialog box
        JOptionPane.showMessageDialog(this, resume.toString(), "Generated Resume", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String args[]) {
        Onlineresume builder = new Onlineresume();
        builder.setVisible(true);
    }
}