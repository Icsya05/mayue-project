import { createRouter, createWebHistory } from 'vue-router'

// 路由规则：URL地址与Vue组件的映射关系
const routes = [
  {
    path: '/', // 网站根路径
    redirect: '/login' // 自动跳转到登录页
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('../views/login/Login.vue') // 路由懒加载
  },
  {
    path: '/register',
    name: 'Register',
    component: () => import('../views/login/Register.vue')
  },
  {
    path: '/home',
    name: 'Home',
    component: () => import('../views/home/Home.vue')
  },
  {
    path: '/task',
    name: 'Task',
    component: () => import('../views/task/TaskList.vue')
  },
  {
    path: '/404',
    name: '404',
    component: () => import('../views/404.vue')
  },
  {
    path: '/:pathMatch(.*)*', // 通配符，匹配所有不存在的路径
    redirect: '/404'
  }
]

// 创建路由实例
const router = createRouter({
  history: createWebHistory(), // 使用HTML5历史模式，URL更美观
  routes
})

export default router