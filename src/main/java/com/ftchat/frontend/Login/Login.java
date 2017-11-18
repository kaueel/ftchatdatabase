package com.ftchat.frontend.Login;


import java.awt.EventQueue;
import java.awt.Image;

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
import com.ftchat.frontend.Resources.FocusTraversalOnArray;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login {

    private JFrame frame;
    private JTextField txtLogin;
    private JPasswordField passwordField;
    private JLabel lblErro;
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

    public void Hide() {
        try {
            frame.setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the application.
     */
    public Login() {
        initialize();
        frame.requestFocusInWindow();
    }

    /**
     * Initialize the contents of the frame.
     */
    public void focusGained(FocusEvent arg0) {
        if(txtLogin.getText() == "Login") {
            txtLogin.setText("");
        }
    }

    public void focusLost(FocusEvent e) {
        if(txtLogin.getText() == "") {
            txtLogin.setText("Login");
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
        txtLogin.setText("Login");
        txtLogin.setForeground(SystemColor.control);
        txtLogin.setBackground(new java.awt.Color(60,70,78));
        txtLogin.setBorder(null);
        txtLogin.setBorder(BorderFactory.createCompoundBorder(txtLogin.getBorder(),BorderFactory.createEmptyBorder(0, 20, 0, 0)));
        txtLogin.setBounds(49, 117, 346, 39);

        frame.getContentPane().add(txtLogin);
        txtLogin.setColumns(10);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(129, 37, 183, 48);
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Vinicius\\Documents\\logo_FTSpeack.png"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(),  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        lblNewLabel.setIcon(new ImageIcon(newimg));

        frame.getContentPane().add(lblNewLabel);

        passwordField = new JPasswordField();
        passwordField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent arg0) {
                passwordFieldFocusGained(arg0);
            }
            @Override
            public void focusLost(FocusEvent e) {
                passwordFieldFocusLost(e);
            }
        });
        passwordField.setText("Senha");
        passwordField.setForeground(SystemColor.control);
        passwordField.setBackground(new java.awt.Color(60,70,78));
        passwordField.setBorder(null);
        passwordField.setBorder(BorderFactory.createCompoundBorder(txtLogin.getBorder(),BorderFactory.createEmptyBorder(0, 0, 0, 0)));
        passwordField.setBounds(49, 167, 346, 39);
        frame.getContentPane().add(passwordField);



        JButton btnNewButton = new JButton("Cadastrar-se");
        btnNewButton.setForeground(SystemColor.control);
        btnNewButton.setFont(new Font("Arial", Font.PLAIN, 16));

        btnNewButton.setBackground(new java.awt.Color(43,50,56));
        btnNewButton.setBorder(BorderFactory.createLineBorder(Color.white));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                cadastrar();
            }
        });
        btnNewButton.setBounds(49, 229, 170, 39);
        frame.getContentPane().add(btnNewButton);

        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setFont(new Font("Arial", Font.PLAIN, 16));
        btnEntrar.setBounds(225, 229, 170, 39);
        btnEntrar.setBackground(new java.awt.Color(51, 204, 255));
        btnEntrar.setBorder(null);
        btnEntrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                entrar();
            }
        });

        frame.getContentPane().add(btnEntrar);

        Component horizontalGlue = Box.createHorizontalGlue();
        horizontalGlue.setBounds(10, 46, 1, 1);
        frame.getContentPane().add(horizontalGlue);

        lblErro = new JLabel(" ");
        lblErro.setHorizontalAlignment(SwingConstants.CENTER);
        lblErro.setFont(new Font("Arial", Font.BOLD, 13));
        lblErro.setForeground(Color.WHITE);
        lblErro.setBounds(10, 279, 430, 14);
        frame.getContentPane().add(lblErro);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                System.exit(0);
            }
        });
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Vinicius\\Documents\\close.png"));
        lblNewLabel_1.setBounds(420, 11, 20, 36);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        lblNewLabel_1.setCursor(cursor);

        frame.getContentPane().add(lblNewLabel_1);
        frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblNewLabel, txtLogin, passwordField, btnEntrar, btnNewButton, horizontalGlue}));
        frame.setBounds(100, 100, 450, 310);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setAutoRequestFocus(false);
        CenteredFrame(frame);



    }

    private void txtLoginFocusGained(java.awt.event.FocusEvent evt) {
        if(txtLogin.getText().equals("Login")){
            txtLogin.setText("");
        }
    }

    private void txtLoginFocusLost(java.awt.event.FocusEvent evt) {
        if(txtLogin.getText().equals("")){
            txtLogin.setText("Login");
        }
    }

    private void passwordFieldFocusGained(java.awt.event.FocusEvent evt) {
        if(passwordField.getText().equals("Senha")){
            passwordField.setText("");
        }
    }

    private void passwordFieldFocusLost(java.awt.event.FocusEvent evt) {
        if(passwordField.getText().equals("")){
            passwordField.setText("Senha");
        }
    }

    private void CenteredFrame(javax.swing.JFrame objFrame){
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - objFrame.getWidth()) / 2;
        int iCoordY = (objDimension.height - objFrame.getHeight()) / 2;
        objFrame.setLocation(iCoordX, iCoordY);
    }

    private void entrar(){
        if(passwordField.getText().equals("") || passwordField.getText().equals("Senha") || txtLogin.getText().equals("")||txtLogin.getText().equals("Login")){
            printerro("Preencha os dados corretamente!");
        }else{
            com.ftchat.Controllers.Login.Login.validarLogin(this,txtLogin.getText(),passwordField.getText());
        }
    }

    private void cadastrar(){
        com.ftchat.Controllers.Login.Login.Cadastrar(this);
    }

    public void printerro(String erro){
        lblErro.setText(erro);
    }
}