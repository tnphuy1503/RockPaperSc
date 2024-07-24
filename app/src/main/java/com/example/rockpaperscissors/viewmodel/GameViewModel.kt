/*
 * *
 *  * Copyright (c) $YEAR $USER. All rights reserved.
 *  *
 *  * Created by $USER on $DATE.
 *  * Filename: $NAME
 *
 */

package com.example.rockpaperscissors.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rockpaperscissors.model.Choice
import com.example.rockpaperscissors.model.GamePlay

class GameViewModel : ViewModel() {
    private val game = GamePlay()

    private val _result = MutableLiveData<String>()
    val result: LiveData<String> = _result

    private val _computerChoice = MutableLiveData<Choice>()
    val computerChoice: LiveData<Choice> = _computerChoice

    fun play(playerChoice: Choice) {
        val compChoice = game.generateComputerChoice()
        _computerChoice.value = compChoice
        _result.value = game.play(playerChoice, compChoice)
    }
}