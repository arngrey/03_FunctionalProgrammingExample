class Expression(private val expressionInInfixNotation: String) {
  def GetReversedPolishNotation(): String =
    GetLexemesInReversedPolishNotationOrder()
      .GetAsString()

  def GetValue(): Double = {
    new ReversedPolishNotationEvaluationAlgorithm()
      .Evaluate(GetLexemesInReversedPolishNotationOrder())
  }

  private[this] def GetLexemesInReversedPolishNotationOrder(): Lexemes =
    new LexemesParser()
      .Parse(expressionInInfixNotation)
      .ToReversedPolishNotationOrder()


}
