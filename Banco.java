import java.util.Scanner;

public class Banco {
    public static void main(String[] args) {
        Scanner lerOperacao = new Scanner(System.in);
        String nome = "Júlio César de O. Pimentel";
        String tipoDeConta = "Conta Corrente";
        double saldoAtual = 1782.85;
        boolean operacao = true;
        String dadosDoCliente;
        dadosDoCliente = """
                **************************************************************
                Dados iniciais do cliente:
                
                Nome:             %s
                Tipo de conta:    %s
                Saldo inicial:    R$ %.2f
                **************************************************************
                """.formatted(nome, tipoDeConta, saldoAtual);


        System.out.println(dadosDoCliente);


        while (operacao) {
            String menuDeOperacao;
            menuDeOperacao = """
                    1- Consultar saldo
                    2- Receber valor
                    3- Fazer retirada
                    4- Sair
                    """;

            System.out.println(menuDeOperacao);

            System.out.println("Digite a opção desejada:");
            int tipoDeOperacao = lerOperacao.nextInt();

            switch (tipoDeOperacao) {
                case 1 -> System.out.printf("Seu saldo é R$ %.2f%n\n", saldoAtual);
                case 2 -> {
                    System.out.println("Digite o valor que deseja depositar:");
                    double valorDepositado = lerOperacao.nextDouble();
                    saldoAtual += valorDepositado;
                    System.out.printf("Seu saldo é R$ %.2f%n\n", saldoAtual);
                }
                case 3 -> {
                    System.out.println("Digite o valor que deseja retirar:");
                    double valorRetirado = lerOperacao.nextDouble();
                    if (valorRetirado > saldoAtual) {
                        System.out.println("Seu saldo não é suficiente para esta retirada.\n");
                    } else {
                        saldoAtual -= valorRetirado;
                        System.out.printf("Seu saldo é R$ %.2f%n\n", saldoAtual);
                    }
                }
                case 4 -> operacao = false;
                default -> System.out.println("Operação inválida.\n");
            }
        }

        System.out.println("Obrigado por utilizar nossos serviços.");
    }
}
