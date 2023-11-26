package dao;

public class DadosTime {
    private int partidas;
    private int golsMarcados;
    private int golsSofridos;
    private int vitorias;
    private int derrotas;
    private int empates;
    private int saldoGols;

    public DadosTime(String nomeTime) {
        this.partidas = 0;
        this.golsMarcados = 0;
        this.golsSofridos = 0;
        this.vitorias = 0;
        this.derrotas = 0;
        this.empates = 0;
        this.saldoGols = 0;
    }

    public int getPartidas() {
        return partidas;
    }

    public void setPartidas(int partidas) {
        this.partidas = partidas;
    }

    public int getGolsMarcados() {
        return golsMarcados;
    }

    public void setGolsMarcados(int golsMarcados) {
        this.golsMarcados = golsMarcados;
    }

    public int getGolsSofridos() {
        return golsSofridos;
    }

    public void setGolsSofridos(int golsSofridos) {
        this.golsSofridos = golsSofridos;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public int getSaldoGols() {
        return saldoGols;
    }

    public void setSaldoGols(int saldoGols) {
        this.saldoGols = saldoGols;
    }
}
