package org.freedom.politica.model;

public class Leaders extends BaseModel{
    private Legislator memberOfParliament;
    private Legislator memberOfLegislativeAssembly;
    private Legislator memberOfLegislativeCouncil;

    public Leaders() {
    }

    public Leaders(Legislator memberOfParliament, Legislator memberOfLegislativeAssembly, Legislator memberOfLegislativeCouncil) {
        this.memberOfParliament = memberOfParliament;
        this.memberOfLegislativeAssembly = memberOfLegislativeAssembly;
        this.memberOfLegislativeCouncil = memberOfLegislativeCouncil;
    }

    public Legislator getMemberOfParliament() {
        return memberOfParliament;
    }

    public Legislator getMemberOfLegislativeAssembly() {
        return memberOfLegislativeAssembly;
    }

    public Legislator getMemberOfLegislativeCouncil() {
        return memberOfLegislativeCouncil;
    }
}
