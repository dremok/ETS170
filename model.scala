import reqT._

var m = Model(
	Product("Electronic Voting System") has
		(Gist("An electronic voting system which will complement the manual system used today."),
		 Spec("The system shall conform to the context diagram above. It describes the interactions between voters, electoral workers and the voting system. A voter can either submit a vote via the web from home, on an electronic voting machine at a voting place or on paper to an electoral worker. The electoral workers submit relevant information to the system before the election period. Paper votes are submitted to the system using a similar procedure as the parties and candidates after the end of the voting phase. In addition to this, electoral workers need to identify any free-text candidates and register those votes in the system. Finally, the system can calculate the result of the voting."),
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
	Stakeholder("S04. Mobility impaired / hospitalized") has (
		Spec("This group includes people who may be incapable of moving to a voting place."),
		Prio(2),
		Comment("Stakeholder's goals: Be able to vote from where they are.")
	),
	Stakeholder("S05. Cognitive impairment") has (
		Spec("This group includes people who may have difficulties operating any voting system."),
		Example("Patients suffering from dementia, Alzheimer's disease or senility."),
		Prio(1),
		Comment("Stakeholder's goals: As many cognitively impaired as possible should be able to vote. Risks/costs: User interface too complicated to understand." +
		"<br>This stakeholder has low priority since it is unlikely that an electronic system will be of much help regarding severe examples of this impairment. These voters will probably continue to vote via mail or via representative.")
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
		Comment("Stakeholder's goals: Voting shall be done as smoothly as before. Risks/costs: Voting gets too confusing." +
		"<br>This stakeholder has low priority since it is unlikely that an electronic system will be of much help regarding severe examples of this impairment. These voters will probably continue to vote via mail or via representative.")
	),
	Stakeholder("S09. Voters who are uninterested in using an electronic voting system") has (
		Spec("This group includes voters who regards election day as a traditional event that should not change."),
		Prio(1),
		Comment("Stakeholder's goals: Voting process should be changed as little as possible. Risks/costs: Turnout is decreased among voters who have a tradition of going to a voting place to vote." +
		"<br>This stakeholder has low priority since it is unlikely that an electronic system will be of much help regarding severe examples of this impairment. These voters will probably continue to vote via mail or via representative.")
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
		Comment("Risk with stakeholder: If the system has low security it might be exploited by hackers.")
	),
	
	// Features
	
	Feature("F01. Web interface for voting") has (
		Spec("GUI that allows the user to place a vote.")
	),
	Feature("F02. Input of election data to database") has (
		Spec("Ability to add parties, candidates, a start time and an end time for the election to the database.")
	),
	Feature("F03. Send vote to server") has (
		Spec("Functionality that carries out transmission of vote data from client to server."),
		Deprecated("Changed into a function requirement.")
	),
	Feature("F04. Individual Verifiability") has (
		Spec("Ability for the voter to verify that his/her vote was placed on the intended entities.")
	),
	Feature("F05. Counting of electronic votes") has (
		Spec("Possibility for the system to count the votes in the data received from clients.")
	),
	Feature("F06. Support for different languages") has (
		Spec("Support for showing all output to the user in arbitrary languages.")
	),
	Feature("F07. Input of paper votes") has (
		Spec("Ability to read data of votes submitted on paper and store together with electronic votes.")
	),
	Feature("F08. Privacy") has (
		Spec("Functionality to prevent extraction of information about someone else's vote.")
	),
	Feature("F09. Authentication when voting electronically from home") has (
		Spec("Functionality to allow for user authentication.")
	),
	Feature("F10. Voter eligibility check") has (
		Spec("Functionality to ensure that only voters that are allowed to vote can vote.")
	),
	Feature("F11. Coercion-Resistance & Receipt-Freeness") has (
		Spec("Properties of the system that prevent a voter to prove how he/she ultimately votes. " + 
		     "These properties also counter attempts to coerce someone to vote in a particular way, " +
		     "making it pointless since there is no way of knowing how the vote was placed.")
	),
	Feature("F12. Fairness") has (
		Spec("Properties of the system that prevent any vote results from being revealed while the system is in the voting phase.")
	),
	Feature("F13. Admin interface") has (
		Spec("The system shall have an admin interface.")
	),
	Feature("F14. Support for visually impaired voters") has (
		Spec("The electronic voting system shall support visually impaired voters.")
	),
	Feature("F15. Support for voters with motor disabilities") has (
		Spec("Ability for disabled voters to use the system to place a vote without assistance from another person.")
	),
	Feature("F16. Support for cognitive disabilities") has (
		Spec("The system shall support voters with cognitive impairments so that they can vote without assistance from another person.")
	),
	Feature("F17. Support for the illiterate & dyslectic") has (
		Spec("The system shall support voters who have reading problems or problems to understand written text.")
	),
	
	// Goals
	Goal("G01. Reduce manual labour") has (
		Spec("Reduce the number of public voting places and the number of votes to be handled manually."),
		Why("Requested by Valmyndigheten.")
	),
	Goal("G02. Facilitate voting for people who have difficulties getting to a voting place") has (
		Spec("Make it easier for the disabled, very ill, etc. by permitting voting from where they are situated."),
		Why("Requested by Valmyndigheten.")
	),
	Goal("G03. Facilitate voting for people who have difficulties using the current manual voting system") has (
		Spec("Make it easier to vote for the visually impaired and other groups who experience that the current system can be difficult, " +
		"so that they can vote as unhindered as the rest of the population."),
		Why("Requested by Valmyndigheten.")
	),
	Goal("G04. Maintain the current election turnout") has (
		Spec("The new system shall not have any significant negative impact on the election turnout."),
		Why("A prerequisite for introducing a new election process is that the new system is in no discernible way inferior to the old one.")
	),
	Goal("G05. Maintain democracy") has (
		Spec("Any attempts at compromising the legitimacy of the election or the maintenance of democracy shall be countered by the system."),
		Why("The system must be equally suitable or superior to the current system at maintaining democracy.")
	),
	Goal("G06. Counter hacking attempts, promote security") has (
		Spec("Undermining the election process by exploiting the fact the votes are submitted electronically shall be very difficult."),
		Why("An electronic system introduces new threats to the election process. These must be countered in order to maintain the quality of the process.")
	),
	
	//Data Dictionary
	Class("ER Diagram") has (
		Spec("The ER diagram shows the relations between the entities in the system's data structure. It must be followed."),
		Image("ETS170 ER diagram.png")
	),

	Class("Voter") has (
		Gist("Can vote in the election"),
		Spec("A voter is someone who has voting rights in Sweden. The point of the voter class is to make sure one individual may only have one of its respective votes counted. A voter must at all times have a vote associated with it. The model must be able to hide whether a voter has voted or not as well as which party it has voted upon. A voter must for each votable party have a personal verification code. Every voter must have a means to authenticate him- or herself via the authentication system in use."),
		Example("(1) A person who has voting rights but does not vote.<br>" +
			"(2) A person who has voting rights and does place a vote.")

	),

	Class("Party") has (
		Gist("A party which can receive a vote from the voters"),
		Spec("Each votable party is represented with a party in the system. A blank vote counts as being placed on the \"blank\" party. There is also a \"no-vote\" party that is used to hide who has not voted at all."),
		Example("(1) The pirate party.<br>" +
			"(2) The \"blank\" party.<br>" +
			"(3) The \"no-vote\" party.")
	),

	Class("Party Candidate") has (
		Gist("A member of a party who the voters can vote for"),
		Spec("A party candidate is party appointed candidate. A party candidate is eligible to receive candidate votes. Also knows which party it belongs to."),
		Example("(1) Anna Troberg of the pirate party.<br>" +
			"(2) \"blank\" of any party.")
	),

	Class("Electoral area") has (
		Gist("A geographical area associated with a subset of the voters and party candidates"),
		Spec("The electoral areas partition the voters, i.e. a voter belongs to one electoral area only. A party candidate can belong to any number of electoral areas."),
		Example("(1) Stockholms kommuns valkrets<br>" +
			"(2) Blekinge läns valkrets")
	),

	Class("Vote") has (
		Gist("A vote can be placed by a voter on a party and candidate"),
		Spec("A Vote is placed by a voter on a party and a party candidate. The vote is masked in such a way that there is no way for an outsider to determine which candidate and party the vote was placed on, nor who placed the vote, while still being connected to its voter. The party candidate which is being voted upon must be a party candidate from the party being voted on. Each vote also has a time-stamp. At the start of the voting phase, a place-holder vote on the \"no-vote\" party is created for each voter, so that it is impossible to tell who has not voted by looking at the database contents."),
		Example("(1) A vote on pirate party and \"blank\" candidate.<br>" +
			"(2) A vote on \"blank\" party and \"blank\" candidate.<br>" +
			"(2) A place-holder vote on the \"no-vote\" party.")
	),
		
	//CRUD
	Class("Voter") has (
		Comment("It shall be possible to create, read and delete voters. CRD is only applied during the pre-election phase; during the other phases it is only possible to read voters.")
	),

	Class("Party") has (
		Comment("It shall be possible to create, read, and delete parties. CRD is only applied during the pre-election phase; during the other phases it is only possible to read parties.")
	),

	Class("Party Candidate") has (
		Comment("It shall be possible to create, read and delete party candidates. CRD is only applied during the pre-election phase and pre-tallying phase; during the other phases it is only possible to read party candidates.")
	),

	Class("Vote") has (
		Comment("It shall only be possible to create and read votes, not delete or update them, although votes are automatically deleted from the database at the end of the tallying phase. Votes can only be created during the voting phase and pre-tallying phase and only be read during the tallying phase.")
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
		Task("T1a Carry out voting via the web interface - the typical case"),
		Task("T1b Carry out voting via the web interface - visually impaired"),
		Task("T1c Carry out voting via the web interface - non-Swedish speaking voter"),
		Task("T1d Carry out voting via the web interface - voter has motor impairments")
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
			Spec("The voter enters his/her personal code on the received voting card in the web interface and authenticates him-/herself using " +
			"electronic identification."),
			Example("An example of a suitable identification procedure is BankID.")
		),
			
		Task("T1.2 Choose party and candidate") has (
			Label("subtask1.2"),
			Spec("The voter chooses the party and candidate that he/she wishes to vote for in the web interface.")
		),
			
		Task("T1.3 Confirm") has (
			Label("subtask1.3"),
			Spec("The voter confirms that the chosen party and candidate is indeed the one he/she wants to vote for, using the web interface.")
		),
			
		Task("T1.4 Receive confirmation") has (
			Label("subtask1.4"),
			Spec("The voter is able to verify how he/she voted through a confirmation message from the system."),
			Comment("It must be very difficult to fake this confirmation message.")
		),
		
		Task("T1a Carry out voting via the web interface - the typical case") has (
			Label("variant1a"),
			Gist("A person without any special needs uses the web interface to vote"),
			Example("The voter chooses to vote through the web interface. On the voting card there is a web adress to the voting website. " +
				"The voter opens up this site in a web browser, logs in using electronic identification enters the personal code " +
				"stated on the voting card. A party and a candidate is chosen in the web interface. The voter clicks on a 'Submit' button. " +
				"The voter then receives some kind of message and is able to confirm what he/she voted for.")
		),	
		
		Task("T1b Carry out voting via the web interface - visually impaired") has (
			Label("variant1b"),
			Gist("A person with a visual impairment uses the web interface to vote"),
			Example("The voter chooses to vote through the web interface. Assuming that the voter has the necessary tools to surf the web " +
			"without hinder, the voting is carried out with the same ease as with the procedure in 1a for a fully sighted person.")
		),
		
		Task("T1c Carry out voting via the web interface - non-Swedish speaking voter") has (
			Label("variant1c"),
			Gist("A person who doesn't understand Swedish uses the web interface to vote"),
			Example("The voter chooses to vote through the web interface. From the voting card it is clear enough what is the web " +
			"adress to the voting web site that no text on the card needs to be understood. As soon as the person enters the web site, " +
			"there shall be a clear possibility to change language to any language that is spoken by a Swedish citizen. The procedure is " +
			"then carried out as in T1a.")
		),
		
		Task("T1d Carry out voting via the web interface - voter has motor impairments") has (
			Label("variant1d"),
			Gist("A person with motor impairments uses the web interface to vote"),
			Example("The voter chooses to vote through the web interface. Assuming that the voter has the necessary tools to surf the web " +
			"without hinder, the voting is carried out with the same ease as with the procedure in T1a for a person without motor impairments.")
		),
		
	Task("T2") has (
		Label("maintask2"),
		Gist("Carry out voting via machine"),
		Why("Let a person place a vote on a machine."),
		Trigger("A voter goes to a place with a voting machine and wants to place a vote."),
		Frequency("The machine might be used continuously during open hours throughout the entire voting period."),
		Comment("The voting machine is a computer which is designed to only operate the web voting interface. It is placed in a voting booth. " +
				"A booth with a machine is automatically assigned to the voter after he/she is authenticated.")
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
			Spec("The voter shows an accepted identification document and scans his or her identification card.")
		),
			
		Task("T2.2 Choose party and candidate") has (
			Label("subtask2.2"),
			Spec("The voter chooses the party and candidate that he/she wishes to vote for in the web interface on the machine.")
		),
		
		Task("T2.3 Confirm") has (
			Label("subtask2.3"),
			Spec("The voter confirms that the chosen party is indeed the one he/she wants to vote for, using the web interface on the machine.")
		),
		
		Task("T2.4 Receive confirmation") has (
			Label("subtask2.4"),
			Spec("The voter is able to verify how he/she voted through a confirmation message from the system."),
			Comment("It must be very difficult to fake this confirmation message.")
		),

		// Variants
		Task("T2a Carry out voting via machine - the typical case") has (
			Label("variant2a"),
			Gist("A person without any special needs votes using a machine at a voting place"),
			Spec("The voter uses a computer which is designed to only operate the web voting interface. The voter shows his/her valid identification " +
			"to at least two election inspectors and scans some kind of barcode (or similar) on the personal voting card. The voter is assigned a voting booth where a computer is situated. " +
			"This computer has minimal functionality and can only operate the web interface for voting. The voter shall be able to verify the placed vote, as in Task T1.")
		),
		
		Task("T2b Carry out voting via machine - visually impaired") has (
			Label("variant2b"),
			Gist("A person with a visual impairment votes using a machine at a voting place"),
			Spec("The public voting machines are equipped with technologies that enable a visually impaired person to use them. This makes voting identical to the case in T1b."),
			Comment("In case text-to-speech is used, it shall not be possible to hear the output from outside of the booth where the machine is placed."),
			Example("The voting machines might be placed in sound isolated booths or be equipped with headphones in order to provide text-to-speech functionality.")
		),
		
		Task("T2c Carry out voting via machine - non-Swedish speaking voter") has (
			Label("variant2c"),
			Gist("A person who doesn't understand Swedish votes using a machine at a voting place"),
			Spec("When the voter enters the booth, it is evident from the user interface how one changes the language. The user changes language and proceeds as in T1a.")
		),

		Task("T2d Carry out voting via machine - voter has motor impairments") has (
			Label("variant2d"),
			Gist("A person with motor impairments votes using a machine at a voting place"),
			Spec("The public voting machines are equipped with voice recognition functions to enable the voter to use them. The general procedure is identical to the typical case (Task T2a)."),
			Comment("It must not be possible to conclude what was voted for from outside the voting booth. One example is to use sound isolated booths. Another way might be to construct the user interface in a way that does not encourage the voter to say out loud what (s)he is voting for.")
		),

		Task("T2e Carry out voting via machine - voter has cognitive impairments") has (
			Label("variant2e"),
			Gist("A person with cognitive impairments votes using a machine at a voting place"),
			Spec("The designers of the user interface shall strive to make it as easy and efficient to use as possible.")
		),

	Task("T3") has (
		Label("maintask3"),
		Gist("Set up election"),
		Why("Make sure that all prerequisites for running an election, using this system, are fulfilled."),
		Trigger("Valmyndigheten decides that an election shall be carried out, and assigns an admin to set it up.")
	),
	
	Task("T3") owns (
		Task("T3.1 Import party/candidate data"),
		Task("T3.2 Set dates for the election"),
		Task("T3.3 Confirm")
	),

		// Subtasks	
		Task("T3.1 Import party/candidate data") has (
			Label("subtask3.1"),
			Spec("The admin uses the admin interface to choose the files to import. These files must contain party and candidate data " +
				"in the correct format, as specified in the design requirements.")
		),
			
		Task("T3.2 Set time and duration for the election") has (
			Label("subtask3.2"),
			Spec("The admin uses the admin interface to set start- and end date for the election.")
		),
		
		Task("T3.3 Confirm") has (
			Label("subtask3.3"),
			Spec("The admin uses the admin interface to confirm that the party/candidate data and entered dates are correct.")
		),


	// Function requirements
	Function("R04. Authentication when voting electronically from home") has (
		Spec("The system shall authenticate the voter using an existing electronic identification system that the voters feel " +
		"comfortable using."),
		Example("A well-known example of such a system is BankID."),
		Label("Authentication")
	),
	Function("R05. Send confirmation to voter") has (
		Spec("After a vote is received by the server, the system shall send a personalized confirmation message to the voter. It must be very difficult to decipher this message for anyone but the voter who placed the vote."),
		Example("One way is to send a text message to the voter's cellphone with a code that translates to the party that was voted on, and these codes are randomly generated for each voter in advance. The codes could for example be distributed with the voting cards."),
		Label("Individual verifiability")
	),
	Function("R06. GUI information") has (
		Spec("The GUI shall display information according to the electoral laws on what information is allowed on a voting paper."),
		Label("GUI"),
		Deprecated("Moved to design requirements.")
	),
	Function("R07. Party view") has (
		Spec("The order of the parties that are viewed in the GUI shall be randomized. The parties currently in parliament are placed above all other parties in the list."),
		Why("No single party must get any special benefits from the way the list is sorted. However, parties in parliament are so commonly voted on that they must be easy to find in the list."),
		Label("GUI")
	),
	Function("R08. Voting machines at a voting place") has (
		Spec("At the voting places, each voting booth must have a computer whose only functionality is to run the web interface for voting."),
		Label("GUI"),
		Deprecated("This is not really a function requirement. The requirement is covered in task T2.")
	),
	Function("R09. Authentication when voting electronically at a voting place") has (
		Spec("At voting places with voting machines, the system must have functionality to scan some kind of barcodes or similar from the voter's voting card."),
		Why("To be able to use a voting machine at a voting place, the voter needs to be identified by at least two election inspectors and also scan the personal voting card."),
		Label("GUI")
	),
	Function("R10. One-Voter-One-Vote") has (
		Spec("During the tallying phase of the system, only one vote per voter shall exist."),
		Label("Security")
	),

	Function("R11. Voting to Tallying phase transition") has (
		Spec("The system shall prohibit the admin from starting the tallying phase before the voting phase has terminated."),
		Label("Fairness")
	),

	Function("R12. Envelope-Voter-Connection") has (
		Spec("During the voting phase of the system, each encrypted vote must have a connection to its voter."),
		Why("To allow users to vote multiple times, where the old electronical vote is overridden by the new one.")
	),


	//Covered in data dictionary? Yes, but it's not that big a deal.
	Function("R13. Vote encryption") has (
		Spec("The system shall encrypt each vote before storing it in the database."),
		Why("It must not be possible for anyone but the voter to find out what the vote is placed on or who placed the vote."),
		Label("Privacy")
	),

	Function("R14. Eligibility check") has (
		Spec("The system must prohibit anyone not present in the electoral register to place a vote."),
		Label("Voter eligibility check")
	),

	Function("R15. Support for unlimited amount of electronic votes placed from home") has (
		Spec("Each voter must be allowed to vote via the electronic system as many times as desired.<br>" +
				"Assuming that the voter hasn't placed any overriding votes, only the last electronic vote placed from a personal computer shall be tallied."),
		Why("If a voter is pressured to place a vote against his or her will, it shall be possible to override a previous vote at the voter's discretion."),
		Label("Coercion-resistance & Receipt-freeness")
	),
	
	Function("R16. Voting place overrides vote placed from home") has (
		Spec("Any vote submitted at a public voting place (on paper or from a machine) must override any votes placed from a personal computer by the same voter. A vote placed via mail is overridden by a paper vote placed at a voting place."),
		Why("If a voter is unable to use the electronic voting system at home without privacy or coercion, the public voting places provide a means of voting that is guaranteed to provide privacy and be coercion-free. " +
			"If a voter was coerced into voting against his/her intentions, he/she is the able to override this vote later during the voting period."),
		Label("Coercion-resistance & Receipt-freeness")
	),
	
	Function("R17. Language support") has (
		Spec("The web interface must support the addition of other languages than Swedish."),
		Why("It must be possible for non-Swedish speaking voters to vote."),
		Label("Language")
	),
	
	Function("R18. Change language") has (
		Spec("The start page of the web interface must present an obvious way (for all voting stakeholders) of changing language."),
		Why("It must be trivial for non-Swedish speaking voters to vote in their own language."),
		Deprecated("Moved to design requirements."),
		Label("Language")
	),

	//VOTING
	Function("R19. Vote for an unregistered candidate") has (
		Spec("The web interface must present a way to vote for a candidate in a party that has no notified candidates."),
		Why("If a party doesn't notify candidates for the election it shall still be possible to vote for a candidate by " +
			"writing the name and other information that distinguishes the intended person."),
		Example("It can be done with a text box where the voter can write a name and other information."),
		Label("Voting")
	),
	
	//ADMIN

	Function("R20. Read paper votes") has (
		Spec("The admin interface must have functionality to read counted paper votes in an appropriate form of data."),
		Why("The vote counting system must know of the paper votes in order to produce a complete voting result."),
		Label("Vote count")
	),
	
	Function("R21. Assembling and counting of votes") has (
		Spec("The system shall be able to assemble the input paper votes and all electronic votes and produce a complete result."),
		Label("Vote count")
	),

	Function("R22. Assembling and counting of unregistered candidates") has (
		Spec("The system must be able to produce a result of votes on unregistered candidates."),
		Why("When people use the text box to vote on an unregistered candidate the vote has to be verified manually. When the the voting closes, the votes on unregistered candidates have to be presented separately."),
		Label("Vote count")
	),

	Function("R23. Initiate vote count") has (
		Spec("It must be possible to initiate counting of all the votes received by the system, via the admin interface."),
		Label("Vote count")
	),

	Function("R24. Start voting phase") has (
		Spec("The admin interface must have functionality to start the voting phase."),
		Label("Admin functionality"),
		Deprecated("The voting phase will automatically start according to a time set in the database. See R30.")
	),

	Function("R25. End voting phase") has (
		Spec("The admin interface must have functionality to end the voting phase."),
		Label("Admin functionality"),
		Deprecated("The voting phase will automatically end according to a time set in the database. See R30.")
	),

	Function("R26. Import party/candidate data") has (
		Spec("The admin interface must have functionality to push party and candidate data to the database."),
		Example("The party and candidate data may be imported from an Excel file"),
		Label("Admin functionality")
	),

	Function("R27. Import voter data") has (
		Spec("The admin interface must have functionality to import voter data into the system"),
		Example("The voter data may be imported from an Excel file"),
		Label("Admin functionality")
	),

	Function("R28. Admin warnings - Counting of votes") has (
		Spec("When initiating counting of votes, the admin interface must raise a warning if any of the following situations occur:" +
		     "<br>No paper votes have been written to the database during the election period." +
		     "<br>Votes placed on unregistered candidates remain in the database." +
		     "<br>Votes placed on unregistered candidates have been extracted from the database, but the new votes have not been registered."),
		Example("(1) Notify the user that no paper votes have been read. (2) Notify the user that there are votes on unregistered candidates"),
		Label("Admin functionality")
	),

	Function ("R29. Admin warnings - Starting and ending a phase") has (
		Spec("When the admin starts or ends a phase a confirmation dialog is shown."),
		Example("\"Are you sure you want to end the pre-tallying phase and start tallying phase?\""),
		Label("Admin functionality")
	),

	Function ("R30. Input start and end times into database") has (
		Spec("The admin interface shall have functionality for specifying a start time and an end time for the voting phase."),
		Label("Admin functionality")
	),

	Function ("R31. Process free-text candidate votes") has (
		Spec("The admin interface shall, during the pre-tallying phase, enable administrators to extract the votes placed on free-text candidates. " +
			"The votes shall be presented in a way that makes it impossible to trace them to their voters. If a candidate can not be identified, " +
			"it shall be possible to remove the corresponding vote from the database. If a candidate is identified, it shall be possible to register " +
			"the candidate in the database and replace the free-text vote with a vote on this candidate."),
		Why("Free-text candididates can not be identified automatically. A human administrator must manually identify the candidates. " +
			"If this is not possible, the vote is invalid and must be removed. In order to perform the tallying, all candidates that have been voted on must have a proper entry in the database."),
		Example("The free-text votes might be exported as an Excel file, and the votes are automatically deleted from the database. The new votes might be imported as an Excel file, " +
			"possibly with any new candidates automatically created in the database."),
		Label("Admin functionality")
	),

	Function ("R32. Log out") has (
		Spec("Once logged in, it must be possible to log out from the system."),
		Label("Authentication")
	),
	Function ("R33. Non-voter anonymity") has (
		Spec("At the start of the voting phase, every voter must automatically have a place-holder vote on the \"no-vote\" party."),
		Why("It must not be possible to tell from the database contents if a certain person has voted or not. If someone gained access to the database they might theoretically be able to tell if a specific person's vote was present or not, unless every eligible voter always has at least one vote in the database."),
		Label("Privacy")
	),

	Function("R34. Time out") has (
		Spec("When a logged in user has been inactive for more than 5 minutes the user shall be automatically logged out."),
		Why("If a user forgets to log out someone else may vote in the user's name."),
		Label("Authentication")
	),

		//Design-level requirements
	Design("D01. start-page") has (
		Spec("The web GUI must have a start page which is first shown when pointing a browser toward the voting interface. From here you can change language and authenticate.")
	),
	Design("D02. start-page - Change language") has (
		Spec("The start page of the web interface must present an obvious way (for all voting stakeholders) to change language."),
		Why("It must be trivial for non-Swedish speaking voters to vote in their own language.")
	),

	Design("D03. vote-page") has (
		Spec("The web GUI must have a page where the actual voting is conducted. This is where you select the party and candidate you want to vote for.")
	),

	Design("D04. vote-page - Information") has (
		Spec("The vote-page shall display information according to the electoral laws on what information is allowed on a voting paper.")
	),

	Design("D05. vote-page - Free-text") has (
		Spec("In case a party does not have any registered candidates, the vote-page shall have a text box where the voter can insert name and other information that distinguishes a person.")
	),

	Design("D06. vote-page - vote for party") has (
		Spec("When the user enters the vote-page the user is presented with the view above."),
		Image("vote_party.png")
	),

	Design("D07. vote-page - vote for candidate") has (
		Spec("When the user clicks on a party on the vote-page the candidates must be shown as shown in the view above."),
		Image("vote_candidate.png")
	),	

	Design("D08. vote-page - confirmation") has (
		Spec("When the user clicks on \"Rösta!\" a confirmation overlay must be shown as shown in the view above."),
		Image("vote_done.png")
	),

	Design("D09. admin-page") has (
		Spec("The web GUI must have a page where administrative tasks can be conducted by on-server-site authorized personel.")
	),

	Design("D10. admin-page - import party data") has (
		Spec("The party data file must be in .csv format. Each party name is seperated by a comma name. All parties must be in one row."),
		Example("Socialdemokraterna,Moderaterna,Centerpartiet,Piratpartiet,Feministiskt initiativ")
	),

	Design("D11. admin-page - import candidate data") has (
		Spec("The candidate data file must be in .csv format.<br>The first row contains the candidate names, " +
			"the second each candidate's personal identity number, the third each candidate's party and " +
			"the fourth a priority number for each candidate which is used to decide their order in the GUI and on the ballots." +
			"Then follows one row per candidate (in the same order as they are in the first row), " +
			"with all the electoral areas where he/she candidates."),
		Example("Fredrik Reinfeldt,Maud Olofsson,Gudrun Schyman<br>" +
				"19650804-1099,19550809-7887,19480609-1049<br>" +
				"Moderaterna,Centerpartiet,Feministiskt initiativ<br>" +
				"1,2,1<br>" +
				"Täby Västra,Täby Östra,...<br>" +
				"Robertsfors,Umeå,...<br>" +
				"Simrishamn 9,Simrishamn 8,...")
	),

	Design("D12. Admin-page - design") has (
		Spec("When the admin enters the admin-page the admin is presented with the view above. The above mockup represents the GUI for release 0.1. The admin-page must be modifiable and extendable for release 1.0 and 2.0. "),
		Image("admin.png")
	),

	Design("D13. Admin-page - Save") has (
		Spec("The save button (\"Spara\") on the admin page saves the actions performed on the admin page. This includes: importing of party data, importing of candidate data, importing of paper votes and setting of start and end dates for the election period.")
	),

	Design("D14. Admin-page - Save party data") has (
		Spec("Any existing data in the party database will be erased and replaced by the imported data.")
	),

	Design("D15. Admin-page - import party data, candidate data and voter data buttons") has (
		Spec("The buttons for importing party data, candidate data and voter data are only clickable during the prevoting phase.")
	),

	Design("D16. Admin-page - Import votes") has (
		Spec("The button for importing votes is only clickable during the tallying phase.")
	),

	Design("D17. Admin-page - Set dates") has (
		Spec("Setting the dates is only possible during the prevoting phase.")
	),

	Design("D18. Admin-page - Save candidate data") has (
		Spec("Any existing data in the candidate database it will be erased and replaced by the imported data.")
	),

	Design("D19. Admin-page - Confirm system reset") has (
		Spec("When the system reset button is pressed the admin has to confirm the action via a confirmation dialog.")
	),

	Design("D20. Tallying procedure") has (
		Spec("When the voting period is over and paper votes and free-text votes have been merged into the database, the tallying phase should be prepared by the electoral workers must follow the following procudure:<br>" +
		     "1. All of the database's direct and indirect connections to the internet are closed.<br>" +
		     "2. Each vote is rendered anonymous by throwing away the connection to the voter's identity.<br>" +
		     "3. The votes are transferred to an external storage medium.<br>" +
		     "4. The storage medium is manually transferred to a separate room where the tallying computers reside. These computers have never been connected to the internet in any way.<br>" +
		     "5. The contents of the storage medium is transferred to the tallying computers.<br>" +
		     "6. The key for decrypting the votes is introduced to the system of tallying computers.<br>" +
		     "7. The tallying phase is commenced. Human access to the room during this phase is restricted."),
		Label("Vote count")
	),

	Design("D21. Log out") has (
		Spec("By clicking on a log out button (\"Logga ut\") a logged in user must be logged out.")
	),
	
	Design("D22. Voter eligibility check") has (
		Spec("A voter voting from home authenticates him- or herself via BankID. If the authentication is successful, the voter is looked up in the voter database. If the voter is eligible to vote, the voting GUI will appear. Otherwise, the voter will be denied access."),
		Label("")
	),
	
	//Quality requirements
	Quality("Q01. Maximum downtime") has (
		Spec("The system must be available for voting _% of the voting phase."),
		Why("Valmyndigheten demands this."),
		Label("Reliability / Availability")
	),

	Quality("Q02. Maximum testing time") has (
		Spec("Assuming a test system is up and running, it must be possible to simulate a real voting process in less than _ hours."),
		Label("Testability")
	),

	Quality("Q03. Voter interface ease of use") has (
		Spec("_ % of randomly selected voters must be able to place a vote within 2 minutes from opening the voting site."),
		Comment("Customer expects 80%."),
		Label("Usability")
	),

	Quality("Q04. Administrator interface ease of use") has (
		Spec("_ % of the administrators shall learn to use all administrative functions in 8 hours."),
		Label("Usability")
	),

	Quality("Q05. Vote count correctness") has (
		Spec("_ % of all votes shall be counted correctly, i.e. the same party and candidate that were specified in the vote shall be counted."),
		Comment("Customer expects close to 100%."),
		Label("Correctness")
	),

	Quality("Q06. Web browser compatibility") has (
		Spec("The system shall be compatible with different browsers in such a way that at least _ % of the voters are able to use their default browsers to vote."),
		Comment("Customer expects 90%."),
		Label("Interoperability / Portability")
	),
	Quality("Q07. Robustness/Fault Tolerance") has (
		//Difficult to verify. Should we specify what parts? And to what extent?
		Spec("The system must work even though _ % of the servers do not work at all."),
		Example("Anonymity shall still be enforced.<br>" +
			"Correct result must be obtained.")
	),
	Quality("Q08. Stress case tolerance") has (
		Spec("The system shall be able to receive _ (number) votes every second. Any votes that can not be received must be queued for later processing."),
		Why("The worst case scenario is that a vote from every eligible voter arrives during the same second."),
		Label("Reliability / Availability")
	),

	// Relationships
	Product("Electronic voting system") helps Goal("G01. Reduce manual labour"),
	Product("Electronic voting system") helps Goal("G02. Facilitate voting for people who have difficulties getting to a voting place"),
	Product("Electronic voting system") helps Goal("G03. Facilitate voting for people who have difficulties using the current manual voting system"),
	Product("Electronic voting system") helps Goal("G04. Maintain the current election turnout"),
	Product("Electronic voting system") helps Goal("G05. Maintain democracy"),
	
	Function("R04. Authentication when voting electronically from home") helps Goal("G05. Maintain democracy"),
	Function("R05. Send confirmation to voter") helps Goal("G05. Maintain democracy"),
	Function("R06. GUI information") helps Goal("G05. Maintain democracy"),
	Function("R07. Party view") helps Goal("G05. Maintain democracy"),
	Function("R08. Voting machines at a voting place") helps Goal("G01. Reduce manual labour"),
	Function("R09. Authentication when voting electronically at a voting place") helps Goal("G05. Maintain democracy"),
	Function("R10. One-Voter-One-Vote") helps Goal("G05. Maintain democracy"),
	Function("R11. Voting to Tallying phase transition") helps Goal("G05. Maintain democracy"),
	Function("R12. Envelope-Voter-Connection") helps Goal("G05. Maintain democracy"),
	Function("R13. Vote encryption") helps Goal("G05. Maintain democracy"),
	Function("R14. Eligibility check") helps Goal("G05. Maintain democracy"),
	Function("R15. Support for unlimited amount of electronic votes placed from home") helps Goal("G05. Maintain democracy"),
	Function("R16. Voting place overrides vote placed from home") helps Goal("G05. Maintain democracy"),
	Function("R17. Language support") helps Goal("G03. Facilitate voting for people who have difficulties using the current manual voting system"),
	Function("R18. Change language") helps Goal("G03. Facilitate voting for people who have difficulties using the current manual voting system"),
	Function("R19. Vote for an unregistered candidate") helps Goal("G01. Reduce manual labour"),
	Function("R20. Read paper votes") helps Goal("G04. Maintain the current election turnout"),
	Function("R21. Assembling and counting of votes") helps Goal("G05. Maintain democracy"),
	Function("R22. Assembling and counting of unregistered candidates") helps Goal("G05. Maintain democracy"),
	Function("R23. Initiate vote count") helps Goal("G01. Reduce manual labour"),
	Function("R24. Start voting phase") helps Goal("G01. Reduce manual labour"),
	Function("R25. End voting phase") helps Goal("G01. Reduce manual labour"),
	Function("R26. Import party data") helps Goal("G01. Reduce manual labour"),
	Function("R27. Import voter data") helps Goal("G01. Reduce manual labour"),
	Function("R28. Admin warnings - Counting of votes") helps Goal("G01. Reduce manual labour"),
	Function("R29. Admin warnings - Starting and ending a phase") helps Goal("G01. Reduce manual labour"),
	Function("R30. Input start and end times into database") helps Goal("G01. Reduce manual labour"),
	Function("R31. Process free-text candidate votes") helps Goal("G05. Maintain democracy"),
	Function("R32. Log out") helps Goal("G05. Maintain democracy"),
	Function("R33. Voting") helps Goal("G01. Reduce manual labour"),
	Function("R34. Time out") helps Goal("G05. Maintain democracy"),

	Design("D01. start-page") helps Function("R04. Authentication when voting electronically from home"),
	Design("D01. start-page") helps Function("R17. Language support"),
	Design("D01. start-page") helps Function("R18. Change language"),
	Design("D02. start-page - Change language") helps Function("R17. Language support"),
	Design("D02. start-page - Change language") helps Function("R18. Change language"),
	Design("D03. vote-page") helps Function("R06. GUI information"),
	Design("D03. vote-page") helps Function("R07. Party view"),
	Design("D03. vote-page") helps Function("R08. Voting machines at a voting place"),
	Design("D03. vote-page") helps Function("R19. Vote for an unregistered candidate"),
	Design("D03. vote-page") helps Function("R32. Log out"),
	Design("D03. vote-page") helps Function("R33. Voting"),
	Design("D04. vote-page - Information") helps Function("R06. GUI information"),
	Design("D05. vote-page - Free-text") helps Function("R19. Vote for an unregistered candidate"),
	Design("D06. vote-page - vote for party") helps Function("R06. GUI information"),
	Design("D06. vote-page - vote for party") helps Function("R07. Party view"),
	Design("D06. vote-page - vote for party") helps Function("R32. Log out"),
	Design("D06. vote-page - vote for party") helps Function("R33. Voting"),
	Design("D07. vote-page - vote for candidate") helps Function("R06. GUI information"),
	Design("D07. vote-page - vote for candidate") helps Function("R19. Vote for an unregistered candidate"),
	Design("D07. vote-page - vote for candidate") helps Function("R32. Log out"),
	Design("D07. vote-page - vote for candidate") helps Function("R33. Voting"),
	Design("D08. vote-page - confirmation") helps Function("R33. Voting"),

	Design("D09. admin-page") helps Function("R20. Read paper votes"),
	Design("D09. admin-page") helps Function("R23. Initiate vote count"),
	Design("D09. admin-page") helps Function("R24. Start voting phase"),
	Design("D09. admin-page") helps Function("R25. End voting phase"),
	Design("D09. admin-page") helps Function("R26. Import party data"),
	Design("D09. admin-page") helps Function("R27. Import voter data"),
	Design("D09. admin-page") helps Function("R28. Admin warnings - Counting of votes"),
	Design("D09. admin-page") helps Function("R29. Admin warnings - Starting and ending a phase"),
	Design("D09. admin-page") helps Function("R30. Input start and end times into database"),
	Design("D09. admin-page") helps Function("R31. Process free-text candidate votes"),
	Design("D09. admin-page") helps Function("R32. Log out"),

	Design("D10. admin-page - import party data") helps Function(""),
	Design("D11. admin-page - import candidate data") helps Function(""),
	Design("D12. Admin-page - design") helps Function(""),
	Design("D13. Admin-page - Save") helps Function(""),
	Design("D14. Admin-page - Save party data") helps Function(""),
	Design("D15. Admin-page - import party data, candidate data and voter data buttons") helps Function(""),
	Design("D16. Admin-page - Import votes") helps Function(""),
	Design("D17. Admin-page - Set dates") helps Function(""),
	Design("D18. Admin-page - Save candidate data") helps Function(""),
	Design("D19. Admin-page - Confirm system reset") helps Function(""),
	Design("D20. Tallying procedure") helps Function(""),
	Design("D21. Log out") helps Function("R32. Log out"),
	Design("D22. Voter eligibility check") helps Function(""),

	//TODO: Q02
	Quality("Q01. Maximum downtime") helps Goal("G05. Maintain democracy"),
	Quality("Q01. Maximum downtime") helps Goal("G01. Reduce manual labour"),
	Quality("Q02. Maximum testing time") helps Goal("G05. Maintain democracy"),
	Quality("Q03. Voter interface ease of use") helps Goal("G01. Reduce manual labour"),
	Quality("Q03. Voter interface ease of use") helps Goal("G03. Facilitate voting for people who have difficulties using the current manual voting system"),
	Quality("Q04. Administrator interface ease of use") helps Goal("G01. Reduce manual labour"),
	Quality("Q05. Vote count correctness") helps Goal("G04. Maintain the current election turnout"),
	Quality("Q05. Vote count correctness") helps Goal("G05. Maintain democracy"),
	Quality("Q06. Web browser compatibility") helps Goal("G02. Facilitate voting for people who have difficulties getting to a voting place"),
	Quality("Q07. Robustness/Fault Tolerance") helps Goal("G05. Maintain democracy"),
	Quality("Q07. Robustness/Fault Tolerance") helps Goal("G01. Reduce manual labour"),
	Quality("Q08. Stress case tolerance") helps Goal("G05. Maintain democracy"),
	Quality("Q08. Stress case tolerance") helps Goal("G01. Reduce manual labour")
)
