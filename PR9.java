import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;

public class PR9 {
    private BigInteger p, q, N, phi, e, d;
    private int bitlength = 1024;
    private Random r;

    public RSA() {
        r = new Random();
        p = BigInteger.probablePrime(bitlength, r);
        q = BigInteger.probablePrime(bitlength, r);
        System.out.println("Prime number p: " + p);
        System.out.println("Prime number q: " + q);

        N = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        e = BigInteger.probablePrime(bitlength / 2, r);
        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0) {
            e = e.add(BigInteger.ONE);
        }
        System.out.println("Public key: " + e);

        d = e.modInverse(phi);
        System.out.println("Private key: " + d);
    }

    public byte[] encrypt(byte[] message) {
        return (new BigInteger(message)).modPow(e, N).toByteArray();
    }

    public byte[] decrypt(byte[] message) {
        return (new BigInteger(message)).modPow(d, N).toByteArray();
    }

    private static String bytesToString(byte[] encrypted) {
        StringBuilder sb = new StringBuilder();
        for (byte b : encrypted) sb.append(b);
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        RSA rsa = new RSA();
        DataInputStream in = new DataInputStream(System.in);

        System.out.print("Enter the plain text: ");
        String testString = in.readLine();

        System.out.println("Encrypting string: " + testString);
        System.out.println("String in bytes: " + bytesToString(testString.getBytes()));

        byte[] encrypted = rsa.encrypt(testString.getBytes());
        byte[] decrypted = rsa.decrypt(encrypted);

        System.out.println("Decrypted Bytes: " + bytesToString(decrypted));
        System.out.println("Decrypted string: " + new String(decrypted));
    }
}
