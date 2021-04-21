class Lexemes(private val lexemesAsList: List[Lexeme]) {
  def ToReversedPolishNotationOrder(): Lexemes = new Lexemes(
    new ShuntingYardAlgorithm()
      .toReversedPolishNotationOrder(lexemesAsList)
  )

  def GetAsString(): String =
    lexemesAsList
      .map(lexeme => lexeme.GetAsString())
      .mkString(" ")
}
