import controller.Controller;
import subForms.*;

import javax.swing.*;
import java.awt.event.*;

public class MainForm extends JDialog {
    private JPanel contentPane;
    private JButton buttonCancel;
    private JButton countGDS;
    private JButton countUnorganizedRunoff;
    private JButton countAtmosphereVolume;
    private JButton countWaterVolume;
    private JButton countStrangeRunoff;
    private JButton countNitratsVolume;

    public MainForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(countGDS);
        Controller controller = new Controller();

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
        countGDS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GDSForm dialog = new GDSForm(controller);
                dialog.pack();
                dialog.setVisible(true);
            }
        });
        countUnorganizedRunoff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UnorganizedRunOffForm dialog = new UnorganizedRunOffForm(controller);
                dialog.pack();
                dialog.setVisible(true);
            }
        });
        countAtmosphereVolume.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AtmosphereVolumeForm dialog = new AtmosphereVolumeForm(controller);
                dialog.pack();
                dialog.setVisible(true);
            }
        });
        countWaterVolume.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WaterVolumeForm dialog = new WaterVolumeForm(controller);
                dialog.pack();
                dialog.setVisible(true);
            }
        });
        countStrangeRunoff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StrangeRunoffForm dialog = new StrangeRunoffForm(controller);
                dialog.pack();
                dialog.setVisible(true);
            }
        });
        countNitratsVolume.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NitratVolumeForm dialog = new NitratVolumeForm(controller);
                dialog.pack();
                dialog.setVisible(true);
            }
        });
    }


}
