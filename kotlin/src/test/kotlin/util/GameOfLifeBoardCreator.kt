package util

import GameOfLifeBoard
import GameOfLifeCell

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
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead
            )
        )
        .withRow(
            listOf(
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Alive,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead
            )
        )
        .withRow(
            listOf(
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Alive,
                GameOfLifeCell.Alive,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead
            )
        )
        .withRow(
            listOf(
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Alive
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
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead
            )
        )
        .withRow(
            listOf(
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Alive,
                GameOfLifeCell.Alive,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead
            )
        )
        .withRow(
            listOf(
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Alive,
                GameOfLifeCell.Alive,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead
            )
        )
        .withRow(
            listOf(
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead,
                GameOfLifeCell.Dead
            )
        )
        .build()