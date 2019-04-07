import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Actions {
    private Pokedeck deck;
    private Scanner input;

    public Actions(Pokedeck deck) {
        this.deck= deck;
        input = new Scanner(System.in);
    }

    public void displayCards() {
        ArrayList<Card> cards = deck.getCards();

        if (cards.size() == 0) {
            System.out.println("Your Pokedeck is empty");
        }

        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            System.out.println("Card No. " + (i+1) + ":");
            System.out.println("   Name: " + card.cardName);
            System.out.println("   Description: " + card.cardDescription);
        }
    }

    public void addCard() {

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

        Card card = new Card(name, description);
        deck.addCard(card);
        System.out.println("Your card was successfully added to your deck !");
    }

    public void removeCard() {
        if (deck.getCards().size() == 0) {
            System.out.println("Your deck is empty");
            return;
        }

        System.out.println("Enter the number of the card you want to remove, or enter 0 to go back:");

        int cardNumber = cardNumberInDeck();

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

        int cardNumber = cardNumberInDeck();

        if (cardNumber == 0) {
            return;
        }
        if (cardNumber >= 1 && cardNumber <= deck.getCards().size()) {
            System.out.println("Enter the new description of the card");
            String description = input.nextLine();
            deck.editCard((cardNumber-1), description);
        }
    }

    private int cardNumberInDeck(){
        boolean done = false;
        int cardNumber = 0;
        do {
            try {
                cardNumber = input.nextInt();
                done = true;
            }
            catch (InputMismatchException e) {
                System.out.println("Please enter a valid number");
                input.next();
            }
        } while (!done);
        return cardNumber;
    }
}
