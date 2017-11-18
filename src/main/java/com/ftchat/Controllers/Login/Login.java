package com.ftchat.Controllers.Login;

import com.ftchat.backend.user.User;
import com.ftchat.backend.user.UserDaoImpl;
import com.ftchat.Controllers.Cadastrar.Cadastrar;
import com.ftchat.frontend.Chat.Chat;

import java.util.List;

public class Login {


    public static void showLogin(){
        com.ftchat.frontend.Login.Login frm = new com.ftchat.frontend.Login.Login();
        frm.Show();
    }

    public static void validarLogin(com.ftchat.frontend.Login.Login frm,String username, String password){
        UserDaoImpl userDao = new UserDaoImpl();
        try {
            List<User> users = userDao.getAllUsers();

            if(users == null){
                frm.printerro("Usuario e/ou senha incorretos!");
            }else{
                for (User user:users) {
                    if(username.equals(user.getName()) && user.validPassword(password)){
                        com.ftchat.Controllers.Chat.Chat chat = new com.ftchat.Controllers.Chat.Chat(user);
                        return;
                    }
                }
                frm.printerro("Usuario e/ou senha incorretos!");
            }
        }catch (Exception ex) {
            frm.printerro("Usuario e/ou senha incorretos!");
            //System.out.println(ex.toString());
        }
    }

    public  static void Cadastrar(com.ftchat.frontend.Login.Login frm){
        frm.Hide();
        Cadastrar.showLogin();
    }



}
