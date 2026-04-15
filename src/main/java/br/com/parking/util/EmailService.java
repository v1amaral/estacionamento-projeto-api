package br.com.parking.util;

import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.security.SecureRandom;
import java.util.Properties;

public class EmailService {

    public String gerarCodigo() {
        SecureRandom random = new SecureRandom();
        int num = random.nextInt(900000) + 100000; // Garante um número de 6 dígitos
        return String.valueOf(num);
    }

    public void enviarEmail(String emailDestino, String subject, String corpoHtml) {
        try {
            Message message = new MimeMessage(EmailConfig.getSession());
            message.setFrom(new InternetAddress(EmailConfig.getRemetente()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailDestino));
            message.setSubject(subject);
            message.setContent(corpoHtml, "text/html; charset=utf-8");

            // 4. Envio
            Transport.send(message);
            System.out.println("E-mail enviado com sucesso!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void enviarEmailRecuperacao(String emailDestino, String codigo){
        String corpoHtml = "<div style='font-family: sans-serif;'>" +
                "<h2>Recuperação de Senha</h2>" +
                "<p>Seu código é: <b>" + codigo + "</b></p>" +
                "</div>";

        enviarEmail(emailDestino, "Recuperação de senha", corpoHtml);
    }

    public void enviarEmailConfirmacao(String emailDestino, String nomeUsuario, String codigo){
        String html = "<div style='font-family: sans-serif; border: 1px solid #ddd; padding: 20px; border-radius: 10px; max-width: 500px;'>" +
                "<h2 style='color: #28a745;'>Bem-vindo ao Parking System!</h2>" +
                "<p>Olá, <strong>" + nomeUsuario + "</strong>!</p>" +
                "<p>Falta pouco para ativar sua conta. Use o código de confirmação abaixo no sistema:</p>" +
                "<div style='background-color: #f8f9fa; padding: 15px; text-align: center; border-radius: 5px;'>" +
                "  <span style='font-size: 24px; font-weight: bold; color: #333; letter-spacing: 4px;'>" + codigo + "</span>" +
                "</div>" +
                "<p style='font-size: 12px; color: #777; margin-top: 20px;'>" +
                "Se você não realizou este cadastro, ignore este e-mail.</p>" +
                "</div>";

        enviarEmail(emailDestino, "Confirme seu e-mail - Parking System", html);
    }
}
