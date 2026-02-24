public class Sum {
    public static void main(String[] args) {
        int sum = 0;

        for (String s : args) {          // перебираем все аргументы командной строки
            int i = 0;

            while (i < s.length()) {
                char c = s.charAt(i);

                // если это не цифра и не знак, просто пропускаем символ
                if (!Character.isDigit(c) && c != '+' && c != '-') {
                    i++;
                    continue;
                }

                // предполагаем, что здесь начинается число
                int start = i;

                // если первый символ — знак
                if (c == '+' || c == '-') {
                    i++;  // переходим к следующему символу

                    // если сразу после знака нет цифры — это не число
                    if (i >= s.length() || !Character.isDigit(s.charAt(i))) {
                        continue;   // вернёмся в while, но уже с новым i
                    }
                }

                // теперь i стоит на первой цифре числа
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    i++;
                }

                // вырезаем подстроку с числом
                String number = s.substring(start, i);

                try {
                    sum += Integer.parseInt(number);
                } catch (NumberFormatException e) {
                    // если вдруг число слишком большое или странное — просто игнорируем
                }
            }
        }

        System.out.println(sum);
    }
}