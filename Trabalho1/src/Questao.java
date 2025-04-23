import Operacoes.Divisao;
import Operacoes.Multiplicacao;
import Operacoes.Soma;
import Operacoes.Subtracao;

import java.util.Scanner;

public class Questao{
    Scanner input = new Scanner(System.in);
    int opcao = 0;

    public void quiz(int nivel){
        do {
            System.out.println("Qual operação você deseja praticar?\n1 - Soma\n2 - Subtração\n3 - Multiplicação\n4 - Divisão\n5 - Sair");
            try{
                opcao = Integer.parseInt(input.nextLine());
            }catch (NumberFormatException e){
                System.out.println("A interação com o menu deve ser feita apenas através de números...");
                continue;
            }

            switch (opcao){
                case 1:
                    Soma soma = new Soma();
                    soma.calcular(nivel);
                    break;
                case 2:
                    Subtracao subtracao = new Subtracao();
                    subtracao.calcular(nivel);
                    break;
                case 3:
                    Multiplicacao multiplicacao = new Multiplicacao();
                    multiplicacao.calcular(nivel);
                    break;
                case 4:
                    Divisao divisao = new Divisao();
                    divisao.calcular(nivel);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default :
                    System.out.println("Opção inválida");
                    break;
            }
        }while (opcao !=5);
    }
}
