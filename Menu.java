import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private Conversor conversor;

    public Menu(Conversor conversor) {
        this.conversor = conversor;
    }
    public int leInt(){
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();
        return i;
    }
    public String leString(){
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        return s;
    }

    public char leChar(){
        Scanner input = new Scanner(System.in);
        char c = input.next().charAt(0);
        return c;
    }

    public void imprimeMenu(){
        System.out.println("\n----------Conversor de binário para decimal----------\nQuantos números deseja converter?");
    }

    public boolean charNaoEZeroOuUm(char c){
        if (Character.getNumericValue(c) != 0 || Character.getNumericValue(c) != 1)
            return false;
        return true;
    }

    public boolean verificaSeNumeroEstaEmBinario(String numero){
        for (int i = 0; i < numero.length(); i++){
            if (charNaoEZeroOuUm(numero.charAt(i)))
                return false;
        }
        return true;
    }
    public void rodaMenu(){
        boolean ativo = true;
        while (ativo){
            imprimeMenu();
            int qtdDeNumeros = leInt();

            for (int i = 0; i < qtdDeNumeros; i++){
                String numeroBinarioEmString = null;
                boolean vai = true;
                while(vai) {
                    System.out.printf("Número %d: ", i + 1);
                    numeroBinarioEmString = leString();
                    if (verificaSeNumeroEstaEmBinario(numeroBinarioEmString)){
                        System.out.println("Número não está em binário. Por favor digite um número em binário para ser convertido.");
                        vai = false;
                    }

                }
                NumeroBinario numeroBinario = conversor.geraNovoNumeroBinario(numeroBinarioEmString);
                conversor.adcionaNumeroBinarioNaArray(numeroBinario);
            }
            conversor.converteParaDecimal();
            imprimeResultado();

            System.out.println("Deseja converter mais algum número? s/n");
            char opc = Character.toLowerCase(leChar());
            if (opc == 'n')
                ativo = false;
        }
    }

    public void imprimeResultado(){
        ArrayList<NumeroBinario> resultado = conversor.getNumerosBinarios();
        for (NumeroBinario numeroBinario : resultado){
            System.out.println(numeroBinario.getBinario() + " = " + numeroBinario.getDecimal());
        }
    }
}
