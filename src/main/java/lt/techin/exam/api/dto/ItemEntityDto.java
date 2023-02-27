package lt.techin.exam.api.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lt.techin.exam.model.Customer;

import java.time.LocalDateTime;
import java.util.Objects;


public class ItemEntityDto extends ItemDto {

    private Long id;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;

    public ItemEntityDto(Long id, LocalDateTime createdDate) {
        this.id = id;
        this.createdDate = createdDate;
    }

    public ItemEntityDto(String name, Double weight, Integer sector, Customer customer, Long id, LocalDateTime createdDate) {
        super(name, weight, sector, customer);
        this.id = id;
        this.createdDate = createdDate;
    }

    public ItemEntityDto() {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ItemEntityDto that = (ItemEntityDto) o;
        return Objects.equals(id, that.id) && Objects.equals(createdDate, that.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, createdDate);
    }

    @Override
    public String toString() {
        return "ItemEntityDto{" +
                "id=" + id +
                ", createdDate=" + createdDate +
                '}';
    }
}