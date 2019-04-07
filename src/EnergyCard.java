public class EnergyCard extends Card {
    private String type;

    public EnergyCard(String cardName, String cardDescription, String type) {
        super(cardName, cardDescription, "Energy");
        this.type = type;
    }

    public String toString() {
        String text = super.toString();
        text += "Type: " + type +"\n";
        return text;
    }

    public void editCard(String toEdit, String content) {
        super.editCard(toEdit, content);
        if (toEdit == "type") {
            type = content;
        }
    }
}
