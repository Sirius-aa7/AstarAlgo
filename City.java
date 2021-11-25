/*
ARNAV GUJARATHI
2020A7PS0066P
OOP PROJECT- 24.ASTAR ALGORITHM
*/

import java.util.*;

public class City {

    private ArrayList<ArrayList<Edge>> city;

    public City(int size) {
        this.city = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            this.city.add(new ArrayList<>());
        }
        // ArrayLists are initialised in this Constructor
    }

    public ArrayList<Edge> getNeighbours(int city1_name) {
        return this.city.get(city1_name);
    }

    public void addEdge(Edge edge) {
        this.city.get(edge.getCity1Name()).add(
            new Edge(edge.getCity1Name(), edge.getCity2Name(), edge.getCitiesDist()));
        //this.graph.get(edge.getCity2Name()).add(
            //new Edge(edge.getCity2Name(), edge.getCity1Name(), edge.getCitiesDist()));
        //for bidirectional graph, add second instruction of this method.
    }
}

