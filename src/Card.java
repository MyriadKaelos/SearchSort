public class Card {

    int num;
    int suit;

    public Card(int num, int suit) {
        this.num = num;
        this.suit = suit;
    }
    public String stringify() {
        String face;
        if(num == 1) {
            face = "Ace";
        } else if(num == 11) {
            face = "Jack";
        } else if(num == 12) {
            face = "Queen";
        } else if(num == 13) {
            face = "King";
        } else {
            face = Integer.toString(num);
        }
        if(suit == 1) {
            return face + " of Clubs";
        } else if(suit == 2) {
            return face + " of Diamonds";
        } else if(suit == 3) {
            return face + " of Hearts";
        } else {
            return face + " of Spades";
        }
    }

}
