import java.io.*;
import java.util.ArrayList;

public class Pokedeck implements Serializable {
    private ArrayList<Card> cards;

    public Pokedeck() {
        Pokedeck p = this.load();
        if (p != null) {
            this.cards = p.getCards();
        }
        else {
            this.cards = new ArrayList<Card>();
        }
    }

    private Pokedeck load() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("pokedeck");
        } catch (FileNotFoundException e) {
            return null;
        }
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(fis);
        } catch (IOException e) {
            return null;
        }
        try {
            return (Pokedeck) ois.readObject();
        } catch (IOException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
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

    public Card getCard(int id) {
        return cards.get(id);
    }

    public void editCard(int id, String type, String content) {
        cards.get(id).editCard(type, content);
    }

    public void editCard(int id, String type, int content){
        cards.get(id).editCard(type, content);
    }

    public void save() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("pokedeck");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectOutputStream oos= null;
        try {
            oos = new ObjectOutputStream(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
