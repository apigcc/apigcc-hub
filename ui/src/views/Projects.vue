<template>
    <div class="container" :style="{marginTop: '20px'}">
        <Card :bordered="false" dis-hover>
            <div slot="title">
                <Row>
                    <Col span="12">
                        <h5>Projects</h5>
                    </Col>
                    <Col span="12" :style="{textAlign:'right'}">
                        <router-link to="project"><Button type="success">Create</Button></router-link>
                    </Col>
                </Row>
            </div>
            <div>
                <Table border :columns="columns" :data="data" no-data-text="No Data"></Table>
            </div>
            <div :style="{marginTop: '10px'}">
                Auto refresh：<i-switch v-model="refresh" />
            </div>
        </Card>

    </div>
</template>

<script>
    import productDetail from '../components/ProductDetail.vue';
    export default {
        name: 'Projects',
        data() {
            return {
                form: {
                    id: '',
                    name: '',
                    git: '',
                    gitUser: '',
                    gitPassword: '',
                },
                windowWidth: 0,
                refresh: true,
                refreshing: false,
                showing: false,
                columns: [],
                columnFull:[
                    {
                        type: 'expand',
                        width: 50,
                        render: (h, params) => {
                            return h(productDetail, {
                                props: {
                                    row: params.row
                                }
                            })
                        }
                    },
                    {
                        title: 'ID',
                        key: 'id',
                        always: true,
                    },
                    {
                        title: 'Title',
                        key: 'title',
                        ellipsis: true,
                    },
                    {
                        title: 'Description',
                        key: 'description',
                        ellipsis: true,
                    },
                    {
                        title: 'Status',
                        key: 'status',
                        always: true,
                        render: (h, params) =>{
                            let status = "";
                            let text = params.row.status;
                            switch (params.row.status) {
                                case 'INIT':
                                    status = 'default';
                                    break;
                                case 'SUCCESS':
                                    status = 'success';
                                    break;
                                case 'FAIL':
                                    status = 'error';
                                    break;
                                case 'BUILDING':
                                    status = 'warning';
                                    break;
                            }
                            return h('Badge',{
                                props:{
                                    status: status,
                                    text: text
                                }
                            })
                        }
                    },
                    {
                        title: 'Action',
                        align: 'center',
                        always: true,
                        key: 'id',
                        render: (h, params) => {
                            return h('div', [
                                h('LoadingButton', {
                                    props: {
                                        size: 'small',
                                        text: 'Build',
                                        loading: params.row.status === 'BUILDING',
                                    },
                                    style: {
                                        marginRight: '5px',
                                        marginBottom: '5px',
                                    },
                                    on: {
                                        click: (finishCall) => {
                                            this.buildProject(params.row.id,finishCall);
                                        }
                                    }
                                }),
                                h('Button', {
                                    props: {
                                        size: 'small'
                                    },
                                    style: {
                                        marginRight: '5px',
                                        marginBottom: '5px',
                                    },
                                    on: {
                                        click: () => {
                                            this.$router.push({ path: 'project/'+params.row.id})
                                        }
                                    }
                                }, 'Edit')
                            ]);
                        }
                    },
                ],
                data: [
                ],
            }
        },
        methods : {
            loadProjects(){
                this.refreshing = true;
                this.axios.get("/api/projects")
                    .then(response => {
                        if(response.data.code === 0){
                            for (let i in response.data.data) {
                                let data = response.data.data[i];
                                let d = this.findProject(data.id);
                                if(d){
                                    for (let key in data) {
                                        d[key] = data[key];
                                    }
                                }else{
                                    this.data.push(data);
                                }

                            }
                        }
                    })
                    .catch(error => {
                        this.$Message.error(error);
                    })
                    .finally(() => {
                        this.refreshing = false;
                        this.refreshData();
                    })
            },
            buildProject(id,finishCall){
                let project = this.findProject(id);
                if(project){
                    this.axios.get("/api/projects/"+id+"/build")
                        .then(response => {
                            if(response.data.code === 0){
                                this.$Message.success('build success !');
                                this.loadProjects();
                            }
                        })
                        .catch(error => {
                            this.$Message.error(error);
                        })
                        .finally(() => {
                            if(finishCall){
                                finishCall();
                            }
                        })
                }
            },
            findProject(id){
                for (let i in this.data) {
                    if(this.data[i] && this.data[i].id === id){
                        return this.data[i];
                    }
                }
            },
            refreshData(){
                if(this.showing && this.refresh && !this.refreshing){
                    this.refreshing = true;
                    setTimeout(()=>{
                        this.loadProjects();
                    },1000);
                }
            }
        },
        watch: {
            windowWidth(width) {
                if(width>450){
                    this.columns = this.columnFull;
                }else{
                    this.columns = [];
                    for (let i in this.columnFull) {
                        if(this.columnFull[i].always){
                            this.columns.push(this.columnFull[i]);
                        }
                    }
                }
            },
            refresh(b){
                if(b){
                    this.refreshData();
                }
            }
        },
        mounted() {
            this.showing = true;

            this.windowWidth = `${document.documentElement.clientWidth}`
            window.onresize = function () {
                this.windowWidth = `${document.documentElement.clientWidth}`;
            }.bind(this);

            this.loadProjects();
        },
        beforeDestroy() {
            this.showing = false;
        }
    }
</script>

<style>

</style>
