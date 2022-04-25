package minevalley.core.api.modulepipeline;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.function.Consumer;

@AllArgsConstructor
@RequiredArgsConstructor
public class Container {

    @Getter
    private final String text;
    private Consumer<String> answer;

    public void answer(String answer) {
        this.answer.accept(answer);
    }
}