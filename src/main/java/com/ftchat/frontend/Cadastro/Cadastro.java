package com.ftchat.frontend.Cadastro;

    import com.ftchat.Controllers.Cadastrar.Cadastrar;
    import com.ftchat.Controllers.Login.Login;
    import com.ftchat.backend.user.User;
    import com.ftchat.frontend.Resources.FocusTraversalOnArray;

    import java.awt.*;

    import javax.swing.*;
    import java.awt.event.FocusAdapter;
    import java.awt.event.FocusEvent;
    import java.awt.event.MouseAdapter;
    import java.awt.event.MouseEvent;

public class Cadastro {

    private JFrame frame;
    private JTextField txtNomeCompleto;
    private JTextField txtUsername;
    private JTextField txtEmail;
    private JPasswordField passwordField;
    private JPasswordField passwordField_1;
    private JLabel label;
    private JButton Login;
    private JButton Cadastar;
    private JLabel lblErro;
    private com.ftchat.Controllers.Cadastrar.Cadastrar controller;
    /**
     * Launch the application.
     */
    public void Show() {
        this.frame.setVisible(true);
    }

    public void Hide() {
        this.frame.dispose();
    }

    /**
     * Create the application.
     */
    public Cadastro(com.ftchat.Controllers.Cadastrar.Cadastrar controller) {
        this.controller = controller;
        initialize();
        frame.requestFocusInWindow();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setResizable(false);
        frame.getContentPane().setBackground(new java.awt.Color(43,50,56));
        frame.setBounds(100, 100, 490, 502);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        label = new JLabel("");
        label.setBounds(120, 45, 257, 66);
        ImageIcon imageIcon = new ImageIcon("logo_FTSpeack.png"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(label.getWidth(), label.getHeight(),  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        label.setIcon(new ImageIcon(newimg));
        frame.getContentPane().add(label);

        txtNomeCompleto = new JTextField();
        txtNomeCompleto.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent arg0) {
                limpaValor("Nome completo",txtNomeCompleto);
            }
            @Override
            public void focusLost(FocusEvent e) {
                setValue("Nome completo",txtNomeCompleto);
            }
        });
        txtNomeCompleto.setText("Nome completo");
        txtNomeCompleto.setForeground(Color.WHITE);
        txtNomeCompleto.setFont(new Font("Arial", Font.PLAIN, 18));
        txtNomeCompleto.setColumns(10);
        txtNomeCompleto.setBorder(null);
        txtNomeCompleto.setBackground(new java.awt.Color(60,70,78));
        txtNomeCompleto.setBounds(49, 153, 384, 39);
        txtNomeCompleto.setBorder(BorderFactory.createCompoundBorder(txtNomeCompleto.getBorder(),BorderFactory.createEmptyBorder(0, 20, 0, 0)));
        frame.getContentPane().add(txtNomeCompleto);

        txtUsername = new JTextField();
        txtUsername.setText("Username");
        txtUsername.setForeground(Color.WHITE);
        txtUsername.setFont(new Font("Arial", Font.PLAIN, 18));
        txtUsername.setColumns(10);
        txtUsername.setBorder(null);
        txtUsername.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent arg0) {
                limpaValor("Username",txtUsername);
            }
            @Override
            public void focusLost(FocusEvent e) {
                setValue("Username",txtUsername);
            }
        });
        txtUsername.setBackground(new java.awt.Color(60,70,78));
        txtUsername.setBounds(49, 203, 384, 39);
        txtUsername.setBorder(BorderFactory.createCompoundBorder(txtUsername.getBorder(),BorderFactory.createEmptyBorder(0, 20, 0, 0)));
        frame.getContentPane().add(txtUsername);

        txtEmail = new JTextField();
        txtEmail.setText("E-mail");
        txtEmail.setForeground(Color.WHITE);
        txtEmail.setFont(new Font("Arial", Font.PLAIN, 18));
        txtEmail.setColumns(10);
        txtEmail.setBorder(null);
        txtEmail.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent arg0) {
                limpaValor("E-mail",txtEmail);
            }
            @Override
            public void focusLost(FocusEvent e) {
                setValue("E-mail",txtEmail);
            }
        });
        txtEmail.setBackground(new java.awt.Color(60,70,78));
        txtEmail.setBounds(49, 253, 384, 39);
        txtEmail.setBorder(BorderFactory.createCompoundBorder(txtEmail.getBorder(),BorderFactory.createEmptyBorder(0, 20, 0, 0)));
        frame.getContentPane().add(txtEmail);

        passwordField = new JPasswordField();
        passwordField.setText("Senha");
        passwordField.setForeground(Color.WHITE);
        passwordField.setBorder(null);
        passwordField.setBackground(new java.awt.Color(60,70,78));
        passwordField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent arg0) {
                limpaValor("Senha",passwordField);
            }
            @Override
            public void focusLost(FocusEvent e) {
                setValue("Senha",passwordField);
            }
        });
        passwordField.setBounds(49, 303, 384, 39);
        passwordField.setBorder(BorderFactory.createCompoundBorder(passwordField.getBorder(),BorderFactory.createEmptyBorder(0, 20, 0, 0)));
        frame.getContentPane().add(passwordField);

        passwordField_1 = new JPasswordField();
        passwordField_1.setText("Senha");
        passwordField_1.setForeground(Color.WHITE);
        passwordField_1.setBorder(null);
        passwordField_1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent arg0) {
                limpaValor("Senha",passwordField_1);
            }
            @Override
            public void focusLost(FocusEvent e) {
                setValue("Senha",passwordField_1);
            }
        });
        passwordField_1.setBackground(new java.awt.Color(60,70,78));
        passwordField_1.setBounds(49, 353, 384, 39);
        passwordField_1.setBorder(BorderFactory.createCompoundBorder(passwordField_1.getBorder(),BorderFactory.createEmptyBorder(0, 20, 0, 0)));
        frame.getContentPane().add(passwordField_1);

        Login = new JButton("Login");
        Login.setForeground(SystemColor.control);
        Login.setFont(new Font("Arial", Font.PLAIN, 16));
        Login.setBackground(new java.awt.Color(43,50,56));
        Login.setBorder(BorderFactory.createLineBorder(Color.white));
        Login.setBounds(49, 415, 187, 39);
        Login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                login();
            }
        });
        frame.getContentPane().add(Login);

        Cadastar = new JButton("Cadastrar");
        Cadastar.setFont(new Font("Arial", Font.PLAIN, 16));
        Cadastar.setBackground(new java.awt.Color(80,157,225));
        Cadastar.setBorder(null);
        Cadastar.setBounds(246, 415, 187, 39);
        Cadastar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                cadastar();
            }
        });
        frame.getContentPane().add(Cadastar);
        frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{label, txtNomeCompleto, txtUsername, txtEmail, passwordField, passwordField_1}));
        frame.setAutoRequestFocus(false);
        CenteredFrame(frame);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                System.exit(0);
            }
        });
        lblNewLabel_1.setIcon(new ImageIcon("close.png"));
        lblNewLabel_1.setBounds(455, 6, 25, 36);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        lblNewLabel_1.setCursor(cursor);
        frame.getContentPane().add(lblNewLabel_1);
        lblErro = new JLabel("");
        lblErro.setHorizontalAlignment(SwingConstants.CENTER);
        lblErro.setFont(new Font("Arial", Font.BOLD, 13));
        lblErro.setForeground(Color.WHITE);
        lblErro.setBounds(0, frame.getHeight()-25, frame.getWidth(), 14);
        frame.getContentPane().add(lblErro);
        frame.setUndecorated(true);
    }

    private void limpaValor(String valor,JTextField campo){
        if(campo.getText().equals(valor)){
            campo.setText("");
        }
    }

    private void CenteredFrame(javax.swing.JFrame objFrame){
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - objFrame.getWidth()) / 2;
        int iCoordY = (objDimension.height - objFrame.getHeight()) / 2;
        objFrame.setLocation(iCoordX, iCoordY);
    }

    private void setValue(String valor,JTextField campo){
        if(campo.getText().equals("")){
            campo.setText(valor);
        }
    }

    private void login(){
        controller.showLogin();
        Hide();
    }

    private void cadastar(){
        if(passwordField_1.getText().equals("") ||
                passwordField_1.getText().equals("Senha") ||
                txtEmail.getText().equals("") ||
                txtUsername.getText().equals("")||
                txtNomeCompleto.getText().equals("")||
                txtEmail.getText().equals("E-mail") ||
                txtUsername.getText().equals("Username")||
                txtNomeCompleto.getText().equals("Nome completo"))
        {
            printerro("Preencha os Valores corretamente");
        }
        else
        {
            if (passwordField.getText().equals(passwordField_1.getText())) {
                User user = new User(txtUsername.getText(), txtEmail.getText(), txtNomeCompleto.getText(), passwordField.getText());
                controller.cadastar(user);
            }
        }
    }

    public void printerro(String erro){
        lblErro.setText(erro);
    }

}
