package ifsc.poo.naves;

import ifsc.poo.interfaces.Autonoma;

public class NaveSentinela extends NaveEspacial implements Autonoma {
    private boolean radarAtivo;

    public NaveSentinela(int velocidadeMaxima) {
        super(ajustarVelocidade(velocidadeMaxima), 0);
        this.radarAtivo = false;
    }

    private static int ajustarVelocidade(int v) {
        int velocidadeAjustada = Math.max(10, v); // Garante mínimo de 10
        velocidadeAjustada = Math.min(20, velocidadeAjustada); // Garante máximo de 20
        if (velocidadeAjustada != v) {
            System.out.println("Velocidade para NaveSentinela ajustada para " + velocidadeAjustada + " (limite é 10-20).");
        }
        return velocidadeAjustada;
    }

    public String ativarRadar() {
        if (this.velocidadeAtual > (double) this.velocidadeMaxima * 0.9) {
            return getTagNave() + " não é possível ativar o radar em alta velocidade (" + this.velocidadeAtual + " Mm/h).";
        }

        this.radarAtivo = true;
        return getTagNave() + " radar ativado. Varrendo o setor.";
    }

    public String desativarRadar() {
        this.radarAtivo = false;
        return getTagNave() + " radar desativado.";
    }

    @Override
    public String ativarControleAutomatico() {
        return getTagNave() + " controle automático ativado.";
    }
}