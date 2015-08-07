package org.freedom.politica.repository;

import org.junit.Test;

import static org.junit.Assert.*;

public class AllConstituenciesTest {

    @Test
    public void shouldInitializeAllConstituencies() {
        AllConstituencies allConstituencies = new AllConstituencies();
    }

    @Test
    public void shouldRetrieveConstituencyForValidConstituency() {
        assertEquals(new AllConstituencies().constituencyForLocation(82.87, 18.33), "Araku");
    }

    @Test
    public void shouldReturnNullIfNoConstituencyPresent() {
        assertNull(new AllConstituencies().constituencyForLocation(170.87, 18.33));
    }
}