package com.company;
import java.util.Random;
import java.util.Scanner;
public class Game {
    private Map map;
    private Character cat;
    private Character mouse;
    private Character food;
    private  FoolCheck in;
    private  int mouse_steps;
    public Game(int row,int col){
        map = new Map(col,row);
        cat = new Cat(row,col);
        food = new Food(row,col);
        mouse = new Mouse(row,col);
        mouse_steps=col*row;
        in= new FoolCheck();
    }
    private void allSpawn(){
        System.out.print("Input a number of walls: ");
        map.putEnvironment(in.checkPositive());
        map.putCharacter(food);
        System.out.print("Input a maximum jump for cat: ");
        cat.setJump(in.checkPositive());
        map.putCharacter(cat);
        System.out.print("Input a maximum jump for mouse: ");
        mouse.setJump(in.checkPositive());
        map.putCharacter(mouse);
        map.showMap();
    }
    private Pair<Integer> moving(Character player){
        String move;
        System.out.print("Choose direction: ");
        move=in.writeString();
        switch (move) {
                case "up":
                    return player.jumpUp();
                case "right":
                    return player.jumpRight();
                case "down":
                    return player.jumpDown();
                case "left":
                    return player.jumpLeft();
                default:
                    return new Pair<Integer>(player.getPositionX(), player.getPositionY());
            }
    }

    private boolean canMouseWin() {

        allSpawn();
        Pair<Integer> mousePair;
        Pair<Integer> catPair;
        for (int i=0;i<mouse_steps;i++) {
            System.out.println("Step count: "+i+"/"+mouse_steps);
            mousePair = moving(mouse);
            map.putCharacter(mouse, mousePair);
            map.showMap();
            if(mousePair.samePosition(food.getPositionX(), food.getPositionY()))
              return true;

            catPair = moving(cat);
            map.putCharacter(cat, catPair);
            map.showMap();
            if(catPair.samePosition(mousePair)||catPair.samePosition(food.getPositionX(), food.getPositionY()))
              return false;
      }
        return false;
    }
    public void playProccess(){
        if(canMouseWin())
            System.out.println("Mouse wins!!!!");
        else
            System.out.println("Cat wins!!!!");
    }
}
