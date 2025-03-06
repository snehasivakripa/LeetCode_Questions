public class BinaryCount {
        public static void main(String[] args) {
            int number = 4;
            String binary = decimalToBinary(number);
            System.out.println("Binary representation of " + number + " is: " + binary);
        }

        public static String decimalToBinary(int number) {


            StringBuilder binary = new StringBuilder();
            int n=number;
            while(n>=0) {
                number=n;

                int count = 0;

                while (number > 0) {
                    if (number % 2 == 1) count++;
                    number = number / 2;        // Divide number by 2
                }
                binary.append(count);
                n--;
            }
            return binary.reverse().toString();
        }

}
