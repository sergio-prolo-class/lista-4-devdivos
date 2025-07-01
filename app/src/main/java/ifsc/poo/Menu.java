package ifsc.poo;

import ifsc.poo.interfaces.*;
import ifsc.poo.naves.*;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Menu {

    private final LinkedHashSet<NaveEspacial> garagem = new LinkedHashSet<>();

    public Menu() {
        inicializarNaves();
    }

    private void inicializarNaves() {
        garagem.add(new NaveMineradora(15, 100));
        garagem.add(new NaveExploradora(16, 3));
        garagem.add(new NaveCargueira(14, 0, 1000));
        garagem.add(new NaveSentinela(14, 0));
    }

    public void executar() {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== MENU FROTA ESPACIAL =====");
            System.out.println("1. Simular ações das naves");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> simularAcoes();
                case 0 -> System.out.println("Encerrando simulação...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        sc.close();
    }

    private void simularAcoes() {
        for (NaveEspacial nave : garagem) {
            System.out.println("// Polimorfismo:");
            System.out.println(nave.decolar());
            System.out.println(nave.acelerar(5));
            System.out.println(nave.frear(3));
            System.out.println(nave.pousar());
            System.out.println();

            if (nave instanceof Tripulada t) {
                System.out.println(t.ativarControleManual());
            }

            if (nave instanceof Autonoma a) {
                System.out.println(a.ativarControleAutomatico());
            }

            if (nave instanceof Blindada b) {
                System.out.println(b.ativarBlindagem());
                System.out.println(b.desativarBlindagem());
            }

            if (nave instanceof NaveMineradora m) {
                System.out.println(m.minerar(20));
            }

            if (nave instanceof NaveExploradora e) {
                System.out.println(e.ativarHolofotes());
                System.out.println(e.pousar());
            }

            if (nave instanceof NaveCargueira c) {
                System.out.println(c.carregar(800));
                System.out.println(c.desativarBlindagem());
            }

            if (nave instanceof NaveSentinela s) {
                System.out.println(s.ativarRadar());
                System.out.println(s.desativarRadar());
            }

            System.out.println("--------------------------------------------------");
        }
    }
}