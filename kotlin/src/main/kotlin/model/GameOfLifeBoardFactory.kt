package model

/*
Generation 1:
4 8
........
....*...
...**...
........
*/

fun createSampleBoardGen1() =
    GameOfLifeBoard.Builder()
        .withRow(
            listOf(
                Cell.Dead,
                Cell.Dead,
                Cell.Dead,
                Cell.Dead,
                Cell.Dead,
                Cell.Dead,
                Cell.Dead,
                Cell.Dead
            )
        )
        .withRow(
            listOf(
                Cell.Dead,
                Cell.Dead,
                Cell.Dead,
                Cell.Dead,
                Cell.Alive,
                Cell.Dead,
                Cell.Dead,
                Cell.Dead
            )
        )
        .withRow(
            listOf(
                Cell.Dead,
                Cell.Dead,
                Cell.Dead,
                Cell.Alive,
                Cell.Alive,
                Cell.Dead,
                Cell.Dead,
                Cell.Dead
            )
        )
        .withRow(
            listOf(
                Cell.Dead,
                Cell.Dead,
                Cell.Dead,
                Cell.Dead,
                Cell.Dead,
                Cell.Dead,
                Cell.Dead,
                Cell.Alive
            )
        )
        .build()

/*
Generation 2:
4 8
........
...**...
...**...
........
*/

fun createSampleBoardGen2() =
    GameOfLifeBoard.Builder()
        .withRow(
            listOf(
                Cell.Dead,
                Cell.Dead,
                Cell.Dead,
                Cell.Dead,
                Cell.Dead,
                Cell.Dead,
                Cell.Dead,
                Cell.Dead
            )
        )
        .withRow(
            listOf(
                Cell.Dead,
                Cell.Dead,
                Cell.Dead,
                Cell.Alive,
                Cell.Alive,
                Cell.Dead,
                Cell.Dead,
                Cell.Dead
            )
        )
        .withRow(
            listOf(
                Cell.Dead,
                Cell.Dead,
                Cell.Dead,
                Cell.Alive,
                Cell.Alive,
                Cell.Dead,
                Cell.Dead,
                Cell.Dead
            )
        )
        .withRow(
            listOf(
                Cell.Dead,
                Cell.Dead,
                Cell.Dead,
                Cell.Dead,
                Cell.Dead,
                Cell.Dead,
                Cell.Dead,
                Cell.Dead
            )
        )
        .build()