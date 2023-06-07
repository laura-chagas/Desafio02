package Desafio02_SistemaDeVendas;


import java.util.*;
public class Cliente{
    public static Scanner scan = new Scanner(System.in);
    public static Map<String, String> clientes = new HashMap<>();
    public static Map<String, List<String>> compraAssociada = new HashMap<>();
    public static List<String> listaCompras = new ArrayList<>();

    public static void criarCliente() {
        clientes.put("73685377027", "anaLeviana@gmail.com"); //novo cliente
        clientes.put("13546190050", "marceloMartelo@gmail.com"); //novo cliente
    }

    public static void cadastrarCliente() {

        criarCliente();

        System.out.println("Informe seu cpf: ");
        String cpf = scan.next();

        while(cpf.contains(".") || cpf.contains("-") || cpf.length() < 11){
            System.out.println("CPF inválido, digite novamente os 11 dígitos, sem [.] e sem [-]");

            System.out.println("Informe seu cpf: ");
             cpf = scan.next();
        }

        System.out.println("Informe seu email: ");
        String email = scan.next();

        while (!(email.contains("@"))) {
            System.out.println("Email inválido, tente novamente com @ ");

            System.out.println("Informe seu email: ");
            email = scan.next();

        }

        while (clientes.containsKey(cpf) || clientes.containsValue(email)) {
            System.out.println("Não foi possível realizar o cadastro, pois o Cliente já está em nosso sistema. Tente novamente\n");

            System.out.println("Informe seu cpf: ");
            cpf = scan.next();

            System.out.println("Informe seu email: ");
            email = scan.next();
        }

        clientes.put(cpf, email);
        System.out.println("Cliente cadastrado com sucesso!");

    }

    public static void mostrarClientes() {

        for (Map.Entry<String, String> entry : clientes.entrySet()) {
            System.out.println("CPF: " + entry.getKey() + ", EMAIL: " + entry.getValue());
        } // mostrar clientes existentes

    }


    public static void Comprar() {

        criarCliente();


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
