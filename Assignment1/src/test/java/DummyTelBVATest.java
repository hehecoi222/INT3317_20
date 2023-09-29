import org.example.DummyTelClass;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test class using boundary value analysis
 * <p>
 * Description input:
 * timeStart hour valid:
 * TH1: [8:18)
 * TH2: [0:8)
 * TH3: [18:24)
 * => Select {8, 7, 18, 17, 0, -1, 23, 24} addition with center point of each {4, 13, 21}
 * timeStart minute valid:
 * TM1: [0,60)
 * => Select {0, -1, 59, 60} addition with center point {30}
 * duration time valid:
 * DH1: [0, 1)
 * DH2: [1:INF)
 * => Select {0, -1, 1} addition a representative {0}
 * duration minute valid:
 * DM1: [0,60)
 * => Select {0, -1, 59, 60} addition with center point {30}
 */
public class DummyTelBVATest {
    /**
     * TH1 bound left
     * <p>
     * Input: 8:30, 0:30
     * Expected output: 15.75
     */
    @Test
    public void testDummyTelBVTH1BoundL() {
        try {
            Assert.assertEquals("TH1BL", "15.75", DummyTelClass.DummyTel("8:30", "0:30"));
        } catch (Exception e) {
            Assert.fail("Fail caused by: " + e.getCause());
        }
    }

    /**
     * TH1 center
     * <p>
     * Input: 13:30, 0:30
     * Expected output: 15.75
     */
    @Test
    public void testDummyTelBVTH1Center() {
        try {
            Assert.assertEquals("TH1C", "15.75", DummyTelClass.DummyTel("13:30", "0:30"));
        } catch (Exception e) {
            Assert.fail("Fail caused by: " + e.getCause());
        }
    }

    /**
     * TH1 bound right
     * <p>
     * Input: 17:30, 0:30
     * Expected output: 15.75
     */
    @Test
    public void testDummyTelBVTH1BoundR() {
        try {
            Assert.assertEquals("TH1BR", "15.75", DummyTelClass.DummyTel("17:30", "0:30"));
        } catch (Exception e) {
            Assert.fail("Fail caused by: " + e.getCause());
        }
    }

    /**
     * TH2 bound left
     * <p>
     * Input: 0:30, 0:30
     * Expected output: 7.88
     */
    @Test
    public void testDummyTelBVTH2BoundL() {
        try {
            Assert.assertEquals("TH2BL", "7.88", DummyTelClass.DummyTel("0:30", "0:30"));
        } catch (Exception e) {
            Assert.fail("Fail caused by: " + e.getCause());
        }
    }

    /**
     * TH2 center
     * <p>
     * Input: 4:30, 0:30
     * Expected output: 7.88
     */
    @Test
    public void testDummyTelBVTH2Center() {
        try {
            Assert.assertEquals("TH2C", "7.88", DummyTelClass.DummyTel("4:30", "0:30"));
        } catch (Exception e) {
            Assert.fail("Fail caused by: " + e.getCause());
        }
    }

    /**
     * TH2 bound near left
     * <p>
     * Input: -1:30, 0:30
     * Expected output: Invalid timeStart format
     */
    @Test
    public void testDummyTelBVTH2BoundnL() {
        Exception exception = Assert.assertThrows("TH2BnL", Exception.class, () -> DummyTelClass.DummyTel("-1:30", "0:30"));

        Assert.assertTrue(exception.getMessage().contains("timeStart input is wrongly formatted"));
    }

    /**
     * TH2 bound right
     * <p>
     * Input: 7:30, 0:30
     * Expected output: 7.88
     */
    @Test
    public void testDummyTelBVTH2BoundR() {
        try {
            Assert.assertEquals("TH2BR", "7.88", DummyTelClass.DummyTel("7:30", "0:30"));
        } catch (Exception e) {
            Assert.fail("Fail caused by: " + e.getCause());
        }
    }

    /**
     * TH3 bound left
     * <p>
     * Input: 18:30, 0:30
     * Expected output: 7.88
     */
    @Test
    public void testDummyTelBVTH3BoundL() {
        try {
            Assert.assertEquals("TH3BL", "7.88", DummyTelClass.DummyTel("18:30", "0:30"));
        } catch (Exception e) {
            Assert.fail("Fail caused by: " + e.getCause());
        }
    }

    /**
     * TH3 center
     * <p>
     * Input: 21:30, 0:30
     * Expected output: 7.88
     */
    @Test
    public void testDummyTelBVTH3Center() {
        try {
            Assert.assertEquals("TH3C", "7.88", DummyTelClass.DummyTel("21:30", "0:30"));
        } catch (Exception e) {
            Assert.fail("Fail caused by: " + e.getCause());
        }
    }

    /**
     * TH3 bound right
     * <p>
     * Input: 23:30, 0:30
     * Expected output: 7.88
     */
    @Test
    public void testDummyTelBVTH3BoundR() {
        try {
            Assert.assertEquals("TH3BR", "7.88", DummyTelClass.DummyTel("23:30", "0:30"));
        } catch (Exception e) {
            Assert.fail("Fail caused by: " + e.getCause());
        }
    }

    /**
     * TH3 bound near right
     * <p>
     * Input: 24:30, 0:30
     * Expected output: Invalid timeStart format
     */
    @Test
    public void testDummyTelBVTH3BoundnR() {
        Exception exception = Assert.assertThrows("TH3BnR", Exception.class, () -> DummyTelClass.DummyTel("24:30", "0:30"));

        Assert.assertTrue(exception.getMessage().contains("timeStart input is wrongly formatted"));
    }

    /**
     * TM1 bound left
     * <p>
     * Input: 13:00, 0:30
     * Expected output: 15.75
     */
    @Test
    public void testDummyTelBVTM1BoundL() {
        try {
            Assert.assertEquals("TM1BL", "15.75", DummyTelClass.DummyTel("13:00", "0:30"));
        } catch (Exception e) {
            Assert.fail("Fail caused by: " + e.getCause());
        }
    }

    /**
     * TM1 bound near left
     * <p>
     * Input: 13:-01, 0:30
     * Expected output: Invalid timeStart format
     */
    @Test
    public void testDummyTelBVTM1BoundnL() {
        Exception exception = Assert.assertThrows("TM1BnL", Exception.class, () -> DummyTelClass.DummyTel("13:-01", "0:30"));

        Assert.assertTrue(exception.getMessage().contains("timeStart input is wrongly formatted"));
    }

    /**
     * TM1 bound right
     * <p>
     * Input: 13:59, 0:30
     * Expected output: 15.75
     */
    @Test
    public void testDummyTelBVTM1BoundR() {
        try {
            Assert.assertEquals("TM1BR", "15.75", DummyTelClass.DummyTel("13:59", "0:30"));
        } catch (Exception e) {
            Assert.fail("Fail caused by: " + e.getCause());
        }
    }

    /**
     * TM1 bound near right
     * <p>
     * Input: 13:60, 0:30
     * Expected output: Invalid timeStart format
     */
    @Test
    public void testDummyTelBVTM1BoundnR() {
        Exception exception = Assert.assertThrows("TM1BnR", Exception.class, () -> DummyTelClass.DummyTel("13:60", "0:30"));

        Assert.assertTrue(exception.getMessage().contains("timeStart input is wrongly formatted"));
    }
}
