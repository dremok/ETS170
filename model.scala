var m = Model(
	Product("Electronic Voting System") has
		(Spec("An electronic voting system which will complement the manual system which is used today. " +
			"The long-term goal is to fully replace the current system during the course of a twelve year period.")),
	
	// Goals
	Goal("Main goal") has
		(Spec("Reduce the number of public voting places and the number of votes to be handled manually.")),
	Goal("Facilitate voting for people who have difficulties getting to a voting place") has
		(Spec("Make it easier for the disabled, very ill, etc. by permiting voting from where they are situated.")),
	
	// Tasks
	Task("Carry out voting - the typical case") has
		(Gist("A person without any special needs places a vote for a party and a candidate."),
		Spec("The voter chooses to vote through the web interface. On the voting card there is a web adress to the voting website. " +
			"The voter opens up this site in a web browser and logs in with the code stated on the voting card. A party " +
			"is chosen in the web interface. The voter clicks on a 'Submit' button. One minute later, the voter recieves some kind of " +
			"personalized message confirming that the vote was counted for the correct party.")),
	
	// Stakeholders
	Stakeholder("Swedish Valmyndigheten") has
		(Spec("A governemt authority responsible for the parliamentary elections in Sweden.")),
	
	// Relationships
	Product("Electronic voting system") helps Goal("Main goal")
)