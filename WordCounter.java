import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class WordCounter extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JLabel wordCountLabel;
    private JButton countButton;

    public WordCounter() {
        // Set up the JFrame
        setTitle("Word Counter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Center the window

        // Set up the text area
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Set up the count button
        countButton = new JButton("Count Words");
        countButton.addActionListener(this);

        // Set up the word count label
        wordCountLabel = new JLabel("Word Count: 0");

        // Add components to the frame
        add(scrollPane, BorderLayout.CENTER);
        add(countButton, BorderLayout.SOUTH);
        add(wordCountLabel, BorderLayout.NORTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the text from the text area
        String text = textArea.getText();

        // Split the text into words
        String[] words = text.trim().split("\\s+");

        // Update the word count label
        wordCountLabel.setText("Word Count: " + words.length);
    }

    public static void main(String[] args) {
        // Create and show the WordCounter JFrame
        SwingUtilities.invokeLater(() -> {
            WordCounter wordCounter = new WordCounter();
            wordCounter.setVisible(true);
        });
    }
}
