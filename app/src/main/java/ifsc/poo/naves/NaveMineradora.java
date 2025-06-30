package ifsc.poo.naves;
import ifsc.poo.interfaces.Tripulada;

public class NaveMineradora extends NaveEspacial implements Tripulada {
    private int energiaLaserAtual;

    public NaveMineradora(int velocidadeMaxima, int energiaLaserMaxima) {
        super(velocidadeMaxima, 2);
        this.energiaLaserAtual = energiaLaserMaxima;
    }

    public String minerar(int custo) {
        if (energiaLaserAtual > custo && velocidadeAtual < velocidadeMaxima * 0.1) {
            energiaLaserAtual -= custo;
            return getTagNave() + " mineração realizada. Energia restante: " + energiaLaserAtual;
        }
        return getTagNave() + " não pode minerar (verifique energia ou velocidade)";
    }

    public String ativarControleManual() {
        return getTagNave() + " controle manual ativado.";
    }
}