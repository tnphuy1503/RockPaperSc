package com.example.rockpaperscissors.model

/**
 * Game play
 *
 * @constructor Create empty Game play
 */
class GamePlay {
    /**
     * Play
     *
     * @param playerChoice
     * @param computerChoice
     * @return
     */
    fun play(playerChoice: Choice, computerChoice: Choice): String {
        return when {
            playerChoice == computerChoice -> "It's a tie"
            (playerChoice == Choice.ROCK && computerChoice == Choice.SCISSORS) ||
                    (playerChoice == Choice.PAPER && computerChoice == Choice.ROCK) ||
                    (playerChoice == Choice.SCISSORS && computerChoice == Choice.PAPER) -> "You win!"
            else -> "Computer wins!"
        }
    }

    /**
     * Generate computer choice
     *
     * @return
     */
    fun generateComputerChoice(): Choice {
        return Choice.values().random();
    }
}