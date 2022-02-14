import java.util.Scanner;
import java.util.InputMismatchException;

class Variables{
     int totalBalance = 500000;
     int AtmPin, num;;
     char ch = '\u0000';
     int choice;
}

class Method{
    Variables var = new Variables();
    Scanner sc = new Scanner(System.in);
    int newPin;

    void ChangeATMPin(){
        
        System.out.println("\n enter new pin:  ");
        newPin = sc.nextInt();

        System.out.println("\n pin code changed successfully");

        ATMPin();
    }

    void ATMPin(){
        System.out.println("\n Please enter pin: ");
        var.AtmPin = sc.nextInt();
        try {
            if(!(var.AtmPin == newPin)){
                System.out.println("\n invalid pin ");
                System.exit(0);
            }else{
                System.out.println("\n welcome to atm machine ");
            }
        } catch (InputMismatchException e) {
            //TODO: handle exception
            System.out.println(e);
        }
        MainMethod();
    }

    boolean checkingNegative(){
        System.out.println("\n enter amount ");
        var.num = sc.nextInt();

        if(var.num <= 0){
            System.out.println("\n the amount cannot be zero or negative ");
            return false;
        }else{
            return true;
        }
    }

    void WithdrwalAmount(){
        if(checkingNegative()){
            var.totalBalance -= var.num;
            System.out.println("\n amount debited");

            try {
                Thread.sleep(600);
                System.out.println("\n please collect your cash  ");
                System.out.println("\n Remaining balance is "+var.totalBalance);
            } catch (InterruptedException e) {
                //TODO: handle exception
                System.out.println(e);
            }
        }
    }


    void BalanceCheck(){
        System.out.println("\n your current balance is "+ var.totalBalance);
    }

    void DepositAmount(){
        if(checkingNegative()){
            var.totalBalance += var.num;
            
            try {      
                Thread.sleep(600);
                System.out.println("\n Amount deposited successfully ");
                System.out.println("\n now your current balance is "+ var.totalBalance);
    
            } catch (InterruptedException e) {
                //TODO: handle exception
                System.out.println(e);
            } 
        }
    }

    void ExitProgram(){
        System.exit(0);
    }

    void MainMethod(){

        do{
            System.out.println("\n\n \t1.Withdraw");
            System.out.println("\t2.Balance view");
            System.out.println("\t3.Change ATM pin");
            System.out.println("\t4.Deposit");
            System.out.println("\t5.Exit");
            System.out.println("\n \tEnter your choice:  ");
            var.choice = sc.nextInt();

            switch(var.choice){
                case 1: WithdrwalAmount();break;
                case 2: BalanceCheck();break;
                case 3: ChangeATMPin();break;
                case 4: DepositAmount();break;
                case 5: ExitProgram();break;
                default:System.out.println("invalid choice ");
            }
            System.out.println("\n Continue(y/n)  ");
            var.ch = sc.next().toCharArray()[0];
        }while(var.ch == 'y' || var.ch == 'Y');
    }
}

public class WorkingOfAtm{
    public static void main(String args[]){
        
        Method mth = new Method();
        System.out.println("\n \t Welcome to Automated Teller Machine ");
        
        mth.ChangeATMPin(); 
    }
}