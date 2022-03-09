package com.company;
import java.util.Scanner;

public class FoolCheck {
    private Scanner in;

    public FoolCheck() {
        in = new Scanner(System.in);
    }
    public int checkPositive() {
        int number;
    do{
        while (!in.hasNextInt()) {
            System.out.println("That not a number!");
            in.next();
        }
        number = in.nextInt();
    } while(number <=0);
    return number;
}
    public String writeString(){
        return in.next();
    }
}
