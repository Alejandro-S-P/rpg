package game;

import java.util.Scanner;

public class ReadInt {
    private Scanner sc;
    private String prompt;
    private int min;
    private int max;
    
public ReadInt(Scanner sc, String prompt, int min, int max) {
        this.sc = sc;
        this.prompt = prompt;
        this.min = min;
        this.max = max;
    }

public Scanner getSc() {
    return sc;
}

public void setSc(Scanner sc) {
    this.sc = sc;
}

public String getPrompt() {
    return prompt;
}

public void setPrompt(String prompt) {
    this.prompt = prompt;
}

public int getMin() {
    return min;
}

public void setMin(int min) {
    this.min = min;
}

public int getMax() {
    return max;
}

public void  setMax(int max) {
    this.max = max;
}

public static int readInt(Scanner sc, String prompt, int min, int max) {
        while (true) {
            System.out.println(prompt);
            String line = sc.nextLine();
            try {
                int val = Integer.parseInt(line.trim());
                if (val < min || val > max) {
                    System.out.println("Ingrese un número entre " + min + " y " + max + ".");
                    continue;
                }
                return val;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Intente de nuevo.");
            }
        }
    }
}
