class Lexemes(private val lexemesAsList: List[Lexeme]) {
  /**
   * Получить список лексем в порядке обратной польской записи.
   * @return список лексем в порядке обратной польской записи.
   */
  def ToReversedPolishNotationOrder(): Lexemes = new Lexemes(
    new ShuntingYardAlgorithm()
      .toReversedPolishNotationOrder(lexemesAsList)
  )

  /**
   * Получить список лексем.
   * @return список лексем.
   */
  def GetAsList(): List[Lexeme] = lexemesAsList

  /**
   * Получить строковое представление списка лексем.
   * @return строковое представление списка лексем.
   */
  def GetAsString(): String =
    lexemesAsList
      .map(lexeme => lexeme.GetAsString())
      .mkString(" ")

  /**
   * Вычислить выражение.
   * @return результат вычисления.
   */
  def Evaluate(): Double =
    new ReversedPolishNotationEvaluationAlgorithm()
      .Evaluate(this.ToReversedPolishNotationOrder())
}
