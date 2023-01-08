<template>
  <body> </body>
  <html style="background-color: rgba(56,91,102,255);width: 100%; height: 100%;">
  <a><img src="https://i.ibb.co/4NTr7xT/logo.png" alt="logo" style="width: 15%; height: 10%;"></a>
  <nav>
    <router-link to="/">Tasks</router-link> |
    <router-link to="/about">About</router-link>
  </nav>
  <router-view/>
  </html>
</template>

<style>
nav {
  background-color: rgba(189,218,165,255);
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
  background-color: rgba(56,91,102,255);
  color: rgba(189,218,165,255);
}
</style>
