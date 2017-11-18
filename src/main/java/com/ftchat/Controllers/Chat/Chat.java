package com.ftchat.Controllers.Chat;

import com.ftchat.backend.user.User;

public class Chat {

    private User user;

    public Chat(User user){
        this.user = user;

        com.ftchat.frontend.Chat.Chat frm = new com.ftchat.frontend.Chat.Chat();

        frm.Show();

    }

}
