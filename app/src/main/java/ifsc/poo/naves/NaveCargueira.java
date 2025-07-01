package ifsc.poo.naves;

import ifsc.poo.interfaces.Autonoma;
import ifsc.poo.interfaces.Blindada;

public class NaveCargueira extends NaveEspacial implements Blindada, Autonoma {
    private int cargaMaxima;
    private int cargaAtual;
    private boolean blindagemAtiva;

    public NaveCargueira(int velocidadeMaxima, int tripulacaoMax, int cargaMaxima) {
        super(velocidadeMaxima, tripulacaoMax);
        this.cargaMaxima = cargaMaxima;
        this.cargaAtual = 0;
        this.blindagemAtiva = false;
    }

    public String carregar(int carga) {
        if (cargaAtual + carga > cargaMaxima) {
            return getTagNave() + " não é possível carregar além da carga máxima.";
        }
        cargaAtual += carga;

        if (cargaAtual > 0.7 * cargaMaxima) {
            blindagemAtiva = true;
            return getTagNave() + " carga atual: " + cargaAtual + " - blindagem ativada.";
        }

        return getTagNave() + " carga atual: " + cargaAtual;
    }

    public String ativarBlindagem() {
        if (cargaAtual > 0.7 * cargaMaxima) {
            blindagemAtiva = true;
            return getTagNave() + " blindagem ativada.";
        }
        return getTagNave() + " blindagem não ativada (carga abaixo de 70%).";
    }

    public String desativarBlindagem() {
        if (velocidadeAtual == 0) {
            blindagemAtiva = false;
            return getTagNave() + " blindagem desativada.";
        }
        return getTagNave() + " não é possível desativar blindagem em movimento.";
    }

    public String ativarControleAutomatico() {
        return getTagNave() + " controle automático ativado.";
    }
}