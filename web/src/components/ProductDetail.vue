<style scoped>
    table,tr,td{
        background: none;
        border: none;
    }
    table{
        width:100%;
    }
    td{
        padding: 5px 0 0 5px;
        height: auto;
    }
</style>

<template>
    <div>
        <table>
            <col width="120"></col>
            <tr>
                <td>Source: </td>
                <td>{{ row.source }}</td>
            </tr>
            <tr>
                <td>Dependency: </td>
                <td>{{ row.dependency }}</td>
            </tr>
            <tr>
                <td>Build Hook: </td>
                <td>{{ row.buildUrl }}</td>
            </tr>
            <tr>
                <td>Git: </td>
                <td>{{ row.git }}</td>
            </tr>
            <tr>
                <td>Commit: </td>
                <td>
                    {{ row.gitCommitMessage }}
                    <code :style="{fontWeight:'bolder',maxWidth:'60px',overflow:'hidden'}">{{ row.gitCommitId }}</code>
                </td>
            </tr>
            <tr>
                <td>Build Time: </td>
                <td><Time :time="new Date(row.buildTime)" /></td>
            </tr>
            <tr>
                <td>msg: </td>
                <td><span :style="{color: '#ba3925'}">{{ row.msg }}</span></td>
            </tr>
        </table>
    </div>
</template>
<script>
    export default {
        props: {
            row: Object
        }
    };
</script>