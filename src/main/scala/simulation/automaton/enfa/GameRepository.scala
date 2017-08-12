package simulation.automaton.enfa

import de.tu_dortmund.cs.ls14.cls.interpreter.combinator
import de.tu_dortmund.cs.ls14.cls.types._
import de.tu_dortmund.cs.ls14.cls.types.syntax._
import simulation.automaton.AutomatonCombinators

/**
  * In this repository, the type for the blank space symbol is called 'space.
  */
trait GameRepository extends AutomatonCombinators {

  private val idu: Unit => Unit = identity

  // Gamma F', Section 4.3.3
  @combinator object Fireball {
    def apply(word: Unit): Skill = Skill("Fireball")
    val semanticType = 'Word('F('i('r('e('b('a('l('l('epsilon))))))))) =>: 'Skill
  }

  @combinator object WallOfIce {
    def apply(word: Unit): Skill = Skill("Wall of Ice")
    val semanticType = 'Word('W('a('l('l('space('o('f('space('I('c('e('epsilon)))))))))))) =>: 'Skill
  }

  @combinator object IceLance {
    def apply(word: Unit): Skill = Skill("Ice Lance")
    val semanticType = 'Word('I('c('e('space('L('a('n('c('e('epsilon)))))))))) =>: 'Skill
  }

  @combinator object Poison {
    def apply(word: Unit): Skill = Skill("Poison")
    val semanticType = 'Word('P('o('i('s('o('n('epsilon))))))) =>: 'Skill
  }

  @combinator object DeepCut {
    def apply(word: Unit): Skill = Skill("Deep Cut")
    val semanticType = 'Word('D('e('e('p('space('C('u('t('epsilon))))))))) =>: 'Skill
  }

  @combinator object SkillSet {
    def apply(s1: Skill, s2: Skill): List[Skill] = List(s1, s2)
    val semanticType = 'Skill =>: 'Skill =>: 'SkillSet
  }

  // Gamma 1, Section 4.3.2
  @combinator object RunNfa extends Run[Unit]('start)

  @combinator object EpsS_W1 extends EpsilonTransition('start, 'w1)(idu)
  @combinator object W1_F extends Transition('w1, 'F(_), 'wF)(idu)
  @combinator object WF_i extends Transition('wF, 'i(_), 'wFi)(idu)
  @combinator object WFi_r extends Transition('wFi, 'r(_), 'wFir)(idu)
  @combinator object WFir_e extends Transition('wFir, 'e(_), 'wFire)(idu)
  @combinator object FinFire extends Fin('wFire)(())

  @combinator object EpsS_W2 extends EpsilonTransition('start, 'w2)(idu)
  @combinator object W2_I extends Transition('w2, 'I(_), 'wI)(idu)
  @combinator object WI_c extends Transition('wI, 'c(_), 'wIc)(idu)
  @combinator object WIc_e extends Transition('wIc, 'e(_), 'wIce)(idu)
  @combinator object FinIce extends Fin('wIce)(())

  // Gamma 2
  @combinator object S_UpperA extends Transition('start, 'A(_), 'start)(idu)
  @combinator object S_UpperB extends Transition('start, 'B(_), 'start)(idu)
  @combinator object S_UpperC extends Transition('start, 'C(_), 'start)(idu)
  @combinator object S_UpperD extends Transition('start, 'D(_), 'start)(idu)
  @combinator object S_UpperE extends Transition('start, 'E(_), 'start)(idu)
  @combinator object S_UpperF extends Transition('start, 'F(_), 'start)(idu)
  @combinator object S_UpperG extends Transition('start, 'G(_), 'start)(idu)
  @combinator object S_UpperH extends Transition('start, 'H(_), 'start)(idu)
  @combinator object S_UpperI extends Transition('start, 'I(_), 'start)(idu)
  @combinator object S_UpperJ extends Transition('start, 'J(_), 'start)(idu)
  @combinator object S_UpperK extends Transition('start, 'K(_), 'start)(idu)
  @combinator object S_UpperL extends Transition('start, 'L(_), 'start)(idu)
  @combinator object S_UpperM extends Transition('start, 'M(_), 'start)(idu)
  @combinator object S_UpperN extends Transition('start, 'N(_), 'start)(idu)
  @combinator object S_UpperO extends Transition('start, 'O(_), 'start)(idu)
  @combinator object S_UpperP extends Transition('start, 'P(_), 'start)(idu)
  @combinator object S_UpperQ extends Transition('start, 'Q(_), 'start)(idu)
  @combinator object S_UpperR extends Transition('start, 'R(_), 'start)(idu)
  @combinator object S_UpperS extends Transition('start, 'S(_), 'start)(idu)
  @combinator object S_UpperT extends Transition('start, 'T(_), 'start)(idu)
  @combinator object S_UpperU extends Transition('start, 'U(_), 'start)(idu)
  @combinator object S_UpperV extends Transition('start, 'V(_), 'start)(idu)
  @combinator object S_UpperW extends Transition('start, 'W(_), 'start)(idu)
  @combinator object S_UpperX extends Transition('start, 'X(_), 'start)(idu)
  @combinator object S_UpperY extends Transition('start, 'Y(_), 'start)(idu)
  @combinator object S_UpperZ extends Transition('start, 'Z(_), 'start)(idu)

  @combinator object S_LowerA extends Transition('start, 'a(_), 'start)(idu)
  @combinator object S_LowerB extends Transition('start, 'b(_), 'start)(idu)
  @combinator object S_LowerC extends Transition('start, 'c(_), 'start)(idu)
  @combinator object S_LowerD extends Transition('start, 'd(_), 'start)(idu)
  @combinator object S_LowerE extends Transition('start, 'e(_), 'start)(idu)
  @combinator object S_LowerF extends Transition('start, 'f(_), 'start)(idu)
  @combinator object S_LowerG extends Transition('start, 'g(_), 'start)(idu)
  @combinator object S_LowerH extends Transition('start, 'h(_), 'start)(idu)
  @combinator object S_LowerI extends Transition('start, 'i(_), 'start)(idu)
  @combinator object S_LowerJ extends Transition('start, 'j(_), 'start)(idu)
  @combinator object S_LowerK extends Transition('start, 'k(_), 'start)(idu)
  @combinator object S_LowerL extends Transition('start, 'l(_), 'start)(idu)
  @combinator object S_LowerM extends Transition('start, 'm(_), 'start)(idu)
  @combinator object S_LowerN extends Transition('start, 'n(_), 'start)(idu)
  @combinator object S_LowerO extends Transition('start, 'o(_), 'start)(idu)
  @combinator object S_LowerP extends Transition('start, 'p(_), 'start)(idu)
  @combinator object S_LowerQ extends Transition('start, 'q(_), 'start)(idu)
  @combinator object S_LowerR extends Transition('start, 'r(_), 'start)(idu)
  @combinator object S_LowerS extends Transition('start, 's(_), 'start)(idu)
  @combinator object S_LowerT extends Transition('start, 't(_), 'start)(idu)
  @combinator object S_LowerU extends Transition('start, 'u(_), 'start)(idu)
  @combinator object S_LowerV extends Transition('start, 'v(_), 'start)(idu)
  @combinator object S_LowerW extends Transition('start, 'w(_), 'start)(idu)
  @combinator object S_LowerX extends Transition('start, 'x(_), 'start)(idu)
  @combinator object S_LowerY extends Transition('start, 'y(_), 'start)(idu)
  @combinator object S_LowerZ extends Transition('start, 'z(_), 'start)(idu)

  @combinator object S_Space extends Transition('start, 'space(_), 'start)(idu)

  // Gamma 3
  @combinator object WFire_UpperA extends Transition('wFire, 'A(_), 'wFire)(idu)
  @combinator object WFire_UpperB extends Transition('wFire, 'B(_), 'wFire)(idu)
  @combinator object WFire_UpperC extends Transition('wFire, 'C(_), 'wFire)(idu)
  @combinator object WFire_UpperD extends Transition('wFire, 'D(_), 'wFire)(idu)
  @combinator object WFire_UpperE extends Transition('wFire, 'E(_), 'wFire)(idu)
  @combinator object WFire_UpperF extends Transition('wFire, 'F(_), 'wFire)(idu)
  @combinator object WFire_UpperG extends Transition('wFire, 'G(_), 'wFire)(idu)
  @combinator object WFire_UpperH extends Transition('wFire, 'H(_), 'wFire)(idu)
  @combinator object WFire_UpperI extends Transition('wFire, 'I(_), 'wFire)(idu)
  @combinator object WFire_UpperJ extends Transition('wFire, 'J(_), 'wFire)(idu)
  @combinator object WFire_UpperK extends Transition('wFire, 'K(_), 'wFire)(idu)
  @combinator object WFire_UpperL extends Transition('wFire, 'L(_), 'wFire)(idu)
  @combinator object WFire_UpperM extends Transition('wFire, 'M(_), 'wFire)(idu)
  @combinator object WFire_UpperN extends Transition('wFire, 'N(_), 'wFire)(idu)
  @combinator object WFire_UpperO extends Transition('wFire, 'O(_), 'wFire)(idu)
  @combinator object WFire_UpperP extends Transition('wFire, 'P(_), 'wFire)(idu)
  @combinator object WFire_UpperQ extends Transition('wFire, 'Q(_), 'wFire)(idu)
  @combinator object WFire_UpperR extends Transition('wFire, 'R(_), 'wFire)(idu)
  @combinator object WFire_UpperS extends Transition('wFire, 'S(_), 'wFire)(idu)
  @combinator object WFire_UpperT extends Transition('wFire, 'T(_), 'wFire)(idu)
  @combinator object WFire_UpperU extends Transition('wFire, 'U(_), 'wFire)(idu)
  @combinator object WFire_UpperV extends Transition('wFire, 'V(_), 'wFire)(idu)
  @combinator object WFire_UpperW extends Transition('wFire, 'W(_), 'wFire)(idu)
  @combinator object WFire_UpperX extends Transition('wFire, 'X(_), 'wFire)(idu)
  @combinator object WFire_UpperY extends Transition('wFire, 'Y(_), 'wFire)(idu)
  @combinator object WFire_UpperZ extends Transition('wFire, 'Z(_), 'wFire)(idu)

  @combinator object WFire_LowerA extends Transition('wFire, 'a(_), 'wFire)(idu)
  @combinator object WFire_LowerB extends Transition('wFire, 'b(_), 'wFire)(idu)
  @combinator object WFire_LowerC extends Transition('wFire, 'c(_), 'wFire)(idu)
  @combinator object WFire_LowerD extends Transition('wFire, 'd(_), 'wFire)(idu)
  @combinator object WFire_LowerE extends Transition('wFire, 'e(_), 'wFire)(idu)
  @combinator object WFire_LowerF extends Transition('wFire, 'f(_), 'wFire)(idu)
  @combinator object WFire_LowerG extends Transition('wFire, 'g(_), 'wFire)(idu)
  @combinator object WFire_LowerH extends Transition('wFire, 'h(_), 'wFire)(idu)
  @combinator object WFire_LowerI extends Transition('wFire, 'i(_), 'wFire)(idu)
  @combinator object WFire_LowerJ extends Transition('wFire, 'j(_), 'wFire)(idu)
  @combinator object WFire_LowerK extends Transition('wFire, 'k(_), 'wFire)(idu)
  @combinator object WFire_LowerL extends Transition('wFire, 'l(_), 'wFire)(idu)
  @combinator object WFire_LowerM extends Transition('wFire, 'm(_), 'wFire)(idu)
  @combinator object WFire_LowerN extends Transition('wFire, 'n(_), 'wFire)(idu)
  @combinator object WFire_LowerO extends Transition('wFire, 'o(_), 'wFire)(idu)
  @combinator object WFire_LowerP extends Transition('wFire, 'p(_), 'wFire)(idu)
  @combinator object WFire_LowerQ extends Transition('wFire, 'q(_), 'wFire)(idu)
  @combinator object WFire_LowerR extends Transition('wFire, 'r(_), 'wFire)(idu)
  @combinator object WFire_LowerS extends Transition('wFire, 's(_), 'wFire)(idu)
  @combinator object WFire_LowerT extends Transition('wFire, 't(_), 'wFire)(idu)
  @combinator object WFire_LowerU extends Transition('wFire, 'u(_), 'wFire)(idu)
  @combinator object WFire_LowerV extends Transition('wFire, 'v(_), 'wFire)(idu)
  @combinator object WFire_LowerW extends Transition('wFire, 'w(_), 'wFire)(idu)
  @combinator object WFire_LowerX extends Transition('wFire, 'x(_), 'wFire)(idu)
  @combinator object WFire_LowerY extends Transition('wFire, 'y(_), 'wFire)(idu)
  @combinator object WFire_LowerZ extends Transition('wFire, 'z(_), 'wFire)(idu)

  @combinator object WFire_Space extends Transition('wFire, 'space(_), 'wFire)(idu)

  @combinator object WIce_UpperA extends Transition('wIce, 'A(_), 'wIce)(idu)
  @combinator object WIce_UpperB extends Transition('wIce, 'B(_), 'wIce)(idu)
  @combinator object WIce_UpperC extends Transition('wIce, 'C(_), 'wIce)(idu)
  @combinator object WIce_UpperD extends Transition('wIce, 'D(_), 'wIce)(idu)
  @combinator object WIce_UpperE extends Transition('wIce, 'E(_), 'wIce)(idu)
  @combinator object WIce_UpperF extends Transition('wIce, 'F(_), 'wIce)(idu)
  @combinator object WIce_UpperG extends Transition('wIce, 'G(_), 'wIce)(idu)
  @combinator object WIce_UpperH extends Transition('wIce, 'H(_), 'wIce)(idu)
  @combinator object WIce_UpperI extends Transition('wIce, 'I(_), 'wIce)(idu)
  @combinator object WIce_UpperJ extends Transition('wIce, 'J(_), 'wIce)(idu)
  @combinator object WIce_UpperK extends Transition('wIce, 'K(_), 'wIce)(idu)
  @combinator object WIce_UpperL extends Transition('wIce, 'L(_), 'wIce)(idu)
  @combinator object WIce_UpperM extends Transition('wIce, 'M(_), 'wIce)(idu)
  @combinator object WIce_UpperN extends Transition('wIce, 'N(_), 'wIce)(idu)
  @combinator object WIce_UpperO extends Transition('wIce, 'O(_), 'wIce)(idu)
  @combinator object WIce_UpperP extends Transition('wIce, 'P(_), 'wIce)(idu)
  @combinator object WIce_UpperQ extends Transition('wIce, 'Q(_), 'wIce)(idu)
  @combinator object WIce_UpperR extends Transition('wIce, 'R(_), 'wIce)(idu)
  @combinator object WIce_UpperS extends Transition('wIce, 'S(_), 'wIce)(idu)
  @combinator object WIce_UpperT extends Transition('wIce, 'T(_), 'wIce)(idu)
  @combinator object WIce_UpperU extends Transition('wIce, 'U(_), 'wIce)(idu)
  @combinator object WIce_UpperV extends Transition('wIce, 'V(_), 'wIce)(idu)
  @combinator object WIce_UpperW extends Transition('wIce, 'W(_), 'wIce)(idu)
  @combinator object WIce_UpperX extends Transition('wIce, 'X(_), 'wIce)(idu)
  @combinator object WIce_UpperY extends Transition('wIce, 'Y(_), 'wIce)(idu)
  @combinator object WIce_UpperZ extends Transition('wIce, 'Z(_), 'wIce)(idu)

  @combinator object WIce_LowerA extends Transition('wIce, 'a(_), 'wIce)(idu)
  @combinator object WIce_LowerB extends Transition('wIce, 'b(_), 'wIce)(idu)
  @combinator object WIce_LowerC extends Transition('wIce, 'c(_), 'wIce)(idu)
  @combinator object WIce_LowerD extends Transition('wIce, 'd(_), 'wIce)(idu)
  @combinator object WIce_LowerE extends Transition('wIce, 'e(_), 'wIce)(idu)
  @combinator object WIce_LowerF extends Transition('wIce, 'f(_), 'wIce)(idu)
  @combinator object WIce_LowerG extends Transition('wIce, 'g(_), 'wIce)(idu)
  @combinator object WIce_LowerH extends Transition('wIce, 'h(_), 'wIce)(idu)
  @combinator object WIce_LowerI extends Transition('wIce, 'i(_), 'wIce)(idu)
  @combinator object WIce_LowerJ extends Transition('wIce, 'j(_), 'wIce)(idu)
  @combinator object WIce_LowerK extends Transition('wIce, 'k(_), 'wIce)(idu)
  @combinator object WIce_LowerL extends Transition('wIce, 'l(_), 'wIce)(idu)
  @combinator object WIce_LowerM extends Transition('wIce, 'm(_), 'wIce)(idu)
  @combinator object WIce_LowerN extends Transition('wIce, 'n(_), 'wIce)(idu)
  @combinator object WIce_LowerO extends Transition('wIce, 'o(_), 'wIce)(idu)
  @combinator object WIce_LowerP extends Transition('wIce, 'p(_), 'wIce)(idu)
  @combinator object WIce_LowerQ extends Transition('wIce, 'q(_), 'wIce)(idu)
  @combinator object WIce_LowerR extends Transition('wIce, 'r(_), 'wIce)(idu)
  @combinator object WIce_LowerS extends Transition('wIce, 's(_), 'wIce)(idu)
  @combinator object WIce_LowerT extends Transition('wIce, 't(_), 'wIce)(idu)
  @combinator object WIce_LowerU extends Transition('wIce, 'u(_), 'wIce)(idu)
  @combinator object WIce_LowerV extends Transition('wIce, 'v(_), 'wIce)(idu)
  @combinator object WIce_LowerW extends Transition('wIce, 'w(_), 'wIce)(idu)
  @combinator object WIce_LowerX extends Transition('wIce, 'x(_), 'wIce)(idu)
  @combinator object WIce_LowerY extends Transition('wIce, 'y(_), 'wIce)(idu)
  @combinator object WIce_LowerZ extends Transition('wIce, 'z(_), 'wIce)(idu)

  @combinator object WIce_Space extends Transition('wIce, 'space(_), 'wIce)(idu)

}
