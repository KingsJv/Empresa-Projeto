package empresa.com;
import java.time.LocalDate;
import java.time.YearMonth;

public class Gerente extends Funcionario {
    private static final double SALARIO_BASE = 20000.00;
    private static final double BONUS_ANUAL = 3000.00;

    public Gerente(String nome, LocalDate dataContratacao) {
        super(nome, dataContratacao);
    }

    @Override
    double calcularSalario(int ano, int mes) {
        int anosDeServico = YearMonth.of(ano, mes).getYear() - dataContratacao.getYear();
        return SALARIO_BASE + anosDeServico * BONUS_ANUAL;
    }

    @Override
    double calcularBeneficio(int ano, int mes) {
        return 0.0; // Gerente não recebe benefício
    }
}