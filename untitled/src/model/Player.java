
package model;

public class Player {
    private String name;
    private String color;
    private int position;

    public Player(String name, String color) {
        this.name = name;
        this.color = color;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
