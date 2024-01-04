package CardGame;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    public String[] suits = {"♥","♣","♦","♠"};

    // 1. 买牌 —— 生成一副52张扑克牌
    public List<Card> buyCard() {
        List<Card> list = new ArrayList<>();
        for (int i = 0;i < 4;i++) {
            for (int j = 1;j <= 13;j++) {
                Card card = new Card(suits[i],j);
                list.add(card);
            }
        }
        return list;
    }

    // 2. 洗牌 —— 使用交换方式
    public List<Card> shuffles(List<Card> list) {
        Random random = new Random();
        // 交换51次
        for (int i = list.size()-1;i > 0;i--) {
            int index = random.nextInt(i); // 得到[0,i)之间的随机值
            // 交换
            swap(list,i,index);
        }
        return list;
    }
    private void swap(List<Card> list,int src,int dst) {
        Card tmp = list.get(src);
        list.set(src,list.get(dst));
        list.set(dst,tmp);
    }
    // 3. 发牌
    // 把牌发到三个人手中
    public List<List<Card>> getCard(List<Card> list) {
        List<Card> hand1 = new ArrayList<>();
        List<Card> hand2 = new ArrayList<>();
        List<Card> hand3 = new ArrayList<>();
        List<List<Card>> retArray = new ArrayList<>();
        retArray.add(hand1);
        retArray.add(hand2);
        retArray.add(hand3);

        // 轮流发牌 每一个人5张牌
        for (int i = 0;i < 5;i++) {
            for (int j = 0;j < 3;j++) {
                List<Card> hand = retArray.get(j);
                hand.add(list.remove(0));
            }
        }
        return retArray;
    }
}
