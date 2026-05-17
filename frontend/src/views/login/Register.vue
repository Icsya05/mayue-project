<template>
  <div class="register-container">
    <div class="register-box">
      <h2>CodeLeap 注册</h2>
      <form @submit.prevent="register">
        <div class="form-item">
          <label>用户名</label>
          <input type="text" v-model="user.username" placeholder="请输入用户名" required>
        </div>
        <div class="form-item">
          <label>密码</label>
          <input type="password" v-model="user.password" placeholder="请输入密码" required>
        </div>
        <div class="form-item">
          <label>邮箱</label>
          <input type="email" v-model="user.email" placeholder="请输入邮箱" required>
        </div>
        <button type="submit" class="btn btn-primary btn-block">注册</button>
        <p class="login-link">已有账号？<router-link to="/login">立即登录</router-link></p>
      </form>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import request from '../../utils/request'

const router = useRouter()

const user = ref({
  username: '',
  password: '',
  email: ''
})

const register = async () => {
  // 等后端接口写完后，取消下面的注释
  // const res = await request.post('/user/register', user.value)
  // if (res.code === 200) {
  //   alert('注册成功，请登录')
  //   router.push('/login')
  // } else {
  //   alert(res.msg)
  // }

  // 临时测试代码：模拟注册成功
  alert('注册成功，请登录')
  router.push('/login')
}
</script>

<style scoped>
.register-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #f5f5f5;
}

.register-box {
  width: 400px;
  padding: 30px;
  background-color: white;
  border-radius: 8px;
  box-shadow: 0 2px 12px rgba(0, 0, 0, 0.1);
}

.register-box h2 {
  text-align: center;
  margin-bottom: 30px;
  color: #333;
}

.btn-block {
  width: 100%;
  margin-top: 10px;
}

.login-link {
  text-align: center;
  margin-top: 20px;
  color: #666;
}

.login-link a {
  color: #409eff;
  text-decoration: none;
}
</style>