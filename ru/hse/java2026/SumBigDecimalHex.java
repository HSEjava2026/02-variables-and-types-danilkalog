import java.math.BigDecimal;
import java.math.BigInteger;

public class SumBigDecimalHex {

    public static void main(String[] args) {

        BigDecimal sum = BigDecimal.ZERO;
        int maxScale = 0;

        for (String arg : args) {


            String[] tokens = arg.split("[^0-9a-fA-FxXsS+\\-.]+");

            for (String token : tokens) {

                if (token.isEmpty()) continue;

                token = token.toLowerCase();


                if (token.startsWith("0x")) {

                    String body = token.substring(2);


                    if (body.contains("s")) {

                        String[] parts = body.split("s");
                        if (parts.length != 2) continue;

                        BigInteger mantissa = new BigInteger(parts[0], 16);
                        BigInteger exponent = new BigInteger(parts[1], 16);

                        BigDecimal value = new BigDecimal(mantissa)
                                .scaleByPowerOfTen(-exponent.intValue());

                        sum = sum.add(value);

                    } else {

                        BigInteger value = new BigInteger(body, 16);
                        sum = sum.add(new BigDecimal(value));
                    }

                } else {

                    BigDecimal val = new BigDecimal(token);
                    maxScale = Math.max(maxScale, val.scale());
                    sum = sum.add(val);
                }
            }
        }


        sum = sum.setScale(maxScale);

        System.out.println(sum.toPlainString());
    }
}