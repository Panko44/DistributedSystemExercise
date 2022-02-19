<?php

$connect = mysql_connect(“dsexercise”, “hbstudent”, “changeit2”); if (!connect) { die('Connection Failed: ' . mysql_error()); { mysql_select_db(“dsexercise”, $connect);

$user_info = “INSERT INTO citizen(AMKA,fullName,municipalHouse,password,email,address,age)VALUES('$_POST[AMKA]','$_POST[fullName]','$_POST[municipalHouse]','$_POST[password]','$_POST[email]','$_POST[address]','$_POST[age]',)”;
if (!mysql_query($user_info, $connect)){
    die('Error: ' . mysql_error());
}

echo “Your information was added to the database.”;

mysql_close($connect); ?>


