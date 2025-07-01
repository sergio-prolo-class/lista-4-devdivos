package ifsc.poo.naves;

public abstract class NaveEspacial {
    protected static int contadorId = 1;
    protected int id;
    protected int velocidadeAtual;
    protected int velocidadeMaxima;
    protected int tripulacaoMaxima;
    protected int tripulacaoAtual;

    public NaveEspacial(int velocidadeMaxima, int tripulacaoMaxima) {
        this.id = contadorId++;
        this.velocidadeAtual = 0;
        this.velocidadeMaxima = velocidadeMaxima;
        this.tripulacaoMaxima = tripulacaoMaxima;
        this.tripulacaoAtual = 0;
    }

    public String acelerar(int incremento){
        velocidadeAtual = Math.min(velocidadeAtual+incremento, velocidadeMaxima);
        return getTagNave() + " acelerando para " + velocidadeAtual + "Km/h";
    }

    public String frear(int incremento){
        velocidadeAtual = Math.max(velocidadeAtual-incremento, velocidadeMaxima);
        return getTagNave() +" freando para " + velocidadeAtual + "Km/h";
    }

    public String pousar(){
        if(velocidadeAtual == 0){
            return getTagNave() + " pousando";
        }
        return getTagNave() + " não pode pousar em movimento!";
    }

    public String decolar(){
    return getTagNave() + " decolando";
    }

    protected String getTagNave(){
        return this.getClass().getSimpleName() +  "(ID#" + String.format("%04d", id) + "):";
    }

    public int getvelocidadeAtual() {
        return velocidadeAtual;
    }
    public int getVelocidadeMaxima() {
        return velocidadeMaxima;
    }
}
