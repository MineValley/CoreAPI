package eu.minevalley.core.api.database;

import org.intellij.lang.annotations.Language;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import java.sql.SQLException;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public interface DatabaseHolder {

    /**
     * Create a {@link StatementBuilder} based on the given SQL code.
     *
     * @param sql SQL code to prepare
     * @return a new {@link StatementBuilder} instance
     * @throws SQLException if a database access error occurs
     */
    @Nonnull
    @Contract("_ -> new")
    default StatementBuilder prepareSQL(@Nonnull @Language("SQL") String sql) throws SQLException {
        return prepareSQL(sql, false);
    }

    /**
     * Create a {@link StatementBuilder} based on the given SQL code.
     *
     * @param sql                   SQL code to prepare
     * @param retrieveGeneratedKeys whether to retrieve generated keys
     * @return a new {@link StatementBuilder} instance
     * @throws SQLException if a database access error occurs
     */
    @Nonnull
    @Contract("_ ,_ -> new")
    StatementBuilder prepareSQL(@Nonnull @Language("SQL") String sql, boolean retrieveGeneratedKeys) throws SQLException;

    /**
     * Generate a random String based on the given supplier that was not used in the given column and table.
     * <p>
     * <b>Note:</b> This method will not insert anything into the database,
     * it only checks for existing values and generates new ones until it finds a unique one.
     *
     * @param table          table to check
     * @param column         column to check
     * @param stringSupplier supplier to generate random strings
     * @return a unique string
     * @throws IllegalArgumentException if the table, column or supplier is null
     * @throws SQLException             if a database access error occurs
     */
    @Nonnull
    @Contract(value = "_, _, _ -> new", pure = true)
    String generateUniqueRandomString(@Nonnull String table, @Nonnull String column, @Nonnull Supplier<String> stringSupplier)
            throws IllegalArgumentException, SQLException;
}
