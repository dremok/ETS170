var m = Model(
	Product("Electronic Voting System") owns Interface("VoterUI"),
		Feature("Choose candidate") has Status(ELICITED),
		Interface("VoterUI") has (
			Gist("User interface for voters."),
			Status(ELICITED)
		)
	)
