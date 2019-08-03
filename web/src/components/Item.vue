<template>
    <div class="ivu-cell ivu-cell-with-link" :class="(selected === id+group)?'ivu-cell-selected':''">
        <a :href="'books/'+id+'/'+group+'.html'" :target="target" class="ivu-cell-link" @click="$emit('click',id,group)">
            <div class="ivu-cell-item">
                <div class="ivu-cell-main">
                    <div class="ivu-cell-title">{{ group }}</div>
                    <div class="ivu-cell-label"></div>
                </div>
                <div v-if="badge" class="ivu-cell-footer">
                    <span class="ivu-cell-extra">
                        <span class="ivu-badge-status ivu-badge">
                            <span :class="badge?'ivu-badge-status-'+badge:''" class="ivu-badge-status-dot"></span>
                            <span class="ivu-badge-status-text"></span>
                        </span>
                    </span>
                </div>
            </div>
        </a>
        <div class="ivu-cell-arrow"><i class="ivu-icon ivu-icon-ios-arrow-forward"></i></div>
    </div>
</template>
<script>
    export default {
        name: 'Item',
        props: ['id', 'group', 'target', 'selected', 'badge'],
        data: function () {
            return {
                count: 0
            }
        }
    }
</script>