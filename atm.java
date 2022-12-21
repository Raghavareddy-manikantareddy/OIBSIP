import java.util.Scanner;
import java.io.*;
public class atm {
static String user_id,user_pwd;
static int user_pin;
static int acc_no,trans_count=0;
static float balance=10000f;
static String History="";
static boolean flag=false;
static Scanner sc =new Scanner(System.in);

public static void register() {
System.out.println("\nEnter your username :");
user_id=sc.next();
System.out.println("\nEnter your password :");
user_pwd=sc.next();
System.out.println("\nEnter your 4-digit ATM pin :");
user_pin=sc.nextInt();

System.out.println("You registered successfully!!");
}

public static void login() {
System.out.println("\nEnter your ATM pin :");
int pin_no=sc.nextInt();
if(pin_no==user_pin) {
System.out.println("\nYou logged in Successfully");
flag=true;
}
else{
    System.out.println("please collect your card");
    System.exit(0);
}
}

public static void deposit() {
System.out.print("\nEnter the amount you want to Deposit  :");
float dep_amount=sc.nextFloat();
balance+=dep_amount;
System.out.println("\nAfter Depositing "+dep_amount+" Rupees your current balance is "+balance+" Rupees");
trans_count+=1;
History=History.concat(dep_amount+" Rupees deposited into your account\n");
}

public static void withdraw() {
System.out.println("\nEnter the amount you want to Withdraw  :");
float withdr_amount=sc.nextFloat();
if(withdr_amount<=balance) {
balance-=withdr_amount;
System.out.println("\nAfter withdrawing "+withdr_amount+" Rupees your current balance is "+balance+" Rupees");
trans_count+=1;
History=History.concat(withdr_amount+" Rupees withdrawn from your account\n");
}
else {
System.out.println("\nSorry you can't withdraw!! INSUFFICIENT FUNDS");
}
}

public static void transfer() {
System.out.println("\nEnter the Account number of person to whom you want to transfer :");
int tran_acc=sc.nextInt();
System.out.println("\nEnter the amount you want to Transfer :");
float tran_amount=sc.nextFloat();
if(tran_amount<=balance) {
System.out.println("\n "+tran_amount+" Rupees is successfully transferred to account number "+tran_acc);
balance-=tran_amount;
trans_count+=1;
History=History.concat(tran_amount+" Rupees tranferred from your account\n");
}
else {
System.out.println("Sorry money transfer is not possible! INSUFFICIENT FUNDS");
}
}

public static void tot_bal() {
System.out.println("\nYour Current Balance is "+balance+" Rupees");
}

public static void trans_His() {
if(trans_count>0) {
System.out.println("\nYou have performed "+trans_count+" transactions.");

System.out.println("\nTransaction Details:");
System.out.print(History);
}
else {
System.out.println("\nNo Transactions are performed.");
}
}

public static void main(String args[]) {
System.out.println("\nWELCOME TO ATM");
System.out.println("\nchoose one option!");
System.out.println("\n1.REGISTER\n2.EXIT");
int opt=sc.nextInt();
if(opt==1) {
register();
System.out.println("\nchoose one option!");
System.out.println("\n1.LOGIN\n2.EXIT");
int ch=sc.nextInt();
if(ch==1) {
login();
while(flag==true) {
System.out.println("\nchoose one option!");
System.out.println("\n1.DEPOSIT\n2.WITHDRAW\n3.TRANSFER\n4.TRANSACTION HISTORY\n5.CHECK BALANCE\n6.EXIT");
int choice=sc.nextInt();
switch(choice) {
    case 1:deposit();
    break;
    case 2:withdraw();
    break;
    case 3:transfer();
    break;
    case 4:trans_His();
    break;
    case 5:tot_bal();
    break;
    case 6:flag=false;
    System.out.println("\nplease collect your card");
    break;
    default:System.out.println("Please select an option from 1 to 6");
}
}
}
else{
System.out.println("please collect your card");
System.exit(0);
}
}
else {
System.out.println("please collect your card");
System.exit(0);
}
}
}