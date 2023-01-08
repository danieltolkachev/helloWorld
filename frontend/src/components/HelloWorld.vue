<template>
  <table class="table table-light">
    <thead class="thead-light">
    <tr>
      <th scope="col">titel</th>
      <th scope="col">description</th>
      <th scope="col">date</th>
      <th scope="col">priority</th>
      <th scope="col">finished</th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="task in tasks" :key="task.id">
      <td>{{task.titel}}</td>
      <td>{{task.description}}</td>
      <td>{{task.date}}</td>
      <td>{{task.priority ? 'Ja' : 'Nein'}}</td>
      <td>{{task.finished ? 'erledigt' : 'nicht erledigt'}}</td>
    </tr>
    </tbody>
  </table>
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
