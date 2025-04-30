import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import Crate from '../views/Create.vue'

const routes = [
    { path: '/', component: Home },
    { path: '/create', component: Crate}
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})

export default router
