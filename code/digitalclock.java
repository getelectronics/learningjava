
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClock extends JFrame {

    private JLabel timeLabel;
    private SimpleDateFormat timeFormat;

    public DigitalClock() {
        // Set up the frame
        this.setTitle("Digital Clock");
        this.setSize(300, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // Center the frame

        // Set up the time format
        timeFormat = new SimpleDateFormat("HH:mm:ss");

        // Create a label to display the time
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 50));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Add the label to the frame
        this.add(timeLabel);

        // Create a timer to update the time every second
        Timer timer = new Timer(1000, e -> updateTime());
        timer.setInitialDelay(0);
        timer.start();

        // Make the frame visible
        this.setVisible(true);
    }

    private void updateTime() {
        // Get the current time and set it to the label
        String currentTime = timeFormat.format(new Date());
        timeLabel.setText(currentTime);
    }

    public static void main(String[] args) {
        // Run the clock in the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new DigitalClock());
    }
}