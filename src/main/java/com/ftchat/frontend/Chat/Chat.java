package com.ftchat.frontend;


import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import Control.ComponentMover;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashSet;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import java.awt.Color;

import javax.sound.midi.Track;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSeparator;
import javax.swing.UIManager;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
//import com.jgoodies.forms.layout.FormSpecs;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JViewport;




public class Chat {





    /**
     * Atributos do form
     */
    private JFrame frmFtchat;
    private JPanel panelMessagensGlobal;
    private JPanel panelContatos;
    private JPanel topPanelMessagens;
    private JLabel lblContatoNome;
    private JPanel topPanelContatos;
    private JLabel lblContatos;
    private JPanel panelMessagens;
    private boolean firstload = true;
    private JPanel paneltextMessage;
    private JPanel panel;
    private JPanel panel2;
    private JTextArea textArea;
    private JTextArea textAreaMessage;
    private JScrollPane scrollPane;
    private JButton btnNewButton;
    private static final int SCROLL_BAR_ALPHA_ROLLOVER = 150;
    private static final int SCROLL_BAR_ALPHA = 100;
    private static final int THUMB_BORDER_SIZE = 2;
    private static final int THUMB_SIZE = 8;
    private static final Color THUMB_COLOR = Color.GRAY;
    private JScrollBar vertical;
    private JPanel Contatos;
    private JScrollBar verticalScrollBar;
    private JScrollBar horizontalScrollBar;
    private JScrollPane scrollPaneContatos;

    /**
     * Atributos da View
     */
    private java.util.ArrayList<JPanel> Messsage = new java.util.ArrayList<JPanel>();
    private java.util.ArrayList<JTextArea> MessageText = new java.util.ArrayList<JTextArea>();
    private int countMessage = 1;
    private int countcontatos = 0;
    private int tamanho = 0;
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private JLabel lblNewLabel;
    /**
     * Construtor do form
     */
    public Chat() {

        initialize();

        UIManager.put("InternalFrame.activeTitleBackground", new ColorUIResource(Color.black ));
        UIManager.put("InternalFrame.activeTitleForeground", new ColorUIResource(Color.WHITE));
        UIManager.put("InternalFrame.titleFont", new Font("Dialog", Font.PLAIN, 11));

        addContato("Vinicius Cazelli Ferreira", 1);
        addContato("Kaue Eufrosino Lima", 2);
        addContato("Japa", 2);
        addContato("Vinicius Cazelli Ferreira", 1);
        addContato("Kaue Eufrosino Lima", 2);
        addContato("Japa", 2);
        addContato("Vinicius Cazelli Ferreira", 1);
        addContato("Kaue Eufrosino Lima", 2);
        addContato("Japa", 2);
        addContato("Vinicius Cazelli Ferreira", 1);
        addContato("Kaue Eufrosino Lima", 2);
        addContato("Japa", 2);
        addContato("Vinicius Cazelli Ferreira", 1);
        addContato("Kaue Eufrosino Lima", 2);
        addContato("Japa", 2);
        addContato("Vinicius Cazelli Ferreira", 1);
        addContato("Kaue Eufrosino Lima", 2);
        addContato("Japa", 2);
        addContato("Vinicius Cazelli Ferreira", 1);
        addContato("Kaue Eufrosino Lima", 2);
        addContato("Japa", 2);
        addContato("Vinicius Cazelli Ferreira", 1);
        addContato("Kaue Eufrosino Lima", 2);
        addContato("Japa", 2);
        addContato("Vinicius Cazelli Ferreira", 1);
        addContato("Kaue Eufrosino Lima", 2);
        addContato("Japa", 2);
        addContato("Vinicius Cazelli Ferreira", 1);
        addContato("Kaue Eufrosino Lima", 2);
        addContato("Japa", 2);

    }




    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Chat window = new Chat();
                    window.frmFtchat.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void Show() {
        try {
            Chat window = new Chat();
            window.frmFtchat.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Create the application.
     */





    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {



        /**
         * lblContatoNome
         */
        lblContatoNome = new JLabel("Vinicius Cazelli Ferreira");
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
         * paneltextMessage
         */

        textAreaMessage = new JTextArea();
        textAreaMessage.setBackground(new java.awt.Color(240,240,240));
        textAreaMessage.setBounds(30, 6, 401, 95);
        textAreaMessage.setWrapStyleWord(true);
        textAreaMessage.setLineWrap(true);

        Border border = BorderFactory.createLineBorder(new java.awt.Color(240,240,240));
        textAreaMessage.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));


        paneltextMessage = new JPanel();
        paneltextMessage.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(230,230,230)));
        paneltextMessage.setBackground(Color.WHITE);
        paneltextMessage.addComponentListener(new ComponentAdapter() {@Override public void componentResized(ComponentEvent arg0) { resizeTextMessage();}});
        paneltextMessage.setBounds(0, 436, 602, 126);
        paneltextMessage.setLayout(null);
        paneltextMessage.setMinimumSize(new Dimension(602,126));

        btnNewButton = new JButton("Enviar");
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setBackground(new java.awt.Color(80,157,225));
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addNewMessageLeft(textAreaMessage.getText());
                addNewMessageRight(textAreaMessage.getText());
            }
        });
        btnNewButton.setBounds(502, 40, 90, 45);
        paneltextMessage.add(btnNewButton);

        paneltextMessage.add(textAreaMessage);



        /**
         * panelMessagens
         */
        panelMessagensGlobal = new JPanel();
        panelMessagensGlobal.setBackground(Color.WHITE);
        panelMessagensGlobal.setBounds(0, 0, 602, 600);
        panelMessagensGlobal.setLayout(null);
        panelMessagensGlobal.add(topPanelMessagens);
        /**
         JScrollPane jScrollPane = new JScrollPane();
         // only a configuration to the jScrollPane...
         jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
         jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

         jScrollPane.setViewportView(panelMessagens);
         */
        panelMessagens = new JPanel();


        panelMessagens.setBackground(Color.WHITE);
        panelMessagens.setBounds(0, 47, 602, 400);
        panelMessagens.setLayout(new MigLayout("width parent.w", "10[100%]10", "[fill]10"));
        //JScrollPane jScrollPane = new JScrollPane(panelMessagens,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


        scrollPane = new JScrollPane(panelMessagens,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setLocation(0, 117);
        scrollPane.setSize(602, 200);
        scrollPane.setBorder(null);
        scrollPane.setBackground(Color.WHITE);
        verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setVisible(false);
        verticalScrollBar.setOpaque(false);
        verticalScrollBar.setUI(new MyScrollBarUI());

        horizontalScrollBar = scrollPane.getHorizontalScrollBar();
        horizontalScrollBar.setVisible(false);
        horizontalScrollBar.setOpaque(false);
        horizontalScrollBar.setUI(new MyScrollBarUI());

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        panelMessagensGlobal.add(scrollPane);

        //panelMessagens.add(panel,"cell 0 1 ,width 85%,alignx right");
        panelMessagensGlobal.add(paneltextMessage);
        /**
         * lblContatos
         */
        lblContatos = new JLabel("Contatos");
        lblContatos.setHorizontalAlignment(SwingConstants.CENTER);
        lblContatos.setForeground(SystemColor.menu);
        lblContatos.setFont(new Font("Arial", Font.PLAIN, 18));
        lblContatos.setBounds(0, 0, 290, 40);
        /**
         * topPanelContatos
         */
        topPanelContatos = new JPanel();
        topPanelContatos.setBackground(new java.awt.Color(60,70,78));
        topPanelContatos.setBounds(0, 0, 290, 40);
        topPanelContatos.setLayout(null);
        topPanelContatos.add(lblContatos);

        Contatos = new JPanel();
        Contatos.setBounds(10, 51, 290, 297);
        Contatos.setBackground(new java.awt.Color(43,50,53));
        Contatos.setLayout(new MigLayout("width parent.w", "[100%]", "[40]"));




        scrollPaneContatos = new JScrollPane(Contatos,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneContatos.setLocation(0, 117);
        scrollPaneContatos.setSize(290, 200);
        scrollPaneContatos.setBorder(null);
        scrollPaneContatos.setBackground(new java.awt.Color(43,50,53));
        verticalScrollBar = scrollPaneContatos.getVerticalScrollBar();
        verticalScrollBar.setVisible(false);
        verticalScrollBar.setOpaque(false);
        verticalScrollBar.setUI(new MyScrollBarUI());

        horizontalScrollBar = scrollPaneContatos.getHorizontalScrollBar();
        horizontalScrollBar.setVisible(false);
        horizontalScrollBar.setOpaque(false);
        horizontalScrollBar.setUI(new MyScrollBarUI());

        scrollPaneContatos.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPaneContatos.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);



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
        frmFtchat.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Vinicius\\Documents\\iconbar.png"));
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
        Control.ComponentResizer cr = new Control.ComponentResizer();
        cr.setSnapSize(new Dimension(10, 10));
        cr.setDragInsets( new Insets(0,5, 0, 0) );
        cr.registerComponent(panelContatos);


        Control.ComponentResizer cr2 = new Control.ComponentResizer();
        cr2.setSnapSize(new Dimension(10, 10));
        cr2.setDragInsets( new Insets(5,0, 0, 0));
        cr2.registerComponent(paneltextMessage);

    }

    private void resizeTextMessage() {

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

    }

    private void resizeContatos() {


        if(panelContatos.getWidth() <= 350) {
            panelContatos.setBounds(0, 0, 350, frmFtchat.getHeight());
        }else if(panelContatos.getWidth() >= frmFtchat.getWidth()/2){
            panelContatos.setBounds(0, 0, frmFtchat.getWidth()/2, frmFtchat.getHeight());
        }


        panelMessagensGlobal.setBounds(0, 0, frmFtchat.getWidth()-panelContatos.getWidth(), frmFtchat.getHeight());
        panelContatos.setBounds(panelMessagensGlobal.getWidth(), 0, panelContatos.getWidth(), frmFtchat.getHeight());
        topPanelContatos.setBounds(0, 0, panelContatos.getWidth(), topPanelMessagens.getHeight());
        panelContatos.setVisible(true);
        topPanelContatos.setBounds(-5, 0, panelContatos.getWidth()-5, topPanelMessagens.getHeight());
        lblContatos.setBounds(-5, 0, panelContatos.getWidth()-5, topPanelMessagens.getHeight());
        topPanelMessagens.setBounds(0, 0, panelMessagensGlobal.getWidth(), topPanelMessagens.getHeight());
        lblContatoNome.setBounds(30, 0, panelMessagensGlobal.getWidth()-10, topPanelMessagens.getHeight());
        resizeTextMessage();

        //panelMessagens.updateUI();
    }

    private void resizeWindows() {
        resizeContatos();
    }

    /**
     * 	Metodos de controles
     */


    public void addNewMessageLeft(String message) {

        LocalDateTime now = LocalDateTime.now();
        JPanel aux = panelsub(textAreaMessage.getText(),true,"left",dtf.format(now));

        panelMessagens.add(aux,"cell 0 "+countMessage+",width 85%,alignx left");
        panelMessagens.updateUI();
        countMessage++;
        scrollPane.getVerticalScrollBar().setValue(100);

        vertical = scrollPane.getVerticalScrollBar();
        vertical.setValue( vertical.getMaximum() + 1000 );
    }

    public void addNewMessageRight(String message) {

        LocalDateTime now = LocalDateTime.now();
        JPanel aux = panelsub(textAreaMessage.getText(),false,"right",dtf.format(now));

        panelMessagens.add(aux,"cell 0 "+countMessage+",width 85%,alignx right");
        panelMessagens.updateUI();
        countMessage++;
        scrollPane.getVerticalScrollBar().setValue(110);

        vertical = scrollPane.getVerticalScrollBar();
        vertical.setValue( vertical.getMaximum() + 1000 );

        //scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());

    }

    public void addContato(String ContatoNome,int idContato) {


        lblNewLabel = new JLabel(ContatoNome);
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        lblNewLabel.setForeground(Color.LIGHT_GRAY);
        lblNewLabel.setName(""+idContato);
        Contatos.add(lblNewLabel, "cell 0 "+countcontatos);

        countcontatos++;

    }






    public JPanel panelsub(String messagem, boolean blue,String textAling, String data ) {

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

        newLabel.setFont(new Font("Arial", Font.PLAIN, 10));

        panel.add(auxtext,"grow,wmin 10,wrap");
        panel.add(newLabel,"grow,wmin 10");

        return panel;
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

    private static class MyScrollBarUI extends BasicScrollBarUI {
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
}