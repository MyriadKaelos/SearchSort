public class Runner {
    public static void main(String[] args) {
        Deck d = new Deck(true);
        d.shuffle();
        d.dealHand(7);
        d.merge();
        d.binSer(3);
    }
}