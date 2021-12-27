package ru.gb.course1.gb_calculator.domain.states;

import java.util.List;

import ru.gb.course1.gb_calculator.domain.entities.InputSymbol;

/**
 * Ввод первой цифры целой части числа после после знака (минус/плюс)
 * -"2"2323.23424
 */
public class FirstIntState extends BaseState {

    public FirstIntState(List<InputSymbol> input) {
        this.input.addAll(input);
    }

    @Override
    public BaseState onClickButton(InputSymbol inputSymbol) {
        switch (inputSymbol) {
            case NUM_1:
            case NUM_2:
            case NUM_3:
                input.add(inputSymbol);
                return new IntState(input);
            case DOT:
                input.add(InputSymbol.NUM_0);
                input.add(InputSymbol.DOT);
                return new FloatState(input);
            case NUM_0:
                input.add(InputSymbol.NUM_0);
                return new ZeroState(input);
            case CLEAR:
                return new SignState();
            default:
                return this;
        }
    }
}
