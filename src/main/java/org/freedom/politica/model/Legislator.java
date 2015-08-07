package org.freedom.politica.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Legislator extends BaseModel{
    private String first_name;
    private String last_name;
    private String state;
    private String constituency;
    private Integer attendance_percentage;
    private String party;
    private String email_address;
    private String phone_number;

    public Legislator() {
    }

    public Legislator(String first_name, String last_name, String state, String constituency, Integer attendance_percentage, String party, String email_address, String phone_number) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.state = state;
        this.constituency = constituency;
        this.attendance_percentage = attendance_percentage;
        this.party = party;
        this.email_address = email_address;
        this.phone_number = phone_number;
    }

    public boolean belongsToConstituency(String cs) {
        if (constituency == null) {
            System.out.println("Nulls exist");
            return false;
        }
        String trimmedConstituency = cs.trim();
        return trimmedConstituency.equalsIgnoreCase(this.constituency);
    }
}
