interface GameOfLifeRule {
    fun apply(cell: GameOfLifeCell, neighbours: List<GameOfLifeCell>): Boolean
    fun newCellState(): GameOfLifeCell
}

class UnderpopulationRule : GameOfLifeRule {
    override fun newCellState() = GameOfLifeCell.Dead
    override fun apply(cell: GameOfLifeCell, neighbours: List<GameOfLifeCell>): Boolean {
        if (cell.isDead()) {
            return false
        }
        return neighbours.count(GameOfLifeCell::isAlive) < 2
    }
}

class OvercrowdingRule : GameOfLifeRule {
    override fun newCellState() = GameOfLifeCell.Dead
    override fun apply(cell: GameOfLifeCell, neighbours: List<GameOfLifeCell>): Boolean {
        if (cell.isDead()) {
            return false
        }
        return neighbours.count(GameOfLifeCell::isAlive) > 3
    }
}

class StayAliveRule : GameOfLifeRule {
    override fun newCellState() = GameOfLifeCell.Alive
    override fun apply(cell: GameOfLifeCell, neighbours: List<GameOfLifeCell>): Boolean {
        if (cell.isDead()) {
            return false
        }
        val aliveNeighbours = neighbours.count(GameOfLifeCell::isAlive)
        return aliveNeighbours == 2 || aliveNeighbours == 3
    }
}

class RegenerateCellRule : GameOfLifeRule {
    override fun newCellState() = GameOfLifeCell.Alive
    override fun apply(cell: GameOfLifeCell, neighbours: List<GameOfLifeCell>): Boolean {
        if (cell.isAlive()) {
            return false
        }
        return neighbours.count(GameOfLifeCell::isAlive) == 3
    }
}