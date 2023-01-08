<template>
  <html style="background-color: white;">
  <a><img src="https://i.ibb.co/5GHCzJY/Do-IT-removebg-preview.png" alt="Do-IT-removebg-preview" style="width: 15%; height: 10%;"></a>
  <nav>
    <router-link to="/">Tasks</router-link> |
    <router-link to="/about">About</router-link>
  </nav>
  <router-view/>
  </html>
</template>

<style>
nav {
  background-color: wheat;
  display: compact;
  justify-content: space-between;
}
nav a {
  color: black;
  text-decoration: none;
  font-size: 18px;
  padding: 10px 20px;
}
nav a:hover {
  background-color: black;
  color: wheat;
}
</style>
