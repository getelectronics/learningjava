import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMIBMRCalculatorApp extends JFrame {

    // Components for input
    private JTextField weightField, heightField, ageField;
    private JRadioButton maleButton, femaleButton;
    private JButton calculateButton, resetButton;

    // Labels for output
    private JLabel bmiLabel, bmrLabel;

    // Constructor to set up the UI
    public BMIBMRCalculatorApp() {
        setTitle("BMI and BMR Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Center the window on the screen

        // Panel for input fields
        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Input labels and fields
        inputPanel.add(new JLabel("Weight (kg):"));
        weightField = new JTextField();
        inputPanel.add(weightField);

        inputPanel.add(new JLabel("Height (cm):"));
        heightField = new JTextField();
        inputPanel.add(heightField);

        inputPanel.add(new JLabel("Age (years):"));
        ageField = new JTextField();
        inputPanel.add(ageField);

        // Gender selection
        inputPanel.add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ButtonGroup genderGroup = new ButtonGroup();
        maleButton = new JRadioButton("Male", true);
        femaleButton = new JRadioButton("Female");
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        inputPanel.add(genderPanel);

        // Buttons for calculate and reset
        calculateButton = new JButton("Calculate");
        resetButton = new JButton("Reset");
        inputPanel.add(calculateButton);
        inputPanel.add(resetButton);

        // Panel for output labels
        JPanel outputPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        bmiLabel = new JLabel("BMI: ");
        bmrLabel = new JLabel("BMR: ");
        outputPanel.add(bmiLabel);
        outputPanel.add(bmrLabel);

        // Add action listeners
        calculateButton.addActionListener(new CalculateButtonListener());
        resetButton.addActionListener(new ResetButtonListener());

        // Set layout for the frame
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.CENTER);
        add(outputPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Method to calculate and display BMI and BMR
    private void calculateBMIandBMR() {
        try {
            double weight = Double.parseDouble(weightField.getText());
            double height = Double.parseDouble(heightField.getText()) / 100.0;  // Convert height to meters
            int age = Integer.parseInt(ageField.getText());

            // Calculate BMI
            double bmi = weight / (height * height);

            // Calculate BMR based on gender
            double bmr;
            if (maleButton.isSelected()) {
                bmr = 10 * weight + 6.25 * (height * 100) - 5 * age + 5;  // For men
            } else {
                bmr = 10 * weight + 6.25 * (height * 100) - 5 * age - 161;  // For women
            }

            // Display results
            bmiLabel.setText(String.format("BMI: %.2f", bmi));
            bmrLabel.setText(String.format("BMR: %.2f", bmr));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Action listener for the calculate button
    private class CalculateButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            calculateBMIandBMR();
        }
    }

    // Action listener for the reset button
    private class ResetButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            weightField.setText("");
            heightField.setText("");
            ageField.setText("");
            bmiLabel.setText("BMI: ");
            bmrLabel.setText("BMR: ");
        }
    }

    // Main method to run the app
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BMIBMRCalculatorApp());
    }
}