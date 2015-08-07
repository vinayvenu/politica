package org.freedom.politica.repository;

import org.geotools.data.DataStore;
import org.geotools.data.DataStoreFinder;
import org.geotools.data.FeatureSource;
import org.geotools.feature.FeatureIterator;
import org.geotools.feature.simple.SimpleFeatureImpl;
import org.geotools.filter.text.cql2.CQL;
import org.opengis.feature.Feature;
import org.opengis.filter.Filter;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Service
public class AllConstituencies {

    private final FeatureSource featureSource;

    public AllConstituencies() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("india_pc_2014.shp").getFile());

        try {
            Map connect = new HashMap();
            connect.put("url", file.toURI().toURL());

            DataStore dataStore = DataStoreFinder.getDataStore(connect);
            String[] typeNames = dataStore.getTypeNames();
            String typeName = typeNames[0];

            featureSource = dataStore.getFeatureSource(typeName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Feature featureForLocation(double x, double y) {
        try {
            Filter filter = CQL.toFilter("CONTAINS(the_geom, POINT(" + x + " " + y + "))");

            FeatureIterator featureIterator = featureSource.getFeatures(filter).features();

            return featureIterator.hasNext()? featureIterator.next(): null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String constituencyForLocation(double x, double y) {
        Feature feature = featureForLocation(x, y);
        return feature != null? (String) ((SimpleFeatureImpl) feature).getAttribute("PC_NAME"): null;
    }
}
