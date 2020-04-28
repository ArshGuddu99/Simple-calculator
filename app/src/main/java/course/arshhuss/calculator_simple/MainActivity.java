package course.arshhuss.calculator_simple;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView tv;
    static int number1 = 0;
    static int number2 = 0;
    boolean n1_obtained = false;
    boolean n2_obtained = false;
    boolean op_obtained = false;
    boolean equals = false;
    char operation;
    float result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.numbers);

    }

    public void onclick(View view) {
        Button tapped = (Button) view;
        int tappedpos = Integer.parseInt(tapped.getTag().toString());

        if (tappedpos == 14) {
            tv.setText("");
            number1 = 0;
            number2 = 0;
            n1_obtained = false;
            n2_obtained = false;
            op_obtained = false;
            equals = false;
        }
        else {

            if (!n1_obtained) {
                if (tappedpos >= 0 && tappedpos <= 9) {
                    number1 = 10 * number1 + tappedpos;
                    tv.setText(Integer.toString(number1));
                }
                if (tappedpos > 9 && tappedpos < 15) {
                    op_obtained = true;
                    n1_obtained = true;
                    if (tappedpos == 10) {
                        operation = '+';
                    }
                    if (tappedpos == 11) {
                        operation = '-';
                    }
                    if (tappedpos == 12) {
                        operation = '*';
                    }
                    if (tappedpos == 13) {
                        operation = '/';
                    }
                    tv.setText(Integer.toString(number1) + operation);
                }
            }

            if (n1_obtained && op_obtained && !n2_obtained) {
                if (tappedpos >= 0 && tappedpos <= 9) {
                    number2 = 10 * number2 + tappedpos;
                    tv.setText(Integer.toString(number1) + operation + Integer.toString(number2));
                }
                if (tappedpos == 15) {
                    equals = true;
                    n2_obtained = true;
                }
            }

            if (n1_obtained && n2_obtained && op_obtained) {
                if (operation == '+') {
                    result = number1 + number2;
                }
                if (operation == '-') {
                    result = number1 - number2;
                }
                if (operation == '*') {
                    result = number1 * number2;
                }
                if (operation == '/') {
                    result = (float)number1 / number2;
                }
                tv.setText(Float.toString(result));
            }


        }}

}
