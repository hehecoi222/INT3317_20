package org.example;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * DummyTel Class contains DummyTel function which calculates the total cost of telephone communication
 */
public class DummyTelClass {
    /**
     * DummyTel function to calculates the total cost of telephone communication.
     *
     * @param timeStart Time start calling, in the format of 24-hour HH:MM.
     *                  If any input is not match the format, the function will throw {@link org.example.DummyTelClass.InvalidFormattedInput}.
     *                  If input contains sequences that cannot be parsed to number, the function will throw {@link NumberFormatException}.
     *                  If missing, the function will throw {@link NullPointerException} since the function cannot parse the time.
     * @param duration  Duration of the telecommunication activity, in the format of hour:minute, with hour > 0 &  0 < minute < 59.
     *                  If any input is not match the format, the function will throw {@link org.example.DummyTelClass.InvalidFormattedInput}.
     *                  If input contains sequences that cannot be parsed to number, the function will throw {@link NumberFormatException}.
     *                  If missing, the function will throw {@link NullPointerException} since the function cannot parse the duration.
     * @return totalCost in String represent, round up to 2 decimal in {@code HALF_UP} Rounding mode
     * @throws Exception {@link NullPointerException} when missing inputs, {@link NumberFormatException} when cannot parse to number, {@link InvalidFormattedInput} when wrongly formatted inputs are passed in.
     *                  If any exception not represent in catch, the general Exception is thrown with system message.
     */
    public static String DummyTel(String timeStart, String duration) throws Exception {
        Pair<Integer, Integer> timeStartFormatted;
        try {
            String[] splitTimeStart = timeStart.split(":");
            timeStartFormatted = new Pair<>(Integer.parseInt(splitTimeStart[0]), Integer.parseInt(splitTimeStart[1]));
            if (timeStartFormatted.first < 0 || timeStartFormatted.first > 23 || timeStartFormatted.second < 0 || timeStartFormatted.second > 59) {
                throw new InvalidFormattedInput("Your timeStart input is not 24-hour format");
            }
        } catch (NullPointerException nullPointerException) {
            throw new Exception("Your timeStart input is missing?", nullPointerException);
        } catch (NumberFormatException | InvalidFormattedInput | IndexOutOfBoundsException inputException) {
            throw new Exception("Your timeStart input is wrongly formatted", inputException);
        } catch (Exception e) {
            throw new Exception("Unknown exception", e);
        }

        Pair<BigInteger, Integer> durationFormatted;
        try {
            String[] splitDuration = duration.split(":");
            durationFormatted = new Pair<>(new BigInteger(splitDuration[0]), Integer.parseInt(splitDuration[1]));
            if (durationFormatted.first.compareTo(BigInteger.valueOf(0)) < 0 || durationFormatted.second < 0 || durationFormatted.second > 59) {
                throw new InvalidFormattedInput("Your duration input is not hour-minute format");
            }
        } catch (NullPointerException nullPointerException) {
            throw new Exception("Your duration input is missing?", nullPointerException);
        } catch (NumberFormatException | InvalidFormattedInput | IndexOutOfBoundsException inputException) {
            throw new Exception("Your duration input is wrongly formatted", inputException);
        } catch (Exception e) {
            throw new Exception("Unknown exception", e);
        }

        BigDecimal discountTimeStart = (timeStartFormatted.first >= 18 || timeStartFormatted.first < 8) ? new BigDecimal("0.5") : new BigDecimal(1);
        BigDecimal discountDuration = (durationFormatted.first.compareTo(BigInteger.valueOf(1)) < 0) ? new BigDecimal(1) : new BigDecimal("0.85");

        BigDecimal result = new BigDecimal(durationFormatted.first.multiply(BigInteger.valueOf(60)).add(BigInteger.valueOf(durationFormatted.second))).multiply(new BigDecimal("0.5"));
        result = result.multiply(discountTimeStart).multiply(discountDuration).multiply(new BigDecimal("1.05"));
        return result.setScale(2, RoundingMode.HALF_UP).toString();
    }

    /**
     * Pair class for saving values in pair.
     * @param <T> Type of first value.
     * @param <K> Type of second value.
     */
    public static class Pair<T, K> {
        T first;
        K second;

        public Pair(T first, K second) {
            this.first = first;
            this.second = second;
        }
    }

    public static class InvalidFormattedInput extends RuntimeException {
        /**
         * Constructs a new runtime exception with {@code null} as its
         * detail message.  The cause is not initialized, and may subsequently be
         * initialized by a call to {@link #initCause}.
         */
        public InvalidFormattedInput() {
        }

        /**
         * Constructs a new runtime exception with the specified detail message.
         * The cause is not initialized, and may subsequently be initialized by a
         * call to {@link #initCause}.
         *
         * @param message the detail message. The detail message is saved for
         *                later retrieval by the {@link #getMessage()} method.
         */
        public InvalidFormattedInput(String message) {
            super(message);
        }

        /**
         * Constructs a new runtime exception with the specified detail message and
         * cause.  <p>Note that the detail message associated with
         * {@code cause} is <i>not</i> automatically incorporated in
         * this runtime exception's detail message.
         *
         * @param message the detail message (which is saved for later retrieval
         *                by the {@link #getMessage()} method).
         * @param cause   the cause (which is saved for later retrieval by the
         *                {@link #getCause()} method).  (A {@code null} value is
         *                permitted, and indicates that the cause is nonexistent or
         *                unknown.)
         * @since 1.4
         */
        public InvalidFormattedInput(String message, Throwable cause) {
            super(message, cause);
        }

        /**
         * Constructs a new runtime exception with the specified cause and a
         * detail message of {@code (cause==null ? null : cause.toString())}
         * (which typically contains the class and detail message of
         * {@code cause}).  This constructor is useful for runtime exceptions
         * that are little more than wrappers for other throwables.
         *
         * @param cause the cause (which is saved for later retrieval by the
         *              {@link #getCause()} method).  (A {@code null} value is
         *              permitted, and indicates that the cause is nonexistent or
         *              unknown.)
         * @since 1.4
         */
        public InvalidFormattedInput(Throwable cause) {
            super(cause);
        }

        /**
         * Constructs a new runtime exception with the specified detail
         * message, cause, suppression enabled or disabled, and writable
         * stack trace enabled or disabled.
         *
         * @param message            the detail message.
         * @param cause              the cause.  (A {@code null} value is permitted,
         *                           and indicates that the cause is nonexistent or unknown.)
         * @param enableSuppression  whether or not suppression is enabled
         *                           or disabled
         * @param writableStackTrace whether or not the stack trace should
         *                           be writable
         * @since 1.7
         */
        public InvalidFormattedInput(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }
}
