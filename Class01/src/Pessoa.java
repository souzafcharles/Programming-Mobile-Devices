public class Pessoa {
    private String cpf;
    private String nome;
    private int idade;
    private int matricula;

    public Pessoa(String cpf, String nome, int idade, int matricula) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = 0;
        this.matricula = 2;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}
