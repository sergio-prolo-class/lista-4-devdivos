package ifsc.poo.naves;

public abstract class NaveEspacial {
    protected static int contadorId = 1;
    protected final int id;
    protected int velocidadeAtual;
    protected final int velocidadeMaxima;
    protected final int tripulacaoMaxima;
    protected int tripulacaoAtual;

    public NaveEspacial(int velocidadeMaxima, int tripulacaoMaxima) {
        this.id = contadorId++;
        this.velocidadeAtual = 0;
        this.velocidadeMaxima = velocidadeMaxima;
        this.tripulacaoMaxima = tripulacaoMaxima;
        this.tripulacaoAtual = 0;
    }

    public String acelerar(int incremento){
        velocidadeAtual = Math.min(this.velocidadeAtual+incremento, this.velocidadeMaxima);
        return getTagNave() + " acelerando para " + velocidadeAtual + "Mm/h";
    }

    public String frear(int incremento){
        velocidadeAtual = Math.max(this.velocidadeAtual-incremento, 0);
        return getTagNave() +" freando para " + this.velocidadeAtual + "Mm/h";
    }

    public String pousar(){
        if(velocidadeAtual == 0){
            return getTagNave() + " pouso autorizado. Nave pousada.";
        }
        return getTagNave() + " não pode pousar em movimento!";
    }

    public String decolar(){
        return getTagNave() + " decolando";
    }

    public String getTagNave(){
        return this.getClass().getSimpleName() +  "(ID#" + String.format("%04d", id) + "):";
    }

    public int getId() {
        return id;
    }
}