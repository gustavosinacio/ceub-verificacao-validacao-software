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
         if(fatorial == 0) return 1;
        return fatorial;
    }
	
	public int somaDobro(int a, int b) {
        return a + b * 2;
    }
}