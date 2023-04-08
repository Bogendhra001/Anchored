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
                <h2>Anchored</h2>
            </div>
            <div class="middle-lane">
                
            </div>
            <div class="logout-section">
                <button onclick="logout()">Logout</button>
            </div>
        </div>
        <div class="container">
            <div class="content">
                <form class="sailor-section" action="url-addsailors" method="post">
                    <h2 class="add-remove-title">Add/Remove a Sailor: </h2>
                    <div class="sailor-settings">
                        <select onchange="sailorOptCheck()" name="add-remove" id="sailor-add-remove" class="add-remove">
                            <option value="add">Add</option>
                            <option value="remove">Remove</option>
                        </select>
                        <div class="add-section" id="sailor-add">
                            <input type="text" class="add-inp" placeholder="Enter name to add:" name="name" id="sailor-name">
                            <input type="text" class="add-inp" placeholder="Enter Age:" name="age" id="sailor-age">
                            <input type="text" class="add-inp" placeholder="Enter Rating:" name="rating" id="sailor-rating">
                        </div>
                        <div class="remove-section" id="sailor-remove">
                            <input type="text" class="remove-inp" placeholder="Enter id to remove:" name="id" id="sailor-id">
                        </div>
                        <input type="submit" value="Submit" class="submit-btn">
                    </div>
                    <!-- <p id="sailor-query-info" style="color: red; text-align: center; margin: 4px auto;"></p> -->
                </form>
                <hr>
                    <form class="boat-section" action="url-addboat" method="post">
                        <h2 class="add-remove-title">Add/Remove a Boat: </h2>
                        <div class="boat-settings">
                            <select onchange="boatOptCheck()" name="add-remove" id="boat-add-remove" class="add-remove">
                                <option value="add">Add</option>
                                <option value="remove">Remove</option>
                            </select>
                            <div class="add-section" id="boat-add">
                                <input type="text" class="add-inp" placeholder="Enter name to add:" name="name" id="boat-name">
                                <input type="text" class="add-inp" placeholder="Enter color:" name="color" id="boat-color">
                            </div>
                            <div class="remove-section" id="boat-remove">
                                <input type="text" class="remove-inp" placeholder="Enter id to remove:" name="id" id="boat-id">
                            </div>
                            <input type="submit" value="Submit" class="submit-btn">
                        </div>
                    </form>
                    <hr>
                    <form class="reserve-section" action="url-reserve" method="post">
                        <h2 class="add-remove-title">Reserve a Boat: </h2>
                        <div class="reserve-settings">
                            <div id="reserve-section">
                                <input type="text" class="add-inp" placeholder="Enter sailor id:" name="sid" id="sailor-id-res">
                                <input type="text" class="add-inp" placeholder="Enter boat id:" name="bid" id="boat-id-res">
                            </div>
                            <!-- <button class="submit-btn" onclick="valReserve()">Submit</button> -->
                            <input type="submit" value="Submit" class="submit-btn">
                        </div>
                    </form>
                    <hr>
                    <form class="view-section" action="url-search" method="post">
                        <h2 class="add-remove-title">View details of a Sailor/Boat/Reserves by: </h2>
                        <div class="view-settings">
                            <input type="text" placeholder="Enter keywords to search the db: " class="add-inp search-bar" name="searchBar">
                            <!-- <button class="submit-btn" onclick="valReserve()">Submit</button> -->
                            <input type="submit" value="Submit" class="submit-btn">
                        </div>
                    </form>
            </div>
        </div>
        <script src="script.js"></script>
    </body>
</html>