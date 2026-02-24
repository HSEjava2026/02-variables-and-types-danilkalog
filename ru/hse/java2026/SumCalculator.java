package ru.hse.java2026;

public class SumCalculator {
    public static void main(String[] args) {
        int sum = 0;

        for (String s : args) {
            int i = 0; // будет нашим индексом, которым мы проходимся по строке

            while (i < s.length()) { //проходимся по строке
                char c = s.charAt(i); // преобразовываем по индексу в строке в символ

                if (!Character.isDigit(c) && c != '+' && c != '-') { // если не число и не знак, то пропускаем этот символ
                    i++;
                    continue;
                }



                int start = i; //считаем, что наш символ (либо число, либо знак) является стартовым и за ним может быть ещё числа

                if (c == '+' || c == '-') { // если у нас после числа идет знак, то мы сдвигаем на следующий символ
                    i++;

                    if (i >= s.length() || !Character.isDigit(s.charAt(i))) { // если i за пределами строки (например знак стоит "123-" или на этой позиции не цифра, то возращаемся к циклу while
                        continue;
                    }
                }


                while (i < s.length() && Character.isDigit(s.charAt(i))) { //на этом шаге мы уверены, что у нас будет цифра, поэтому тут i указывает на первую цирфру числа
                    i++; // пока у нас в строке и текущий символ цифра, двигаем i вперёд
                }


                String number = s.substring(start, i); // "вырезаем" наше число

                try {
                    sum += Integer.parseInt(number); // складываем к общей сумме
                } catch (NumberFormatException e) {

                }
            }
        }

        System.out.println(sum);
    }
}