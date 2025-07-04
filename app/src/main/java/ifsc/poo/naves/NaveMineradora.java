package ifsc.poo.naves;
import ifsc.poo.interfaces.Tripulada;

public class NaveMineradora extends NaveEspacial implements Tripulada {
    private final int energiaLaserMaxima;
    private int energiaLaserAtual;

    public NaveMineradora(int velocidadeMaxima, int energiaLaserMaxima) {
        super(ajustarVelocidade(velocidadeMaxima), 5);
        this.energiaLaserMaxima = energiaLaserMaxima;
        this.energiaLaserAtual = energiaLaserMaxima;
    }

    private static int ajustarVelocidade(int v) {
        int velocidadeAjustada = Math.max(12, v); // Garante mínimo de 12
        velocidadeAjustada = Math.min(20, velocidadeAjustada); // Garante máximo de 20
        if (velocidadeAjustada != v) {
            System.out.println("Velocidade para NaveMineradora ajustada para " + velocidadeAjustada + " (limite é 12-20).");
        }
        return velocidadeAjustada;
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