import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Empresa {
    private List<Funcionario> funcionarios = new ArrayList<>();

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void removerFuncionario(String nome) {
        funcionarios.removeIf(f -> f.getNome().equals(nome));
    }

    public void aumentoSalario(BigDecimal percentual) {
        funcionarios.forEach(f -> f.salario = f.getSalario().multiply(BigDecimal.ONE.add(percentual.divide(new BigDecimal("100")))));
    }

    public Map<String, List<Funcionario>> agruparPorFuncao() {
        return funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
    }

    public void imprimirAgrupadosPorFuncao() {
        Map<String, List<Funcionario>> agrupados = agruparPorFuncao();
        agrupados.forEach((funcao, lista) -> {
            System.out.println("Função: " + funcao);
            lista.forEach(f -> System.out.println(f));
        });
    }

    public void imprimirAniversariantes(List<Integer> meses) {
        funcionarios.stream()
                .filter(f -> meses.contains(f.getDataNascimento().getMonthValue()))
                .forEach(f -> System.out.println(f));
    }

    public void imprimirMaioresDeIdade() {
        LocalDate hoje = LocalDate.now();
        funcionarios.stream()
                .filter(f -> hoje.getYear() - f.getDataNascimento().getYear() >= 18)
                .forEach(f -> System.out.println(f));
    }

    public void imprimirEmOrdemAlfabetica() {
        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(f -> System.out.println(f));
    }

    public void imprimirTotalSalarios() {
        BigDecimal total = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total dos salários: " + total);
    }

    public void imprimirSalariosMinimos(BigDecimal salarioMinimo) {
        funcionarios.forEach(f -> {
            BigDecimal salariosMinimos = f.getSalario().divide(salarioMinimo, 2, BigDecimal.ROUND_HALF_UP);
            System.out.println(f.getNome() + " ganha " + salariosMinimos + " salários mínimos.");
        });
    }
}
