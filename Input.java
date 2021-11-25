/*
ARNAV GUJARATHI
2020A7PS0066P
OOP PROJECT- 24.ASTAR ALGORITHM
*/

import java.util.*;
public class Input {

    public int N;  // number of cities
    //public static int n;  // number of intercity inputs

    static ArrayList<Vertex> src = new ArrayList<Vertex>();// cities in which the dist will be given
    static ArrayList<Vertex> dest = new ArrayList<Vertex>();
    static ArrayList<Integer> ltBetn = new ArrayList<Integer>(); // dist in between src and dest

    ArrayList<Vertex> citiesWithCoordinates = new ArrayList<Vertex>();   // initialised using const of vertex
    static ArrayList<Integer> city_name =  new ArrayList<Integer>();
    static ArrayList<Integer> city_x =  new ArrayList<Integer>();
    static ArrayList<Integer> city_y =  new ArrayList<Integer>();

    Vertex city1,city2;// cities for dist formula
    static int a,b; // city numbers
   // public int name1,name2;//, x1,x2,y1,y2;
    private float dist;// final dist given from here

    public int getCityNumber() {
        Scanner inCityNo = new Scanner(System.in);
        System.out.println("Enter number of Cities:");
        N = inCityNo.nextInt();
        //inCityNo.close();
        return N;
    }

    public void getCityRel(){

        System.out.println("Enter the intercity relations(one rel per line):");
        Scanner inCityRel= new Scanner(System.in);

        String s = inCityRel.next();

        String[] arrOfStringS = s.split("\n",-1);

        for(int i=0;i< arrOfStringS.length;i++){
            String array[] =arrOfStringS[i].split(" ",2);
            src.add(new Vertex(Integer.parseInt(array[0])));
            dest.add(new Vertex(Integer.parseInt(array[1])));
            ltBetn.add(Integer.parseInt(array[2]));
        }
        //inCityRel.close();
    }

    public void getCityCoordinates() {
        System.out.println("Enter the city coordinates:");
        Scanner inCityCoordinates = new Scanner(System.in);
        ArrayList<Integer> t = new ArrayList<>();
        while(inCityCoordinates.hasNextInt()){
            t.add(inCityCoordinates.nextInt());
        }
        for(int i=0;i<t.size();i++){
            
            if(i%3==0){
                city_name.add(t.get(i));
            }
            else if(i%3==1){
                city_x.add(t.get(i));
            }
            else if(i%3==2){
                city_y.add(t.get(i));
                citiesWithCoordinates.add(new Vertex(city_name.get((i-2)/3),city_x.get((i-2)/3),city_y.get((i-2)/3)));
                //System.out.println("added");
            }
            //System.out.println("test");
        }
        // System.out.println(city_y);
        //System.out.println("test_out");
    }

    public double distanceBetTwoPoints(int m, int n){
          double x1=0,x2=0,y1=0,y2=0;
        
        for(int i=0;i<citiesWithCoordinates.size();i++){
            //System.out.println(city_name.get(i));
            if(city_name.get(i)==m){
                //city 1 is at index i
                x1 = city_x.get(i);
                y1 = city_y.get(i);
                //System.out.println(x1+" text1 "+y1);
            }
            if(city_name.get(i)==n){
                //city 2 is at index i
                x2 = city_x.get(i);
                y2 = city_y.get(i);
                //System.out.println(x2+" text2 "+y2);
            }
        }
        double x = Math.abs(x1-x2);
        double y = Math.abs(y1-y2);
        double dsquare = (x*x +y*y);
        double d = Math.sqrt(Math.abs(dsquare));
        return d;
   }

    public static ArrayList<Vertex> getSrc() 
    { return src;}

    public static ArrayList<Vertex> getDest() 
    { return dest;}

    public static ArrayList<Integer> getLtBetn() 
    { return ltBetn;}

    public void setCities() {
        getCityNumber();
        getCityRel();
        getCityCoordinates();
    }
}


 /*   public void setCitiesForDist(){
        Scanner inCityForDist = new Scanner(System.in);
        System.out.println("Enter city1:");
        int a = inCityForDist.nextInt();
        int b = inCityForDist.nextInt();

        for(int i=0;i<citiesWithCoordinates.size();i++){
            if(city_name.get(i)==a){
                //city 1 is at index i
                city1 = citiesWithCoordinates.get(i);
            }
            else if(city_name.get(i)==b){
                //city 2 is at index i
                city2 = citiesWithCoordinates.get(i);
            }
        }
        inCityForDist.close();

    }

    public void setCitiesusingint(){
        Scanner inCityForDist = new Scanner(System.in);
        System.out.println("Enter city1:");
        a = inCityForDist.nextInt();
        b = inCityForDist.nextInt();
        inCityForDist.close();
    }

    public int originCity(){
        return a;
    }
    
    public int targetCity(){
        return a;
    }
*/
    /*public void ToFindDist(Vertex city1, Vertex city2){

        setCities();
        //dist= new ASTAR().Distance_Astar();
        System.out.print("Distance between cities using AStar Algorithm:-");
        System.out.println(dist);

        //dist= new Dijkstra().Distance_Dijkstra();
        System.out.print("Distance between cities using Dijkstra Algorithm");
        System.out.println(dist);
    }*/
