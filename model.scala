var m = Model(
	Product("Electronic Voting System") owns
		Task("Vote for a party and a candidate"),
	
	// Tasks
	Task("Carry out voting - the typical case") has
		(Status(ELICITED),
		Gist("A person without any special needs places a vote for a party and a candidate."),
		Spec("A man logs in on the webpage. He clicks on Sossarna and Harald Görtz. He clicks OK."))
			
	)
