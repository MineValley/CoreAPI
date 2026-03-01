package minevalley.core.api.database;

import org.intellij.lang.annotations.Language;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import java.sql.SQLException;

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
}
