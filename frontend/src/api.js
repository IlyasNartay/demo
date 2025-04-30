import axios from 'axios';

// Базовая конфигурация Axios с использованием переменной окружения
const api = axios.create({
    baseURL: import.meta.env.VITE_API_BASE_URL || 'http://localhost:8080/api',
    headers: {
        'Content-Type': 'application/json'
    }
});

/**
 * Получить список всех продуктов
 * @returns {Promise<Array>} массив продуктов
 */
export function getAllProducts() {
    return api.get('/products');
}

/**
 * Получить продукт по ID
 * @param {string} id - идентификатор продукта
 * @returns {Promise<Object>} объект продукта
 */
export function getProductById(id) {
    return api.get(`/products/${id}`);
}

/**
 * Создать новый продукт
 * @param {Object} product - объект продукта для создания
 * @returns {Promise<Object>} созданный продукт
 */
export function createProduct(product) {
    return api.post('/products', product);
}

/**
 * Удалить продукт по ID
 * @param {string} id - идентификатор продукта
 * @returns {Promise<void>}
 */
export function deleteProduct(id) {
    return api.delete(`/products/${id}`);
}

// Экспорт клиента для случаев, когда нужны дополнительные запросы
export default api;
