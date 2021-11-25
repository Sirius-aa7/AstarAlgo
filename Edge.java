/*
ARNAV GUJARATHI
2020A7PS0066P
OOP PROJECT- 24.ASTAR ALGORITHM
*/

//import java.util.*;

public class Edge { //static

    private int city1_name;
    private int city2_name;
    private int cities_dist;

    public Edge(int city1_name, int city2_name, int cities_dist) {
        this.city1_name = city1_name;
        this.city2_name = city2_name;
        this.cities_dist = cities_dist;
    }

    public int getCity1Name() {
        return city1_name;
    }

    public int getCity2Name() {
        return city2_name;
    }

    public int getCitiesDist() {
        return cities_dist;
    }
}

