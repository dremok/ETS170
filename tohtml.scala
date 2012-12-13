/*
Generates HTML from model m according to the following template.
*/

def mWithoutLabels(mIn: Model) = mIn collect { 
		case (k,NodeSet(ns)) => (k, NodeSet(ns collect { case n if !(n <==> Label) => n }))
	}

def mainTask(i: Int): Model = for (
	(Key(entity,edge), nodes) <- (m / Task)
		if nodes exists {
			case Label(l) => l contains ("maintask"+i)
			case _ => false
		}
	) yield (Key(entity,edge), nodes)
	
def subtasks(i: Int): Model = for (
	(Key(entity,edge), nodes) <- (m / Task)
		if nodes exists {
			case Label(l) => l contains ("subtask"+i)
			case _ => false
		}
	) yield (Key(entity,edge), nodes)

def variants(i: Int): Model = for (
	(Key(entity,edge), nodes) <- (m / Task)
		if nodes exists {
			case Label(l) => l contains ("variant"+i)
			case _ => false
		}
	) yield (Key(entity,edge), nodes)

def deprecatedHas(): Model = for (
	(Key(entity,edge), nodes) <- m
		if nodes exists {
			case Deprecated(_) => true
			case _ => false
		}
	) yield (Key(entity,edge), nodes)

def deprecatedHelps(): Model =
  for ( (Key(entity,edge), nodes) <- (m / helps);
    if deprecatedHas().keySet contains Key(entity,has
)     )
  yield (Key(entity,edge), nodes)

def deprecated(): Model = deprecatedHas() ++ deprecatedHelps()

val myTemplate = DocumentTemplate( 
	"Requirements Document ver. 3", 
	Text("Generated by " + 
	  " <a href=\"http://reqT.org\">reqT.org</a> " + 
	  ( new java.util.Date ) ), 
	Chapter("Context", Text("System context"), m => (m / Context) \ Stakeholder),
	
	// Stakeholders
	Chapter("Stakeholders", Text("The stakeholders are prioritized on a scale from 1 to 4, where 1 is lowest priority and 4 is highest."), m => m / Stakeholder),
	
	// Features
	Chapter("System Features", Text("<b>The system consists of the following features. The point of these features is to partition the requirements for better clarity. They are not requirements per se.</b>"), m => m / Feature),
	
	// Goals
	Chapter("Goal requirements", Text("<b>R01. The system shall support the following goals:</b>"), m => m / Goal),
	
	// Task descriptions
	Chapter("Tasks to be supported", Text("<b>R02. The system shall support the following tasks:</b>"), m => mWithoutLabels(mainTask(1)) ), 
	Section("Sub-tasks:", Text(""), m => mWithoutLabels(subtasks(1))),
	Section("Variants:", Text(""), m => mWithoutLabels(variants(1))),
	Section("", Text(""), m => mWithoutLabels(mainTask(2))),
	Section("Sub-tasks:", Text(""), m => mWithoutLabels(subtasks(2))),
	Section("Variants:", Text(""), m => mWithoutLabels(variants(2))),
	Section("", Text(""), m => mWithoutLabels(mainTask(3))),
	Section("Sub-tasks:", Text(""), m => mWithoutLabels(subtasks(3))),
	
	// Data requirements
	Chapter("Data Requirements", Text("<b>R03. The server shall handle the following data:</b>"), m => m / hurts),
	Section("Data dictionary", Text(""), m => m / Class),
	
	// Function requirements
	Chapter("Function Requirements", Text(""), m => (m / Function -- deprecated().keySet) - Label),

	// Design-level requirements
	Chapter("Design Requirements", Text(""), m => m / Design),

	// Quality requirements
	Chapter("Quality Requirements", Text(""), m => m / Quality),

	//Deprecated
	Chapter("Deprecated", Text(""), m => deprecated() - Label)
)

object myHtmlGen extends HtmlGenerator {
  val meta = """<meta http-equiv="Content-Type" content="text/html;charset=utf-8" >"""
  override def head(title:String) = "<head>\n" + css + meta + "<title>" + title + "</title>\n</head>\n\n"
}

m.toHtml(myTemplate, myHtmlGen).save("reqDoc.html")