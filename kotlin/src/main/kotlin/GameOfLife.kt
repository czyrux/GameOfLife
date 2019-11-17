import model.Cell
import model.CellState
import model.GameOfLifeBoard

fun main(args: Array<String>) {
    println("Hello, World!")

    var board = GameOfLifeBoard.Builder()
        .withRow(
            listOf(
                CellState.Alive,
                CellState.Alive,
                CellState.Alive,
                CellState.Alive,
                CellState.Alive,
                CellState.Alive,
                CellState.Alive,
                CellState.Alive
            )
        )
        .withRow(
            listOf(
                CellState.Alive,
                CellState.Alive,
                CellState.Alive,
                CellState.Alive,
                CellState.Dead,
                CellState.Alive,
                CellState.Alive,
                CellState.Alive
            )
        )
        .withRow(
            listOf(
                CellState.Alive,
                CellState.Alive,
                CellState.Alive,
                CellState.Dead,
                CellState.Dead,
                CellState.Alive,
                CellState.Alive,
                CellState.Alive
            )
        )
        .withRow(
            listOf(
                CellState.Alive,
                CellState.Alive,
                CellState.Alive,
                CellState.Alive,
                CellState.Alive,
                CellState.Alive,
                CellState.Alive,
                CellState.Dead
            )
        )
        .build()
/*    Generation 1:
    4 8
    ........
    ....*...
    ...**...
    ........*/


    // Generation 2:
    // 4 8
    // ........
    // ...**...
    // ...**...
    // ........
}