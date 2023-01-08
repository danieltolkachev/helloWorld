<template>
  <div>
    <button type="button" class="btn btn-success sticky-button" data-bs-toggle="offcanvas"
            data-bs-target="#task-create-offcanvas" aria-controls="#task-create-offcanvas">Add Task
      <i class="bi bi-task-plus-fill"></i>
    </button>
    <div class="offcanvas offcanvas-end" tabindex="-1" id="task-create-offcanvas" aria-labelledby="offcanvas-label">
      <div class="offcanvas-header">
        <h5 id="offcanvas-label">New Task</h5>
        <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
      </div>
      <div class="offcanvas-body">
        <form class="text-start needs-validation" id="tasks-create-form" novalidate>
          <div class="mb-3">
            <label for="first-name" class="form-label">First name</label>
            <input type="text" class="form-control" id="first-name" v-model="title" required>
            <div class="invalid-feedback">
              Please provide the first name.
            </div>
          </div>
          <div class="mb-3">
            <label for="descrpition" class="form-label">Task Description: </label>
            <input type="text" class="form-control" id="description" v-model="description" required>
            <div class="invalid-feedback">
              Please provide the last name.
            </div>
          </div>
          <div class="mb-3">
            <label for="gender" class="form-label">Gender</label>
            <select id="gender" class="form-select" v-model="gender" required>
              <option value="" selected disabled>Choose...</option>
              <option value="MALE">Male</option>
              <option value="FEMALE">Female</option>
              <option value="DIVERSE">Diverse</option>
            </select>
            <div class="invalid-feedback">
              Please select a valid gender.
            </div>
          </div>
          <div class="mb-3">
            <div class="form-check">
              <input class="form-check-input" type="checkbox" id="vaccinated" v-model="favorite">
              <label class="form-check-label" for="vaccinated">
                Vaccinated
              </label>
            </div>
          </div>
          <div v-if="this.serverValidationMessages">
            <ul>
              <li v-for="(message, index) in serverValidationMessages" :key="index" style="color: red">
                {{ message }}
              </li>
            </ul>
          </div>
          <div class="mt-5">
            <button class="btn btn-primary me-3" type="submit" @click.prevent="createTask">Create</button>
            <button class="btn btn-danger" type="reset">Reset</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'TaskCreateForm',
  data () {
    return {
      title: '',
      description: '',
      gender: '',
      favorite: false,
      serverValidationMessages: []
    }
  },

  emits: ['created'],
  methods: {
    async createTask () {
      if (this.validate()) {
        const endpoint = 'http://localhost:8080/api/v1/todo'

        const headers = new Headers()
        headers.append('Content-Type', 'application/json')

        const task = JSON.stringify({
          firstName: this.title,
          lastName: this.description,
          vaccinated: this.favorite,
          gender: this.gender
        })

        const requestOptions = {
          method: 'POST',
          headers: headers,
          body: task,
          redirect: 'follow'
        }

        const response = await fetch(endpoint, requestOptions)
        await this.handleResponse(response)
      }
    },
    async handleResponse (response) {
      if (response.ok) {
        this.$emit('created', response.headers.get('location'))
        document.getElementById('close-offcanvas').click()
      } else if (response.status === 400) {
        response = await response.json()
        response.errors.forEach(error => {
          error.defaultMessage = undefined
          this.serverValidationMessages.push(error.defaultMessage)
        })
      } else {
        this.serverValidationMessages.push('Unknown error occurred')
      }
    },
    validate () {
      const form = document.getElementById('task-create-form')
      form.classList.add('was-validated')
      return form.checkValidity()
    }
  }
}
</script>
<style scoped>
</style>
