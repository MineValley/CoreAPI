package minevalley.core.api.corporations.tasks;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Material;

import java.util.List;

@SuppressWarnings("unused")
public interface MaterialTask extends Task {

    List<MaterialSet> getMaterialSets();

    @Getter
    @AllArgsConstructor
    class MaterialSet {

        private final Material material;
        private final int goal;
        private int current;

        public boolean reached() {
            return current >= goal;
        }

        public void increase() {
            increase(1);
        }

        public void increase(int amount) {
            current += amount;
        }
    }
}
