package com.booking.service;

import com.booking.entities.Route;

public interface RouteService {
    Route createRoute(Route route);
    void deleteRoute(Long id);
    Route modifyRoute(Long id, Route modifiedRoute);

}
