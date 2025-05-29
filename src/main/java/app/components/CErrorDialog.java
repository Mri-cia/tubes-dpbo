package app.components;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class CErrorDialog extends JDialog{
    private JFrame owner;
    
    private JLabel messageLabel;
    private CButton btn1;
    private CButton btn2;
    
    private int numOfButton;

    public CErrorDialog(JFrame owner, String message, int numOfButton) {
        super(owner, "Error", true); // 'true' makes it modal
        this.owner = owner;
        this.numOfButton = numOfButton;

        initMessage(message);
        defaultLayout();
        registerEvents();

        pack();  
        setLocationRelativeTo(owner);
    }

    private void initMessage(String message) {
        messageLabel = new JLabel(message, SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 10));

        btn1 = new CButton("Ok");
        btn1.setBorder(new EmptyBorder(5, 15, 5, 15));
        
        btn2 = new CButton("Cancel");
        btn2.setBorder(new EmptyBorder(5, 15, 5, 15));
    }

    private void defaultLayout() {
        JPanel content = new JPanel(new BorderLayout(10, 10));
        content.setBorder(new EmptyBorder(15, 20, 15, 20)); // Add padding around entire dialog

        content.add(messageLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(); // FlowLayout by default
        buttonPanel.add(btn1);
        buttonPanel.add(btn2);

        content.add(buttonPanel, BorderLayout.SOUTH);

        setContentPane(content);
    }

    private void registerEvents() {
        btn1.addActionListener(
        		e -> {
                    System.out.println("OK clicked");
                    dispose();
                });

        btn2.addActionListener(
        		e -> {
                    System.out.println("Cancel clicked");
                    dispose();
                });
    }
    
    public void setBtn1(String title) {
    	btn1.setText(title);
    }
    
    public void setBtn1(String title, Dimension size) {
    	btn1.setText(title);
        btn1.setPreferredSize(size);
    }
    
    public void setBtn1Action(ActionListener a) {
        for (ActionListener al : btn1.getActionListeners()) {
            btn1.removeActionListener(al);
        }
        btn1.addActionListener(e -> {
        	a.actionPerformed(e);
        	dispose();
        });
    }
    
    public void setBtn2(String title) {
    	btn2.setText(title);
    }
    
    public void setBtn2(String title, Dimension size) {
    	btn2.setText(title);
        btn2.setPreferredSize(size);
    }
    
    public void setBtn2Action(ActionListener a) {
        for (ActionListener al : btn2.getActionListeners()) {
            btn2.removeActionListener(al);
        }
        btn2.addActionListener(e -> {
        	a.actionPerformed(e);
        	dispose();
        });
    }
    
}

