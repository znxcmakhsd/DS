package CardGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    public static final String[] suits = {"♥","♣","♦","♠"};

    // 1. 买牌 —— 生成 一副 52张扑克牌
    public List<Card> buyCard() {
        List<Card> cardList = new ArrayList<>();

        for (int i = 0;i < 4;i++) {
            String suit = this.suits[i];
            for (int j = 1;j <= 13;j++) {
                Card card = new Card(suit,j);
                cardList.add(card);
            }
        }
        return cardList;
    }
    // 2. 洗牌 —— 使用交换方式
    public List<Card> shuffles(List<Card> cardList) {
        Random random = new Random();
        for (int i = cardList.size()-1;i > 0;i--) {
            int index = random.nextInt(i);
            swap(cardList,i,index);
        }
        return cardList;
    }
    private void swap(List<Card> cardList,int i,int index) {
        Card tmp = cardList.get(i);
        cardList.set(i,cardList.get(index));
        cardList.set(index,tmp);
    }

    // 3. 发牌
    public List<List<Card>> getCard(List<Card> cardList) {
        List<Card> hand1 = new ArrayList<>();
        List<Card> hand2 = new ArrayList<>();
        List<Card> hand3 = new ArrayList<>();

        List<List<Card>> list = new ArrayList<>();
        list.add(hand1);
        list.add(hand2);
        list.add(hand3);

        for (int i = 0;i < 5;i++) {
            for (int j = 0;j < 3;j++) {
                List<Card> hand = list.get(j);
                Card card = cardList.remove(0);
                hand.add(card);
            }
        }
        return list;
    }
}
