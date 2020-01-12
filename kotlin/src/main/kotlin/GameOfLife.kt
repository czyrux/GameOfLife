private val gameRules = listOf(
    UnderpopulationRule(),
    OvercrowdingRule(),
    StayAliveRule(),
    RegenerateCellRule()
)

fun playGame(initialBoard: GameOfLifeBoard, generations: Int): GameOfLifeBoard {

    var currentBoard = initialBoard

    for (_x in 0 until generations) {
        val boardBuilder = GameOfLifeBoard.Builder()
        for (i in 0 until currentBoard.getRows()) {
            val rowCells: MutableList<GameOfLifeCell> = ArrayList()
            for (j in 0 until currentBoard.getColumns()) {
                val cell = currentBoard.getCell(row = i, column = j)
                val neighbours: List<GameOfLifeCell> = currentBoard.getNeighbours(row = i, column = j)
                val newCell = gameRules
                    .find { it.apply(cell, neighbours) }
                    ?.newCellState()
                    ?: cell
                rowCells.add(newCell)
            }
            boardBuilder.withRow(rowCells)
        }
        currentBoard = boardBuilder.build()
    }

    return currentBoard
}