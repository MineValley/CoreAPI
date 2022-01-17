package minevalley.core.api.corporations.tasks;

import lombok.AllArgsConstructor;
import lombok.Getter;
import minevalley.core.api.corporations.Task;
import org.bukkit.Material;

import java.util.List;

public interface MaterialTask extends Task {

    List<MaterialSet> getMaterialSets();

    @AllArgsConstructor
    @Getter
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
