package model

/*
Generation 1:
4 8
........
....*...
...**...
........
*/

fun createSampleBoard() =
    GameOfLifeBoard.Builder()
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