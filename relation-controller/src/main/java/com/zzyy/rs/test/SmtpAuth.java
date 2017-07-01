package com.zzyy.rs.test;

import javax.mail.Authenticator;

/**
 * Created by Administrator on 2017/7/1 0001.
 */
public class SmtpAuth extends Authenticator {

    private String username,password;

    public SmtpAuth(String username,String password){
        this.username = username;
        this.password = password;
    }
    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
        return new javax.mail.PasswordAuthentication(username,password);
    }
}
