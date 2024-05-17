package empresa.com;
import java.time.YearMonth;
import java.time.LocalDate;
public class Secretario extends Funcionario {
    private static final double SALARIO_BASE = 7000.00;
    private static final double BONUS_ANUAL = 1000.00;
    private static final double PERCENTUAL_BENEFICIO = 0.20;

    public Secretario(String nome, LocalDate dataContratacao) {
        super(nome, dataContratacao);
    }

    @Override
    double calcularSalario(int ano, int mes) {
        int anosDeServico = YearMonth.of(ano, mes).getYear() - dataContratacao.getYear();
        return SALARIO_BASE + anosDeServico * BONUS_ANUAL;
    }

    @Override
    double calcularBeneficio(int ano, int mes) {
        return calcularSalario(ano, mes) * PERCENTUAL_BENEFICIO;
    }
}