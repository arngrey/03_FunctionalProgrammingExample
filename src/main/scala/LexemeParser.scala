import scala.util.matching.Regex

class LexemeParser() {
  private val openBracketPattern: Regex = "\\(".r
  private val closeBracketPattern: Regex = "\\)".r
  private val operatorPattern: Regex = "^[+\\-*/]$".r
  private val numberPattern: Regex = "^[+\\-]?\\d$".r

  /**
   * Преобразовать лексему в строковом представлении в лексему-объект.
   * @param lexemeAsString лексема в строковом представлении.
   * @return лексема-объект.
   */
  def Parse(lexemeAsString: String): Option[Lexeme] = {
    if (isOpenBracket(lexemeAsString)) {
      Some(OpenBracketLexeme(lexemeAsString))
    } else if (isCloseBracket(lexemeAsString)) {
      Some(CloseBracketLexeme(lexemeAsString))
    } else if (isOperator(lexemeAsString)) {
      Some(OperatorLexeme(lexemeAsString))
    } else if (isNumber(lexemeAsString)) {
      Some(NumericLexeme(lexemeAsString))
    } else {
      None
    }
  }

  private[this] def isOpenBracket(lexemeAsString: String): Boolean =
    openBracketPattern.matches(lexemeAsString)

  private[this] def isCloseBracket(lexemeAsString: String): Boolean =
    closeBracketPattern.matches(lexemeAsString)

  private[this] def isOperator(lexemeAsString: String): Boolean =
    operatorPattern.matches(lexemeAsString)

  private[this] def isNumber(lexemeAsString: String): Boolean =
    numberPattern.matches(lexemeAsString)
}
