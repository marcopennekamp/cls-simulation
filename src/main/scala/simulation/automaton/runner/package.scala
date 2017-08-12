package simulation

package object runner {

  case class PlayerPosition(x: Int, y: Int)

  object PlayerPosition {
    val start = PlayerPosition(0, 0)
    val startState = Option(start)
  }

  type State = Option[PlayerPosition]
  type Action = State => State

  object Action {
    val jump: Action = _.map(pos => PlayerPosition(pos.x + 1, pos.y + 1))
    val fall: Action = _.map(pos => PlayerPosition(pos.x + 1, pos.y - 1))
    val run: Action = _.map(pos => PlayerPosition(pos.x + 1, pos.y))
    val die: Action = _ => None
    val stayDead: Action = p => p
  }

}
