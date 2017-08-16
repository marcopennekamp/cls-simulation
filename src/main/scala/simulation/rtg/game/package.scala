package simulation.rtg

package object game {
  sealed trait Archetype
  case object Warrior extends Archetype
  case object Mage extends Archetype
  case object Rogue extends Archetype

  sealed trait DamageType
  case object Fire extends DamageType
  case object Ice extends DamageType
  case object Physical extends DamageType
  case object Poison extends DamageType
  case object Bleed extends DamageType

  sealed trait CostType
  case object Health extends CostType
  case object Mana extends CostType
  case object Stamina extends CostType

  case class Damage(damageType: DamageType, damageValue: Int)
  case class Cost(costType: CostType, costValue: Int)
  case class SkillInfo(archetype: Archetype, damageList: List[Damage], cost: Cost)

  /**
    * Skill differs from SkillInfo in the following way: A SkillInfo instance is constructed
    * while the tree grammar is simulated, while Skill is the result type of a skill combinator.
    * Additional properties may be added to Skill in the future, without being added to SkillInfo,
    * or vice versa. SkillInfo summarizes the properties that are used to select a skill, while
    * the Skill itself can be used in the resulting program.
    */
  case class Skill(archetype: Archetype, damageList: List[Damage], cost: Cost)

  object Skill {
    def fromSkillInfo(skillInfo: SkillInfo) = Skill(skillInfo.archetype, skillInfo.damageList, skillInfo.cost)
  }
}
