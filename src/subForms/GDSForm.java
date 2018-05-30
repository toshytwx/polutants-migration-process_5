package subForms;

import controller.Controller;

import javax.swing.*;
import java.awt.event.*;

public class GDSForm extends JDialog implements subForms.IComputeResult {
    private JPanel contentPane;
    private JButton countButton;
    private JButton cancelButton;
    private JButton saveButton;
    private JTextField edgeValueTf;
    private JTextField maxValueTf;

    public GDSForm(Controller controller) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(countButton);

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
               dispose();
            }
        });

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

    @Override
    public double countResult() {
        return Double.valueOf(edgeValueTf.getText()) * Double.valueOf(maxValueTf.getText());
    }

    private void countAndShowResult() {
        JOptionPane.showMessageDialog(this, "ГДС: " + String.valueOf(countResult()), "Результат", JOptionPane.PLAIN_MESSAGE);
    }
}
