package empresa.com;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Empresa {
    public static double calcularTotalPago(List<Funcionario> funcionarios, int ano, int mes) {
        return funcionarios.stream()
                .mapToDouble(f -> f.calcularSalario(ano, mes) + f.calcularBeneficio(ano, mes))
                .sum();
    }

    public static double calcularTotalSalarios(List<Funcionario> funcionarios, int ano, int mes) {
        return funcionarios.stream()
                .mapToDouble(f -> f.calcularSalario(ano, mes))
                .sum();
    }

    public static double calcularTotalBeneficios(List<Funcionario> funcionarios, int ano, int mes) {
        return funcionarios.stream()
                .mapToDouble(f -> f.calcularBeneficio(ano, mes))
                .sum();
    }

    public static Funcionario encontrarFuncionarioComMaiorRecebimento(List<Funcionario> funcionarios, int ano, int mes) {
        return funcionarios.stream()
                .max((f1, f2) -> Double.compare(
                        f1.calcularSalario(ano, mes) + f1.calcularBeneficio(ano, mes),
                        f2.calcularSalario(ano, mes) + f2.calcularBeneficio(ano, mes)))
                .orElse(null);
    }

    public static Funcionario encontrarFuncionarioComMaiorBeneficio(List<Funcionario> funcionarios, int ano, int mes) {
        return funcionarios.stream()
                .max((f1, f2) -> Double.compare(f1.calcularBeneficio(ano, mes), f2.calcularBeneficio(ano, mes)))
                .orElse(null);
    }

    public static Vendedor encontrarVendedorComMaiorVenda(List<Vendedor> vendedores, int ano, int mes) {
        return vendedores.stream()
                .max((v1, v2) -> Double.compare(
                        v1.calcularBeneficio(ano, mes) / 0.30, // PERCENTUAL_BENEFICIO
                        v2.calcularBeneficio(ano, mes) / 0.30))
                .orElse(null);
    }

    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();
        List<Vendedor> vendedores = new ArrayList<>();

        // Definindo o formato do date


        Secretario jorge = new Secretario("Jorge Carvalho", LocalDate.parse("2018-01-01", DateTimeFormatter.ofPattern("yyyy-MM-dd").withLocale(Locale.ENGLISH)));
        Secretario maria = new Secretario("Maria Souza", LocalDate.parse("2015-12-01", DateTimeFormatter.ofPattern("yyyy-MM-dd").withLocale(Locale.ENGLISH)));
        Vendedor ana = new Vendedor("Ana Silva", LocalDate.parse("2021-12-01", DateTimeFormatter.ofPattern("yyyy-MM-dd").withLocale(Locale.ENGLISH)));
        ana.adicionarVenda(new RegistroVendas(12, 2021, 5200.00));
        ana.adicionarVenda(new RegistroVendas(1, 2022, 4000.00));
        ana.adicionarVenda(new RegistroVendas(2, 2022, 4200.00));
        ana.adicionarVenda(new RegistroVendas(3, 2022, 5850.00));
        ana.adicionarVenda(new RegistroVendas(4, 2022, 7000.00));
        Vendedor joao = new Vendedor("João Mendes", LocalDate.parse("2021-12-01", DateTimeFormatter.ofPattern("yyyy-MM-dd").withLocale(Locale.ENGLISH)));
        joao.adicionarVenda(new RegistroVendas(12, 2021, 3400.00));
        joao.adicionarVenda(new RegistroVendas(1, 2022, 7700.00));
        joao.adicionarVenda(new RegistroVendas(2, 2022, 5000.00));
        joao.adicionarVenda(new RegistroVendas(3, 2022, 5900.00));
        joao.adicionarVenda(new RegistroVendas(4, 2022, 6500.00));
        Gerente juliana = new Gerente("Juliana Alves", LocalDate.parse("2017-07-01", DateTimeFormatter.ofPattern("yyyy-MM-dd").withLocale(Locale.ENGLISH)));
        Gerente bento = new Gerente("Bento Albino", LocalDate.parse("2014-03-01", DateTimeFormatter.ofPattern("yyyy-MM-dd").withLocale(Locale.ENGLISH)));

        funcionarios.add(jorge);
        funcionarios.add(maria);
        funcionarios.add(ana);
        funcionarios.add(joao);
        funcionarios.add(juliana);
        funcionarios.add(bento);
        vendedores.add(ana);
        vendedores.add(joao);

        int ano = 2022;
        int mes = 4;

        System.out.println("Total pago no mês: " + calcularTotalPago(funcionarios, ano, mes));
        System.out.println("Total pago em salários no mês: " + calcularTotalSalarios(funcionarios, ano, mes));
        System.out.println("Total pago em benefícios no mês: " + calcularTotalBeneficios(funcionarios, ano, mes));
        System.out.println("Funcionário com maior recebimento no mês: " + encontrarFuncionarioComMaiorRecebimento(funcionarios, ano, mes).nome);
        System.out.println("Funcionário com maior benefício no mês: " + encontrarFuncionarioComMaiorBeneficio(funcionarios, ano, mes).nome);
        System.out.println("Vendedor com maior venda no mês: " + encontrarVendedorComMaiorVenda(vendedores, ano, mes).nome);
    }
}
