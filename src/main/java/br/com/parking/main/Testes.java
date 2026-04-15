package br.com.parking.main;

import br.com.parking.exception.CepInvalidoException;
import br.com.parking.model.CepRecord;
import br.com.parking.model.Endereco;
import br.com.parking.util.ConsumoCEP;
import br.com.parking.util.EmailService;

import java.io.IOException;
import java.util.Scanner;

public class Testes {
    static void main(String[] args) throws IOException, InterruptedException {
        EmailService emailService = new EmailService();

        var codigo = emailService.gerarCodigo();
        emailService.enviarEmailConfirmacao("vitor@linkedby.us", "Carlo", emailService.gerarCodigo());
    }
}
