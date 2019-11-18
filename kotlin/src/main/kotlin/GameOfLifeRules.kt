import model.Cell
import model.isAlive
import model.isDead

interface GameOfLifeRule {
    fun apply(cell: Cell, neighbours: List<Cell>): Boolean
    fun newCellState(): Cell
}

class UnderpopulationRule : GameOfLifeRule {
    override fun newCellState() = Cell.Dead
    override fun apply(cell: Cell, neighbours: List<Cell>): Boolean {
        if (cell.isDead()) {
            return false
        }
        return neighbours.count(Cell::isAlive) < 2
    }
}