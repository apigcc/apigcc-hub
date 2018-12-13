<template>
    <div class="login">
        <div class="content mt-5 p-3">
            <h1 class="h3 mb-3 font-weight-normal text-center">🐷</h1>
            <p><b-input prefix-icon="el-icon-message" placeholder="邮箱"></b-input></p>
            <p><b-input prefix-icon="el-icon-view" type="password" placeholder="密码"></b-input></p>
            <p><b-button block type="submit" variant="outline-success">登录</b-button></p>
            <p class="mt-3 mb-2 text-muted">© 2018 Apigcc</p>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'Login',
        data(){
            return{
                form: {
                    name: '',
                    password: ''
                }
            }
        }
    }
</script>

<style scoped>
    @media (min-width: 768px) {
        .content{
            width: 380px;
            margin: 0 auto;
            border: 1px solid #e6e6e6;
            background-color: #ffffff;
            border-radius: 5px;
        }
    }
</style>
