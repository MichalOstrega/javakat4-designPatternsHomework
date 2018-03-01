package pl.sdacademy.java.patterns_homework.external.peronal;

public interface PersonalInformationService {
    PersonalInformationData fetch(String username, String password);
}
