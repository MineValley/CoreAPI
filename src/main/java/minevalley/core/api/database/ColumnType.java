package minevalley.core.api.database;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ColumnType {

    /**
     * <P>The constant in the Java programming language, sometimes referred
     * to as a type code, that identifies the generic SQL type
     * {@code BIT}.
     */
    BIT(-7),

    /**
     * <P>The constant in the Java programming language, sometimes referred
     * to as a type code, that identifies the generic SQL type
     * {@code TINYINT}.
     */
    TINYINT(-6),

    /**
     * <P>The constant in the Java programming language, sometimes referred
     * to as a type code, that identifies the generic SQL type
     * {@code SMALLINT}.
     */
    SMALLINT(5),

    /**
     * <P>The constant in the Java programming language, sometimes referred
     * to as a type code, that identifies the generic SQL type
     * {@code INTEGER}.
     */
    INTEGER(4),

    /**
     * <P>The constant in the Java programming language, sometimes referred
     * to as a type code, that identifies the generic SQL type
     * {@code BIGINT}.
     */
    BIGINT(-5),

    /**
     * <P>The constant in the Java programming language, sometimes referred
     * to as a type code, that identifies the generic SQL type
     * {@code FLOAT}.
     */
    FLOAT(6),

    /**
     * <P>The constant in the Java programming language, sometimes referred
     * to as a type code, that identifies the generic SQL type
     * {@code REAL}.
     */
    REAL(7),


    /**
     * <P>The constant in the Java programming language, sometimes referred
     * to as a type code, that identifies the generic SQL type
     * {@code DOUBLE}.
     */
    DOUBLE(8),

    /**
     * <P>The constant in the Java programming language, sometimes referred
     * to as a type code, that identifies the generic SQL type
     * {@code NUMERIC}.
     */
    NUMERIC(2),

    /**
     * <P>The constant in the Java programming language, sometimes referred
     * to as a type code, that identifies the generic SQL type
     * {@code DECIMAL}.
     */
    DECIMAL(3),

    /**
     * <P>The constant in the Java programming language, sometimes referred
     * to as a type code, that identifies the generic SQL type
     * {@code CHAR}.
     */
    CHAR(1),

    /**
     * <P>The constant in the Java programming language, sometimes referred
     * to as a type code, that identifies the generic SQL type
     * {@code VARCHAR}.
     */
    VARCHAR(12),

    /**
     * <P>The constant in the Java programming language, sometimes referred
     * to as a type code, that identifies the generic SQL type
     * {@code LONGVARCHAR}.
     */
    LONGVARCHAR(-1),


    /**
     * <P>The constant in the Java programming language, sometimes referred
     * to as a type code, that identifies the generic SQL type
     * {@code DATE}.
     */
    DATE(91),

    /**
     * <P>The constant in the Java programming language, sometimes referred
     * to as a type code, that identifies the generic SQL type
     * {@code TIME}.
     */
    TIME(92),

    /**
     * <P>The constant in the Java programming language, sometimes referred
     * to as a type code, that identifies the generic SQL type
     * {@code TIMESTAMP}.
     */
    TIMESTAMP(93),


    /**
     * <P>The constant in the Java programming language, sometimes referred
     * to as a type code, that identifies the generic SQL type
     * {@code BINARY}.
     */
    BINARY(-2),

    /**
     * <P>The constant in the Java programming language, sometimes referred
     * to as a type code, that identifies the generic SQL type
     * {@code VARBINARY}.
     */
    VARBINARY(-3),

    /**
     * <P>The constant in the Java programming language, sometimes referred
     * to as a type code, that identifies the generic SQL type
     * {@code LONGVARBINARY}.
     */
    LONGVARBINARY(-4),

    /**
     * <P>The constant in the Java programming language
     * that identifies the generic SQL value
     * {@code NULL}.
     */
    NULL(0),

    /**
     * The constant in the Java programming language that indicates
     * that the SQL type is database-specific and
     * gets mapped to a Java object that can be accessed via
     * the methods {@code getObject} and {@code setObject}.
     */
    OTHER(1111),

    /**
     * The constant in the Java programming language, sometimes referred to
     * as a type code, that identifies the generic SQL type
     * {@code DISTINCT}.
     *
     * @since 1.2
     */
    DISTINCT(2001),


    /**
     * The constant in the Java programming language, sometimes referred to
     * as a type code, that identifies the generic SQL type {@code BOOLEAN}.
     *
     * @since 1.4
     */
    BOOLEAN(16),

    /**
     * The constant in the Java programming language, sometimes referred to
     * as a type code, that identifies the generic SQL type {@code REF CURSOR}.
     *
     * @since 1.8
     */
    REF_CURSOR(2012),

    /**
     * The constant in the Java programming language, sometimes referred to
     * as a type code, that identifies the generic SQL type
     * {@code TIME WITH TIMEZONE}.
     *
     * @since 1.8
     */
    TIME_WITH_TIMEZONE(2013),

    /**
     * The constant in the Java programming language, sometimes referred to
     * as a type code, that identifies the generic SQL type
     * {@code TIMESTAMP WITH TIMEZONE}.
     *
     * @since 1.8
     */
    TIMESTAMP_WITH_TIMEZONE(2014);

    private final int type;
}
