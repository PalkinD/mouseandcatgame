package com.company;

import java.util.Random;

public abstract class Character {
    protected String typeOfCharacter;
    private int mapRow;
    private int mapCol;
    private Pair<Integer> position;
    private int jump;
    private Random rand;
    Character(int row, int col){
        mapRow=row;
        mapCol=col;
        jump=0;
        position = new Pair<>(0,0);
        rand = new Random();
    }
    public Pair<Integer> jumpUp(){
        int newPositionY=getPositionY()-getRandomJump();
        if(newPositionY<0||newPositionY==getPositionY())
            return position;
        return new Pair<Integer>(getPositionX(),newPositionY);
    }
    public Pair<Integer> jumpRight(){
        int newPositionX=getPositionX()+getRandomJump();
        if(newPositionX>=mapCol||newPositionX==getPositionX())
            return position;
        return new Pair<Integer>(newPositionX,getPositionY());
    }
    public Pair<Integer> jumpDown(){
        int newPositionY=getPositionY()+getRandomJump();
        if(newPositionY>=mapRow||newPositionY==getPositionY())
            return position;
        return new Pair<Integer>(getPositionX(),newPositionY);
    }
    public  Pair<Integer> jumpLeft(){
        int newPositionX=getPositionX()-getRandomJump();
        if(newPositionX<0||newPositionX==getPositionX())
            return position;
        return  new Pair<Integer>(newPositionX,getPositionY());
    }
    public void setJump(int jump){
        this.jump=jump;
    }
    public int getRandomJump(){
        int dice=rand.nextInt(jump);
        System.out.println("Rolling dice: "+dice+" points of jump");
        return dice;
    }
    public String getTypeOfCharacter(){
        return typeOfCharacter;
    }
    public void setPosition(int x,int y){
        position.setFirst(x);
        position.setSecond(y);
    }
    public int getPositionX(){
        return position.getFirst();
    }
    public int getPositionY(){
        return position.getSecond();
    }
    public boolean samePosition(Pair<Integer> newPosition){
        return getPositionX()==newPosition.getFirst()&&getPositionY()==newPosition.getSecond();
    }
    public boolean samePosition(Character second){
        return getPositionX()==second.getPositionX()&&getPositionY()==second.getPositionY();
    }
}
