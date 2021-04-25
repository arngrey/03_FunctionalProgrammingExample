case class OperatorLexeme (private val inputLexeme: String) extends Lexeme(inputLexeme) {
  /**
   * @return является ли оператор высокоприоритетным?
   */
  def isHighPriority: Boolean = inputLexeme == "*" || inputLexeme == "/"

  /**
   * @return является ли оператор низкоприоритетным?
   */
  def isLowPriority: Boolean = inputLexeme == "+" || inputLexeme == "-"

  /**
   * @param other другой оператор.
   * @return является ли приоритет оператора выше либо равным приоритету другого оператора?
   */
  def HasGraterOrEqualPriorityThan(other: OperatorLexeme): Boolean =
    !(this.isLowPriority && other.isHighPriority)

  /**
   * Применить оператор к операндам и получить результат.
   * @param leftOperand левый операнд.
   * @param rightOperand правый операнд.
   * @return результат операции.
   */
  def evaluate(leftOperand: Double, rightOperand: Double): Option[Double] =
    inputLexeme match {
      case "+" => Some(leftOperand + rightOperand)
      case "-" => Some(leftOperand - rightOperand)
      case "*" => Some(leftOperand * rightOperand)
      case "/" => Some(leftOperand / rightOperand)
      case _ => None
    }
}
