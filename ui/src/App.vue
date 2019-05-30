<style scoped>
    .ivu-menu-horizontal{
        height: 48px !important;
        line-height: 48px !important;
    }
    .ivu-menu a{
        text-decoration: none;
    }
</style>
<template>
    <div id="app" class="layout">
        <Layout>
            <Header id="titleBar" :style="{overflowY:'hidden'}">
                <Row type="flex" justify="start">
                    <Col :style="{color: '#fff',cursor: 'pointer'}"><a href="/" :style="{fontSize: '1.3em',color: '#fff', textDecoration: 'none'}">APIGCC</a><span :style="{opacity: '.7', marginLeft: '10px'}">Auto build API document for Java</span></Col>
                    <Col>
                        <Menu mode="horizontal" theme="dark" active-name="1" :style="{fontSize: '1.2em'}">
                            <div class="layout-nav">
                                <MenuItem name="1" to="/">
                                    <Icon type="md-book" />
                                    Books
                                </MenuItem>
                                <MenuItem name="2" to="/projects">
                                    <Icon type="md-list" />
                                    Projects
                                </MenuItem>
                                <MenuItem name="3" to="/system">
                                    <Icon type="ios-settings" />
                                    System
                                </MenuItem>
                            </div>
                        </Menu>

                    </Col>
                </Row>
            </Header>
            <Content>
                <router-view></router-view>
            </Content>
            <!--<Footer class="layout-footer-center">by Apigcc</Footer>-->
        </Layout>
    </div>
</template>
<script>
    export default {
        name: 'app',
        data() {
            return {
            }
        },

    }
</script>
