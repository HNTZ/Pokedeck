import java.util.Scanner;

public class Menu {
    private Actions actions;

    public Menu() {
        actions = new Actions();
        System.out.println("Welcome to your Pokedeck !");
        this.displayChoices();
    }

    private void displayChoices() {
        System.out.println("----------------------------------------------------------");
        // Displays all the actions and executes the one chosen
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter a number to execute one of the actions below:");
        System.out.println("1 - Display your cards");
        System.out.println("2 - Add a new card ");
        System.out.println("3 - Edit a card ");
        System.out.println("4 - Remove a card ");
        System.out.println("5 - Search a card");
        System.out.println("6 - Save");
        System.out.println("7 - Exit");

        int action = input.nextInt();
        System.out.println("----------------------------------------------------------");

        this.executeAction(action);
    }

    private void quickMenu() {
        System.out.println("----------------------------------------------------------");
        Scanner input = new Scanner(System.in);
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
        while(action < 1 || action > 7) {
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
                actions.editCard();
                break;
            case 4:
                actions.removeCard();
                break;
            case 5:
                actions.searchCard();
                break;
            case 6:
                 actions.save();
                 break;
            case 7:
                System.exit(0);
        }
        this.quickMenu();
    }
}
