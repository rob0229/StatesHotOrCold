package com.su.friends.states;

import org.junit.Assert;
import org.junit.Test;

public class StatesGraphTest {
	
	@Test
	public void StatesGraphTest_ClassConstructor(){
		StatesGraph empty = new StatesGraph(0);
		StatesGraph sg = new StatesGraph(1);
		StatesGraph largeGraph = new StatesGraph(100);
		Assert.assertEquals(0, empty.getAdjacency_List().size());
		Assert.assertEquals(1, sg.getAdjacency_List().size());
		Assert.assertEquals(100, largeGraph.getAdjacency_List().size());
	
	}
	
	@Test
	public void Test_SetEdge(){
		StatesGraph smallGraph = new StatesGraph(1);
		
		smallGraph.setEdge(2, 2);
		
	}
}
