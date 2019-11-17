import model.Cell
import model.CellState

interface GameOfLifeRule {
    fun apply(cell: Cell, neighbours: List<Cell>): Boolean
    fun newCellState(): CellState
}

class UnderpopulationRule : GameOfLifeRule {
    override fun newCellState() = CellState.Dead
    override fun apply(cell: Cell, neighbours: List<Cell>): Boolean {
        if (cell.isDead()) {
            return false
        }
        return neighbours.count(Cell::isAlive) < 2
    }
}