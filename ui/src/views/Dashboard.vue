<style scoped>
    iframe{
        width:100%;
        height: 100%;
        display: block;
        border:none;
    }
    .sider-title{
        -webkit-transition: all 0.2s ease-in-out;
        transition: all 0.2s ease-in-out;
        overflow: hidden;
    }
    .sider-title-collapse{
        width:0px;
    }
    .sider-title-open{
        width:236px;
    }
    .ivu-layout-content{
        -webkit-transition: all 0.2s ease-in-out;
        transition: all 0.2s ease-in-out;
    }
</style>

<template>
    <div>
        <div id="statusBar" :style="{lineHeight: '24px',padding:'10px',borderBottom: '1px solid #e8eaec',background: '#ffffff'}">
            <Row type="flex" justify="start">
                <Col class="sider-title" :class="sideCollapsed?'sider-title-collapse':'sider-title-open'">
                    <h5>Books</h5>
                </Col>
                <Col>
                    <Icon @click.native="$refs.side.toggleCollapse()" :style="{marginRight: '10px',cursor: 'pointer'}" type="md-menu" size="24"></Icon>
                </Col>
                <Col :style="{flex: '1'}">
                    {{book.title + (book.group!==''?'-':'') + book.group}}
                </Col>
                <Col v-if="book.id!==''">
                    <!--<Button :to="'/books/'+book.id+'/'+book.group+'.md'" target="_blank" icon="md-download" :style="{lineHeight: '22px',padding: '0px 10px',marginLeft: '10px'}">MD</Button>-->
                    <Button :to="'/books/'+book.id+'/'+book.group+'.adoc'" target="_blank" icon="md-download" :style="{lineHeight: '22px',padding: '0px 10px',marginLeft: '10px'}">Adoc</Button>
                    <Button :to="'/books/'+book.id+'/'+book.group+'.json'" target="_blank" title="import to postman" icon="ios-link" :style="{lineHeight: '22px',padding: '0px 10px',marginLeft: '10px'}">Postman</Button>
                </Col>
            </Row>
        </div>
        <Layout ref="fixedContent" id="fixedContent">
            <Sider ref="side" hide-trigger collapsible :collapsed-width="0" v-model="sideCollapsed" width="280px" :style="{height: '100%', overflow: 'auto'}">
                <div class="menu" :style="{padding: '10px 10px 0 10px'}">

                    <Card v-for="b in books" :key="b.id" :title="b.title" icon="md-book" :style="{marginBottom:'20px'}" shadow>
                        <!--<Item :id="b.id" group="index" target="_doc" :selected="book.id+book.group" @click="itemSelected" />-->
                        <Item v-for="group in b.groups" :key="group.name" :id="b.id" :group="group.name" target="_doc" :selected="book.id+book.group" @click="itemSelected" />
                    </Card>
                </div>


            </Sider>
            <Content>
                <iframe name="_doc" scrolling="auto" frameborder="0"></iframe>
            </Content>
        </Layout>

    </div>

</template>

<script>
    import Item from '../components/Item';
    export default {
        name: 'Dashboard',
        components:{Item},
        data() {
            return {
                sideCollapsed: false,
                windowHeight: 0,
                books:[
                ],
                book:{
                    id:'',
                    title:'',
                    group:''
                }
            }
        },
        mounted() {
            this.windowHeight = `${document.documentElement.clientHeight}`
            window.onresize = function () {
                this.windowHeight = `${document.documentElement.clientHeight}`;
            }.bind(this);

            this.loadBooks();
        },
        watch: {
            windowHeight(newHeight) {
                var titleHeight = `${document.getElementById('titleBar').offsetHeight}`
                var statusHeight = `${document.getElementById('statusBar').offsetHeight}`
                var h = (newHeight - titleHeight - statusHeight);
                this.$refs.fixedContent.$el.style.height = h + 'px';
            }
        },
        methods: {
            loadBooks(){
                this.axios.get("/api/projects/books")
                    .then(response => {
                        if(response.data.code === 0){
                            this.books = response.data.data;
                        }
                    })
                    .catch(error => {
                        this.$Message.error(error)
                    })
                    .finally(() => {})
            },
            itemSelected(id,group){
                this.book.id = id;
                this.book.group = group;
                for (let i in this.books) {
                    if (this.books.hasOwnProperty(i)) {
                        let b = this.books[i];
                        if(b.id === id){
                            this.book.title = b.title;
                        }
                    }
                }
            }
        }
    }
</script>
