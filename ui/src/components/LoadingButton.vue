<template>
    <Button :type="type" :loading="isLoading" :size="size" @click="clickHandle">{{text}}</Button>
</template>
<script>
    export default {
        name: 'LoadingButton',
        props: {
            text: String,
            size: String,
            type: String,
            loading: Boolean,
        },
        data(){
            return {
                isLoading: false,
            }
        },
        methods: {
            clickHandle() {
                this.isLoading = true;
                this.$emit('click',() =>{
                    this.isLoading = false;
                });
            }
        },
        mounted() {
            if(this.loading){
                this.isLoading = true;
            }else{
                this.isLoading = false;
            }
        }
    }
</script>