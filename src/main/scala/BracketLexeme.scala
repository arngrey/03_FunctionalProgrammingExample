class BracketLexeme(private val inputLexeme: String) extends Lexeme(inputLexeme) {
  def IsOpen(): Boolean = inputLexeme == "("
  def IsClose(): Boolean = inputLexeme == ")"
}
