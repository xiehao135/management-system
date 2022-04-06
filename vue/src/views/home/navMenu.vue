<template>
    <div>
        <el-aside width="200px">
            <el-menu
            :default-active="this.$route.path"
            class="el-menu-vertical-demo" router>
                <NavItem v-for="v in items" :key="v.url" :item="v" :basePath="v.url"/>
            </el-menu>
        </el-aside>
    </div>
</template>

<script>    
import NavItem from './NavItem.vue'
export default{
    name:'navMenu',
    data(){
        return{
            items:[
                {name:'首页',url:'/index'},
                {name:'数据管理',url:'/data'},
                {name:'信息管理',url:'/info',children:[{name:'列表管理',url:'/info/list'}]},
                {
                    name:'用户管理',
                    url:'/user',
                    children:[
                        {name:'用户统计',url:'/user/data'},
                        {name:'角色统计',url:'/user/role'}
                    ]}
            ]
        }
    },
    components:{
        NavItem
    },
    methods: {

    }
}
</script>