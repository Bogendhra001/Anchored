function sailorOptCheck() {
    var selectedOpt = document.getElementById('sailor-add-remove').value;
    if (selectedOpt == 'add') {
        document.getElementById('sailor-remove').style.display = 'none';
        document.getElementById('sailor-add').style.display = 'block';
    } else if (selectedOpt == 'remove') {
        document.getElementById('sailor-remove').style.display = 'block';
        document.getElementById('sailor-add').style.display = 'none';
    }
}

function boatOptCheck() {
    var selectedOpt = document.getElementById('boat-add-remove').value;
    if (selectedOpt == 'add') {
        document.getElementById('boat-remove').style.display = 'none';
        document.getElementById('boat-add').style.display = 'block';
    } else if (selectedOpt == 'remove') {
        document.getElementById('boat-remove').style.display = 'block';
        document.getElementById('boat-add').style.display = 'none';
    }
}

function valSailor() {
    var selectedOpt = document.getElementById('sailor-add-remove').value;
    if (selectedOpt == 'add') {
        var sailorName = document.getElementById('sailor-name').value;
        var sailorAge = document.getElementById('sailor-age').value;
        var sailorRating = document.getElementById('sailor-rating').value;

        var query = `INSERT INTO SAILORS VALUES(${String(Math.round(Math.random() * 100))}, \'${sailorName}\', ${sailorAge}, ${sailorRating});`;
        console.log(query);
    } else if (selectedOpt == 'remove') {
        var sailorId = document.getElementById('sailor-id').value;

        var query = `DELETE FROM SAILORS WHERE SID=${sailorId};`;
        console.log(query);
    }
}

function valBoat() {
    var selectedOpt = document.getElementById('boat-add-remove').value;
    if (selectedOpt == 'add') {
        var boatName = document.getElementById('boat-name').value;
        var boatColor = document.getElementById('boat-color').value;

        var query = `INSERT INTO BOATS VALUES(${String(Math.round(Math.random() * 100))}, \'${boatName}\', \'${boatColor}\');`;
        console.log(query);
    } else if (selectedOpt == 'remove') {
        var boatId = document.getElementById('boat-id').value;

        var query = `DELETE FROM BOATS WHERE BID=${boatId};`;
        console.log(query);
    }
}

function valReserve() {
    var sailorId = document.getElementById('sailor-id-res').value;
    var boatId = document.getElementById('boat-id-res').value;

    var query = `INSERT INTO RESERVES VALUES(${sailorId}, ${boatId}, \'${getToday()}\');`;
    console.log(query);
}

function getToday() {
    const date = new Date();
    const formattedDate = date.toLocaleDateString('en-GB', {day: 'numeric', month: 'short', year: 'numeric'}).replace(/ /g, '/');
    return formattedDate;
}


function logout(){
			return(window.location.href = "Login.jsp");
}

function searchCheck(){
	var selectedOpt = document.getElementById('res-search-check').value;
	if (selectedOpt == 'sailors') {
		document.getElementById('boat-id-view').style.display = 'none';
		document.getElementById('res-id-view').style.display = 'none';
		document.getElementById('sailor-id-view').style.display = 'block';	
	} else if (selectedOpt == 'boats') {
		document.getElementById('boat-id-view').style.display = 'block';
		document.getElementById('res-id-view').style.display = 'none';
		document.getElementById('sailor-id-view').style.display = 'none';	
	} else if (selectedOpt == 'reserves') {
		document.getElementById('boat-id-view').style.display = 'none';
		document.getElementById('res-id-view').style.display = 'block';
		document.getElementById('sailor-id-view').style.display = 'none';	
	}
}

