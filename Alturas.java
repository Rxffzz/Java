package exercises.altura;

import java.util.Locale;
import java.util.Scanner;

public class Alturas {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantas pessoas serao digitadas? ");
        int n = sc.nextInt();
        String nome[] = new String[n];
        int idades[] = new int[n];
        double alturas[] =new double[n];

        for(int i = 0; i<n; i++) {
            System.out.println("Dados da " + (i+1) + "a pessoa:");
            System.out.print("Nome: ");
            nome[i] = sc.next();
            System.out.print("Idade: ");
            idades[i] = sc.nextInt();
            System.out.print("Altura: ");
            alturas[i] = sc.nextDouble();
        }

        double mediaAlturas = 0.0;
        double somaAlturas = 0.0;

        for (int i = 0; i<n; i++){
            somaAlturas = somaAlturas += alturas[i];
        }

        for(int i = 0; i<n; i++) {
            mediaAlturas = somaAlturas / n;
        }

        System.out.println();
        System.out.printf("Altura media: %.2f\n", mediaAlturas);

        int menores = 0;
        
        for (int i=0; i<n; i++) {
            if (idades[i] < 16) {
                menores++;
            }
        }
        double percentMenores = ((double) menores / n) * 100.0;

        System.out.printf("Pessoas com menos de 16 anos: %.1f%%\n", percentMenores);

        for(int i =0; i<n; i++){
            if (idades[i] < 16) {
                System.out.printf("%s\n", nome[i]); 
            }
        }
           
        sc.close();
    }
}
