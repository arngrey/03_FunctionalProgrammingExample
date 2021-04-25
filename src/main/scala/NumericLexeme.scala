case class NumericLexeme(private val inputLexeme: String) extends Lexeme(inputLexeme) {
  /**
   * Получить значение числовой лексемы.
   * @return значение лексемы.
   */
  def GetAsInt(): Int = Integer.parseInt(inputLexeme)
}
