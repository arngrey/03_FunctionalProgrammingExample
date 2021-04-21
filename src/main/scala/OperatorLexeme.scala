case class OperatorLexeme (private val inputLexeme: String) extends Lexeme(inputLexeme) {
  def isHighPriority: Boolean = inputLexeme == "*" || inputLexeme == "/"
  def isLowPriority: Boolean = inputLexeme == "+" || inputLexeme == "-"
  def HasGraterOrEqualPriorityThan(other: OperatorLexeme): Boolean =
    !(this.isLowPriority && other.isHighPriority)

}
