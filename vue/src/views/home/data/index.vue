<template>
    <el-table
      :data="tableData"
      stripe
      style="width: 100%">
      <el-table-column
        prop="date"
        sortable
        label="日期"
        width="180"
        :filters="filterDate"
        :filter-method="filterHandler"
        filter-placement="bottom-end">
      </el-table-column>
      <el-table-column
        prop="name"
        label="姓名"
        width="180">
      </el-table-column>
      <el-table-column
        prop="address"
        label="地址">
      </el-table-column>
      <el-table-column
        prop="tag"
        label="标签"
        width="100"
        :filters="[{ text: '家', value: '家' }, { text: '公司', value: '公司' }]"
        :filter-method="filterHandler"
        filter-placement="bottom-end">
        <template slot-scope="scope">
          <el-tag
            :type="scope.row.tag === '家' ? 'primary' : 'success'"
            disable-transitions>{{scope.row.tag}}</el-tag>
        </template>
      </el-table-column>
    </el-table>
</template>

<script>
    import request from '@/utils/request'
    export default{
        data(){
            return{
                tableData:[],
                filterDate:[]
            }
        },
        created(){
          this.load()
        },
        methods:{
          load(){
            request.get("/userinfo",{
              pageNum:1,
              pageSize:10,
              search:''
            }).then(res=>{
              console.log(res);
              let {code,result,msg} = res;
              if(code=="0"){
                this.tableData = res.data.records;
                this.filterDate = this.tableData.map(item=>({text:item.date,value:item.date}));
              };
            },err=>{
              console.log(err)
            })
          },
          filterHandler(value, row, column) {
            const property = column['property']; //得到我们决定筛选的值
            return row[property] === value; //返回筛选值等于value的行
          }
        }
    }
</script>
