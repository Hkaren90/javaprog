import java.util.Scanner;

public class PR10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] packets = new int[20];
        int bucketRemaining = 0, bucketCapacity = 4, rate = 3, sent, recv;

        System.out.print("Enter the number of packets: ");
        int n = in.nextInt();

        System.out.println("Enter the packets:");
        for (int i = 1; i <= n; i++) packets[i] = in.nextInt();

        System.out.println("Clock\tPacket Size\tAccept\tSent\tRemaining");
        for (int i = 1; i <= n; i++) {
            if (packets[i] != 0) {
                if (bucketRemaining + packets[i] > bucketCapacity) {
                    recv = -1;
                } else {
                    recv = packets[i];
                    bucketRemaining += packets[i];
                }
            } else recv = 0;

            if (bucketRemaining != 0) {
                if (bucketRemaining < rate) {
                    sent = bucketRemaining;
                    bucketRemaining = 0;
                } else {
                    sent = rate;
                    bucketRemaining -= rate;
                }
            } else sent = 0;

            if (recv == -1)
                System.out.println(i + "\t" + packets[i] + "\tDropped\t" + sent + "\t" + bucketRemaining);
            else
                System.out.println(i + "\t" + packets[i] + "\t" + recv + "\t" + sent + "\t" + bucketRemaining);
        }
        in.close();
    }
}
