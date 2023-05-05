package br.com.cafi.classificacao.modelo.entidade;

public class Relatorio {
    public String classifacacao;
    public double porcentagemClassificacao;
    public String identificador;

    public Relatorio(String classifacacao, double porcentagemClassificacao, String identificador) {
        this.classifacacao = classifacacao;
        this.porcentagemClassificacao = porcentagemClassificacao;
        this.identificador = identificador;
    }

    public String getClassifacacao() {
        return classifacacao;
    }

    public void setClassifacacao(String classifacacao) {
        this.classifacacao = classifacacao;
    }

    public double getPorcentagemClassificacao() {
        return porcentagemClassificacao;
    }

    public void setPorcentagemClassificacao(double porcentagemClassificacao) {
        this.porcentagemClassificacao = porcentagemClassificacao;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    
    
}
