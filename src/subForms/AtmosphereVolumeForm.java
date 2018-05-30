package subForms;

import controller.Controller;

import javax.swing.*;
import java.awt.event.*;

public class AtmosphereVolumeForm extends JDialog implements subForms.IComputeResult {
    private JPanel contentPane;
    private JButton countButton;
    private JButton saveButton;
    private JButton cancelButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    public AtmosphereVolumeForm(Controller controller) {
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

        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

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
        return 10 * Double.valueOf(textField1.getText()) * Double.valueOf(textField2.getText()) * Double.valueOf(textField3.getText());
    }

    private void countAndShowResult() {
        JOptionPane.showMessageDialog(this, "Об'єм атмосферних опадів за рiк: " + String.valueOf(countResult() + " м3/рік"), "Результат", JOptionPane.PLAIN_MESSAGE);
    }
}
