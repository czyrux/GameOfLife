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

class OvercrowdingRule : GameOfLifeRule {
    override fun newCellState() = Cell.Dead
    override fun apply(cell: Cell, neighbours: List<Cell>): Boolean {
        if (cell.isDead()) {
            return false
        }
        return neighbours.count(Cell::isAlive) > 3
    }
}

class StayAliveRule : GameOfLifeRule {
    override fun newCellState() = Cell.Alive
    override fun apply(cell: Cell, neighbours: List<Cell>): Boolean {
        if (cell.isDead()) {
            return false
        }
        val aliveNeighbours = neighbours.count(Cell::isAlive)
        return aliveNeighbours == 2 || aliveNeighbours == 3
    }
}