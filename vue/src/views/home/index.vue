<template>
  <div>
    <el-container>
        <!--左侧导航-->
        <NavMenu></NavMenu>
        <!--右侧主体-->
        <el-container>
            <!--头部-->
            <el-header>
              <Breakcrumb/>
              <el-button class="exit" type="primary" @click="goBack()">退出</el-button>
            </el-header>
            <!--展示信息-->
            <el-main>
              <router-view></router-view>
            </el-main>
        </el-container>
    </el-container>
  </div>
</template>

<script>
import NavMenu from './navMenu.vue'
import Breakcrumb from './breakcrumb.vue'
    export default{
        data(){
            return{
              
            }
        },
        methods:{
           goBack(){
             this.$router.push("/login");
           }
        },
        components:{
            NavMenu,
            Breakcrumb
        }
    }
</script>