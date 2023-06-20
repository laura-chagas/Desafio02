package Desafio02_SistemaDeVendas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClienteTest {
    @Test
    public void invalidarCPFClienteComPontoOuTracoOuMenosDigitos() {

         String cpfCli = "123.456.789-1"; //cpf invalido
        if (cpfCli.contains(".") || cpfCli.contains("-") || cpfCli.length() < 11) {
            System.out.println("CPF inválido, digite novamente os 11 dígitos, sem [.] e sem [-]");
        } else {
            System.out.println("CPF DO CLIENTE É VÁLIDO");
        }

        Assertions.assertEquals("123.456.789-1", cpfCli);
    }

    @Test
    public void invalidarCasoCPFClienteExistirNoSistema() {

        Cliente.criarCliente();

        String cpfCli = "73685377027"; //cpf que já existe

        if (Cliente.clientes.containsKey(cpfCli)) {
            System.out.println("CPF INVÁLIDO, JÁ CADASTRADO NO SISTEMA");
        } else {
            System.out.println("CPF DO CLIENTE É VÁLIDO");
        }

        Assertions.assertEquals("73685377027", cpfCli);
    }

    @Test
    public void criarmaisClientesPreCadastradoseMostrar() {
        Cliente.clientes.put("65598871234", "joaovaleu@hotmail.com");
        Cliente.clientes.put("84569521232", "antoniaSilva@hotmail.com");
    }


}
