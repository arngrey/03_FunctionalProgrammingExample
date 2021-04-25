sealed class ReversedPolishNotationEvaluationAlgorithm {
  def Evaluate(lexemesInReversedPolishNotationOrder: Lexemes): Double = {
    val stack = new Stack[Double]()

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
