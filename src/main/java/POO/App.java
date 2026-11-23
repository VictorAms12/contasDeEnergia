package POO;

public class App {
    public static void main(String[] args) {
        Imovel imovel1 = new Imovel(1,2026);
        ContaEnergia conta1 = new ContaEnergia(250,200,meses.JANEIRO);
        ContaEnergia conta2 = new ContaEnergia(260,190,meses.FEVEREIRO);
        ContaEnergia conta3 = new ContaEnergia(270,210,meses.MARCO);
        ContaEnergia conta4 = new ContaEnergia(250,180,meses.ABRIL);
        ContaEnergia conta5 = new ContaEnergia(250,170,meses.MAIO);
        ContaEnergia conta6 = new ContaEnergia(280,230,meses.JUNHO);
        ContaEnergia conta7 = new ContaEnergia(280,220,meses.JULHO);
        ContaEnergia conta8 = new ContaEnergia(245,285,meses.AGOSTO);
        ContaEnergia conta9 = new ContaEnergia(270,210,meses.SETEMBRO);
        ContaEnergia conta10 = new ContaEnergia(250,170,meses.OUTUBRO);
        ContaEnergia conta11 = new ContaEnergia(230,180,meses.NOVEMBRO);
        ContaEnergia conta12 = new ContaEnergia(300,230,meses.DEZEMBRO);
        imovel1.adicionarConta(conta1);
        imovel1.adicionarConta(conta2);
        imovel1.adicionarConta(conta3);
        imovel1.adicionarConta(conta4);
        imovel1.adicionarConta(conta5);
        imovel1.adicionarConta(conta6);
        imovel1.adicionarConta(conta7);
        imovel1.adicionarConta(conta8);
        imovel1.adicionarConta(conta9);
        imovel1.adicionarConta(conta10);
        imovel1.adicionarConta(conta11);
        imovel1.adicionarConta(conta12);
        imovel1.gerarRelatorio();
        IO.println("VALOR MÉDIO: R$"+imovel1.calcularMedia());
        imovel1.gerarResumoAcimaMedia();





    }
}
