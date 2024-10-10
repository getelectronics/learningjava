import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LotteryNumberGenerator extends JFrame {

    private JLabel numbersLabel;
    private JButton generateButton;

    // Constructor to set up the GUI
    public LotteryNumberGenerator() {
        setTitle("Lottery Number Generator");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Center the window on the screen

        // Label to display lottery numbers
        numbersLabel = new JLabel("Lottery Numbers: ", SwingConstants.CENTER);
        numbersLabel.setFont(new Font("Serif", Font.BOLD, 24));

        // Button to generate numbers
        generateButton = new JButton("Generate Numbers");
        generateButton.addActionListener(new GenerateButtonListener());

        // Set up the layout of the app
        setLayout(new BorderLayout());
        add(numbersLabel, BorderLayout.CENTER);
        add(generateButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Method to generate 6 unique random numbers between 1 and 49
    private int[] generateLotteryNumbers() {
        Random random = new Random();
        Set<Integer> numberSet = new HashSet<>();

        // Ensure we get exactly 6 unique numbers
        while (numberSet.size() < 6) {
            int number = random.nextInt(49) + 1;  // Generates numbers from 1 to 49
            numberSet.add(number);
        }

        // Convert the set to an array and sort it
        int[] lotteryNumbers = numberSet.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(lotteryNumbers);
        return lotteryNumbers;
    }

    // Action listener for the generate button
    private class GenerateButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int[] lotteryNumbers = generateLotteryNumbers();  // Generate numbers
            numbersLabel.setText("Lottery Numbers: " + Arrays.toString(lotteryNumbers));  // Display numbers
        }
    }

    // Main method to run the app
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LotteryNumberGenerator());
    }
}