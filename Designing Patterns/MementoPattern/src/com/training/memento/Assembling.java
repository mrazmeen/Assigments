package com.training.memento;

import java.util.ArrayList;

//Originator
public class Assembling {
    ArrayList<CarParts>  carPart = new ArrayList<>();

    public void addParts(CarParts carParts){
        carPart.add(carParts);
    }

    public ArrayList<CarParts> getCarPart() {
        return (ArrayList<CarParts>) carPart.clone();
    }

    public AssemblingMemento save(){
        return new AssemblingMemento(getCarPart());
    }

    public void revert(AssemblingMemento assemblingMemento){
        carPart=assemblingMemento.getCarPart();
    }

    @Override
    public String toString() {
        return "Assembling{" +
                "carPart=" + carPart +
                '}';
    }

    static class AssemblingMemento{
        ArrayList<CarParts>  carPart;

        public AssemblingMemento(ArrayList<CarParts> carPart) {
            this.carPart = carPart;
        }

        private ArrayList<CarParts> getCarPart() {
            return carPart;
        }
    }
}
