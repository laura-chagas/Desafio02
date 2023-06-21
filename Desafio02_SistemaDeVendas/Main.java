package Desafio02_SistemaDeVendas;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int MySystem = 1;

        while (MySystem == 1) {
            System.out.println("==================VOCÊ É================== \n[1] CLIENTE" + "     " + "[2] VENDEDOR" + "     " + "[3] QUERO SAIR");
            switch (scan.nextInt()) {
                case 1 -> {
                    System.out.println("================VOCÊ DESEJA================ \n[1] CADASTRAR VENDA" + "     " + "[2] CADASTRAR-SE\n" + "[3] MOSTRAR COMPRAS" + "     " + "[4] MOSTRAR CLIENTES EXISTENTES\n" + "[5] FAZER LOGIN" + "         " + "[6] SAIR");
                    switch (scan.nextInt()) {
                        case 1:
                            Cliente.criarCliente();
                            Cliente.Comprar();
                            break;
                        case 2:
                            Cliente.criarCliente();
                            Cliente.cadastrarCliente();
                            break;
                        case 3:
                            Cliente.criarCliente();
                            Cliente.mostrarCompras();
                            break;
                        case 4:
                            Cliente.criarCliente();
                            Cliente.mostrarClientes();
                            break;
                        case 5:
                            Cliente.loginCliente();
                            break;
                        case 6:
                            System.out.print("Encerrando sistema...");
                            System.exit(0);
                    }
                }
                case 2 -> {
                    System.out.println("==================VOCÊ DESEJA================== \n[1] CADASTRAR VENDA" + "     " + "[2] CADASTRAR-SE\n" + "[3] MOSTRAR VENDAS" + "      " + "[4] MOSTRAR CLIENTES EXISTENTES\n" + "[5] FAZER LOGIN" + "         " + "[6] SAIR");
                    switch (scan.nextInt()) {
                        case 1:
                            Vendedor.criarVendedores();
                            Vendedor.registrarVenda();
                            break;
                        case 2:
                            Vendedor.criarVendedores();
                            Vendedor.cadastrarVendedor();
                            break;
                        case 3:
                            Vendedor.criarVendedores();
                            Vendedor.mostrarVendas();
                            break;
                        case 4:
                            Vendedor.criarVendedores();
                            Vendedor.mostrarVendedores();
                            break;
                        case 5:
                            Vendedor.loginVendedor();
                            break;
                        case 6:
                            System.out.print("Encerrando sistema...");
                            System.exit(0);
                    }
                }
                case 3 -> {
                    System.out.print("Encerrando sistema...");
                    System.exit(0);
                }
            }
            System.out.println("\nDeseja realizar outra operação? \n[1] SIM" + "     " + "[2] NÃO");
            switch (scan.nextInt()) {
                case 1:
                    MySystem = 1;
                    break;
                case 2:
                    System.out.print("Encerrando sistema...");
                    MySystem++;
            }

        }

    }

}
