package org.freedom.politica;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.freedom.politica.repository.AllLegislators;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class AllLegislatorsTest{

    @Test
    public void shouldInitialize() throws JsonProcessingException {
        AllLegislators allLegislators = new AllLegislators();
    }

    @Test
    public void shouldRetrieveForAConstituency() {
        assertNotNull(new AllLegislators().findForConstituency("Maval"));
    }

    @Test
    public void shouldReturnNullIfConstituencyNotAvailable() {
        assertNull(new AllLegislators().findForConstituency("thatDoesNotExist"));
    }

}