import java.util.InputMismatchException;
import java.util.Scanner;

class ATM {

    static Scanner input = new Scanner(System.in);

    // local variable
    static int balance = 0;

    static int choice;
    static int depositAmount;
    static int withdrawAmount;

    public static int checkValidInput(String msg) {
        int inputValue = 0;
        boolean checkIfValid = false;

        while(!checkIfValid) {
            System.out.print(msg);
            try {
                inputValue = input.nextInt();
                checkIfValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Do not input words/letters. Please input again.");
                input.next(); 
            }
        }
        return inputValue;
    }

    public static void deposit() {
        depositAmount = checkValidInput("Enter the amount to deposit: ");

        if(depositAmount <= 0) {
            System.out.println("Invalid deposit amount. Please enter an amount greater than 0.");
        } else {
            balance += depositAmount;
            System.out.println("Deposit successful! Your new balance is: " + balance);
        }
    }

    public static void withdraw() {
        withdrawAmount = checkValidInput("Enter the amount to withdraw: ");
        
        if (withdrawAmount <= 0) {
            System.out.println("Invalid withdraw amount. Please enter an amount greater than 0.");
        } else if(withdrawAmount > balance) {
            System.out.println("Insufficient balance. Your current balance is: " + balance);
        } else {
            balance -= withdrawAmount;
            System.out.println("Withdrawal successful! Your new balance is: " + balance);
        }
    }

    public static void checkBalance() {
        System.out.println("Your current balance is: " + balance);
    }

    public static void main(String[] args) {
        System.out.println("------------------------------------");
        System.out.println("Welcome to Simple ATM using JAVA...");
        do {
            System.out.println("------------------------------------");
            System.out.println("1. Deposit\n2. Withdraw\n3. Check balance\n4. Exit");
            System.out.println("------------------------------------");
            System.out.print("Enter your choice: ");
            try {
                choice = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Do not input a words/letter. Please input again.");
                input.next();
                continue;
            }
            System.out.println("------------------------------------");

            switch(choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using ATM.");
                    System.out.println("------------------------------------");
                    System.exit(0);
                    break;
                default:
                    System.out.print("Invalid choice.");
            }
        } while(true);
    }   
}
