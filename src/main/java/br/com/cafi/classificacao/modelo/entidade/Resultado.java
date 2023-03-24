package br.com.cafi.classificacao.modelo.entidade;

public class Resultado {
    private String algoritmo;
    private double correto;

    public Resultado(String algoritmo, double correto) {
        this.algoritmo = algoritmo;
        this.correto = correto;
    }

    public String getAlgoritmo() {
        return algoritmo;
    }

    public void setAlgoritmo(String algoritmo) {
        this.algoritmo = algoritmo;
    }

    public double getCorreto() {
        return correto;
    }

    public void setCorreto(double correto) {
        this.correto = correto;
    }
    
    public String toString (){
        return algoritmo+" - "+correto;
    }
}
