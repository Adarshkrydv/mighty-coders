package com.EventManagement.dao;

import java.util.List;

public interface VenueDao {

    // Save or update a venue
    VenueDao save(VenueDao venue);

    // Find a venue by ID
    VenueDao findById(Long venueId);

    // Find venues by name
    List<VenueDao> findByName(String name);

    // Find venues by location (address)
    List<VenueDao> findByAddress(String address);

    // Find venues with a minimum capacity
    List<VenueDao> findByCapacity(int capacity);

    // Find venues offering a specific facility
    List<VenueDao> findByFacility(String facility);

    // Delete a venue
    void delete(Long venueId);
}
