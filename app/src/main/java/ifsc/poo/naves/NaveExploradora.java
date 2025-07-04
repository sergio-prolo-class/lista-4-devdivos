package ifsc.poo.naves;
import ifsc.poo.interfaces.Tripulada;
import ifsc.poo.interfaces.Blindada;


public class NaveExploradora extends NaveEspacial implements Tripulada, Blindada {
    private boolean holofotesAtivos;
    private boolean blindagemAtiva;

    public NaveExploradora(int velocidadeMaxima, int tripulacaoMax) {
        super(14, ajustarTripulacao(tripulacaoMax));
        this.holofotesAtivos = false;
        this.blindagemAtiva = false;
    }

    private static int ajustarTripulacao(int t) {
        if (t < 2) {
            System.out.println("Valor de tripulação muito baixo. Ajustando para 2.");
            return 2;
        } else if (t > 10) {
            System.out.println("Valor de tripulação muito alto. Ajustando para 10.");
            return 10;
        }
        return t;
    }

    public String ativarHolofotes() {
        this.holofotesAtivos = true;
        return getTagNave() + " holofotes ativados.";
    }

    public String desligarHolofotes() {
        this.holofotesAtivos = false;
        return getTagNave() + " holofotes desligados.";
    }

    @Override
    public String pousar() {
        String mensagemPouso = super.pousar();
        if (this.velocidadeAtual == 0) {
            if (this.holofotesAtivos) {
                mensagemPouso += "\n" + desligarHolofotes() + " (Desligamento automático ao pousar)";
            }
        }
        return mensagemPouso;
    }

    @Override
    public String ativarControleManual() {
        return getTagNave() + " controle manual ativado.";
    }

    @Override
    public String ativarBlindagem() {
        this.blindagemAtiva = true;
        return getTagNave() + " blindagem leve ativada para reconhecimento em campo.";
    }

    @Override
    public String desativarBlindagem() {
        blindagemAtiva = false;
        return getTagNave() + " blindagem desativada.";
    }
}