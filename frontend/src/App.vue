<template>
  <div class="flex flex-col min-h-screen bg-gray-50 text-gray-900">
    <!-- Header / Navbar -->
    <header class="bg-white shadow-md">
      <div class="container mx-auto flex items-center justify-between p-4">
        <RouterLink to="/" class="text-2xl font-extrabold text-blue-600">
          Product App
        </RouterLink>

        <nav class="space-x-4">
          <RouterLink to="/" class="text-gray-700 hover:text-blue-600">Home</RouterLink>
          <RouterLink to="/create" class="text-gray-700 hover:text-blue-600">Create Product</RouterLink>
        </nav>
      </div>
    </header>

    <!-- Main -->
    <main class="flex-grow container mx-auto p-4">
      <RouterView />
    </main>

    <!-- Footer -->
    <footer class="bg-white border-t text-center py-4 text-sm text-gray-500">
      © {{ new Date().getFullYear() }} Product App. All rights reserved.
    </footer>
  </div>
</template>

<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>


