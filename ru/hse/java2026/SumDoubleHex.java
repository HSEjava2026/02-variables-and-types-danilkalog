public class SumDoubleHex {
    public static void main(String[] args) {
        double sum = 0.0;
        for (String g: args) {
            String [] numbers = g.split("[^0-9a-fA-FxXpP.+-]+");
            for (String f: numbers) {
                if (!b.isEmpty()){
                    String f1 = f;
                    if (f1.toLowerCase().contains("0x") && !f1.toLowerCase().contains("p")) {
                        f1 += "p0";
                    }
                    sum += Double.parseDouble(f1);
                }

            }
        }
        System.out.println(sum);
    }}