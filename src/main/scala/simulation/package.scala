import de.tu_dortmund.cs.ls14.cls.types.{Constructor, Type}
import shapeless.feat.Enumeration

package object simulation {

  implicit class TermTypeSeqEnumerator(termTypes: Seq[Constructor]) {
    def enumerate: Enumeration[Type] = termTypes.map(_.enumerate).reduce(_ union _)
  }

  implicit class TermTypeEnumerator(termType: Constructor) {
    /**
      * Enumerate all possible instantiations of a type variable by recursively
      * extracting all type parts used in a term type.
      */
    def enumerate: Enumeration[Type] = TermTypeEnumerator.enumerate(termType)
  }

  object TermTypeEnumerator {
    private def uniqueParts(tt: Type): Set[Type] = tt match {
      case cst: Constructor if cst.arguments.nonEmpty =>
        val children = cst.arguments.map(uniqueParts).reduce(_ union _)
        children + cst
      case t => Set(t)
    }

    private def enumerate(tt: Type): Enumeration[Type] = {
      val set = uniqueParts(tt)
      set.map(t => Enumeration.singleton(t).asInstanceOf[Enumeration[Type]]).reduce(_ union _)
    }
  }

}
