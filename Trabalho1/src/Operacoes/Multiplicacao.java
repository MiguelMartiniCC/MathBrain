package Operacoes;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Multiplicacao extends OperacaoMatematica implements Desafio{
    Scanner input = new Scanner(System.in);

    //metodo avalia o lvl do usuário e passa o jogador para a sua dificuldade correspondente
    public void calcular(int nivel){
        if(nivel >= 1 && nivel <5){
            calcularLvl1();
        }else{
            calcularLvl5();
        }
        gerarDesafio();
    }

    @Override
    public void calcularLvl1() {
        System.out.println("nivel 1");
        int acertos = 0;

        for(int i = 1; i <= 5; i++){

            double a = (Math.round(Math.random() * 100));
            double b = (Math.round(Math.random() * 100));
            System.out.println(i +" - " + a + " " + getSimbolo() + " " + b);
            int resposta;
//            caso a resposta digitada seja diferente de um número
            try{
                resposta = Integer.parseInt(input.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Apenas números...");
                continue;
            }

            if(resposta == (a * b)){
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
            double a = (Math.random() * 102);
            double b = (Math.random() * 102);

            System.out.println(i +" - " + formatar.format(a) + " " + getSimbolo() + " " + formatar.format(b));

//            caso a resposta digitada seja diferente de um número
            try{
                resposta = Double.parseDouble(input.nextLine()); //resposta usuário
            }catch (NumberFormatException e){
                System.out.println("Apenas números...");
                continue;
            }

            double resultado = Math.round((a * b) * 100.0) / 100.0; // resposta conta

            if(Math.abs(resposta - resultado) < 0.01){
                System.out.println("Você acertou");
                acertos++;
            }else{
                System.out.println("Você errou");
                System.out.println(resultado);
            }

        }
        if(acertos > 3){
            System.out.println("Boa! Sua pontuação foi de " + acertos + " pontos");
        }else{
            System.out.println("Você deve revisar o conteúdo");
        }
    }

    @Override
    public String getSimbolo() {
        return "*";
    }

    @Override
    public void gerarDesafio() {
        DecimalFormat formatar = new DecimalFormat("#" );
        double a = (Math.round(Math.random() * 100));
        double b = (Math.round(Math.random() * 100));
        double x = (Math.round(Math.random() * 10));

        System.out.println("Você aceita o desafio? 1-Sim | 0-Não");
        int challenge = Integer.parseInt(input.nextLine());

        if(challenge == 1){
            System.out.println("Resolva: (("+ formatar.format(a) +".x) * (" + formatar.format(b) + ".x))/2 \nLembrando que x = " + x);
            double resolucao = ((a*x)*(b*x))/2;
            double resposta = Double.parseDouble(input.nextLine());
            if(resposta == resolucao){
                System.out.println("Você é o mestre dos magos!");
            }else{
                System.out.println("Não foi dessa vez, a resposta correta é: " + resolucao+ " e sua resposta foi "+ resposta);
            }
        }
    }
}
