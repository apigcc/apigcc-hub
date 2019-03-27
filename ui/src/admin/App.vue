<template>
    <div id="app">

        <b-navbar toggleable="md" type="dark" variant="dark" id="nav">

            <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>

            <b-navbar-brand href="/">APIGCC</b-navbar-brand>

            <b-collapse is-nav id="nav_collapse">

                <b-navbar-nav>
                    <b-nav-text>Auto build API document for Java</b-nav-text>
                </b-navbar-nav>

                <!-- Right aligned nav items -->
                <b-navbar-nav class="ml-auto">

                    <b-nav-item-dropdown right>
                        <!-- Using button-content slot -->
                        <template slot="button-content">
                            <span>User</span>
                        </template>
                        <b-dropdown-item href="/">dashboard</b-dropdown-item>
                        <b-dropdown-item href="/namespaces">namespace</b-dropdown-item>
                        <b-dropdown-item href="/projects">project</b-dropdown-item>
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
        data() {
            return {
                authenticated: false
            }
        },
    }
</script>

<style>

    body {
        /*background-color: #f6f8fa;*/
    }

</style>
