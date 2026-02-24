public class Sum {
    public static void main(String[] args) {
        int sum = 0;

        for (String s : args) {
            int i = 0;

            while (i < s.length()) {
                char c = s.charAt(i);

                if (!Character.isDigit(c) && c != '+' && c != '-') {
                    i++;
                    continue;
                }

                int start = i;

                if (c == '+' || c == '-') {
                    i++;


                    if (i >= s.length() || !Character.isDigit(s.charAt(i))) {
                        continue;
                    }
                }

                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    i++;
                }

                String number = s.substring(start, i);

                try {
                    sum += Integer.parseInt(number);
                } catch (NumberFormatException e) {
                }
            }
        }

        System.out.println(sum);
    }
}