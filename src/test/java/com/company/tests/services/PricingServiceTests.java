package com.company.tests.services;

import com.company.app.services.PricingService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PricingServiceTests {
    PricingService service;

    //create new service before each test
    @Before
    public void init() {
        service = new PricingService();
    }

    //just once
    @Test
    public void serviceShouldNotBeNull() {
        Assert.assertNotNull("Service instance not created", service);
    }

    @Test

    public void shouldReturn0For0Item() {
        float cost = service.compute(0, 10.00f, "FL", new String[]{});
        //delta: margin of error
        Assert.assertEquals("Cost not calculated", 0.0f, cost, 0.0f);
    }

}
