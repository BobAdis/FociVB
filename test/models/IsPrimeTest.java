package models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IsPrimeTest {

    @Test
    void test() {
        boolean result1 = IsPrime.isPrime(-2);
        assertEquals(false, result1);
        boolean result2 = IsPrime.isPrime(-1);
        assertEquals(false, result2);
        boolean result3 = IsPrime.isPrime(0);
        assertEquals(false, result3);
        boolean result4 = IsPrime.isPrime(1);
        assertEquals(false, result4);
        boolean result5 = IsPrime.isPrime(2);
        assertEquals(true, result5);
        boolean result6 = IsPrime.isPrime(3);
        assertEquals(true, result6);
        boolean result7 = IsPrime.isPrime(4);
        assertEquals(false, result7);
        boolean result8 = IsPrime.isPrime(5);
        assertEquals(true, result8);
        boolean result9 = IsPrime.isPrime(6);
        assertEquals(false, result9);
        boolean result10 = IsPrime.isPrime(7);
        assertEquals(true, result10);
        boolean result11 = IsPrime.isPrime(8);
        assertEquals(false, result11);
    }

}