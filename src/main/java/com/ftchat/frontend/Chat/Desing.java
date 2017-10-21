package com.ftchat.frontend.Chat;

import com.ftchat.frontend.Resources.ComponentResizer;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.format.DateTimeFormatter;

public abstract class Desing{

    protected JScrollBar verticalScrollBar;
    protected JScrollBar horizontalScrollBar;

    private static final int SCROLL_BAR_ALPHA_ROLLOVER = 150;
    private static final int SCROLL_BAR_ALPHA = 100;
    private static final int THUMB_BORDER_SIZE = 2;
    private static final int THUMB_SIZE = 8;
    private static final Color THUMB_COLOR = Color.GRAY;

    /**
     * Atributos do form
     */
    //Jframe
    protected JFrame frmFtchat;
    //JPanel
    protected JPanel panelMessagensGlobal;
    protected JPanel panelContatos;
    protected JPanel topPanelMessagens;
    protected JPanel topPanelContatos;
    protected JPanel panelMessagens;
    protected JPanel paneltextMessage;
    protected JPanel panel;
    protected JPanel panel2;
    protected JPanel Contatos;
    //Jlabel
    protected JLabel lblContatos;
    protected JLabel lblContatoNome;
    protected JLabel lblcontatoMatriz;
    //JTextArea
    protected JTextArea textArea;
    protected JTextArea textAreaMessage;
    //JScrollPane
    protected JScrollPane scrollPane;
    protected JScrollPane scrollPaneContatos;
    //JScrollBar
    protected JScrollBar vertical;

    //JButton
    protected JButton btnNewButton;

    /**
     * Atributos da View
     */

    protected int countMessage = 1;
    protected int countcontatos = 0;
    protected static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    /**
     * run windows.
     */
    public void Show() {
        try {
            Chat window = new Chat();
            window.frmFtchat.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Initialize the contents of the frame.
     */
    protected void initialize() {



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
         * textAreaMessage
         */
        textAreaMessage = new JTextArea();
        textAreaMessage.setBackground(new java.awt.Color(240,240,240));
        textAreaMessage.setBounds(30, 6, 401, 95);
        textAreaMessage.setWrapStyleWord(true);
        textAreaMessage.setLineWrap(true);

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
                addNewMessageLeft(textAreaMessage.getText());       //  Chama funcao enviar nova mensagem
                addNewMessageRight(textAreaMessage.getText());      //

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
         * panelMessagens
         */
        panelMessagensGlobal = new JPanel();
        panelMessagensGlobal.setBackground(Color.WHITE);
        panelMessagensGlobal.setBounds(0, 0, 602, 600);
        panelMessagensGlobal.setLayout(null);
        panelMessagensGlobal.add(topPanelMessagens);
        panelMessagensGlobal.add(scrollPane);
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
        ComponentResizer cr = new ComponentResizer();
        cr.setSnapSize(new Dimension(10, 10));
        cr.setDragInsets( new Insets(0,5, 0, 0) );
        cr.registerComponent(panelContatos);


        ComponentResizer cr2 = new ComponentResizer();
        cr2.setSnapSize(new Dimension(10, 10));
        cr2.setDragInsets( new Insets(5,0, 0, 0));
        cr2.registerComponent(paneltextMessage);

    }



    protected void displayScrollBarsIfNecessary(JViewport viewPort) {
        displayVerticalScrollBarIfNecessary(viewPort);
        displayHorizontalScrollBarIfNecessary(viewPort);
    }

    protected void displayVerticalScrollBarIfNecessary(JViewport viewPort) {
        Rectangle viewRect = viewPort.getViewRect();
        Dimension viewSize = viewPort.getViewSize();

        boolean shouldDisplayVerticalScrollBar =
                viewSize.getHeight() > viewRect.getHeight();
        verticalScrollBar.setVisible(shouldDisplayVerticalScrollBar);
    }

    protected void displayHorizontalScrollBarIfNecessary(JViewport viewPort) {
        Rectangle viewRect = viewPort.getViewRect();
        Dimension viewSize = viewPort.getViewSize();
        boolean shouldDisplayHorizontalScrollBar =
                viewSize.getWidth() > viewRect.getWidth();
        horizontalScrollBar.setVisible(shouldDisplayHorizontalScrollBar);
    }

    protected static class MyScrollBarButton extends JButton {
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

    protected abstract void resizeWindows();
    protected abstract void resizeContatos();
    protected abstract void resizeTextMessage();
    public abstract void addNewMessageLeft(String message);
    public abstract void addNewMessageRight(String message);

}
