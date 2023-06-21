package Desafio02_SistemaDeVendas;

import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.*;

public class Vendedor {
    public static Scanner scan = new Scanner(System.in);
    public static Map<String, String> vendedores = new HashMap<>();
    public static Map<String, List<String>> vendaAssociada = new HashMap<>();
    public static List<String> listaVendas = new ArrayList<>();

    public static Map<String, String> login = new HashMap<>();
    static String senhaCrip, senha, cpf, email;

    public static void criarVendedores() {
        vendedores.put("mariaGostaria@gmail.com", "56747607058"); //novo vendedor
        vendedores.put("joseBale@gmail.com", "21618829882"); //novo vendedor3
        vendedores.put("lanaBanana@gmail.com", "31315827892"); //novo vendedor
    }

    public static void cadastrarVendedor() {

        System.out.println("Informe seu cpf: ");
         cpf = scan.next();

        while (cpf.contains(".") || cpf.contains("-") || cpf.length() < 11) {
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


        while (vendedores.containsKey(email) || vendedores.containsValue(cpf)) {
            System.out.println("Não foi possível realizar o cadastro, pois o vendedor já está em nosso sistema. Tente novamente\n");

            System.out.println("Informe seu cpf: ");
            cpf = scan.next();

            System.out.println("Informe seu email: ");
            email = scan.next();
        }

        vendedores.put(email, cpf);
        login.put(email, senhaCrip);
        System.out.println("Vendedor cadastrado com sucesso!");

    }

    public static void mostrarVendedores() {

        for (Map.Entry<String, String> entry : vendedores.entrySet()) {
            System.out.println("EMAIL: " + entry.getKey() + ", CPF: " + entry.getValue());
        } // mostrar vendedores existentes

    }

    public static void loginVendedor(){

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
    public static void registrarVenda() {

        System.out.println("Informe seu Email: ");
        String verf = scan.next();

        if (vendedores.containsKey(verf)) {
            System.out.println("Digite o código do produto: ");
            listaVendas.add(scan.next());

            System.out.println("Digite o nome do produto: ");
            listaVendas.add(scan.next());

            System.out.println("Digite o preço do produto: ");
            double precoProduto = scan.nextDouble();

            String precoConvertido = Double.toString(precoProduto);
            listaVendas.add(precoConvertido);

            System.out.println("Digite a quantidade: ");
            int qtdeProduto = scan.nextInt();

            String qtdeProdutoConvertido = Integer.toString(qtdeProduto);
            listaVendas.add(qtdeProdutoConvertido);

            double vlTotal = precoProduto * qtdeProduto;
            String vlTotalConvertido = Double.toString(vlTotal);
            listaVendas.add(vlTotalConvertido);

            System.out.println("O valor total é " + (precoProduto * qtdeProduto));

            System.out.println("Venda registrada com sucesso! ");

            vendaAssociada.put(verf, listaVendas);

        } else {
            System.out.println("Email inexistente em nosso sistema... Por favor, cadastre-se");
        }


    }

    public static void mostrarVendas() {

        System.out.println("Informe seu Email");
        String verifc = scan.next();

        if (vendaAssociada.containsKey(verifc)) {

            System.out.println("======VENDAS REGISTRADAS======");
            for (String prod : listaVendas) {
                System.out.print(prod + "\n");
            }
            System.out.println("--------------");
        } else {
            System.out.println("Vendedor não possui vendas registradas");
        }
    }
}

