<template>
    <div class="namespaces">
        <b-container>
            <div class="pt-3">
                <b-button variant="success" v-b-modal.createModal>添加</b-button>
            </div>
            <div class="pt-3">
                <b-table :fields="fields" :items="items">
                    <template slot="op" slot-scope="row">
                        <b-button variant="link" size="sm" class="mr-1"><i class="iconfont icon-garbage" /></b-button>
                    </template>
                </b-table>
            </div>
        </b-container>

        <b-modal id="createModal" title="添加新成员">
            <b-form>
                <b-form-group label="用户名">
                    <b-form-input type="text" v-model="form.username" required />
                </b-form-group>
            </b-form>

        </b-modal>

    </div>
</template>

<script>
    export default {
        name: 'Namespaces',
        data() {
            return {
                form: {
                    username: '',
                },
                fields: ["namespace","username","name","op"],
                items: [
                    { namespace:'1byongche',username : 'wangzhe' , name: '王哲' }
                ],
            }
        },
        methods : {
        }
    }
</script>

<style>

</style>
