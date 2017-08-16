package simulation.rtg.game

import de.tu_dortmund.cs.ls14.cls.interpreter.combinator
import simulation.rtg.{TreeGrammarCombinators, TreeGrammarVariables}
import de.tu_dortmund.cs.ls14.cls.types.syntax._

trait RtgGameRepository extends TreeGrammarCombinators with TreeGrammarVariables {

  trait SkillCombinator {
    def apply(skillInfo: SkillInfo): Skill = Skill.fromSkillInfo(skillInfo)
  }

  // Gamma F'
  @combinator object Fireball extends SkillCombinator {
    val semanticType = 'Term('skinfo('mage, 'dlcons('fire, 'n2, 'dlnil), 'cost('mana, 'n1))) =>: 'Skill
  }

  @combinator object WallOfIce extends SkillCombinator {
    val semanticType = 'Term('skinfo('mage, 'dlnil, 'cost('mana, 'n4))) =>: 'Skill
  }

  @combinator object IceLance extends SkillCombinator {
    val semanticType = 'Term('skinfo('mage, 'dlcons('ice, 'n3, 'dlcons('physical, 'n2, 'dlnil)), 'cost('mana, 'n3))) =>: 'Skill
  }

  @combinator object Poison extends SkillCombinator {
    val semanticType = 'Term('skinfo('rogue, 'dlcons('poison, 'n3, 'dlnil), 'cost('stamina, 'n2))) =>: 'Skill
  }

  @combinator object DeepCut extends SkillCombinator {
    val semanticType = 'Term('skinfo('warrior, 'dlcons('physical, 'n2, 'dlcons('bleed, 'n4, 'dlnil)), 'cost('stamina, 'n3))) =>: 'Skill
  }

  @combinator object SkillSet {
    def apply(s1: Skill, s2: Skill): List[Skill] = List(s1, s2)
    val semanticType = 'Skill =>: 'Skill =>: 'SkillSet
  }

  // Gamma G_A, Section 5.4.2
  @combinator object StartSkillInfo extends Start[List[SkillInfo]]('NtSkillInfo)

  @combinator object SkillInfo1 {
    def apply(archetype: Archetype, damageList: List[Damage], cost: Cost): SkillInfo = SkillInfo(archetype, damageList, cost)
    val semanticType = ('NtArchetype =>: 'Term(alpha1)) =>: ('NtFullDamageList =>: 'Term(alpha2)) =>:
      ('NtCost =>: 'Term(alpha3)) =>: ('NtSkillInfo =>: 'Term('skinfo(alpha1, alpha2, alpha3)))
  }

  @combinator object Archetype1 extends TerminalProduction[Archetype]('NtArchetype, 'mage, Mage)
  @combinator object Archetype2 extends TerminalProduction[Archetype]('NtArchetype, 'rogue, Rogue)

  @combinator object FullDamageList1 {
    def apply(damageType: DamageType, damageValue: Int, damageList: List[Damage]): List[Damage] = {
      Damage(damageType, damageValue) +: damageList
    }
    val semanticType = ('NtDamageType =>: 'Term(alpha1)) =>: ('NtDamageValue =>: 'Term(alpha2)) =>:
      ('NtDamageList =>: 'Term(alpha3)) =>: ('NtFullDamageList =>: 'Term('dlcons(alpha1, alpha2, alpha3)))
  }

  @combinator object DamageList1 extends TerminalProduction[List[Damage]]('NtDamageList, 'dlnil, List())

  @combinator object DamageList2 {
    def apply(damageType: DamageType, damageValue: Int, damageList: List[Damage]): List[Damage] = {
      Damage(damageType, damageValue) +: damageList
    }
    val semanticType = ('NtDamageType =>: 'Term(alpha1)) =>: ('NtDamageValue =>: 'Term(alpha2)) =>:
      ('NtDamageList =>: 'Term(alpha3)) =>: ('NtDamageList =>: 'Term('dlcons(alpha1, alpha2, alpha3)))
  }

  @combinator object DamageType1 extends TerminalProduction[DamageType]('NtDamageType, 'fire, Fire)
  @combinator object DamageType2 extends TerminalProduction[DamageType]('NtDamageType, 'ice, Ice)
  @combinator object DamageType3 extends TerminalProduction[DamageType]('NtDamageType, 'physical, Physical)

  @combinator object DamageValue1 extends TerminalProduction[Int]('NtDamageValue, 'n1, 1)
  @combinator object DamageValue2 extends TerminalProduction[Int]('NtDamageValue, 'n2, 2)
  @combinator object DamageValue3 extends TerminalProduction[Int]('NtDamageValue, 'n3, 3)
  @combinator object DamageValue4 extends TerminalProduction[Int]('NtDamageValue, 'n4, 4)
  @combinator object DamageValue5 extends TerminalProduction[Int]('NtDamageValue, 'n5, 5)

  @combinator object Cost1 {
    def apply(costType: CostType, costValue: Int): Cost = Cost(costType, costValue)
    val semanticType = ('NtCostType =>: 'Term(alpha1)) =>: ('NtCostValue =>: 'Term(alpha2)) =>:
      ('NtCost =>: 'Term('cost(alpha1, alpha2)))
  }

  @combinator object CostType1 extends TerminalProduction[CostType]('NtCostType, 'mana, Mana)
  @combinator object CostType2 extends TerminalProduction[CostType]('NtCostType, 'stamina, Stamina)

  @combinator object CostValue1 extends TerminalProduction[Int]('NtCostValue, 'n2, 2)
  @combinator object CostValue2 extends TerminalProduction[Int]('NtCostValue, 'n3, 3)
  @combinator object CostValue3 extends TerminalProduction[Int]('NtCostValue, 'n4, 4)

}
