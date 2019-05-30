<template>
    <div class="container" :style="{marginTop: '20px'}">
        <Card :bordered="false" dis-hover>
            <h5 slot="title">{{id?'Edit Project':'Create Project'}}</h5>
            <Form ref="form" :model="formData" label-position="left" :label-width="80">
                <FormItem label="Id">
                    <Input :style="{maxWidth: '400px'}" v-model="formData.id" :readonly="id!==undefined && id!==''" placeholder="Unique Key"></Input>
                </FormItem>
                <FormItem label="Title">
                    <Input :style="{maxWidth: '400px'}" v-model="formData.title" placeholder="Title"></Input>
                </FormItem>
                <FormItem label="Description">
                    <Input v-model="formData.description" placeholder="Description"></Input>
                </FormItem>
                <FormItem label="Git">
                    <Input v-model="formData.git" placeholder="support git or https" :readonly="id!==undefined && id!==''"></Input>
                    <span>readonly, delete and create project to modify</span>
                </FormItem>
                <FormItem label="Branch">
                    <Input v-model="formData.branch" placeholder="git branch"></Input>
                </FormItem>
                <FormItem label="Username">
                    <Input v-model="formData.username" placeholder="git username"></Input>
                </FormItem>
                <FormItem label="Password">
                    <Input v-model="formData.password" type="password"></Input>
                </FormItem>
                <FormItem label="Source">
                    <Input v-model="formData.source" placeholder="Default:src/main/java"></Input>
                </FormItem>
                <FormItem label="Dependency">
                    <Input v-model="formData.dependency" placeholder="Folder of dependency"></Input>
                    <span>Multiple separated by <code>,</code></span>
                </FormItem>
                <FormItem>
                    <Button type="primary" @click="handleSave()" :style="{marginRight:'10px'}">Save</Button>
                    <Button type="error" @click="handleDelete()">Delete</Button>
                </FormItem>
            </Form>
        </Card>

    </div>
</template>

<script>
    export default {
        name: 'Project',
        props: ['id'],
        data() {
            return {
                formData: {
                    id : '',
                    title: '' ,
                    description: '' ,
                    git: '',
                    branch: '',
                    username: '',
                    password: '',
                    source: '' ,
                    dependency: '' ,
                }
            }
        },
        methods:{
            handleSave(){
                this.axios.post('/api/projects', {
                        id: this.formData.id,
                        title: this.formData.title,
                        description: this.formData.description,
                        git: this.formData.git,
                        branch: this.formData.branch,
                        username: this.formData.username,
                        password: this.formData.password,
                        source: this.formData.source,
                        dependency: this.formData.dependency,
                    })
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
            handleDelete(){

                this.axios.delete('/api/projects/'+this.formData.id, {})
                    .then(response => {
                        if(response.data.code === 0){
                            this.$Message.success('delete success!');
                        }else{
                            this.$Message.error(response.data.msg);
                        }
                    })
                    .catch(error => {
                        this.$Message.error(error);
                    });
            },
            loadProject(){
                this.axios.get("/api/projects/"+this.id)
                    .then(response => {
                        if(response.data.code === 0){
                            this.formData = response.data.data;
                        }
                    })
                    .catch(error => {
                        this.$Message.error(error);
                    })
                    .finally(() => {})
            }
        },
        mounted() {
            if(!this.id){
                return;
            }
            this.loadProject();
        }
    }
</script>

<style>

</style>
