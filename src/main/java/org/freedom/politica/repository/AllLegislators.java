package org.freedom.politica.repository;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.freedom.politica.model.Legislator;
import org.freedom.politica.model.Legislators;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class AllLegislators {

    private final Legislators legislators;

    public AllLegislators() {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("legislators.json").getFile());
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            legislators = objectMapper.readValue(file, Legislators.class);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public Legislator findForConstituency(String constituency) {
        return legislators.belongingToConstituency(constituency);
    }
}
