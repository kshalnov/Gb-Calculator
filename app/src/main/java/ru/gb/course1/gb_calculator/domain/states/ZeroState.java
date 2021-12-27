package ru.gb.course1.gb_calculator.domain.states;

import java.util.List;

import ru.gb.course1.gb_calculator.domain.entities.InputSymbol;

public class ZeroState extends BaseState {
    public ZeroState(List<InputSymbol> input) {
        this.input.addAll(input);
    }

    @Override
    public BaseState onClickButton(InputSymbol inputSymbol) {
        switch (inputSymbol) {
            case DOT:
                input.add(InputSymbol.DOT);
                return new FloatState(input);
            case CLEAR:
                return new SignState();
            default:
                return this;
        }
    }
}
