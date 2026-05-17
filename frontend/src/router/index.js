import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    path: '/',
    redirect: '/login'
  },
  {
    path: '/login',
    name: '登录页',
    component: () => import('../views/Login.vue')
  },
  {
    path: '/home',
    name: '首页',
    component: () => import('../views/home/Home.vue')
  },
  {
    path: '/task',
    name: '任务管理',
    component: () => import('../views/task/TaskList.vue')
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
