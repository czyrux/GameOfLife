sealed class GameOfLifeCell {
    object Alive : GameOfLifeCell()
    object Dead : GameOfLifeCell()
}

fun GameOfLifeCell.isAlive() = this == GameOfLifeCell.Alive
fun GameOfLifeCell.isDead() = this == GameOfLifeCell.Dead