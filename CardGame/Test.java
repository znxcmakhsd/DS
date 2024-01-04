package CardGame;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Game game = new Game();
        List<Card> ret = game.buyCard();
        System.out.println(ret);

        System.out.println();
        List<Card> cards = game.shuffles(ret);
        System.out.println(cards);

        System.out.println("牌的数量: " + cards.size());
        List<List<Card>> array = game.getCard(cards);
        System.out.println(array);
        System.out.println("牌的数量: " + cards.size());

    }
}
