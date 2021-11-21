package minevalley.core.api.utils;

public interface Countdown {

    /**
     * Defines the length of the whole countdown
     *
     * @param length the length of the countdown as long
     * @return this countdown
     */
    Countdown setLength(long length);

    /**
     * Defines the length of every period
     *
     * @param period length of periods as long
     * @return this countdown
     */
    Countdown setPeriod(long period);

    /**
     * Defindes the callback at the given time
     *
     * @param time     time, at which the callback gets called
     * @param callback the callback to perform at the given time
     * @return this countdown
     */
    Countdown on(long time, Runnable callback);

    /**
     * Defines the callback which gets called at the end
     *
     * @param callback the callback to perform at the end
     * @return this countdown
     */
    Countdown onEnd(Runnable callback);

    /**
     * Defines the callback which gets called every period
     *
     * @param callback the callback to perform every period
     * @return this countdown
     */
    Countdown onPeriod(Runnable callback);

    /**
     * Defines the callback which gets called every tick
     *
     * @param callback the callback to perform every tick
     * @return this countdown
     */
    Countdown onTick(Runnable callback);

    /**
     * Starts this countdown
     *
     * @return this countdown
     */
    Countdown start();

    /**
     * Stops this countdown
     *
     * @return this countdown
     */
    Countdown stop();

    /**
     * Gets the duration left
     *
     * @return duration left as long
     */
    long getLeft();

    /**
     * Gets the period of the countdown
     *
     * @return period of the countdown as long
     */
    long getPeriod();

    /**
     * Gets the length of the countdown
     *
     * @return length of the countdown as long
     */
    long getLength();

    /**
     * Gets the current position of the countdown
     *
     * @return current duration as long
     */
    long getNow();

    /**
     * Defines the duration left
     *
     * @param left duration as long
     */
    void setLeft(long left);

    /**
     * Gets whether the countdown is started yet
     *
     * @return true if the countdown is started
     */
    boolean isStarted();
}