import VertexExistException.VertexExistException;
import VertexNotExistException.VertexNotExistException;

import java.util.ArrayList;
import java.util.Collections;

public class Graph<E>
{
    ArrayList<ArrayList<E>> data;

    public Graph()
    {
        this.data = new ArrayList<ArrayList<E>>();
    }

    public void addVertex(E ver) throws VertexExistException
    {
//     The method receives an E-type object and checks if there is an Array list that contains the object.
        for (ArrayList<E> datum : data)
        {
            if (datum.contains(ver))
                throw new VertexExistException("already exist"); // if data contains Array list with the 'E' object the method throw exception.
        }
//        create a new Array list with 'ver' and add him to 'data'.
        ArrayList<E> Ver = new ArrayList<E>();
        Ver.add(ver);
        this.data.add(Ver);
    }
// The method takes two nodes and adds an arc between them.
// If one or both nodes do not exist in the graph,
// the method will throw a VertexNotExistException exception.
    public void addEdge(E ver1, E ver2) throws VertexNotExistException
    {
        if (VertexExist(ver1) && VertexExist(ver2))
        {
            for (ArrayList<E> datum : data)
            {
                if (datum.get(0).equals(ver1))
                    datum.add(ver2);
                else if (datum.get(0).equals(ver2))
                    datum.add(ver1);
            }
        } else throw new VertexNotExistException("VertexNotExistException");

    }
// The method returns a list of all the nodes that have an arc between ver and them.
    public ArrayList<E> getEdges(E ver) throws VertexNotExistException
    {
        if (!VertexExist(ver))
            throw new VertexNotExistException("VertexNotExistException");
        ArrayList<E> edgesList = new ArrayList<E>();

        for (ArrayList<E> datum : data)
        {
            if (datum.get(0).equals(ver))
            {
                for (int i = 0; i < datum.size(); i++)
                {
                    if (!edgesList.contains(datum.get(i)))
                        edgesList.add(datum.get(i));
                }
                edgesList.remove(ver);
                break;
            }
        }
        return edgesList;
    }
// The method returns an ArrayList object that will contain all the nodes in the graph
    public ArrayList<E> getVertices()
    {
        ArrayList<E> getVertices = new ArrayList<>();
        for (ArrayList<E> datum : data)
            getVertices.add(datum.get(0));
        return getVertices;
    }
    //  The private Boolean method checks if VER exists in the graph.
    private boolean VertexExist(E ver)
    {
        for (ArrayList<E> datum : data)
            if (datum.get(0).equals(ver))
                return true;
        return false;
    }
//    The method will accept as parameters two nodes. The method returns a list of nodes that make up the route from  'FROM' to 'TO'.
    public ArrayList<E> bfs(E from, E to) {
        ArrayList<ArrayList<E>> theWayList = new ArrayList<ArrayList<E>>(); //list of all possibles routes from 'FROM' to 'TO'
        ArrayList<E> firstList = new ArrayList<E>();
        firstList.add(from);
        theWayList.add(firstList);
        ArrayList<E> queue = new ArrayList<E>();
        queue.add(from);

        while (!queue.isEmpty()) {
            E currentVertex = queue.get(0);
            if (!VertexExist(currentVertex))
                continue;
            ArrayList<E> neighborsTemp = data.get(getVertexIndex(currentVertex));
            neighborsTemp.remove(currentVertex);

            ArrayList<E> route = null;
            //find the relevant routes from the list
            for (ArrayList<E> visit : theWayList)
                if (visit.contains(currentVertex))
                {
                    route = (ArrayList<E>) visit.clone();
                    theWayList.remove(visit);
                    break;
                }
            //route => the relevant route

            for (E n : neighborsTemp)
                if (!route.contains(n)) {
                    boolean wayAlreadyExist = false;

                    for(ArrayList<E> ways : theWayList)
                        if(ways.contains(n)){
                            wayAlreadyExist = true;
                            break;
                        }
                    if (wayAlreadyExist)
                        continue;

                    ArrayList<E> newRoute = (ArrayList<E>) route.clone();
                    newRoute.add(n);

                    if (n.equals(to))
                        return newRoute;

                    theWayList.add(newRoute);
                    queue.add(n);
                }
            queue.remove(currentVertex);

        }


        return new ArrayList<>();
    }
// get the Vertex Index in the graph.
    private int getVertexIndex(E currentVertex)
    {
        for (ArrayList<E> temp : data)
        {
            if (temp.get(0).equals(currentVertex))
                return data.indexOf(temp);
        }
        return -1;
    }

}


