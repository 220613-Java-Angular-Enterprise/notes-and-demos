package com.revature;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class MessageGeneratorImpl implements MessageGenerator {
	
	//constants
	private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);
	
	//Fields
	@Autowired
	private Game game;
	
	@PostConstruct
	public void init() {
		// As SOON as DI is fulfilled, that's when this method will be called
		log.info("DI has finished and the game = {}", game);
	}
	
	

	@Override
	public String getMainMessage() {
		return "Number is between " + game.getSmallest() + " and " + game.getBiggest() + ". Can you guess it?";
	}

	@Override
	public String getResultMessage() {
		if(game.isGameWon()) {
			return "You guessed it! The number was " + game.getNumber();
		} else {
			return "You didn't guess it";
		}
	}

}
