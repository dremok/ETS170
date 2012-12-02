import reqT._

var m = Model(
	Product("Electronic Voting System") has
		(Gist("An electronic voting system which will complement the manual system which is used today."),
		 Spec("The context diagram above describes the interactions between voters, electoral workers and the voting system. A voter can either submit a vote to the system directly or on paper to an electoral worker. If the voter votes electronically, he or she will receive a confirmation that the vote was received properly. The electoral workers submit parties and candidates before the election period. Paper votes are submitted to the system using a cimilar procedure as the parties and candidates. After the end of the voting phase, the system can calculate the result of the voting."),
		Image("ContextDiagram.png")
	),

	// Stakeholders
	Stakeholder("S01. Swedish Valmyndigheten") has (
		Spec("A government authority responsible for the parliamentary elections in Sweden."),
		Prio(4),
		Comment("Stakeholder's goals: Reduced costs for the election process (manual labour, vote places, vote counting etc.) Higher election turnout. " +
		"Higher turnout for certain groups that have difficulties with the current system. Be sure that democracy is maintained, which means no votes can be sold or stolen, " +
		"a person cannot vote for another person and no one can be forced to vote against their will. Be sure that the result is accurate." +
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
		Spec("This group includes people who may have difficulties operating any voting system."),
		Example("Patients suffering from dementia, Alzheimer's disease or senility."),
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
		Feature("F_. Web interface for voting"),
		Feature("F_. Input from party/candidate database"),
		Feature("F_. Send vote to server"),
		Feature("F_. Individual Verifiability"),
		Feature("F_. Counting of electronic votes"),
		Feature("F_. Support for different languages"),
		Feature("F_. Input of paper votes"),
		Feature("F_. Privacy"),
		Feature("F_. Authentication when voting electronically from home"),
		Feature("F_. Voter eligibility check"),
		Feature("F_. Coercion-Resistance & Receipt-Freeness"),
		Feature("F_. Fairness"),
		Feature("F_. Admin interface"),
		Feature("F_. Support for visually impaired voters"),
		Feature("F_. Support for voters with motor disabilities"),
		Feature("F_. Support for cognitive disabilities"),
		Feature("F_. Support for the illiterate & dyslectic")
	),
	
	Feature("F_. Web interface for voting") has (
		Spec("GUI that allows the user to place a vote.")
	),
	Feature("F_. Input from party/candidate database") has (
		Spec("Ability for server to read party and candidate data from an external database.")
	),
	Feature("F_. Send vote to server") has (
		Spec("Functionality that carries out transmission of vote data from client to server.")
	),
	Feature("F_. Individual Verifiability") has (
		Spec("Ability for the voter to verify that his/her vote was placed on the intended entities.")
	),
	Feature("F_. Counting of electronic votes") has (
		Spec("Possibility for server to count the votes in the data recieved from clients.")
	),
	Feature("F_. Support for different languages") has (
		Spec("Support for showing all output to the user in arbitrary languages.")
	),
	Feature("F_. Input of paper votes") has (
		Spec("Ability to read data of votes submitted on paper and store together with electronic votes.")
	),
	Feature("F_. Privacy") has (
		Spec("Functionality to prohibit extraction of information about someone else's vote.")
	),
	Feature("F_. Authentication") has (
		Spec("Functionality to allow for user authentication.")
	),
	Feature("F_. Voter eligibility check") has (
		Spec("Functionality to ensure that only voters that are allowed to vote can vote.")
	),
	Feature("F_. Coercion-Resistance & Receipt-Freeness") has (
		Spec("It should not be possible for a voter to prove how he/she votes. " +
			"Thereby, it should not be possible to coerce someone to vote in a particular way.")
	),
	Feature("F_. Fairness") has (
		Spec("No partial results should be disclosed before the end of the voting procedure</b>")
	),
	Feature("F_. Admin interface") has (
		Spec("The vote counting part of the system shall have an admin interface.")
	),
	Feature("F_. Support for visually impaired voters") has (
		Spec("The electronic voting system shall support visually impaired voters, either indirectly or with provided interfaces.")
	),
	Feature("F_. Support for voters with motor disabilities") has (
		Spec("Functionality that facilitates for disabled voters, so that as many as possible are able to place a vote without assistance from another person.")
	),
	Feature("F_. Support for cognitive disabilities") has (
		Spec("Functionality that facilitates for voters with cognitive impairments, so that as many as possible are able to place a vote without assistance from another person.")
	),
	Feature("F_. Support for the illiterate & dyslectic") has (
		Spec("The system shall support voters who have reading problems or problems to understand written text.")
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
	Goal("G04. Maintain the current election turnout") has (
		Spec("The new system shall not have any significant negative impact on the election turnout.")
	),
	Goal("G05. Maintain democracy") has (
		Spec("The new system shall make sure that the law is followed in such a way that democracy is maintained.")
	),
	
	
	//Data Dictionary
	Class("Voter") has (
		Gist("Can vote in the election"),
		Spec("A voter is someone who has voting rights in Sweden. The point of the voter class is to make sure one individual may only have one of its respective votes counted. A voter must at all times have a vote associated with it. The model must be able to hide whether a voter has voted or not as well as which party it has voted upon. A voter must for each votable party have a personal verification code. Every voter must have a means to authenticate him- or herself via the authentication system in use."),
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
		
	//CRUD
	Class("Voter") has (
		Comment("It should be possible to create, read, update and delete voters. CRUD is only applied during the registration phase, during the other phases it is only possible to read voters.")
	),

	Class("Party") has (
		Comment("It should be possible to create, read, update and delete parties. CRUD is only applied during the registration phase, during the other phases it is only possible to read parties.")
	),

	Class("Party Candidate") has (
		Comment("It should be possible to create, read, update and delete party candidates. CRUD is only applied during the registration phase, during the other phases it is only possible to read party candidates.")
	),

	Class("Vote") has (
		Comment("It should only be possible to create and read votes, not delete or update them. Votes can only be created during the voting phase and read during the tallying phase.")
	),
	
	// Tasks
	Task("T1") has (
		Label("maintask1"),
		Gist("Carry out voting via the web interface"),
		Why("Let a person place a vote online."),
		Trigger("A voter opens up the voting website during the voting period."),
		Critical("Worst case: the entire voting population logs in and place their votes at the same time.")
	),
	// Variants
	Task("T1") owns (
		Task("1a Carry out voting via the web interface - the typical case"),
		Task("1b Carry out voting via the web interface - visually impaired"),
		Task("1c Carry out voting via the web interface - non-Swedish speaking voter"),
		Task("1d Carry out voting via the web interface - voter has motor impairments")
	),
	// Subtasks
	Task("T1") owns (
		Task("T1.1 Authenticate"),
		Task("T1.2 Choose party and candidate"),
		Task("T1.3 Confirm"),
		Task("T1.4 Receive confirmation")
	),
		
		Task("T1.1 Authenticate") has (
			Label("subtask1.1"),
			Gist("The voter enters his/her personal code on the received voting card in the web interface and authenticates him-/herself using " +
			"electronic identification"),
			Example("By for example using BankID")
		),
			
		Task("T1.2 Choose party and candidate") has (
			Label("subtask1.2"),
			Gist("The voter chooses the party and candidate that he/she wishes to vote for in the web interface.")
		),
			
		Task("T1.3 Confirm") has (
			Label("subtask1.3"),
			Gist("The voter confirms that the chosen party and candidate is indeed the one he/she wants to vote for, using the web interface.")
		),
			
		Task("T1.4 Receive confirmation") has (
			Label("subtask1.4"),
			Gist("The voter receives a personalized message confirming that the vote was counted for the correct party."),
			Comment("It should be very difficult to fake this confirmation message.")
		),
		
		Task("T1a Carry out voting via the web interface - the typical case") has (
			Label("variant1a"),
			Gist("A person without any special needs uses the web interface to vote"),
			Example("The voter chooses to vote through the web interface. On the voting card there is a web adress to the voting website. " +
				"The voter opens up this site in a web browser, logs in using electronic identification (e.g. bankID) and enters the personal code " +
				"stated on the voting card. A party and a candidate is chosen in the web interface. The voter clicks on a 'Submit' button. " +
				"After an appropriate amount of time, the voter receives some kind of personalized message confirming that the vote was counted for the correct party.")
		),	
		
		Task("T1b Carry out voting via the web interface - visually impaired") has (
			Label("variant1b"),
			Gist("A person with a visual impairment uses the web interface to vote"),
			Example("The voter chooses to vote through the web interface. Assuming that the voter has the necessary tools to surf the web " +
			"without hinder, the voting should be carried out with the same ease as the procedure in 1a is for a fully sighted person.")
		),
		
		Task("T1c Carry out voting via the web interface - non-Swedish speaking voter") has (
			Label("variant1c"),
			Gist("A person who doesn't understand Swedish uses the web interface to vote"),
			Example("The voter chooses to vote through the web interface. From the voting card it should be clear enough what is the web " +
			"adress to the voting web site that no text on the card needs to be understood. As soon as the person enters the web site, " +
			"there should be a clear possibility to change language to any language that is spoken by a Swedish citizen. The procedure is " +
			"then carried out as in 1a.")
		),
		
		Task("T1d Carry out voting via the web interface - voter has motor impairments") has (
			Label("variant1d"),
			Gist("A person with motor impairments uses the web interface to vote"),
			Example("The voter chooses to vote through the web interface. Assuming that the voter has the necessary tools to surf the web " +
			"without hinder, the voting should be carried out with the same ease as the procedure in 1a is for a person without motor impairments.")
		),
		
	Task("T2") has (
		Label("maintask2"),
		Gist("Carry out voting via machine"),
		Why("Let a person place a vote on a machine."),
		Trigger("A voter goes to a place with a voting machine and wants to place a vote."),
		Frequency("The machine might be used continuously during open hours throughout the entire voting period.")
		
	),
	Task("T2") owns (
		Task("T2a Carry out voting via machine - the typical case"),
		Task("T2b Carry out voting via machine - visually impaired"),
		Task("T2c Carry out voting via machine - non-Swedish speaking voter"),
		Task("T2d Carry out voting via machine - voter has motor impairments"),
		Task("T2e Carry out voting via machine - voter has cognitive impairments")
	),
	
	Task("T2") owns (
		Task("T2.1 Authenticate"),
		Task("T2.2 Choose party and candidate"),
		Task("T2.3 Confirm"),
		Task("T2.4 Receive confirmation")
	),

		// Subtasks	
		Task("T2.1 Authenticate") has (
			Label("subtask2.1"),
			Gist("The voter shows an accepted identification document and scans his or her identification card.")
		),
			
		Task("T2.2 Choose party and candidate") has (
			Label("subtask2.2"),
			Gist("The voter chooses the party and candidate that he/she wishes to vote for in the web interface on the machine.")
		),
		
		Task("T2.3 Confirm") has (
			Label("subtask2.3"),
			Gist("The voter confirms that the chosen party is indeed the one he/she wants to vote for, using the web interface on the machine.")
		),
		
		Task("T2.4 Receive confirmation") has (
			Label("subtask2.4"),
			Gist("The voter receives a personalized message confirming that the vote was counted for the correct party."),
			Comment("It should be very difficult to fake this confirmation message.")
		),

		// Variants
		Task("T2a Carry out voting via machine - the typical case") has (
			Label("variant2a"),
			Gist("A person without any special needs votes using a machine at a voting place"),
			Spec("The voter uses a computer which is designed to only operate the web voting interface. The voter shows his/her valid identification " +
			"to at least two election inspectors and scans some kind of barcode (or similar) on the personal voting card. The voter is assigned a voting booth where a computer is situated. " +
			"This computer has minimal functionality and can only operate the web interface for voting. Confirmation message is sent to the voter " +
			"in the same way as in Task 1.")
		),
		
		Task("T2b Carry out voting via machine - visually impaired") has (
			Label("variant2b"),
			Gist("A person with a visual impairment votes using a machine at a voting place"),
			Spec("The public voting machines are equipped with technologies that enable a visually impaired person to use them. This makes voting identical to the case in 1b."),
			Comment("In case text-to-speech is used, it should not be possible to hear the output from outside of the booth where the machine is placed."),
			Example("The voting machines might be placed in sound isolated booths or be equipped with headphones in order to provide text-to-speech functionality.")
		),
		
		Task("T2c Carry out voting via machine - non-Swedish speaking voter") has (
			Label("variant2c"),
			Gist("A person who doesn't understand Swedish votes using a machine at a voting place"),
			Spec("This should be identical to 1c.")
		),

		Task("T2d Carry out voting via machine - voter has motor impairments") has (
			Label("variant2d"),
			Gist("A person with motor impairments votes using a machine at a voting place"),
			Spec("The public voting machines are equipped with voice recognition functions to enable the voter to use them. The general procedure is identical to the typical case (Task 2a)."),
			Comment("It must not be possible to conclude what was voted for from outside the voting booth. One example is to use sound isolated booths. Another way might be to construct the user interface in a way that does not encourage the voter to say out loud what (s)he is voting for.")
		),

		Task("T2e Carry out voting via machine - voter has cognitive impairments") has (
			Label("variant2e"),
			Gist("A person with cognitive impairments votes using a machine at a voting place"),
			Spec("The designers of the user interface should strive to make it as easy and efficient to use as possible.")
		),

	// Function requirements
	Function("Authentication when voting electronically from home") has (
		//What does the R_. mean?
		//Answer: It's a placeholder for the unique ID's that every requirement needs in the final document.
		Spec("<b>R_. Authentication of the voter should be done using an existing electronic identification system that the voters feel " +
		"comfortable using.</b>"),
		Example("A well-known example of such a system is BankID."),
		Label("Authentication")
	),
	Function("Send confirmation to voter") has (
		Spec("<b>R_. A personalized confirmation message should be sent to the voter after a placed vote. It should only be possible for the voter " +
		"to decipher it.</b>"),
		Label("Individual verifiability")
	),
	Function("GUI information") has (
		Spec("<b>R_. The GUI should not display any information in excess of the GUI mockups and what is defined in the Swedish electoral law.</b>"),
		Label("GUI")
	),
	Function("Party view") has (
		Spec("<b>R_. The order of the parties that are viewed in the GUI should be randomized. The parties that are in the parliament should, however, be placed above all other parties in the list." +
		"be in a separate list.</b>"),
		Why("No single party must get any special benefits from the way the list is sorted."),
		Label("GUI")
	),
	Function("Voting machines at a voting place") has (
		Spec("At the voting places, each voting booth should have a computer whose only functionality is to run the web interface for voting."),
		Label("GUI")
	),
	Function("Authentication when voting electronically at a voting place") has (
		Spec("To be able to use a voting machine at a voting place, the voter needs to be identified by at least two election inspectors and " +
		"scan some kind of barcode (or similar) on the voter's voting card."),
		Label("GUI")
	),
	Function("One-Voter-One-Vote") has (
		Spec("R_. Only one vote per voter should go to the tallying phase of the voting."),
		Label("Security")
	),

	Function("Voting to Tallying phase transition") has (
		Spec("It should not be possible to start tallying phase before the voting phase has terminated."),
		Label("Fairness")
	),

	Function("Envelope-Voter-Connection") has (
		Spec("During the voting phase, each encrypted vote must have a connection to its voter."),
		Why("To allow users to vote multiple times, where the old electronical vote is overridden by the new one."),
		Comment("supports F07, F10 and F11")
	),


	//Covered in data dictionary? Yes, but it's not that big a deal.
	Function("Vote encryption") has (
		Spec("Each vote shall be encrypted so that it is not possible for anyone but the voter to find out what the vote is placed on or who placed the vote."),
		Label("Privacy")
	),

	Function("Eligibility check") has (
		Spec("Only people present in the electoral register shall be able to place a vote in the system."),
		Label("Voter eligibility check")
	),

	Function("Support for unlimited amount of individual votes") has (
		Spec("Each voter must be allowed to vote via the electronic system as many times as desired. Only the last vote placed shall be tallied."),
		Why("If a voter is pressured to place a vote against his or her will, it shall be possible to undo a previous vote at the voter's discretion."),
		Label("Coercion-resistance & Receipt-freeness")
	),

//	Function("Vote traceability") has (
//		Spec("Each electronical vote must be connected to its voter, but not in a traceable way."),
//		Why("It must be possible to determine which of the voter's votes shall be tallied."),
//		Label("Coercion-resistance & Receipt-freeness")
//	),
	
	Function("Voting place overrides vote placed from home") has (
		Spec("Any vote submitted at a public voting place (on paper or from a machine) should override any votes placed from a personal computer by the same voter."),
		Why("If a voter is unable to use the electronic voting system at home without privacy or coercion, the public voting places provide a means of voting that is guaranteed to be free of these problems."),
		Label("Coercion-resistance & Receipt-freeness")
	),
	
	Function("Language support") has (
		Spec("The web interface must support the addition of other languages than Swedish."),
		Why("It must be possible for non-Swedish speaking voters to vote."),
		Label("Language")
	),
	
	Function("Change language") has (
		Spec("The start page of the web interface should present an obvious way (for all voting stakeholders) of changing language."),
		Why("It must be trivial for non-Swedish speaking voters to vote in their own language."),
		Label("Language")
	),

	//VOTING
	Function("Vote for an unregistered candidate") has (
		Spec("It should be possible to vote for a candidate in a party that has no notified candidates by writing a name and other information in a text box."),
		Why("If a party doesn't notify candidates for the election it should still be possible to vote for a candidate by writing the name in a text box."),
		Label("Voting")
	),
	
	//ADMIN

	Function("Read paper votes") has (
		Spec("The admin interface must have functionality to read counted paper votes in an appropriate form of data."),
		Why("The vote counting system must know of the paper votes in order to produce a complete voting result."),
		Label("Vote count")
	),
	
	Function("Assembling and counting of votes") has (
		Spec("The vote counting system shall be able to assemble the input paper votes and all electronic votes and produce a complete result."),
		Label("Vote count")
	),

	Function("Assembling and counting of unregistered candidates") has (
		Spec("The system should be able to produce a result on votes on unregistered candidates."),
		Why("When people use the text box to vote on an unregistered candidate the vote has to be counted manually. When the system produces a result the votes on unregistered candidates have to be presented separately."),
		Label("Vote count")
	),

	Function("Initiate vote count") has (
		Spec("It should be possible to initiate counting of all the votes received by the system, via the admin interface.<br>"),
		Label("Vote count")
	),

	Function("Admin warnings") has (
		Spec("When initiating counting of votes, the admin interface should warn about appropriate deviations in the system " +
			"(e.g. no paper votes have been read)."),
		Label("Vote count")
	),

	Function("Start voting phase") has (
		Spec("The admin interface must have functionality to start the voting phase."),
		Label("Admin functionality")
	),

	Function("End voting phase") has (
		Spec("The admin interface must have functionality to end the voting phase."),
		Label("Admin functionality")
	),

	Function("Import party data") has (
		Spec("The admin interface must have functionality to import party and candidate data into the system"),
		Example("The party and candidate data may be imported from an Excel file"),
		Label("Admin functionality")
	),

	Function("Import voter data") has (
		Spec("The admin interface must have functionality to import voter data into the system"),
		Example("The voter data may be imported from an Excel file"),
		Label("Admin functionality")
	),

	//Quality requirements
	Quality("Maximum downtime") has (
		Spec("The system should be possible to use _% of the voting process period."),
		Label("Reliability / Availability")
	),

	Quality("Maximum testing time") has (
		Spec("Assuming a test system is up and running, it should be possible to simulate a real voting process in less than _ hours."),
		Label("Testability")
	),

	Quality("Voter interface ease of use") has (
		Spec("_ % of randomly selected voters should be able to place a vote within 2 minutes from opening the voting site."),
		Label("Usability")
	),

	Quality("Administrator interface ease of use") has (
		Spec("_ % of the administrators shall learn to use all administrative functions in 8 hours."),
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
		//Difficult to verify. Should we specify what parts? And to what extent?
		Spec("Some of the servers should be allowed to fail/become compromised, and the system should still work."),
		Example("Anonymity should still be enforced <br> Correct result should be obtained")
	),
	
	// Relationships
	Product("Electronic voting system") helps Goal("G01. Reduce manual labour"),
	Product("Electronic voting system") helps Goal("G02. Facilitate voting for people who have difficulties getting to a voting place"),
	Product("Electronic voting system") helps Goal("G03. Facilitate voting for people who have difficulties using the current manual voting system"),
	Product("Electronic voting system") helps Goal("G04. Maintain the current election turnout"),
	Product("Electronic voting system") helps Goal("G05. Maintain democracy"),
	
	Function("Authentication when voting electronically from home") helps Goal("G05. Maintain democracy"),
	Function("Send confirmation to voter") helps Goal("G05. Maintain democracy"),
	Function("GUI information") helps Goal("G05. Maintain democracy"),
	Function("Party view") helps Goal("G01. Reduce manual labour"),
	Function("Voting machines at a voting place") helps Goal("G01. Reduce manual labour"),
	Function("Authentication when voting electronically at a voting place") helps Goal("G05. Maintain democracy"),
	Function("One-Voter-One-Vote") helps Goal("G05. Maintain democracy"),
	Function("Voting to Tallying phase transition") helps Goal("G05. Maintain democracy"),
	Function("Envelope-Voter-Connection") helps Goal("G05. Maintain democracy"),
	Function("Vote encryption") helps Goal("G05. Maintain democracy"),
	Function("Eligibility check") helps Goal("G05. Maintain democracy"),
	Function("Support for unlimited amount of individual votes") helps Goal("G05. Maintain democracy"),
	Function("Voting place overrides vote placed from home") helps Goal("G05. Maintain democracy"),
	Function("Language support") helps Goal("G03. Facilitate voting for people who have difficulties using the current manual voting system"),
	Function("Change language") helps Goal("G03. Facilitate voting for people who have difficulties using the current manual voting system"),
	Function("Read paper votes") helps Goal("G04. Maintain the current election turnout"),
	Function("Assembling and counting of votes") helps Goal("G05. Maintain democracy"),
	Function("Initiate vote count") helps Goal("G01. Reduce manual labour"),
	Function("Admin warnings") helps Goal("G01. Reduce manual labour"),
	Function("Start voting phase") helps Goal("G01. Reduce manual labour"),
	Function("End voting phase") helps Goal("G01. Reduce manual labour"),
	Function("Import party data") helps Goal("G01. Reduce manual labour"),
	Function("Import voter data") helps Goal("G01. Reduce manual labour")
)
