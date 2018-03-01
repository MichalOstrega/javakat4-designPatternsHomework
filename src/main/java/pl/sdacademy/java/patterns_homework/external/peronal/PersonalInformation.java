package pl.sdacademy.java.patterns_homework.external.peronal;

public class PersonalInformation {
    private String personIdentificationNumber;
    private String city;
    private String street;
    private Long houseNumber;
    private Long apartmentNumber;

    public String getPersonIdentificationNumber() {
        return personIdentificationNumber;
    }

    public void setPersonIdentificationNumber(String personIdentificationNumber) {
        this.personIdentificationNumber = personIdentificationNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Long getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Long houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Long getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(Long apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }
}
