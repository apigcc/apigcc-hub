<template>
    <div class="projects">
        <b-container>
            <div class="pt-3">
                <b-button variant="success" v-b-modal.createModal>创建</b-button>
            </div>
            <div class="pt-3">
                <b-table :fields="fields" :items="items">
                    <template slot="doc" slot-scope="row">
                        <b-button variant="link" size="sm" class="mr-2"><i class="iconfont icon-see" /></b-button>
                    </template>
                    <template slot="webhook" slot-scope="row">
                        <b-button variant="link" size="sm" class="mr-2"><i class="iconfont icon-see" /></b-button>
                    </template>
                    <template slot="op" slot-scope="row">
                        <b-button variant="link" size="sm" class="mr-1"><i class="iconfont icon-Hammer"/></b-button>
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

                <b-form-group label="Git">
                    <b-form-input type="text" v-model="form.git" required />
                </b-form-group>

                <b-form-group label="Git user">
                    <b-form-input type="text" v-model="form.gitUser" required />
                </b-form-group>

                <b-form-group label="Git password">
                    <b-form-input type="password" v-model="form.gitPassword" required />
                </b-form-group>

            </b-form>

        </b-modal>

        <b-modal id="createModal" title="创建项目">
            <b-form>
                <b-form-group label="标识" description="标识不能修改">
                    <b-form-input type="text" v-model="form.id" required />
                </b-form-group>

                <b-form-group label="名称">
                    <b-form-input type="text" v-model="form.name" required />
                </b-form-group>

                <b-form-group label="Git">
                    <b-form-input type="text" v-model="form.git" required />
                </b-form-group>

                <b-form-group label="Git user">
                    <b-form-input type="text" v-model="form.gitUser" required />
                </b-form-group>

                <b-form-group label="Git password">
                    <b-form-input type="password" v-model="form.gitPassword" required />
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
                    git: '',
                    gitUser: '',
                    gitPassword: '',
                },
                fields: ["namespace" , "id","name","doc","webhook","op"],
                items: [
                    { namespace:'1byongche',id : '1byongche' , name: '一步用车后端' }
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
