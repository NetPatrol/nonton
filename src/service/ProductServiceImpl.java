package service;

import model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Класс реализует интерфейс ProductService.
 * @author Евгений Анфимов
 * */
public class ProductServiceImpl implements ProductService {

    final static Logger LOGGER = Logger.getLogger(ProductService.class.getName());

    /**
     * Поле, используемое в качестве InMemory DataBase
     * */
    private final Map<String, Product> database = new HashMap<>();

    @Override
    public boolean addProduct(final Product product) {
        final String id = Objects.requireNonNull(product).getId();
        LOGGER.info("проверяем, нет ли базе данных продукта с таким ID...");
        if (!database.containsKey(id)) {
            LOGGER.info("всё в порядке, добавляем новый продукт");
            database.put(id, product);
            return true;
        }
        LOGGER.log(Level.WARNING,
                "Ops, операция прервана, возможно продукт с ID {} уже существует.", id);
        return false;
    }

    @Override
    public boolean deleteProduct(final Product product) {
        final String id = Objects.requireNonNull(product).getId();
        if (database.containsKey(id)) {
            database.remove(id, product);
            LOGGER.log(Level.INFO, "продукт с ID " + id + " успешно удален");
            return true;
        }
        LOGGER.log(Level.WARNING,
                "продукт с ID " + id + " не может быть удален, так как он не найден в базе данных");
        return false;
    }

    @Override
    public String getProductNameById(final String id) {
        LOGGER.log(Level.INFO, "Ищем продукт с ID " + id);
        if (id != null && database.containsKey(id)) {
            final String name = database.get(id).getName();
            LOGGER.log(Level.INFO, "Ок, нашли! - " + name);
            return name;
        }
        LOGGER.log(Level.WARNING, "Продукт с ID " + id + " не найден");
        return "";
    }

    @Override
    public List<Product> findProductsByName(final String name) {
        final List<Product> products = new ArrayList<>();
        if (name != null) {
            for (Product product : database.values()) {
                if (product.getName().equals(name)) {
                    products.add(product);
                }
            }
            LOGGER.log(Level.INFO, "найдено " + products.size() + " продуктов с наименованием: " + name);
            return products;
        }
        LOGGER.log(Level.WARNING, "продуктов с таким наименованием не найдено");
        return Collections.emptyList();
    }
}