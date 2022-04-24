package minevalley.core.api.modulepipeline;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.function.Consumer;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Container {

    private final String text;
    private Consumer<String> answer;
}