package simulation.rtg.game

import de.tu_dortmund.cs.ls14.cls.interpreter._
import de.tu_dortmund.cs.ls14.cls.types._
import de.tu_dortmund.cs.ls14.cls.types.syntax._
import simulation._

object RtgGameInhabitation extends App {
  val repository = new RtgGameRepository { }

  def inhabit(): Set[List[Skill]] = {
    // We enumerate all terms that occur in RtgGameRepository, because there is a chance that we need to instantiate
    // alpha with any part from any word.
    val termTypes = Seq(
      'skinfo('mage, 'dlcons('fire, 'n2, 'dlnil), 'cost('mana, 'n1)),
      'skinfo('mage, 'dlnil, 'cost('mana, 'n4)),
      'skinfo('mage, 'dlcons('ice, 'n3, 'dlcons('physical, 'n2, 'dlnil)), 'cost('mana, 'n3)),
      'skinfo('rogue, 'dlcons('poison, 'n3, 'dlnil), 'cost('stamina, 'n2)),
      'skinfo('warrior, 'dlcons('physical, 'n2, 'dlcons('bleed, 'n4, 'dlnil)), 'cost('stamina, 'n3))
    )

    val parts = termTypes.enumerate
    val kinding = Kinding(repository.alpha1).addOptions(parts) merge
                  Kinding(repository.alpha2).addOptions(parts) merge
                  Kinding(repository.alpha3).addOptions(parts)
    val gamma = ReflectedRepository[RtgGameRepository](inst = repository, kinding = kinding, semanticTaxonomy = Taxonomy.empty)

    println("Γ = {")
    gamma.combinators.foreach { case (c, ty) => println(s"\t $c : $ty") }
    println("}")

    println("Starting inhabitation...")

    val results = gamma.inhabit[List[Skill]]('SkillSet)
    results.terms.values.flatMap(_._2).foreach(println(_))
    results.interpretedTerms.values.flatMap(_._2).toSet
  }

  println(inhabit())
}
