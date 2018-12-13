<template>
    <div class="doc">

        <b-container fluid>

            <b-row>
                <b-col md="2" class="pt-3">
                    <h5>
                        <b-link class="text-dark">1byongche</b-link>
                        /
                        <b-link class="text-dark">service-user</b-link>
                    </h5>
                    <dl>
                        <dd><b-link class="text-muted">1 说明</b-link></dd>
                        <dd>
                            <b-link class="text-muted">2 附录</b-link>
                            <dl>
                                <dd>
                                    <b-link class="text-muted">2.1 响应码</b-link>
                                </dd>
                                <dd>
                                    <b-link class="text-muted">2.2 请求字典</b-link>
                                </dd>
                            </dl>
                        </dd>
                        <dd>
                            <b-link class="text-muted">3 app</b-link>
                            <dl>
                                <dd>
                                    <b-link class="text-muted">3.1 用户</b-link>
                                    <dl>
                                        <dd>
                                            <b-link class="text-muted">3.1.1 用户注册</b-link>
                                        </dd>
                                        <dd>
                                            <b-link class="text-muted">3.1.2 用户登录</b-link>
                                        </dd>
                                    </dl>
                                </dd>
                                <dd>
                                    <b-link class="text-muted">3.2 订单</b-link>
                                </dd>
                                <dd>
                                    <b-link class="text-muted">3.3 车辆</b-link>
                                </dd>
                            </dl>
                        </dd>

                    </dl>
                </b-col>
                <b-col md="10" class="pt-3">

                        <div class="doc">
                            <div class="doc-section">
                                <h1>用户服务service-user</h1>
                                <p>用Jenkins 实现java工程自动编译发布的方法如下: 1. 在...为了做自动化发布系统,其中流程就是java调用Jenkins的远程api实现Jenkins的build</p>
                            </div>
                            <div class="doc-section">
                                <h2>1 说明</h2>
                                <p>用Jenkins 实现java工程自动编译发布的方法如下: 1. 在...为了做自动化发布系统,其中流程就是java调用Jenkins的远程api实现Jenkins的build</p>
                            </div>
                            <div class="doc-section">
                                <h2>2 附录</h2>
                                <h3>2.1 响应码</h3>
                                <h3>2.2 请求字典</h3>
                            </div>
                            <div class="doc-section">
                                <h2>3 app</h2>
                                <div class="list">
                                    <div class="item">
                                        <h3>3.1 用户</h3>
                                        <p>用Jenkins 实现java工程自动编译发布的方法如下: 1. 在...为了做自动化发布系统,其中流程就是java调用Jenkins的远程api实现Jenkins的build</p>
                                        <div class="list">

                                            <!-- item start -->
                                            <div class="item">
                                                <h4>3.1.1 用户注册</h4>
                                                <p>用Jenkins 实现java工程自动编译发布的方法如下: 1. 在...为了做自动化发布系统,其中流程就是java调用Jenkins的远程api实现Jenkins的build</p>
                                                <!-- block request -->
                                                <div class="mb-3">
                                                    <div class="tag">请求</div>
                                                    <table class="request-info">
                                                        <tr>
                                                            <td>URI</td>
                                                            <td>/greeting</td>
                                                        </tr>
                                                        <tr>
                                                            <td>请求方法</td>
                                                            <td>GET</td>
                                                        </tr>
                                                    </table>
                                                    <div class="p-3 mt-3 mb-3 bg-light rounded"><pre class="mb-0">GET /greeting?name=apigcc HTTP/1.1</pre></div>
                                                    <table>
                                                        <thead>
                                                        <tr>
                                                            <th>名称</th>
                                                            <th>类型</th>
                                                            <th>校验</th>
                                                            <th>默认值</th>
                                                            <th>描述</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <tr>
                                                            <td>name</td>
                                                            <td>String</td>
                                                            <td></td>
                                                            <td>apigcc</td>
                                                            <td>名称</td>
                                                        </tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                                                <!-- block request -->

                                                <!-- block response -->
                                                <div class="mb-3">
                                                    <div class="tag">响应</div>
                                                    <div class="p-3 mt-3 mb-3 bg-light rounded"><pre class="mb-0">HTTP/1.1 200 OK

    {
    "id" : 0,
    "content" : ""
    }</pre></div>
                                                    <table>
                                                        <thead>
                                                        <tr>
                                                            <th>名称</th>
                                                            <th>类型</th>
                                                            <th>校验</th>
                                                            <th>默认值</th>
                                                            <th>描述</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <tr>
                                                            <td>id</td>
                                                            <td>long</td>
                                                            <td></td>
                                                            <td>0</td>
                                                            <td>编号</td>
                                                        </tr>
                                                        <tr>
                                                            <td>content</td>
                                                            <td>String</td>
                                                            <td></td>
                                                            <td></td>
                                                            <td>内容</td>
                                                        </tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                                                <!-- block response -->

                                            </div>
                                            <!-- item end -->

                                            <!-- item start -->
                                            <div class="item">
                                                <h4>3.1.1 用户注册</h4>
                                                <p>用Jenkins 实现java工程自动编译发布的方法如下: 1. 在...为了做自动化发布系统,其中流程就是java调用Jenkins的远程api实现Jenkins的build</p>
                                                <!-- block request -->
                                                <div class="mb-3">
                                                    <div class="tag">请求</div>
                                                    <table class="request-info">
                                                        <tr>
                                                            <td>URI</td>
                                                            <td>/greeting</td>
                                                        </tr>
                                                        <tr>
                                                            <td>请求方法</td>
                                                            <td>GET</td>
                                                        </tr>
                                                    </table>
                                                    <div class="p-3 mt-3 mb-3 bg-light rounded"><pre class="mb-0">GET /greeting?name=apigcc HTTP/1.1</pre></div>
                                                    <table>
                                                        <thead>
                                                        <tr>
                                                            <th>名称</th>
                                                            <th>类型</th>
                                                            <th>校验</th>
                                                            <th>默认值</th>
                                                            <th>描述</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <tr>
                                                            <td>name</td>
                                                            <td>String</td>
                                                            <td></td>
                                                            <td>apigcc</td>
                                                            <td>名称</td>
                                                        </tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                                                <!-- block request -->

                                                <!-- block response -->
                                                <div class="mb-3">
                                                    <div class="tag">响应</div>
                                                    <div class="p-3 mt-3 mb-3 bg-light rounded"><pre class="mb-0">HTTP/1.1 200 OK

    {
    "id" : 0,
    "content" : ""
    }</pre></div>
                                                    <table>
                                                        <thead>
                                                        <tr>
                                                            <th>名称</th>
                                                            <th>类型</th>
                                                            <th>校验</th>
                                                            <th>默认值</th>
                                                            <th>描述</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <tr>
                                                            <td>id</td>
                                                            <td>long</td>
                                                            <td></td>
                                                            <td>0</td>
                                                            <td>编号</td>
                                                        </tr>
                                                        <tr>
                                                            <td>content</td>
                                                            <td>String</td>
                                                            <td></td>
                                                            <td></td>
                                                            <td>内容</td>
                                                        </tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                                                <!-- block response -->

                                            </div>
                                            <!-- item end -->

                                            <div class="item">
                                                <h4>3.1.2 用户注册</h4>
                                                <p>用Jenkins 实现java工程自动编译发布的方法如下: 1. 在...为了做自动化发布系统,其中流程就是java调用Jenkins的远程api实现Jenkins的build</p>
                                                <div class="block">
                                                    <div class="tag">请求</div>
                                                    <table class="request-info">
                                                        <tr>
                                                            <td>URI</td>
                                                            <td>/greeting</td>
                                                        </tr>
                                                        <tr>
                                                            <td>请求方法</td>
                                                            <td>GET</td>
                                                        </tr>
                                                    </table>
                                                    <pre data-lang="HTTP">GET /greeting?name=apigcc HTTP/1.1</pre>
                                                    <table>
                                                        <thead>
                                                        <tr>
                                                            <th>名称</th>
                                                            <th>类型</th>
                                                            <th>校验</th>
                                                            <th>默认值</th>
                                                            <th>描述</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <tr>
                                                            <td>name</td>
                                                            <td>String</td>
                                                            <td></td>
                                                            <td>apigcc</td>
                                                            <td>名称</td>
                                                        </tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                                                <div class="block">
                                                    <div class="tag">响应</div>
                                                    <pre data-lang="HTTP">HTTP/1.1 200 OK

    {
    "id" : 0,
    "content" : ""
    }</pre>
                                                    <table>
                                                        <thead>
                                                        <tr>
                                                            <th>名称</th>
                                                            <th>类型</th>
                                                            <th>校验</th>
                                                            <th>默认值</th>
                                                            <th>描述</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <tr>
                                                            <td>id</td>
                                                            <td>long</td>
                                                            <td></td>
                                                            <td>0</td>
                                                            <td>编号</td>
                                                        </tr>
                                                        <tr>
                                                            <td>content</td>
                                                            <td>String</td>
                                                            <td></td>
                                                            <td></td>
                                                            <td>内容</td>
                                                        </tr>
                                                        </tbody>
                                                    </table>
                                                </div>

                                            </div>

                                        </div>

                                    </div>
                                </div>
                            </div>


                        </div>

                </b-col>
            </b-row>

        </b-container>
    </div>

</template>

<script>
    export default {
        name: 'Doc',
        data() {
            return {
            };
        },
        methods: {
        }
    }
</script>

<style scoped>

    .tag{
        font-size: .8em;
        margin-bottom: 5px;
    }

    .request-info tr>td:first-child{
        width: 100px;
    }


    table{
        border: 1px solid #dedede;
        max-width: 100%;
        border-collapse: separate;
        border-spacing: 0;
        width: 100%;
    }

    table tr>td,table tr>th{
        padding: .5em .625em .625em;
        border-right: 1px solid #dedede;
        border-bottom: 1px solid #dedede;
        text-align: left;
    }
    table tr:last-child>td{
        border-bottom: none;
    }
    table tr>td:last-child{
        border-right: none;
    }
    table>tr:nth-of-type(odd),table>thead>tr:nth-of-type(odd),table>tbody>tr:nth-of-type(even){
        background: #f8f8f7;
    }

    dl dl{
        margin-left:20px;
    }
    dl,dd{
        margin-bottom: 0;
    }

    .doc-section{
        border-bottom: 1px solid #ddddd8;
        padding-bottom: 8px;
        margin-bottom: 12px;
    }

</style>
