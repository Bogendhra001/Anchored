<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Anchored - Streamlining Sailor and Boat Data Entry</title>
        <link rel="stylesheet" href="styles1.css">
    </head>
    <body>
        <div class="header">
            <div class="pro-title">
                <h2>Login to Anchored</h2>
            </div>
            <div class="middle-lane">
                
            </div>
            <div class="logout-section">
                
            </div>
        </div>
        <div class="container">
            <form class="login-section" action="url-authen">
                <div class="login-content">
                    <h2 class="add-remove-title">Username</h2>
                    <input type="text" placeholder="Enter your username: " class="add-inp login-inp-field" name="usern">
                    <h2 class="add-remove-title">Password</h2>
                    <input type="password" placeholder="Enter your password: " class="add-inp login-inp-field" name="pwd">
                    <!-- <br> -->
                </div>
                <div class="submit-field">
                    <input type="submit" value="Login" class="login-btn-form">
                </div>
            </form>
        </div>
    </body>
</html>