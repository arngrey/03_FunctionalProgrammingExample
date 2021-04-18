class NumericLexeme(private val inputLexeme: String) extends Lexeme(inputLexeme) {
  def GetAsInt(): Int = Integer.parseInt(inputLexeme)
}
