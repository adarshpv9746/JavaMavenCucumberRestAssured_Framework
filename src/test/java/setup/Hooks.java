package setup;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class Hooks {
    @BeforeAll
    public static void beforeAll() {
        System.out.println("Inside BeforeAll hook");
    }

    @Before
    public void setup() {
        System.out.println("Inside Before hook");
    }

    @After
    public void teardown() {
        System.out.println("Inside After hook");
    }
    @AfterAll
    public static void afterAll() {
        System.out.println("Inside AfterAll hook");
    }
}

