package com.maxmind.minfraud.response;

import com.fasterxml.jackson.jr.ob.JSON;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EmailTest extends AbstractOutputTest {

    @Test
    public void testEmail() throws Exception {
        Email email = this.deserialize(
                Email.class,
                JSON.std
                        .composeString()
                        .startObject()
                        .put("is_free", false)
                        .put("is_high_risk", true)
                        .end()
                        .finish()
        );

        assertFalse(email.isFree());
        assertTrue(email.isHighRisk());
    }
}
