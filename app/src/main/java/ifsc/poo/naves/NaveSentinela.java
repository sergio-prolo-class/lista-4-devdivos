package ifsc.poo.naves;

import ifsc.poo.interfaces.Autonoma;

public class NaveSentinela extends NaveEspacial implements Autonoma {
    private boolean radarAtivo;

    public NaveSentinela(int velocidadeMaxima) {
        super(velocidadeMaxima, 0);
        this.radarAtivo = false;
    }

    public String ativarRadar() {
        if (this.velocidadeAtual > (double) this.velocidadeMaxima * 0.9) {
            return getTagNave() + " não é possível ativar o radar em alta velocidade (" + this.velocidadeAtual + " Mm/h).";
        }

        this.radarAtivo = true;
        return getTagNave() + " radar ativado. Varrendo o setor.";
    }

    @Override
    public String ativarControleAutomatico() {
        return getTagNave() + " controle automático ativado.";
    }
}