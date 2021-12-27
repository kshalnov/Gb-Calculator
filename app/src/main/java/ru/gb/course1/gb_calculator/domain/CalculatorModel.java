package ru.gb.course1.gb_calculator.domain;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import ru.gb.course1.gb_calculator.domain.entities.InputSymbol;
import ru.gb.course1.gb_calculator.domain.states.BaseState;
import ru.gb.course1.gb_calculator.domain.states.SignState;

public class CalculatorModel {
    private BaseState currentState = new SignState();

    public void onClickButton(InputSymbol inputSymbol) {
        BaseState newState = currentState.onClickButton(inputSymbol);
        Log.d("@@@", "Old state = " + currentState.getClass().getSimpleName());
        Log.d("@@@", "Input symbol = " + inputSymbol.name());
        Log.d("@@@", "New state = " + newState.getClass().getSimpleName());
        Log.d("@@@", "\n");
        currentState = newState;
    }

    public List<InputSymbol> getInput() {
        return new ArrayList<>(currentState.getInput());
    }

}
