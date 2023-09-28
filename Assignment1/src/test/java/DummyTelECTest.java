import org.example.DummyTelClass;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test class using equivalence class partitioning
 * <p>
 * Description valid input class partitioning:
 * timeStart:
 * T1: Call in time window from 8h to 18h [8:18)
 * T2: Otherwise [0:8) u [18:24)
 * T3: Invalid lower (-INF:0)
 * T4: Invalid higher [24:INF)
 * duration:
 * D1: duration above 60 minutes [60:INF)
 * D2: Vice versa [0:60)
 * D3: Invalid lower (-INF:0)
 * <p>
 * Output partitioning
 * From 8-18 and longer than 60
 * From 8-18 and less than 60
 * Out 8-18 and longer than 60
 * Out 8-18 and less than 60
 * Invalid timeStart
 * Invalid duration
 */
public class DummyTelECTest {
    /**
     * T1 - D1 combination
     * Expected output: From 8-18 and longer than 60
     * => 50% discount
     * <p>
     * Input: 13:00, 1:00 (60min)
     * Expected output: 26.78
     */
    @Test
    public void testDummyTelvEC1WithT1D1() {
        try {
            Assert.assertEquals("vEC1: T1-D1", "26.78", DummyTelClass.DummyTel("13:00", "1:00"));
        } catch (Exception e) {
            Assert.fail("Fail caused by: " + e.getCause());
        }
    }

    /**
     * T1 - D2 combination
     * Expected output: From 8-18 and less than 60
     * => No discount
     * <p>
     * Input: 13:00, 0:30 (30min)
     * Expected output: 15.75
     */
    @Test
    public void testDummyTelvEC2WithT1D2() {
        try {
            Assert.assertEquals("vEC2: T1-D2", "15.75", DummyTelClass.DummyTel("13:00", "0:30"));
        } catch (Exception e) {
            Assert.fail("Fail caused by: " + e.getCause());
        }
    }

    /**
     * T2 - D1 combination
     * Expected output: Out 8-18 and longer than 60
     * => Discount 50% then 15%
     * <p>
     * Input: 00:00, 0:60 (60min)
     * Expected output: 13.39
     */
    @Test
    public void testDummyTelvEC3WithT2D1() {
        try {
            Assert.assertEquals("vEC3: T2-D1", "13.39", DummyTelClass.DummyTel("00:00", "1:00"));
        } catch (Exception e) {
            Assert.fail("Fail caused by: " + e.getCause());
        }
    }

    /**
     * T2 - D2 combination
     * Expected output: Out 8-18 and less than 60
     * => Discount 50%
     * <p>
     * Input: 00:00, 0:30 (30min)
     * Expected output: 7.88
     */
    @Test
    public void testDummyTelvEC4WithT2D2() {
        try {
            Assert.assertEquals("vEC4: T2-D2", "7.88", DummyTelClass.DummyTel("00:00", "0:30"));
        } catch (Exception e) {
            Assert.fail("Fail caused by: " + e.getCause());
        }
    }

    /**
     * T3 - D1 combination
     * Expected output: Invalid timeStart
     * <p>
     * Input: -00:01, 1:00 (60min)
     * Expected output: timeStart wrongly formatted
     */
    @Test
    public void testDummyTeliEC1WithT3D1() {
        Exception exception = Assert.assertThrows("iEC1: T3-D1", Exception.class, () -> DummyTelClass.DummyTel("-00:01", "01:00"));

        Assert.assertTrue(exception.getMessage().contains("timeStart input is wrongly formatted"));
    }

    /**
     * T4 - D1 combination
     * Expected output: Invalid timeStart
     * <p>
     * Input: 24:00, 1:00 (60min)
     * Expected output: timeStart wrongly formatted
     */
    @Test
    public void testDummyTeliEC2WithT4D1() {
        Exception exception = Assert.assertThrows("iEC2: T4-D1", Exception.class, () -> DummyTelClass.DummyTel("24:00", "01:00"));

        Assert.assertTrue(exception.getMessage().contains("timeStart input is wrongly formatted"));
    }

    /**
     * T1 - D3 combination
     * Expected output: Invalid duration
     * <p>
     * Input: 13:00, -0:01 (60min)
     * Expected output: duration wrongly formatted
     */
    @Test
    public void testDummyTeliEC3WithT1D3() {
        Exception exception = Assert.assertThrows("iEC3: T1-D3", Exception.class, () -> DummyTelClass.DummyTel("13:00", "-0:01"));

        Assert.assertTrue(exception.getMessage().contains("duration input is wrongly formatted"));
    }
}
