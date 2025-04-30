<template>
  <div class="max-w-xl mx-auto">
    <h2 class="text-2xl font-semibold mb-4">Создать продукт</h2>

    <form @submit.prevent="submitForm" class="space-y-4 bg-white p-6 rounded shadow">
      <div>
        <label class="block mb-1 font-medium">Название</label>
        <input
            v-model="product.name"
            type="text"
            class="w-full border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring focus:ring-blue-200"
            required
        />
      </div>

      <div>
        <label class="block mb-1 font-medium">Описание</label>
        <textarea
            v-model="product.description"
            class="w-full border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring focus:ring-blue-200"
            rows="3"
        />
      </div>

      <div>
        <label class="block mb-1 font-medium">Цена</label>
        <input
            v-model.number="product.price"
            type="number"
            step="0.01"
            class="w-full border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring focus:ring-blue-200"
            required
        />
      </div>

      <button
          type="submit"
          class="bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700"
          :disabled="loading"
      >
        {{ loading ? 'Сохранение...' : 'Сохранить' }}
      </button>

      <p v-if="error" class="text-red-600 mt-2">{{ error }}</p>
      <p v-if="success" class="text-green-600 mt-2">Продукт успешно создан!</p>
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { createProduct } from '../api'

const product = ref({
  name: '',
  description: '',
  price: null,
})

const loading = ref(false)
const success = ref(false)
const error = ref(null)

async function submitForm() {
  loading.value = true
  error.value = null
  success.value = false

  try {
    await createProduct(product.value)
    success.value = true
    product.value = { name: '', description: '', price: null }
  } catch (err) {
    error.value = 'Ошибка при создании продукта'
    console.error(err)
  } finally {
    loading.value = false
  }
}
</script>
