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
console.log("ASDASDASDASD");
function searchCheck() {
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