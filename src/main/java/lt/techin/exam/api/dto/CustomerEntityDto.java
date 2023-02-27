package lt.techin.exam.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lt.techin.exam.model.Item;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class CustomerEntityDto extends CustomerDto {

    private Long id;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;

    private List<Item> items;

    public CustomerEntityDto() {
    }

    public CustomerEntityDto(String name, String surname, Date birthday, Long phoneNumber, Boolean loyal, Long id, LocalDateTime createdDate, List<Item> items) {
        super(name, surname, birthday, phoneNumber, loyal);
        this.id = id;
        this.createdDate = createdDate;
        this.items = items;
    }

    public CustomerEntityDto(Long id, LocalDateTime createdDate, List<Item> items) {
        this.id = id;
        this.createdDate = createdDate;
        this.items = items;
    }

    public CustomerEntityDto(long l, String vardas, String pavarde, String s, int i, Boolean aFalse, String s1) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CustomerEntityDto that = (CustomerEntityDto) o;
        return Objects.equals(id, that.id) && Objects.equals(createdDate, that.createdDate) && Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, createdDate, items);
    }

    @Override
    public String toString() {
        return "CustomerEntityDto{" +
                "id=" + id +
                ", createdDate=" + createdDate +
                ", items=" + items +
                '}';
    }
}