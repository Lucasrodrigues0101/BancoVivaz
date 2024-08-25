package SistemaBancarioVivaz;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {

        Scanner leitorNome = new Scanner(System.in);
        Scanner leitorResposta = new Scanner(System.in);
        Scanner leitorValor = new Scanner(System.in);
        Scanner leitorFinal = new Scanner(System.in);
        Random random = new Random();
        double valorsaque;
        double valordeposito;
        int idcontaINT;
        int resposta;
        String respostaFinal = "S";

        System.out.println("Olá ! Seja bem vindo ao banco Vivaz !");

        ContaBancaria Conta1 = new ContaBancaria();
        System.out.println("Vamos criar sua conta bancaria !");
        System.out.println("NOME: ");
        Conta1.setNomeUser(leitorNome.nextLine());
        System.out.println("Criando seu id da sua nova Conta");
        idcontaINT = random.nextInt(1500);
        String.valueOf(idcontaINT);
        Conta1.setIdConta("ID" + Conta1.getNomeUser() + idcontaINT);
        System.out.println(Conta1.getIdConta());
        System.out.println("ID CONTA CRIADO");
        Conta1.setStatus(true);

        System.out.println("CONTA CRIADA COM SUCESSO ! ");

        Date dataAtual = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = formatter.format(dataAtual);
        Conta1.setDataCriacao(dataFormatada);



        while(!respostaFinal.equalsIgnoreCase("não")) {
            System.out.println("[1] - Sacar saldo bancario. ");
            System.out.println("[2] - Depositar saldo bancario. ");
            System.out.println("[3] - Mostrar informações da conta bancaria. ");
            System.out.println("[4] - Salvar conta ");
            System.out.println("Saldo atual: " + Conta1.getSaldo());

            resposta = leitorResposta.nextInt();
            if (resposta == 1) {
                System.out.println("Valor do saque: ");
                valorsaque = leitorValor.nextInt();
                Conta1.sacar(valorsaque);
            }

            if (resposta == 2) {
                System.out.println("Valor do depósito: ");
                valordeposito = leitorValor.nextInt();
                Conta1.depositar(valordeposito);
            }

            if (resposta == 3) {
                System.out.println("Mostrando informações da conta... ");
                Conta1.mostrarIformacoes();

            }

            if (resposta == 4){
                try {
                    FileWriter writer = new FileWriter("conta.txt");
                    writer.write(Conta1.toString()); // Converte o objeto para string e escreve no arquivo
                    writer.close();
                    System.out.println("Informações da conta salvas com sucesso!");
                } catch (IOException e) {
                    System.out.println("Ocorreu um erro ao salvar o arquivo.");
                    e.printStackTrace();
                }
            }


            System.out.println("Deseja continuar? ");
            respostaFinal = leitorFinal.nextLine();

        }
        System.out.println("Finalizado !");




    }
}

