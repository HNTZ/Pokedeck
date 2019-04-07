import java.lang.reflect.Array;
import java.util.ArrayList;

public class Pokedeck {
    private ArrayList<Card> cards;

    public Pokedeck() {
        this.cards = new ArrayList<Card>();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void removeCard(int id) {
        cards.remove(id);
    }

    public void editCard(int id, String description) {
        cards.get(id).setCardDescription(description);
    }
}
