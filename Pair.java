package com.company;

public class Pair<T> {

    private T first;

    private T second;

    public Pair() {
        first = null; second = null;
    }
    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }
    public T getFirst() {
        return first;
    }
    public T getSecond() {
        return second;
    }
    public void setFirst(T newValue) {
        first = newValue;
    }
    public void setSecond(T newValue) {
        second = newValue;
    }
    public boolean samePosition(Pair<T> second){
        return this.getFirst()==second.getFirst()&&this.getSecond()==second.getSecond();
    }
    public boolean samePosition(T first, T second){
        return this.getFirst()==first&&this.getSecond()==second;
    }
}