<template>
    <div>
        <h1> Hello Warun</h1>
        <h2 v-if="show"> My Name Is:: {{data}}</h2>
        <button v-on:click="hello1(var1)" > Click on</button>
    </div>
</template>

<script>
//import { defineComponent } from '@vue/composition-api'

export default {
    name:"MyHome",
    props:{
        data:String,
        msg: String,
        var1:String,
    },
    methods:{
        hello1(var1){
           alert(var1);
        }
    },
    data(){
        return {
            show:false
            }
        
    }
};
</script>

