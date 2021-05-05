package org.example.util;

import java.util.Scanner;

public class Console {
    public static void writeConsole(String text) {
        System.out.println(text);
    }

    public static int readIntConsole() {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNext()) {
            int res = scanner.nextInt();
            scanner.nextLine();
            return res;
        }
        scanner.nextLine();
        writeConsole("Вы ввели не число. Повторите попытку:");
        return readIntConsole();
    }

    public static int readIntConsole(String message) {
        writeConsole(message);
        return readIntConsole();
    }

    public static int readIntConsole(int min, int max) {
        int res = readIntConsole();
        if(res < min || res > max){
            writeConsole(String.format("Вы ввели не корретное значение. Минимум %d максимум %d", min, max));
            return readIntConsole();
        }
        return res;
    }

    public static int readIntConsole(int min, int max, String message) {
        writeConsole(message);
        return readIntConsole(min, max);
    }
}
