package CardGame;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Game game = new Game();
        // 买牌
        System.out.println("买牌");
        List<Card> list = game.buyCard();
        System.out.println(list);

        System.out.println("===================");

        // 洗牌
        System.out.println("洗牌");
        list = game.shuffles(list);
        System.out.println(list);

        System.out.println("===================");
        // 发牌
        System.out.println("发牌");
        List<List<Card>> ret = game.getCard(list);
        for (int i = 0;i < ret.size();i++) {
            System.out.println(ret.get(i));
        }
        // 剩下的牌
        System.out.println(list);


    }
}
