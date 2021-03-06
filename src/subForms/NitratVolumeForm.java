package subForms;

import controller.Controller;

import javax.swing.*;
import java.awt.event.*;

public class NitratVolumeForm extends JDialog implements subForms.IComputeResult {
    private JPanel contentPane;
    private JButton countButton;
    private JButton saveButton;
    private JButton cancelButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;

    public NitratVolumeForm(Controller controller) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(countButton);

        countButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                countAndShowResult();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.onSaveFile(String.valueOf(countResult()));
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                back(controller);
            }
        });
    }

    private void back(Controller controller) {
        controller.goToMain(this);
    }

    @Override
    public double countResult() {
        return (Double.valueOf(textField1.getText()) + Double.valueOf(textField2.getText())) -
                (Double.valueOf(textField3.getText()) + Double.valueOf(textField4.getText()) +
                Double.valueOf(textField5.getText()) + Double.valueOf(textField6.getText()));
    }

    private void countAndShowResult() {
        JOptionPane.showMessageDialog(this, "Середньорічний об’єм фільтрату, що утворюється на полігоні ТПВ: " + String.valueOf(countResult()), "Результат", JOptionPane.PLAIN_MESSAGE);
    }
}
