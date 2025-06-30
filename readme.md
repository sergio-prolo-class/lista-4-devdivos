[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/eVrFUgIm)

# Programação Orientada a Objetos

Dupla: Leticia Helena do Rosário Furlan e Roberto da Silva Espindola.

## Lista 4: Frota Espacial Polimórfica

```mermaid
classDiagram
    class App {
        - garagem : Set<NaveEspacial>
        + main(args : String[]) void
    }
    class NaveEspacial {
        <<abstract>>
        - int id
        - int velocidadeAtual
        - int velocidadeMaxima
        - int tripulacaoMax
        - int tripulacaoAtual
        + String acelerar(int)
        + String frear(int)
        + String pousar()
        + String decolar()
    }

    class Autonoma {
        <<interface>>
        + String ativarControleAutomatico()
    }

    class Tripulada {
        <<interface>>
        + String controleManual()
    }

    class Blindada {
        <<interface>>
        + String ativarBlindagem()
        + String desativarBlindagem()
    }

    class NaveMineradora {
        - int energiaLaserMaxima
        - int energiaLaserAtual
        + String minerar(int)
        + String controleManual()
    }

    class NaveExploradora {
        - boolean holofotesAtivos
        + String ativarHolofotes()
        + String desligarHolofotes()
        + String controleManual()
        + String pousar()
    }

    class NaveCargueira {
        - int cargaMaxima
        - int cargaAtual
        - boolean blindagemAtiva
        + String ativarBlindagem()
        + String desativarBlindagem()
        + String ativarControleAutomatico()
        + String carregar(int)
    }

    class NaveSentinela {
        - boolean radarAtivo
        + String ativarRadar()
        + String desativarRadar()
        + String ativarControleAutomatico()
    }
    
    App o-- NaveEspacial
    NaveEspacial <|-- NaveMineradora
    NaveEspacial <|-- NaveExploradora
    NaveEspacial <|-- NaveCargueira
    NaveEspacial <|-- NaveSentinela

    NaveMineradora ..|> Tripulada
    NaveExploradora ..|> Tripulada
    NaveCargueira ..|> Blindada
    NaveCargueira ..|> Autonoma
    NaveSentinela ..|> Autonoma

```