package pl.sdacademy.java.patterns_homework.external.address;

public interface ContactService {
    ContactInformationData fetch(String username, String password);
}
