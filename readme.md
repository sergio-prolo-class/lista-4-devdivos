[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/eVrFUgIm)

# Programação Orientada a Objetos

Dupla: Leticia Helena do Rosário Furlan e Roberto da Silva Espindola.

## Lista 4: Frota Espacial Polimórfica

```mermaid
classDiagram
    direction LR
    class App{
        - garagem : Set<NaveEspacial>
        + main(args : String[]) void
    }
    
    class NaveEspacial{
        # velocidadeAtual : int
        + acelerar(inten: int) String
        + pousar() String
        + decolar() String
    } 
    
    class NaveMineradora{
        - energiaLaserMaxima : int
        - energiaLaserAtual : int
        + minerar(custo : int) String
    }
    
    class NaveExploradora{
        - holofotes : bool
        + ligarHolofotes() String
    }
    
    class NaveCargueira{
        - capacidadeMaxima : int
        - cargaAtual : int
        + carregar(peso:int) String
    }
    
    class NaveSentinela{
        - radar : bool
        + ligarRadar() String
    }
    
    class Tripulada{
        <<interface>>
        + controlarManual() String
    }
    
    class Blindada{
        <<interface>>
        + ativarBlindagem() String
    }
    
    class Autonoma{
        + ativarControleAutomatico() String
    }

```