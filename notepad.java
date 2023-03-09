import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;
public class notepad implements ActionListener  {
    JFrame note;
    JTextArea textarea;
    JMenuBar menu;
    JMenu file,edit,format,About;
    JMenuItem cutnote,copynote,pastenote,selectallnote;
    JMenuItem newnote,opennote,savenote;
    JMenuItem background,foreground;
    notepad(){
        note = new JFrame();
        textarea = new JTextArea();
        menu = new JMenuBar();
        file = new JMenu("File");
        edit = new JMenu("Edit");
        format = new JMenu("format");
        About = new JMenu("About");
        newnote = new JMenuItem("New");
        opennote = new JMenuItem("Open");
        savenote = new JMenuItem("Save");
        cutnote = new JMenuItem("Cut");
        copynote = new JMenuItem("Copy");
        pastenote = new JMenuItem("Paste");
        selectallnote = new JMenuItem("Select");
        background = new JMenuItem("Background");
        foreground = new JMenuItem("Foreground");
        textarea.setBounds(4,40,996,996);
        menu.setBounds(4,5,996,30);
        note.setLayout(null);
        note.setTitle("My Notes");
        note.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        note.getContentPane().setBackground(Color.white);
        note.setSize(1000,1000);
        note.setJMenuBar(menu);
        note.add(textarea);
        menu.add(file);
        menu.add(edit);
        menu.add(format);
        edit.add(cutnote);
        edit.add(pastenote);
        edit.add(copynote);
        edit.add(selectallnote);
        file.add(newnote);
        file.add(opennote);
        file.add(savenote);
        format.add(foreground);
        format.add(background);
        note.setVisible(true);
        cutnote.addActionListener(this);
        copynote.addActionListener(this);
        pastenote.addActionListener(this);
        selectallnote.addActionListener(this);
        background.addActionListener(this);
        foreground.addActionListener(this);
        newnote.addActionListener(this);
        opennote.addActionListener(this);
        savenote.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cutnote) {
            textarea.cut();
        } else if (e.getSource() == pastenote) {
            textarea.paste();
        } else if (e.getSource() == copynote) {
            textarea.copy();
        } else if (e.getSource() == selectallnote) {
            textarea.selectAll();
        } else if (e.getSource() == background) {
            JColorChooser color = new JColorChooser();
            Color c = color.showDialog(note, "colours", Color.white);
            textarea.setBackground(c);
        } else if (e.getSource() == foreground) {
            JColorChooser color = new JColorChooser();
            Color c = color.showDialog(note, "colours", Color.white);
            textarea.setForeground(c);
        } else if (e.getSource() == newnote) {
            textarea.setText("");
            textarea.setBackground(Color.white);
        } else if (e.getSource() == opennote) {
            JFileChooser filechooser = new JFileChooser();
            int options = filechooser.showOpenDialog(note);
            File note = filechooser.getSelectedFile();
            try {
                Scanner m = new Scanner(note);
                while (m.hasNextLine()) {
                    textarea.append("\n" + m.nextLine());
                }

            } catch (Exception ex) {
            }
        } else if (e.getSource() == savenote) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Name to Save");
            int option = fileChooser.showSaveDialog(note);
            if (option == JFileChooser.APPROVE_OPTION) {
                try {
                    File f = fileChooser.getSelectedFile();
                    String text = textarea.getText();
                    FileWriter my = new FileWriter(f);
                    my.write(text);
                    my.close();
                    System.out.println("DONE");
                } catch (Exception ex) {
                }
            }
        }
    }
        public static void main (String[]args)throws Exception{
            new notepad();
        }



}
