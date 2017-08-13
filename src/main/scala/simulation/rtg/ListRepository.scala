package simulation.rtg

import de.tu_dortmund.cs.ls14.cls.interpreter.combinator
import de.tu_dortmund.cs.ls14.cls.types.syntax._

trait ListRepository extends TreeGrammarVariables with TreeGrammarCombinators {

  // Gamma List, Section 5.2.2
  @combinator object StartList extends Start[List[Int]]('NtList)

  @combinator object List1 extends TerminalProduction[List[Int]]('NtList, 'nil, List.empty[Int])

  @combinator object List2 {
    def apply(e: Int, l1: List[Int]): List[Int] = e +: l1
    val semanticType = ('NtNat =>: 'Term(alpha1)) =>: ('NtList =>: 'Term(alpha2)) =>: ('NtList =>: 'Term('cons(alpha1, alpha2)))
  }

  @combinator object Nat1 extends TerminalProduction[Int]('NtNat, 'zero, 0)

  @combinator object Nat2 {
    def apply(n: Int): Int = n + 1
    val semanticType = ('NtNat =>: 'Term(alpha1)) =>: ('NtNat =>: 'Term('s(alpha1)))
  }

}
