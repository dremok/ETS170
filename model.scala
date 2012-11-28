import reqT._

var m = Model(
	Product("Electronic Voting System") has
		(Spec("An electronic voting system which will complement the manual system which is used today. " +
			"The long-term goal is to fully replace the current system during the course of a twelve year period."),
		Image("ContextDiagram.png")),
	
	// Stakeholders
	Stakeholder("S01. Swedish Valmyndigheten") has (
		Spec("A government authority responsible for the parliamentary elections in Sweden."),
		Prio(3),
		Comment("Stakeholder's goals: Reduced costs for the election process (manual labour, vote places, vote counting etc.) Higher election turnout. " +
		"Higher turnout for certain groups that have difficulties with the current system. Be sure that democracy is maintained, which means no votes can be sold or stolen, " +
		"a person cannot vote for another person and noone can be forced to vote against their will. Be sure that the result is accurate." +
		"<br> Risks/costs: Identity theft. Coercion. Selling of votes. Too complicated for the voters. Security risks. Development costs.")
	),
	Stakeholder("S02. Experts") has (
		Spec("Thore Husfeldt is a professor at the Computer Science department at Lund University, Faculty of Engineering and will provide the project with special knowledge on electronic voting systems. " +
		"He is mainly interested in the system because he thinks that it is interesting from a scientific point of view."),
		Prio(3),
		Comment("Stakeholder's goals: Good technical solutions. Minimal security risks.<br> Risks/costs: Conflicts of interest among different stakeholders.")
	),
	Stakeholder("S03. Idlers") has (
		Spec("There is a general interest in a democratic society to raise the election turnout. To do this, the system has to activate idlers."),
		Prio(3),
		Comment("Stakeholder's goals: Less effort required to place a vote.")
	),
	Stakeholder("S04. Disabled / hospitalized") has (
		Spec("This group includes people who may be incapable of moving to a voting place."),
		Prio(2),
		Comment("Stakeholder's goals: Be able to vote from where they are.")
	),
	Stakeholder("S05. Cognitive impairment") has (
		Spec("This group includes people who may have difficulties operating any voting system. (e.g. Dementia, Alzheimer's disease, etc.)"),
		Prio(1),
		Comment("Stakeholder's goals: As many cognitively impaired as possible should be able to vote. Risks/costs: User interface too complicated to understand." +
		"<br>This stakeholder has low priority since we can't think of any ways for the electronic system to enhance their voting abilities.")
	),
	Stakeholder("S06. Visually impaired / Blind") has (
		Spec("This group includes every voter with some kind of visual impairment which may hinder their ability to use a voting system."),
		Prio(2),
		Comment("Stakeholder's goals: Higher turnout among the visually impaired.")
	),
	Stakeholder("S07. Non-Swedish speaking voters") has (
		Spec("People who don't speak Swedish but are eligible to vote."),
		Prio(2),
		Comment("Stakeholder's goals: Same opportunity to vote regardless of native language.")
	),
	Stakeholder("S08. Voters with particularly low knowledge of electronic systems") has (
		Spec("This group includes voters who have little to no computer experience and feel uncomfortable using them."),
		Prio(1),
		Comment("Stakeholder's goals: Voting should be done as smoothly as before. Risks/costs: Voting gets too confusing." +
		"<br>This stakeholder has low priority since we can't think of any ways for the electronic system to enhance their voting abilities.")
	),
	Stakeholder("S09. Voters who are uninterested in using an electronic voting system") has (
		Spec("This group includes voters who regards election day as a traditional event that should not change."),
		Prio(1),
		Comment("Stakeholder's goals: Voting process should be changed as little as possible. Risks/costs: Turnout is decreased among voters who have a tradition of going to a voting place to vote." +
		"<br>This stakeholder has low priority since we can't think of any ways for the electronic system to enhance their voting abilities.")
	),
	Stakeholder("S10. Voters abroad") has (
		Spec("Swedish citizens who are abroad during the voting period but are still eligible to vote."),
		Prio(2),
		Comment("Stakeholder's goals: Easier/as easy to vote from where they are.")
	),
	Stakeholder("S11. Typical voters") has (
		Spec("The rest of the voting population."),
		Prio(1),
		Comment("Stakeholder's goals: Save time. Be sure that my vote counts and is counted for the correct party / candidate. Be sure that no one else can vote for me. Be sure that the result is accurate. " +
		"Risks/costs: Too complicated. Sense of insecurity.")
	),
	Stakeholder("S12. Sub-contractors / Hardware suppliers") has (
		Spec("This group includes manufacturers of the hardware for the machines in voting places and any providers of external software (such as security functions etc.) to be used in the electronic voting system."),
		Prio(1),
		Comment("Stakeholder's goals: That we use their external software and hardware so that they can benefit from this project.")
	),
	Stakeholder("S13. Dyslectic / Illiterate") has (
		Spec("People who have have difficulties understanding written text."),
		Prio(2),
		Comment("Stakeholder's goals: Easier/as easy to vote as with the current system.")
	),
	Stakeholder("S14. Hackers") has (
		Spec("People who will try to influence the election and/or gather classified information from the system by hacking it."),
		Prio(3),
		Comment("Stakeholder's goals: The system should have low security.")
	),
	
	// Features
	Product("Electronic Voting System") owns (
		Feature("F1. Web GUI for voting"),
		Feature("F2. Input from party/candidate database"),
		Feature("F3. Send vote to server"),
		Feature("F4. Individual Verifiability"),
		Feature("F5. Universal Verifiability"),
		Feature("F6. Counting of electronic votes"),
		Feature("F7. Support for different languages"),
		Feature("F8. Assembling of manual votes"),
		Feature("F9. Privacy"),
		Feature("F10. Authentication")
	),
	
	Feature("F01. Web GUI for voting") has (
		Spec("GUI that allows the user to place a vote.")
	),
	Feature("F02. Input from party/candidate database") has (
		Spec("Ability for server to read party and candidate data from an external database.")
	),
	Feature("F03. Send vote to server") has (
		Spec("Functionality that carries out transmission of vote data from client to server.")
	),
	Feature("F04. Individual Verifiability") has (
		Spec("Ability for the voter to verify that his/her vote was placed on the intended entities.")
	),
	Feature("F05. Counting of electronic votes") has (
		Spec("Possibility for server to count the votes in the data recieved from clients.")
	),
	Feature("F06. Support for different languages") has (
		Spec("Support for showing all output to the user in arbitrary languages.")
	),
	Feature("F07. Assembling of manual votes") has (
		Spec("Ability to read data with manual votes and synchronize with electronic votes.")
	),
	Feature("F08. Privacy") has (
		Spec("Functionality to prohibit extraction of information about someone else's vote.")
	),
	Feature("F09. Authentication") has (
		Spec("Functionality to allow for user authentication.")
	),
	Feature("F10. Voter eligibility check") has ( //Enough to have this as a function? Or do we need to specify exactly how? Do we need to specify the system for printing roestkort etc.?
		Spec("Functionality to ensure that only voters that are allowed to vote can vote.")
	),
	Feature("F11. Coercion-Resistance") has (
		Spec("It should not be possible to coerce someone to vote in a particular way.")
	),
	Feature("F12. Receipt-Freeness") has (
		Spec("It should not be possible for a voter to prove how he/she votes.")
	),
	Feature("F13. Fairness") has (
		Spec("No partial results should be disclosed before the end of the voting procedure</b>")
	),
	Feature("F14. Admin interface") has (
		Spec("The vote counting part of the system shall have an admin interface.")
	),
	
	//Data Dictionary
	Class("Voter") has (
		Gist("Can vote in the election"),
		Spec("A voter is someone who has voting rights in Sweden. The point of the voter class is to make sure one individual may only have one of its respective votes counted. A voter must at all time have a vote associated with it.The model must be able to hide whether a voter has voted or not as well as which party it has voted upon. A voter must for each votable party have a personal verification code."),
		Example("(1) A person who has voting rights but does not vote. (2) A person who has voting rights and does place a vote.")

		),

	Class("Party") has (
		Gist("A party which can receive a vote from the voters."),
		Spec("Each votable party is represented with a party in the system, there must also be a \"no-vote\" party in order to mask the fact that some people may not have voted, or may have voted blank."),
		Example("(1) The \"no-vote\" party. (2) The pirate party.")
		),

	Class("Party Candidate") has (
		Gist("A member of a party who the voters can vote for."),
		Spec("A party candidate is party appointed candidate. A Party Candidate is eligible to receive candidate votes. Also knows which party it belongs to."),
		Example("(1) Anna Troberg of the pirate party. (2) \"blank\" of any party.")
		),

	Class("Vote") has (
		Gist("A vote can be placed by a voter on a party and candidate."),
		Spec("A Vote is placed by a voter on a party and a party candidate. The vote is masked in such a way that there is no way for an outsider to determine which candidate and party the vote was placed on, nor who placed the vote, while still being connected to its voter. The party candidate which is being voted upon must be a party candidate from the party being voted on."),
		Example("(1) A vote on pirate party and \"blank\" candidate. (2) A vote on \"blank\" party and \"blank\" candidate")
		),

	
	// Goals
	Goal("G01. Reduce manual labour") has (
		Spec("Reduce the number of public voting places and the number of votes to be handled manually.")
	),
	Goal("G02. Facilitate voting for people who have difficulties getting to a voting place") has (
		Spec("Make it easier for the disabled, very ill, etc. by permitting voting from where they are situated.")
	),
	Goal("G03. Facilitate voting for people who have difficulties using the current manual voting system") has (
		Spec("Make it easier to vote for the visually impaired and other groups who experience that the current system can be difficult, " +
		"so that they can vote as unhindered as the rest of the population.")
	),
	
	
	// Tasks
	Task("1") has (
		Label("maintask1"),
		Gist("Carry out voting via the web interface"),
		Why("Let a person place a vote online."),
		Trigger("A voter opens up the voting website during the voting period."),
		Critical("Worst case: the entire voting population logs in and place their votes at the same time.")
	),
	// Variants
	Task("1") owns (
		Task("1a Carry out voting via the web interface - the typical case"),
		Task("1b Carry out voting via the web interface - visually impaired"),
		Task("1c Carry out voting via the web interface - non-Swedish speaking voter"),
		Task("1d Carry out voting via the web interface - voter has motor impairments")
	),
	// Subtasks
	Task("1") owns (
		Task("1.1 Authenticate"),
		Task("1.2 Choose party and candidate"),
		Task("1.3 Confirm"),
		Task("1.4 Receive confirmation")
	),
		
		Task("1.1 Authenticate") has (
			Label("subtask1.1"),
			Gist("The voter enters his/her personal code on the received voting card in the web interface and authenticates him-/herself using " +
			"electronic identification (e.g. BankID)")
		),
			
		Task("1.2 Choose party and candidate") has (
			Label("subtask1.2"),
			Gist("The voter chooses the party and candidate that he/she wishes to vote for in the web interface.")
		),
			
		Task("1.3 Confirm") has (
			Label("subtask1.3"),
			Gist("The voter confirms that the chosen party and candidate is indeed the one he/she wants to vote for, using the web interface.")
		),
			
		Task("1.4 Receive confirmation") has (
			Label("subtask1.4"),
			Gist("The voter receives a personalized message confirming that the vote was counted for the correct party."),
			Comment("It should be very difficult to fake this confirmation message.")
		),
		
		Task("1a Carry out voting via the web interface - the typical case") has (
			Label("variant1a"),
			Gist("A person without any special needs uses the web interface to vote"),
			Example("The voter chooses to vote through the web interface. On the voting card there is a web adress to the voting website. " +
				"The voter opens up this site in a web browser, logs in using electronic identification (e.g. bankID) and enters the personal code " +
				"stated on the voting card. A party and a candidate is chosen in the web interface. The voter clicks on a 'Submit' button. " +
				"After an appropriate amount of time, the voter receives some kind of personalized message confirming that the vote was counted for the correct party.")
		),	
		
		Task("1b Carry out voting via the web interface - visually impaired") has (
			Label("variant1b"),
			Gist("A person with a visual impairment uses the web interface to vote"),
			Example("The voter chooses to vote through the web interface. Assuming that the voter has the necessary tools to surf the web " +
			"without hinder, the voting should be carried out with the same ease as the procedure in 1a is for a fully sighted person.")
		),
		
		Task("1c Carry out voting via the web interface - non-Swedish speaking voter") has (
			Label("variant1c"),
			Gist("A person who doesn't understand Swedish uses the web interface to vote"),
			Example("The voter chooses to vote through the web interface. From the voting card it should be clear enough what is the web " +
			"adress to the voting web site that no text on the card needs to be understood. As soon as the person enters the web site, " +
			"there should be a clear possibility to change language to any language that is spoken by a Swedish citizen. The procedure is " +
			"then carried out as in 1a.")
		),
		
		Task("1d Carry out voting via the web interface - voter has motor impairments") has (
			Label("variant1d"),
			Gist("A person with motor impairments uses the web interface to vote"),
			Example("The voter chooses to vote through the web interface. Assuming that the voter has the necessary tools to surf the web " +
			"without hinder, the voting should be carried out with the same ease as the procedure in 1a is for a person without motor impairments.")
		),
		
	Task("2") has (
		Label("maintask2"),
		Gist("Carry out voting via machine"),
		Why("Let a person place a vote on a machine."),
		Trigger("A voter goes to a place with a voting machine and wants to place a vote."),
		Frequency("The machine might be used continuously during open hours throughout the entire voting period.")
		
	),
	Task("2") owns (
		Task("2a Carry out voting via machine - the typical case"),
		Task("2b Carry out voting via machine - visually impaired"),
		Task("2c Carry out voting via machine - non-Swedish speaking voter"),
		Task("2d Carry out voting via machine - voter has motor impairments"),
		Task("2e Carry out voting via machine - voter has cognitive impairments")
	),
	
	Task("2") owns (
		Task("2.1 Authenticate"),
		Task("2.2 Choose party and candidate"),
		Task("2.3 Confirm"),
		Task("2.4 Receive confirmation")
	),

		// Subtasks	
		Task("2.1 Authenticate") has (
			Label("subtask2.1"),
			Gist("To be decided.")
		),
			
		Task("2.2 Choose party and candidate") has (
			Label("subtask2.2"),
			Gist("The voter chooses the party and candidate that he/she wishes to vote for in the web interface on the machine.")
		),
		
		Task("2.3 Confirm") has (
			Label("subtask2.3"),
			Gist("The voter confirms that the chosen party is indeed the one he/she wants to vote for, using the web interface on the machine.")
		),
		
		Task("2.4 Receive confirmation") has (
			Label("subtask2.4"),
			Gist("The voter receives a personalized message confirming that the vote was counted for the correct party."),
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
			Spec("The public voting machines are equipped with technologies that enable a visually impaired person to use them. This makes voting identical to the case in 1b."),
			Comment("In case text-to-speech is used, it should not be possible to hear the output from outside of the booth where the machine is placed (e.g. sound isolated booth or headphones).")
		),
		
		Task("2c Carry out voting via machine - non-Swedish speaking voter") has (
			Label("variant2c"),
			Gist("A person who doesn't understand Swedish votes using a machine at a voting place"),
			Spec("This should be identical to 1c.")
		),

		Task("2d Carry out voting via machine - voter has motor impairments") has (
			Label("variant2d"),
			Gist("A person with motor impairments votes using a machine at a voting place"),
			Spec("The public voting machines are equipped with voice recognition functions to enable the voter to use them. The general procedure is identical to the typical case (Task 2a)."),
			Comment("It must not be possible to conclude what was voted for from outside the voting booth. One example is to use sound isolated booths. Another way might be to construct the user interface in a way that does not encourage the voter to say out loud what (s)he is voting for.")
		),

		Task("2e Carry out voting via machine - voter has cognitive impairments") has (
			Label("variant2e"),
			Gist("A person with cognitive impairments votes using a machine at a voting place"),
			Spec("The designers of the user interface should strive to make it as easy and efficient to use as possible.")
		),
	
	// Function requirements
	Function("Authentication") has (
		//What does the R_. mean?
		//Answer: It's a placeholder for the unique ID's that every requirement needs in the final document.
		Spec("<b>R_. Authentication of the voter should be done using an existing electronic identification system that the voters feel " +
		"comfortable using (e.g. BankID).</b>"),
		Label("Security")
	),
	Function("Send confirmation to voter") has (
		Spec("<b>R_. A personalized confirmation message should be sent to the voter after a placed vote. It should only be possible for the voter " +
		"to decipher it.</b>"),
		Label("Security")
	),
	Function("GUI information") has (
		Spec("<b>R_. The GUI should not display any information in excess of the GUI mockups and what is defined in the Swedish electoral law.</b>"),
		Label("GUI")
	),
	Function("One-Voter-One-Vote") has (
		Spec("R_. Only one vote should go to the tallying phase of the voting."),
		Label("Security")
	),

	//Covered in data dictionary?
	Function("Vote encryption") has (
		Spec("Each vote shall be encrypted so that it is not possible for an outsider to find out what the vote is placed on or who placed the vote."),
		Label("Privacy")
	),

	Function("Eligibility check") has (
		Spec("Only people present in the electoral register shall be able to place a vote in the system."),
		Label("Voter eligibility check")
	),

	Function("Support for unlimited amount of individual votes") has (
		Spec("Each voter must be allowed to vote via the electronic system as many times as desired. Only the last vote placed shall be tallied."),
		Why("If a voter is pressured to place a vote against his or her will, it shall be possible to undo a previous vote at the voter's discretion."),
		Label("Coercion-resistance")
	),

	Function("Vote traceability") has (
		Spec("Each vote must be connected to its voter, but not in a traceable way."),
		Why("It must be possible to determine which of the voter's votes shall be tallied."),
		Label("Coercion-resistance")
	),
	
	Function("Language support") has (
		Spec("The web interface must support the addition of other languages than Swedish."),
		Why("It must be possible for non-Swedish speaking voters to vote."),
		Label("Language")
	),
	
	Function("Change language") has (
		Spec("The start page of the web interface should present an obvious way of changing language."),
		Why("It must be trivial for non-Swedish speaking voters to vote in their own language."),
		Label("Language")
	),
	
	Function("Read manual votes") has (
		Spec("The admin interface must have functionality to read counted manual votes in an appropriate form of data."),
		Why("The vote counting system must know of the manual votes to count all votes equally."),
		Label("Vote count")
	),
	
	Function("Assembling and counting of votes") has (
		Spec("The vote counting system shall be able to assemble the input manual votes and all electronic votes and produce a result " +
		"where each vote is counted equally."),
		Label("Vote count")
	),

	//Quality requirements
	Quality("Maximum downtime") has (
		Spec("The system should be possible to use _% of the voting process period."),
		Label("Reliability / Availability")
	),

	Quality("Maximum testing time") has (
		Spec("It should be possible to simulate a real voting process in less than _ hours."),
		Label("Testability")
	),

	Quality("Voter interface ease of use") has (
		Spec("_ % of randomly selected voters should be able to place a vote within 2 minutes from opening the voting site."),
		Label("Usability")
	),

	Quality("Vote count correctness") has (
		Spec("_ % of all votes shall be counted as the voter intended."),
		Comment("Customer expects close to 100%."),
		Label("Correctness")
	),

	Quality("Web browser compatibility") has (
		Spec("_ % of voters' default browsers shall be compatible with the system."),
		Label("Interoperability / Portability")
	),
	Quality("Robustness/Fault Tolerance") has (
		Spec("<b>Some parts should be allowed to fail/cheat, and the system should still work</b>"),
		Example("Anonymity should still be enforced <br> Correct result should be obtained")
	),
	

	// Relationships
	Product("Electronic voting system") helps Goal("Reduce manual labour"),
	Product("Electronic voting system") helps Goal("Facilitate voting for people who have difficulties getting to a voting place"),
	Product("Electronic voting system") helps Goal("Facilitate voting for people who have difficulties using the current manual voting system")
)
