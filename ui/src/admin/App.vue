<template>
    <div id="app">

        <b-navbar toggleable="md" type="dark" variant="dark">

            <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>

            <b-navbar-brand href="#">APIGCC</b-navbar-brand>

            <b-collapse is-nav id="nav_collapse">

                <b-navbar-nav>
                    <b-nav-text>Auto build API document for Java</b-nav-text>
                </b-navbar-nav>

                <b-navbar-nav>
                    <b-form-input size="sm" class="ml-sm-2" type="text" placeholder="Search"/>
                    <!--<b-button size="sm" class="my-2 my-sm-0" type="submit">创建</b-button>-->
                </b-navbar-nav>

                <!-- Right aligned nav items -->
                <b-navbar-nav class="ml-auto">

                    <!--<b-nav-item-dropdown text="Lang" right>-->
                        <!--<b-dropdown-item href="#">EN</b-dropdown-item>-->
                        <!--<b-dropdown-item href="#">ES</b-dropdown-item>-->
                        <!--<b-dropdown-item href="#">RU</b-dropdown-item>-->
                        <!--<b-dropdown-item href="#">FA</b-dropdown-item>-->
                    <!--</b-nav-item-dropdown>-->

                    <b-nav-item-dropdown right>
                        <!-- Using button-content slot -->
                        <template slot="button-content">
                            <b-img style="margin-right: 10px" rounded="circle" width="30" height="30" fluid
                                   src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1544535647698&di=5cd15a0864c0812f008c3bc7784458fe&imgtype=0&src=http%3A%2F%2Fimg1.touxiang.cn%2Fuploads%2F20131012%2F12-054322_623.jpg" ></b-img>
                            <span>User</span>
                        </template>
                        <b-dropdown-item href="#">Profile</b-dropdown-item>
                        <b-dropdown-item href="#">Signout</b-dropdown-item>
                    </b-nav-item-dropdown>
                </b-navbar-nav>

            </b-collapse>
        </b-navbar>

        <router-view></router-view>
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

    body{
        /*background-color: #f6f8fa;*/
    }

</style>
