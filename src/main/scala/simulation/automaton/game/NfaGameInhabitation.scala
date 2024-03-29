package simulation.automaton.game

import de.tu_dortmund.cs.ls14.cls.interpreter.ReflectedRepository
import de.tu_dortmund.cs.ls14.cls.types._
import de.tu_dortmund.cs.ls14.cls.types.syntax._
import simulation._

object NfaGameInhabitation extends App {

  val repository = new NfaGameRepository { }

  def inhabit(): Set[List[Skill]] = {
    // We enumerate all words that occur in NfaGameRepository, because there is a chance that we need to instantiate
    // alpha with any part from any word.
    val wordTypes = Seq(
      'F('i('r('e('b('a('l('l('epsilon)))))))),
      'W('a('l('l('space('o('f('space('I('c('e('epsilon))))))))))),
      'I('c('e('space('L('a('n('c('e('epsilon))))))))),
      'P('o('i('s('o('n('epsilon)))))),
      'D('e('e('p('space('C('u('t('epsilon))))))))
    )

    val kinding = Kinding(repository.alpha).addOptions(wordTypes.enumerate)
    val gamma = ReflectedRepository[NfaGameRepository](inst = repository, kinding = kinding, semanticTaxonomy = Taxonomy.empty)

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
