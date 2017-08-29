package simulation

import de.tu_dortmund.cs.ls14.cls.inhabitation.Tree
import de.tu_dortmund.cs.ls14.cls.interpreter.ReflectedRepository
import de.tu_dortmund.cs.ls14.cls.types.{Constructor, Kinding, Type, Variable}

import scala.reflect.runtime.universe.WeakTypeTag

/**
  * A trait that forms the basis of any simulation inhabitation object.
  */
trait Inhabitation[Repository, Out[_]] {

  val repository: Repository
  val variables: Seq[Variable]

  protected def createGamma(kinding: Kinding): ReflectedRepository[Repository]
  protected def wrapInput(input: Constructor): Constructor
  protected def wrapOutput[A](terms: Stream[Tree], values: Stream[A]): Out[A]

  private def createKinding(input: Constructor): Kinding = {
    val parts = input.enumerate

    // Print type variable kinding.
    println("Type variable kinding:")
    parts.values.flatMap(_._2).foreach(t => println(t))
    println()

    variables.map(Kinding(_).addOptions(parts)).reduce(_ merge _)
  }

  def inhabit[A](input: Constructor)(implicit typeTag: WeakTypeTag[A]): Out[A] = {
    val kinding = createKinding(input)
    val gamma = createGamma(kinding)

    // Print list of combinators.
    println("Γ = {")
    gamma.combinators.foreach { case (c, ty) => println(s"\t $c : $ty") }
    println("}")

    println("Starting inhabitation...")

    val results = gamma.inhabit[A](wrapInput(input))
    val terms = results.terms.values.flatMap(_._2)
    val values = results.interpretedTerms.values.flatMap(_._2)
    wrapOutput[A](terms, values)
  }

}
