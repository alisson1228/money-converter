import model.Code;
import model.Request;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String key = "ab3429d80811b8632cd5696b";

        Scanner scan = new Scanner(System.in);
        Request request = new Request(key);

        ArrayList<Code> codes = request.cods();

        System.out.println("Tipos de opções:");

        for (int i = 0; i < codes.size(); i++) {
            String nome = codes.get(i).getName();
            System.out.println((i + 1) + " - " + nome);
        }

        System.out.println("\nDigite o numero da moeda original:");

        int origin = scan.nextInt();

        System.out.println("\nDigite o valor:");

        double value = scan.nextDouble();

        System.out.println("\nDigite o numero da moeda a converter:");

        int objective = scan.nextInt();

        System.out.println("\nResultado: " + request.cover(codes.get(origin - 1).getCode(), codes.get(objective - 1).getCode(), value));
    }
}