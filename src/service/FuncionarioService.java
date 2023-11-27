package service;

import domain.Funcionario;
import domain.Pessoa;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;

public class FuncionarioService {

    public List<Funcionario> funcionarios = new ArrayList<>();

    public FuncionarioService(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void inserir(Funcionario funcionario){
        this.funcionarios.add(funcionario);
    }
    public void removerPorNome(String nome){
        this.funcionarios = this.funcionarios.stream()
                .filter(f-> !f.getNome().equals(nome)).collect(Collectors.toList());
    }

    public void aumentarSalario(){
        this.funcionarios.forEach(funcionario -> {
            funcionario.setSalario(funcionario.getSalario().multiply(new BigDecimal(1.1)));
        });
    }
    public Map<String, List<Funcionario>> agruparPorFuncao(){
        return this.funcionarios.stream().collect(groupingBy(Funcionario::getFuncao));
    }
    public List<Funcionario> funcionariosAniversariantes(int mes){
        return this.funcionarios.stream().filter(funcionario -> {
            return funcionario.getDataDeNascimento().getMonthValue() == mes;
        }).collect(Collectors.toList());
    }
    public Funcionario funcionarioMaisVelho(){
        return this.funcionarios.stream()
                .min(comparing(Funcionario::getDataDeNascimento))
                .orElse(null);
    }
    public BigDecimal totalSalarial(){
        return this.funcionarios.stream()
                .map(funcionario -> funcionario.getSalario())
                .reduce(BigDecimal.ZERO,BigDecimal::add);
    }
    public List<String> quantoSalariosGanhaCadaFuncinario(){
        List<String> salarios = new ArrayList<>();
        this.funcionarios.forEach(funcionario -> {
            var sal = funcionario.getSalario().toBigInteger();
            var qtd = sal.divide(BigInteger.valueOf(1212));
            salarios.add("funcionario " + funcionario.getNome() + " ganha " + qtd.toString());
        });
        return salarios;
    }

    public List<Funcionario> getFuncionariosPorOrdemAlfabetica() {
        return funcionarios.stream().sorted(Comparator.comparing(Pessoa::getNome)).collect(Collectors.toList());
    }
}
