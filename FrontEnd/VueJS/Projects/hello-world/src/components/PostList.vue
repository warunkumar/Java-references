<template>
    
    <div>
            <label>warun {{var1}}</label>
            <input type="text" ref="name" placeholder="Name Please" v-model="name"/>
            {{name}}
       <button @click="inputTextCheck();getPosts();">Load Posts</button>
       
        <div v-for="post in posts" :key="post.id">
            <h3>{{post.userId}}</h3>
            <h3>{{post.id}}</h3>
            <h3>{{post.title}}</h3>
            <h3>{{post.body}}</h3>


        </div>
    </div>
</template>

<script>
import axios from 'axios';
export default {
    name:"PostList",
    props:{
        data:String,
        msg: String,
        var1:String,
    },
    methods:{
        resetInput() {
            this.$refs["name"].value = "";
        },
        getPosts(){
            
            axios.get('https://jsonplaceholder.typicode.com/posts')
            .then((response)=> {
                console.log(response.data)
                this.posts=response.data
            })
            .catch((error) => {
                this.resetInput(),
                console.log(error)
            })
        },
        inputTextCheck(){
            console.log("Yes")
            this.name=this.name.replace(/[^a-zA-Z'$*\- ]/g, "");
            console.log(this.name);

        }
    },
    data(){
        return {
            name: null,
            posts: [],
            }
        
    }
};
</script>

