package Desafio02_SistemaDeVendas;


import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.*;
public class Cliente{
    public static Scanner scan = new Scanner(System.in);
    public static Map<String, String> clientes = new HashMap<>();
    public static Map<String, List<String>> compraAssociada = new HashMap<>();
    public static List<String> listaCompras = new ArrayList<>();

    public static Map<String, String> login = new HashMap<>();
     static String senhaCrip, senha, cpf, email;

    public static void criarCliente() {
        clientes.put("73685377027", "anaLeviana@gmail.com"); //novo cliente
        clientes.put("84759621366", "marceloMartelo@gmail.com");
    }

    public static void cadastrarCliente() {

        System.out.println("Informe seu cpf: ");
         cpf = scan.next();

        while(cpf.contains(".") || cpf.contains("-") || cpf.length() < 11){
            System.out.println("CPF inválido, digite novamente os 11 dígitos, sem [.] e sem [-]");

            System.out.println("Informe seu cpf: ");
             cpf = scan.next();
        }

        System.out.println("Informe seu email: ");
        email = scan.next();

        while (!(email.contains("@")) && !(email.contains("."))) {
            System.out.println("Email inválido, tente novamente com [@] e [.]");

            System.out.println("Informe seu email: ");
            email = scan.next();

        }

        System.out.println("Informe uma senha: ");
        senha = scan.next();

        while (!(senha.contains(" ")) && !(senha.length() >= 6)){
            System.out.println("Senha inválida, por favor, tente novamente sem espaço e nem menos que 6 caracteres");
            System.out.println("Informe uma senha: ");
            senha = scan.next();
        }

        senhaCrip = BCrypt.hashpw(senha, BCrypt.gensalt());

        while (clientes.containsKey(cpf) || clientes.containsValue(email)) {
            System.out.println("Não foi possível realizar o cadastro, pois o Cliente já está em nosso sistema. Tente novamente\n");
            System.out.println("Informe seu cpf: ");
            cpf = scan.next();

            System.out.println("Informe seu email: ");
            email = scan.next();
        }

        clientes.put(cpf, email);

        login.put(email, senhaCrip);

        System.out.println("Cliente cadastrado com sucesso!");

    }

    public static void loginCliente(){

        System.out.println("Informe seu email: ");
        String verfEmail = scan.next();

        System.out.println("Informe sua senha: ");
        String senhaVerf = scan.next();

        if (login.containsKey(verfEmail) && BCrypt.checkpw(senhaVerf, senhaCrip)){
            System.out.println("Login efetuado");
        }else {
            System.out.println("Email ou senha incorretos, tente novamente");
        }

    }
    public static void mostrarClientes() {

        for (Map.Entry<String, String> entry : clientes.entrySet()) {
            System.out.println("CPF: " + entry.getKey() + ", EMAIL: " + entry.getValue());
        } // mostrar clientes existentes

    }

    public static void Comprar() {

        System.out.println("Informe seu cpf: ");
        String verf = scan.next();
        if (clientes.containsKey(verf)) {
            System.out.println("Digite o código do produto: ");
            listaCompras.add(scan.next());

            System.out.println("Digite o nome do produto: ");
            listaCompras.add(scan.next());

            System.out.println("Digite o preço do produto: ");
            double precoProduto = scan.nextDouble();

            String precoConvertido = Double.toString(precoProduto);
            listaCompras.add(precoConvertido);

            System.out.println("Digite a quantidade: ");
            int qtdeProduto = scan.nextInt();

            String qtdeProdutoConvertido = Integer.toString(qtdeProduto);
            listaCompras.add(qtdeProdutoConvertido);

            double vlTotal = precoProduto * qtdeProduto;
            String vlTotalConvertido = Double.toString(vlTotal);
            listaCompras.add(vlTotalConvertido);

            compraAssociada.put(verf, listaCompras);

        } else {
            System.out.println("Cpf inexistente em nosso sistema... Por favor, cadastre-se");
        }

    }

    public static void mostrarCompras() {

        System.out.println("Informe seu cpf");
        String verifc = scan.next();

        if (compraAssociada.containsKey(verifc)) {
            System.out.println("======COMPRAS REGISTRADAS======");
            for (String prod : listaCompras) {
                System.out.print(prod + "-");
            }
            System.out.println("--------------");

        } else {
            System.out.println("Cliente não possui compras registradas");
        }
    }
}
