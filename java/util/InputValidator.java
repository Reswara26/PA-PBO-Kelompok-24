package util;

import java.util.Scanner;

public final class InputValidator {
    private InputValidator() {}

    public static String requireNonEmpty(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine();
            if (s != null && !s.trim().isEmpty()) return s.trim();
            System.out.println("Wajib diisi. Tidak boleh kosong.");
        }
    }

    public static double requireDouble(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (s.matches("^-?\\d+(\\.\\d+)?$")) return Double.parseDouble(s);
            System.out.println("Input harus angka. Coba lagi.");
        }
    }

    public static String requireDate(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (s.matches("^[0-9\\-]+$") && s.matches("^\\d{4}-\\d{2}-\\d{2}$")) return s;
            System.out.println("⚠Format tanggal harus YYYY-MM-DD.");
        }
    }
}
