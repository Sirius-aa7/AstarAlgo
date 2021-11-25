/*
ARNAV GUJARATHI
2020A7PS0066P
OOP PROJECT- 24.ASTAR ALGORITHM
*/

import java.util.*;

public class astar {

    // Time Complexity of Astar algorithm = O(E), where E is equal to the number of edges 
    // class to iterate during the algorithm execution, and also used to return the solution.
    private static class PathAndDistance {

        private double dist; // distance advanced till now
        private ArrayList<Integer> visitedCities; // list of visited nodes in this path.
        private double heuristicValue; 
        // heuristic value associated to the last node od the path (current node).

        public PathAndDistance(double dist, ArrayList<Integer> visitedCities, double heuristicValue) {
            // constructors are different in classes astar and dijkstra hence two separate defn
            this.dist = dist;
            this.visitedCities  = visitedCities;
            this.heuristicValue = heuristicValue;
        }

        public void printSolution_astar() {
            if (this.visitedCities != null) {
                System.out.println("Optimum path using Astar: " + this.visitedCities);
                System.out.println("Distance using Astar: " + this.dist);
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

    public static PathAndDistance aStar(int startCity, int targetCity, City city, double[][] heuristics) {
        // node prioritization based on the less value of current distance and the estimated
        // heuristic function values to reach destination point from the current point
        
        PriorityQueue<PathAndDistance> queue = new PriorityQueue<>(
            Comparator.comparingDouble(a -> (a.getDist() + a.getHeuristicValue() )));
        // lambda or arrow operator ->   

        // dummy data to start the algorithm from the beginning point
        queue.add(new PathAndDistance(0, new ArrayList<>(List.of(startCity)), 0));

        boolean solutionFound = false;
        PathAndDistance currentData = new PathAndDistance(-1, null, -1);
        
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
                                new PathAndDistance(
                                        currentData.getDist() + edge.getCitiesDist(),
                                        updatedPath,
                                        heuristics[edge.getCity2Name()][targetCity]));
                    }
                }
            }
        }
        // exited the while loop
        return (solutionFound) ? currentData : new PathAndDistance(-1, null, -1);
        // ternary operator
        // if there is a solution, the current Data will store the optimal path and distance
    }

    public static void main(String[] args) {

        int N; 
        Input input =  new Input();
        N = input.getCityNumber();
        double heuristics[][] = new double[N][N];
        City city =  new City(N);

        System.out.println("Enter cities and their distances:");
        System.out.println("(enter a ; once giving this input is done)");
        Scanner inCityRel= new Scanner(System.in);
        //String s = inCityRel.next();
        ArrayList<Integer> graphDatas = new ArrayList<>();
        while(inCityRel.hasNextInt()){
            graphDatas.add(inCityRel.nextInt());
        }
        initializeGraph(city, graphDatas);
        /*
        StringTokenizer st = new StringTokenizer(s," ");
        while (st.hasMoreTokens()) {
            graphDatas.add(Integer.parseInt(st.nextToken()));  
            getting a weird error here
        }*/

        input.getCityCoordinates();
        
        
        // input of cities betn which dist is to be found
        Scanner inCityForDist = new Scanner(System.in);
        System.out.println("Enter city1:");
        int a = inCityForDist.nextInt();
        System.out.println("Enter city2:");
        int b = inCityForDist.nextInt();

        //System.out.println("Dist formula:"+input.distanceBetTwoPoints(a, b));

        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
               heuristics[i][j]= input.distanceBetTwoPoints(i, j);
            }
        }
        PathAndDistance solution = aStar(a,b, city, heuristics);
        // here 3 is my start city & 1 is my target city
        solution.printSolution_astar();

        dijkstra dij = new dijkstra();
        dij.dst(a, b, city);
        dijkstra.PathAnddistance obj=dij.dst(a, b, city);
        obj.printSolutionDijkstra();
        inCityForDist.close();
        inCityRel.close();
        /*
        dijkstra.dst(a, b, city);
        dijkstra.
        dij.dst(a, b, city);
        dijkstra.printSolutionDijkstra();
        PathAnddistance sol */
        //dijkstra.dijkstra(a,b, city);    
        
    }
}


/*
    .x. node
    (y) cost
    - or | or /  connection

                          ( 98)- .7. -(86)- .4.
                            |
                    ( 85)- .17. -(142)- .18. -(92)- .8. -(87)- .11.
                      |
                     . 1. -------------------- (160)
                      |  \                       |
                    (211) \                     .6.
                      |    \                     |
                     . 5.  (101)-.13. -(138)   (115)
                      |           |     |     /
                    ( 99)       ( 97)   |    /
                      |           |     |   /
        .12. -(151)- .15. -(80)- .14.   |  /
         |            |           |     | /
       ( 71)        (140)       (146)- .2. -(120)
         |            |                       |
        .19. -( 75)- . 0.        .10. -(75)- .3.
                      |            |
                    (118)        ( 70)
                      |            |
                     .16. -(111)- .9.
         */
