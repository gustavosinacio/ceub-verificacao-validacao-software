# Verificação e validação de Software

## Introdução

Neste relatório, vamos apresentar os resultados da criação de testes unitários para uma calculadora. Todo o código deste trabalho, incluindo o código testado e seus testes estarão disponíveis [neste repositório do github](https://github.com/gustavosinacio/ceub-verificacao-validacao-software). Os testes foram criados com o JUnit 4.13.2 para testar o seguinte código:

```java
public class CalculadoraDiferente {
    public int inverteNumero(int numero){
        int numeroInvertido = 0;
        int temp = 0;

        while(numero > 0){
            temp = numero%10;
            numeroInvertido = numeroInvertido * 10 + temp;
            numero = numero/10;
        }
        return (numeroInvertido);
    }

    public int fatorial(int numero){
        int fatorial = numero;
         for(int i =(numero - 1); i > 1; i--)
         {
            fatorial = fatorial * i;
         }
        return fatorial;
    }

	public int somaDobro(int a, int b) {
        return a + b * 2 ;
    }
}
```

## Testes

Para começar, criei alguns testes para cada uma das funções disponibilizadas. Eles podem ser encontrados a seguir.

```java
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculadoraDiferenteTest {

    @Test
    public void testInverteNumero() {
        CalculadoraDiferente calc = new CalculadoraDiferente();
        assertEquals(321, calc.inverteNumero(123));
        assertEquals(8008135, calc.inverteNumero(5318008));
        assertEquals(4321, calc.inverteNumero(1234));
        assertEquals(1, calc.inverteNumero(1));
        assertEquals(0, calc.inverteNumero(0));
        assertEquals(21, calc.inverteNumero(1200));
    }

    @Test
    public void testFatorial() {
        CalculadoraDiferente calc = new CalculadoraDiferente();
        assertEquals(120, calc.fatorial(5));
        assertEquals(362880, calc.fatorial(9));
        assertEquals(6, calc.fatorial(3));
        assertEquals(1, calc.fatorial(1));
        assertEquals(1, calc.fatorial(0));
    }

    @Test
    public void testSomaDobro() {
        CalculadoraDiferente calc = new CalculadoraDiferente();
        assertEquals(7, calc.somaDobro(1, 3));
        assertEquals(14, calc.somaDobro(2, 6));
        assertEquals(0, calc.somaDobro(0, 0));
        assertEquals(3, calc.somaDobro(1, 1));
        assertEquals(1, calc.somaDobro(1, 0));
        assertEquals(2, calc.somaDobro(0, 1));
        assertEquals(10, calc.somaDobro(2, 4));
    }
}
```

e os rodei, obtendo o seguinte resultado:

```bash
JUnit version 4.13.2
...E
Time: 0.003
There was 1 failure:
1) testFatorial(CalculadoraDiferenteTest)
java.lang.AssertionError: expected:<1> but was:<0>
        at org.junit.Assert.fail(Assert.java:89)
        at org.junit.Assert.failNotEquals(Assert.java:835)
        at org.junit.Assert.assertEquals(Assert.java:647)
        at org.junit.Assert.assertEquals(Assert.java:633)
        at CalculadoraDiferenteTest.testFatorial(CalculadoraDiferenteTest.java:24)

FAILURES!!!
Tests run: 3,  Failures: 1
```

Como podemos ver, houveram erros no teste. Na linha 24 dos testes, era esperado o resultado 1, porém o resultado retornado foi 0. Ao investigar melhor, podemos ver que a função fatorial não trata o caso especifico do número 0. Na matematica, o retorno de 0! (zero fatorial) é 1. Vamos corrigir o código disponibilizado e executar novamente os testes.

O código ajustado:

```java
public int fatorial(int numero){
    int fatorial = numero;
     for(int i =(numero - 1); i > 1; i--)
     {
        fatorial = fatorial * i;
     }
     if(fatorial == 0) return 1; // adiciona o retorno esperado de 0!
    return fatorial;
}
```

O resultado dos testes após o ajuste:

```bash
JUnit version 4.13.2
...
Time: 0.003

OK (3 tests)

```

## Conclusão

O retorno acima o ultimo retorno da seção anterior mostra que os testes foram executados e o código passou com sucesso.

Isso demonstra a importância de testes em código. O erro encontrado era um erro de lógica. Esse erro não seria capturado pelo compilador nem pelos LSPs do vscode. Era um erro que poderia facilmente chegar em produção. Entretanto, testando o resultado esperado que já era previamente conhecido (nesse caso, algumas funções matemáticas) conseguimos capturar e ajustar o erro sem grandes esforços.

O desenvolvimento de testes automatizados torna o nosso código confiável. Qualquer manutenção que seja feita nesse código no futuro será mais simples, pois o dev que fizer ajustes terá a segurança de executar os testes e imediatamente saberá se suas alterações alteraram o resultado esperado das funções.
