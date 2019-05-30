<template>
    <div class="container" :style="{marginTop: '20px'}">
        <Card :bordered="false" dis-hover>
            <h5 slot="title">System</h5>
            <Form ref="form" :model="formData" label-position="left" :label-width="80">
                <FormItem label="Host">
                    <Input v-model="formData.host" placeholder="Host"></Input>
                </FormItem>
                <FormItem label="Sources">
                    <Input v-model="formData.sources" placeholder="Folder of Sources, defualt: sources"></Input>
                </FormItem>
                <FormItem label="Build">
                    <Input v-model="formData.builds" placeholder="Folder of Build, default: build"></Input>
                    <span>Build resources configured when app started, so restart app to make it work</span>
                </FormItem>
                <FormItem>
                    <Button type="primary" @click="handleSave()">Save</Button>
                </FormItem>
            </Form>
        </Card>

    </div>
</template>

<script>
    export default {
        name: 'System',
        data() {
            return {
                formData: {
                    sources : '',
                    build: '' ,
                    host: '' ,
                }
            }
        },
        methods:{
            handleSave(){
                var arr = [];
                for (let key in this.formData) {
                    arr.push({'key':key,'value':this.formData[key]});
                }
                this.put(arr);
            },
            put(arr){
                this.axios.put('/api/system', arr)
                    .then(response => {
                        if(response.data.code === 0){
                            this.$Message.success('save success!');
                        }else{
                            this.$Message.error(response.data.msg);
                        }
                    })
                    .catch(error => {
                        this.$Message.error(error);
                    });
            },
            get(key){
                this.axios.get('/api/system/'+key)
                    .then(response => {
                            if(response.data.code === 0){
                                if(response.data.data!=null){
                                    this.formData[key] = response.data.data.value;
                                }
                            }else{
                                this.$Message.error(response.data.msg);
                            }
                        })
                    .catch(error => {
                        this.$Message.error(error);
                    });
            }
        },
        mounted() {
            for (let key in this.formData) {
                this.get(key);
            }
        }
    }
</script>

<style>

</style>
