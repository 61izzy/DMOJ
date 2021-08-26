public class Main {
    public static void main(String[] args) {
        String[] line = {
        "public class Main {",
        "    public static void main(String[] args) {",
        "        String[] line = {",
        "        ",
        "        };",
        "        for (int i = 0; i < 3; i++)",
        "            System.out.println(line[i]);",
        "        for (int i = 0; i < line.length; i++)",
        "            System.out.println(line[3] + (char)34 + line[i] + (char)34 + (char)44);",
        "        for (int i = 4; i < line.length; i++)",
        "            System.out.println(line[i]);",
        "    }",
        "}",
        };
        for (int i = 0; i < 3; i++)
            System.out.println(line[i]);
        for (int i = 0; i < line.length; i++)
            System.out.println(line[3] + (char)34 + line[i] + (char)34 + (char)44);
        for (int i = 4; i < line.length; i++)
            System.out.println(line[i]);
    }
}
