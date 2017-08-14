package simulation.automaton.runner

import de.tu_dortmund.cs.ls14.cls.inhabitation.Tree
import de.tu_dortmund.cs.ls14.cls.interpreter._
import de.tu_dortmund.cs.ls14.cls.types._
import de.tu_dortmund.cs.ls14.cls.types.syntax._
import simulation._

object RunnerInhabitation extends App with Inhabitation[RunnerRepository, Option] {

  override val repository = new RunnerRepository { }
  override val variables = Seq(repository.alpha)
  override protected def createGamma(kinding: Kinding) = ReflectedRepository[RunnerRepository](inst = repository, kinding = kinding)
  override protected def wrapInput(input: Constructor) = 'Word(input)
  override protected def wrapOutput[A](terms: Stream[Tree], values: Stream[A]) = {
    println(terms.headOption)
    values.headOption
  }

  // Runtime for different word sizes n in seconds:
  // n = 8:      4s
  // n = 12:     5s
  // n = 16:     7s
  // n = 20:    10s
  // n = 24:    14s
  // n = 28:    23s
  // n = 32:    34s
  // n = 36:    47s
  // n = 40:    65s
  // n = 60:   248s
  // n = 80:   633s
  // n = 160: 7963s
  val word = {
    val constructor = (t: Type) => 'b('b('g('g(t))))
    (1 to 8).foldLeft('epsilon: Constructor) { case (t, _) => constructor(t) }
  }

  println(s"Word type: $word")
  println(inhabit[State](word))

}
