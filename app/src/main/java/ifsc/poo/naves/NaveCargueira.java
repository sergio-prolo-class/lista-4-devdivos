package ifsc.poo.naves;

import ifsc.poo.interfaces.Autonoma;
import ifsc.poo.interfaces.Blindada;

public class NaveCargueira extends NaveEspacial implements Blindada, Autonoma {
    private final int cargaMaxima;
    private int cargaAtual;
    private boolean blindagemAtiva;

    public NaveCargueira(int cargaMaxima) {
        super(14, 0);
        this.cargaMaxima = cargaMaxima;
        this.cargaAtual = 0;
        this.blindagemAtiva = false;
    }

    public String carregar(int carga) {
        if (this.cargaAtual + carga > this.cargaMaxima) {
            return getTagNave() + " não é possível carregar além da carga máxima.";
        }
        this.cargaAtual += carga;

        if (cargaAtual > 0.7 * (double)cargaMaxima) {
            blindagemAtiva = true;
            return getTagNave() + " carga de " + carga + " adicionada." + " " + "Carga atual: " + this.cargaAtual + " --- " + ativarBlindagem() + " (Ativação automática por carga elevada)";
        }

        return getTagNave() + " carga de " + carga + " adicionada. Carga atual: " + this.cargaAtual;
    }

    @Override
    public String ativarBlindagem() {
        this.blindagemAtiva = true;
        return getTagNave() + " blindagem ativada.";
    }

    public String desativarBlindagem() {
        if (velocidadeAtual == 0) {
            if(this.blindagemAtiva){
                this.blindagemAtiva = false;
                return getTagNave() + " blindagem desativada.";
            }
            return getTagNave() + " blindagem já estava desativada.";
        }
        return getTagNave() + " não é possível desativar a blindagem em movimento.";
    }

    @Override
    public String ativarControleAutomatico() {
        return getTagNave() + " controle automático ativado.";
    }

    @Override
    public String pousar() {
        String mensagemPouso = super.pousar();
        if (this.velocidadeAtual == 0) {
            mensagemPouso += "\n" + desativarBlindagem();
        }
        return mensagemPouso;
    }
}