<template>
    <div>
        <el-progress :text-inside="true" :percentage="num" status="success"></el-progress>

        <el-steps :active="active" finish-status="success">
            <el-step v-for="(step,i) in step_titles" :key="i" :title="step"></el-step>
        </el-steps>

        <el-button v-show="flag" style="margin-top: 12px;" @click="next">下一步</el-button>
    </div>
</template>

<script>
    export default{
        data(){
            return{
              active:0,
              step_titles:['步骤1','步骤2','步骤3','步骤3','步骤5'],
              flag:true
            }
        },
        computed:{
            num(){
                return this.active/this.step_titles.length*100
            }
        },
        methods: {
            next(){
                if(this.active ++ == this.step_titles.length){
                    this.$alert('任务完成', '', {
                        confirmButtonText: '确定'
                    }).then(res=>{
                        this.flag = false;
                    });
                }
            }
        }
    }
</script>