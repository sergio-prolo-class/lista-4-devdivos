package ifsc.poo;

import java.util.LinkedHashSet;
import java.util.Set;
import ifsc.poo.interfaces.*;
import ifsc.poo.naves.*;

public class App {
    
    private final Set<NaveEspacial> garagem = new LinkedHashSet<>();

    public void executar() {
        System.out.println("--- Iniciando Simulação da Frota Espacial ---");

        inicializarGaragem();

        System.out.println("\n--- Naves na Garagem ---");
        for (NaveEspacial nave : garagem) {
            System.out.println(nave.getTagNave());
        }

        System.out.println("\n--- Executando Operações com a Frota (Usando Polimorfismo) ---");
        operarFrotas();

        System.out.println("\n--- Simulação Finalizada ---");
    }

    private void inicializarGaragem() {
        garagem.add(new NaveCargueira(2000));

        garagem.add(new NaveMineradora(18, 1000)); // Velocidade 18 (entre 12-20)

        garagem.add(new NaveExploradora(14,4)); // Tripulação 4 (entre 2-10)

        garagem.add(new NaveSentinela(15)); // Velocidade 15 (entre 10-20)
    }

    private void operarFrotas() {
        for (NaveEspacial nave : garagem) {
            System.out.println("\n========================================================");
            System.out.println(">>> OPERANDO: " + nave.getTagNave());
            System.out.println("========================================================");

            // Usando polimorfismo na instrução abaixo
            // Chamando o metodo 'decolar' da superclasse 'NaveEspacial' em um objeto
            // que pode ser de qualquer uma das subclasses.
            // Ações comuns
            System.out.println(nave.decolar());
            // Usando polimorfismo na instrução abaixo
            System.out.println(nave.acelerar(13));

            // Teste de capacidades (Interfaces)
            // Usando polimorfismo na instrução abaixo
            // Verificamos se o objeto 'NaveEspacial' tem a "forma" da interface 'Tripulada'.
            if (nave instanceof Tripulada) {
                // Se tiver, podemos fazer o "cast" e chamar o metodo da interface.
                System.out.println(((Tripulada) nave).ativarControleManual());
            }
            // Usando polimorfismo na instrução abaixo
            if (nave instanceof Autonoma) {
                System.out.println(((Autonoma) nave).ativarControleAutomatico());
            }
            // Usando polimorfismo na instrução abaixo
            if (nave instanceof Blindada) {
                System.out.println(((Blindada) nave).ativarBlindagem());
            }

            // Teste de métodos exclusivos (Classes Concretas)
            // Usando polimorfismo na instrução abaixo
            // Verificamos se o objeto 'NaveEspacial' é, na verdade, uma 'NaveCargueira'.
            if (nave instanceof NaveCargueira) {
                // Se for, podemos fazer o "cast" para acessar seus métodos exclusivos.
                System.out.println(((NaveCargueira) nave).carregar(1500)); // Carga > 70% para testar blindagem auto
            }

            // Usando polimorfismo na instrução abaixo
            if (nave instanceof NaveMineradora) {
                System.out.println(((NaveMineradora) nave).minerar(100)); // Deve falhar (velocidade alta)
                System.out.println(nave.frear(12)); // Reduz velocidade para 1 // Chamada polimórfica padrão
                System.out.println(((NaveMineradora) nave).minerar(100)); // Deve funcionar
            }

            // Usando polimorfismo na instrução abaixo
            if (nave instanceof NaveExploradora) {
                System.out.println(((NaveExploradora) nave).ativarHolofotes());
            }

            // Usando polimorfismo na instrução abaixo
            if (nave instanceof NaveSentinela) {
                System.out.println(((NaveSentinela) nave).ativarRadar()); // Deve falhar (velocidade alta)
                System.out.println(nave.frear(5)); // Reduz velocidade para 8
                System.out.println(((NaveSentinela) nave).ativarRadar()); // Deve funcionar
            }

            // Usando polimorfismo na instrução abaixo
            // O método 'pousar' é chamado. Se a subclasse (ex: NaveExploradora)
            // tiver uma versão sobrescrita (@Override), essa versão será executada.
            System.out.println(nave.frear(20));
            System.out.println(nave.pousar());
        }
    }

    public static void main(String[] args) {
        App app = new App();
    app.executar();
}
    
}
