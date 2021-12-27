package ru.gb.course1.gb_calculator.domain.states;

import ru.gb.course1.gb_calculator.domain.entities.InputSymbol;

public class SignState extends BaseState {

    @Override
    public BaseState onClickButton(InputSymbol inputSymbol) {
        switch (inputSymbol) {
            case OP_MINUS:
                input.add(InputSymbol.OP_MINUS);
                return new FirstIntState(input);
            case OP_PLUS:
                return this;
            case DOT:
                input.add(InputSymbol.NUM_0);
                input.add(InputSymbol.DOT);
                return new FloatState(input);
            case NUM_0:
                input.add(InputSymbol.NUM_0);
                return new ZeroState(input);
            case NUM_1:
            case NUM_2:
            case NUM_3:
                input.add(inputSymbol);
                return new IntState(input);
            case CLEAR:
                return new SignState();
            default:
                return this;
        }
    }
}
