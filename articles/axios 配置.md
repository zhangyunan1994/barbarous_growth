**配置**

创建 `src/config/axios_config.js` 文件

```js
import axios from 'axios'

// 全局状态控制引入
import store from '../store/store'
import router from '../router'

let host = 'http://api.mir.com'

// http request 拦截器
axios.interceptors.request.use(
  config => {
    if (store.state.userInfo.token) { // 判断是否存在token，如果存在的话，则每个http header都加上token
      config.headers.Authorization = `JWT ${store.state.userInfo.token}`
    }
    config.baseURL = host
    return config
  },
  err => {
    return Promise.reject(err)
  })

// http response 拦截器
axios.interceptors.response.use(
  undefined,
  error => {
    let res = error.response
    switch (res.status) {
      case 401:
        // 返回 401 清除token信息并跳转到登录页面
        // store.commit(types.LOGOUT);
        router.replace({
          path: '/console/home/login',
          query: {
            redirect: router.currentRoute.fullPath
          }
        })
        break
      case 403:
        console.log('您没有该操作权限')
        break
      case 500:
        console.log('服务器错误')
        break
    }
    return Promise.reject(error.response.data) // 返回接口返回的错误信息
  })

```

为 axios 配置拦截器，全局对错误的状态码进行拦截，同时设置 header `Authorization` 添加认证信息


