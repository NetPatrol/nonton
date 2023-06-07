package model;

import java.util.Objects;

/**
 * Модель представления продукта.
 * @author Евгений Анфимов
 * */
public class Product {

    private String id;
    private String name;

    /**
     * Конструктор.
     * */
    public Product(final String id, final String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Предоставляет ID продукта
     * */
    public String getId() {
        return id;
    }

    /**
     * Устанавливает значение поля ID
     * */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * Предоставляет наименование продукта
     * */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает значение поля name
     * */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Переопределяет метод equals
     * */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(getId(), product.getId()) && Objects.equals(getName(), product.getName());
    }

    /**
     * Переопределяет метод hashCode
     * */
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    /**
     * Переопределяет метод toString
     * */
    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}