package com.example.api;

import com.example.BaseTest;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseApiTest extends BaseTest {

    @BeforeAll
    public static void init() {
        new ApiTestConfiguration().configure();
    }
}
