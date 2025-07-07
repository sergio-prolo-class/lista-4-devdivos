package ifsc.poo.naves;
import ifsc.poo.interfaces.Tripulada;

public class NaveMineradora extends NaveEspacial implements Tripulada {
    private final int energiaLaserMaxima;
    private int energiaLaserAtual;

    public NaveMineradora(int velocidadeMaxima, int energiaLaserMaxima) {
        super(velocidadeMaxima, 5);
        this.energiaLaserMaxima = energiaLaserMaxima;
        this.energiaLaserAtual = energiaLaserMaxima;
    }

    public String minerar(int custo) {
        if (this.velocidadeAtual >= (double) this.velocidadeMaxima * 0.1) {
            return getTagNave() + " mineração não permitida. Velocidade atual (" + this.velocidadeAtual + " Mm/h) muito alta.";
        }

        if (this.energiaLaserAtual <= custo) {
            return getTagNave() + " mineração não permitida. Energia do laser (" + this.energiaLaserAtual + ") insuficiente para o custo (" + custo + ").";
        }

        this.energiaLaserAtual -= custo;
        return getTagNave() + " mineração realizada com sucesso. Custo: " + custo + ". Energia restante: " + this.energiaLaserAtual + "/" + this.energiaLaserMaxima;
    }

    @Override
    public String ativarControleManual() {
        return getTagNave() + " controle manual ativado.";
    }
}