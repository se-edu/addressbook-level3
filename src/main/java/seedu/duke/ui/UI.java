package seedu.duke.ui;

import java.util.Scanner;

public class UI {
    public String enterUsername() {
        System.out.println("\nEnter your one word username (case sensitive!!!) to begin: \n");
        Scanner in = new Scanner(System.in);
        String username = in.nextLine().trim();

        while (username.contains(" ")) {
            System.out.println("\nUsername must be one word!\n" +
                    "\nEnter your one word username (case sensitive!!!) to begin: \n");

            username = in.nextLine().trim();
        }

        return username;
    }

    public void showWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("\nHello from\n" + logo);
    }

    public String readUserInput() {
        Scanner in = new Scanner(System.in);

        return in.nextLine();
    }

    public void showLine() {
        System.out.println("__________________________________________________________" +
                "__________________________________________");
    }
}

