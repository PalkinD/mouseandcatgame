package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        FoolCheck in= new FoolCheck();
        int rows,cols;
        System.out.print("Press number of rows: ");
        rows=in.checkPositive();
        System.out.print("Press number of cols: ");
        cols=in.checkPositive();
        Game game = new Game(rows,cols);
        game.playProccess();
    }
}
