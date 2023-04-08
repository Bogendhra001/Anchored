<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>WAD Mini project</title>
        <link rel="stylesheet" href="styles1.css">
    </head>
    <body>
        <div class="container">
            <nav class="header">
                <h2>WAD Mini Project</h2>
            </nav>
            <div class="content">
                <form class="sailor-section" action="url-addsailors" method="post">
                    <h2 class="add-remove-title">Add/Remove a Sailor: </h2>
                    <div class="sailor-settings">
                        <select onchange="sailorOptCheck()" name="add-remove" id="sailor-add-remove" class="add-remove">
                            <option value="add">Add</option>
                            <option value="remove">Remove</option>
                        </select>
                        <div class="add-section" id="sailor-add">
                            <input type="text" class="add-inp" placeholder="Enter name to add:" id="sailor-name" name="name">
                            <input type="text" class="add-inp" placeholder="Enter Age:" id="sailor-age" name="age">
                            <input type="text" class="add-inp" placeholder="Enter Rating:" id="sailor-rating"  name ="rating">
                        </div>
                        <div class="remove-section" id="sailor-remove">
                            <input type="text" class="remove-inp" placeholder="Enter id to remove:" id="sailor-id" name = "id">
                        </div>
                        <!-- <button class="submit-btn" onclick="valSailor()">Submit</button> -->
                        <input type="submit" value="Submit" class="submit-btn">
                    </div>
                </form>
                <hr>
                <form class="boat-section" action="url-addboat" method="post">
                    <h2 class="add-remove-title">Add/Remove a Boat: </h2>
                    <div class="boat-settings">
                        <select onclick="boatOptCheck()" name="add-remove" id="boat-add-remove" class="add-remove">
                            <option value="add">Add</option>
                            <option value="remove">Remove</option>
                        </select>
                        <div class="add-section" id="boat-add">
                            <input type="text" class="add-inp" placeholder="Enter name to add:" id="boat-name" name="name">
                            <input type="text" class="add-inp" placeholder="Enter color:" id="boat-color" name="color">
                        </div>
                        <div class="remove-section" id="boat-remove">
                            <input type="text" class="remove-inp" placeholder="Enter id to remove:" id="boat-id" name="id">
                        </div>
                        <!-- <button class="submit-btn" onclick="valBoat()">Submit</button> -->
                        <input type="submit" value="Submit" class="submit-btn">
                    </div>
                </form>
                <hr>
                <form class="reserve-section" action="url-reserve" method="post">
                    <h2 class="add-remove-title">Reserve a Boat: </h2>
                    <div class="reserve-settings">
                        <div class="reserve-section" id="reserve-section">
                            <input type="text" class="add-inp" placeholder="Enter sailor id:" id="sailor-id-res" name="sid">
                            <input type="text" class="add-inp" placeholder="Enter boat id:" id="boat-id-res" name="bid">
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