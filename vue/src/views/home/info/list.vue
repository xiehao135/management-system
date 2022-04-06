<template>
    <div>
        <el-card class="box-card">
            <div slot="header" class="clearfix">
                <span>卡片名称</span>
                <el-button style="float: right; padding: 3px 0" type="text" @click="dialogVisible = true">操作按钮</el-button>
            </div>
            <el-collapse v-model="activeNames" accordion> <!-- @change="handleChange"-->
                <el-collapse-item  v-for="item in items" :key="item.id"  :title="item.title" :name="item.id">
                    <div v-for="(v,i) in item.contentList" :key="i">{{v.content}}</div>
                </el-collapse-item>
            </el-collapse>
        </el-card>

        <!--对话框-->
        <el-dialog
        title="提示"
        :visible.sync="dialogVisible"
        width="30%"> <!--:before-close="handleClose"-->
            <span>这是一段信息</span>
            <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="submit()">确 定</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
    import request from '@/utils/request'
    export default{
        data(){
            return{
              dialogVisible:false,
              activeNames:"1",
              items:[]
            }
        },
        methods: {
            submit(){
                this.dialogVisible = false;
                let _id = this.items.length>0?Math.max(...this.items.map(v=>v.id))+1:1;
                this.items.push({
                    id:_id,
                    title:'这是新添加的数据 == '+_id,
                    contentList:[
                        {content:'这是新添加的数据'}
                    ]
                })
            },
            load(){
                request.get("/info",{
                    pageNum:1,
                    pageSize:10,
                    search:''
                    }).then(res=>{
                    console.log(res);
                    let {code,result,msg} = res;
                    if(code=="0"){
                        this.items = res.data.records;
                        this.activeNames = this.items[0].id || 1;
                    };
                    },err=>{
                    console.log(err)
                })
            }
        },
        mounted(){
            this.load()
        }
    }
</script>