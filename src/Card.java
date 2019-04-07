public class Card {
    protected String cardName;
    protected String cardDescription;

    public Card(String cardName, String cardDescription) {
        this.cardName = cardName;
        this.cardDescription = cardDescription;
    }

    public void setCardDescription(String cardDescription) {
        this.cardDescription = cardDescription;
    }

    public String getCardDescription() {
        return this.cardDescription;
    }
}
