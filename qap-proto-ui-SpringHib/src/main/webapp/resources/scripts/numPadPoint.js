/**
* Funciones para añadir una coma cuando se pulsa la tecla del punto del teclado
* numérico.
* http://enlosdetalles.net/2011/05/comatecladonumerico.html 	
*/
 	 
function _replaceSelectedVal(input, text) {
        if ('selectionStart' in input) {
                var start = input.selectionStart + 1;

                input.value = input.value.substr(0, input.selectionStart) + text
                        + input.value.substr(input.selectionEnd, input.value.length);

                input.selectionStart = start;
                input.selectionEnd = start;
                input.focus();
        } else if (document.selection) {
                input.focus();
                var sel = document.selection.createRange();
                sel.text = text;
                // Move selection start and end to 0 position
                sel.moveStart('character', -input.value.length);

                // Move selection start and end to desired position
                sel.moveStart('character', sel.text.length);
                sel.moveEnd('character', 0);
                sel.select();
        } else {
        input.value += text;
        }
}

/**
* La tecla del punto del teclado numérico tiene el código 110 (por lo menos en
* firefox y IE)
*/
function _numericPadPeriodPressed(keydownCode) {
        return 110 == keydownCode;
}

/**
* Función que se llama en el evento keyDown del input para guardar el keyCode
* de la tecla pulsada.
*/
function setLastkeyCode(input, e) {
        input.lastKeyCode = e.keyCode;
}

/**
* Función que se llama en el keyPress del input y añade la coma si se ha
* pulsado el punto del teclado numérico.
*/
function changeNumericPadPeriod(input, e) {
        if (_numericPadPeriodPressed(input.lastKeyCode) && !e.shiftKey
                && !e.ctrlKey && !e.altKey) {
                _replaceSelectedVal(input, ",");

                /* Stops all propagation of the event in the bubbling phase. */ 
                e.cancelBubble = true; //Microsoft model 
                if (e.stopPropagation) e.stopPropagation(); //W3C model 
                return false;
        }
        return true;
}