# Correção

## Diagrama

- multiplicidade ausente entre App e NaveEspacial

## Implementação

- por que há algs4 no repositório?
- App
  - em geral, tudo ok.
  - apenas uma dica: o operador instanceof também pode ser usado para atribuir a especificação para uma nova variável local
    - por exemplo: em App (linha 55), poderiam usar if (nave instanceof Tripulada t)
    - agora, t é uma variável do tipo Tripulada igual à nave
    - assim, na linha 57 não precisaria do typecasting em nave, e ficaria apenas t.ativarControleManual()
- NaveEspacial
  - em nenhum lugar está implementada a restrição de velocidade máxima e tribulação com base nas interfaces
    - o construtor de NaveEspacial permite a criação de qualquer versão, com qualquer valor
    - nenhuma classe concreta restringe os valores para obedecer às restrições das regras da agência espacial
    - assim, eu posso criar uma nave que não obedece nada!

## Nota

9