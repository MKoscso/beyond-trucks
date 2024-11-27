<template>
  <form @submit.prevent="handleSubmit">
    <label>Name:</label>
    <input v-model="student.name" required />

    <label>Age:</label>
    <input type="number" v-model="student.age" required />

    <label>Sexuality:</label>
    <select v-model="student.sexuality">
      <option>Male</option>
      <option>Female</option>
      <option>Other</option>
    </select>

    <button type="submit">{{ isEdit ? 'Update' : 'Add' }} Student</button>
  </form>
</template>

<script>
export default {
  props: ['student', 'isEdit'],
  methods: {
    handleSubmit() {
      this.$emit('complete', this.student);
    },
  },
};
</script>

<style scoped>
form {
  display: flex;
  flex-direction: column;
  gap: 10px;
  margin-top: 20px;
}
label {
  font-weight: bold;
}
input,
select,
button {
  padding: 5px;
}
</style>
