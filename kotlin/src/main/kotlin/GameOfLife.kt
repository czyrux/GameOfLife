private val gameRules = listOf(
    UnderpopulationRule(),
    OvercrowdingRule(),
    StayAliveRule(),
    RegenerateCellRule()
)

fun playGame(initialBoard: GameOfLifeBoard, generations: Int): GameOfLifeBoard {

    var currentBoard = initialBoard
    (0..generations).forEach { _ ->
        val nextBoardBuilder = GameOfLifeBoard.Builder()
        currentBoard.boardRows
            .mapIndexed { rowIndex, row ->
                row.mapIndexed { columnIndex, cell ->
                    val neighbours = currentBoard.getNeighbours(rowIndex, columnIndex)
                    val matchingRule = gameRules.find { it.apply(cell, neighbours) }
                    matchingRule?.newCellState() ?: cell
                }
            }
            .forEach { newRow -> nextBoardBuilder.withRow(newRow) }

        currentBoard = nextBoardBuilder.build()
    }

    return currentBoard
}