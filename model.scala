import reqT._

var m = Model(
	Product("Electronic Voting System") has
		(Spec("An electronic voting system which will complement the manual system which is used today. " +
			"The long-term goal is to fully replace the current system during the course of a twelve year period.")),
	
	// Stakeholders
	Stakeholder("Swedish Valmyndigheten") has (
		Spec("A governemt authority responsible for the parliamentary elections in Sweden.")
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
		Why("Let a person place a vote online. Store the vote with no connection to the voter."),
		Trigger("A voter opens up the voting website during the voting period."),
		Critical("Worst case: the entire voting population logs in and place their votes at the same time.")
	),
	Task("1. Carry out voting via the web interface") owns (
		Task("1a. Carry out voting via the web interface - the typical case"),
		Task("1b. Carry out voting via the web interface - visually impaired"),
		Task("1c. Carry out voting via the web interface - non-swedish speaking voter")
	),
	
	Task("1a. Carry out voting via the web interface - the typical case") has (
		Label("variant1"),
		Gist("A person without any special needs uses the web interface to place a vote for a party."),
		Example("The voter chooses to vote through the web interface. On the voting card there is a web adress to the voting website. " +
			"The voter opens up this site in a web browser and logs in with the code stated on the voting card. A party " +
			"is chosen in the web interface. The voter clicks on a 'Submit' button. One minute later, the voter recieves some kind of " +
			"personalized message confirming that the vote was counted for the correct party.")
	),
	
	Task("1b. Carry out voting via the web interface - visually impaired") has (
		Label("variant1"),
		Gist("A person with a visual impairment uses the web interface to place a vote for a party."),
		Example("The voter chooses to vote through the web interface. On the voting card there is a web adress in braille... bla bla bla")
	),
			
	Task("2. Carry out voting via machine") has (
		Label("maintask2"),
		Why("Let a person place a vote on a machine. Store the vote with no connection to the voter."),
		Trigger("A voter goes to a place with a voting machine and wants to place a vote."),
		Frequency("The machine might be used continuously throughout the voting period.")
	),
	Task("2. Carry out voting via machine") owns (
		Task("2a. Carry out voting via machine - the typical case"),
		Task("2b. Carry out voting via machine - visually impaired"),
		Task("2c. Carry out voting via machine - non-swedish speaking voter")
	),
	
	Task("2a. Carry out voting via machine - the typical case") has (
		Label("variant2"),
		Gist("A person without any special needs places a vote for a party using a machine at a voting place."),
		Example("The voter bla bla bla")
	),
	
	// Relationships
	Product("Electronic voting system") helps Goal("Reduce manual labour"),
	Product("Electronic voting system") helps Goal("Facilitate voting for people who have difficulties getting to a voting place")
)