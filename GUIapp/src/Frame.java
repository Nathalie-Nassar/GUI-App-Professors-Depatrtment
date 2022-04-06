import javax.swing.*;
import java.awt.event.*;

public class Frame extends JFrame {
    public Frame() {
        setTitle("University Database");
        setBounds(100, 100, 800, 500);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        setContentPane(panel);

        JLabel label = new JLabel();
        label.setText("Enter the location of the Department: ");
        label.setBounds(45, 10, 300, 30);
        panel.add(label);

        JTextField field = new JTextField();
        field.setBounds(45, 45, 300, 25);
        panel.add(field);

        JButton btn = new JButton();
        btn.setText("Check");
        btn.setBounds(45, 80, 300, 20);

        JTextArea j = new JTextArea(5, 5);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String location = field.getText().trim();
                j.setBounds(3, 200, 900, 700);
                j.setText("The professors working in "
                        + field.getText()
                        + " are:\n " + DataBaseClass.getProfessors(location)
                        + "\n \nThe Department summary (" + field.getText() + "):\n "
                        + DataBaseClass.getDepSummary(location));
            }
        });
        panel.add(btn);
        panel.add(j);
    }
}
