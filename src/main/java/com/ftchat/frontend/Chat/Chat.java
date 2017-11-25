package com.ftchat.frontend.Chat;


import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Observable;
import javax.swing.border.Border;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicScrollBarUI;

//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
import com.ftchat.Controllers.ControllerOwner;
import com.ftchat.frontend.Resources.ComponentResizer;
import com.google.api.client.util.DateTime;
import net.miginfocom.swing.MigLayout;
//import com.jgoodies.forms.layout.FormSpecs;


public class Chat {

    private com.ftchat.Controllers.Chat.Chat Controller;

    public Chat (com.ftchat.Controllers.Chat.Chat Controller) {

        this.Controller = Controller;
        initialize();

    }

    private JScrollBar verticalScrollBar;
    private JScrollBar horizontalScrollBar;

    private static final int SCROLL_BAR_ALPHA_ROLLOVER = 150;
    private static final int SCROLL_BAR_ALPHA = 100;
    private static final int THUMB_BORDER_SIZE = 2;
    private static final int THUMB_SIZE = 8;
    private static final Color THUMB_COLOR = Color.GRAY;

    /**
     * Atributos do form
     */
    //Jframe
    private JFrame frmFtchat;
    //JPanel
    private JPanel panelMessagensGlobal;
    private JPanel panelContatos;
    private JPanel topPanelMessagens;
    private JPanel topPanelContatos;
    private JPanel panelMessagens;
    private JPanel paneltextMessage;
    private JPanel panel;
    private JPanel panel2;
    private JPanel Contatos;
    //Jlabel
    private JLabel lblContatos;
    private JLabel lblContatoNome;
    private JLabel lblcontatoMatriz;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    //JTextArea
    private JTextArea textArea;
    private JTextArea textAreaMessage;
    //JScrollPane
    private JScrollPane scrollPane;
    private JScrollPane scrollPaneContatos;
    //JScrollBar
    private JScrollBar vertical;

    //JButton
    private JButton btnNewButton;

    /**
     * Atributos da View
     */

    private int countMessage = 1;
    private int countcontatos = 0;
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    /**
     * run windows.
     */
    public void Show() {
        try {

            this.frmFtchat.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Hide() {
        frmFtchat.dispose();
    }

    public boolean getVisible() {
        return frmFtchat.isVisible();

    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {



        /**
         * lblContatoNome
         */
        lblContatoNome = new JLabel("");
        lblContatoNome.setBackground(Color.WHITE);
        lblContatoNome.setForeground(SystemColor.textInactiveText);
        lblContatoNome.setFont(new Font("Arial", Font.PLAIN, 18));
        lblContatoNome.setBounds(10, 0, 582, 40);
        /**
         * topPanelMessagens
         */
        topPanelMessagens = new JPanel();
        topPanelMessagens.setBackground(Color.WHITE);
        topPanelMessagens.setBounds(0, 0, 602, 50);
        topPanelMessagens.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white));
        topPanelMessagens.setLayout(null);
        topPanelMessagens.add(lblContatoNome);
        /**
         * panelMessagens
         */

        /**
         * textAreaMessage
         */
        textAreaMessage = new JTextArea();
        textAreaMessage.setBackground(new java.awt.Color(240,240,240));
        textAreaMessage.setBounds(30, 6, 401, 95);
        textAreaMessage.setWrapStyleWord(true);
        textAreaMessage.setLineWrap(true);
        textAreaMessage.addKeyListener(new KeyAdapter() {@Override public void keyPressed(KeyEvent arg0) {keyPress(arg0);}});
        Border border = BorderFactory.createLineBorder(new java.awt.Color(240,240,240));
        textAreaMessage.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        /**
         * btnNewButton
         */
        btnNewButton = new JButton("Enviar");
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setBackground(new java.awt.Color(80,157,225));
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                sendMessage();
            }
        });
        btnNewButton.setBounds(502, 40, 90, 45);

        /**
         * paneltextMessage
         */
        paneltextMessage = new JPanel();
        paneltextMessage.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(230,230,230)));
        paneltextMessage.setBackground(Color.WHITE);
        paneltextMessage.addComponentListener(new ComponentAdapter() {@Override public void componentResized(ComponentEvent arg0) { resizeTextMessage();}});
        paneltextMessage.setBounds(0, 436, 602, 126);
        paneltextMessage.setLayout(null);
        paneltextMessage.setMinimumSize(new Dimension(602,126));
        paneltextMessage.add(btnNewButton);
        paneltextMessage.add(textAreaMessage);

        /**
         * panelMessagens
         */
        panelMessagens = new JPanel();
        panelMessagens.setBackground(Color.WHITE);
        panelMessagens.setBounds(0, 47, 602, 400);
        panelMessagens.setLayout(new MigLayout("width parent.w", "10[100%]10", "[fill]10"));

        /**
         * scrollPane
         */
        scrollPane = new JScrollPane(panelMessagens,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setLocation(0, 117);
        scrollPane.setSize(602, 200);
        scrollPane.setBorder(null);
        scrollPane.setBackground(Color.WHITE);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        /**
         * verticalScrollBar
         */
        verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setVisible(false);
        verticalScrollBar.setOpaque(false);
        verticalScrollBar.setUI(new MyScrollBarUI());

        /**
         * horizontalScrollBar
         */
        horizontalScrollBar = scrollPane.getHorizontalScrollBar();
        horizontalScrollBar.setVisible(false);
        horizontalScrollBar.setOpaque(false);
        horizontalScrollBar.setUI(new MyScrollBarUI());
        /**
         *lblNewLabel
         */
        lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(0, 0, 183, 48);
        ImageIcon imageIcon = new ImageIcon("logo_FTSpeack2.png"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(),  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        lblNewLabel.setIcon(new ImageIcon(newimg));

        /**
         * panelMessagens
         */
        panelMessagensGlobal = new JPanel();
        panelMessagensGlobal.setBackground(Color.WHITE);
        panelMessagensGlobal.setBounds(0, 0, 602, 600);
        panelMessagensGlobal.setLayout(null);
        panelMessagensGlobal.add(topPanelMessagens);
        panelMessagensGlobal.add(scrollPane);
        panelMessagensGlobal.add(paneltextMessage);
        panelMessagensGlobal.add(lblNewLabel);
        /**
         * lblContatos
         */
        lblContatos = new JLabel("Contatos");
        lblContatos.setHorizontalAlignment(SwingConstants.LEFT);
        lblContatos.setForeground(SystemColor.menu);
        lblContatos.setFont(new Font("Arial", Font.PLAIN, 18));
        lblContatos.setBounds(40, 0, 250, 40);

        lblNewLabel_1 =  new JLabel("");
        lblNewLabel_1.setBounds(260, 15, 25 , 25);
        imageIcon = new ImageIcon("add.png"); // load the image to a imageIcon
        image = imageIcon.getImage(); // transform it
        newimg = image.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(),  java.awt.Image.SCALE_SMOOTH); // scale it the smooth
        lblNewLabel_1.setIcon(new ImageIcon(newimg));
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        lblNewLabel_1.setCursor(cursor);
        lblNewLabel_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                Controller.AdicionarNovoAmigo();
            }
        });
        /**
         * topPanelContatos
         */
        topPanelContatos = new JPanel();
        topPanelContatos.setBackground(new java.awt.Color(60,70,78));
        topPanelContatos.setBounds(0, 0, 290, 40);
        topPanelContatos.setLayout(null);
        topPanelContatos.add(lblContatos);
        topPanelContatos.add(lblNewLabel_1);


        /**
         * Contatos
         */
        Contatos = new JPanel();
        Contatos.setBounds(10, 51, 290, 297);
        Contatos.setBackground(new java.awt.Color(43,50,53));
        Contatos.setLayout(new MigLayout("width parent.w", "[100%]", "[40]"));

        /**
         * scrollPaneContatos
         */
        scrollPaneContatos = new JScrollPane(Contatos,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneContatos.setLocation(0, 117);
        scrollPaneContatos.setSize(290, 200);
        scrollPaneContatos.setBorder(null);
        scrollPaneContatos.setBackground(new java.awt.Color(43,50,53));
        scrollPaneContatos.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPaneContatos.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        /**
         * verticalScrollBar
         */
        verticalScrollBar = scrollPaneContatos.getVerticalScrollBar();
        verticalScrollBar.setVisible(false);
        verticalScrollBar.setOpaque(false);
        verticalScrollBar.setUI(new MyScrollBarUI());

        /**
         * horizontalScrollBar
         */
        horizontalScrollBar = scrollPaneContatos.getHorizontalScrollBar();
        horizontalScrollBar.setVisible(false);
        horizontalScrollBar.setOpaque(false);
        horizontalScrollBar.setUI(new MyScrollBarUI());

        /**
         * panelContatos
         */
        panelContatos = new JPanel();
        panelContatos.addComponentListener(new ComponentAdapter() {@Override public void componentResized(ComponentEvent arg0) {resizeContatos();}});
        panelContatos.setBackground(new java.awt.Color(43,50,53));
        panelContatos.setBounds(609, 0, 290, 600);
        panelContatos.setLayout(null);
        panelContatos.add(topPanelContatos);
        panelContatos.add(scrollPaneContatos);
        /**
         * frmFtchat
         */
        frmFtchat = new JFrame();
        frmFtchat.setBackground(Color.WHITE);
        frmFtchat.getContentPane().setBackground(Color.WHITE);
        frmFtchat.setIconImage(Toolkit.getDefaultToolkit().getImage("iconbar.png"));
        frmFtchat.setTitle("FTChat");
        frmFtchat.getContentPane().addComponentListener(new ComponentAdapter() { @Override public void componentResized(ComponentEvent arg0) {resizeWindows();}});
        frmFtchat.setExtendedState(frmFtchat.getState() | Frame.MAXIMIZED_BOTH);
        frmFtchat.setBounds(100, 100, 800, 1000);
        frmFtchat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmFtchat.getContentPane().setLayout(null);
        frmFtchat.getContentPane().add(panelMessagensGlobal);
        frmFtchat.getContentPane().add(panelContatos);
        /**
         * Resize PainelContatos
         */
        ComponentResizer cr = new ComponentResizer();
        cr.setSnapSize(new Dimension(10, 10));
        cr.setDragInsets( new Insets(0,5, 0, 0) );
        cr.registerComponent(panelContatos);


        ComponentResizer cr2 = new ComponentResizer();
        cr2.setSnapSize(new Dimension(10, 10));
        cr2.setDragInsets( new Insets(5,0, 0, 0));
        cr2.registerComponent(paneltextMessage);

    }



    private void displayScrollBarsIfNecessary(JViewport viewPort) {
        displayVerticalScrollBarIfNecessary(viewPort);
        displayHorizontalScrollBarIfNecessary(viewPort);
    }

    private void displayVerticalScrollBarIfNecessary(JViewport viewPort) {
        Rectangle viewRect = viewPort.getViewRect();
        Dimension viewSize = viewPort.getViewSize();

        boolean shouldDisplayVerticalScrollBar =
                viewSize.getHeight() > viewRect.getHeight();
        verticalScrollBar.setVisible(shouldDisplayVerticalScrollBar);
    }

    private void displayHorizontalScrollBarIfNecessary(JViewport viewPort) {
        Rectangle viewRect = viewPort.getViewRect();
        Dimension viewSize = viewPort.getViewSize();
        boolean shouldDisplayHorizontalScrollBar =
                viewSize.getWidth() > viewRect.getWidth();
        horizontalScrollBar.setVisible(shouldDisplayHorizontalScrollBar);
    }

    private static class MyScrollBarButton extends JButton {
        private MyScrollBarButton() {
            setOpaque(false);
            setFocusable(false);
            setFocusPainted(false);
            setBorderPainted(false);
            setBorder(BorderFactory.createEmptyBorder());
        }
    }

    public static class MyScrollBarUI extends BasicScrollBarUI {
        @Override
        protected JButton createDecreaseButton(int orientation) {
            return new MyScrollBarButton();
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            return new MyScrollBarButton();
        }

        @Override
        protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {

            int alpha = isThumbRollover() ? SCROLL_BAR_ALPHA_ROLLOVER : SCROLL_BAR_ALPHA;
            int orientation = scrollbar.getOrientation();
            int arc = THUMB_SIZE;
            int x = trackBounds.x + THUMB_BORDER_SIZE;
            int y = trackBounds.y + THUMB_BORDER_SIZE;

            int width = orientation == JScrollBar.VERTICAL ?
                    THUMB_SIZE : trackBounds.width - (THUMB_BORDER_SIZE * 2);
            width = Math.max(width, THUMB_SIZE);

            int height = orientation == JScrollBar.VERTICAL ?
                    trackBounds.height - (THUMB_BORDER_SIZE * 2) : THUMB_SIZE;
            height = Math.max(height, THUMB_SIZE);

            Graphics2D graphics2D = (Graphics2D) g.create();
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            graphics2D.setColor(Color.WHITE);
            graphics2D.fillRoundRect(x, y, width, height, 0, 0);
            graphics2D.dispose();

        }

        @Override
        protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
            int alpha = isThumbRollover() ? SCROLL_BAR_ALPHA_ROLLOVER : SCROLL_BAR_ALPHA;
            int orientation = scrollbar.getOrientation();
            int arc = THUMB_SIZE;
            int x = thumbBounds.x + THUMB_BORDER_SIZE;
            int y = thumbBounds.y + THUMB_BORDER_SIZE;

            int width = orientation == JScrollBar.VERTICAL ?
                    THUMB_SIZE : thumbBounds.width - (THUMB_BORDER_SIZE * 2);
            width = Math.max(width, THUMB_SIZE);

            int height = orientation == JScrollBar.VERTICAL ?
                    thumbBounds.height - (THUMB_BORDER_SIZE * 2) : THUMB_SIZE;
            height = Math.max(height, THUMB_SIZE);

            Graphics2D graphics2D = (Graphics2D) g.create();
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            graphics2D.setColor(new Color(THUMB_COLOR.getRed(),
                    THUMB_COLOR.getGreen(), THUMB_COLOR.getBlue(), alpha));
            graphics2D.fillRoundRect(x, y, width, height, arc, arc);
            graphics2D.dispose();
        }
    }
    /**
     * metodo responsalve pelo recalculo quando alterado o tamanho do campo de escrita de texto
     */
    protected void resizeTextMessage() {
    try{
        int height;

        if(paneltextMessage.getHeight() <= 126) {
            height = 126;
        }else if(paneltextMessage.getHeight() >= frmFtchat.getHeight()/2) {
            height = frmFtchat.getHeight()/2;
        }else {
            height = paneltextMessage.getHeight();
        }

        paneltextMessage.setBounds(0, frmFtchat.getHeight()-height, panelMessagensGlobal.getWidth(), height);
        panelMessagens.setBounds(0, topPanelMessagens.getHeight(), panelMessagensGlobal.getWidth(), panelMessagensGlobal.getHeight()-topPanelMessagens.getHeight()-height);
        textAreaMessage.setBounds(10, 10, paneltextMessage.getWidth()-20-btnNewButton.getWidth()-10,height-60 );
        btnNewButton.setBounds(paneltextMessage.getWidth()-10-btnNewButton.getWidth(),20,btnNewButton.getWidth() ,btnNewButton.getHeight() );
        scrollPane.setBounds(0, topPanelMessagens.getHeight(), panelMessagensGlobal.getWidth(), panelMessagensGlobal.getHeight()-topPanelMessagens.getHeight()-height);
        scrollPaneContatos.setBounds(10, topPanelContatos.getHeight(), panelContatos.getWidth()-10, panelContatos.getHeight()-topPanelContatos.getHeight());

    }catch (Exception ex){

    }

    }

    protected void sendMessage()
    {
        Controller.enviarMensagem(textAreaMessage.getText());
        textAreaMessage.setText("");

    }

    protected void keyPress(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
            sendMessage();
            ke.consume();
        }
    }


    /**
     * metodo responsalve pelo recalculo quando alterado o tamanho da aba de contato
     */
    protected void resizeContatos() {
        try{

        if(panelContatos.getWidth() <= 350) {
            panelContatos.setBounds(0, 0, 350, frmFtchat.getHeight());
        }else if(panelContatos.getWidth() >= frmFtchat.getWidth()/2){
            panelContatos.setBounds(0, 0, frmFtchat.getWidth()/2, frmFtchat.getHeight());
        }

        lblNewLabel.setBounds((panelMessagensGlobal.getWidth()-183)/2, (panelMessagensGlobal.getHeight()-48)/2, 183, 48);
        panelMessagensGlobal.setBounds(0, 0, frmFtchat.getWidth()-panelContatos.getWidth(), frmFtchat.getHeight());
        panelContatos.setBounds(panelMessagensGlobal.getWidth(), 0, panelContatos.getWidth(), frmFtchat.getHeight());
        topPanelContatos.setBounds(0, 0, panelContatos.getWidth(), topPanelMessagens.getHeight());
        panelContatos.setVisible(true);
        topPanelContatos.setBounds(-5, 0, panelContatos.getWidth()-5, topPanelMessagens.getHeight());
        lblContatos.setBounds(50, 2, panelContatos.getWidth()-60, topPanelMessagens.getHeight());
        lblNewLabel_1.setBounds(panelContatos.getWidth()-50, 14, 25 , 25);
        topPanelMessagens.setBounds(0, 0, panelMessagensGlobal.getWidth(), topPanelMessagens.getHeight());
        lblContatoNome.setBounds(30, 0, panelMessagensGlobal.getWidth()-10, topPanelMessagens.getHeight());
        resizeTextMessage();

        //panelMessagens.updateUI();
        }catch (Exception ex){

        }
    }
    /**
     * metodo responsalve pelo recalculo quando alterado o tamanho da janela
     */
    protected void resizeWindows() {
        resizeContatos();
    }

    /**
     * 	Metodos adição mensagem recebidas (a esquerda)
     */

    public void setnameContatoConversaAtual(String nome){
        lblContatoNome.setText(nome);
        lblContatoNome.updateUI();
    }

    public void setVisibleImgLogo(boolean visible){

    }

    public  void clearAllMessage(){
        panelMessagens.removeAll();

        countMessage= 0;
    }

    public  void clearAllContatos(){
        Contatos.removeAll();
        Contatos.updateUI();
        countcontatos= 0;
    }

    public void addNewMessageLeft(String message, TemporalAccessor date) {

        LocalDateTime now = LocalDateTime.now();
        JPanel aux = panelsub(message,true,"left",dtf.format(date));

        panelMessagens.add(aux,"cell 0 "+countMessage+",width 85%,alignx left");

        countMessage++;
        scrollPane.getVerticalScrollBar().setValue(100);

        vertical = scrollPane.getVerticalScrollBar();
        vertical.setValue( vertical.getMaximum() + 1000 );
    }
    /**
     * 	Metodos adição mensagem enviadas (a diretira)
     */

    public void addNewMessageRight(String message,TemporalAccessor date) {

        LocalDateTime now = LocalDateTime.now();
        JPanel aux = panelsub(message,false,"right",dtf.format(date));

        panelMessagens.add(aux,"cell 0 "+countMessage+",width 85%,alignx right");

        countMessage++;
        scrollPane.getVerticalScrollBar().setValue(110);

        vertical = scrollPane.getVerticalScrollBar();
        vertical.setValue( vertical.getMaximum() + 1000 );


        //scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());

    }
    public void panelMessagensUpdateui(){
        panelMessagens.updateUI();
    }
    /**
     * 	metodo para adicionar o nome do amigo na lista
     */
    public void addContato(String fulname,String username) {

        lblcontatoMatriz = new JLabel(fulname);
        lblcontatoMatriz.setFont(new Font("Arial", Font.PLAIN, 16));
        lblcontatoMatriz.setForeground(Color.LIGHT_GRAY);
        lblcontatoMatriz.setName(username);
        lblcontatoMatriz.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                Controller.setSelectedFriend(username);
            }
        });

        Contatos.add(lblcontatoMatriz, "cell 0 "+countcontatos);

        countcontatos++;

        Contatos.updateUI();

    }



    /**
     * 	metodo para criar os elementos de uma mensagem
     */
    private JPanel panelsub(String messagem, boolean blue,String textAling, String data ) {

        JPanel panel = new JPanel();
        JTextArea auxtext = new JTextArea();
        JLabel newLabel = new JLabel(data);

        if(blue) {
            panel.setBackground(new java.awt.Color(80,157,225));
            auxtext.setForeground(Color.WHITE);
            newLabel.setForeground(Color.WHITE);
        }else {
            panel.setBackground(new java.awt.Color(241,245,248));
            auxtext.setForeground(Color.black);
            newLabel.setForeground(Color.black);
        }
        panel.setBounds(0, 0, 290, 50 );

        panel.setLayout(new MigLayout("", "10[100%]10", "10[fill]10"));

        auxtext.setFont(new Font("Verdana", Font.PLAIN, 14));
        if(textAling == "right") {
            auxtext.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
            newLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        }else {
            auxtext.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            newLabel.setHorizontalAlignment(SwingConstants.LEFT);
        }
        auxtext.setText(messagem);
        auxtext.setWrapStyleWord(true);
        auxtext.setLineWrap(true);
        auxtext.setOpaque(false);
        auxtext.setEditable(false);
        auxtext.setFocusable(false);
        auxtext.updateUI();
        newLabel.setFont(new Font("Arial", Font.PLAIN, 10));

        panel.add(auxtext,"grow,wmin 10,wrap");
        panel.add(newLabel,"grow,wmin 10");

        return panel;
    }


}