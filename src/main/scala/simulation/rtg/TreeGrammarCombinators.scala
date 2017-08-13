package simulation.rtg

import de.tu_dortmund.cs.ls14.cls.types.Type
import de.tu_dortmund.cs.ls14.cls.types.syntax._
import simulation.automaton.AutomatonVariables

trait TreeGrammarCombinators extends TreeGrammarVariables {

  /**
    * Generic combinator template for productions of the form A -> B.
    */
  class SingleNonterminalProduction[A](leftNonterminal: Type, rightNonterminal: Type) {
    def apply(x: A): A = x
    val semanticType = (rightNonterminal =>: 'Term(alpha1)) =>: (leftNonterminal =>: 'Term(alpha1))
  }

  /**
    * Generic combinator template for productions of the form A -> f.
    */
  class TerminalProduction[A](nonterminal: Type, terminal: Type, value: A) {
    def apply(): A = value
    val semanticType = nonterminal =>: 'Term(terminal)
  }

  /**
    * Generic combinator template for the start production.
    */
  class Start[A](S: Type) {
    def apply(x: A): A = x
    val semanticType = (S =>: 'Term(alpha1)) =>: 'Term(alpha1)
  }

}
