package simulation.rtg

import de.tu_dortmund.cs.ls14.cls.inhabitation.Tree
import de.tu_dortmund.cs.ls14.cls.interpreter.ReflectedRepository
import de.tu_dortmund.cs.ls14.cls.types._
import de.tu_dortmund.cs.ls14.cls.types.syntax._
import simulation._

object ListInhabitation extends App with Inhabitation[ListRepository, Option] {
  override val repository = new ListRepository { }
  override val variables = Seq(repository.alpha1, repository.alpha2)

  override protected def createGamma(kinding: Kinding) = ReflectedRepository[ListRepository](inst = repository, kinding = kinding)
  override protected def wrapInput(input: Constructor) = 'Term(input)
  override protected def wrapOutput[A](terms: Stream[Tree], values: Stream[A]) = values.headOption

  // Starting inhabitation...
  // Some(List())
  // [success] Total time: 4 s
  //println(inhabit[List[Int]]('nil))

  // Starting inhabitation...
  // Some(List(0))
  // [success] Total time: 6 s
  //println(inhabit[List[Int]]('cons('zero, 'nil)))

  // Starting inhabitation...
  // None
  // [success] Total time: 7 s
  //println(inhabit[List[Int]]('cons('s('zero), 'nil)))

  // Starting inhabitation...
  // Some(List(0, 1))
  // [success] Total time: 1376 s, completed Aug 16, 2017 7:40:46 PM
  //println(inhabit[List[Int]]('cons('zero, 'cons('s('zero), 'nil))))

  // Starting inhabitation...
  // Some(List(1, 1))
  // [success] Total time: 428 s, completed Aug 16, 2017 8:07:20 PM
  println(inhabit[List[Int]]('cons('s('zero), 'cons('s('zero), 'nil))))
}
