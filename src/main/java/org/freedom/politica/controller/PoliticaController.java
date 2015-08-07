package org.freedom.politica.controller;

import org.freedom.politica.model.Leaders;
import org.freedom.politica.model.Legislator;
import org.freedom.politica.repository.AllConstituencies;
import org.freedom.politica.repository.AllLegislators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PoliticaController {

    @Autowired
    private AllConstituencies allConstituencies;

    @Autowired
    private AllLegislators allLegislators;

    @RequestMapping("/leaders")
    public Leaders findLeadersByLocation(@RequestParam(value = "x") Double x, @RequestParam(value = "y") Double y) {
        Legislator memberOfParliament = allLegislators.findForConstituency(allConstituencies.constituencyForLocation(x, y));
        return new Leaders(memberOfParliament, null, null);
    }
}
