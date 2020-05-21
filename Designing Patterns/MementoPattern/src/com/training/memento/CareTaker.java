package com.training.memento;

import java.util.Stack;

public class CareTaker {

    Stack<Assembling.AssemblingMemento> history= new Stack<>();

    public void save(Assembling assembling){
        history.push(assembling.save());
    }

    public void revert(Assembling assembling){
        if(!history.isEmpty())
            assembling.revert(history.pop());
        else
            System.out.println("cannot undo");
    }
}
