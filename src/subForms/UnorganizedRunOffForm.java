package subForms;

import controller.Controller;

import javax.swing.*;
import java.awt.event.*;

public class UnorganizedRunOffForm extends JDialog implements subForms.IComputeResult{
    private JPanel contentPane;
    private JButton saveButton;
    private JButton countButton;
    private JButton cancelButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;

    public UnorganizedRunOffForm(Controller controller) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(saveButton);

        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.onSaveFile(String.valueOf(countResult()));
            }
        });

        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countAndShowResult();
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

    private void countAndShowResult() {
        JOptionPane.showMessageDialog(this, "Розрахунок впливу неорганiзованого стоку: " + String.valueOf(countResult()), "Результат", JOptionPane.PLAIN_MESSAGE);
    }

    @Override
    public double countResult() {
        return (Double.valueOf(textField1.getText()) * Double.valueOf(textField2.getText())) /
                (Double.valueOf(textField3.getText()) * Double.valueOf(textField4.getText()));
    }
}
