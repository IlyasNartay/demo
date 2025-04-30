<template>
  <div class="container mx-auto p-4">
    <h1 class="text-2xl font-bold mb-4">Home</h1>
    <div v-if="loading" class="text-gray-500">Загрузка...</div>
    <div v-else>
      <ul>
        <li
            v-for="product in products"
            :key="product.id"
            class="mb-2 p-4 border rounded hover:bg-gray-50 transition"
        >
          <h2 class="text-xl font-semibold">{{ product.name }}</h2>
          <p class="text-gray-700">Цена: {{ product.price }}</p>
        </li>
      </ul>
      <div v-if="error" class="text-red-500 mt-4">{{ error }}</div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { getAllProducts } from '../api'

const products = ref([])
const loading = ref(true)
const error = ref(null)

async function loadProducts() {
  loading.value = true
  try {
    const { data } = await getAllProducts()
    products.value = data
  } catch (e) {
    console.error(e)
    error.value = 'Не удалось загрузить продукты'
  } finally {
    loading.value = false
  }
}

onMounted(loadProducts)
</script>


