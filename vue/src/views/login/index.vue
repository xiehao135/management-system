<template>
    <div class="login">
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="80px">
            <el-form-item label="用户名" prop="username">
                <el-input v-model="ruleForm.username"></el-input>
            </el-form-item>

            <el-form-item label="密码" prop="password">
                <el-input type="passowrd" v-model="ruleForm.password"></el-input>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    import request from '@/utils/request'
    export default{
        data(){
            return{
                ruleForm:{
                    username:'',
                    password:''
                },
                rules:{
                    username:[
                        { required: true, message: '请输入用户名', trigger: 'blur' },
                        { min: 5, max: 18, message: '长度在 5 到 18 个字符', trigger: 'blur' }
                    ],
                    password:[
                        { required: true, message: '请输入密码', trigger: 'blur' },
                        { min: 8, max: 11, message: '长度在 8 到 11 个字符', trigger: 'blur' }
                    ],
                }
            }
        },
        methods:{
            submitForm(formName) {
                this.$refs[formName].validate((valid) =>{
                    if(valid){
                        request.post("/user",this.ruleForm).then(res=>{
                            console.log(res);
                            let {code,data,msg} = res;
                            if(code == '0'){
                                this.$router.push("/home");//页面跳转
                            }else{
                                alert(msg)
                            }
                        }).catch(err=>{
                            console.log(err)
                        })
                    }else{
                        alert('error submit')
                    }
                })
                
            }
        }
    }
</script>