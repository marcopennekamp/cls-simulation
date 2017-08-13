package simulation.rtg

import de.tu_dortmund.cs.ls14.cls.inhabitation.Tree
import de.tu_dortmund.cs.ls14.cls.interpreter.ReflectedRepository
import de.tu_dortmund.cs.ls14.cls.types._
import de.tu_dortmund.cs.ls14.cls.types.syntax._
import simulation._

import scala.reflect.runtime.universe._

object ListInhabitation extends App with Inhabitation[ListRepository, Option] {
  override val repository = new ListRepository { }
  override val variables = Seq(repository.alpha1, repository.alpha2)

  override protected def createGamma(kinding: Kinding) = ReflectedRepository[ListRepository](inst = repository, kinding = kinding)
  override protected def wrapInput(input: Constructor) = 'Term(input)
  override protected def wrapOutput[A](terms: Stream[Tree], values: Stream[A]) = values.headOption

  import repository._

  println(StartList(List1()))

  // Example from section 5.3
  println(inhabit[List[Int]]('cons('s('zero), 'nil)))
  //println(inhabit[List[Int]]('nil))
}
