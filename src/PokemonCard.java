public class PokemonCard extends Card {
    private int healthPoints;
    private String type;

    public PokemonCard(String cardName, String cardDescription, int HealthPoints, String type) {
        super(cardName, cardDescription, "Pokemon");
        this.healthPoints = HealthPoints;
        this.type = type;
    }

    public String toString() {
        String text = super.toString();
        text += "Type: " + type + "\n";
        text += "HP: " + healthPoints + "\n";
        return text;
    }

    public void editCard(String toEdit, String content) {
        super.editCard(toEdit, content);
        if (toEdit == "type") {
            type = content;
        }
    }

    public void editCard(String toEdit, int content) {
        if (toEdit == "hp") {
            healthPoints = content;
        }
    }
}
