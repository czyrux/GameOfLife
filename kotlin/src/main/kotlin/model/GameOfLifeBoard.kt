package model

class GameOfLifeBoard(private val boardRows: List<List<Cell>>) {

    fun getCell(row : Int, column : Int) = boardRows[row][column]
    fun getRows() = boardRows.size
    fun getColumns() = boardRows[0].size

    class Builder() {
        private var rows: MutableList<List<Cell>> = ArrayList()

        fun withRow(newRow: List<CellState>): Builder {
            rows.add(newRow.map { cellState: CellState -> Cell(cellState) })
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