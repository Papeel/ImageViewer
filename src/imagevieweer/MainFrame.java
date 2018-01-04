package imagevieweer;

import imagevieweer.control.Command;
import imagevieweer.ui.ImageDisplay;
import imagevieweer.ui.implementation.SwingImageDisplay;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MainFrame extends JFrame{
    
    private Map<String,Command> commands = new HashMap<>();
    private ImageDisplay imageDisplay;
    JTextArea area =  new JTextArea("0");
    public MainFrame(){
        this.setTitle("iMAGEN");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(image());
        this.add(toolbar(),BorderLayout.SOUTH);
        this.setVisible(true);
    }
    
    public void add (Command command){
        commands.put(command.name(), command);
    }

    private Component image() {
        SwingImageDisplay display = new SwingImageDisplay();
        imageDisplay=display;
        return display;
    }

    public ImageDisplay getImageDisplay() {
        return imageDisplay;
    }

    private Component toolbar() {
        JPanel panel =  new JPanel();
        panel.add(area);
        area.setEditable(false);
        panel.add(button("prev"));
        panel.add(button("next"));
        return panel;
    }
    
    
    private Component button(String name) {
        JButton button= new JButton(name);
        button.addActionListener(execute(name));
        return button;
    }

    private ActionListener execute(String name) {
        return new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get(name).execute();
                area.setText(Integer.toString(imageDisplay.currentImage().getIndex()));
            }
            
        };
    }
}
