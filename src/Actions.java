import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Actions {
    private Pokedeck deck;
    private Scanner input;

    public Actions() {
        this.deck= new Pokedeck();
        input = new Scanner(System.in);
    }

    private int promptInt(){
        boolean done = false;
        int number = 0;
        do {
            try {
                number = input.nextInt();
                done = true;
            }
            catch (InputMismatchException e) {
                System.out.println("Please enter a valid number");
                input.next();
            }
        } while (!done);

        // We consume the /n from the input.nextInt() call, see https://stackoverflow.com/questions/23450524/java-scanner-doesnt-wait-for-user-input
        input.nextLine();

        return number;
    }

    public void displayCards() {
        ArrayList<Card> cards = deck.getCards();

        if (cards.size() == 0) {
            System.out.println("Your Pokedeck is empty");
        }

        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            System.out.println("Card No. " + (i+1) + ":");
            System.out.println(card.toString());
        }
    }

    public void addCard() {
        System.out.println("What type of card do you want to add ?");
        System.out.println("1 - Pokemon card");
        System.out.println("2 - Trainer card");
        System.out.println("3 - Energy card");
        int nb = promptInt();

        String type = "";
        switch (nb) {
            case 1:
                type = "Pokemon";
                break;
            case 2:
                type = "Trainer";
                break;
            case 3:
                type = "Energy";
                break;
            default:
                type = "Pokemon";
        }

        System.out.println("Enter your card's name:");
        String name = input.nextLine();
        while (name.length() == 0) {
            System.out.println("The name can't be empty");
            name = input.nextLine();
        }

        System.out.println("Enter the description of your card:");
        String description = input.nextLine();
        while (description.length() == 0) {
            System.out.println("The descripton can't be empty");
            description = input.nextLine();
        }

        Card card = null;
        if (type == "Pokemon") {
            card = createPokemonCard(name, description);
        }
        else if (type == "Energy") {
            card = createEnergyCard(name, description);
        }
        else if (type == "Trainer") {
            card = createTrainerCard(name, description);
        }

        deck.addCard(card);
        System.out.println("Your card was successfully added to your deck !");
    }

    private Card createPokemonCard(String name, String description) {
        System.out.println("Enter your Pokemon's HP:");
        int hp = promptInt();

        System.out.println("Enter your Pokemon's type");
        String type = input.nextLine();
        while (type.length() == 0) {
            System.out.println("The type can't be empty");
            type = input.nextLine();
        }

        return new PokemonCard(name, description, hp, type);
    }

    private Card createEnergyCard(String name, String description) {
        System.out.println("Enter your Energy card's type");
        String type = input.nextLine();
        while (type.length() == 0) {
            System.out.println("The type can't be empty");
            type = input.nextLine();
        }

        return new EnergyCard(name, description, type);
    }

    private Card createTrainerCard(String name, String description) {
        return new TrainerCard(name, description);
    }

    public void removeCard() {
        if (deck.getCards().size() == 0) {
            System.out.println("Your deck is empty");
            return;
        }

        System.out.println("Enter the number of the card you want to remove, or enter 0 to go back:");

        int cardNumber = promptInt();

        if (cardNumber == 0) {
            return;
        }
        if (cardNumber >= 1 && cardNumber <= deck.getCards().size()) {
            deck.removeCard((cardNumber-1));
            System.out.println("The card was removed from you deck");
        }
    }

    public void editCard() {
        if (deck.getCards().size() == 0) {
            System.out.println("Your deck is empty");
            return;
        }

        System.out.println("Enter the number of the card you want to edit, or enter 0 to go back:");

        int cardNumber = promptInt();

        if (cardNumber == 0) {
            return;
        }
        if (cardNumber >= 1 && cardNumber <= deck.getCards().size()) {
            Card card = deck.getCard((cardNumber-1));

            System.out.println("Editing card No. " + cardNumber + ", " + card.getCardType() + " card");
            System.out.println("0 - Go back");
            System.out.println("1 - Name");
            System.out.println("2 - Description");
            if (card.getCardType() == "Pokemon" || card.getCardType() == "Energy") {
                System.out.println("3 - Type");
            }
            if (card.getCardType() =="Pokemon") {
                System.out.println("4 - HP");
            }

            int choice = promptInt();

            if (choice == 0) return;

            int maxChoice = 2;

            switch (card.getCardType()) {
                case "Pokemon":
                    maxChoice = 4;
                    break;
                case "Energy":
                    maxChoice = 3;
                    break;
            }

            while (choice < 1 || choice > maxChoice) {
                choice = promptInt();
                System.out.println("Enter a valid number");
            }

            String toEdit = "";
            switch(choice) {
                case 1:
                    toEdit = "name";
                    break;
                case 2:
                    toEdit = "description";
                    break;
                case 3:
                    toEdit = "type";
                    break;
                case 4:
                    toEdit = "hp";
                    break;
            }

            System.out.println("Type the new value");
            if (toEdit == "hp") {
                int content = input.nextInt();
                input.nextLine();
                deck.editCard((cardNumber-1), toEdit, content);
            }
            else {
                String content = input.nextLine();
                deck.editCard((cardNumber-1), toEdit, content);
            }
        }
    }

    public void searchCard() {
        ArrayList<Card> cards = deck.getCards();

        System.out.println("Search a card");
        System.out.println("1 - By name");
        System.out.println("2 - By number");

        int choice = promptInt();

        if (choice == 1) {
            System.out.println("Type the name you want to search for:");
            String search = input.nextLine();
            cards.removeIf(c -> !c.getCardName().contains(search));
            if (cards.size() > 0) {
                System.out.println("Results:");
                for (int i = 0; i < cards.size(); i++) {
                    Card card = cards.get(i);
                    System.out.println((i+1) + ":");
                    System.out.println(card.toString());
                }
            }
            else {
                System.out.println("No results for this search");
            }
        }
        else if(choice == 2) {
            System.out.println("Type the number you want to search for:");
            int search = promptInt();
            if (search >= 1 && search <= cards.size()) {
                System.out.println(cards.get((search-1)).toString());
            }
            else {
                System.out.println("This card does not exist");
            }

        }
    }

    public void save() {
        deck.save();
        System.out.println("Your deck has been saved");
    }
}
