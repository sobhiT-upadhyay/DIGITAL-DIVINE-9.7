package com.booking.service.impl;

import com.booking.entities.Route;
import com.booking.repository.RouteRepository;
import com.booking.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Optional;

@Service
public class RouteServiceImpl implements RouteService {
    @Autowired
    private RouteRepository routeRepository;
    @Override
    public Route createRoute(Route route) {
        route.setCreatedAt(new Date());
        route.setUpdatedAt(new Date());
        return routeRepository.save(route);
    }
    @Override
    public void deleteRoute(Long id) {
        routeRepository.deleteById(id);
    }

    @Override
    public Route modifyRoute(Long id, Route modifiedRoute) {
        Optional<Route> optionalRoute = routeRepository.findById(id);
        if (optionalRoute.isPresent()) {
            Route route = optionalRoute.get();
            route.setOrigin(modifiedRoute.getOrigin());
            route.setDestination(modifiedRoute.getDestination());
            route.setDistance(modifiedRoute.getDistance());
            route.setUpdatedAt(new Date());
            return routeRepository.save(route);
        }
        return null; // or throw an exception if required
    }
}

