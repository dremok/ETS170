/*
Generates HTML from model m according to the following template.
*/

def mWithoutLabels(mIn: Model) = mIn collect { 
		case (k,NodeSet(ns)) => (k, NodeSet(ns collect { case n if !(n <==> Label) => n }))
	}

def mainTask(i: Int): Model = ((m / Task(""+i)) \ owns)
	
def subtasks(i: Int): Model = for (
	(Key(entity,edge), nodes) <- (m / Task)
		if nodes exists {
			case Label(l) => l contains ("subtask"+i)
			case _ => false
		}
	) yield (Key(entity,edge), nodes)

def variants(i: Int): Model = for (
	(Key(entity,edge), nodes) <- (m/ Task)
		if nodes exists {
			case Label(l) => l contains ("variant"+i)
			case _ => false
		}
	) yield (Key(entity,edge), nodes)
	
val myTemplate = DocumentTemplate( 
	"Requirements Document ver. 2", 
	Text("Generated by " + 
	  " <a href=\"http://reqT.org\">reqT.org</a> " + 
	  ( new java.util.Date ) ), 
	Chapter("Context", Text("System context"), m => (m / Context) \ Stakeholder),
	
	// Stakeholders
	Chapter("Stakeholders", Text("The stakeholders are prioritized on a scale from 1 to 3, where 1 is lowest priority and 3 is highest."), m => m / Stakeholder),
	
	// Goals
	Chapter("Goal requirements", Text("<b>R1. The system shall support the following goals:</b>"), m => m / Goal),
	
	// Task descriptions
	Chapter("Tasks to be supported", Text("<b>R2. The system shall support the following tasks:</b>"), m => mWithoutLabels(mainTask(1)) ), 
	Section("Sub-tasks:", Text(""), m => mWithoutLabels(subtasks(1))),
	Section("Variants:", Text(""), m => mWithoutLabels(variants(1))),
	Section("", Text("<hr>"), m => m / hurts), // Tom modell
	Section("", Text(""), m => mWithoutLabels(mainTask(2))),
	Section("Sub-tasks:", Text(""), m => mWithoutLabels(subtasks(2))),
	Section("Variants:", Text(""), m => mWithoutLabels(variants(2))),
	
	// Data requirements
	Chapter("Data Requirements", Text("<b>R3. The server shall handle the following data:</b>"), m => m / hurts),
	Section("Data dictionary", Text(""), m => m / Class),
	
	// Function requirements
	Chapter("Function Requirements", Text(""), m => m / Function)
)

m.toHtml(myTemplate).save("reqDoc.html")