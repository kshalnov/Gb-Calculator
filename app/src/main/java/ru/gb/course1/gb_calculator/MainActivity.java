package ru.gb.course1.gb_calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import ru.gb.course1.gb_calculator.domain.CalculatorModel;
import ru.gb.course1.gb_calculator.domain.entities.InputSymbol;

public class MainActivity extends AppCompatActivity {
    private TextView resultTextView;
    private Button num1Button;
    private Button num2Button;
    private Button num3Button;
    private Button num0Button;
    private Button minusButton;
    private Button plusButton;
    private Button dotButton;
    private Button clearButton;

    private CalculatorModel calculatorModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculatorModel = new CalculatorModel();

        initViews();
        initListeners();
    }

    private void initViews() {
        resultTextView = findViewById(R.id.result_text_view);

        num1Button = findViewById(R.id.num_1_button);
        num2Button = findViewById(R.id.num_2_button);
        num3Button = findViewById(R.id.num_3_button);
        num0Button = findViewById(R.id.num_0_button);

        minusButton = findViewById(R.id.minus_button);
        plusButton = findViewById(R.id.plus_button);
        dotButton = findViewById(R.id.dot_button);
        clearButton = findViewById(R.id.clear_button);
    }

    private void initListeners() {
        num1Button.setOnClickListener(v -> updateInput(InputSymbol.NUM_1));
        num2Button.setOnClickListener(v -> updateInput(InputSymbol.NUM_2));
        num3Button.setOnClickListener(v -> updateInput(InputSymbol.NUM_3));
        num0Button.setOnClickListener(v -> updateInput(InputSymbol.NUM_0));

        dotButton.setOnClickListener(v -> updateInput(InputSymbol.DOT));
        minusButton.setOnClickListener(v -> updateInput(InputSymbol.OP_MINUS));
        plusButton.setOnClickListener(v -> updateInput(InputSymbol.OP_PLUS));
        clearButton.setOnClickListener(v -> updateInput(InputSymbol.CLEAR));
    }

    private void updateInput(InputSymbol inputSymbol) {
        calculatorModel.onClickButton(inputSymbol);
        List<InputSymbol> inputSymbolList = calculatorModel.getInput();
        resultTextView.setText(convertInputSymbolsToString(inputSymbolList));
    }

    private String convertInputSymbolsToString(List<InputSymbol> inputSymbolList) {
        final StringBuilder sb = new StringBuilder();
        for (InputSymbol inputSymbol : inputSymbolList) {
            switch (inputSymbol) {
                case NUM_0:
                    sb.append("0");
                    break; // todo вынести в strings.xml
                case NUM_1:
                    sb.append("1");
                    break;
                case NUM_2:
                    sb.append("2");
                    break;
                case NUM_3:
                    sb.append("3");
                    break;
                case DOT:
                    sb.append(".");
                    break;
                case OP_MINUS:
                    sb.append("-");
                    break;
                case OP_PLUS:
                    sb.append("+");
                    break;
                default:
                    sb.append("@");
                    break;
            }
        }
        return sb.toString();
    }

}