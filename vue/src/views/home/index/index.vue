<template>
    <div>
        <!--走马灯-->
        <el-carousel :interval="3000" type="card" indicator-position="outside" height="200px">
            <el-carousel-item v-for="item in imgs" :key="item">
                <img :src="item"/>
            </el-carousel-item>
        </el-carousel>
        <!--卡片-->
        <el-row :gutter="20">
            <el-col :xs="24" :sm="12" :md="6" v-for="o in cardList" :key="o">
                <el-card :body-style="{ padding: '0px' }">
                <img :src="o.img" class="image">
                <div style="padding: 14px;">
                    <span>{{o.title}}</span>
                    <div class="bottom clearfix">
                    <el-button type="text" class="button">操作按钮</el-button>
                    </div>
                </div>
                </el-card>
            </el-col>
        </el-row>
    </div>
</template>

<script>
    export default{
        data(){
            return{
              imgs:[
                  require('@/assets/images/11.jpg'),
                  require('@/assets/images/12.jpg'),
                  require('@/assets/images/13.jpg'),
              ],
              cardList:[
                  {title:'小羊可爱',img:require('@/assets/images/sheep.jpg')},
                  {title:'小羊美丽',img:require('@/assets/images/sheep.jpg')},
                  {title:'小羊聪明',img:require('@/assets/images/sheep.jpg')},
                  {title:'小羊贪吃',img:require('@/assets/images/sheep.jpg')}
              ]
            }
        },
        methods: {

        }
    }
</script>

<style>
.el-card__body img{
    height: 200px;
}
</style>