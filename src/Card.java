import java.io.Serializable;

public class Card implements Serializable {
    protected String cardName;
    protected String cardDescription;
    protected String cardType;

    public Card(String cardName, String cardDescription, String cardType) {
        this.cardName = cardName;
        this.cardDescription = cardDescription;
        this.cardType = cardType;
    }

    public void editCard(String toEdit, String content) {
        if (toEdit == "name") {
            cardName = content;
        }
        else if (toEdit == "description") {
            cardDescription = content;
        }
    }

    public void editCard(String toEdit, int content) {}

    public String getCardName() {
        return this.cardName;
    }

    public String getCardType() {
        return this.cardType;
    }

    public String toString(){
        String text = cardType + " card" + "\n";
        text += "Name: " + cardName + "\n";
        text += "Description: " + cardDescription + "\n";
        return text;
    };
}
