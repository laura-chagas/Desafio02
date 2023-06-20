package Desafio02_SistemaDeVendas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VendedorTest {
    @Test
    public void invalidarEmailVendedorSemArrobaEPonto() {

        String emailVend = "joseBalegmailcom"; //email invalido

        if ((!(emailVend.contains("@"))) || (!(emailVend.contains(".")))) {
            System.out.println("EMAIL inválido, digite novamente utilizando [@] e [.]");
        } else {
            System.out.println("EMAIL DO VENDEDOR É VÁLIDO");
        }

        Assertions.assertEquals("joseBalegmailcom", emailVend);
    }

    @Test
    public void invalidarSeEmailVendedorExistirNoSistema() {

        Vendedor.criarVendedores();

        String emailVend = "mariaGostaria@gmail.com"; //invalido

        if (Vendedor.vendedores.containsKey(emailVend)) {
            System.out.println("EMAIL INVÁLIDO, JÁ CADASTRADO NO SISTEMA");
        } else {
            System.out.println("EMAIL DO VENDEDOR É VÁLIDO");
        }

        Assertions.assertEquals("mariaGostaria@gmail.com", emailVend);
    }

    @Test
    public void criarmaisVendedoresPreCadastradoseMostrar() {
        Vendedor.vendedores.put("sandro@mendes.com", "58694521756");
        Vendedor.vendedores.put("murilo@yahoo.com.br", "74125639876");
        Vendedor.mostrarVendedores();
    }

}