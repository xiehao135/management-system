import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect:'/home'
  },
  {
    path: '/login', //登录页
    name: 'login',
    component: () => import('../views/login/index.vue')
  },
  {
    path: '/home', //布局页
    name: 'home',
    meta:{title:'首页'},
    redirect:'/index',
    component: () => import('../views/home/index.vue'),
    children:[
      {
        path: '/index', //主体页
        name: 'index',
        meta:{title:'首页'},
        component: () => import('../views/home/index/index.vue')
      },
      {
        path: '/data', //数据管理
        name: 'data',
        meta:{title:'数据管理'},
        component: () => import('../views/home/data/index.vue')
      },
      {
        path: '/info', //信息管理
        name: 'info',
        meta:{title:'信息管理'},
        component: () => import('../views/home/info/index.vue'),
        children:[
            {
              path:'/info/list',//列表管理
              name:'infolist',
              meta:{title:'列表管理'},
              component:() => import('../views/home/info/list.vue')
        }]
      },
      {
        path: '/user', //用户管理
        name: 'user',
        meta:{title:'用户管理'},
        component: () => import('../views/home/user/index.vue'),
        children:[
            {
              path:'/user/data',//用户统计
              name:'userdata',
              meta:{title:'用户统计'},
              component:() => import('../views/home/user/data.vue')
            },
            {
              path:'/user/role', //角色统计
              name:'userrole',
              meta:{title:'角色统计'},
              component:() => import('../views/home/user/role.vue')
            }
        ]
      }
    ]
  }
]

const router = new VueRouter({
  routes
})

export default router
