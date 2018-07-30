
function syncCondIva(form, condic)
{
    //alert("test2:"+condic);
    //como la actualizacion del combo via js no anda...alerto.
    var comboComprobante = document.getElementById(form.name+":cbComprobante");
    if (condic=='Responsable Inscripto') {
        if (comboComprobante.value!="Factura A") {
            alert("El comprobante para un R. Inscripto debiera ser Factura A");
            //comboComprobante.value="Factura A";        
            //xDisabledSubmit(document.getElementById("ComprobanteEditForm"));
        }
    } else {
        if (comboComprobante.value=="Factura A") {
            alert("El comprobante para un R. No Inscripto no debiera ser Factura A");
            //comboComprobante.value="Factura B";
            //xDisabledSubmit(document.getElementById("ComprobanteEditForm"));
        }         
    }
}

function syncCondVta(form, condic)
{
    //alert("test3b:"+condic);
    var comboPago = document.getElementById(form.name+":cbPago");
    if (condic=='Cta. Cte.') {
        comboPago.value="en Cta. Cte.";
        syncPago(form, comboPago.value);
    } else {
        if (comboPago.value=="en Cta. Cte.") {
            comboPago.value="Efectivo";
            syncPago(form, comboPago.value);
        } 
    }
}

function syncPago(form, pago)
{
    //alert(form.name);
    //var comboEstado = document.getElementById("ComprobanteEditForm:cbEstado");
    var comboEstado = document.getElementById(form.name+":cbEstado");
    if (pago=='en Cta. Cte.') {
        comboEstado.value="Pendiente";        
    } else {
        if (comboEstado.value=="Pendiente") {
            comboEstado.value="Pagado";
        }         
    }
}

function syncPeriodo(form)
{
    var sufijo = document.getElementById(form.name+":sufijo");
    var resumen = document.getElementById(form.name+":resumen");
    var r = resumen.value;
    var posG = r.lastIndexOf('-');
    
    if ( posG > 0 ) {
        r = r.substring(0, posG) + "- " + sufijo.value;        
    } else {
        r = r + " - " + sufijo.value;        
    }
    resumen.value = r;        
}

function syncImporte(form)
{
    //alert("test5:"+form.name);
    var inputC = document.getElementById(form.name+":cantidad");
    var inputP = document.getElementById(form.name+":precio");
    var inputI = document.getElementById(form.name+":importe");
    //alert(inputC.value+"*"+inputP.value);
    var v=parseFloat(inputC.value)*parseFloat(inputP.value);        
    //alert(v);
    inputI.value=v.toFixed(2);           
    
    // Casos con IVA
    var inputTasa = document.getElementById(form.name+":tasaIva");
    var inputNoG = document.getElementById(form.name+":nograv");
    var inputNeto = document.getElementById(form.name+":neto");
    var inputIva = document.getElementById(form.name+":iva");
    if (inputTasa.value=="0.0") {
        inputNoG.value=v.toFixed(2);           
        inputNeto.value="0.00";           
        inputIva.value="0.00";           
    } else {
        var n=v/(1+(parseFloat(inputTasa.value)/100));        
        var i=v-n;        
        inputNoG.value="0.00";           
        inputNeto.value=n.toFixed(2);                   
        syncIva(form);
    }
    
}

function syncIva(form)
{
    //alert("test5b:"+form.name);    
    var inputTasa = document.getElementById(form.name+":tasaIva");
    var inputNeto = document.getElementById(form.name+":neto");
    var inputIva = document.getElementById(form.name+":iva");

    var neto=parseFloat(inputNeto.value);        
    var iva=neto*(parseFloat(inputTasa.value)/100);        
    inputIva.value=iva.toFixed(2);           
    syncTotal(form);
}

function syncTotal(form)
{
    //alert("test5c:"+form.name);    
    var inputNoG = document.getElementById(form.name+":nograv");
    var inputNeto = document.getElementById(form.name+":neto");
    var inputIva = document.getElementById(form.name+":iva");
    var inputTotal = document.getElementById(form.name+":importe");

    var nog=parseFloat(inputNoG.value);        
    var neto=parseFloat(inputNeto.value);        
    var iva=parseFloat(inputIva.value);        
    var tot=nog+neto+iva;        
    inputTotal.value=tot.toFixed(2);         
}
