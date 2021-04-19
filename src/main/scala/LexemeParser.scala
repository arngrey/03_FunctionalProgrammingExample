import scala.util.matching.Regex

class LexemeParser() {
  private val openBracketPattern: Regex = "^[(]$".r
  private val closeBracketPattern: Regex = "^[)]$".r
  private val operatorPattern: Regex = "^[+\\-*/]$".r
  private val numberPattern: Regex = "^[+\\-]?\\d$".r

  /**
   * Преобразует входную строку в лексему.
   * @param lexemeAsString входная строка.
   * @return Лексема.
   */
  def parse(lexemeAsString: String): Option[Lexeme] = {
    if (isOpenBracket(lexemeAsString)) {
      Some(new OpenBracketLexeme(lexemeAsString))
    } else if (isCloseBracket(lexemeAsString)) {
      Some(new CloseBracketLexeme(lexemeAsString))
    } else if (isOperator(lexemeAsString)) {
      Some(new OperatorLexeme(lexemeAsString))
    } else if (isNumber(lexemeAsString)) {
      Some(new NumericLexeme(lexemeAsString))
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
