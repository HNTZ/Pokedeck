import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private Pokedeck deck;
    private Actions actions;

    public Menu(Pokedeck deck) {
        actions = new Actions(deck);
        System.out.println("Welcome to your Pokedeck !");
        this.displayChoices();
    }

    private void displayChoices() {
        // Displays all the actions and executes the one chosen
        Scanner input = new Scanner(System.in);

        System.out.println("----------------------------------------------------------");
        System.out.println("Please enter a number to execute one of the actions below:");
        System.out.println("1 - Display your cards");
        System.out.println("2 - Add a new card ");
        System.out.println("3 - Edit a card ");
        System.out.println("4 - Remove a card ");

        int action = input.nextInt();

        System.out.println("----------------------------------------------------------");

        this.executeAction(action);
    }

    private void quickMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("----------------------------------------------------------");
        System.out.println("Enter a number to execute an action, or enter 0 to have all your actions displayed again");

        int action = input.nextInt();

        System.out.println("----------------------------------------------------------");

        if (action == 0) {
            this.displayChoices();
        }
        else {
            this.executeAction(action);
        }
    }

    private void executeAction(int action) {
        while(action != 1 && action != 2 && action != 3 && action != 4) {
            System.out.println("This action does not exist");
            Scanner input = new Scanner(System.in);
            action = input.nextInt();
        }
        switch(action) {
            case 1:
                actions.displayCards();
                break;
            case 2:
                actions.addCard();
                break;
            case 3:
                actions.removeCard();
                break;
            case 4:
                actions.editCard();
                break;
        }
        this.quickMenu();
    }
}
