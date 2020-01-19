data class GameOfLifeBoard(val boardRows: List<List<GameOfLifeCell>>) {

    fun getCell(row: Int, column: Int) = boardRows[row][column]
    fun getRows() = boardRows.size
    fun getColumns() = boardRows[0].size
    fun getNeighbours(row: Int, column: Int): List<GameOfLifeCell> {
        val neighbours = ArrayList<GameOfLifeCell>()

        // Upper row
        getCellIfInBounds(row = row - 1, column = column - 1)?.let { neighbours.add(it) }
        getCellIfInBounds(row = row - 1, column = column)?.let { neighbours.add(it) }
        getCellIfInBounds(row = row - 1, column = column + 1)?.let { neighbours.add(it) }

        // same row
        getCellIfInBounds(row = row, column = column - 1)?.let { neighbours.add(it) }
        getCellIfInBounds(row = row, column = column + 1)?.let { neighbours.add(it) }

        // Lower row
        getCellIfInBounds(row = row + 1, column = column - 1)?.let { neighbours.add(it) }
        getCellIfInBounds(row = row + 1, column = column)?.let { neighbours.add(it) }
        getCellIfInBounds(row = row + 1, column = column + 1)?.let { neighbours.add(it) }

        return neighbours
    }

    private fun getCellIfInBounds(row: Int, column: Int): GameOfLifeCell? {
        return if (row >= 0 && row < boardRows.size && column >= 0 && column < boardRows[0].size)
            boardRows[row][column]
        else
            null
    }

    class Builder {
        private var rows: MutableList<List<GameOfLifeCell>> = ArrayList()

        fun withRows(rows: List<List<GameOfLifeCell>>): Builder {
            this.rows.addAll(rows)
            return this
        }

        fun withRow(newRow: List<GameOfLifeCell>): Builder {
            rows.add(newRow)
            return this
        }

        fun build(): GameOfLifeBoard {
            check(rows.isNotEmpty()) { "No rows added to the board" }
            check(rows[0].isNotEmpty()) { "No columns" }
            rows.forEach {
                check(it.size == rows[0].size) { "Row with different column size. Expected:$rows[0].size, observed:$it.size" }
            }
            return GameOfLifeBoard(rows)
        }
    }
}