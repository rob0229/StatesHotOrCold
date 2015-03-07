package com.su.friends.states;

import junit.framework.Assert;

import org.junit.Test;

public class StatesHotOrColdTest {
	
	
	@Test
	public void Test_FindState_In_Enum(){
		Assert.assertEquals(6, StatesHotOrCold.getGuessInt("colorado"));
		Assert.assertEquals(51, StatesHotOrCold.getGuessInt("wyoming"));
		Assert.assertEquals(1, StatesHotOrCold.getGuessInt("alaska"));
		
	}
}
