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