<?php
   $host = "localhost";
   $username ="id15032554_nhbthach";
   $password ="Giabaovip123#";
   $database = "id15032554_product";

   $conn = mysqli_connect($host,$username,$password,$database);
   mysqli_query($conn,"SET NAMES 'utf8'");
   mysqli_set_charset($conn, 'utf8');
   
?>