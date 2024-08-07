import java.util.Scanner;
import static java.lang.Character.toUpperCase;

public class Conversao {
    public enum EscalasEnum{
        FAHRENHEIT {
            @Override
            public double converterPara(char escala, double temperatura) {

                switch (escala){
                    case 'C': return (temperatura - 32)*(5f/9);
                    case 'K': return (temperatura + 459.67)*(5f/9);
                    default: return temperatura;
                }
            }
        },

        CELSIUS {
            @Override
            public double converterPara(char escala, double temperatura) {

                switch(escala){
                    case 'F': return (temperatura *(9f/5))+32;
                    case 'K': return (temperatura + 273.15);
                    default: return temperatura;
                }
            }
        },

        KELVIN {
            @Override
            public double converterPara(char escala, double temperatura) {

                switch (escala){
                    case 'C': return (temperatura - 273.15);
                    case 'F': return ((9f/5)*temperatura- 459.67);
                    default: return temperatura;
                }
            }
        };

        public abstract double converterPara(char escala, double temperatura);
    }

    public static String getEscalaAtual(char escala){
        switch(escala){
            case 'C': return "CELSIUS";
            case 'K': return "KELVIN";
            case 'F': return "FAHRENHEIT";
            default: return "Escala não encontrada";
        }
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.print("Escolha a escala de temperatura atual (C, K ou F): ");
        char escalaInicial = toUpperCase(s.next().charAt(0));

        System.out.print("Escolha a escala para a conversão (C, K ou F): ");
        char escalaObjetivo = toUpperCase(s.next().charAt(0));

        System.out.print("Digite a temperatura: ");
        double temperatura = s.nextDouble();

        s.close();

        EscalasEnum escalas = EscalasEnum.valueOf(getEscalaAtual(escalaInicial));
        System.out.printf("Convertendo %.2f%c para %c = %.2f%c", temperatura,
                escalaInicial,
                escalaObjetivo,
                escalas.converterPara(escalaObjetivo, temperatura),
                escalaObjetivo);

    }
}
