package domain;

import util.BigDecimalFormatter;
import util.DateFormatterBR;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa {

    private String funcao;
    private BigDecimal salario;

    public Funcionario(String nome, LocalDate dataDeNascimento, String funcao, BigDecimal salario) {
        super(nome, dataDeNascimento);
        this.funcao = funcao;
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome = " + nome + '\'' +
                ", dataDeNascimento = " + DateFormatterBR.toDate(dataDeNascimento) +
                ", salario = " + BigDecimalFormatter.toFormat(salario) +
                ", função = " + funcao + '\'' +
                '}';
    }
}
