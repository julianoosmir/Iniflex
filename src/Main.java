import domain.Funcionario;
import service.FuncionarioService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Funcionario maria = new Funcionario("Maria", LocalDate.of(2000,10,18),
                "Operador", BigDecimal.valueOf(2009.44));

        Funcionario joao = new Funcionario("João", LocalDate.of(1990,5,12),
                "Operador", BigDecimal.valueOf(2248.38));

        Funcionario caio = new Funcionario("Caio", LocalDate.of(1961,5,2),
                "Coordenador", BigDecimal.valueOf(9836.14));

        Funcionario miguel = new Funcionario("Miguel", LocalDate.of(1988,10,14),
                "Diretor", BigDecimal.valueOf(19119.88));

        Funcionario alice = new Funcionario("Alice", LocalDate.of(1995,1,05),
                "Recepcionista", BigDecimal.valueOf(2234.68));

        Funcionario heitor = new Funcionario("Heitor", LocalDate.of(1999,11,19),
                "Operador", BigDecimal.valueOf(1582.72));

        Funcionario arthur = new Funcionario("Arthur", LocalDate.of(1993,3,31),
                "Operador", BigDecimal.valueOf(4071.84));

        Funcionario laura = new Funcionario("Laura", LocalDate.of(1994,7,8),
                "Gerente", BigDecimal.valueOf(3017.45));

        Funcionario heloisa = new Funcionario("Heloisa", LocalDate.of(2003,05,24),
                "Eletricista", BigDecimal.valueOf(1606.85));

        Funcionario helena = new Funcionario("Helena", LocalDate.of(1996,9,2),
                "Gerente", BigDecimal.valueOf(2799.93));


        List<Funcionario> funcionarios = Arrays.asList(maria,joao,caio,miguel,alice,heitor,arthur,laura,
                heloisa,helena);

        FuncionarioService funcionarioService = new FuncionarioService(funcionarios);

        funcionarioService.removerPorNome("João");
        funcionarioService.funcionarios.forEach(System.out::println);
        funcionarioService.aumentarSalario();
        System.out.println("_______________________________________");
        funcionarioService.funcionarios.forEach(System.out::println);

        var map = funcionarioService.agruparPorFuncao();
        System.out.println("_______________________________________");

        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
        System.out.println("_______________________________________");

        System.out.println(funcionarioService.funcionariosAniversariantes(10));
        System.out.println(funcionarioService.funcionariosAniversariantes(12));

        var funcionarioMaisVelho = funcionarioService.funcionarioMaisVelho();

        System.out.println(funcionarioMaisVelho.getNome() + " idade : "
                + (LocalDate.now().getYear() - funcionarioMaisVelho.getDataDeNascimento().getYear()));

        System.out.println(funcionarioService.getFuncionariosPorOrdemAlfabetica());

        System.out.println(funcionarioService.totalSalarial());

       var salarios =  funcionarioService.quantoSalariosGanhaCadaFuncinario();

       salarios.forEach(System.out::println);

    }
}