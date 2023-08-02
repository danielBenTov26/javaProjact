import UserExistException.UserExistException;
import UserNotFoundException.UserNotFoundException;
import VertexExistException.VertexExistException;
import VertexNotExistException.VertexNotExistException;

import java.util.ArrayList;

public class SocialNetwork
{
    Graph<String> network;
// An empty constructor that creates the graph object as an empty object.
    public SocialNetwork()
    {
        network = new Graph<String>();
    }


// The method accepts a String object and adds it to the graph.
// If a user named user already exists, the method will throw a UserExistException exception.
    public void addUser(String user) throws UserExistException
    {
        try
        {
            this.network.addVertex(user);
        } catch (VertexExistException a)
        {
            throw new UserExistException("already exist");
        }
    }
//  The method accepts two String objects and links them.
//  If one of the strings does not exist in the graph, the method will throw a UserNotFoundException exception.
    public void addFriends(String user1, String user2) throws UserNotFoundException
    {
        try
        {
            network.addEdge(user1, user2);

        } catch (VertexNotExistException n)
        {
            throw new UserNotFoundException("UserNotFoundException");
        }
    }
// The method accepts two String objects that represent two users. The method returns true if users know each other.
    public boolean knows(String user1, String user2) throws UserNotFoundException
    {
        if (!(network.getVertices().contains(user1) && network.getVertices().contains(user2)))
        {
            throw new UserNotFoundException("User Not Found");
        }
            return  !network.bfs(user1,user2).isEmpty();


    }
}
