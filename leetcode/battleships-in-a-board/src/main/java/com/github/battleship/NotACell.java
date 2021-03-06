package com.github.battleship;

public class NotACell extends Cell {
    
    private NotACell() {
        super('.', Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public static Cell instance() {
        return new NotACell();
    }

    @Override
    public boolean isValidCell() {
        return false;
    }

    @Override
    public boolean couldBePartOfShip() {
        return false;
    }

    @Override
    public boolean isAdjacentToShip() {
        return false;
    }

    @Override
    public boolean isPartOfShip() {
        return false;
    }
}
