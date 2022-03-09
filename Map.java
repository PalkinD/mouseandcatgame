package com.company;

import java.util.Random;

public class Map {
    private final String floor= ".";
    private final String wall="#";
    private String grid[][];
    private Random random;
    private int row;
    private int col;
    public Map(int col,int row){
        grid= new String[row][col];
        this.row=row;
        this.col=col;
        random = new Random();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                grid[i][j]=floor;
            }
        }
    }
    public void putEnvironment(int count){
        for(int i=0;i<count;i++)
           randomSpawn(wall);
    }

    public void showMap(){
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(" "+grid[i][j]+" ");
            }
            System.out.println();
        }

    }
    public void putCharacter(Character playableChar){
        Pair<Integer> xAndY= randomSpawn(playableChar.getTypeOfCharacter());
        playableChar.setPosition(xAndY.getFirst(), xAndY.getSecond());
    }
    public void putCharacter(Character playableChar, Pair<Integer> pair) {
        if (playableChar.samePosition(pair)) {
            System.out.println("Stay at ur position");
            return;
        }
        int newX = pair.getFirst();
        int newY = pair.getSecond();
        int oldX = playableChar.getPositionX();
        int oldY = playableChar.getPositionY();
        try {
            if (grid[newY][newX].equals(floor)) {
                grid[newY][newX] = playableChar.getTypeOfCharacter();
                playableChar.setPosition(newX, newY);
                grid[oldY][oldX] = floor;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
    private Pair<Integer> randomSpawn(String item){
        int x,y;
        do {
            x = random.nextInt(col);
            y = random.nextInt(row);
        } while (!grid[y][x].equals(floor));
        grid[y][x] = item;
        return new Pair<>(x, y);
    }
}
