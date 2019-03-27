<template>
    <div class="dashboard">
        <div class="menu">
            <div class="mb-3">
                <h5>Projects</h5>
            </div>
            <div class="mb-3">
                <b-nav-form>
                    <b-form-input size="sm" class="mr-sm-2" type="text"></b-form-input>
                    <b-button size="sm" class="my-2 my-sm-0 bg-white text-muted border" type="submit">搜索</b-button>
                </b-nav-form>
            </div>
            <div class="mb-3">
                <b-link href="#">1byongche</b-link>
                <b-list-group class="mt-1">
                    <b-list-group-item href="/apigcc.html" target="iframe-content">service-car</b-list-group-item>
                    <b-list-group-item href="#">service-car-station</b-list-group-item>
                    <b-list-group-item href="#">service-charging</b-list-group-item>
                </b-list-group>
            </div>
            <div class="mb-3">
                <b-link href="#">hcd</b-link>
                <b-list-group class="mt-1">
                    <b-list-group-item href="#">service-car</b-list-group-item>
                    <b-list-group-item href="#">service-car-station</b-list-group-item>
                    <b-list-group-item href="#">service-charging</b-list-group-item>
                </b-list-group>
            </div>
        </div>
        <div class="content">
            <iframe id="iframe-content" ref="iframeContent" name="iframe-content">
            </iframe>

        </div>

    </div>
</template>

<script>
    export default {
        name: 'Dashboard',
        data() {
            return {
                form: {
                    name: '',
                    password: ''
                },
                windowHeight: 0
            }
        },
        mounted() {
            this.windowHeight = `${document.documentElement.clientHeight}`
            window.onresize = function temp() {
                this.windowHeight = `${document.documentElement.clientHeight}`;
            };
        },
        watch: {
            windowHeight: function () {
                this.changeFixed(this.windowHeight)
            }
        },
        methods: {
            changeFixed(windowHeight) {

                var navHeight = this.getDomHeight("nav");

                var iframeHeight = windowHeight - 16 - navHeight ;

                this.$refs.iframeContent.style.height = iframeHeight + 'px';

            },
            getDomHeight(id){
                var h = window.getComputedStyle(document.getElementById(id)).height;
                return Number.parseInt(h.replace("px",""));
            }
        }
    }
</script>

<style>
    body {
        height: 100%;
    }

    .dashboard {
        display: flex;
    }

    .menu {
        with: 230px;
        padding: 10px 10px 0 10px;
    }

    .content {
        flex: 1;
    }

    #iframe-content {
        width: 100%;
        height: auto;
        border: none;
    }
</style>
