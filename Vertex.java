/*
ARNAV GUJARATHI
2020A7PS0066P
OOP PROJECT- 24.ASTAR ALGORITHM
*/

public class Vertex {
    private int name; // not a string. this attribute represents the city number
    private int x;  // x coordinate
    private int y;
    //private final int y;  // y coordinate

    Vertex(int name){
        this.name=name;
    }

    Vertex(int name, int x, int y){
        this.name=name;
        this.x=x;
        this.y=y;
    }

}

