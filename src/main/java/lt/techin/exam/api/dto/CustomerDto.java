package lt.techin.exam.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

public class CustomerDto {

    private String name;
    private String surname;

    @JsonFormat(pattern="dd-MM-yyyy")
    @ApiModelProperty(dataType = "java.sql.Date")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date birthday;

    private Long phoneNumber;

    private Boolean loyal;

    public CustomerDto(String name, String surname, Date birthday, Long phoneNumber, Boolean loyal) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.loyal = loyal;
    }

    public CustomerDto() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getLoyal() {
        return loyal;
    }

    public void setLoyal(Boolean loyal) {
        this.loyal = loyal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDto that = (CustomerDto) o;
        return Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(birthday, that.birthday) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(loyal, that.loyal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthday, phoneNumber, loyal);
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                ", phoneNumber=" + phoneNumber +
                ", loyal=" + loyal +
                '}';
    }
}
