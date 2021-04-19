import scala.util.matching.Regex

class LexemesParser() {
  private val lexemePattern: Regex = "([(])|([)])|([+\\-]?\\d)|\\s([+\\-*/])\\s".r

  /**
   * Преобразует входную строку в лексемы.
   * @param expressionAsString входная строка.
   * @return Лексемы.
   */
  def parse(expressionAsString: String): Lexemes = Lexemes(
    lexemePattern
      .findAllIn(expressionAsString)
      .flatMap(lexemeAsString => new LexemeParser().parse(lexemeAsString))
      .toList
  )
}
