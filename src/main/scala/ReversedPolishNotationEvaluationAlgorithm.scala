import scala.collection.mutable

/**
 * Алгоритм вычисления выражения в обратной польской записи.
 */
sealed class ReversedPolishNotationEvaluationAlgorithm {
  /**
   * Вычислить выражение в обратной польской записи.
   * @param lexemesInReversedPolishNotationOrder список лексем в порядке обратной польской записи.
   * @return Результат вычисления.
   */
  def Evaluate(lexemesInReversedPolishNotationOrder: Lexemes): Double = {
    val stack = new mutable.Stack[Double]()

    lexemesInReversedPolishNotationOrder
      .GetAsList()
      .foreach {
        case lexeme@(_: NumericLexeme) =>
          stack.push(lexeme.GetAsInt())
        case lexeme@(_: OperatorLexeme) =>
          val rightOperand = stack.pop()
          val leftOperand = stack.pop()
          lexeme.evaluate(leftOperand, rightOperand)
            match {
              case Some(value) => stack.push(value)
              case None =>
            }
        case _ =>
      }

    stack.pop()
  }
}
