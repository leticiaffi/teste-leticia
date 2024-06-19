import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

public class Principal {

    public static void main(String[] args) {
        Empresa empresa = new Empresa();

        // Adicionar funcionários
        empresa.adicionarFuncionario(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        empresa.adicionarFuncionario(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        empresa.adicionarFuncionario(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        empresa.adicionarFuncionario(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        empresa.adicionarFuncionario(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        empresa.adicionarFuncionario(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        empresa.adicionarFuncionario(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        empresa.adicionarFuncionario(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        empresa.adicionarFuncionario(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        empresa.adicionarFuncionario(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        // Remover funcionário "João" da lista
        empresa.removerFuncionario("João");

        // Imprimir todos os funcionários com todas suas informações
        empresa.imprimirAgrupadosPorFuncao();

        // Aumentar salários dos funcionários em 10%, e atualizar a lista com novo valor
        empresa.aumentoSalario(new BigDecimal("10"));

        // Agrupar e imprimir funcionários por função
        empresa.imprimirAgrupadosPorFuncao();

        // Imprimir aniversariantes dos meses 10 e 12
        empresa.imprimirAniversariantes(Arrays.asList(10, 12));

        // Imprimir maiores de idade, com nome e idade
        empresa.imprimirMaioresDeIdade();

        // Imprimir em ordem alfabética
        empresa.imprimirEmOrdemAlfabetica();

        // Imprimir total dos salários dos funcionários
        empresa.imprimirTotalSalarios();

        // Imprimir quantos salários mínimos ganha cada funcionário
        empresa.imprimirSalariosMinimos(new BigDecimal("1212.00"));
    }
}
