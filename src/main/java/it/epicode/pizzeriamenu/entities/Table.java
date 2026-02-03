package it.epicode.pizzeriamenu.entities;

public class Table {
    private int number;
    private int maxCoperti;
    private boolean occupied;

    public Table(int number, int maxCoperti, boolean occupied) {
        this.number = number;
        this.maxCoperti = maxCoperti;
        this.occupied = occupied;
    }

    public int getNumber() { return number; }
    public void setNumber(int number) { this.number = number; }

    public int getMaxCoperti() { return maxCoperti; }
    public void setMaxCoperti(int maxCoperti) { this.maxCoperti = maxCoperti; }

    public boolean isOccupied() { return occupied; }
    public void setOccupied(boolean occupied) { this.occupied = occupied; }

    @Override
    public String toString() {
        return "Table{number=" + number + ", maxCoverti=" + maxCoperti + ", occupied=" + occupied + '}';
    }
}
