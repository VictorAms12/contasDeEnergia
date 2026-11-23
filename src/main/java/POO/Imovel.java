package POO;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Imovel {
    private int id;
    private int ano;
    private final List<ContaEnergia> listaConta = new ArrayList<>(12);
    public Imovel(int id, int ano) {
        this.id = id;
        this.ano = ano;
    }
    public boolean adicionarConta(ContaEnergia novaConta) {
        if (novaConta == null) {
            return false;
        }
        if (listaConta.contains(novaConta)) {
            throw new IllegalArgumentException("Já existe uma conta cadastrada para o mês de " + novaConta.getMesReferencia());
        }

        if (listaConta.size() >= 12) {
            throw new IllegalStateException("O histórico anual já possui os 12 meses cadastrados.");
        }
        return listaConta.add(novaConta);
    }
        public List<ContaEnergia> getContas() {
            return Collections.unmodifiableList(listaConta);
        }
        public float calcularMedia(){
        float soma = 0;
        for(ContaEnergia c :listaConta){
            float valorConta = c.calcularValorTotal();
            soma +=valorConta;
        }
        return soma/12;
        }

        public void gerarRelatorio(){
            IO.println("RELATÓRIO ANUAL:");
        for(ContaEnergia c : listaConta){
            IO.println(c.gerarResumo());
        }
        }
    public void gerarResumoAcimaMedia(){
        IO.println("--------------------------------------\nRELATÓRIO DE CONTAS ACIMA DA MÉDIA:\n--------------------------------------");
        for(ContaEnergia c : listaConta) {
            if (c.calcularValorTotal() > this.calcularMedia())
                IO.println(c.gerarResumo());
        }

        }
    }




