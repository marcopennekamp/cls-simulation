package simulation

import de.tu_dortmund.cs.ls14.cls.types._
import de.tu_dortmund.cs.ls14.cls.types.syntax._

trait AutomatonCombinators extends Variables {

  /**
    * Generic combinator template for final states.
    */
  class Fin[A](q: Constructor)(v: A) {
    def apply(): A = v
    val semanticType = 'St(q) =>: 'Word('epsilon)
  }

  /**
    * Generic combinator template for transitions of the form (q, a, p).
    */
  class Transition[A, B](q: Constructor, a: Type => Constructor, p: Constructor)(f: A => B) {
    def apply(x: A): B = f(x)
    val semanticType = ('St(p) =>: 'Word(alpha)) =>: ('St(q) =>: 'Word(a(alpha)))
  }

  /**
    * Generic combinator template for epsilon-transitions of the form (q, epsilon, p).
    */
  class EpsilonTransition[A, B](q: Constructor, p: Constructor)(f: A => B) {
    def apply(x: A): B = f(x)
    val semanticType = ('St(p) =>: 'Word(alpha)) =>: ('St(q) =>: 'Word(alpha))
  }

  /**
    * Generic combinator template for ensuring that the execution begins in starting states.
    */
  class Run[A](q0: Constructor) {
    def apply(x: A): A = x
    val semanticType = ('St(q0) =>: 'Word(alpha)) =>: 'Word(alpha)
  }

}
