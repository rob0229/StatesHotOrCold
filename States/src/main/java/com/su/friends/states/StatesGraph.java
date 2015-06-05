package com.su.friends.states;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "statesGraph")
@XmlAccessorType (XmlAccessType.FIELD)
public class StatesGraph {

    private  Map<Integer, ArrayList<Integer>> Adjacency_List;
    
    
    
    public Map<Integer, ArrayList<Integer>> getAdjacency_List() {
		return Adjacency_List;
	}

	public void setAdjacency_List(Map<Integer, ArrayList<Integer>> adjacency_List) {
		Adjacency_List = adjacency_List;
	}

	public StatesGraph(){}
	
	public StatesGraph(int num_verts)
    {
        Adjacency_List = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 1 ; i <= num_verts ; i++)
        {
            Adjacency_List.put(i, new ArrayList<Integer>());
        }
    }

    // Adds nodes in the Adjacency list for the corresponding vertex 
    public void setEdge(int source , int destination)
    {
        if (source > Adjacency_List.size() || destination > Adjacency_List.size())
        {
            System.out.println("the vertex entered in not present ");
            return;
        }
        List<Integer> slist = Adjacency_List.get(source);
        slist.add(destination);
        List<Integer> dlist = Adjacency_List.get(destination);
        dlist.add(source);
    }
 
    // Returns the List containing the vertex joining the source vertex 
    public List<Integer> getEdge(int source)
    {
        if (source > Adjacency_List.size())
        {
            System.out.println("the vertex entered is not present");
            return null;
        }
        return Adjacency_List.get(source);
    } 
}