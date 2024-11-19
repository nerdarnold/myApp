package com.ata.courierApp.entities.abstracts;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable
{
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @PrePersist
    protected void onCreate() {
        if (this.id == null) {
            this.id = UUID.randomUUID().toString();
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (!(o instanceof BaseEntity))
            return false;
        BaseEntity that = (BaseEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }

    @Override
    public String toString()
    {
        return "BaseEntity {" + "id = " + id + "}";
    }
}

