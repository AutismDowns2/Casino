package Karate;

import com.intuit.karate.junit5.Karate;

public class KarateTest {
    
    @Karate.Test
    Karate testUsers() {
        return Karate.run("user").relativeTo(getClass());
    }
}
