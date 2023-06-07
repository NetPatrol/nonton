package Test;

import model.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.ProductService;
import service.ProductServiceImpl;

import java.util.List;

import static Test.TestData.PRODUCT_ONE;
import static Test.TestData.PRODUCT_TWO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Тестовый класс
 *
 * @author Анфимов Евгений
 * */
public class ProductServiceTest {

    private ProductService service;

    /**
     * Инициализирует сервис перед каждым тестовым случаем.
     * */
    @Before
    public void initMethod() {
        service = new ProductServiceImpl();
    }

    /**
     * Удаляет ссылку на объект сервиса после каждого тестового случая
     * */
    @After
    public void destroyMethod() {
        service = null;
    }

    /**
     * Тестирует добавление продукта
     * */
    @Test
    public void addProductTest() {
        final boolean result = service.addProduct(PRODUCT_ONE);
        final String name = service.getProductNameById(PRODUCT_ONE.getId());

        assertTrue(result);
        assertEquals(PRODUCT_ONE.getName(), name);

    }

    /**
     * Тестирует удаление продукта
     * */
    @Test
    public void deleteProductTest() {
        service.addProduct(PRODUCT_ONE);

        final boolean result = service.deleteProduct(PRODUCT_ONE);

        assertTrue(result);
    }

    /**
     * Тестирует получение наименования продукта по ID
     * */
    @Test
    public void getProductNameByIdTest() {
        service.addProduct(PRODUCT_TWO);

        final String name = service.getProductNameById(PRODUCT_TWO.getId());

        assertEquals(PRODUCT_TWO.getName(), name);
    }

    /**
     * Тестирует возврат пустой строки в случае, когда продукт с указанным ID не найден.
     * */
    @Test
    public void getProductNameByIdIsBlankTest() {
        final String name = service.getProductNameById("8");

        assertTrue(name.isBlank());
    }

    /**
     * Тестирует поиск продуктов по наимнованию
     * */
    @Test
    public void findProductsByNameTest() {
        service.addProduct(PRODUCT_TWO);

        final String id = PRODUCT_TWO.getId();
        final String name = PRODUCT_TWO.getName();

        final List<Product> products = service.findProductsByName(name);

        assertEquals(id, products.get(0).getId());
        assertEquals(name, products.get(0).getName());
    }

    /**
     * Тестирует возврат пустого списка в случае, когда продукты с указанным наименованием не найдены.
     * */
    @Test
    public void findProductsByNameIsEmptyTest() {
        service.addProduct(PRODUCT_TWO);

        final List<Product> products = service.findProductsByName("some");

        assertTrue(products.isEmpty());
    }
}