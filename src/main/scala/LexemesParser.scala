import scala.util.matching.Regex

class LexemesParser() {
  private val lexemePattern: Regex = "([(])|([)])|([+\\-]?\\d)|(?<=\\s)([+\\-*/])(?=\\s)".r

  /**
   * Преобразовать строковое выражение в список лексем.
   * @param expressionAsString строковое выражение.
   * @return список лексем в порядке инфиксной записи.
   */
  def Parse(expressionAsString: String): Lexemes = new Lexemes(
    lexemePattern
      .findAllIn(expressionAsString)
      .flatMap(lexemeAsString => new LexemeParser().Parse(lexemeAsString))
      .toList
  )
}
