package exemplo;

public class Empregado {
    private String nome;
    private String departmento;
    private int idade;

    public Empregado(String nome, String departmento, int age) {
        this.nome = nome;
        this.departmento = departmento;
        this.idade = age;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepartmento() {
        return departmento;
    }

    public void setDepartmento(String departmento) {
        this.departmento = departmento;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}