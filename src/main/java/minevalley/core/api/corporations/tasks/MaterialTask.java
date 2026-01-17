package minevalley.core.api.corporations.tasks;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Material;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import java.util.List;

@SuppressWarnings("unused")
public interface MaterialTask extends Task {

    /**
     * Gets the list of material sets required to complete this task.
     *
     * @return A list of MaterialSet objects representing the required materials and their goals.
     */
    @Nonnull
    @Contract(pure = true)
    List<MaterialSet> getMaterialSets();

    @Getter
    @AllArgsConstructor
    class MaterialSet {

        private final Material material;
        private final int goal;
        private int current;

        /**
         * Checks if the material goal has been reached.
         *
         * @return true if the current amount is greater than or equal to the goal, false otherwise.
         */
        @Contract(pure = true)
        public boolean reached() {
            return current >= goal;
        }

        /**
         * Increases the current amount by 1.
         */
        public void increase() {
            increase(1);
        }

        /**
         * Increases the current amount by the specified amount.
         *
         * @param amount The amount to increase the current count by.
         */
        public void increase(int amount) {
            current += amount;
        }
    }
}
