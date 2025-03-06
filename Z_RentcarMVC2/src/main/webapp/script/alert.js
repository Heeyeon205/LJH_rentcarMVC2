function alertAndRedirect(msg, url) {
	console.log("✅ alertAndRedirect 실행됨!");
	    console.log("Message: ", msg);
	    console.log("Redirect URL: ", url);
    alert(msg);
    window.location.href = url;
}

