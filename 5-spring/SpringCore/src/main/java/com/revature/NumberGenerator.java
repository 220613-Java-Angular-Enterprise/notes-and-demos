package com.revature;


public interface NumberGenerator {
	
	//Produce a number with next()
	int next();
	
	// We need a max number to determine the range to guess from
	int getMaxNumber();

}
