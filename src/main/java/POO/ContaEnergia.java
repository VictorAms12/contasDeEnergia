package POO;


import java.util.Objects;

public class ContaEnergia {
    private meses mesReferencia;
    private float leituraAnterior;
    private float leituraAtual;
    private static final float ICMS = 0.22f;
    private static final float tarifaKWH =0.92f;
    private static final float iluminacao = 0.025f ;

    public ContaEnergia(float leituraAtual, float leituraAnterior, meses mesReferencia) {
        if (mesReferencia == null) {
            throw new IllegalArgumentException("O mês não pode ser nulo.");
        }
        this.leituraAtual = leituraAtual;
        this.leituraAnterior = leituraAnterior;
        this.mesReferencia = mesReferencia;
    }
    public float calcularConsumo(){
        return leituraAtual - leituraAnterior;
    }
    public float calcularValorTotal(){
        float consumo = this.calcularConsumo();
        float valorBase = consumo * tarifaKWH;
        if (consumo < 90){
           return valorBase;
        }
        else {
            float valorIluminacao = valorBase * iluminacao;
            float valorICMS = (valorBase + valorIluminacao) * ICMS;
            return valorICMS + valorIluminacao + valorBase;
        }
    }
    public boolean isMaisCaraQue(ContaEnergia conta){
        return this.calcularValorTotal() > conta.calcularValorTotal();
    }
    public String gerarResumo(){
        return "-------------------\nMês:"+this.mesReferencia+"\nConsumo:"+this.calcularConsumo()+"KWH\nValor:R$"+this.calcularValorTotal()+"\n-------------------";
    }

    public meses getMesReferencia() {
        return mesReferencia;
    }

    public float getLeituraAtual() {
        return leituraAtual;
    }

    public float getLeituraAnterior() {
        return leituraAnterior;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContaEnergia that = (ContaEnergia) o;
        return mesReferencia == that.mesReferencia;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mesReferencia);
    }
}
