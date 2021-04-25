class Lexemes(private val lexemesAsList: List[Lexeme]) {
  def ToReversedPolishNotationOrder(): Lexemes = new Lexemes(
    new ShuntingYardAlgorithm()
      .toReversedPolishNotationOrder(lexemesAsList)
  )

  def GetAsList(): List[Lexeme] = lexemesAsList

  def GetAsString(): String =
    lexemesAsList
      .map(lexeme => lexeme.GetAsString())
      .mkString(" ")
}
