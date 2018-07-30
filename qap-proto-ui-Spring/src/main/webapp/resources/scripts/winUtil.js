/**
* Funciones para recuperar el tamaño de la ventana.
* http://stackoverflow.com/questions/2474009/browser-size-width-and-height 	
*/
 	 
function winHeight() {
    return document.all ? document.body.clientHeight - 152 : window.innerHeight - 152 ;
}

function autoWinHeight() {
    //var combo = document.getElementById("configForm:inputTemplate");
    //combo.value = "max-"+winHeight();     
    var template = document.getElementById("areaForm:hiddenTemplate");
    var area = document.getElementById("areaForm:hiddenArea");
    template.value = "qap_template";
    area.value = winHeight();     
}