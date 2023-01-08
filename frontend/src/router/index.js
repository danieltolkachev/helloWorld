import { createRouter, createWebHistory } from 'vue-router'
import Task from '@/views/TaskView'

const routes = [
  {
    path: '/tasks',
    name: 'tasks',
    component: Task
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  }
]

const router = createRouter({
  history: createWebHistory('http://localhost:8080/api/v1/todo'),
  linkActiveClass: 'active',
  routes
})

export default router
