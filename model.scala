import reqT._

var m = Model(
	Product("Electronic Voting System") has
		(Spec("An electronic voting system which will complement the manual system which is used today. " +
			"The long-term goal is to fully replace the current system during the course of a twelve year period.")),
	
	// Stakeholders
	Stakeholder("Swedish Valmyndigheten") has (
		Spec("A government authority responsible for the parliamentary elections in Sweden.")
	),
	Stakeholder("Experts") has (
		Spec("Thore Husfeldt is a professor at the Computer Science department at Lunds Tekniska Högskola and will provide the project with special knowledge on electronic voting systems.")
	),
	Stakeholder("Idlers") has (
		Spec("There is a general interest in a democratic society to raise the election turnout. To do this, the system has to activate idlers.")
	),
	Stakeholder("Disabled / hospitalized") has (
		Spec("This group includes people who may be incapable of moving to a voting place.")
	),
	Stakeholder("Visually impaired") has (
		Spec("This group includes every voter with some kind of visual impairment which may hinder their ability to use a voting system.")
	),
	Stakeholder("Voters abroad") has (
		Spec("Swedish citizens who are abroad during the voting period but are still eligible to vote.")
	),
	Stakeholder("Non-swedish speaking voters") has (
		Spec("People who don't speak Swedish but are eligible to vote.")
	),
	Stakeholder("Sub-contractors / Hardware suppliers") has (
		Spec("This group includes manufacturers of the hardware for the human interfaces, any providers of external software (such as security functions) and possibly also carpenters that manufacture voting booths etc.")
	),
	Stakeholder("The parties") has (
		Spec("This group includes the parties the Swedish population votes on.")
	),
	
	// Goals
	Goal("Reduce manual labour") has
		(Spec("Reduce the number of public voting places and the number of votes to be handled manually.")),
	Goal("Facilitate voting for people who have difficulties getting to a voting place") has
		(Spec("Make it easier for the disabled, very ill, etc. by permiting voting from where they are situated.")),
	
	// Tasks
	Task("1. Carry out voting via the web interface") has (
		Label("maintask1"),
		Why("Let a person place a vote online."),
		Trigger("A voter opens up the voting website during the voting period."),
		Critical("Worst case: the entire voting population logs in and place their votes at the same time.")
	),
	// Variants
	Task("1. Carry out voting via the web interface") owns (
		Task("1a Carry out voting via the web interface - the typical case"),
		Task("1b Carry out voting via the web interface - visually impaired"),
		Task("1c Carry out voting via the web interface - non-swedish speaking voter")
	),
	// Subtasks
	Task("1. Carry out voting via the web interface") owns (
			Task("1.1 Authenticate"),
			Task("1.2 Choose party"),
			Task("1.3 Confirm"),
			Task("1.4 Recieve confirmation")
	),
		
		Task("1.1 Authenticate") has (
			Label("subtask1.1"),
			Gist("The voter enters his/her personal code on the recieved voting card in the web interface and authenticates him-/herself using " +
			"electronic identification (e.g. BankID)")
		),
			
		Task("1.2 Choose party") has (
			Label("subtask1.2"),
			Gist("The voter chooses the party that he/she wish to vote for in the web interface.")
		),
			
		Task("1.3 Confirm") has (
			Label("subtask1.3"),
			Gist("The voter confirms that the chosen party is indeed the one he/she wants to vote for, using the web interface.")
		),
			
		Task("1.4 Recieve confirmation") has (
			Label("subtask1.4"),
			Gist("The voter recieves a personalized message confirming that the vote was counted for the correct party."),
			Comment("It should be very difficult to fake this confirmation message.")
		),
		
		Task("1a Carry out voting via the web interface - the typical case") has (
			Label("variant1a"),
			Gist("A person without any special needs uses the web interface to vote"),
			Example("The voter chooses to vote through the web interface. On the voting card there is a web adress to the voting website. " +
				"The voter opens up this site in a web browser and logs in with the code stated on the voting card. A party " +
				"is chosen in the web interface. The voter clicks on a 'Submit' button. One minute later, the voter recieves some kind of " +
				"personalized message confirming that the vote was counted for the correct party.")
		),	
		
		Task("1b Carry out voting via the web interface - visually impaired") has (
			Label("variant1b"),
			Gist("A person with a visual impairment uses the web interface to vote"),
			Example("The voter chooses to vote through the web interface. Assuming that the voter has the necessary tools to surf the web " +
			"without hinder, the voting should be carried out with the same ease as the procedure in 1a is for a fully sighted person.")
		),
		
		Task("1c Carry out voting via the web interface - non-swedish speaking voter") has (
			Label("variant1c"),
			Gist("A person who doesn't understand Swedish uses the web interface to vote"),
			Example("The voter chooses to vote through the web interface. From the voting card it should be clear enough what is the web " +
			"adress to the voting web site that no text on the card needs to be understood. As soon as the person enters the web site, " +
			"there should be a clear possibility to change language to any language that is spoken by a Swedish citizen. The procedure is " +
			"then carried out as in 1a.")
		),
		
	Task("2. Carry out voting via machine") has (
		Label("maintask2"),
		Why("Let a person place a vote on a machine. Store the vote with no connection to the voter."),
		Trigger("A voter goes to a place with a voting machine and wants to place a vote."),
		Frequency("The machine might be used continuously during open hours throughout the entire voting period.")
		
	),
	Task("2. Carry out voting via machine") owns (
		Task("2a Carry out voting via machine - the typical case"),
		Task("2b Carry out voting via machine - visually impaired"),
		Task("2c Carry out voting via machine - non-swedish speaking voter")
	),
	
	Task("2. Carry out voting via machine") owns (
		Task("2.1 Authenticate"),
		Task("2.2 Choose party"),
		Task("2.3 Confirm"),
		Task("2.4 Recieve confirmation")
	),

		// Subtasks	
		Task("2.1 Authenticate") has (
			Label("subtask2.1"),
			Gist("To be decided.")
		),
			
		Task("2.2 Choose party") has (
			Label("subtask2.2"),
			Gist("The voter chooses the party that he/she wishes to vote for in the web interface on the machine.")
		),
			
		Task("2.3 Confirm") has (
			Label("subtask2.3"),
			Gist("The voter confirms that the chosen party is indeed the one he/she wants to vote for, using the web interface on the machine.")
		),
			
		Task("2.4 Recieve confirmation") has (
			Label("subtask2.4"),
			Gist("The voter recieves a personalized message confirming that the vote was counted for the correct party."),
			Comment("It should be very difficult to fake this confirmation message.")
		),

		// Variants
		Task("2a Carry out voting via machine - the typical case") has (
			Label("variant2a"),
			Gist("A person without any special needs votes using a machine at a voting place"),
			Example("The voter uses a computer which is designed to only operate the web voting interface.")
		),
		
		Task("2b Carry out voting via machine - visually impaired") has (
			Label("variant2b"),
			Gist("A person with a visual impairment votes using a machine at a voting place"),
			Example("The public voting machines are equipped with text-to-speech and braille functionalities. This makes voting identical "+
			"to the case in 1b.")
		),
		
		Task("2c Carry out voting via machine - non-Swedish speaking voter") has (
			Label("variant2c"),
			Gist("A person who doesn't understand Swedish votes using a machine at a voting place"),
			Example("This should be identical to 1c.")
		),
	
	// Relationships
	Product("Electronic voting system") helps Goal("Reduce manual labour"),
	Product("Electronic voting system") helps Goal("Facilitate voting for people who have difficulties getting to a voting place")
)