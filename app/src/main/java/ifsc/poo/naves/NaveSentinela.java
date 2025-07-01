package ifsc.poo.naves;

import ifsc.poo.interfaces.Autonoma;

public class NaveSentinela extends NaveEspacial implements Autonoma {
    private boolean radarAtivo;

    public NaveSentinela(int velocidadeMaxima, int tripulacaoMax) {
        super(velocidadeMaxima, tripulacaoMax);
        this.radarAtivo = false;
    }

    public String ativarRadar() {
        if (velocidadeAtual <= 0.9 * velocidadeMaxima) {
            radarAtivo = true;
            return getTagNave() + " radar ativado.";
        }
        return getTagNave() + " não é possível ativar o radar em alta velocidade.";
    }

    public String desativarRadar() {
        radarAtivo = false;
        return getTagNave() + " radar desativado.";
    }

    @Override
    public String ativarControleAutomatico() {
        return getTagNave() + " controle automático ativado.";
    }
}