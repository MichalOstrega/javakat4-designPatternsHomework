package pl.sdacademy.java.patterns_homework.external.peronal;

import java.util.Date;
import java.util.List;

public class PersonalInformationData {
    private List<PersonalInformation> data;
    private Date validTill;

    public List<PersonalInformation> getData() {
        return data;
    }

    public void setData(List<PersonalInformation> data) {
        this.data = data;
    }

    public Date getValidTill() {
        return validTill;
    }

    public void setValidTill(Date validTill) {
        this.validTill = validTill;
    }
}
