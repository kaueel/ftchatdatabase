package com.ftchat.Controllers.Cadastrar;

import com.ftchat.Controllers.Chat.Chat;
import com.ftchat.Controllers.ControllerOwner;
import com.ftchat.backend.user.User;
import com.ftchat.backend.user.UserDaoImpl;
import com.ftchat.frontend.Cadastro.Cadastro;
import com.ftchat.frontend.Chat.AdicionarNovoAmigo;
import com.ftchat.frontend.Login.Login;

import java.util.List;

public class Cadastrar extends ControllerOwner{

    public Cadastrar(Login frmlogin, Cadastro frmcaCadastro, com.ftchat.frontend.Chat.Chat frmChat, AdicionarNovoAmigo frmAddFriends){
        this.frmLogin = frmlogin;
        this.frmCadastro = frmcaCadastro;
        this.frmChat = frmChat;
        this.frmAddFriends = frmAddFriends;
    }

    public void show(){

        if(frmCadastro==null)
            frmCadastro = new Cadastro(this);

        frmCadastro.Show();
    }

    public void cadastar(User user){
        UserDaoImpl userDao = new UserDaoImpl();
        try {
            List<User> users = userDao.getAllUsers();

            if(users != null){
                for (User usuario:users) {
                    if (usuario.getName().equals(user.getName()) || usuario.getemail().equals(user.getemail())) {
                        frmCadastro.printerro("Usuario ja cadastrado");
                        return;
                    }
                }
            }

            if(userDao.executeFtpInsert("users",user) == null){
                frmCadastro.printerro("Erro ao cadastrar");
            }{
                frmCadastro.Hide();
                Chat chat = new Chat(user,frmLogin,frmCadastro,frmChat,frmAddFriends);
            }

        }catch (Exception ex) {
            frmCadastro.printerro("Usuario e/ou senha incorretos!");
            System.out.println(ex.toString());
        }
    }

    public void showLogin(){

        frmCadastro.Hide();

        if(frmLogin == null){
            com.ftchat.Controllers.Login.Login login = new com.ftchat.Controllers.Login.Login(frmLogin,frmCadastro,frmChat,frmAddFriends);
            login.showLogin();
        }else{
            frmLogin.Show();
        }
    }

}
