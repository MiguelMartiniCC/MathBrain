import java.util.ArrayList;
import java.util.Scanner;

public class JogoMatematica{

    ArrayList<Usuario> usuarios = new ArrayList<>();// usuarios
    Scanner input = new Scanner(System.in);

    public void menuPrincipal() {
        int opcao = 0;

        Usuario teste1 = new Usuario("Miguel", 1); //usuario de teste lvl1
        Usuario teste5 = new Usuario("Carol", 5); //usuario de teste lvl5

        usuarios.add(teste1);
        usuarios.add(teste5);

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Adicionar usuário");
            System.out.println("2 - Iniciar quiz");
            System.out.println("3 - Mostrar usuários");
            System.out.println("4 - Sair");
            try{
                opcao = Integer.parseInt(input.nextLine());
            }catch (NumberFormatException e){
                System.out.println("A interação com o menu deve ser feita apenas através de números...");
                continue;
            }

            switch (opcao) {
                case 1:
                    adicionarUsuario();
                    break;
                case 2:
                    iniciarQuiz();
                    break;
                case 3:
                    for (Usuario u : usuarios) {
                        System.out.println("Nome: " + u.getNome() + " | Nível: " + u.getNivelAtual());
                    }
                    break;
                case 4:
                    System.out.println("Saindo do jogo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 4);
    }

    public void adicionarUsuario() {
        System.out.println("Digite o nome do usuário:");

        String nome = input.nextLine();
        Usuario usuario = new Usuario(nome);
        usuarios.add(usuario);

        System.out.println("Usuário adicionado com sucesso!");
    }

    public void iniciarQuiz() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado!");
            return;// para a execução
        }

        System.out.println("Escolha um usuário para jogar:");
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println(i + " - " + usuarios.get(i).getNome());
        }

        int escolha = Integer.parseInt(input.nextLine());
        Usuario usuarioAtual = usuarios.get(escolha); //pega o elemento da lista

        System.out.println("Iniciando o quiz para " + usuarioAtual.getNome() + " no nível " + usuarioAtual.getNivelAtual());
//inicia de fato o jogo
        Questao questao = new Questao();
        questao.quiz(usuarioAtual.getNivelAtual());
    }
}
