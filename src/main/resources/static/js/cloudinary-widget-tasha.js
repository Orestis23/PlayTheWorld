/**
 * 
 */
 	
   var myWidget = cloudinary.applyUploadWidget(document.getElementById('opener'), 
  { cloudName: "${name}", uploadPreset: "${preset}" }, (error, result) => {
	 console.log("start")
	
	 if(result.event === 'success'){
         console.log(result.info.url);
         window.location.assign("uploadurl?imageURL=" + result.info.url);
     }
	  });
	
function upload(){
	
myWidget.open();
} 
// cloudinary.openUploadWidget({
//	  cloudName: "${name}", uploadPreset: "${preset}" }, (error, result) => { }); 

 
// // Customized upload widget  
//	function showUploadWidget() { cloudinary.openUploadWidget({ cloudName: "${name}", uploadPreset:"${preset}",
//	sources: [ "local", "url", "camera", "image_search", "facebook", "dropbox", "instagram" ],showAdvancedOptions: true, cropping: true, multiple: false,
//	defaultSource: "local", styles: { palette: { window: "#464040", sourceBg: "#292222", windowBorder: "#c7a49f", tabIcon: "#cc6600",
//	inactiveTabIcon: "#E8D5BB", menuIcons: "#ebe5db", link: "#ffb107", action: "#ffcc00", inProgress: "#99cccc", complete: "#78b3b4", error:
//	"#ff6666", textDark: "#4C2F1A", textLight: "#D8CFCF" }, fonts: {default: null, "'Kalam', cursive": { url:
//	"https://fonts.googleapis.com/css?family=Kalam", active: true } } }}, (err, info) => { if (!err) { console.log("Upload Widget event - ",
//	info);
//	}
//	});
//	} 