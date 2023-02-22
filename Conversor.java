import java.util.ArrayList;

public class Conversor {
    private ArrayList<NumeroBinario> numerosBinarios;

    public Conversor() {
        this.numerosBinarios = new ArrayList<>();
    }
    public NumeroBinario geraNovoNumeroBinario(String numeroBinario){
        NumeroBinario n = new NumeroBinario(numeroBinario);
        return n;
    }
    public boolean adcionaNumeroBinarioNaArray(NumeroBinario numeroBinario){
        return numerosBinarios.add(numeroBinario);
    }
    public void converteParaDecimal(){
        int decimal;
        for (NumeroBinario numeroBinario : numerosBinarios){
            int[] digitosBinarios = separaStringEmChar(numeroBinario.getBinario());
            decimal = fazContaBinParaDec(digitosBinarios);
            numeroBinario.setDecimal(decimal);
        }
    }

    public int[] separaStringEmChar(String numeroEmString){
        int tamanhoDaString = numeroEmString.length();
        int[] digitosBinarios = new int[tamanhoDaString];
        for (int i = 0; i < tamanhoDaString; i++){
            digitosBinarios[i] = Character.getNumericValue(numeroEmString.charAt(i));
        }
        return digitosBinarios;
    }

    public int fazContaBinParaDec(int[] digitosBinarios){
        int valorCasa = 1;
        int decimal = 0;
        for (int i = digitosBinarios.length - 1; i >= 0; i--){
            decimal += digitosBinarios[i] * valorCasa;
            valorCasa *= 2;
        }
        return decimal;
    }

    public ArrayList<NumeroBinario> getNumerosBinarios() {
        return numerosBinarios;
    }
}
