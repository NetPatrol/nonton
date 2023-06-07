package service;

import model.Product;

import java.util.List;

/**
 * Интерфейс предоставляет стандартный набор методов для работы с продуктами
 * @author Евгений Анфимов
 * */
public interface ProductService {

    /**
     * Добавляет новый продукт.
     * Возвращает false если продукт с таким ID же существует.
     * @param product продукт для добавления
     * @return boolean
     * */
    boolean addProduct(final Product product);

    /**
     * Удаляет продукт.
     * Возвращает false если такого продукта не обнаружено, удаления не происходит.
     * @param product продукт для удаления
     * @return boolean
     * */
    boolean deleteProduct(final Product product);

    /**
     * Предоставляет наименование продукта по ID.
     * В случае отсутствия продукта с таким ID, метод возвращает пустую строку.
     * @param id ID продукта
     * @return наименование продукта
     * */
    String getProductNameById(final String id);

    /**
     * Предоставляет список всех продуктов имеющих определенное наименование.
     * Иначе возвращает пустой список.
     * @param name наименование продуктов
     * @return список продуктов.
     * */
    List<Product> findProductsByName(final String name);
}