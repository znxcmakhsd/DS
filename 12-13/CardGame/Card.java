package CardGame;

public class Card {
    public String suit;
    public int number;

    public Card(String suit,int number) {
        this.suit = suit;
        this.number = number;
    }

    @Override
    public String toString() {
        return suit+number;
    }
}
