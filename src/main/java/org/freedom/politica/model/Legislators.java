package org.freedom.politica.model;

import java.util.List;

public class Legislators extends BaseModel{

    private List<Legislator> legislators;

    public Legislators() {
    }

    public Legislators(List<Legislator> legislators) {
        this.legislators = legislators;
    }

    public Legislator belongingToConstituency(String constituency) {
        for (Legislator legislator : legislators) {
            if (legislator.belongsToConstituency(constituency)) {
                return legislator;
            }
        }
        return null;
    }
}
