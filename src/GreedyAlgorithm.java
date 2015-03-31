public class GreedyAlgorithm {

  int minCoins(int value) {
    int denoms[] = { 1, 5, 10, 25, 100, 200 };
    int totalCoins = 0;
    // Iterate backwards by highest denomination.
    for (int i = denoms.length; i >= 0; i--) {
      // Calculate highest number of coins that can be used.
      int coins = value / denoms[i];
      // Increment number of coins.
      totalCoins += coins;
      // Subtract value of coins.
      value -= denoms[i] * coins;
    }
    return totalCoins;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
