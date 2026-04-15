package br.com.parking.util;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;

import java.util.Properties;

public class EmailConfig {
    private static final String EMAIL = "vitorsantosamaral123@gmail.com";
    private static final String SENHA = "afyl qzsz azkr vcci"; // Não é a senha normal, veja o aviso abaixo!

    public static Session getSession(){
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        return Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL, SENHA);
            }
        });
    }

    public static String getRemetente(){
        return EMAIL;
    }
}
