package Operacoes;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Divisao extends OperacaoMatematica{
    Scanner input = new Scanner(System.in);
//metodo avalia o lvl do usuário e passa o jogador para a sua dificuldade correspondente
    public void calcular(int nivel){
        if(nivel >= 1 && nivel <5){
            calcularLvl1();
        }else{
            calcularLvl5();
        }
    }

    @Override
    public void calcularLvl1() {
        int resposta;
        System.out.println("nivel 1");
        int acertos = 0;

        for(int i = 1; i <= 5; i++){
            double b = (Math.round(Math.random() * 9)+1); //gera um valor de 0 a 9
            int multiplicador = (int)(Math.round(Math.random() * 10)); //gera um valor inteiro de 0/10
            double a = b * multiplicador;

            System.out.println(i +" - " + a + " " + getSimbolo() + " " + b);
            try{
                resposta = Integer.parseInt(input.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Apenas números...");
                continue;
            }


            if(resposta == (a / b)){
                System.out.println("Você acertou");
                acertos++;
            }else{
                System.out.println("Você errou");
            }
        }
        if(acertos > 3){
            System.out.println("Boa! Sua pontuação foi de " + acertos + " pontos");
        }else{
            System.out.println("Você deve revisar o conteúdo");
        }
    }

    @Override
    public void calcularLvl5() {
        DecimalFormat formatar = new DecimalFormat("#.00" );
        System.out.println("nivel 5");

        int acertos = 0;

        for(int i = 1; i <= 5; i++){
            double resposta;
            double b = (Math.round(Math.random() * 11)+1);
            int multiplicador = (int)(Math.round(Math.random() * 20));
            double a = b * multiplicador;

            System.out.println(i +" - " + formatar.format(a) + " " + getSimbolo() + " " + formatar.format(b));

            try{
                resposta = Double.parseDouble(input.nextLine()); //resposta usuário
            }catch (NumberFormatException e){
                System.out.println("Apenas números...");
                continue;
            }

            if(resposta == (a/b)){
                System.out.println("Você acertou");
                acertos++;
            }else{
                System.out.println("Você errou");
                System.out.println(a/b);
            }

        }
        if(acertos > 3){
            System.out.println("Boa! Sua pontuação foi de " + acertos + " pontos");
        }else{
            System.out.println("Você deve revisar o conteúdo");
        };
    }

    @Override
    public String getSimbolo() {
        return "/";
    }
}
