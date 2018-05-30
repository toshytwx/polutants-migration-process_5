package subForms;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StrangeRunoffForm extends JDialog implements subForms.IComputeResult{
    private JPanel contentPane;
    private JButton saveButton;
    private JButton countButton;
    private JButton cancelButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;

    public StrangeRunoffForm(Controller controller) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(saveButton);

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

    @Override
    public double countResult() {
        return Double.valueOf(textField1.getText()) * Double.valueOf(textField2.getText()) +
                Double.valueOf(textField3.getText()) * Double.valueOf(textField4.getText()) +
                Double.valueOf(textField5.getText()) * Double.valueOf(textField6.getText());
    }

    private void countAndShowResult() {
        JOptionPane.showMessageDialog(this, "Сумарна рiчна кiлькiсть виносу речовин з поверхневим стоком: " + String.valueOf(countResult()), "Результат", JOptionPane.PLAIN_MESSAGE);
    }
}
