package com.ftchat.frontend.Chat;


import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JFrame;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.ComponentOrientation;
import java.awt.SystemColor;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicScrollBarUI;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
import com.ftchat.frontend.Resources.ComponentResizer;
import net.miginfocom.swing.MigLayout;
//import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JViewport;




public class Chat extends com.ftchat.frontend.Chat.Desing{

    public Chat() {

        initialize();
        /**
         * teste
         */
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



    public  void clearAllMessage(){
        panelMessagens.removeAll();
        panelMessagens.updateUI();
        countMessage= 0;
    }

    public  void clearAllContatos(){
        Contatos.removeAll();
        Contatos.updateUI();
        countcontatos= 0;
    }

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
    /**
     * 	Metodos adição mensagem enviadas (a diretira)
     */

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
    /**
     * 	metodo para adicionar o nome do amigo na lista
     */
    public void addContato(String ContatoNome,int idContato) {


        lblcontatoMatriz = new JLabel(ContatoNome);
        lblcontatoMatriz.setFont(new Font("Arial", Font.PLAIN, 16));
        lblcontatoMatriz.setForeground(Color.LIGHT_GRAY);
        lblcontatoMatriz.setName(""+idContato);
        Contatos.add(lblcontatoMatriz, "cell 0 "+countcontatos);

        countcontatos++;

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

        newLabel.setFont(new Font("Arial", Font.PLAIN, 10));

        panel.add(auxtext,"grow,wmin 10,wrap");
        panel.add(newLabel,"grow,wmin 10");

        return panel;
    }


}