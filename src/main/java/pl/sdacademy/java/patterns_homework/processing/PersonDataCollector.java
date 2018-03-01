package pl.sdacademy.java.patterns_homework.processing;

import pl.sdacademy.java.patterns_homework.external.address.ContactService;
import pl.sdacademy.java.patterns_homework.external.address.ContactInformation;
import pl.sdacademy.java.patterns_homework.external.address.ContactInformationData;
import pl.sdacademy.java.patterns_homework.external.peronal.PersonalInformation;
import pl.sdacademy.java.patterns_homework.external.peronal.PersonalInformationService;
import pl.sdacademy.java.patterns_homework.external.peronal.PersonalInformationData;

import java.util.ArrayList;
import java.util.List;

public class PersonDataCollector {
    private PersonalInformationService personalInformationService;
    private ContactService contactService;
    private PersonRepository personRepository;
    private Configuration configuration;

    public PersonDataCollector(PersonalInformationService personalInformationService, ContactService contactService, PersonRepository personRepository) {
        this.personalInformationService = personalInformationService;
        this.contactService = contactService;
        this.personRepository = personRepository;
        configuration = new Configuration();
    }

    public void process() {
        PersonalInformationData personalData = personalInformationService.fetch(configuration.getUserForPersonalService(), configuration.getPasswordForPersonalService());
        List<PersonalInformation> validPersonalData = getValidPersonalData(personalData);
        ContactInformationData addressData = contactService.fetch(configuration.getUserForAddressService(), configuration.getPasswordForAddressService());
        List<ContactInformation> validContactData = getValidContactData(addressData);
        for (PersonalInformation personalInfo : validPersonalData) {
            ContactInformation matchingContactInfo = null;
            for (ContactInformation contactInfo : validContactData) {
                if (personalInfo.getPersonIdentificationNumber().equalsIgnoreCase(contactInfo.getPersonIdentificationNumber())) {
                    matchingContactInfo = contactInfo;
                }
            }
            Person person = new Person();
            person.setIdentificationNumber(personalInfo.getPersonIdentificationNumber());
            person.setCity(personalInfo.getCity());
            person.setStreet(personalInfo.getStreet());
            person.setHouseNumber(
                    personalInfo.getHouseNumber()
                            + (personalInfo.getApartmentNumber() != null ? "/" + personalInfo.getApartmentNumber() : ""));
            person.setName(matchingContactInfo.getName());
            person.setSurname(matchingContactInfo.getSurname());
            person.setTelephone(matchingContactInfo.getTelephone());
            personRepository.save(person);
        }
    }

    private List<PersonalInformation>       getValidPersonalData(PersonalInformationData personalData) {
        List<PersonalInformation> validData = new ArrayList<>();
        for (PersonalInformation data : personalData.getData()) {
            if (data.getPersonIdentificationNumber() == null || data.getPersonIdentificationNumber().length() != 11) {
                continue;
            }
            if (data.getCity() == null || data.getCity().length() < 1) {
                continue;
            }
            if (data.getStreet() == null || data.getStreet().length() < 1) {
                continue;
            }
            if (data.getHouseNumber() == null || data.getHouseNumber() < 1) {
                continue;
            }
            validData.add(data);
        }
        return validData;
    }

    private List<ContactInformation> getValidContactData(ContactInformationData addressData) {
        List<ContactInformation> validData = new ArrayList<>();
        for (ContactInformation data : addressData.getData()) {
            if (data.getPersonIdentificationNumber() == null || data.getPersonIdentificationNumber().length() != 11) {
                continue;
            }
            if (data.getSurname() == null || data.getSurname().length() < 1) {
                continue;
            }
            if (data.getName() == null || data.getName().length() < 1) {
                continue;
            }
            validData.add(data);
        }
        return validData;
    }
}
