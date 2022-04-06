<template>
    <div>
    <el-aside width="200px">
        <el-menu
        :default-active="$route.path" exact
        class="el-menu-vertical-demo"
        router
        >
            <!--无子集-->
            <el-menu-item :index="basePath" v-if="!item.children">
                <i class="el-icon-menu"></i>
                <span slot="title">{{item.name}}</span>
            </el-menu-item>

            <!--有子集-->
            <el-submenu :index="basePath" v-else>
                <template slot="title">
                    <i class="el-icon-menu"></i>
                    {{item.name}}
                </template>
                <NavItem v-for="sub in item.children" :key="sub.url" :item="sub" :basePath="sub.url"/>
            </el-submenu>
        </el-menu>
    </el-aside>
    </div>
</template>

<script>
    export default{
        name:'NavItem',
        data(){
            return{
                
            }
        },
        props:['item','basePath'], //父传子
        methods: {

        }
    }
</script>