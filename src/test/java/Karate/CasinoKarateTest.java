package Karate;

import com.intuit.karate.junit5.Karate;

public class CasinoKarateTest {

    @Karate.Test
    Karate testCasino() {
        return Karate.run("casino").relativeTo(getClass());
    }

}
