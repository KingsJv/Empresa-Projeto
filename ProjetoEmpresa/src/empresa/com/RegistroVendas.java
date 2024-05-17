package empresa.com;

public class RegistroVendas {
    private int mes;
    private int ano;
    private double valor;

    public RegistroVendas(int mes, int ano, double valor) {
        this.mes = mes;
        this.ano = ano;
        this.valor = valor;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public double getValor() {
        return valor;
    }
}
