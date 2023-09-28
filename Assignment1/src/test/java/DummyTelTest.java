import org.example.DummyTelClass;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test class for DummyTel.
 */
public class DummyTelTest {
    /**
     * First small 0.5+tax (1 minute) call test.
     * <p>
     * Input: 15:00, 00:01.
     * Expected output: 0.53.
     */
    @Test
    public void testDummyTel1() {
        try {
            Assert.assertEquals("First small 0.5+tax (1 minute) full price call test", "0.53", DummyTelClass.DummyTel("15:00", "00:01"));
        } catch (Exception e) {
            Assert.fail("Fail cause by: " + e.getCause());
        }
    }

    /**
     * 1 hour full price call test.
     * <p>
     * Input: 15:00, 1:00
     * Expected Output: 26.78
     */
    @Test
    public void testDummyTel2() {
        try {
            Assert.assertEquals("1 hour full price call test", "26.78", DummyTelClass.DummyTel("15:00", "01:00"));
        } catch (Exception e) {
            Assert.fail("Fail caused by: " + e.getCause());
        }
    }

    /**
     * Test timeStart null.
     * <p>
     * Input: null, 00:01.
     * Expected Output: NullPointerException with message timeStart missing.
     */
    @Test
    public void testDummyTelTimeStartNull() {
        Exception exception = Assert.assertThrows("Check if it throws Exception", Exception.class, () -> DummyTelClass.DummyTel(null, "00:01"));

        Assert.assertThrows("Check which caused Exception", NullPointerException.class, () -> {
            throw exception.getCause();
        });
        Assert.assertTrue(exception.getMessage().contains("timeStart input is missing"));
    }

    /**
     * Tests timeStart wrongly formatted.
     */
    @Test
    public void testDummyTelTimeStartWrongFormat() {
        Exception exception = Assert.assertThrows("Check if it throws Exception", Exception.class, () -> DummyTelClass.DummyTel("", "00:01"));

        Assert.assertTrue(exception.getMessage().contains("timeStart input is wrongly formatted"));
    }

    /**
     * Test timeStart wrongly formatted.
     * <p>
     * Input: 0909, 00:01.
     * Expected Output: Exception with message timeStart wrongly formatted.
     */
    @Test
    public void testDummyTelTimeStartWrongFormat2() {
        Exception exception = Assert.assertThrows("Check if it throws Exception", Exception.class, () -> DummyTelClass.DummyTel("0909", "00:01"));

        Assert.assertTrue(exception.getMessage().contains("timeStart input is wrongly formatted"));
    }

    /**
     * Test timeStart wrongly formatted.
     * <p>
     * Input: 09a:9, 00:01.
     * Expected Output: Exception with message timeStart wrongly formatted.
     */
    @Test
    public void testDummyTelTimeStartWrongFormat3() {
        Exception exception = Assert.assertThrows("Check if it throws Exception", Exception.class, () -> DummyTelClass.DummyTel("09a:9", "00:01"));

        Assert.assertTrue(exception.getMessage().contains("timeStart input is wrongly formatted"));
    }

    /**
     * Test timeStart wrongly formatted.
     * <p>
     * Input: 90:59, 00:01.
     * Expected Output: Exception with message timeStart wrongly formatted.
     */
    @Test
    public void testDummyTelTimeStartWrongFormat4() {
        Exception exception = Assert.assertThrows("Check if it throws Exception", Exception.class, () -> DummyTelClass.DummyTel("90:59", "00:01"));

        Assert.assertTrue(exception.getMessage().contains("timeStart input is wrongly formatted"));
    }

    /**
     * Test timeStart wrongly formatted.
     * <p>
     * Input: 23:90, 00:01.
     * Expected Output: Exception with message timeStart wrongly formatted.
     */
    @Test
    public void testDummyTelTimeStartWrongFormat5() {
        Exception exception = Assert.assertThrows("Check if it throws Exception", Exception.class, () -> DummyTelClass.DummyTel("23:90", "00:01"));

        Assert.assertTrue(exception.getMessage().contains("timeStart input is wrongly formatted"));
    }

    /**
     * Test timeStart wrongly formatted.
     * <p>
     * Input: -1:20, 00:01.
     * Expected Output: Exception with message timeStart wrongly formatted.
     */
    @Test
    public void testDummyTelTimeStartWrongFormat6() {
        Exception exception = Assert.assertThrows("Check if it throws Exception", Exception.class, () -> DummyTelClass.DummyTel("-1:20", "00:01"));

        Assert.assertTrue(exception.getMessage().contains("timeStart input is wrongly formatted"));
    }

    /**
     * Test timeStart wrongly formatted.
     * <p>
     * Input: 20:-1, 00:01.
     * Expected Output: Exception with message timeStart wrongly formatted.
     */
    @Test
    public void testDummyTelTimeStartWrongFormat7() {
        Exception exception = Assert.assertThrows("Check if it throws Exception", Exception.class, () -> DummyTelClass.DummyTel("20:-1", "00:01"));

        Assert.assertTrue(exception.getMessage().contains("timeStart input is wrongly formatted"));
    }

    /**
     * Test duration null.
     * <p>
     * Input: 6:50, null.
     * Expected Output: NullPointerException with message duration missing.
     */
    @Test
    public void testDummyTelDurationNull() {
        Exception exception = Assert.assertThrows("Check if it throws Exception", Exception.class, () -> DummyTelClass.DummyTel("6:50", null));

        Assert.assertThrows("Check which caused Exception", NullPointerException.class, () -> {
            throw exception.getCause();
        });
        Assert.assertTrue(exception.getMessage().contains("duration input is missing"));
    }

    /**
     * Test duration wrongly formatted.
     * <p>
     * Input: 10:37, "".
     * Expected Output: Exception with message duration wrongly formatted.
     */
    @Test
    public void testDummyTelDurationWrongFormat1() {
        Exception exception = Assert.assertThrows("Check if it throws Exception", Exception.class, () -> DummyTelClass.DummyTel("10:37", ""));

        Assert.assertTrue(exception.getMessage().contains("duration input is wrongly formatted"));
    }

    /**
     * Test duration wrongly formatted.
     * <p>
     * Input: 9:01, 0909.
     * Expected Output: Exception with message duration wrongly formatted.
     */
    @Test
    public void testDummyTelDurationWrongFormat2() {
        Exception exception = Assert.assertThrows("Check if it throws Exception", Exception.class, () -> DummyTelClass.DummyTel("9:01", "0909"));

        Assert.assertTrue(exception.getMessage().contains("duration input is wrongly formatted"));
    }

    /**
     * Test duration wrongly formatted.
     * <p>
     * Input: 10:37, 9a:9.
     * Expected Output: Exception with message duration wrongly formatted.
     */
    @Test
    public void testDummyTelDurationWrongFormat3() {
        Exception exception = Assert.assertThrows("Check if it throws Exception", Exception.class, () -> DummyTelClass.DummyTel("10:37", "9a:9"));

        Assert.assertTrue(exception.getMessage().contains("duration input is wrongly formatted"));
    }

    /**
     * Test duration wrongly formatted.
     * <p>
     * Input: 1:50, 11:69.
     * Expected Output: Exception with message duration wrongly formatted.
     */
    @Test
    public void testDummyTelDurationWrongFormat4() {
        Exception exception = Assert.assertThrows("Check if it throws Exception", Exception.class, () -> DummyTelClass.DummyTel("1:50", "11:69"));

        Assert.assertTrue(exception.getMessage().contains("duration input is wrongly formatted"));
    }

    /**
     * Test duration wrongly formatted.
     * <p>
     * Input: 1:50, -1:59.
     * Expected Output: Exception with message duration wrongly formatted.
     */
    @Test
    public void testDummyTelDurationWrongFormat5() {
        Exception exception = Assert.assertThrows("Check if it throws Exception", Exception.class, () -> DummyTelClass.DummyTel("1:50", "-1:59"));

        Assert.assertTrue(exception.getMessage().contains("duration input is wrongly formatted"));
    }

    /**
     * Test duration wrongly formatted.
     * <p>
     * Input: 1:50, 59:-1.
     * Expected Output: Exception with message duration wrongly formatted.
     */
    @Test
    public void testDummyTelDurationWrongFormat6() {
        Exception exception = Assert.assertThrows("Check if it throws Exception", Exception.class, () -> DummyTelClass.DummyTel("1:50", "59:-1"));

        Assert.assertTrue(exception.getMessage().contains("duration input is wrongly formatted"));
    }

    /**
     * Test timeStart from 18h and later
     * <p>
     * Input: 19:00, 00:05.
     * Expected output: 1.31
     */
    @Test
    public void testDummyTelTimeStartOver18() {
        try {
            Assert.assertEquals("From 19h - 5 minutes", "1.31", DummyTelClass.DummyTel("19:00", "00:05"));
        } catch (Exception e) {
            Assert.fail("Fail cause by: " + e.getCause());
        }
    }

    /**
     * Test timeStart sooner than 8h
     * <p>
     * Input: 7:00, 00:05.
     * Expected output: 1.31
     */
    @Test
    public void testDummyTelTimeStartUnder8() {
        try {
            Assert.assertEquals("From 7h - 5 minutes", "1.31", DummyTelClass.DummyTel("7:00", "00:05"));
        } catch (Exception e) {
            Assert.fail("Fail cause by: " + e.getCause());
        }
    }

    /**
     * Test duration over 60 minutes (normal fee hour)
     * <p>
     * Input: 15:00, 01:05 (65m).
     * Expected output: 29.01.
     */
    @Test
    public void testDummyTelDurationOver60() {
        try {
            Assert.assertEquals("From 15h - 65 minutes (1hr 5m)", "29.01", DummyTelClass.DummyTel("15:00", "01:05"));
        } catch (Exception e) {
            Assert.fail("Fail cause by: " + e.getCause());
        }
    }

    /**
     * Test duration over 60 minutes (discount fee hour)
     * <p>
     * Input: 19:00, 01:05 (65m).
     * Expected output: 14.50.
     */
    @Test
    public void testDummyTelTimeStartOver18DurationOver60() {
        try {
            Assert.assertEquals("From 19h - 65 minutes (1hr 5m)", "14.50", DummyTelClass.DummyTel("19:00", "01:05"));
        } catch (Exception e) {
            Assert.fail("Fail cause by: " + e.getCause());
        }
    }

    /**
     * Test duration to Java Max Int
     * <p>
     * Input: 15:00, JavaMaxInt.
     * Expected output: Not null.
     * Another expect: Cost < time called (since 0.5 per minute + extra discount 15%)
     */
    @Test
    public void testDummyTelDurationLarge() {
        try {
            String test = DummyTelClass.DummyTel("19:00", "%d:59".formatted(Integer.MAX_VALUE));
            System.out.println(test);
            Assert.assertNotNull("From 19h - Max.Int minutes", test);
            Assert.assertTrue(test.length() > "%d".formatted(Integer.MAX_VALUE).length());
        } catch (Exception e) {
            Assert.fail("Fail cause by: " + e.getCause());
        }
    }
}
