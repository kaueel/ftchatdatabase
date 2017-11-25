package com.ftchat.Controllers.Login;

import com.ftchat.Controllers.ControllerOwner;
import com.ftchat.backend.user.User;
import com.ftchat.backend.user.UserDaoImpl;
import com.ftchat.Controllers.Cadastrar.Cadastrar;
import com.ftchat.frontend.Cadastro.Cadastro;
import com.ftchat.frontend.Chat.AdicionarNovoAmigo;
import com.ftchat.frontend.Chat.Chat;

import java.util.List;

public class Login extends ControllerOwner{

    public Login(com.ftchat.frontend.Login.Login frmlogin, Cadastro frmcaCadastro, com.ftchat.frontend.Chat.Chat frmChat, AdicionarNovoAmigo frmAddFriends){
        this.frmLogin = frmlogin;
        this.frmCadastro = frmcaCadastro;
        this.frmChat = frmChat;
        this.frmAddFriends = frmAddFriends;
    }

    public void showLogin(){
        frmLogin = new com.ftchat.frontend.Login.Login(this);
        frmLogin.Show();
    }

    public void validarLogin(String username, String password){
        UserDaoImpl userDao = new UserDaoImpl();
        try {
            List<User> users = userDao.getAllUsers();

            if(users == null){
                frmLogin.printerro("Usuario e/ou senha incorretos!");
            }else{
                for (User user:users) {
                    if(username.equals(user.getName()) && user.validPassword(password)){
                        frmLogin.Hide();
                        com.ftchat.Controllers.Chat.Chat chat = new com.ftchat.Controllers.Chat.Chat(user,frmLogin,frmCadastro,frmChat,frmAddFriends);
                        return;
                    }
                }
                frmLogin.printerro("Usuario e/ou senha incorretos!");
            }
        }catch (Exception ex) {
            frmLogin.printerro("Usuario e/ou senha incorretos!");
            //System.out.println(ex.toString());
        }
    }

    public  void Cadastrar(){
        frmLogin.Hide();
        if(frmCadastro == null){
            Cadastrar cadastro = new Cadastrar(frmLogin,frmCadastro,frmChat,frmAddFriends);
            cadastro.show();
        }else{
            frmCadastro.Show();
        }
    }



}
