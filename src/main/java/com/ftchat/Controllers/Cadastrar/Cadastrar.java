package com.ftchat.Controllers.Cadastrar;

import com.ftchat.backend.user.User;
import com.ftchat.backend.user.UserDaoImpl;
import com.ftchat.frontend.Cadastro.Cadastro;

import java.util.List;

public class Cadastrar {
    public static void showLogin(){
        Cadastro frm = new Cadastro();
        frm.Show();
    }

    public static void cadastar(User user,Cadastro frm){
        UserDaoImpl userDao = new UserDaoImpl();
        try {
            List<User> users = userDao.getAllUsers();

            if(users != null){
                for (User usuario:users) {
                    if (usuario.getName().equals(user.getName()) || usuario.getemail().equals(user.getemail())) {
                        frm.printerro("Usuario ja cadastrado");
                        return;
                    }
                }
            }

            if(userDao.executeFtpInsert("users",user) == null){
                frm.printerro("Erro ao cadastrar");
            }{
                System.exit(0);
            }

        }catch (Exception ex) {
            frm.printerro("Usuario e/ou senha incorretos!");
            System.out.println(ex.toString());
        }
    }

}
