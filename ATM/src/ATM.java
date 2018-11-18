import java.util.Scanner;

public class ATM {

    private String menu = ("\nMeny\n" + "1: Saldo\n" + "2: Uttak\n" + "3: Innskudd\n" + "4: Avbryt\n");

    private int id = -1;
    private Account[] accounts = new Account[10];
    private Scanner input = new Scanner(System.in);


    ATM() {
        for (int i = 0; i < this.accounts.length; i++) {
            this.accounts[i] = new Account(i, 1000);
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();

        while (true) {
            if (atm.id < 0 || atm.id > atm.accounts.length) {
                atm.askForId();
            }

            System.out.print(atm.menu);
            atm.presentMenu(atm);


        }
    }

        public void askForId() {
            int id = 0;
            while (id < 1 || id > this.accounts.length) {
                System.out.print("Oppgi konto id: ");
                id = this.input.nextInt();
                if (id < 1 || id > this.accounts.length) {
                    System.out.println("Oppgi konto id mellom 1 og 10");
                }


            }
            this.id = --id;
        }




    public void presentMenu(ATM atm) {
        switch (atm.getChoice()) {
            case (1):
                atm.printBalance();
                break;
            case (2):
                atm.withdraw();
                break;
            case (3):
                atm.deposit();
                break;
            case (4):
                atm.id = -1;
                break;
        }
    }

    public int getChoice() {
        int choice = 0;
        while (choice < 1 || choice > 4) {
            System.out.print("Ditt valg? ");
            choice = this.input.nextInt();
            if (choice < 1 || choice > 4) {
                System.out.println("Ugyldig valg");
            }
        }

        return choice;
    }

    public void printBalance() {
        System.out.printf("\nSaldo for konto nr %d er %.02f kr.\n", this.id + 1, this.accounts[id].getBalance());
    }

    public void withdraw() {
        System.out.print("Oppgi uttaksverdi: ");
        double amount = this.input.nextDouble();
        if (!accounts[this.id].withdraw(amount)) {
            System.out.println("Ugyldig operasjon!");
            return;
        }
        System.out.printf("Tatt ut %.02f kr fra konto nr %d\n", amount, this.id + 1);
    }

    public void deposit() {
        System.out.print("Oppgi innskudsverdi: ");
        double amount = this.input.nextDouble();
        if (!accounts[this.id].deposit(amount)) {
            System.out.println("Ugyldig operasjon!");
            return;
        }
        System.out.printf("Satt inn %.02f til konto nr %d\n", amount, this.id + 1);
    }
}

