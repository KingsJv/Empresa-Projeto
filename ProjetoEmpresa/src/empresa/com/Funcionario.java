package empresa.com;
import java.time.LocalDate;

public abstract class Funcionario {
    String nome;
    LocalDate dataContratacao;

    public Funcionario(String nome, LocalDate dataContratacao) {
        this.nome = nome;
        this.dataContratacao = dataContratacao;
    }

    abstract double calcularSalario(int ano, int mes);
    abstract double calcularBeneficio(int ano, int mes);
}