package simulation.automaton.runner

import de.tu_dortmund.cs.ls14.cls.interpreter.combinator
import de.tu_dortmund.cs.ls14.cls.types.syntax._
import simulation.automaton.AutomatonCombinators

trait RunnerRepository extends AutomatonCombinators {

  @combinator object RunRunner extends Run[State]('grnd)
  @combinator object FinGrnd extends Fin('grnd)(PlayerPosition.startState)

  @combinator object GrndG extends Transition('grnd, 'g(_), 'grnd)(Action.run)
  @combinator object GrndB extends Transition('grnd, 'b(_), 'air1)(Action.jump)
  @combinator object Air1G extends Transition('air1, 'g(_), 'grnd)(Action.fall)
  @combinator object Air1B extends Transition('air1, 'b(_), 'air2)(Action.jump)
  @combinator object Air2G extends Transition('air2, 'g(_), 'fall)(Action.fall)
  @combinator object Air2B extends Transition('air2, 'b(_), 'dead)(Action.die)
  @combinator object FallG extends Transition('fall, 'g(_), 'grnd)(Action.fall)
  @combinator object FallB extends Transition('fall, 'b(_), 'dead)(Action.die)
  @combinator object DeadG extends Transition('dead, 'g(_), 'dead)(Action.stayDead)
  @combinator object DeadB extends Transition('dead, 'b(_), 'dead)(Action.stayDead)

}
