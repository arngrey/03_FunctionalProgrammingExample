case class Expression(private val expressionInInfixNotation: String) {
  def GetReversedPolishNotation(): String =
    new LexemesParser()
      .Parse(expressionInInfixNotation)
      .ToReversedPolishNotationOrder()
      .GetAsString()

  def GetValue(): Int = 0
}
