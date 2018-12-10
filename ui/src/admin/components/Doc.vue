<template>

    <el-container>
        <el-aside class="projects">
            <el-dropdown>
                <span class="el-dropdown-link">
                1byongche<i class="el-icon-arrow-down el-icon--right"></i>
                </span>
                <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item>hcd</el-dropdown-item>
                    <el-dropdown-item>service-car</el-dropdown-item>
                    <el-dropdown-item>wangzhe</el-dropdown-item>
                </el-dropdown-menu>
            </el-dropdown>
            <el-tree :data="data" :props="defaultProps" @node-click="handleNodeClick"></el-tree>
        </el-aside>
        <el-main>
        </el-main>
        <el-aside class="toc">
            <el-card class="box-card">
                <div slot="header" class="clearfix">
                    <span>用户服务</span>
                </div>
                <el-tree :data="data" :props="defaultProps" @node-click="handleNodeClick"></el-tree>
            </el-card>
        </el-aside>
    </el-container>

</template>

<script>
    export default {
        name: 'Doc',
        data() {
            return {
                data: [{
                    label: '一级 1',
                    children: [{
                        label: '二级 1-1',
                        children: [{
                            label: '三级 1-1-1'
                        }]
                    }]
                }, {
                    label: '一级 2',
                    children: [{
                        label: '二级 2-1',
                        children: [{
                            label: '三级 2-1-1'
                        }]
                    }, {
                        label: '二级 2-2',
                        children: [{
                            label: '三级 2-2-1'
                        }]
                    }]
                }, {
                    label: '一级 3',
                    children: [{
                        label: '二级 3-1',
                        children: [{
                            label: '三级 3-1-1'
                        }]
                    }, {
                        label: '二级 3-2',
                        children: [{
                            label: '三级 3-2-1'
                        }]
                    }]
                }],
                defaultProps: {
                    children: 'children',
                    label: 'label'
                }
            };
        },
        methods: {
            handleNodeClick(data) {
                console.log(data);
            }
        }
    }
</script>

<style scoped>

    .projects{
        background-color: #fafafa;
        position: absolute;
        left: 0;
        top: 0;
        bottom: 0;
        z-index: 32;
        padding: 60px 20px;
    }
    .toc{
        padding: 20px;
    }

</style>
