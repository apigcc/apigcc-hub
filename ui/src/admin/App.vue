<template>
    <div id="app">
        <el-container>
            <el-header style="height:auto; padding: 12px 20px">
                <span>APIGCC</span>
            </el-header>
            <el-aside>

            </el-aside>
            <el-main>
                <router-view></router-view>
            </el-main>
        </el-container>

    </div>
</template>

<script>
    export default {
    name: 'app',
    data(){
        return {
            authenticated: false
        }
    },
}
</script>

<style>
    .el-header {
        background-color: #24292e;
        color: hsla(0,0%,100%,.9);
        line-height: 1.5;
        z-index: 64;
    }
    .app-logo {
        padding-left: 20px;
        font-size: 32px;
    }
    .el-main{
        padding: 0;
    }
</style>
