package ryandoupe.acheivement.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textview);

        String inputString = "Let's have some fun";

        String text = changetoLeet(inputString);
        textView.setText(text);
    }

    private String changetoLeet(String inputString) {
        List<ReplaceMapping> replacements = new ArrayList();
        replacements.add(new ReplaceMapping('a', 'A', '4'));
        replacements.add(new ReplaceMapping('e', 'E', '3'));
        replacements.add(new ReplaceMapping('i', 'I', '1'));
        replacements.add(new ReplaceMapping('o', 'O', '0'));
        replacements.add(new ReplaceMapping('s', 'S', '5'));
        replacements.add(new ReplaceMapping('t', 'T', '7'));
        replacements.add(new ReplaceMapping('b', 'D', '5'));
        return replaceLetters(replacements, inputString);
    }

    private String replaceLetters(List<ReplaceMapping> replacements, String inputString) {
        for (ReplaceMapping replacement : replacements) {
            inputString = inputString.replace(replacement.first, replacement.replaceWith);
            inputString = inputString.replace(replacement.second, replacement.replaceWith);
        }
        return inputString;
    }


    public static class ReplaceMapping {
        public final char first;
        public  final char second;
        public final char replaceWith;

        public ReplaceMapping(char p0, char p1, char replaceWith) {
            this.first = p0;
            this.second = p1;
            this.replaceWith = replaceWith;
        }
    }
}