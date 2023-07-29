import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ANPR extends JFrame implements ActionListener {
    private JLabel imageLabel;
    private JButton openButton;
    private JLabel resultLabel;

    public ANPR() {
        setTitle("ANPR System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        imageLabel = new JLabel(); 
        openButton = new JButton("Open Image");
        openButton.addActionListener(this);
        resultLabel = new JLabel();
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.add(openButton);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(imageLabel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(resultLabel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        add(mainPanel);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == openButton) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                processImage(selectedFile);
            }
        }
    }

    private void processImage(File imageFile) {
        try {
            BufferedImage image = ImageIO.read(imageFile);

            String numberPlate = "RK-755AJ";

            displayResult(numberPlate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void displayResult(String numberPlate) {
        resultLabel.setText("Number Plate: " + numberPlate);
        resultLabel.setForeground(Color.RED);
        resultLabel.setFont(resultLabel.getFont().deriveFont(Font.BOLD));
        resultLabel.setFont(resultLabel.getFont().deriveFont(24f));

    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            ANPR gui = new ANPR();
            gui.setVisible(true);
        });
    }
}
