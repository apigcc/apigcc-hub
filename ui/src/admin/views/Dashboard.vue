<template>
    <div class="dashboard">
        <b-container>
            <b-row>
                <b-col md="4">
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
                            <b-list-group-item href="#">service-car</b-list-group-item>
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
                </b-col>
                <b-col md="8">
                    <div class="mb-3">
                        <h5>Activities</h5>
                    </div>
                    <div>
                        <b-media class="mb-3">
                            <b-img rounded slot="aside" blank blank-color="#ccc" width="64" alt="placeholder"></b-img>
                            <h5 class="mt-0">Media Title</h5>
                            <p class="mb-1">
                                Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante
                                sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.
                                Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis
                                in faucibus.
                            </p>
                            <span class="text-secondary">2018-12-13 15:18</span>
                        </b-media>
                        <b-media class="mb-3">
                            <b-img rounded slot="aside" blank blank-color="#ccc" width="64" alt="placeholder"></b-img>
                            <h5 class="mt-0">Media Title</h5>
                            <p class="mb-1">
                                Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante
                                sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.
                                Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis
                                in faucibus.
                            </p>
                            <span class="text-secondary">2018-12-13 15:18</span>
                        </b-media>
                    </div>
                    <div>
                        <b-link>load more</b-link>
                    </div>

                </b-col>
            </b-row>
        </b-container>


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

<style>
    .dashboard{
        padding: 20px;
    }
    @media (min-width: 992px) {
        .content{
            width: 992px;
            margin:0 auto;
        }
    }
    .el-card .fa-icon{
        color: #6a737d;
        margin-right:5px;
    }
    .projects>.el-col{
        margin-top: 10px;
    }
</style>
