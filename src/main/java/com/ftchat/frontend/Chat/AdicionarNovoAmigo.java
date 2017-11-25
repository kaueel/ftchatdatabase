package com.ftchat.frontend.Chat;

import java.awt.EventQueue;
import java.awt.Image;

import javax.naming.ldap.Control;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.ftchat.frontend.Resources.FocusTraversalOnArray;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdicionarNovoAmigo {

    private JFrame frame;
    private JTextField txtLogin;
    private com.ftchat.Controllers.Chat.Chat Controller;
    private JLabel lblErro;
    private AdicionarNovoAmigo frm = this;
    /**
     * Launch the application.
     */

    public void Show() {
        try {
            this.frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Hide(){
        this.frame.dispose();
    }

    public boolean getVisible(){
        return frame.isVisible();
    }
    /**
     * Create the application.
     */
    public AdicionarNovoAmigo(com.ftchat.Controllers.Chat.Chat Controller) {
        this.Controller = Controller;
        initialize();
        frame.requestFocusInWindow();
    }

    /**
     * Initialize the contents of the frame.
     */
    public void focusGained(FocusEvent arg0) {
        if(txtLogin.getText() == "username") {
            txtLogin.setText("");
        }
    }

    public void focusLost(FocusEvent e) {
        if(txtLogin.getText() == "") {
            txtLogin.setText("username");
        }
    }

    private void initialize() {



        frame = new JFrame();
        frame.setResizable(false);
        frame.getContentPane().setBackground(new java.awt.Color(43,50,56));
        frame.getContentPane().setLayout(null);

        txtLogin = new JTextField();
        txtLogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(FocusEvent evt) {
                txtLoginFocusLost(evt);
            }
            @Override
            public void focusGained(FocusEvent e) {
                txtLoginFocusGained(e);
            }
        });
        txtLogin.setFont(new Font("Arial", Font.PLAIN, 18));
        txtLogin.setText("username");
        txtLogin.setForeground(SystemColor.control);
        txtLogin.setBackground(new java.awt.Color(60,70,78));
        txtLogin.setBorder(null);
        txtLogin.setBorder(BorderFactory.createCompoundBorder(txtLogin.getBorder(),BorderFactory.createEmptyBorder(0, 20, 0, 0)));
        txtLogin.setBounds(49, 98, 346, 39);

        frame.getContentPane().add(txtLogin);
        txtLogin.setColumns(10);
        ImageIcon imageIcon = new ImageIcon("logo_FTSpeack.png"); // load the image to a imageIcon
        Image image = imageIcon.getImage();

        JButton btnEntrar = new JButton("Adicionar");
        btnEntrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if(!txtLogin.getText().equals("") && !txtLogin.getText().equals("username")){
                    Controller.AddFriend(txtLogin.getText());
                }
            }
        });
        btnEntrar.setFont(new Font("Arial", Font.PLAIN, 16));
        btnEntrar.setBounds(225, 160, 170, 39);
        btnEntrar.setBackground(new java.awt.Color(80,157,225));
        btnEntrar.setBorder(null);

        frame.getContentPane().add(btnEntrar);

        Component horizontalGlue = Box.createHorizontalGlue();
        horizontalGlue.setBounds(10, 46, 1, 1);
        frame.getContentPane().add(horizontalGlue);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                Hide();
            }
        });
        lblNewLabel_1.setIcon(new ImageIcon("close.png"));
        lblNewLabel_1.setBounds(408, 11, 32, 36);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        lblNewLabel_1.setCursor(cursor);

        frame.getContentPane().add(lblNewLabel_1);

        lblErro = new JLabel("");
        lblErro.setHorizontalAlignment(SwingConstants.CENTER);
        lblErro.setFont(new Font("Arial", Font.BOLD, 13));
        lblErro.setForeground(Color.WHITE);
        lblErro.setBounds(10, 219, 430, 14);
        frame.getContentPane().add(lblErro);

        JLabel lblNewLabel = new JLabel("Adicionar um novo amigo");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(49, 28, 346, 39);
        frame.getContentPane().add(lblNewLabel);

        JButton button = new JButton("Cancelar");
        button.setForeground(SystemColor.menu);
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setBorder(new LineBorder(SystemColor.control));
        button.setBackground(new Color(43, 50, 56));
        button.setBounds(49, 160, 170, 39);
        frame.getContentPane().add(button);
        frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtLogin, btnEntrar, horizontalGlue}));
        frame.setBounds(100, 100, 450, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setAutoRequestFocus(false);
        CenteredFrame(frame);

    }

    private void txtLoginFocusGained(java.awt.event.FocusEvent evt) {
        if(txtLogin.getText().equals("username")){
            txtLogin.setText("");
        }
    }

    private void txtLoginFocusLost(java.awt.event.FocusEvent evt) {
        if(txtLogin.getText().equals("")){
            txtLogin.setText("username");
        }
    }

    private void CenteredFrame(javax.swing.JFrame objFrame){
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - objFrame.getWidth()) / 2;
        int iCoordY = (objDimension.height - objFrame.getHeight()) / 2;
        objFrame.setLocation(iCoordX, iCoordY);
    }

    public void printerro(String erro){
        lblErro.setText(erro);
    }
}
