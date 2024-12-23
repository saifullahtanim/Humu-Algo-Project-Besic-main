import java.util.Scanner;

public class CoinChange {
    // Define the coin denominations
    static final int[] coins = {1, 5, 10, 25, 50};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Precompute the number of ways for all amounts up to 7489
        int maxAmount = 7489;  // Defined as the maximum constraint
        long[] ways = new long[maxAmount + 1];
        ways[0] = 1;  // There's one way to make 0 amount, by choosing no coins

        // Calculate ways for each denomination
        for (int coin : coins) {
            for (int j = coin; j <= maxAmount; j++) {
                ways[j] += ways[j - coin];
            }
        }

        // Input reading and processing
        while (scanner.hasNextInt()) {
            int amount = scanner.nextInt();
            System.out.println(ways[amount]);
        }
        
        scanner.close();
    }
}
