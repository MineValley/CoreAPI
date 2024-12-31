package minevalley.core.api.database;

import minevalley.core.api.Core;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import java.math.BigDecimal;
import java.sql.*;
import java.util.concurrent.CompletableFuture;

/**
 * This interface covers some but not nearly all features of the {@link PreparedStatement} interface as provided by the JDBC API.
 * It's designed to provide some improvements such as an asynchronous execution and a builder pattern for setting parameters to reduce boilerplate code.
 * Such as the {@link PreparedStatement} interface, the results of the query can be retrieved using the {@link ResultSet} interface.
 * <p>You can call {@link StatementBuilder#executeUpdate()} or {@link StatementBuilder#executeQuery()} multiple times with or without changing parameters in between.
 * <p>Use {@link StatementBuilder#unwrap()} to get the underlying {@link PreparedStatement} object if you need to use a method that is not covered by this interface.
 * <p>The following code snippet demonstrates a possible way to use this interface:
 * <pre>
 * {@code
 * Core.prepareSQL("UPDATE team SET note = ? WHERE unique_id = ?")
 * .setString(1, "Coolest boss ever")
 * .setString(2, "e0ae458e-214c-409e-ad6d-4091a6719bb0")
 * .executeUpdate();
 * }
 * </pre>
 *
 * @see Core#prepareSQL(String)
 * @see PreparedStatement
 * @see ResultSet
 */
@SuppressWarnings("unused")
public interface StatementBuilder extends AutoCloseable {

    /**
     * Sets the parameter at the given index to SQL {@code NULL}.
     * <p>
     * <b>Note:</b> Even though JDBC handles untyped {@code NULL} values pretty well, it is mandatory to provide the {@link ColumnType} of the parameter.
     *
     * @param parameterIndex the index of the parameter to set, beginning with 1
     * @param type           the {@link ColumnType} of the parameter
     * @return this {@link StatementBuilder} object
     * @throws IllegalStateException if this method is called on a closed {@link StatementBuilder}
     * @throws SQLException          if a database access error occurs
     */
    @Nonnull
    @Contract("_, _ -> this")
    StatementBuilder setNull(int parameterIndex, @Nonnull ColumnType type) throws IllegalStateException, SQLException;

    /**
     * Sets the parameter at the given index to the given {@code boolean} value.
     * <p><b>Representation:</b> {@code boolean} values are converted to SQL {@code BIT} values</p>
     *
     * @param parameterIndex the index of the parameter to set, beginning with 1
     * @param bool           the {@code boolean} value to set
     * @return this {@link StatementBuilder} object
     * @throws IllegalStateException if this method is called on a closed {@link StatementBuilder}
     * @throws SQLException          if a database access error occurs
     */
    @Nonnull
    @Contract("_, _ -> this")
    StatementBuilder setBoolean(int parameterIndex, boolean bool) throws IllegalStateException, SQLException;

    /**
     * Sets the parameter at the given index to the given {@code byte} value.
     * <p><b>Representation:</b> {@code byte} values are converted to SQL {@code TINYINT} values</p>
     *
     * @param parameterIndex the index of the parameter to set, beginning with 1
     * @param b              the {@code byte} value to set
     * @return this {@link StatementBuilder} object
     * @throws IllegalStateException if this method is called on a closed {@link StatementBuilder}
     * @throws SQLException          if a database access error occurs
     */
    @Nonnull
    @Contract("_, _ -> this")
    StatementBuilder setByte(int parameterIndex, byte b) throws IllegalStateException, SQLException;

    /**
     * Sets the parameter at the given index to the given {@code short} value.
     * <p><b>Representation:</b> {@code short} values are converted to SQL {@code SMALLINT} values</p>
     *
     * @param parameterIndex the index of the parameter to set, beginning with 1
     * @param s              the {@code short} value to set
     * @return this {@link StatementBuilder} object
     * @throws IllegalStateException if this method is called on a closed {@link StatementBuilder}
     * @throws SQLException          if a database access error occurs
     */
    @Nonnull
    @Contract("_, _ -> this")
    StatementBuilder setShort(int parameterIndex, short s) throws IllegalStateException, SQLException;

    /**
     * Sets the parameter at the given index to the given {@code int} value.
     * <p><b>Representation:</b> {@code int} values are converted to SQL {@code INTEGER} values</p>
     *
     * @param parameterIndex the index of the parameter to set, beginning with 1
     * @param i              the {@code int} value to set
     * @return this {@link StatementBuilder} object
     * @throws IllegalStateException if this method is called on a closed {@link StatementBuilder}
     * @throws SQLException          if a database access error occurs
     */
    @Nonnull
    @Contract("_, _ -> this")
    StatementBuilder setInt(int parameterIndex, int i) throws IllegalStateException, SQLException;

    /**
     * Sets the parameter at the given index to the given {@code long} value.
     * <p><b>Representation:</b> {@code long} values are converted to SQL {@code BIGINT} values</p>
     *
     * @param parameterIndex the index of the parameter to set, beginning with 1
     * @param l              the {@code long} value to set
     * @return this {@link StatementBuilder} object
     * @throws IllegalStateException if this method is called on a closed {@link StatementBuilder}
     * @throws SQLException          if a database access error occurs
     */
    @Nonnull
    @Contract("_, _ -> this")
    StatementBuilder setLong(int parameterIndex, long l) throws IllegalStateException, SQLException;

    /**
     * Sets the parameter at the given index to the given {@code float} value.
     * <p><b>Representation:</b> {@code float} values are converted to SQL {@code FLOAT} values</p>
     *
     * @param parameterIndex the index of the parameter to set, beginning with 1
     * @param f              the {@code float} value to set
     * @return this {@link StatementBuilder} object
     * @throws IllegalStateException if this method is called on a closed {@link StatementBuilder}
     * @throws SQLException          if a database access error occurs
     */
    @Nonnull
    @Contract("_, _ -> this")
    StatementBuilder setFloat(int parameterIndex, float f) throws IllegalStateException, SQLException;

    /**
     * Sets the parameter at the given index to the given {@code double} value.
     * <p><b>Representation:</b> {@code double} values are converted to SQL {@code DOUBLE} values</p>
     *
     * @param parameterIndex the index of the parameter to set, beginning with 1
     * @param d              the {@code double} value to set
     * @return this {@link StatementBuilder} object
     * @throws IllegalStateException if this method is called on a closed {@link StatementBuilder}
     * @throws SQLException          if a database access error occurs
     */
    @Nonnull
    @Contract("_, _ -> this")
    StatementBuilder setDouble(int parameterIndex, double d) throws IllegalStateException, SQLException;

    /**
     * Sets the parameter at the given index to the given {@link BigDecimal} value.
     * <p><b>Representation:</b> {@link BigDecimal} values are converted to SQL {@code DECIMAL} values</p>
     * <p>
     * <b>Note:</b> This method is not meant to handle {@code NULL} values. Use {@link StatementBuilder#setNull(int, ColumnType)} instead.
     *
     * @param parameterIndex the index of the parameter to set, beginning with 1
     * @param bd             the {@link BigDecimal} value to set.
     * @return this {@link StatementBuilder} object
     * @throws IllegalArgumentException if {@code bd} is {@code null}
     * @throws IllegalStateException    if this method is called on a closed {@link StatementBuilder}
     * @throws SQLException             if a database access error occurs
     */
    @Nonnull
    @Contract("_, _ -> this")
    StatementBuilder setBigDecimal(int parameterIndex, @Nonnull BigDecimal bd) throws IllegalArgumentException, IllegalStateException, SQLException;

    /**
     * Sets the parameter at the given index to the given {@link String} value.
     * <p><b>Representation:</b> {@link String} values are converted to SQL {@code VARCHAR} values</p>
     * <p>
     * <b>Note:</b> This method is not meant to handle {@code NULL} values. Use {@link StatementBuilder#setNull(int, ColumnType)} instead.
     *
     * @param parameterIndex the index of the parameter to set, beginning with 1
     * @param s              the {@link String} value to set
     * @return this {@link StatementBuilder} object
     * @throws IllegalArgumentException if {@code s} is {@code null}
     * @throws IllegalStateException    if this method is called on a closed {@link StatementBuilder}
     * @throws SQLException             if a database access error occurs
     */
    @Nonnull
    @Contract("_, _ -> this")
    StatementBuilder setString(int parameterIndex, @Nonnull String s) throws IllegalArgumentException, IllegalStateException, SQLException;

    /**
     * Sets the parameter at the given index to the given {@code byte} array.
     * <p><b>Representation:</b> {@code byte} arrays are converted to SQL {@code VARBINARY} values</p>
     * <p>
     * <b>Note:</b> This method is not meant to handle {@code NULL} values. Use {@link StatementBuilder#setNull(int, ColumnType)} instead.
     *
     * @param parameterIndex the index of the parameter to set, beginning with 1
     * @param bytes          the {@code byte} array to set
     * @return this {@link StatementBuilder} object
     * @throws IllegalArgumentException if {@code bytes} is {@code null}
     * @throws IllegalStateException    if this method is called on a closed {@link StatementBuilder}
     * @throws SQLException             if a database access error occurs
     */
    @Nonnull
    @Contract("_, _ -> this")
    StatementBuilder setBytes(int parameterIndex, @Nonnull byte[] bytes) throws IllegalArgumentException, IllegalStateException, SQLException;

    /**
     * Sets the parameter at the given index to the given {@link Date} value.
     * <p><b>Representation:</b> {@link Date} values are converted to SQL {@code DATE} values</p>
     * <p>
     * <b>Note:</b> This method is not meant to handle {@code NULL} values. Use {@link StatementBuilder#setNull(int, ColumnType)} instead.
     *
     * @param parameterIndex the index of the parameter to set, beginning with 1
     * @param date           the {@link Date} value to set
     * @return this {@link StatementBuilder} object
     * @throws IllegalArgumentException if {@code date} is {@code null}
     * @throws IllegalStateException    if this method is called on a closed {@link StatementBuilder}
     * @throws SQLException             if a database access error occurs
     */
    @Nonnull
    @Contract("_, _ -> this")
    StatementBuilder setDate(int parameterIndex, @Nonnull Date date) throws IllegalArgumentException, IllegalStateException, SQLException;

    /**
     * Sets the parameter at the given index to the given {@link Time} value.
     * <p><b>Representation:</b> {@link Time} values are converted to SQL {@code TIME} values</p>
     * <p>
     * <b>Note:</b> This method is not meant to handle {@code NULL} values. Use {@link StatementBuilder#setNull(int, ColumnType)} instead.
     *
     * @param parameterIndex the index of the parameter to set, beginning with 1
     * @param time           the {@link Time} value to set
     * @return this {@link StatementBuilder} object
     * @throws IllegalArgumentException if {@code time} is {@code null}
     * @throws IllegalStateException    if this method is called on a closed {@link StatementBuilder}
     * @throws SQLException             if a database access error occurs
     */
    @Nonnull
    @Contract("_, _ -> this")
    StatementBuilder setTime(int parameterIndex, @Nonnull Time time) throws IllegalArgumentException, IllegalStateException, SQLException;

    /**
     * Sets the parameter at the given index to the given {@link Timestamp} value.
     * <p><b>Representation:</b> {@link Timestamp} values are converted to SQL {@code TIMESTAMP} values</p>
     * <p>
     * <b>Note:</b> This method is not meant to handle {@code NULL} values. Use {@link StatementBuilder#setNull(int, ColumnType)} instead.
     *
     * @param parameterIndex the index of the parameter to set, beginning with 1
     * @param timestamp      the {@link Timestamp} value to set
     * @return this {@link StatementBuilder} object
     * @throws IllegalArgumentException if {@code timestamp} is {@code null}
     * @throws IllegalStateException    if this method is called on a closed {@link StatementBuilder}
     * @throws SQLException             if a database access error occurs
     */
    @Nonnull
    @Contract("_, _ -> this")
    StatementBuilder setTimestamp(int parameterIndex, @Nonnull Timestamp timestamp) throws IllegalArgumentException, IllegalStateException, SQLException;

    /**
     * Sets the parameter at the given index to the given {@link Object} value.
     * <p>
     * <b>Note:</b>
     * <ul>
     *     <li>Even though this method supports all SQL types, it is recommended to use the more specific methods.</li>
     *     <li>If the desired type is not handled by one of the specific methods, there is a high chance that a conversion (e.g. to {@link String}) is necessary to store the value in the database.</li>
     *     <li>This method is not meant to handle {@code NULL} values. Use {@link StatementBuilder#setNull(int, ColumnType)} instead.</li>
     * </ul>
     *
     * @param parameterIndex the index of the parameter to set, beginning with 1
     * @param obj            the {@link Object} value to set
     * @return this {@link StatementBuilder} object
     * @throws IllegalArgumentException if {@code obj} is {@code null}
     * @throws IllegalStateException    if this method is called on a closed {@link StatementBuilder}
     * @throws SQLException             if a database access error occurs
     */
    @Nonnull
    @Contract("_, _ -> this")
    StatementBuilder setObject(int parameterIndex, @Nonnull Object obj) throws IllegalArgumentException, IllegalStateException, SQLException;

    /**
     * Sets the parameter at the given index to the given {@link Object} value.
     * <p>
     * <b>Note:</b>
     * <ul>
     *     <li>Even though this method supports all SQL types, it is recommended to use the more specific methods.</li>
     *     <li>This method is not meant to handle {@code NULL} values. Use {@link StatementBuilder#setNull(int, ColumnType)} instead.</li>
     * </ul>
     *
     * @param parameterIndex the index of the parameter to set, beginning with 1
     * @param obj            the {@link Object} value to set
     * @param type           the {@link ColumnType} of the parameter
     * @return this {@link StatementBuilder} object
     * @throws IllegalArgumentException if {@code obj} is {@code null}
     * @throws IllegalStateException    if this method is called on a closed {@link StatementBuilder}
     * @throws SQLException             if a database access error occurs
     */
    @Nonnull
    @Contract("_, _, _ -> this")
    StatementBuilder setObject(int parameterIndex, @Nonnull Object obj, @Nonnull ColumnType type) throws IllegalArgumentException, IllegalStateException, SQLException;

    /**
     * Clears all parameters that have been set so far.
     *
     * @return this {@link StatementBuilder} object
     * @throws IllegalStateException if this method is called on a closed {@link StatementBuilder}
     * @throws SQLException          if a database access error occurs
     */
    @Nonnull
    @Contract("-> this")
    StatementBuilder clearParameters() throws IllegalStateException, SQLException;

    /**
     * Executes the SQL query that has been built so far.
     * <p>
     * <b>Note:</b> This method should be used for queries that do not return a result set.
     *
     * @throws IllegalStateException if this method is called on a closed {@link StatementBuilder}
     * @throws SQLException          if a database access error occurs
     */
    @Contract(pure = true)
    void executeUpdate() throws IllegalStateException, SQLException;

    /**
     * Executes the SQL query that has been built so far asynchronously.
     * <p>
     * <b>Note:</b> This method should be used for queries that do not return a result set.
     *
     * @return a {@link CompletableFuture} that will be completed once the query has been executed
     * @throws IllegalStateException if this method is called on a closed {@link StatementBuilder}
     */
    @Nonnull
    @Contract(pure = true)
    CompletableFuture<Void> executeUpdateAsync() throws IllegalStateException;

    /**
     * Executes the SQL query that has been built so far and retrieves the generated key.
     * <p>
     * <b>Note:</b> This method should be used for queries that do not return a result set.
     *
     * @return the generated key
     * @throws IllegalStateException if this method is called on a closed {@link StatementBuilder}
     * @throws SQLException          if a database access error occurs
     */
    @Contract(pure = true)
    int executeUpdateAndRetrieveKey() throws IllegalStateException, SQLException;

    /**
     * Executes the SQL query that has been built so far and retrieves the generated key asynchronously.
     * <p>
     * <b>Note:</b> This method should be used for queries that do not return a result set.
     *
     * @return a {@link CompletableFuture} that will be completed once the query has been executed and the key has been retrieved
     * @throws IllegalStateException if this method is called on a closed {@link StatementBuilder}
     */
    @Nonnull
    @Contract(pure = true)
    CompletableFuture<Integer> executeUpdateAndRetrieveKeyAsync() throws IllegalStateException;

    /**
     * Executes the SQL query that has been built so far and returns the result set.
     * <p>
     * <b>Note:</b> This method should be used for queries that return a result set.
     *
     * @return the result set
     * @throws IllegalStateException if this method is called on a closed {@link StatementBuilder}
     * @throws SQLException          if a database access error occurs or the query does not return a result set
     */
    @Nonnull
    @Contract(pure = true)
    ResultSet executeQuery() throws IllegalStateException, SQLException;

    /**
     * Executes the SQL query that has been built so far and returns the result set asynchronously.
     * <p>
     * <b>Note:</b> This method should be used for queries that return a result set.
     *
     * @return a {@link CompletableFuture} that will be completed once the query has been executed and the result set has been retrieved
     * @throws IllegalStateException if this method is called on a closed {@link StatementBuilder}
     */
    @Nonnull
    @Contract(pure = true)
    CompletableFuture<ResultSet> executeQueryAsync() throws IllegalStateException;

    /**
     * Returns a copy of the underlying {@link PreparedStatement} object.
     * <p>
     * <b>Note:</b>
     * <ul>
     *     <li>This method should be used for methods that are not covered by this interface.</li>
     *     <li>Modifying the {@link PreparedStatement} does not have any influence on the {@link StatementBuilder}</li>
     * </ul>
     *
     * @return a copy of the underlying {@link PreparedStatement} object
     * @throws IllegalStateException if this method is called on a closed {@link StatementBuilder}
     */
    @Nonnull
    @Contract(pure = true)
    PreparedStatement unwrap() throws IllegalStateException;
}