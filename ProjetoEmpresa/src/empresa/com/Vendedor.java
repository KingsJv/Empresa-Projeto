package empresa.com;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Funcionario {
    private static final double SALARIO_BASE = 12000.00;
    private static final double BONUS_ANUAL = 1800.00;
    private static final double PERCENTUAL_BENEFICIO = 0.30;
    private List<RegistroVendas> vendas;

    public Vendedor(String nome, LocalDate dataContratacao) {
        super(nome, dataContratacao);
        vendas = new ArrayList<>();
    }

    public void adicionarVenda(RegistroVendas venda) {
        vendas.add(venda);
    }

    @Override
    double calcularSalario(int ano, int mes) {
        int anosDeServico = YearMonth.of(ano, mes).getYear() - dataContratacao.getYear();
        return SALARIO_BASE + anosDeServico * BONUS_ANUAL;
    }

    @Override
    double calcularBeneficio(int ano, int mes) {
        double totalVendas = vendas.stream()
                .filter(v -> v.getAno() == ano && v.getMes() == mes)
                .mapToDouble(RegistroVendas::getValor)
                .sum();
        return totalVendas * PERCENTUAL_BENEFICIO;
    }
}
