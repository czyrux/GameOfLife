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
                Cell.Alive,
                Cell.Alive,
                Cell.Alive,
                Cell.Alive,
                Cell.Alive,
                Cell.Alive,
                Cell.Alive,
                Cell.Alive
            )
        )
        .withRow(
            listOf(
                Cell.Alive,
                Cell.Alive,
                Cell.Alive,
                Cell.Alive,
                Cell.Dead,
                Cell.Alive,
                Cell.Alive,
                Cell.Alive
            )
        )
        .withRow(
            listOf(
                Cell.Alive,
                Cell.Alive,
                Cell.Alive,
                Cell.Dead,
                Cell.Dead,
                Cell.Alive,
                Cell.Alive,
                Cell.Alive
            )
        )
        .withRow(
            listOf(
                Cell.Alive,
                Cell.Alive,
                Cell.Alive,
                Cell.Alive,
                Cell.Alive,
                Cell.Alive,
                Cell.Alive,
                Cell.Dead
            )
        )
        .build()