package eu.minevalley.core.api.gui;

@SuppressWarnings("unused")
public enum GuiRow {
    ROW_1, ROW_2, ROW_3, ROW_4, ROW_5, ROW_6;

    public int firstSlot() {
        return ordinal() * 9;
    }
}
