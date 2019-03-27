<template>
    <div class="namespaces">
        <b-container>
            <div class="pt-3">
                <b-button variant="success" v-b-modal.createModal>创建</b-button>
            </div>
            <div class="pt-3">
                <b-table :fields="fields" :items="items">
                    <template slot="users" slot-scope="row">
                        <b-button href="/users" variant="link" size="sm" class="mr-1">{{row.value}}</b-button>
                    </template>
                    <template slot="op" slot-scope="row">
                        <b-button @click="toggle(row)" variant="link" size="sm" class="mr-1"><i class="iconfont icon-edit" /></b-button>
                        <b-button variant="link" size="sm" class="mr-1"><i class="iconfont icon-garbage" /></b-button>
                    </template>
                </b-table>
            </div>
        </b-container>

        <b-modal ref="editModal" title="编辑信息">
            <b-form>
                <b-form-group label="标识" description="标识全局唯一">
                    <b-form-input type="text" disabled="disabled" v-model="form.id" required />
                </b-form-group>

                <b-form-group label="名称">
                    <b-form-input type="text" v-model="form.name" required />
                </b-form-group>

            </b-form>

        </b-modal>

        <b-modal id="createModal" title="创建空间">
            <b-form>
                <b-form-group label="标识" description="标识不能修改">
                    <b-form-input type="text" v-model="form.id" required />
                </b-form-group>

                <b-form-group label="名称" label-for="exampleInput2">
                    <b-form-input type="text" v-model="form.name" required />
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
                    id: '',
                    name: '',
                },
                fields: ["id","name","projects","users","op"],
                items: [
                    { id : '1byongche' , name: '一步用车后端', projects: 3, users:1 }
                ],
            }
        },
        methods : {
            toggle(){
                this.$refs.editModal.show();
            }
        }
    }
</script>

<style>

</style>
