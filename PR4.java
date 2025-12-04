import java.util.Scanner;

public class PR4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter message bits: ");
        String message = sc.nextLine();
        System.out.print("Enter generator: ");
        String generator = sc.nextLine();

        int[] data = new int[message.length() + generator.length() - 1];
        int[] divisor = new int[generator.length()];

        for (int i = 0; i < message.length(); i++) data[i] = message.charAt(i) - '0';
        for (int i = 0; i < generator.length(); i++) divisor[i] = generator.charAt(i) - '0';

        // CRC calculation
        for (int i = 0; i < message.length(); i++)
            if (data[i] == 1)
                for (int j = 0; j < divisor.length; j++) data[i + j] ^= divisor[j];

        // Append CRC
        System.out.print("The checksum code is: ");
        for (int i = 0; i < message.length(); i++) data[i] = message.charAt(i) - '0';
        for (int bit : data) System.out.print(bit);
        System.out.println();

        // Validation
        System.out.print("Enter checksum code: ");
        message = sc.nextLine();
        System.out.print("Enter generator: ");
        generator = sc.nextLine();

        data = new int[message.length() + generator.length() - 1];
        divisor = new int[generator.length()];
        for (int i = 0; i < message.length(); i++) data[i] = message.charAt(i) - '0';
        for (int i = 0; i < generator.length(); i++) divisor[i] = generator.charAt(i) - '0';

        for (int i = 0; i < message.length(); i++)
            if (data[i] == 1)
                for (int j = 0; j < divisor.length; j++) data[i + j] ^= divisor[j];

        boolean valid = true;
        for (int bit : data) if (bit == 1) { valid = false; break; }

        System.out.println(valid ? "Data stream is valid" : "Data stream is invalid. CRC error occurred.");
    }
}
