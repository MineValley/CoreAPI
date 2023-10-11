package minevalley.core.api.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Pair<K, V> {
    private K key;
    private V value;
}
