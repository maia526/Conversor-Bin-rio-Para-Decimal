public class NumeroBinario {
    private String binario;
    private int decimal;

    public NumeroBinario(String  binario) {
        this.binario = binario;
    }

    public String getBinario() {
        return binario;
    }

    public int getDecimal() {
        return decimal;
    }

    public void setDecimal(int decimal) {
        this.decimal = decimal;
    }

    @Override
    public String toString() {
        return "NumeroBinario{" +
                "binario='" + binario + '\'' +
                ", decimal=" + decimal +
                '}';
    }
}
