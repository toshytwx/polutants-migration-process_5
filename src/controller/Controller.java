package controller;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Controller {

    public void onSaveFile(String input) {
        JFileChooser jFileChooser = new JFileChooser();
        int res = jFileChooser.showDialog(null, "Зберегти у файл");
        if (res == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser.getSelectedFile();
            jFileChooser.setSelectedFile(file);
            try (BufferedWriter writer = new BufferedWriter((new FileWriter(file)))) {
                writer.write(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void goToMain(JDialog dialog) {
        dialog.dispose();
    }
}
