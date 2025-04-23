
public class Usuario {
    private String nome;
    private int nivelAtual;


    public Usuario(String nome){
        this.nome = nome;
        this.nivelAtual = 1;
    }
    public Usuario (String nome, int nivelAtual){
        this.nome = nome;
        this.nivelAtual = nivelAtual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNivelAtual() {
        return nivelAtual;
    }

    public void setNivelAtual(int nivelAtual) {
        this.nivelAtual = nivelAtual;
    }
}
