package com.ftchat.Controllers.Chat;

import com.ftchat.Controllers.ControllerOwner;
import com.ftchat.backend.friends.Friend;
import com.ftchat.backend.friends.FriendDaoImpl;
import com.ftchat.backend.message.Message;
import com.ftchat.backend.message.MessageDaoImpl;
import com.ftchat.backend.user.User;
import com.ftchat.backend.user.UserDaoImpl;
import com.ftchat.frontend.Cadastro.Cadastro;
import com.ftchat.frontend.Chat.AdicionarNovoAmigo;
import com.ftchat.frontend.Login.Login;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Chat extends ControllerOwner{

    private User user;
    private List<Friend> friends;
    private User friend;
    private Thread th;

    public Chat(User user, Login frmlogin, Cadastro frmcaCadastro, com.ftchat.frontend.Chat.Chat frmChat, AdicionarNovoAmigo frmAddFriends){
        this.user = user;
        this.frmLogin = frmlogin;
        this.frmCadastro = frmcaCadastro;
        this.frmChat = frmChat;
        this.frmAddFriends = frmAddFriends;

        if(frmChat ==null)
            this.frmChat = new com.ftchat.frontend.Chat.Chat(this);

        this.frmChat.Show();

        atualizarContatos();

    }

    public void setSelectedFriend(String username){

        for (Friend friend:friends) {
            if(friend.getUser().getName().equals(username)){
                this.friend = friend.getUser();
                break;
            }
        }

        frmChat.setnameContatoConversaAtual(friend.getfullName());

        atualizarMensagens();
    }

    public void AdicionarNovoAmigo(){
        frmAddFriends = new AdicionarNovoAmigo(this);
        frmAddFriends.Show();

        //frmChat.clearAllContatos();

        //loadAllFriends();
    }

    public void enviarMensagem(String messagem){

        try{
            MessageDaoImpl messageDao = new MessageDaoImpl();
            Message message = new Message(user.getName(),messagem);
            message = messageDao.sendMessage(message,user,friend);

            frmChat.addNewMessageRight(message.getContent(),message.getDate());
            frmChat.panelMessagensUpdateui();

        }catch (Exception ex){
            JOptionPane.showMessageDialog(null,"Erro: "+ ex.getMessage(),".:: FTChat :: Erro ao carregar os amigos ::.",JOptionPane.ERROR_MESSAGE);
        }
    }


    private void loadAllFriends(){

        try{

            FriendDaoImpl friendDao = new FriendDaoImpl();
            friends = friendDao.getAllFriends(user);
            frmChat.clearAllContatos();
            if(friends != null){

                for (Friend friend:friends) {
                    frmChat.addContato(friend.getUser().getfullName(),friend.getUser().getName());
                }
            }
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null,"Erro: "+ ex.getMessage(),".:: FTChat :: Erro ao carregar os amigos ::.",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void AddFriend(String username){
        UserDaoImpl userDao = new UserDaoImpl();
        try {
            List<User> users = userDao.getAllUsers();

            if(users == null){
                frmAddFriends.printerro("Usuário não encontrado!");
            }else{
                for (User user:users) {
                    if(username.equals(user.getName()) && !user.equals(this.user) ){
                        if(friends == null){
                            friends = new ArrayList<>();
                        }else if(friends.contains(new Friend(user))){
                            frmAddFriends.printerro("Usuário já adicionado!");
                            return;
                        }
                        FriendDaoImpl friendDao = new FriendDaoImpl();
                        Friend friend = friendDao.addFriend(this.user,user);
                        frmChat.addContato(friend.getUser().getfullName(),friend.getUser().getName());
                        friends.add(friend);
                        frmAddFriends.Hide();
                        return;
                    }
                }
                frmAddFriends.printerro("Não foi possivel adicionar");
            }
        }catch (Exception ex) {
            frmAddFriends.printerro("Erro ao pesquisar" + ex.getMessage());
            //System.out.println(ex.toString());
        }
    }

    private void atualizarMensagens(){

        stopThreadUpdate();

        th = new Thread() {

            @Override
            public void run() {

                while(true){
                    try{

                        MessageDaoImpl messageDao = new MessageDaoImpl();

                        List<Message> messages = messageDao.getAllMessagesFromChat(user,friend);

                        frmChat.clearAllMessage();

                        for(Message message: messages){

                            if(message.getSender().equals(user.getName())){
                                frmChat.addNewMessageRight(message.getContent(),message.getDate());
                            }else{
                                frmChat.addNewMessageLeft(message.getContent(),message.getDate());
                            }
                        }

                        frmChat.panelMessagensUpdateui();

                        Thread.sleep(5000);
                    }catch (Exception ex){

                    }
                }
            }
        };

        if(true){
            th.start();
        }
    }

    private void atualizarContatos(){

        stopThreadUpdate();

        th = new Thread() {

            @Override
            public void run() {

                while(true){
                    try{

                        loadAllFriends();

                        Thread.sleep(10000);
                    }catch (Exception ex){

                    }
                }
            }
        };

        if(true){
            th.start();
        }
    }

    private void stopThreadUpdate(){
        if(th != null)
            th.stop();

        th = null;
    }


}
