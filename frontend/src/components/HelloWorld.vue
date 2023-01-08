<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      tasks: []
    }
  },
  mounted () {
    const endpoint = 'http://localhost:8080/api/v1/todo'
    console.log(endpoint)
    const requestOptions = {
      method: 'GET',
      redirect: 'follow'
    }
    fetch(endpoint, requestOptions)
      .then(response => response.json())
      .then(result => result.forEach(task => {
        this.tasks.push(task)
      }))
      .then(error => console.log('error', error))
  }
}
</script>

<style scoped>

</style>
