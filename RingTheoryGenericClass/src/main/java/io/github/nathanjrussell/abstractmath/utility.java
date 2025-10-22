package io.github.nathanjrussell.abstractmath;

public class utility {

    public enum ConsoleColor {
        RESET("\u001b[0m"),
        BLACK("\u001b[30m"),
        RED("\u001b[31m"),
        GREEN("\u001b[32m"),
        YELLOW("\u001b[33m"),
        BLUE("\u001b[34m"),
        MAGENTA("\u001b[35m"),
        CYAN("\u001b[36m"),
        WHITE("\u001b[37m"),
        BRIGHT_WHITE("\u001b[97m");

        private final String code;

        ConsoleColor(String code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return code;
        }
    }

    public static <T> void printOpTable(java.util.List<T> headers, T[][] body) {
        if (headers == null || headers.isEmpty()) return;
        int n = headers.size();
        if (body == null || body.length != n) {
            throw new IllegalArgumentException("Body must be an n x n array matching headers size.");
        }
        for (int i = 0; i < n; i++) {
            if (body[i] == null || body[i].length != n) {
                throw new IllegalArgumentException("Each row of body must have length equal to headers.size().");
            }
        }

        // raw string cells (no color codes) used for width calculations and centering
        String[][] cells = new String[n + 1][n + 1];
        cells[0][0] = "+";
        for (int j = 0; j < n; j++) {
            cells[0][j + 1] = java.util.Objects.toString(headers.get(j), "");
            cells[j + 1][0] = java.util.Objects.toString(headers.get(j), "");
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells[i + 1][j + 1] = java.util.Objects.toString(body[i][j], "");
            }
        }

        int cols = n + 1;
        int[] widths = new int[cols];
        for (int j = 0; j < cols; j++) {
            int max = 0;
            for (int i = 0; i < cols; i++) {
                int len = cells[i][j] == null ? 0 : cells[i][j].length();
                if (len > max) max = len;
            }
            widths[j] = max + 2; // padding: one space each side
        }

        // build horizontal rule (raw, without color)
        StringBuilder hrBuilder = new StringBuilder();
        hrBuilder.append("+");
        for (int w : widths) {
            hrBuilder.append("-".repeat(Math.max(0, w)));
            hrBuilder.append("+");
        }
        String hr = hrBuilder.toString();

        // center helper (works with raw strings)
        java.util.function.BiFunction<String, Integer, String> center = (s, w) -> {
            if (s == null) s = "";
            if (s.length() >= w) return s.substring(0, w);
            int padding = w - s.length();
            int left = padding / 2;
            int right = padding - left;
            return " ".repeat(left) + s + " ".repeat(right);
        };

        // print top horizontal rule in white
        System.out.println(ConsoleColor.WHITE + hr + ConsoleColor.RESET);

        for (int i = 0; i < cols; i++) {
            // start row with white vertical bar
            System.out.print(ConsoleColor.WHITE + "|" + ConsoleColor.RESET);
            for (int j = 0; j < cols; j++) {
                // choose color: header row or header column -> RED; else -> GREEN
                ConsoleColor cellColor = (i == 0 || j == 0) ? ConsoleColor.YELLOW : ConsoleColor.GREEN;
                String centered = center.apply(cells[i][j], widths[j]);
                // print colored cell, then white vertical bar to keep lines white
                System.out.print(cellColor + centered + ConsoleColor.RESET + ConsoleColor.WHITE + "|" + ConsoleColor.RESET);
            }
            System.out.println();
            // print horizontal rule in white after each row
            System.out.println(ConsoleColor.WHITE + hr + ConsoleColor.RESET);
        }
    }
}
