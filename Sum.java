import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        int sum = 0;

        // склеиваем все аргументы в одну строку
        String allArgs = String.join(" ", args);

        // Scanner по умолчанию делит по пробельным символам
        Scanner scanner = new Scanner(allArgs);

        while (scanner.hasNext()) {
            String token = scanner.next();
            try {
                int number = Integer.parseInt(token);
                sum += number;
            } catch (NumberFormatException ignored) {
                // если вдруг встретится не число — просто пропускаем
            }
        }

        scanner.close();

        System.out.println(sum);
    }
}