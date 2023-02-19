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

    public void rodaMenu(){
        boolean ativo = true;
        while (ativo){
            imprimeMenu();
            int qtdDeNumeros = leInt();

            for (int i = 0; i < qtdDeNumeros; i++){
                System.out.printf("Número %d: ", i+1);
                String numeroBinario = leString();
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


    //todo: menu pergunta quantos numeros serão convertidos
    //todo: menu lê os numeros binários em string
    //todo: menu manda o conversor converter em decimal
    //todo: menu imprime para o usuário o resultado
    //todo: menu pergunta se quer converter mais números
    //if not, break;
}
