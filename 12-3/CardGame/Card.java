package CardGame;

public class Card {
    public String suit; // 牌的花色
    public int number; // 牌的游戏

    public Card(String suit, int number) {
        this.suit = suit;
        this.number = number;
    }

    @Override
    public String toString() {
        return ""+this.suit+this.number;
    }
}
