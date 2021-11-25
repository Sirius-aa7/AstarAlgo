/*
ARNAV GUJARATHI
2020A7PS0066P
OOP PROJECT- 24.ASTAR ALGORITHM
*/

import java.util.*;

public class dijkstra {
    
    // Compared to astar, here heuristic value is zero        
    double heuristic = 0;

    public class PathAnddistance  {

        private double dist; // distance advanced till now
        private ArrayList<Integer> visitedCities; // list of visited nodes in this path.
        private double heuristicValue; 
        
        public PathAnddistance(double dist, ArrayList<Integer> visitedCities, double heuristicValue) {
            this.dist = dist;
            this.visitedCities  = visitedCities;
            this.heuristicValue = heuristicValue;
        }

        public  void printSolutionDijkstra() {
            if (this.visitedCities != null) {
                System.out.println("Optimum path using Dijkstra: " + this.visitedCities);
                System.out.println("Distance using Dijkstra: " + this.dist);
            } 
            else {
                System.out.println("There is no path available to travel from start city to target city");
            }
        }

        public double getDist() {
            return dist;
        }

        public ArrayList<Integer> getVisitedCities() {
            return visitedCities;
        }

        public double getHeuristicValue() 
        {
            return heuristicValue; //distanceBetTwoPoints
        }
    }

    public static void initializeGraph(City city, ArrayList<Integer> data) {
        for (int i = 0; i < data.size()-2; i += 3) {
            city.addEdge(new Edge(data.get(i), data.get(i + 1), data.get(i + 2)));
        }
        // all inputs for city relation to be taken here

    }

    public PathAnddistance dst(int startCity, int targetCity, City city) {
        // node prioritization based on the less value of current distance and the estimated
        // heuristic function values to reach destination point from the current point
        
        PriorityQueue<PathAnddistance> queue = new PriorityQueue<>(
            Comparator.comparingDouble(a -> (a.getDist() + a.getHeuristicValue() )));
        // lambda or arrow operator ->   

        // dummy data to start the algorithm from the beginning point
        //queue.add(new PathAnddistance(0, new ArrayList<>(List.of(startCity)), 0));

        dijkstra d= new dijkstra();
        queue.add(d.new PathAnddistance(0, new ArrayList<>(List.of(startCity)), 0));

        boolean solutionFound = false;
        PathAnddistance currentData = d.new PathAnddistance(-1, null, -1);
        
        while (!queue.isEmpty() && !solutionFound) {
            currentData = queue.poll(); // first in the queue, so keep exploring
            int currentPosition
                    = currentData.getVisitedCities().get(currentData.getVisitedCities().size() - 1); 
                    // current node
            if (currentPosition == targetCity) {
                solutionFound = true;
            } 
            else {
                for (Edge edge : city.getNeighbours(currentPosition)) {
                    // for else function used
                    if (!currentData.getVisitedCities().contains(edge.getCity2Name())) { 
                        // if the current traversed path doesn't include target city ,then
                        ArrayList<Integer> updatedPath = new ArrayList<>(currentData.getVisitedCities());
                        updatedPath.add(edge.getCity2Name()); // add node to the path
                        // Update the distance and also the heuristic function value associated
                        queue.add(
                                d.new PathAnddistance(
                                        currentData.getDist() + edge.getCitiesDist(),
                                        updatedPath,
                                        0)); // as no heuristic
                    }
                }
            }
        }
        // exited the while loop
        return (solutionFound) ? currentData : d.new PathAnddistance(-1, null, -1);
        // ternary operator
        // if there is a solution, the current Data will store the optimal path and distance
    }

}