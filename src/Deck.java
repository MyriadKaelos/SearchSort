
import java.util.Arrays;
import java.util.Collections;

public class Deck {
    Card[] hand;
    static Card[] allCards;

    public Deck(boolean suit) {
        if(suit) {
            allCards = new Card[52];
        } else {
            allCards = new Card[13];
        }
        for (int i = 0; i < allCards.length; i++) {
            allCards[i] = new Card(i % 13 + 1, (i + 1) % 4);
        }
    }
    public void stringify() {
        for(int c = 0; c < allCards.length; c++) {
            System.out.println(allCards[c].stringify());
        }
    }
    public static void swap(Card[] cards, Card[] cards2, int first, int second) {
        Card save = cards[first];
        cards[first] = cards2[second];
        cards2[second] = save;
    }
    public void dealHand(int numCard) {
        hand = new Card[numCard];
        for(int c = 0; c < numCard; c++) {
            hand[c] = allCards[c];
            System.out.println(hand[c].stringify());
        }
    }
    public void listHand() {
        for(int c = 0; c < hand.length; c++) {
            System.out.println(hand[c].stringify());
        }
    }
    public void shuffle() {
        Collections.shuffle(Arrays.asList(allCards));
    }
    public void bubbleSortHand() {
        for(int d = 0; d < hand.length - 1; d++) {
            for (int c = 0; c < hand.length - 1 - d; c++) {
                if (hand[c].num > hand[c + 1].num) {
                    swap(hand, hand, c, c + 1);
                }
            }
        }
    }
    public void selectionSort() {
        for(int d = 0; d < hand.length - 1; d++) {
            for(int c = d; c < hand.length - 1; c++) {
                if(hand[d].num > hand[c].num) {
                    swap(hand,hand, d, c);
                }
            }
        }
    }
    public void merge() {
        hand = mergeSort(hand);
        listHand();
    }
    public Card[] mergeSort(Card[] arr3) {
        if(arr3.length == 1) {
            return arr3;
        }
        int a = 0;
        Card[] arr1 = mergeSort(Arrays.copyOfRange(arr3,Math.round(arr3.length/2),arr3.length));
        Card[] arr2 = mergeSort(Arrays.copyOfRange(arr3,0,Math.round(arr3.length/2)));
        Card[] nArr = new Card[arr3.length];
        for(int d = 0; d < nArr.length; d++) {
            nArr[d] = new Card(14,3);
        }
        while(nArr[nArr.length -1].num > 13) {
            if (findSmall(arr1) < findSmall(arr2)) {
                swap(arr1, nArr, findSmallIndex(arr1), a);
                a++;
            } else {
                swap(arr2, nArr, findSmallIndex(arr2), a);
                a++;
            }
        }
        return nArr;
    }
    public int findSmall(Card[] arr) {
        int c = 14;
        int b = 0;
        for(int d = 0; d < arr.length; d++) {
            if(arr[d].num < c) {
                c = arr[d].num;
                b = d;
            }
        }
        return arr[b].num;
    }
    public int findSmallIndex(Card[] arr) {
        int c = 14;
        int b = 0;
        for(int d = 0; d < arr.length; d++) {
            if(arr[d].num < c) {
                c = arr[d].num;
                b = d;
            }
        }
        return b;
    }
    public void binSer(int ser) {
        binarySearch(hand,ser);
    }
    public void binarySearch(Card[] arr, int ser) {
        if(arr.length == 1) {
            System.out.println(ser == arr[0].num);
        } else if(arr[Math.round(arr.length/2)].num > ser) {
            binarySearch(Arrays.copyOfRange(arr,0,Math.round(arr.length/2)),ser);
        } else {
            binarySearch(Arrays.copyOfRange(arr,Math.round(arr.length/2),arr.length),ser);
        }
    }
}
